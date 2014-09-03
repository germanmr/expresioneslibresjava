package ar.com.german.ExpresionesLibres.client.app.probarreglas;

import javax.inject.Inject;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

public class ProbarReglasView extends ViewImpl implements ProbarReglasPresenter.MyView {

	interface Binder extends UiBinder<Widget, ProbarReglasView> {
	}

	@UiField
	Button decidir;

	@Inject
	ProbarReglasView(Binder uiBinder) {

		initWidget(uiBinder.createAndBindUi(this));

	}

	@Override
	public void onButtonDecidirAddClickHandler(ClickHandler handler) {
		decidir.addClickHandler(handler);

	}

}
