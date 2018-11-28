package ma.gloster.microservice.business;

import groovy.lang.GroovyShell;

public class BatchExecution {
     
	public static void executeGroovyScript(String groovyScript) {
		String processingCode = groovyScript;
	    GroovyShell shell = new GroovyShell();
	    shell.evaluate(processingCode);
	}
	
	public static void executeSqlQuery(String sqlQuery) {
	   System.out.println(sqlQuery);	
	}
}
