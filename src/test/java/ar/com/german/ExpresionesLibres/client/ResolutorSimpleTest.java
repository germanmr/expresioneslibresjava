package ar.com.german.ExpresionesLibres.client;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import org.junit.Assert;
import org.junit.Test;

import ar.com.german.ExpresionesLibres.server.beanshell.Resolutor;
import ar.com.german.ExpresionesLibres.shared.modelo.Concepto;
import ar.com.german.ExpresionesLibres.shared.modelo.ConceptoIngresado;
import ar.com.german.ExpresionesLibres.shared.modelo.EsComparable;
import ar.com.german.ExpresionesLibres.shared.modelo.Expresion;
import ar.com.german.ExpresionesLibres.shared.modelo.Regla;
import ar.com.german.ExpresionesLibres.shared.modelo.TieneConceptoConValor;
import ar.com.german.ExpresionesLibres.shared.modelo.TieneValorBooleano;
import ar.com.german.ExpresionesLibres.shared.modelo.TieneValorCadena;
import ar.com.german.ExpresionesLibres.shared.modelo.TieneValorColeccionNumeros;
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
		List<EsComparable> conceptos = new ArrayList<>();

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
		List<EsComparable> conceptos = new ArrayList<>();

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
	 * Esto es Concepto Booleano es igual a Algo
	 */
	public void obtenerDesicionConUnConceptoBooleanoTest() {

		// Estos son los conceptos
		List<EsComparable> conceptos = new ArrayList<>();
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

	@Test
	/**
	 * Aca mefijo si algnos de los conceptos esta en una lista de numeros 
	 */
	public void obtenerDesicionConUnConceptosConUnaColeccionNumerosTest() {

		// Estructura de elemento en coleccion
		// coleccion.contiene()
		// Integer numero=1;

		// Este es el concepto
		List<EsComparable> conceptos = new ArrayList<>();

		conceptos.add(getConceptoObraSocial());

		// Estas es la regla definida
		SortedSet<Integer> obrasSociales = new TreeSet<>();
		obrasSociales.add(220);
		obrasSociales.add(226);
		obrasSociales.add(229);

		EsComparable tieneValorColeccionNumeros = new TieneValorColeccionNumeros(obrasSociales, new Concepto(getConceptoObraSocial()
				.getIdentificacion(), getConceptoObraSocial().getDescripcion(), getConceptoObraSocial().getTiposConceptos()));

		List<Expresion> expresiones = new ArrayList<>();

		expresiones
				.add(new Expresion(getConceptoObraSocial(), getComparadorEstaEn(), tieneValorColeccionNumeros, getConcatenadorNinguno()));

		List<Regla<Integer>> reglas = new ArrayList<>();
		reglas.add(new Regla<Integer>(expresiones, 159));

		List<TieneConceptoConValor> conceptosIngresados = new ArrayList<>();
		conceptosIngresados.add(new ConceptoIngresado<Integer>(getConceptoObraSocial(), 226));

		Integer resultado = resolutor.obtenerResultado(conceptos, reglas, conceptosIngresados);

		Assert.assertNotNull(resultado);
		Assert.assertEquals((Integer) 159, resultado);

	}

	@Test
	/**
	 * Aca mefijo si alguno de los conceptos esta en una lista de cadenas 
	 */
	public void obtenerDesicionConceptosCadenaTest() {

	}

	@Test
	public void testParaPruebasBasicas() throws Exception {
		// Ingresado
		String prestacionIngresada = "420101";

		// Validos
		List<String> prestacionesValidas = new ArrayList<>();
		prestacionesValidas.add("420101");

		if (prestacionesValidas.contains(prestacionIngresada)) {
			System.out.println("Contiene la cadena!!!");
		}

		// Ingresado
		Integer obraSocial = 220;

		// Validos
		if (Arrays.asList(220).contains(obraSocial)) {
			System.out.println("Contiene el numero!!!");
		}

	}

}
