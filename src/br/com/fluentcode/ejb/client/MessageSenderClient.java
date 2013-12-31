package br.com.fluentcode.ejb.client;

import javax.naming.InitialContext;

import br.com.fluentcode.ejb.remote.MessageSenderRemote;

public class MessageSenderClient {
	
	public static void main(String[] args) throws Exception {
		InitialContext ctx = new InitialContext();
		String jndiName = "EJB-Example/MessageSenderBean!" + MessageSenderRemote.class.getName();
		MessageSenderRemote sender =  (MessageSenderRemote) ctx.lookup(jndiName);
		sender.sendMessage("Planning is essential!");
		System.out.println("Message sent successfully!");
	}

}
