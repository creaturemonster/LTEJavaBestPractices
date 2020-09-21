package com.ltree.crs516.tasks;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.ltree.crs516.taskengine.TaskEngine;

/**
 * Client to the task engine. This is the class that
 * prepares and submits jobs to the task engine.
 * @author Crs516 Development Team
 * @version k4.
 *
 */
public class Client {

	private static final Logger logger = Logger.getLogger(Client.class.getName());

	/**
	 * Looks up task engine, instantiates CommandImpl and submits it 
	 * to task engine.
	 */
	public void prepareAndSubmitCommand() {
		Registry registry;
		try {
			// Find the engine in the registry.
			registry = LocateRegistry.getRegistry(TaskEngine.hostName);
			TaskEngine engine = (TaskEngine) registry.lookup(TaskEngine.bindName);
			logger.info("Engine located. ");
			
//TODO 1: Create an instance of CommandImpl. 
//Since this command is relatively simple we will not bother to use a separate Receiver.
		CommandImpl commandImpl=new CommandImpl();
			


//TODO 2: Submit the CommandImpl object you just created to the 
//TaskEngine called engine. 
		engine.submitTask(commandImpl);


		} catch (RemoteException e) {
			logger.log( Level.SEVERE,"Failed to get engine.", e);
		} catch (NotBoundException e) {
			logger.log( Level.SEVERE,"Nothing bound under the name "+TaskEngine.bindName, e);
		}
	}
}
