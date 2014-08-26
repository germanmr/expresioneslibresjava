package ar.com.german.ExpresionesLibres.server.guice.dispatch;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.script.SimpleBindings;

import org.junit.Test;

import junit.framework.TestCase;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MyClass extends TestCase {

	@Test
	public void myMethod() {

		// try {
		// ScriptEngine engine = new
		// ScriptEngineManager().getEngineByName("JavaScript");
		// Map<String, Object> vars = new HashMap<String, Object>();
		// vars.put("x", 2);
		// vars.put("y", 1);
		// vars.put("z", 3);
		// System.out.println("result = " + engine.eval("x + y + z", new
		// SimpleBindings(vars)));
		// } catch (ScriptException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		Expression e = new ExpressionBuilder("3 * sin(y) - 2 / (x - 2)").variables("x", "y").build()
				.setVariable("x", 2.3).setVariable("y", 3.14);
		double result = e.evaluate();

		System.out.println(result);

	}
}
