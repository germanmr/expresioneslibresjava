package ar.com.german.ExpresionesLibres.client.app.generadordereglas;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import ar.com.german.ExpresionesLibres.client.app.ApplicationPresenter;
import ar.com.german.ExpresionesLibres.client.place.NameTokens;
import ar.com.german.ExpresionesLibres.shared.modelo.Comparador;
import ar.com.german.ExpresionesLibres.shared.modelo.Concatenador;
import ar.com.german.ExpresionesLibres.shared.modelo.ConcatenadoresJava;
import ar.com.german.ExpresionesLibres.shared.modelo.Concepto;
import ar.com.german.ExpresionesLibres.shared.modelo.Expresion;
import ar.com.german.ExpresionesLibres.shared.modelo.OperadoresSimbolicos;
import ar.com.german.ExpresionesLibres.shared.modelo.TieneValorCadena;
import ar.com.german.ExpresionesLibres.shared.modelo.TiposConceptos;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;

public class GeneradorDeReglasPresenter extends Presenter<GeneradorDeReglasPresenter.MyView, GeneradorDeReglasPresenter.MyProxy> {

	public interface MyView extends View {

		void asignarFoco();

		void agregarConceptos(Map<String, Concepto> conceptosMap);

		void aregarComparadores(Map<String, Comparador> comparadoresMap);

		void onBtnAgregarcondicionAddclickHandler(ClickHandler clickHandler);

		String getConceptoElegido();

		String getComparadorElegido();

		String getValor();

		String getValores();

		void agregarExpresion(Expresion expresion);

		void iniciarExpresion();

	}

	private Map<String, Concepto> conceptosMap = new HashMap<String, Concepto>();
	private Map<String, Comparador> comparadoresMap = new HashMap<String, Comparador>();

	@ProxyStandard
	@NameToken(NameTokens.generadorDeReglas)
	public interface MyProxy extends ProxyPlace<GeneradorDeReglasPresenter> {
	}

	@Inject
	GeneradorDeReglasPresenter(EventBus eventBus, MyView view, MyProxy proxy) {
		super(eventBus, view, proxy, ApplicationPresenter.SLOT_SetMainContent);
	}

	@Override
	protected void onBind() {

		conceptosMap.put("Prestacion", new Concepto("prestacion", "Prestacion", TiposConceptos.CADENA));
		conceptosMap.put("Obra Social", new Concepto("obraSocial", "Obra Social", TiposConceptos.CADENA));
		conceptosMap
				.put("Especialidad del Efector", new Concepto("especialidadEfector", "Especialidad del Efector", TiposConceptos.NUMERO));
		conceptosMap.put("Convenio", new Concepto("convenio", "Convenio", TiposConceptos.NUMERO));
		conceptosMap.put("Profesion del Prestador", new Concepto("profesionPrestador", "Profesion del Prestador", TiposConceptos.NUMERO));
		conceptosMap.put("Matricula del Prestador", new Concepto("matriculaPrestador", "Matricula del Prestador", TiposConceptos.NUMERO));
		conceptosMap.put("Plan del Afiliado", new Concepto("planAfiliado", "Plan del Afiliado", TiposConceptos.NUMERO));
		conceptosMap.put("Afiliado Gravado en IVA", new Concepto("afiliadoGravadoIVA", "Afiliado Gravado en IVA", TiposConceptos.BOOLEANO));

		getView().agregarConceptos(conceptosMap);

		// Creo los operadores de comparacion
		comparadoresMap.put("ES IGUAL A ", new Comparador("ES IGUAL A ", OperadoresSimbolicos.IGUAL));
		comparadoresMap.put(" ES DISINTO DE ", new Comparador(" ES DISINTO DE ", OperadoresSimbolicos.DISTINTO));
		comparadoresMap.put(" ES MENOR QUE ", new Comparador(" ES MENOR QUE ", OperadoresSimbolicos.MENOR));
		comparadoresMap.put(" ES MENOR IGUAL QUE ", new Comparador("ES MENOR IGUAL QUE", OperadoresSimbolicos.MENORIGUAL));
		comparadoresMap.put(" ES MAYOR QUE ", new Comparador(" ES MAYOR QUE ", OperadoresSimbolicos.MAYOR));
		comparadoresMap.put(" ES MAYOR IGUAL QUE ", new Comparador(" ES MAYOR IGUAL QUE ", OperadoresSimbolicos.MAYORIGUAL));
		comparadoresMap.put(" ESTA ENTRE ", new Comparador(" ESTA ENTRE ", OperadoresSimbolicos.ESTANEN));

		getView().aregarComparadores(comparadoresMap);

		getView().onBtnAgregarcondicionAddclickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				agregarCondicion();
			}
		});

		super.onBind();
	}

	/**
	 * En este paso tengo que generar una {@link String}, que va a ser la
	 * condicion( Concepto + Comparador + valor ) <br>
	 * Generar una {@link Expresion}(condicion, operador por defecto) <br>
	 * Agregarla a la coleccion de Expresiones <br>
	 * Indicar inicializar para ingresar otra condicion <br>
	 * Escribir la regla textual con las condicion mas concatenadores
	 */
	private void agregarCondicion() {

		// Agrego la expresion a la lista
		Concepto concepto = conceptosMap.get(getView().getConceptoElegido());
		Comparador comparador = comparadoresMap.get(getView().getComparadorElegido());
		String valor = getView().getValores();

		Expresion expresion = new Expresion(concepto, comparador, new TieneValorCadena(valor), new Concatenador(" Ademas ",
				ConcatenadoresJava.ADEMAS));

		getView().agregarExpresion(expresion);

		/**
		 * Inicializo para agregar una nueva condicion Concepto/ Comparador /
		 * Constantes / Regla Escrita
		 */
		getView().iniciarExpresion();

		/**
		 * 
		 * Recorro la coleccion de ( expresion / concatenador) y vuelvo a
		 * escribir la regla +
		 * " Si concepto comparador constante/s concatenador "
		 */
		// TODO Escribir la regla en base a list<Expresion> del celltable

	}

	@Override
	protected void onReset() {

		getView().asignarFoco();

		super.onReset();
	}
}