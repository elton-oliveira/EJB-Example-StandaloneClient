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
		String jndiName = "EJB-Example/CalculatorBean!" + CalculatorRemote.class.getName();
		CalculatorRemote calculator = (CalculatorRemote) ctx.lookup(jndiName);
		int value = calculator.add(2, 3);
		System.out.println(value);
	}

}
