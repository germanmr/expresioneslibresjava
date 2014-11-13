package ar.com.german.ExpresionesLibres.client;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ar.com.german.ExpresionesLibres.shared.modelo.Concepto;
import ar.com.german.ExpresionesLibres.shared.modelo.ConceptoIngresado;
import ar.com.german.ExpresionesLibres.shared.modelo.EsComparable;
import ar.com.german.ExpresionesLibres.shared.modelo.Expresion;
import ar.com.german.ExpresionesLibres.shared.modelo.Regla;
import ar.com.german.ExpresionesLibres.shared.modelo.TieneConceptoConValor;
import ar.com.german.ExpresionesLibres.shared.modelo.TieneValorCadena;
import ar.com.german.ExpresionesLibres.shared.modelo.TieneValorNumero;

public class ResolutorReglasRealesTest extends ResolutorAbstractTest {

	// TODO Valores salteados en una lista

	@Test
	public void regla1Test() {

		// Regla 1
		// *'Convenio'+' = ' +'1'+Y
		// INLIST(EspecialidadEfector,44,45) Y
		// Prestacion>='420101' Y Prestacion<='429999' ,
		// ObraSocial=228

		// Estos son los conceptos
		List<EsComparable> conceptos = new ArrayList<>();
		conceptos.add(getConceptoConvenio());

		// Estas es la regla definida
		// Convenio, especialidad del efector y prestacion
		List<Expresion> expresiones = new ArrayList<>();
		// Convenio
		expresiones.add(new Expresion(getConceptoConvenio(), getComparadorIgual(), new TieneValorNumero(1), getConcatenadorAdemas()));

		// Especialidad efector
		// SortedSet<Integer> numeros = new TreeSet<>(Arrays.asList(44, 45));

		expresiones.add(new Expresion(getConceptoEspecialidadEfector(), getComparadorMayorIgual(), new TieneValorNumero(44),
				getConcatenadorAdemas()));
		expresiones.add(new Expresion(getConceptoEspecialidadEfector(), getComparadorMenorIgual(), new TieneValorNumero(45),
				getConcatenadorAdemas()));

		/**
		 * Esto seria otra regla aparte porque si no tiene que ser especialidad
		 * igual a 44 o especialidad igual a 45 y tengo que separar en
		 * parentesis para cada concepto
		 */

		// Prestacion
		// Rangos, NO HACE FALTA, SON DOS EXPRESIONES !
		expresiones.add(new Expresion(getConceptoPrestacion(), getComparadorMayorIgual(), new TieneValorCadena("420101"),
				getConcatenadorAdemas()));
		expresiones.add(new Expresion(getConceptoPrestacion(), getComparadorMenorIgual(), new TieneValorCadena("429999"),
				getConcatenadorNinguno()));

		List<Regla<Integer>> reglas = new ArrayList<>();
		reglas.add(new Regla<Integer>(expresiones, 228));

		List<TieneConceptoConValor> conceptosIngresados = new ArrayList<>();
		conceptosIngresados.add(new ConceptoIngresado<Integer>(getConceptoConvenio(), 1));
		conceptosIngresados.add(new ConceptoIngresado<Integer>(getConceptoEspecialidadEfector(), 44));
		conceptosIngresados.add(new ConceptoIngresado<String>(getConceptoPrestacion(), "420101"));

		Integer resultado = resolutor.obtenerResultado(conceptos, reglas, conceptosIngresados);

		Assert.assertNotNull(resultado);
		Assert.assertEquals((Integer) 228, resultado);

	}

	@Test
	public void regla2Test() {

		// Regla 2
		// *'CodigoConvenio'+' = ' +'1'+Y
		// INLIST(codigoEspecialidadEfector,44,45) Y
		// !(codigoPrestacion>='420101' Y
		// codigoPrestacion<='429999'),
		// CodigoObraSocial=229

		// Estos son los conceptos
		List<EsComparable> conceptos = new ArrayList<>();
		conceptos.add(getConceptoConvenio());

		// Estas es la regla definida
		// Convenio, especialidad del efector y prestacion
		List<Expresion> expresiones = new ArrayList<>();
		// Convenio
		expresiones.add(new Expresion(getConceptoConvenio(), getComparadorIgual(), new TieneValorNumero(1), getConcatenadorAdemas()));

		// Especialidad efector
		// SortedSet<Integer> numeros = new TreeSet<>(Arrays.asList(44, 45));

		expresiones.add(new Expresion(getConceptoEspecialidadEfector(), getComparadorMayorIgual(), new TieneValorNumero(44),
				getConcatenadorAdemas()));
		expresiones.add(new Expresion(getConceptoEspecialidadEfector(), getComparadorMenorIgual(), new TieneValorNumero(45),
				getConcatenadorAdemas()));

		/**
		 * Esto seria otra regla aparte porque si no tiene que ser especialidad
		 * igual a 44 o especialidad igual a 45 y tengo que separar en
		 * parentesis para cada concepto
		 */

		// Prestacion
		// Rangos, NO HACE FALTA, SON DOS EXPRESIONES !
		expresiones.add(new Expresion(getConceptoPrestacion(), getComparadorMayorIgual(), new TieneValorCadena("429999"),
				getConcatenadorAdemas()));
		expresiones.add(new Expresion(getConceptoPrestacion(), getComparadorMenorIgual(), new TieneValorCadena("420101"),
				getConcatenadorNinguno()));

		List<Regla<Integer>> reglas = new ArrayList<>();
		reglas.add(new Regla<Integer>(expresiones, 229));

		List<TieneConceptoConValor> conceptosIngresados = new ArrayList<>();
		conceptosIngresados.add(new ConceptoIngresado<Integer>(getConceptoConvenio(), 1));
		conceptosIngresados.add(new ConceptoIngresado<Integer>(getConceptoEspecialidadEfector(), 44));
		conceptosIngresados.add(new ConceptoIngresado<String>(getConceptoPrestacion(), "420101"));

		Integer resultado = resolutor.obtenerResultado(conceptos, reglas, conceptosIngresados);

		Assert.assertNotNull(resultado);
		Assert.assertEquals((Integer) 229, resultado);
	}

