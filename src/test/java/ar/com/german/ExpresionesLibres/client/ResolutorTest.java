package ar.com.german.ExpresionesLibres.client;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

import ar.com.german.ExpresionesLibres.client.beanshell.modelo.Concepto;
import ar.com.german.ExpresionesLibres.client.beanshell.modelo.ConceptoIngresado;
import ar.com.german.ExpresionesLibres.client.beanshell.modelo.Regla;
import ar.com.german.ExpresionesLibres.client.beanshell.modelo.TieneConceptoConValor;

public class ResolutorTest {

	@Inject
	Resolutor resolutor;

	@Before
	public void inicializar() {
		Injector injector = Guice.createInjector();
		injector.injectMembers(this);

	}

	@Test
	public void obtenerDesicionconValoresIntegerTest() {

		List<Concepto> conceptos = new ArrayList<>();
		Concepto conceptoPrestacion = new Concepto("CodigoPrestacion", "Prestacion");
		conceptos.add(conceptoPrestacion);
		Concepto conceptoObraSocial = new Concepto("CodigoObraSocial", "Obra Social");
		conceptos.add(conceptoObraSocial);

		List<Regla<Integer>> reglas = new ArrayList<>();
		reglas.add(new Regla<Integer>(" \"420101\".equals(CodigoPrestacion) && \"220\".equals(CodigoObraSocial)", 159));
		reglas.add(new Regla<Integer>(" \"420101\".equals(CodigoPrestacion) && \"220\".equals(CodigoObraSocial) ", 321));

		List<TieneConceptoConValor> conceptosIngresados = new ArrayList<>();
		conceptosIngresados.add(new ConceptoIngresado<String>(conceptoPrestacion, "420101"));
		conceptosIngresados.add(new ConceptoIngresado<String>(conceptoObraSocial, "220"));

		Integer resultado = resolutor.obtenerResultado(conceptos, reglas, conceptosIngresados);

		Assert.assertNotNull(resultado);
		Integer esperado = 159;
		Assert.assertEquals(esperado, resultado);

	}

	@Test
	public void obtenerResultadoConValoresdeDsintintosTiposTest() {

		List<Concepto> conceptos = new ArrayList<>();
		Concepto conceptoPrestacion = new Concepto("CodigoPrestacion", "Prestacion");
		conceptos.add(conceptoPrestacion);
		Concepto conceptoObraSocial = new Concepto("CodigoObraSocial", "Obra Social");
		conceptos.add(conceptoObraSocial);

		List<Regla<Integer>> reglas = new ArrayList<>();
		reglas.add(new Regla<Integer>(" \"420101\".equals(CodigoPrestacion) && \"220\".equals(CodigoObraSocial)", 159));
		reglas.add(new Regla<Integer>(" \"420101\".equals(CodigoPrestacion) && \"220\".equals(CodigoObraSocial) ", 321));

		List<TieneConceptoConValor> conceptosIngresados = new ArrayList<>();
		conceptosIngresados.add(new ConceptoIngresado<String>(conceptoPrestacion, "420101"));
		conceptosIngresados.add(new ConceptoIngresado<String>(conceptoObraSocial, "220"));

		Integer resultado = resolutor.obtenerResultado(conceptos, reglas, conceptosIngresados);

		Assert.assertNotNull(resultado);
		Integer esperado = 159;
		Assert.assertEquals(esperado, resultado);

	}

}
