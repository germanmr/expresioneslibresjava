package ar.com.german.ExpresionesLibres.client;

import java.io.IOException;
import java.util.Arrays;

import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

import org.junit.Test;

public class DiagnosticCollectorCompile {

	@Test
	public void main() {

		try {

			JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
			DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<JavaFileObject>();
			StandardJavaFileManager fileManager = compiler.getStandardFileManager(diagnostics, null, null);
			Iterable<? extends JavaFileObject> compilationUnits = fileManager.getJavaFileObjectsFromStrings(Arrays
					.asList("Foo.java"));
			JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, diagnostics, null, null,
					compilationUnits);
			boolean success = task.call();
			fileManager.close();
			System.out.println("Success: " + success);

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}

// File: MyClass.java
class MyClass {
	public static void main(String args[]) {
		System.out.println("Hello, World");
	}
}
