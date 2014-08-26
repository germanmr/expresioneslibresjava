package ar.com.german.ExpresionesLibres.client.app.home;

import javax.inject.Inject;

import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.MultiWordSuggestOracle;
import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

public class HomePageView extends ViewImpl implements HomePagePresenter.MyView {

	interface Binder extends UiBinder<Widget, HomePageView> {
	}

	@UiField
	SuggestBox conceptos;

	@Inject
	HomePageView(Binder uiBinder) {

		MultiWordSuggestOracle oracle = new MultiWordSuggestOracle();

		oracle.add("aaaaaaaa");
		oracle.add("aaaa");
		oracle.add("aaa");
		oracle.add("a");
		oracle.add("Prestacion");
		oracle.add("Obra Social");
		oracle.add("Especialidad Efector");
		oracle.add("Especialidad Efector");
		oracle.add("Convenio");
		oracle.add("Profesion del Prestador");
		oracle.add("Matricula del Prestador");
		oracle.add("Plan del Afiliado");
		oracle.add("Afiliado Gravado en IVA");

		conceptos = new SuggestBox(oracle);
		// MultiWordSuggestOracle multiWordSuggestOracle =
		// (MultiWordSuggestOracle) conceptos.getSuggestOracle();

		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void agregarEventos() {

	}

}