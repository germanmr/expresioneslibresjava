package ar.com.german.ExpresionesLibres.client.app.probarreglas;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import ar.com.german.ExpresionesLibres.client.app.ApplicationPresenter;
import ar.com.german.ExpresionesLibres.client.place.NameTokens;
import ar.com.german.ExpresionesLibres.shared.modelo.Concepto;
import ar.com.german.ExpresionesLibres.shared.modelo.ConceptoIngresado;
import ar.com.german.ExpresionesLibres.shared.modelo.TieneConceptoConValor;
import ar.com.german.ExpresionesLibres.shared.modelo.TiposConceptos;
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

				// Los conceptos ingresados y sus valores ingresados son:
				List<TieneConceptoConValor> conceptosIngresados = new ArrayList<TieneConceptoConValor>();
				conceptosIngresados.add(new ConceptoIngresado<String>(new Concepto("prestacion", "Prestacion", TiposConceptos.CADENA),
						"420101"));
				conceptosIngresados.add(new ConceptoIngresado<String>(new Concepto("obraSocial", "Obra Social", TiposConceptos.CADENA),
						"220"));

				dispatchAsync.execute(new ObtenerDesicionAction(conceptosIngresados), new AsyncCallback<ObtenerDesicionResult>() {

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
}