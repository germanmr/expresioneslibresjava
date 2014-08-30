package ar.com.german.ExpresionesLibres.client.app.home;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import ar.com.german.ExpresionesLibres.client.app.ApplicationPresenter;
import ar.com.german.ExpresionesLibres.client.place.NameTokens;
import ar.com.german.ExpresionesLibres.shared.modelo.Concepto;
import ar.com.german.ExpresionesLibres.shared.modelo.TiposConceptos;
import bsh.EvalError;
import bsh.Interpreter;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.MultiWordSuggestOracle;
import com.google.gwt.user.client.ui.SuggestBox;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;

public class HomePagePresenter extends Presenter<HomePagePresenter.MyView, HomePagePresenter.MyProxy> {

	public interface MyView extends View {

		void asignarFoco();

		void agregarConceptos(Map<String, Concepto> conceptosMap);

		void aregarComparadores(Map<String, Comparador> comparadoresMap);

		void onBtnAgregarcondicionAddclickHandler(ClickHandler clickHandler);

		String getConceptoElegido();

		String getComparadorElegido();

		String getValor();

	}

	private Map<String, Concepto> conceptosMap = new HashMap<String, Concepto>();
	private Map<String, Comparador> comparadoresMap = new HashMap<String, Comparador>();

	@ProxyStandard
	@NameToken(NameTokens.home)
	public interface MyProxy extends ProxyPlace<HomePagePresenter> {
	}

	@Inject
	HomePagePresenter(EventBus eventBus, MyView view, MyProxy proxy) {
		super(eventBus, view, proxy, ApplicationPresenter.SLOT_SetMainContent);
	}

	@Override
	protected void onBind() {

		conceptosMap.put("Prestacion", new Concepto("Prestacion", "Prestacion", TiposConceptos.CADENA));
		conceptosMap.put("Obra Social", new Concepto("ObraSocial", "Obra Social", TiposConceptos.CADENA));
		conceptosMap
				.put("Especialidad del Efector", new Concepto("EspecialidadEfector", "Especialidad del Efector", TiposConceptos.NUMERO));
		conceptosMap.put("Convenio", new Concepto("Convenio", "Convenio", TiposConceptos.NUMERO));
		conceptosMap.put("Profesion del Prestador", new Concepto("ProfesionPrestador", "Profesion del Prestador", TiposConceptos.NUMERO));
		conceptosMap.put("Matricula del Prestador", new Concepto("MatriculaPrestador", "Matricula del Prestador", TiposConceptos.NUMERO));
		conceptosMap.put("Plan del Afiliado", new Concepto("PlanAfiliado", "Plan del Afiliado", TiposConceptos.NUMERO));
		conceptosMap.put("Afiliado Gravado en IVA", new Concepto("AfiliadoGravadoIVA", "Afiliado Gravado en IVA", TiposConceptos.BOOLEANO));

		getView().agregarConceptos(conceptosMap);

		// Creo los operadores de comparacion
		comparadoresMap.put("ES IGUAL A ", new Comparador("ES IGUAL A ", OperadoresSimbolicos.IGUAL));
		comparadoresMap.put(" ES DISINTO DE ", new Comparador(" ES DISINTO DE ", OperadoresSimbolicos.DISTINTO));
		comparadoresMap.put(" ES MENOR QUE ", new Comparador(" ES MENOR QUE ", OperadoresSimbolicos.MENOR));
		comparadoresMap.put(" ES MENOR IGUAL QUE ", new Comparador("ES MENOR IGUAL QUE", OperadoresSimbolicos.MENORIGUAL));
		comparadoresMap.put(" ES MAYOR QUE ", new Comparador(" ES MAYOR QUE ", OperadoresSimbolicos.MAYOR));
		comparadoresMap.put(" ES MAYOR IGUAL QUE ", new Comparador(" ES MAYOR IGUAL QUE ", OperadoresSimbolicos.MAYORIGUAL));
		comparadoresMap.put(" ESTA ENTRE ", new Comparador(" ESTA ENTRE ", OperadoresSimbolicos.ENTRE));

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

		String condicion = "";
		String concatenador = "";

		// Agrego la expresion a la lista
		Concepto concepto = conceptosMap.get(getView().getConceptoElegido());
		Comparador comparador = comparadoresMap.get(getView().getComparadorElegido());
		String valor = getView().getValor();

		System.out.println(concepto);
		System.out.println(comparador);
		System.out.println(valor);

		condicion = obtenercondicion(concepto, comparador, valor);

		System.out.println("Condicion: " + condicion);

		Expresion expresion = new Expresion(condicion, new Concatenador(" Ademas ", ConcatenadoresJava.ADEMAS));
		//
		// dataProvider.getList().add(expresion);
		//
		// // Create a data provider.
		// dataProvider = new ListDataProvider<Expresion>();
		//
		// // Connect the table to the data provider.
		// dataProvider.addDataDisplay(expresionesSimples);
		//
		// // Add the data to the data provider, which automatically pushes it
		// to
		// // the
		// // widget.
		// List<Expresion> list = dataProvider.getList();
		//
		// list.add(new Expresion("Prestacion es igual a 420101", " ADEMAS "));
		// list.add(new Expresion("Obra social igual a 220", " O "));
		// list.add(new Expresion("Afiliado gravado en IVA", ""));

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

	/**
	 * Obtenemos un {@link String} con la condicion parseada<br>
	 * Concepto Comparador valor
	 * 
	 * @param concepto
	 * @param comparador
	 * @param valor
	 * @return
	 */
	private String obtenercondicion(Concepto concepto, Comparador comparador, String valor) {

		String condicion;

		condicion = concepto.getIdentificacion() + comparador.getPrefijo() + valor + comparador.getSufijo();

		return condicion;

	}

	@Override
	protected void onReset() {

		getView().asignarFoco();

		super.onReset();
	}
}