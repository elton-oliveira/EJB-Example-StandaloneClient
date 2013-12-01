package br.com.fluentcode.ejb.client;

import java.util.Calendar;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.com.fluentcode.ejb.remote.TaskSchedulerRemote;

public class TaskSchedulerClient {
	
	public static void main(String[] args) throws NamingException {
		InitialContext ctx = new InitialContext();
		TaskSchedulerRemote scheduler =  (TaskSchedulerRemote) ctx.lookup("EJB-Example/TaskSchedulerBean!br.com.fluentcode.ejb.remote.TaskSchedulerRemote");
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.SECOND, 5);
		for(int i = 1; i<= 50; i++){
			calendar.add(Calendar.MILLISECOND, 100);
			scheduler.scheduleTask(calendar.getTime(), "Planning is essential! (Task "+i+")");
		}
		System.out.println("The task was scheduled");
	}

}
