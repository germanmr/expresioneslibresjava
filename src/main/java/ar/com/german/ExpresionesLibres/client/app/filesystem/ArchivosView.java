package ar.com.german.ExpresionesLibres.client.app.filesystem;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.vectomatic.file.Blob;
import org.vectomatic.file.ErrorCode;
import org.vectomatic.file.File;
import org.vectomatic.file.FileError;
import org.vectomatic.file.FileList;
import org.vectomatic.file.FileReader;
import org.vectomatic.file.FileUploadExt;
import org.vectomatic.file.events.LoadEndEvent;
import org.vectomatic.file.events.LoadEndHandler;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

public class ArchivosView extends ViewImpl implements ArchivosPresenter.MyView {

	interface Binder extends UiBinder<Widget, ArchivosView> {
	}

	@UiField
	FileUploadExt fileUpload;

	@UiField
	TextArea resultado;

	@UiField
	Button enviar;

	FileReader reader;
	List<File> readQueue;
	protected boolean useTypedArrays = true;

	private String datos;

	@Inject
	ArchivosView(Binder uiBinder) {

		initWidget(uiBinder.createAndBindUi(this));

		reader = new FileReader();
		reader.addLoadEndHandler(new LoadEndHandler() {
			/**
			 * This handler is invoked when FileReader.readAsText(),
			 * FileReader.readAsBinaryString() or FileReader.readAsArrayBuffer()
			 * successfully completes
			 */
			@Override
			public void onLoadEnd(LoadEndEvent event) {
				if (reader.getError() == null) {
					if (readQueue.size() > 0) {
						File file = readQueue.get(0);
						try {
							resultado.setText("");
							String result = reader.getStringResult();
							System.out.println(result);
							resultado.setText(result);
							datos = result;

							GWT.log("Archivo=" + result);

						} finally {
							readQueue.remove(0);
							readNextFile();
						}
					}
				}
			}
		});
		readQueue = new ArrayList<File>();
	}

	private void createText(final File file) {

	}

	@UiHandler("fileUpload")
	public void uploadFile1(ChangeEvent event) {

		processFiles(fileUpload.getFiles());
	}

	private void processFiles(FileList files) {
		GWT.log("length=" + files.getLength());
		System.out.println(files.getLength());
		for (File file : files) {
			readQueue.add(file);
		}
		// Start processing the queue
		readNextFile();
	}

	// useTypedArrays =
	// !"false".equals(Window.Location.getParameter("typedArrays"));

	// Create a file reader a and queue of files to read.
	// UI event handler will populate this queue by calling queueFiles()

	/**
	 * Processes the next file in the queue. Depending on the MIME type of the
	 * file, a different way of loading the image is used to demonstrate all
	 * parts of the API
	 */
	private void readNextFile() {
		if (readQueue.size() > 0) {
			File file = readQueue.get(0);
			String type = file.getType();
			try {
				// if ("image/svg+xml".equals(type)) {
				// reader.readAsText(file);
				// } else if (type.startsWith("image/png")) {
				// // Do not use the FileReader for PNG.
				// // Take advantage of the fact the browser can
				// // provide a directly usable blob:// URL
				// // imagePanel.add(createThumbnail(file));
				// readQueue.remove(0);
				// readNextFile();
				// } else if (type.startsWith("image/")) {
				// // For other image types (GIF, JPEG), load them
				// // as typed arrays
				// if (useTypedArrays) {
				// reader.readAsArrayBuffer(file);
				// } else {
				// reader.readAsBinaryString(file);
				// }
				// } else if (type.startsWith("text/")) {
				// // If the file is larger than 1kb, read only the first 1000
				// // characters
				// // to demonstrate file slicing
				// Blob blob = file;
				// if (file.getSize() > 0) {
				// blob = file.slice(0, 900000000, "text/plain; charset=utf-8");
				// }
				// reader.readAsText(blob);
				// }

				Blob blob = file;
				if (file.getSize() > 0) {
					blob = file.slice(0, 900000000, "text/plain; charset=utf-8");
				}

				reader.readAsText(blob);

			} catch (Throwable t) {
				// Necessary for FF (see bug
				// https://bugzilla.mozilla.org/show_bug.cgi?id=701154)
				// Standard-complying browsers will not go in this branch
				handleError(file);
				readQueue.remove(0);
				readNextFile();
			}
		}
	}

	private void handleError(File file) {
		FileError error = reader.getError();
		String errorDesc = "";
		if (error != null) {
			ErrorCode errorCode = error.getCode();
			if (errorCode != null) {
				errorDesc = ": " + errorCode.name();
			}
		}
		Window.alert("File loading error for file: " + file.getName() + "\n" + errorDesc);
	}

	@Override
	public String getDatos() {
		return datos;

	}

	@Override
	public void addOnEnviarClickHandler(ClickHandler clickHandler) {
		enviar.addClickHandler(clickHandler);

	}
}