	// Regla 3
	// 'CodigoConvenio'+' = ' +'1'+Y CodigoProfesionPrestador=4 Y
	// MatriculaProfesionalPrestador=69211 codigoPrestacion>='420101' Y
	// codigoPrestacion<='429999' Y CodigoPlanAfiliado=1,
	// CodigoObraSocial=421

	// Regla 4
	// *!* 'CodigoConvenio'+' = ' +'1'+Y CodigoProfesionPrestador=4 Y
	// MatriculaProfesionalPrestador=69211 Y codigoPrestacion>='420101' Y
	// codigoPrestacion<='429999' Y codplan<>1, CodigoObraSocial=323

	// Regla 4.1
	// *!* 'CodigoConvenio'+' = ' +'1'+Y CodigoProfesionPrestador=4 Y
	// MatriculaProfesionalPrestador=69211 Y !(codigoPrestacion>='420101' Y
	// codigoPrestacion<='429999') Y CodigoPlanAfiliado=1,
	// CodigoObraSocial=421

	// Regla 5
	// *!* 'CodigoConvenio'+' = ' +'1'+Y CodigoProfesionPrestador=4 Y
	// MatriculaProfesionalPrestador=69211 Y !(codigoPrestacion>='420101' Y
	// codigoPrestacion<='429999') Y codplan<>1, CodigoObraSocial=323
	// *!* *'CodigoConvenio'+' = ' +'3'+Y CodigoObraSocial <> 210 Y
	// CodigoPrestacion>='420101' Y codigoPrestacion<='429999' Y
	// !INLIST(codigoEspecialidadEfector,0,13,21,57,42,206,216,219,224,226,230,232,238,249,306,316,317),
	// CodigoObraSocial=211

	// Regla 6
	// *!* *'CodigoConvenio'+' = ' +'3'+Y CodigoObraSocial <> 210 Y
	// CodigoPrestacion>='420101' Y codigoPrestacion<='429999' Y
	// INLIST(codigoEspecialidadEfector,0,13,21,57,42,206,216,219,224,226,230,232,238,249,306,316,317),
	// CodigoObraSocial=214

	// Regla 7
	// *!* 'CodigoConvenio'+' = ' +'3'+Y CodigoObraSocial <> 210 Y
	// !(CodigoPrestacion>='420101' Y codigoPrestacion<='429999'),
	// CodigoObraSocial=212

	// Regla 8
	// *!* 'CodigoConvenio'+' = ' +'3'+Y CodigoObraSocial <> 210

	// Regla 9
	// *!* 'CodigoConvenio'+' = ' +'4'+Y
	// INLIST(codigoEspecialidadEfector,44,45) Y
	// codigoPrestacion='423301', CodigoObraSocial=712
	// *!* 'CodigoConvenio'+' = ' +'4'+Y
	// INLIST(codigoEspecialidadEfector,44,45) Y
	// codigoPrestacion='423301', CodigoObraSocial=12

	// Regla 10
	// *!* 'CodigoConvenio'+' = ' +'5', CodigoObraSocial=70

	// Regla 11
	// *!* 'CodigoConvenio'+' = ' +'6', CodigoObraSocial=8

	// Regla 12
	// *!* 'CodigoConvenio'+' = ' +'7', CodigoObraSocial=138

	// Regla 13
	// *!* 'CodigoConvenio'+' = ' +'8' + Y
	// INLIST(codigoPrestacion,'340205','340206','340207','340208'),
	// CodigoObraSocial=167

	// Regla 14
	// *!* 'CodigoConvenio'+' = ' +'8' + Y
	// !INLIST(codigoPrestacion,'340205','340206','340207','340208'),
	// CodigoObraSocial=67

	// Regla 15
	// *!* 'CodigoConvenio'+' = ' +'12'+ Y CodigoPlanAfiliado=1,
	// CodigoObraSocial=27
	// *!* 'CodigoConvenio'+' = ' +'12'+ Y CodigoPlanAfiliado EN(2,3),
	// CodigoObraSocial=125

	// Regla 16
	// *'CodigoConvenio'+' = ' +'18'+ Y CodigoPlanAfiliado EN
	// (611,612,613,614,615,616,617,618,619,620,621,622,623,624,625,630,631,632,633,634,635,636,637,638,641,642,643,644)
	// Y AfiliadoGravadoIva, CodigoObraSocial=190

	// Regla 17
	// *'CodigoConvenio'+' = ' +'18'+ Y
	// INLIST(CodigoPlanAfiliado,611,612,613,614,615,616,617,618,619,620,621,622,623,624,625,630,631,632,633,634,635,636,637,638,641,642,643,644)
	// Y AfiliadoGravadoIva, CodigoObraSocial=192

	// Regla 18
	// *'CodigoConvenio'+' = ' +'18'+ Y
	// INLIST(CodigoPlanAfiliado,608,609,610,627,628,629,640) Y
	// AfiliadoGravadoIva,CodigoObraSocial=191

	// Regla 19
	// *'CodigoConvenio'+' = ' +'18'+ Y
	// INLIST(CodigoPlanAfiliado,608,609,610,627,628,629,640) Y NO
	// AfiliadoGravadoIva, CodigoObraSocial=193

}
