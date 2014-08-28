package ar.com.german.ExpresionesLibres.client.app.home;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import ar.com.german.ExpresionesLibres.shared.modelo.Regla;

import com.google.gwt.cell.client.SelectionCell;
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

	@Inject
	HomePageView(Binder uiBinder) {

		// Creo los operadores de concatenacion
		MultiWordSuggestOracle oraculoOperadoresComprarcion = new MultiWordSuggestOracle();

		oraculoOperadoresComprarcion.add("ES IGUAL A ");
		oraculoOperadoresComprarcion.add("ES DISTINTO DE ");
		oraculoOperadoresComprarcion.add("ES MENOR QUE ");
		oraculoOperadoresComprarcion.add("ES MENOR IGUAL QUE");
		oraculoOperadoresComprarcion.add("ES MAYOR QUE ");
		oraculoOperadoresComprarcion.add("ES MAYOR IGUAL QUE ");
		oraculoOperadoresComprarcion.add("ESTA ENTRE");

		operadoresComparacion = new SuggestBox(oraculoOperadoresComprarcion);

		// Creo los operadores de concatenacion
		MultiWordSuggestOracle oraculoConceptos = new MultiWordSuggestOracle();

		oraculoConceptos.add("Prestacion");
		oraculoConceptos.add("Obra Social");
		oraculoConceptos.add("Especialidad Efector");
		oraculoConceptos.add("Especialidad Efector");
		oraculoConceptos.add("Convenio");
		oraculoConceptos.add("Profesion del Prestador");
		oraculoConceptos.add("Matricula del Prestador");
		oraculoConceptos.add("Plan del Afiliado");
		oraculoConceptos.add("Afiliado Gravado en IVA");

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

		// Create a data provider.
		ListDataProvider<Expresion> dataProvider = new ListDataProvider<Expresion>();

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

}