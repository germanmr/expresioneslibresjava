package ar.com.german.ExpresionesLibres.client;

import org.junit.Test;

public class ResolutorReglasRealesTest extends ResolutorAbstractTest {

	// Regla 1
	// *'CodigoConvenio'+' = ' +'1'+Y
	// INLIST(codigoEspecialidadEfector,44,45) Y
	// codigoPrestacion>='420101' Y codigoPrestacion<='429999' ,
	// CodigoObraSocial=228

	// Regla 2
	// *'CodigoConvenio'+' = ' +'1'+Y
	// INLIST(codigoEspecialidadEfector,44,45) Y
	// !(codigoPrestacion>='420101' Y
	// codigoPrestacion<='429999'),
	// CodigoObraSocial=229

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

	@Test
	public void test() {

		// getResolutor().obtenerResultado(conceptos, reglas,
		// conceptosIngresados);

	}

}
