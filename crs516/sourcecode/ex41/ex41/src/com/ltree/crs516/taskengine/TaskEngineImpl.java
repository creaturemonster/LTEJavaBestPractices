package com.ltree.crs516.taskengine;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * The invoker in a command design pattern.
 * 
 * @author crs516 development team.
 * @version k4
 * 
 */
@SuppressWarnings("serial")
//TODO 1:
//Make this class implement TaskEngine 
 
public final class TaskEngineImpl extends UnicastRemoteObject implements TaskEngine{

	/**
	 * The code in the constructor is for communication.
	 */
	public TaskEngineImpl() throws RemoteException {}

	
//TODO 2:Add the submitTask(Command command) method and in it call the 
//run() method of the Command object that is input to the method
public synchronized void submitTask(Command command) {
	command.run();
}

}

