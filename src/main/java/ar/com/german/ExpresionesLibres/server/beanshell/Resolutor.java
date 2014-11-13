package ar.com.german.ExpresionesLibres.server.beanshell;

import java.util.List;

import com.google.gwt.thirdparty.guava.common.base.Preconditions;
import com.google.inject.Inject;

import ar.com.german.ExpresionesLibres.shared.modelo.Concepto;
import ar.com.german.ExpresionesLibres.shared.modelo.EsComparable;
import ar.com.german.ExpresionesLibres.shared.modelo.Regla;
import ar.com.german.ExpresionesLibres.shared.modelo.TieneConceptoConValor;
import bsh.EvalError;
import bsh.Interpreter;

/**
 * Esta entidad es la encargada de gestionar reglas vs informacion indicada para
 * tomar una desicion
 * 
 * @author germanmr
 * @param <R>
 * 
 */
public final class Resolutor {

	private final Interpreter interpreter;

	@Inject
	public Resolutor(Interpreter interpreter) {
		this.interpreter = interpreter;
	}

	/**
	 * Evalua todas las reglas indicados con los valores indicados y devuelve el
	 * resultado de la regla que coincida o devuelve null si ninguna regla
	 * coincide con los valores ingresados
	 * 
	 * @param <T>
	 * 
	 * @param conceptos
	 * @param reglas
	 * @param conceptosIngresados
	 * @return
	 */
	public <R, T> R obtenerResultado(List<EsComparable> conceptos, List<Regla<T>> reglas, List<TieneConceptoConValor> conceptosIngresados) {

		try {

			Preconditions.checkArgument(!conceptos.isEmpty(), "Los conceptos no tienen que estar vacios");
			Preconditions.checkArgument(!reglas.isEmpty(), "Las reglas no tienen que estar vacias");
			Preconditions.checkArgument(!conceptosIngresados.isEmpty(), "Los conceptos ingresados no tienen que estar vacios");

			boolean condicion = false;

			// Para cada regla me fijo si cumple con la condicion
			for (Regla<T> regla : reglas) {

				// Para cada concepto de la regla le asigno un valor
				for (TieneConceptoConValor conceptoIngresado : conceptosIngresados) {
					System.out.println("Concepto seteado: " + conceptoIngresado.getConcepto().getIdentificacion());
					System.out.println("Valor seteado: " + conceptoIngresado.getValor());
					interpreter.set(conceptoIngresado.getConcepto().getIdentificacion(), conceptoIngresado.getValor());
				}

				System.out.println(regla.getReglaReal());

				String evaluar = "condicion=" + regla.getReglaReal() + " ? true : false ;";

				System.out.println("Expresion a evaluar: " + evaluar);

				condicion = (boolean) interpreter.eval(evaluar);

				System.out.println("Condicion obtenida: " + condicion);

				if (condicion) {
					// TODO ejecutar un comando??
					return (R) regla.getResultado();
				}

			}

			return null;

		} catch (EvalError e) {
			System.out.println(e.getMessage());
			return null;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

}

// * Reglas para probar
// *'CodigoConvenio'+' = ' +'1'+Y INLIST(codigoEspecialidadEfector,44,45) Y
// codigoPrestacion>='420101' Y codigoPrestacion<='429999' ,
// CodigoObraSocial=228
// *'CodigoConvenio'+' = ' +'1'+Y INLIST(codigoEspecialidadEfector,44,45) Y
// !(codigoPrestacion>='420101' Y
// codigoPrestacion<='429999'),CodigoObraSocial=229
// *!* 'CodigoConvenio'+' = ' +'1'+Y CodigoProfesionPrestador=4 Y
// MatriculaProfesionalPrestador=69211 codigoPrestacion>='420101' Y
// codigoPrestacion<='429999' Y CodigoPlanAfiliado=1, CodigoObraSocial=421
// *!* 'CodigoConvenio'+' = ' +'1'+Y CodigoProfesionPrestador=4 Y
// MatriculaProfesionalPrestador=69211 Y codigoPrestacion>='420101' Y
// codigoPrestacion<='429999' Y codplan<>1, CodigoObraSocial=323
// *!* 'CodigoConvenio'+' = ' +'1'+Y CodigoProfesionPrestador=4 Y
// MatriculaProfesionalPrestador=69211 Y !(codigoPrestacion>='420101' Y
// codigoPrestacion<='429999') Y CodigoPlanAfiliado=1, CodigoObraSocial=421
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
// *!* 'CodigoConvenio'+' = ' +'4'+Y INLIST(codigoEspecialidadEfector,44,45) Y
// codigoPrestacion='423301', CodigoObraSocial=712
// *!* 'CodigoConvenio'+' = ' +'4'+Y INLIST(codigoEspecialidadEfector,44,45) Y
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
// *!* 'CodigoConvenio'+' = ' +'12'+ Y CodigoPlanAfiliado=1, CodigoObraSocial=27
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
