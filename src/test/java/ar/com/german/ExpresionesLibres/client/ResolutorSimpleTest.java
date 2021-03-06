package ar.com.german.ExpresionesLibres.client;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ar.com.german.ExpresionesLibres.server.beanshell.Resolutor;
import ar.com.german.ExpresionesLibres.shared.modelo.Comparador;
import ar.com.german.ExpresionesLibres.shared.modelo.Concepto;
import ar.com.german.ExpresionesLibres.shared.modelo.ConceptoIngresado;
import ar.com.german.ExpresionesLibres.shared.modelo.Expresion;
import ar.com.german.ExpresionesLibres.shared.modelo.OperadoresSimbolicos;
import ar.com.german.ExpresionesLibres.shared.modelo.Regla;
import ar.com.german.ExpresionesLibres.shared.modelo.TieneConceptoConValor;
import ar.com.german.ExpresionesLibres.shared.modelo.TieneValorBooleano;
import ar.com.german.ExpresionesLibres.shared.modelo.TieneValorCadena;
import ar.com.german.ExpresionesLibres.shared.modelo.TieneValorNumero;

/**
 * Tests sencillos para el {@link Resolutor}
 * 
 * @author germanmr
 * 
 */
public class ResolutorSimpleTest extends ResolutorAbstractTest {

	@Test
	/**
	 * Esto es Concepto Cadena es igual a Algo 
	 */
	public void obtenerDesicionConUnConceptosCadenaTest() {

		// Estos son los conceptos
		List<Concepto> conceptos = new ArrayList<>();

		conceptos.add(getConceptoPrestacion());

		// Estas es la regla definida
		List<Expresion> expresiones = new ArrayList<>();
		expresiones.add(new Expresion(getConceptoPrestacion(), getComparadorIgual(), new TieneValorCadena("420101"),
				getConcatenadorNinguno()));
		List<Regla<Integer>> reglas = new ArrayList<>();
		reglas.add(new Regla<Integer>(expresiones, 159));

		List<TieneConceptoConValor> conceptosIngresados = new ArrayList<>();
		conceptosIngresados.add(new ConceptoIngresado<String>(getConceptoPrestacion(), "420101"));

		Integer resultado = resolutor.obtenerResultado(conceptos, reglas, conceptosIngresados);

		Assert.assertNotNull(resultado);
		Assert.assertEquals((Integer) 159, resultado);

	}

	@Test
	/**
	 * Esto es Concepto Numero es igual a Algo
	 */
	public void obtenerDesicionConUnConceptoNumeroTest() {

		// Estos son los conceptos
		List<Concepto> conceptos = new ArrayList<>();

		conceptos.add(getConceptoObraSocial());

		// Estas es la regla definida
		List<Expresion> expresiones = new ArrayList<>();
		expresiones.add(new Expresion(getConceptoObraSocial(), getComparadorIgual(), new TieneValorNumero(220), getConcatenadorNinguno()));
		List<Regla<Integer>> reglas = new ArrayList<>();
		reglas.add(new Regla<Integer>(expresiones, 159));

		List<TieneConceptoConValor> conceptosIngresados = new ArrayList<>();
		conceptosIngresados.add(new ConceptoIngresado<Integer>(getConceptoObraSocial(), 220));

		Integer resultado = resolutor.obtenerResultado(conceptos, reglas, conceptosIngresados);

		Assert.assertNotNull(resultado);
		Assert.assertEquals((Integer) 159, resultado);

	}

	@Test
	/**
	 * Esto es Cocnepto Booleano es igual a Algo
	 */
	public void obtenerDesicionConUnConceptoBooleanoTest() {

		// Estos son los conceptos
		List<Concepto> conceptos = new ArrayList<>();
		conceptos.add(getConceptoCondicionAfiliado());

		// Estas es la regla definida
		List<Expresion> expresiones = new ArrayList<>();
		expresiones.add(new Expresion(getConceptoCondicionAfiliado(), getComparadorIgual(), new TieneValorBooleano(true),
				getConcatenadorNinguno()));

		List<Regla<Boolean>> reglas = new ArrayList<>();
		reglas.add(new Regla<Boolean>(expresiones, true));

		List<TieneConceptoConValor> conceptosIngresados = new ArrayList<>();
		conceptosIngresados.add(new ConceptoIngresado<Boolean>(getConceptoCondicionAfiliado(), true));

		Boolean resultado = resolutor.obtenerResultado(conceptos, reglas, conceptosIngresados);

		Assert.assertNotNull(resultado);
		Assert.assertEquals(true, resultado);

	}
}
