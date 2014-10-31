package ar.com.german.ExpresionesLibres.server.dispatch;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

import ar.com.german.ExpresionesLibres.shared.modelo.dispatch.ObtenerEntidadDeCsvAction;
import ar.com.german.ExpresionesLibres.shared.modelo.dispatch.ObtenerEntidadDeCsvResult;
import au.com.bytecode.opencsv.CSVParser;
import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;

import com.google.inject.Inject;
import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.rpc.server.actionhandler.ActionHandler;
import com.gwtplatform.dispatch.shared.ActionException;

public class ObtenerEntidadDeCsvHandler implements ActionHandler<ObtenerEntidadDeCsvAction, ObtenerEntidadDeCsvResult> {

	@Inject
	public ObtenerEntidadDeCsvHandler() {
	}

	@Override
	public ObtenerEntidadDeCsvResult execute(ObtenerEntidadDeCsvAction action, ExecutionContext context) throws ActionException {

		// /////////////////////////////////////////////////////////////////////////////

		try {

			ColumnPositionMappingStrategy strat = new ColumnPositionMappingStrategy();
			strat.setType(Persona.class);

			/**
			 * The fields to bind do in your JavaBean
			 */
			String[] columns = new String[] { "codigo", "nombre", "descripcion" };
			strat.setColumnMapping(columns);

			CsvToBean csv = new CsvToBean();

			String csvFilename = "d:\\datosdeods.csv";
			CSVReader csvReader;
			csvReader = new CSVReader(new FileReader(csvFilename));
			// CSVReader csvReader = new CSVReader(new filer);
			// CSVParser parser=new
			// action.getDatos()

			List list = csv.parse(strat, csvReader);
			for (Object object : list) {
				Persona persona = (Persona) object;
				System.out.println(persona);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// /////////////////////////////////////////////////////////////////////////////

		// TODO El problema esta en un enter adentro de un campo
		//
		// String cadena = action.getDatos();
		//
		// // Tengo que reemplazar todos los
		// //cadena = cadena.replaceAll("[\n]", " salto ");
		//
		// System.out.println(cadena);
		//
		// Scanner scanner = new Scanner(cadena);
		//
		// scanner.useDelimiter(",");
		//
		// while (scanner.hasNext()) {
		//
		// String line = scanner.nextLine();
		//
		// String[] tokens = line.split(",");
		//
		// Integer codigo = Integer.parseInt(tokens[0]);
		// String nombre = tokens[1];
		// String descripcion = tokens[2];
		// Persona persona = new Persona(codigo, nombre, descripcion);
		// System.out.println(persona.toString());
		//
		// }
		//
		// scanner.close();

		return new ObtenerEntidadDeCsvResult();
	}

	@Override
	public Class<ObtenerEntidadDeCsvAction> getActionType() {
		return ObtenerEntidadDeCsvAction.class;
	}

	@Override
	public void undo(ObtenerEntidadDeCsvAction action, ObtenerEntidadDeCsvResult result, ExecutionContext context) throws ActionException {

	}

}
