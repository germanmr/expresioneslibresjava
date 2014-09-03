package ar.com.german.ExpresionesLibres.client.app.home;

import java.util.Arrays;
import java.util.Map;

import javax.inject.Inject;

import ar.com.german.ExpresionesLibres.shared.modelo.Concepto;
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

public class HomePageView extends ViewImpl implements HomePagePresenter.MyView {

	interface Binder extends UiBinder<Widget, HomePageView> {
	}

	// ListDataProvider<Expresion> dataProvider;

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
	TextArea condicionEscrita;

	private String conceptoElegido;

	private String comparadorElegido;

	private ListDataProvider<Expresion> dataProvider = new ListDataProvider<Expresion>();

	@Inject
	HomePageView(Binder uiBinder) {

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
				// TODO Sacar de la coleccion

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

	private void armarFuncion(TieneConceptoConValor element) {

		/**
		 * Para verificar que se cumple la expresion
		 */

		// DIMENSION aMapaValores(4)
		// aMapaValores(1)=CREATEOBJECT("MapElement","Concepto","Comparador")
		// aMapaValores(2)=CREATEOBJECT("MapElement","Comparador","Constante")
		// aMapaValores(3)=CREATEOBJECT("MapElement","Constante","Concatenador")
		// aMapaValores(4)=CREATEOBJECT("MapElement","Concatenador","Concepto")
		/**
		 * Tiene que cumplir con la siguiente regla: Expresion [Concatenador
		 * Expresion][Concatenador Expresion]... Donde expresion: Concepto
		 * Comparador Constante Concepto Comparador Constante Concatenador
		 * Concepto ...
		 */

		// DO CASE
		// CASE pElemento.tipo="Concepto"
		// .expresionSimple.Concepto=pElemento
		//
		// CASE pElemento.tipo="Comparador"
		// .expresionSimple.operador=pElemento
		//
		// CASE pElemento.tipo="Constante"
		// .expresionSimple.operador=pElemento
		// * Tengo que formatear segun el tipo de dato elegido
		//
		// CASE pElemento.tipo="Concatenador"
		//
		// OTHERWISE
		// * y aca que mierda hago???
		//
		// ENDCASE

		// IF RECCOUNT("cExpresion")>0 THEN
		//
		//
		// SELECT cExpresion
		// GO TOP
		// lUltimoTipo=ALLTRIM(cExpresion.tipo)
		// FOR EACH mapElement IN aMapaValores
		// IF ALLTRIM(lUltimoTipo)=mapElement.clave THEN
		// IF pElemento.tipo<>mapElement.valor THEN
		// RETURN .F.
		// ENDIF
		//
		// ENDIF
		// ENDFOR
		// ENDIF

		// INSERT INTO cExpresion(tipo,codigo,valor)
		// VALUES(pElemento.tipo,pElemento.codigo,pElemento.valor)

		// Expresion expresion =new Expresion(new condi, concatenador);

		// *.dibujarExpression()???
		//
		// SELECT cExpresion
		// .EdtExpression.VALUE=""

		// SCAN
		// .EdtExpression.VALUE=.EdtExpression.VALUE+" " +
		// ALLTRIM(cExpresion.valor)
		// ENDSCAN
		//
		//
		//
		// ENDWITH

	}

	private void dibujarcondicion() {
		// lConstante=""

		// IF !ISBLANK(ALLTRIM(thisform.edtlistaConstantes.Value)) THEN
		// lConstante="("+ALLTRIM(thisform.edtlistaConstantes.Value)+")"
		// ENDIF

		// THISFORM.edtCondicion.Value= "Si " +
		// ALLTRIM(THISFORM.CMBconcepto.DisplayValue) + " " +
		// ALLTRIM(thisform.cmbOperadores.DisplayValue) + " " + lConstante

	}

	@Override
	public void agregarExpresion(Expresion expresion) {
		// dataProvider.getList().clear();
		dataProvider.getList().add(expresion);

	}

}
