package ar.com.german.ExpresionesLibres.client;

import org.junit.Before;

import com.google.inject.Inject;

import ar.com.german.ExpresionesLibres.server.beanshell.Resolutor;
import ar.com.german.ExpresionesLibres.shared.modelo.Comparador;
import ar.com.german.ExpresionesLibres.shared.modelo.Concatenador;
import ar.com.german.ExpresionesLibres.shared.modelo.ConcatenadoresJava;
import ar.com.german.ExpresionesLibres.shared.modelo.Concepto;
import ar.com.german.ExpresionesLibres.shared.modelo.OperadoresSimbolicos;
import ar.com.german.ExpresionesLibres.shared.modelo.TiposConceptos;

/**
 * Clase base para todos los test del {@link Resolutor}
 * 
 * @author germanmr
 * 
 */
public class ResolutorAbstractTest extends AbstractTest {

	private final Concepto conceptoPrestacion = new Concepto("prestacion", "Prestacion", TiposConceptos.CADENA);

	private final Concepto conceptoConvenio = new Concepto("convenio", "Convenio", TiposConceptos.CADENA);

	private final Concepto conceptoEspecialidadEfector = new Concepto("especialidadEfector", "Especialidad del Efector",
			TiposConceptos.CADENA);

	private final Concepto conceptoCodigoProfesionPrestador = new Concepto("profesionPrestador", "Profesion del Prestador",
			TiposConceptos.CADENA);

	private final Concepto conceptoMatriculaProfesionalPrestador = new Concepto("matriculaPrestador", "Matricula del Prestador",
			TiposConceptos.CADENA);

	private final Concepto conceptoPlanAfiliado = new Concepto("planAfiliado", "Plan del Afiliado", TiposConceptos.NUMERO);

	private final Concepto conceptoCondicionAfiliado = new Concepto("condicionAfiliado", "Condicion del Afiliado", TiposConceptos.BOOLEANO);

	private final Concepto conceptoObraSocial = new Concepto("obraSocial", "Obra Social", TiposConceptos.NUMERO);

	private final Concatenador concatenadorAdemas = new Concatenador(" Ademas ", ConcatenadoresJava.ADEMAS);

	private final Concatenador concatenadorO = new Concatenador(" o ", ConcatenadoresJava.O);

	private final Concatenador concatenadorNinguno = new Concatenador(" Ninguno ", ConcatenadoresJava.NINGUNO);

	private final Comparador comparadorIgual = new Comparador(" ES IGUAL A ", OperadoresSimbolicos.IGUAL);

	@Inject
	Resolutor resolutor;

	@Before
	public void inicializar() {
		injector.injectMembers(this);
	}

	public Concepto getConceptoConvenio() {
		return conceptoConvenio;
	}

	public Concepto getConceptoEspecialidadEfector() {
		return conceptoEspecialidadEfector;
	}

	public Concepto getConceptoCodigoProfesionPrestador() {
		return conceptoCodigoProfesionPrestador;
	}

	public Concepto getConceptoMatriculaProfesionalPrestador() {
		return conceptoMatriculaProfesionalPrestador;
	}

	public Concepto getConceptoPlanAfiliado() {
		return conceptoPlanAfiliado;
	}

	public Resolutor getResolutor() {
		return resolutor;
	}

	public void setResolutor(Resolutor resolutor) {
		this.resolutor = resolutor;
	}

	public Concepto getConceptoPrestacion() {
		return conceptoPrestacion;
	}

	public Concepto getConceptoObraSocial() {
		return conceptoObraSocial;
	}

	public Concatenador getConcatenadorAdemas() {
		return concatenadorAdemas;
	}

	public Concatenador getConcatenadorO() {
		return concatenadorO;
	}

	public Concatenador getConcatenadorNinguno() {
		return concatenadorNinguno;
	}

	public Concepto getConceptoCondicionAfiliado() {
		return conceptoCondicionAfiliado;
	}

	public Comparador getComparadorIgual() {
		return comparadorIgual;
	}

}
