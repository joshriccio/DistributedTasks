package client;

import java.math.BigDecimal;

import compute.TaskHandler;

import exampleTasks.Pi;
import exampleTasks.QuickSort;

public class Client {
    public static void main(String args[]) {
//    	Pi task = new Pi(Integer.parseInt(args[1]));
//    	TaskHandler<BigDecimal> th = new TaskHandler<BigDecimal>(args[0], args[1]);
//    	th.add(task);
//    	Object result = th.start();
//    	System.out.println((BigDecimal) result );
    	
    	String[] lines = {"z", "w", "r", "q", "t", "p"};
    	QuickSort task = new QuickSort(lines, 0, 5);
    	TaskHandler<String[]> th = new TaskHandler<String[]>(args[0], args[1]);
    	th.add(task);
    	Object result = th.start();
    	for(String s : (String[])result){
    		System.out.println(s);
    	}
    }    
}
