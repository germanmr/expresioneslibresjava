package ar.com.german.ExpresionesLibres.client.app.generadordereglas;

import java.util.Arrays;
import java.util.Map;

import javax.inject.Inject;

import ar.com.german.ExpresionesLibres.shared.modelo.Comparador;
import ar.com.german.ExpresionesLibres.shared.modelo.Concepto;
import ar.com.german.ExpresionesLibres.shared.modelo.Expresion;
import ar.com.german.ExpresionesLibres.shared.modelo.TieneConceptoConValor;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.cell.client.SelectionCell;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.MultiWordSuggestOracle;
import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ListDataProvider;
import com.gwtplatform.mvp.client.ViewImpl;

public class GeneradorDeReglasView extends ViewImpl implements GeneradorDeReglasPresenter.MyView {

	interface Binder extends UiBinder<Widget, GeneradorDeReglasView> {
	}

	@UiField
	Button btnAgregarCondicion;

	@UiField
	SuggestBox conceptos;

	@UiField
	SuggestBox comparadores;

	@UiField
	TextArea valores;

	@UiField
	CellTable<Expresion> expresionesSimples;

	@UiField
	TextBox valor;

	@UiField
	TextArea regla;

	private String conceptoElegido;

	private String comparadorElegido;

	private ListDataProvider<Expresion> dataProvider = new ListDataProvider<Expresion>();

	@Inject
	GeneradorDeReglasView(Binder uiBinder) {

		initWidget(uiBinder.createAndBindUi(this));

		crearCellTable();

		conceptos.addValueChangeHandler(new ValueChangeHandler<String>() {

			@Override
			public void onValueChange(ValueChangeEvent<String> event) {
				conceptoElegido = event.getValue();
			}
		});

		comparadores.addValueChangeHandler(new ValueChangeHandler<String>() {

			@Override
			public void onValueChange(ValueChangeEvent<String> event) {
				comparadorElegido = event.getValue();
			}
		});

	}

	@Override
	public String getConceptoElegido() {
		return conceptoElegido;

	}

	@Override
	public void agregarConceptos(Map<String, Concepto> conceptosMap) {
		MultiWordSuggestOracle oraculoConceptos = (MultiWordSuggestOracle) conceptos.getSuggestOracle();

		for (Map.Entry<String, Concepto> entry : conceptosMap.entrySet()) {
			oraculoConceptos.add(entry.getKey());
		}

	}

	@Override
	public void aregarComparadores(Map<String, Comparador> comparadoresMap) {

		MultiWordSuggestOracle oraculoConceptos = (MultiWordSuggestOracle) comparadores.getSuggestOracle();

		for (Map.Entry<String, Comparador> entry : comparadoresMap.entrySet()) {
			oraculoConceptos.add(entry.getKey());
		}

	}

	/**
	 * Creamos un Cell table con 4 columnas, una {@link Expresion} simple, un
	 * concatenador,
	 */
	private void crearCellTable() {

		// Esta es la expresion
		expresionesSimples.addColumn(new TextColumn<Expresion>() {

			@Override
			public String getValue(Expresion object) {
				return object.obtenerCondicionEscrita();
			}
		});

		// Esto es un concatenador, ADEMAS, O
		expresionesSimples.addColumn(new Column<Expresion, String>(new SelectionCell(Arrays.asList("", " ADEMAS ", " O "))) {

			@Override
			public String getValue(Expresion object) {
				return object.getConcatenador().getNombre();
			}
		});

		Column<Expresion, String> buttonColumn = new Column<Expresion, String>(new ButtonCell()) {
			@Override
			public String getValue(Expresion object) {
				// The value to display in the button.
				// return object;
				return "Eliminar condicion";
			}
		};
		expresionesSimples.addColumn(buttonColumn, "Action");

		// You can then set a FieldUpdater on the Column to be notified of
		// clicks.
		buttonColumn.setFieldUpdater(new FieldUpdater<Expresion, String>() {
			public void update(int index, Expresion object, String value) {
				// Value is the button value. Object is the row object.
				// TODO Sacar de la coleccion solo si es la utima fila

			}
		});

		dataProvider.addDataDisplay(expresionesSimples);
	}

	@Override
	public String getComparadorElegido() {
		return comparadorElegido;
	}

	@Override
	public String getValores() {
		return valores.getText();
	}

	@Override
	public String getValor() {
		return valor.getText();
	}

	@Override
	public void asignarFoco() {
		conceptos.setFocus(true);
	}

	@Override
	public void onBtnAgregarcondicionAddclickHandler(ClickHandler clickHandler) {
		btnAgregarCondicion.addClickHandler(clickHandler);

	}

	@Override
	public void agregarExpresion(Expresion expresion) {
		dataProvider.getList().add(expresion);

	}

	@Override
	public void iniciarExpresion() {
		conceptos.setValue(null);
		conceptoElegido = null;
		comparadores.setValue(null);
		comparadorElegido = null;
		valores.setText("");
	}
}
