package ar.com.german.ExpresionesLibres.client;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

import ar.com.german.ExpresionesLibres.server.beanshell.ResolutorImpl;
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

public class ResolutorTest extends AbstractTest {

	@Inject
	ResolutorImpl resolutor;

	private Concepto conceptoConvenio = new Concepto("convenio", "Convenio", TiposConceptos.CADENA);

	private Concepto conceptoEspecialidadEfector = new Concepto("especialidadEfector", "Especialidad del Efector", TiposConceptos.CADENA);

	private Concepto conceptoCodigoProfesionPrestador = new Concepto("profesionPrestador", "Profesion del Prestador", TiposConceptos.CADENA);

	private Concepto conceptoMatriculaProfesionalPrestador = new Concepto("matriculaPrestador", "Matricula del Prestador",
			TiposConceptos.CADENA);

	private Concepto conceptoPlanAfiliado = new Concepto("planAfiliado", "Plan del Afiliado", TiposConceptos.CADENA);

	@Before
	public void inicializar() {
		injector.injectMembers(this);
	}

	@Test
	public void obtenerDesicionConUnConceptosCadenaTest() {

		// Estos son los conceptos
		List<Concepto> conceptos = new ArrayList<>();
		Concepto conceptoPrestacion = new Concepto("prestacion", "Prestacion", TiposConceptos.CADENA);
		conceptos.add(conceptoPrestacion);

		// Estas es la regla definida
		List<Expresion> expresiones = new ArrayList<>();
		expresiones.add(new Expresion(conceptoPrestacion, new Comparador(" ES IGUAL A ", OperadoresSimbolicos.IGUAL), new TieneValorCadena(
				"420101"), new Concatenador(" ", ConcatenadoresJava.NINGUNO)));
		List<Regla<Integer>> reglas = new ArrayList<>();
		reglas.add(new Regla<Integer>(expresiones, 159));

		List<TieneConceptoConValor> conceptosIngresados = new ArrayList<>();
		conceptosIngresados.add(new ConceptoIngresado<String>(conceptoPrestacion, "420101"));

		Integer resultado = resolutor.obtenerResultado(conceptos, reglas, conceptosIngresados);

		Assert.assertNotNull(resultado);
		Assert.assertEquals((Integer) 159, resultado);

	}

	@Test
	public void obtenerDesicionConUnConceptoNumeroTest() {

		// Estos son los conceptos
		List<Concepto> conceptos = new ArrayList<>();
		Concepto conceptoObraSocial = new Concepto("obraSocial", "Obra Social", TiposConceptos.NUMERO);
		conceptos.add(conceptoObraSocial);

		// Estas es la regla definida
		List<Expresion> expresiones = new ArrayList<>();
		expresiones.add(new Expresion(conceptoObraSocial, new Comparador(" ES IGUAL A ", OperadoresSimbolicos.IGUAL),
				new TieneValorInteger(220), new Concatenador(" ", ConcatenadoresJava.NINGUNO)));
		List<Regla<Integer>> reglas = new ArrayList<>();
		reglas.add(new Regla<Integer>(expresiones, 159));

		List<TieneConceptoConValor> conceptosIngresados = new ArrayList<>();
		conceptosIngresados.add(new ConceptoIngresado<Integer>(conceptoObraSocial, 220));

		Integer resultado = resolutor.obtenerResultado(conceptos, reglas, conceptosIngresados);

		Assert.assertNotNull(resultado);
		Assert.assertEquals((Integer) 159, resultado);

	}

	@Test
	public void obtenerDesicionConUnConceptoBooleanoTest() {

		// Estos son los conceptos
		List<Concepto> conceptos = new ArrayList<>();
		Concepto conceptoPrestacion = new Concepto("prestacion", "Prestacion", TiposConceptos.BOOLEANO);
		conceptos.add(conceptoPrestacion);

		// Estas es la regla definida
		List<Expresion> expresiones = new ArrayList<>();
		expresiones.add(new Expresion(conceptoPrestacion, new Comparador(" ES IGUAL A ", OperadoresSimbolicos.IGUAL),
				new TieneValorBooleano(true), new Concatenador(" ", ConcatenadoresJava.NINGUNO)));
		List<Regla<Integer>> reglas = new ArrayList<>();
		reglas.add(new Regla<Integer>(expresiones, 159));

		List<TieneConceptoConValor> conceptosIngresados = new ArrayList<>();
		conceptosIngresados.add(new ConceptoIngresado<Boolean>(conceptoPrestacion, true));

		Integer resultado = resolutor.obtenerResultado(conceptos, reglas, conceptosIngresados);

		Assert.assertNotNull(resultado);
		Assert.assertEquals((Integer) 159, resultado);

	}

	@Test
	public void obtenerDesicionConConceptosDeDistintoTipoTest() {

		// TODO Hacer

	}

