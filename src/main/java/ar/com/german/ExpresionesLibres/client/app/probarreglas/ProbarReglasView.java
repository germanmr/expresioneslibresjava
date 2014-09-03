package ar.com.german.ExpresionesLibres.client.app.probarreglas;

import javax.inject.Inject;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

public class ProbarReglasView extends ViewImpl implements ProbarReglasPresenter.MyView {

	interface Binder extends UiBinder<Widget, ProbarReglasView> {
	}

	@Inject
	ProbarReglasView(Binder uiBinder) {

		initWidget(uiBinder.createAndBindUi(this));

	}

}
