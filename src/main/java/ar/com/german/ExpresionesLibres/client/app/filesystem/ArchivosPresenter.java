package ar.com.german.ExpresionesLibres.client.app.filesystem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.vectomatic.file.Blob;
import org.vectomatic.file.ErrorCode;
import org.vectomatic.file.File;
import org.vectomatic.file.FileError;
import org.vectomatic.file.FileReader;
import org.vectomatic.file.events.LoadEndEvent;
import org.vectomatic.file.events.LoadEndHandler;

import ar.com.german.ExpresionesLibres.client.app.ApplicationPresenter;
import ar.com.german.ExpresionesLibres.client.place.NameTokens;
import ar.com.german.ExpresionesLibres.shared.modelo.Comparador;
import ar.com.german.ExpresionesLibres.shared.modelo.Concatenador;
import ar.com.german.ExpresionesLibres.shared.modelo.ConcatenadoresJava;
import ar.com.german.ExpresionesLibres.shared.modelo.Concepto;
import ar.com.german.ExpresionesLibres.shared.modelo.Expresion;
import ar.com.german.ExpresionesLibres.shared.modelo.OperadoresSimbolicos;
import ar.com.german.ExpresionesLibres.shared.modelo.TieneValorCadena;
import ar.com.german.ExpresionesLibres.shared.modelo.TiposConceptos;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;

public class ArchivosPresenter extends Presenter<ArchivosPresenter.MyView, ArchivosPresenter.MyProxy> {

	public interface MyView extends View {

	}

	@ProxyStandard
	@NameToken(NameTokens.filesystem)
	public interface MyProxy extends ProxyPlace<ArchivosPresenter> {
	}

	@Inject
	ArchivosPresenter(EventBus eventBus, MyView view, MyProxy proxy) {
		super(eventBus, view, proxy, ApplicationPresenter.SLOT_SetMainContent);
	}

	@Override
	protected void onBind() {

		// getView().addUploadFileHandler(new change)

		super.onBind();
	}

}