package client;

import java.math.BigDecimal;

import exampleTasks.Pi;

public class Client {
    public static void main(String args[]) {
    	Pi task = new Pi(Integer.parseInt(args[1]));
    	TaskHandler<BigDecimal> th = new TaskHandler<BigDecimal>(args[0], args[1]);
    	th.add(task);
    	Object result = th.start();
    	System.out.println((BigDecimal) result );
    }    
}
