package ar.com.german.ExpresionesLibres.client;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

import ar.com.german.ExpresionesLibres.server.beanshell.Resolutor;
import ar.com.german.ExpresionesLibres.shared.modelo.Concepto;
import ar.com.german.ExpresionesLibres.shared.modelo.ConceptoIngresado;
import ar.com.german.ExpresionesLibres.shared.modelo.Regla;
import ar.com.german.ExpresionesLibres.shared.modelo.TieneConceptoConValor;

public class ResolutorTest {

	@Inject
	Resolutor resolutor;

	@Before
	public void inicializar() {
		Injector injector = Guice.createInjector();
		injector.injectMembers(this);

	}

	@Test
	public void obtenerDesicionConValoresIntegerTest() {

		List<Concepto> conceptos = new ArrayList<>();
		Concepto conceptoPrestacion = new Concepto("Prestacion", "Prestacion");
		conceptos.add(conceptoPrestacion);
		Concepto conceptoObraSocial = new Concepto("ObraSocial", "Obra Social");
		conceptos.add(conceptoObraSocial);

		List<Regla<Integer>> reglas = new ArrayList<>();
		reglas.add(new Regla<Integer>(" \"420101\".equals(Prestacion) && 220==ObraSocial && afiliadoGravadoIva ", 159));
		reglas.add(new Regla<Integer>(" \"420101\".equals(Prestacion) && 220==ObraSocial ", 321));

		List<TieneConceptoConValor> conceptosIngresados = new ArrayList<>();
		conceptosIngresados.add(new ConceptoIngresado<String>(conceptoPrestacion, "420101"));
		Integer codigoObrasocial = 220;
		conceptosIngresados.add(new ConceptoIngresado<Integer>(conceptoObraSocial, codigoObrasocial));
		Concepto afiliadoGravadoIva = new Concepto("afiliadoGravadoIva", "Afiliado esta gravado en iva");
		conceptosIngresados.add(new ConceptoIngresado<Boolean>(afiliadoGravadoIva, true));

		Integer resultado = resolutor.obtenerResultado(conceptos, reglas, conceptosIngresados);

		Assert.assertNotNull(resultado);
		Integer esperado = 159;
		Assert.assertEquals(esperado, resultado);

	}

}
