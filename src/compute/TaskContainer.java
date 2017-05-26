package compute;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class TaskContainer {
	private List<Compute> taskList;
	
	public TaskContainer(){
		taskList = new ArrayList<Compute>();
	}
	
	public void addTask(Compute task){
		taskList.add(task);
	}
	
	/**
	 * Connects the task with the client system that will run task
	 * @return
	 */
	private int connect(){
		Socket sock;
		//Choose node
			//localhost
		//Connect to node
		try{
			sock = new Socket(InetAddress.getLocalHost(), 5001);
		    ObjectOutputStream oos = new ObjectOutputStream(sock.getOutputStream());
			//Write task to stream
		    oos.writeObject(taskList.get(0));
		    //ObjectInputStream ois = new ObjectInputStream(sock.getInputStream());
		    sock.close();
		}catch(IOException e){
	    	e.printStackTrace();
	    }
		//wait for task to complete
		//return error code
		return 0;
	}
	
	public void execute(){
		connect();
	}
	
	/**
	 * Waits for other tasks to complete
	 * @return
	 */
	public int join(){
		return 0;
	}
}
