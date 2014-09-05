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
import ar.com.german.ExpresionesLibres.shared.modelo.Comparador;
import ar.com.german.ExpresionesLibres.shared.modelo.Concatenador;
import ar.com.german.ExpresionesLibres.shared.modelo.ConcatenadoresJava;
import ar.com.german.ExpresionesLibres.shared.modelo.Concepto;
import ar.com.german.ExpresionesLibres.shared.modelo.ConceptoIngresado;
import ar.com.german.ExpresionesLibres.shared.modelo.Expresion;
import ar.com.german.ExpresionesLibres.shared.modelo.OperadoresSimbolicos;
import ar.com.german.ExpresionesLibres.shared.modelo.Regla;
import ar.com.german.ExpresionesLibres.shared.modelo.TieneConceptoConValor;
import ar.com.german.ExpresionesLibres.shared.modelo.TiposConceptos;

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

		// Estos son los conceptos
		List<Concepto> conceptos = new ArrayList<>();
		Concepto conceptoPrestacion = new Concepto("prestacion", "Prestacion", TiposConceptos.CADENA);
		conceptos.add(conceptoPrestacion);
		Concepto conceptoObraSocial = new Concepto("obraSocial", "Obra Social", TiposConceptos.CADENA);
		conceptos.add(conceptoObraSocial);

		// Estas es la regla definida
		List<Expresion> expresiones = new ArrayList<>();
		expresiones.add(new Expresion(conceptoPrestacion, new Comparador(" ES IGUAL A ", OperadoresSimbolicos.IGUAL), "420101",
				new Concatenador(" Ademas ", ConcatenadoresJava.ADEMAS)));
		expresiones.add(new Expresion(conceptoObraSocial, new Comparador(" ES IGUAL A ", OperadoresSimbolicos.IGUAL), "220",
				new Concatenador(" Ademas ", ConcatenadoresJava.NADA)));
		List<Regla<Integer>> reglas = new ArrayList<>();
		reglas.add(new Regla<Integer>(expresiones, 159));

		// Estos son los valores que ingresaron
		List<TieneConceptoConValor> conceptosIngresados = new ArrayList<>();
		conceptosIngresados.add(new ConceptoIngresado<String>(conceptoPrestacion, "420101"));
		conceptosIngresados.add(new ConceptoIngresado<String>(conceptoObraSocial, "220"));
		// Concepto afiliadoGravadoIva = new Concepto("afiliadoGravadoIva",
		// "Afiliado esta gravado en iva", TiposConceptos.BOOLEANO);
		// conceptosIngresados.add(new
		// ConceptoIngresado<Boolean>(afiliadoGravadoIva, true));

		Integer resultado = resolutor.obtenerResultado(conceptos, reglas, conceptosIngresados);

		Assert.assertNotNull(resultado);
		Integer esperado = 159;
		Assert.assertEquals(esperado, resultado);

	}

}
