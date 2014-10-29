package ar.com.german.ExpresionesLibres.client.app.probarreglas;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import ar.com.german.ExpresionesLibres.shared.modelo.Concepto;
import ar.com.german.ExpresionesLibres.shared.modelo.TiposConceptos;

import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.cell.client.TextInputCell;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ListDataProvider;
import com.gwtplatform.mvp.client.ViewImpl;

public class ProbarReglasView extends ViewImpl implements ProbarReglasPresenter.MyView {

	interface Binder extends UiBinder<Widget, ProbarReglasView> {
	}

	// @UiField
	// Button decidir;
	// @UiField
	// CellTable<Concepto> lista;
	//
	// ListDataProvider<Concepto> dataProvider;

	@Inject
	ProbarReglasView(Binder uiBinder) {

		initWidget(uiBinder.createAndBindUi(this));
		// Column<Concepto, String> editable = new Column<Concepto, String>(new
		// TextInputCell()) {
		//
		// @Override
		// public String getValue(Concepto object) {
		// // return object..get == null ? "" : object.getA();
		// return object.getIdentificacion() == null ? "" :
		// object.getIdentificacion();
		// }
		// };
		//
		// editable.setFieldUpdater(new FieldUpdater<Concepto, String>() {
		// @Override
		// public void update(int index, Concepto object, String value) {
		// // Called when the user changes the value.
		// object.setDescripcion(value);
		// System.out.println("Valor: " + value);
		// // ContactDatabase.get().refreshDisplays();
		// }
		// });
		//
		// lista.addColumn(editable);
		// List<Concepto> conceptos = new ArrayList<Concepto>();
		// conceptos.add(new Concepto("prestacion", "Prestacion",
		// TiposConceptos.CADENA));
		// conceptos.add(new Concepto("obraSocial", "Obra Social",
		// TiposConceptos.CADENA));
		// // put some data
		// dataProvider = new ListDataProvider<Concepto>(conceptos);
		// dataProvider.addDataDisplay(lista);

	}

	@Override
	public void onButtonDecidirAddClickHandler(ClickHandler handler) {
		// decidir.addClickHandler(handler);
	}

}
