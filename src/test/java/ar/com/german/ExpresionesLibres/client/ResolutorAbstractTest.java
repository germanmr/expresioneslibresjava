package ar.com.german.ExpresionesLibres.client;

import org.junit.Before;

import com.google.inject.Inject;

import ar.com.german.ExpresionesLibres.server.beanshell.Resolutor;
import ar.com.german.ExpresionesLibres.shared.modelo.Comparador;
import ar.com.german.ExpresionesLibres.shared.modelo.Concatenador;
import ar.com.german.ExpresionesLibres.shared.modelo.ConcatenadoresJava;
import ar.com.german.ExpresionesLibres.shared.modelo.Concepto;
import ar.com.german.ExpresionesLibres.shared.modelo.EsComparable;
import ar.com.german.ExpresionesLibres.shared.modelo.OperadoresSimbolicos;
import ar.com.german.ExpresionesLibres.shared.modelo.TiposConceptos;

/**
 * Clase base para todos los test del {@link Resolutor}
 * 
 * @author germanmr
 * 
 */
public class ResolutorAbstractTest extends AbstractTest {

	private final EsComparable conceptoPrestacion = new Concepto("prestacion", "Prestacion", TiposConceptos.CADENA);

	private final EsComparable conceptoConvenio = new Concepto("convenio", "Convenio", TiposConceptos.NUMERO);

	private final EsComparable conceptoEspecialidadEfector = new Concepto("especialidadEfector", "Especialidad del Efector",
			TiposConceptos.NUMERO);

	private final EsComparable conceptoCodigoProfesionPrestador = new Concepto("profesionPrestador", "Profesion del Prestador",
			TiposConceptos.NUMERO);

	private final EsComparable conceptoMatriculaProfesionalPrestador = new Concepto("matriculaPrestador", "Matricula del Prestador",
			TiposConceptos.NUMERO);

	private final EsComparable conceptoPlanAfiliado = new Concepto("planAfiliado", "Plan del Afiliado", TiposConceptos.NUMERO);

	private final EsComparable conceptoCondicionAfiliado = new Concepto("condicionAfiliado", "Condicion del Afiliado",
			TiposConceptos.BOOLEANO);

	private final EsComparable conceptoObraSocial = new Concepto("obraSocial", "Obra Social", TiposConceptos.NUMERO);

	private final Concatenador concatenadorAdemas = new Concatenador(" Ademas ", ConcatenadoresJava.ADEMAS);

	private final Concatenador concatenadorO = new Concatenador(" o ", ConcatenadoresJava.O);

	private final Concatenador concatenadorNinguno = new Concatenador(" Ninguno ", ConcatenadoresJava.NINGUNO);

	private final Comparador comparadorIgual = new Comparador(" ES IGUAL A ", OperadoresSimbolicos.IGUAL);

	private final Comparador comparadorEstaEn = new Comparador("Esta en", OperadoresSimbolicos.ESTANEN);

	private Comparador comparadorMayorIgual = new Comparador(" Mayor igual", OperadoresSimbolicos.MAYORIGUAL);

	private Comparador comparadorMenorIgual = new Comparador(" Menor igual", OperadoresSimbolicos.MENORIGUAL);

	@Inject
	Resolutor resolutor;

	@Before
	public void inicializar() {
		injector.injectMembers(this);
	}

	protected EsComparable getConceptoConvenio() {
		return conceptoConvenio;
	}

	protected EsComparable getConceptoEspecialidadEfector() {
		return conceptoEspecialidadEfector;
	}

	protected EsComparable getConceptoCodigoProfesionPrestador() {
		return conceptoCodigoProfesionPrestador;
	}

	protected EsComparable getConceptoMatriculaProfesionalPrestador() {
		return conceptoMatriculaProfesionalPrestador;
	}

	protected EsComparable getConceptoPlanAfiliado() {
		return conceptoPlanAfiliado;
	}

	protected Resolutor getResolutor() {
		return resolutor;
	}

	protected EsComparable getConceptoPrestacion() {
		return conceptoPrestacion;
	}

	public EsComparable getConceptoObraSocial() {
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

	public EsComparable getConceptoCondicionAfiliado() {
		return conceptoCondicionAfiliado;
	}

	protected Comparador getComparadorIgual() {
		return comparadorIgual;
	}

	protected Comparador getComparadorEstaEn() {
		return comparadorEstaEn;
	}

	protected Comparador getComparadorMayorIgual() {
		return comparadorMayorIgual;
	}

	public Comparador getComparadorMenorIgual() {
		return comparadorMenorIgual;
	}

}
