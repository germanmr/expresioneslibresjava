package ar.com.german.ExpresionesLibres.client;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ar.com.german.ExpresionesLibres.shared.modelo.ConceptoIngresado;
import ar.com.german.ExpresionesLibres.shared.modelo.EsComparable;
import ar.com.german.ExpresionesLibres.shared.modelo.Expresion;
import ar.com.german.ExpresionesLibres.shared.modelo.Regla;
import ar.com.german.ExpresionesLibres.shared.modelo.TieneConceptoConValor;
import ar.com.german.ExpresionesLibres.shared.modelo.TieneValorBooleano;
import ar.com.german.ExpresionesLibres.shared.modelo.TieneValorCadena;
import ar.com.german.ExpresionesLibres.shared.modelo.TieneValorNumero;

/**
 * Test complejos para el resolutor
 * 
 * @author germanmr
 * 
 */
public class ResolutorComplexTest extends ResolutorAbstractTest {

	@Test
	public void obtenerDesicionDosConceptosCadenaNumeroTest() {

		// Estos son los conceptos
		List<EsComparable> conceptos = new ArrayList<>();
		conceptos.add(getConceptoPrestacion());
		conceptos.add(getConceptoObraSocial());

		// Estas es la regla definida

		EsComparable tieneValorCadena = new TieneValorCadena("420101");
		List<Expresion> expresiones = new ArrayList<>();
		expresiones.add(new Expresion(getConceptoPrestacion(), getComparadorIgual(), tieneValorCadena, getConcatenadorAdemas()));
		EsComparable tieneValorNumero = new TieneValorNumero(220);
		expresiones.add(new Expresion(getConceptoObraSocial(), getComparadorIgual(), tieneValorNumero, getConcatenadorNinguno()));

		List<Regla<Integer>> reglas = new ArrayList<>();
		reglas.add(new Regla<Integer>(expresiones, 159));

		List<TieneConceptoConValor> conceptosIngresados = new ArrayList<>();
		conceptosIngresados.add(new ConceptoIngresado<String>(getConceptoPrestacion(), "420101"));
		conceptosIngresados.add(new ConceptoIngresado<Integer>(getConceptoObraSocial(), 220));

		Integer resultado = resolutor.obtenerResultado(conceptos, reglas, conceptosIngresados);

		Assert.assertNotNull(resultado);
		Assert.assertEquals((Integer) 159, resultado);

		getResolutor().obtenerResultado(conceptos, reglas, conceptosIngresados);
	}

	@Test
	public void obtenerDesicionDosConceptosCadenaBooleanoTest() {

		// Estos son los conceptos
		List<EsComparable> conceptos = new ArrayList<>();
		conceptos.add(getConceptoPrestacion());
		conceptos.add(getConceptoPlanAfiliado());

		// Estas es la regla definida
		List<Expresion> expresiones = new ArrayList<>();
		expresiones.add(new Expresion(getConceptoPrestacion(), getComparadorIgual(), new TieneValorCadena("420101"),
				getConcatenadorAdemas()));
		EsComparable tieneValorBooleano = new TieneValorBooleano(true);
		expresiones.add(new Expresion(getConceptoCondicionAfiliado(), getComparadorIgual(), tieneValorBooleano, getConcatenadorNinguno()));
		List<Regla<Integer>> reglas = new ArrayList<>();
		reglas.add(new Regla<Integer>(expresiones, 159));

		List<TieneConceptoConValor> conceptosIngresados = new ArrayList<>();
		conceptosIngresados.add(new ConceptoIngresado<String>(getConceptoPrestacion(), "420101"));
		conceptosIngresados.add(new ConceptoIngresado<Boolean>(getConceptoCondicionAfiliado(), true));

		Integer resultado = resolutor.obtenerResultado(conceptos, reglas, conceptosIngresados);

		Assert.assertNotNull(resultado);
		Assert.assertEquals((Integer) 159, resultado);

		getResolutor().obtenerResultado(conceptos, reglas, conceptosIngresados);
	}

	@Test
	public void obtenerDesicionDosConceptosNumeroBooleanoTest() {

		// Estos son los conceptos
		List<EsComparable> conceptos = new ArrayList<>();
		conceptos.add(getConceptoObraSocial());
		conceptos.add(getConceptoCondicionAfiliado());

		// Estas es la regla definida
		List<Expresion> expresiones = new ArrayList<>();
		expresiones.add(new Expresion(getConceptoObraSocial(), getComparadorIgual(), new TieneValorNumero(220), getConcatenadorAdemas()));
		expresiones.add(new Expresion(getConceptoCondicionAfiliado(), getComparadorIgual(), new TieneValorBooleano(true),
				getConcatenadorNinguno()));
		List<Regla<Integer>> reglas = new ArrayList<>();
		reglas.add(new Regla<Integer>(expresiones, 159));

		List<TieneConceptoConValor> conceptosIngresados = new ArrayList<>();
		conceptosIngresados.add(new ConceptoIngresado<Integer>(getConceptoObraSocial(), 220));
		conceptosIngresados.add(new ConceptoIngresado<Boolean>(getConceptoCondicionAfiliado(), true));

		Integer resultado = resolutor.obtenerResultado(conceptos, reglas, conceptosIngresados);

		Assert.assertNotNull(resultado);
		Assert.assertEquals((Integer) 159, resultado);

		getResolutor().obtenerResultado(conceptos, reglas, conceptosIngresados);
	}

}
