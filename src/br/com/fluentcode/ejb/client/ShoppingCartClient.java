package br.com.fluentcode.ejb.client;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.com.fluentcode.ejb.remote.ShoppingCartRemote;

/**
 * 
 * Stateful Session Bean Client
 *
 */
public class ShoppingCartClient {
	
	public static void main(String[] args) throws NamingException {
		InitialContext ctx = new InitialContext();
		String jndiName = "EJB-Example/ShoppingCartBean!" + ShoppingCartRemote.class.getName();
		ShoppingCartRemote cart =  (ShoppingCartRemote) ctx.lookup(jndiName);
		cart.addItem("Pen");
		cart.addItem("Notebook");
		for(String item : cart.getItems()){
			System.out.println(item);
		}
		cart.finishShopping();
	}

}
