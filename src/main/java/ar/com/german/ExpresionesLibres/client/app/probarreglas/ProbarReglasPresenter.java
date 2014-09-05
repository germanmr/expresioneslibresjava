package ar.com.german.ExpresionesLibres.client.app.probarreglas;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import ar.com.german.ExpresionesLibres.client.app.ApplicationPresenter;
import ar.com.german.ExpresionesLibres.client.place.NameTokens;
import ar.com.german.ExpresionesLibres.server.beanshell.Resolutor;
import ar.com.german.ExpresionesLibres.shared.modelo.Comparador;
import ar.com.german.ExpresionesLibres.shared.modelo.Concepto;
import ar.com.german.ExpresionesLibres.shared.modelo.dispatch.ObtenerDesicionAction;
import ar.com.german.ExpresionesLibres.shared.modelo.dispatch.ObtenerDesicionResult;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.dispatch.rpc.shared.DispatchAsync;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;

public class ProbarReglasPresenter extends Presenter<ProbarReglasPresenter.MyView, ProbarReglasPresenter.MyProxy> {

	public interface MyView extends View {

		void onButtonDecidirAddClickHandler(ClickHandler clickHandler);

	}

	private DispatchAsync dispatchAsync;

	@ProxyStandard
	@NameToken(NameTokens.probador)
	public interface MyProxy extends ProxyPlace<ProbarReglasPresenter> {
	}

	@Inject
	ProbarReglasPresenter(EventBus eventBus, MyView view, MyProxy proxy, final DispatchAsync dispatchAsync) {
		super(eventBus, view, proxy, ApplicationPresenter.SLOT_SetMainContent);
		this.dispatchAsync = dispatchAsync;
	}

	@Override
	protected void onBind() {

		getView().onButtonDecidirAddClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// resolutor.obtenerResultado(conceptos, reglas,
				// conceptosIngresados);
				dispatchAsync.execute(new ObtenerDesicionAction(), new AsyncCallback<ObtenerDesicionResult>() {

					@Override
					public void onFailure(Throwable caught) {
						Window.alert(caught.getMessage());

					}

					@Override
					public void onSuccess(ObtenerDesicionResult result) {
						Window.alert("Exito este es el resultado: " + result.getResultado().toString());

					}
				});
			}
		});

		super.onBind();
	}

	@Override
	protected void onReset() {

		super.onReset();
	}
}