	// * Reglas para probar
	// *'CodigoConvenio'+' = ' +'1'+Y
	// INLIST(codigoEspecialidadEfector,44,45) Y
	// codigoPrestacion>='420101' Y codigoPrestacion<='429999' ,
	// CodigoObraSocial=228
	// *'CodigoConvenio'+' = ' +'1'+Y
	// INLIST(codigoEspecialidadEfector,44,45) Y
	// !(codigoPrestacion>='420101' Y
	// codigoPrestacion<='429999'),CodigoObraSocial=229
	// *!* 'CodigoConvenio'+' = ' +'1'+Y CodigoProfesionPrestador=4 Y
	// MatriculaProfesionalPrestador=69211 codigoPrestacion>='420101' Y
	// codigoPrestacion<='429999' Y CodigoPlanAfiliado=1,
	// CodigoObraSocial=421
	// *!* 'CodigoConvenio'+' = ' +'1'+Y CodigoProfesionPrestador=4 Y
	// MatriculaProfesionalPrestador=69211 Y codigoPrestacion>='420101' Y
	// codigoPrestacion<='429999' Y codplan<>1, CodigoObraSocial=323
	// *!* 'CodigoConvenio'+' = ' +'1'+Y CodigoProfesionPrestador=4 Y
	// MatriculaProfesionalPrestador=69211 Y !(codigoPrestacion>='420101' Y
	// codigoPrestacion<='429999') Y CodigoPlanAfiliado=1,
	// CodigoObraSocial=421
	// *!* 'CodigoConvenio'+' = ' +'1'+Y CodigoProfesionPrestador=4 Y
	// MatriculaProfesionalPrestador=69211 Y !(codigoPrestacion>='420101' Y
	// codigoPrestacion<='429999') Y codplan<>1, CodigoObraSocial=323
	// *!* *'CodigoConvenio'+' = ' +'3'+Y CodigoObraSocial <> 210 Y
	// CodigoPrestacion>='420101' Y codigoPrestacion<='429999' Y
	// !INLIST(codigoEspecialidadEfector,0,13,21,57,42,206,216,219,224,226,230,232,238,249,306,316,317),
	// CodigoObraSocial=211
	// *!* *'CodigoConvenio'+' = ' +'3'+Y CodigoObraSocial <> 210 Y
	// CodigoPrestacion>='420101' Y codigoPrestacion<='429999' Y
	// INLIST(codigoEspecialidadEfector,0,13,21,57,42,206,216,219,224,226,230,232,238,249,306,316,317),
	// CodigoObraSocial=214
	// *!* 'CodigoConvenio'+' = ' +'3'+Y CodigoObraSocial <> 210 Y
	// !(CodigoPrestacion>='420101' Y codigoPrestacion<='429999'),
	// CodigoObraSocial=212
	// *!* 'CodigoConvenio'+' = ' +'3'+Y CodigoObraSocial <> 210
	// *!* 'CodigoConvenio'+' = ' +'4'+Y
	// INLIST(codigoEspecialidadEfector,44,45) Y
	// codigoPrestacion='423301', CodigoObraSocial=712
	// *!* 'CodigoConvenio'+' = ' +'4'+Y
	// INLIST(codigoEspecialidadEfector,44,45) Y
	// codigoPrestacion='423301', CodigoObraSocial=12
	// *!* 'CodigoConvenio'+' = ' +'5', CodigoObraSocial=70
	// *!* 'CodigoConvenio'+' = ' +'6', CodigoObraSocial=8
	// *!* 'CodigoConvenio'+' = ' +'7', CodigoObraSocial=138
	// *!* 'CodigoConvenio'+' = ' +'8' + Y
	// INLIST(codigoPrestacion,'340205','340206','340207','340208'),
	// CodigoObraSocial=167
	// *!* 'CodigoConvenio'+' = ' +'8' + Y
	// !INLIST(codigoPrestacion,'340205','340206','340207','340208'),
	// CodigoObraSocial=67
	// *!* 'CodigoConvenio'+' = ' +'12'+ Y CodigoPlanAfiliado=1,
	// CodigoObraSocial=27
	// *!* 'CodigoConvenio'+' = ' +'12'+ Y CodigoPlanAfiliado EN(2,3),
	// CodigoObraSocial=125
	// *'CodigoConvenio'+' = ' +'18'+ Y CodigoPlanAfiliado EN
	// (611,612,613,614,615,616,617,618,619,620,621,622,623,624,625,630,631,632,633,634,635,636,637,638,641,642,643,644)
	// Y AfiliadoGravadoIva, CodigoObraSocial=190
	// *'CodigoConvenio'+' = ' +'18'+ Y
	// INLIST(CodigoPlanAfiliado,611,612,613,614,615,616,617,618,619,620,621,622,623,624,625,630,631,632,633,634,635,636,637,638,641,642,643,644)
	// Y AfiliadoGravadoIva, CodigoObraSocial=192
	// *'CodigoConvenio'+' = ' +'18'+ Y
	// INLIST(CodigoPlanAfiliado,608,609,610,627,628,629,640) Y
	// AfiliadoGravadoIva,CodigoObraSocial=191
	// *'CodigoConvenio'+' = ' +'18'+ Y
	// INLIST(CodigoPlanAfiliado,608,609,610,627,628,629,640) Y NO
	// AfiliadoGravadoIva, CodigoObraSocial=193

	// Estos son los valores que ingresaron

	// Concepto afiliadoGravadoIva = new Concepto("afiliadoGravadoIva",
	// "Afiliado esta gravado en iva", TiposConceptos.BOOLEANO);
	// conceptosIngresados.add(new
	// ConceptoIngresado<Boolean>(afiliadoGravadoIva, true));

}
