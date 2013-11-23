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
		ShoppingCartRemote cart =  (ShoppingCartRemote) ctx.lookup("EJB-Example/ShoppingCartBean!br.com.fluentcode.ejb.remote.ShoppingCartRemote");
		cart.addItem("Pen");
		cart.addItem("Notebook");
		for(String item : cart.getItems()){
			System.out.println(item);
		}
		cart.finishShopping();
	}

}
