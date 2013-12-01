package br.com.fluentcode.ejb.client;

import java.util.Calendar;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.com.fluentcode.ejb.remote.TaskSchedulerRemote;

public class TaskSchedulerClient {
	
	public static void main(String[] args) throws NamingException {
		InitialContext ctx = new InitialContext();
		TaskSchedulerRemote scheduler =  (TaskSchedulerRemote) ctx.lookup("EJB-Example/TaskSchedulerBean!br.com.fluentcode.ejb.remote.TaskSchedulerRemote");
		if("scheduleTask".equals(args[0])){
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.SECOND, 15);
			for(int i = 1; i<= 50; i++){
				calendar.add(Calendar.MILLISECOND, 100);
				scheduler.scheduleTask(calendar.getTime(), "("+i+")");
			}
			System.out.println("The task was scheduled");
		}else if("cancelTask".equals(args[0])){
			List<String> messages = scheduler.cancelTask();
			System.out.println(messages);
		}
	}

}
