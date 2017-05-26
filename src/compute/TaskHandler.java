package compute;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.LinkedList;


public class TaskHandler<T> {
	
	String ipAddr, port;
	LinkedList<Task<T>> taskQueue;
	
	public TaskHandler(String ipAddr, String port){
		this.ipAddr = ipAddr;
		this.port = port;
		this.taskQueue = new LinkedList<Task<T>>();
	}
	
	public void add(Task<T> task){
		taskQueue.add(task);
	}
	
	public T start(){
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        T value = null;
        try {
            String name = "Compute";
            Registry registry = LocateRegistry.getRegistry(ipAddr);
            Compute comp = (Compute) registry.lookup(name);
            value = comp.executeTask(taskQueue.pop());
        } catch (Exception e) {
            System.err.println("TaskHandler exception:");
            e.printStackTrace();
        }
		return value;
	}

}
