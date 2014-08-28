package ar.com.german.ExpresionesLibres.client.app.home;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import ar.com.german.ExpresionesLibres.shared.modelo.TieneConceptoConValor;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.cell.client.SelectionCell;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
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

	ListDataProvider<Expresion> dataProvider;

	@UiField
	Button btnAgregarCondicion;

	@UiField(provided = true)
	SuggestBox conceptos;

	@UiField(provided = true)
	SuggestBox operadoresComparacion;

	@UiField
	TextArea valores;

	@UiField
	CellTable<Expresion> expresionesSimples;

	@UiField
	TextBox valor;

	@UiField
	TextArea condicionEscrita;

	@Inject
	HomePageView(Binder uiBinder) {

		// Creo los operadores de concatenacion
		MultiWordSuggestOracle oraculoOperadoresComparacion = new MultiWordSuggestOracle();

		oraculoOperadoresComparacion.add("ES IGUAL A "); // .equals() o ==
		oraculoOperadoresComparacion.add("ES DISTINTO DE ");// <> o !.equals
		oraculoOperadoresComparacion.add("ES MENOR QUE "); // <
		oraculoOperadoresComparacion.add("ES MENOR IGUAL QUE"); // <=
		oraculoOperadoresComparacion.add("ES MAYOR QUE "); // >
		oraculoOperadoresComparacion.add("ES MAYOR IGUAL QUE "); // >=
		oraculoOperadoresComparacion.add("ESTA ENTRE"); // .contains() para
														// numeros y cadenas

		operadoresComparacion = new SuggestBox(oraculoOperadoresComparacion);

		// Creo los operadores de concatenacion
		MultiWordSuggestOracle oraculoConceptos = new MultiWordSuggestOracle();

		oraculoConceptos.add("Prestacion");// Prestacion
		oraculoConceptos.add("Obra Social"); // Obra Social
		oraculoConceptos.add("Especialidad Efector"); // EspecialidadEfector
		oraculoConceptos.add("Convenio"); // Convenio
		oraculoConceptos.add("Profesion del Prestador"); // ProfesionDelPrestador
		oraculoConceptos.add("Matricula del Prestador"); // MatriculaDelPrestador
		oraculoConceptos.add("Plan del Afiliado"); // PlanDelAfiliado
		oraculoConceptos.add("Afiliado Gravado en IVA"); // AfiliadoGravadoIVA

		conceptos = new SuggestBox(oraculoConceptos);

		initWidget(uiBinder.createAndBindUi(this));

		expresionesSimples.addColumn(new TextColumn<Expresion>() {

			@Override
			public String getValue(Expresion object) {
				return object.getCondicion();
			}
		});

		expresionesSimples.addColumn(new Column<Expresion, String>(new SelectionCell(getAcceptableValues())) {

			@Override
			public String getValue(Expresion object) {
				return object.getConcatenador();
			}
		});

		ButtonCell buttonCell = new ButtonCell();
		Column buttonColumn = new Column<Expresion, String>(buttonCell) {
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
				Window.alert("You clicked: " + value);
			}
		});

		// Create a data provider.
		dataProvider = new ListDataProvider<Expresion>();

		// Connect the table to the data provider.
		dataProvider.addDataDisplay(expresionesSimples);

		// Add the data to the data provider, which automatically pushes it to
		// the
		// widget.
		List<Expresion> list = dataProvider.getList();

		list.add(new Expresion("Prestacion es igual a 420101", " ADEMAS "));
		list.add(new Expresion("Obra social igual a 220", " O "));
		list.add(new Expresion("Afiliado gravado en IVA", ""));

	}

	private List<String> getAcceptableValues() {
		return Arrays.asList("", " ADEMAS ", " O ");
	}

	@Override
	public void asignarFoco() {
		conceptos.setFocus(true);
	}

	private void agregarCondicion() {

		String condicion = "";
		String concatenador = "";

		// Agrego la expresion a la lista
		Expresion expresion = new Expresion(condicion, concatenador);

		dataProvider.getList().add(expresion);

		/**
		 * Inicializo para agregar una nueva condicion Concepto/ comparador /
		 * Constantes / Regla Escrita
		 */
		// THISFORM.edtCondicion.Value=""
		// thisform.cmbconcepto.DisplayValue=""
		// .concepto=.F.
		// thisform.cmboperadores.DisplayValue=""
		// .operador=.F.
		// thisform.edtlistaConstantes.Value=""
		// .constante=.F.
		// .concatenador=.F.
		//

		/**
		 * Recorro la coleccion de ( expresion / concatenador) y vuelvo a
		 * escribir la regla +
		 * " Si concepto comparador constante/s concatenador "
		 */

		// * Tengo que agregar cada regla
		// * oRegla()
		// *'Concepto = "420101" AND [2] = 220'
		// * Expresion concatenador: [1] = "420101" AND
		// *aReglas(1)=CREATEOBJECT("Regla",'[1] = "420101" AND [2] = 220',159)
		// ENDWITH

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

}