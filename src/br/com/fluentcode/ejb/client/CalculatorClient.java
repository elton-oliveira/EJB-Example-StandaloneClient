package br.com.fluentcode.ejb.client;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.com.fluentcode.ejb.remote.CalculatorRemote;

/**
 * 
 * Stateless Session Bean Client
 *
 */
public class CalculatorClient {
	
	public static void main(String[] args) throws NamingException {
		InitialContext ctx = new InitialContext();
		CalculatorRemote calculator = (CalculatorRemote) ctx.lookup("EJB-Example/CalculatorBean!br.com.fluentcode.ejb.remote.CalculatorRemote");
		int value = calculator.add(2, 3);
		System.out.println(value);
	}

}
