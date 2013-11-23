package br.com.fluentcode.ejb.remote;

import javax.ejb.Remote;

/**
 * 
 * TODO Preciso tirar o classpath target runtime do jboss-7.
 * Para compilar preciso ver como resolver com o ant e ivy (adicionar um lib com scope de ...)
 *
 */
@Remote
public interface CalculatorRemote {
	
	int add(int x, int y);

}
