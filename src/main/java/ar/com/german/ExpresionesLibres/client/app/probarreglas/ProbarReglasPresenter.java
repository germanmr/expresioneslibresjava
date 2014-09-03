package ar.com.german.ExpresionesLibres.client.app.probarreglas;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import ar.com.german.ExpresionesLibres.client.app.ApplicationPresenter;
import ar.com.german.ExpresionesLibres.client.place.NameTokens;
import ar.com.german.ExpresionesLibres.shared.modelo.Comparador;
import ar.com.german.ExpresionesLibres.shared.modelo.Concepto;

import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;

public class ProbarReglasPresenter extends Presenter<ProbarReglasPresenter.MyView, ProbarReglasPresenter.MyProxy> {

	public interface MyView extends View {

	}

	@ProxyStandard
	@NameToken(NameTokens.probador)
	public interface MyProxy extends ProxyPlace<ProbarReglasPresenter> {
	}

	@Inject
	ProbarReglasPresenter(EventBus eventBus, MyView view, MyProxy proxy) {
		super(eventBus, view, proxy, ApplicationPresenter.SLOT_SetMainContent);
	}

	@Override
	protected void onBind() {

		super.onBind();
	}

	@Override
	protected void onReset() {

		super.onReset();
	}
}