package ar.com.german.ExpresionesLibres.client;

//Listing for SimpleCompileTest.java that compiles the MyClass.java file.

import javax.tools.*;

public class SimpleCompileTest {

	public static void main(String[] args) {
		String fileToCompile = "test" + java.io.File.separator + "MyClass.java";
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		int compilationResult = compiler.run(null, null, null, fileToCompile);
		if (compilationResult == 0) {
			System.out.println("Compilation is successful");
		} else {
			System.out.println("Compilation Failed");
		}
	}
}
// See more at:
// http://www.javabeat.net/the-java-6-0-compiler-api/#sthash.kVrOjp2g.dpuf