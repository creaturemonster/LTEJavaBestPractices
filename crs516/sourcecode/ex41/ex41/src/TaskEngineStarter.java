import static com.ltree.crs516.taskengine.TaskEngine.bindName;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NoSuchObjectException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.ltree.crs516.taskengine.TaskEngineImpl;

@SuppressWarnings("serial")
public final class TaskEngineStarter extends JFrame {

	private final Logger logger = Logger.getLogger(getClass().getName());
	private final JButton startButton = new JButton("Start");
	private final JButton stopButton = new JButton("Stop");	
	private Registry registry;

	public TaskEngineStarter() {
		// Create GUI for control buttons.
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Task Engine Control");
		setLayout(new GridLayout(1, 2, 5, 5));
		startButton.addActionListener(new startButtonListener());
		add(startButton);
		stopButton.addActionListener(new stopButtonListener());
		addWindowListener(new WindowCloser());
		add(stopButton);
		startButton.setEnabled(true);
		stopButton.setEnabled(false);
		setLocation(300, 100);
		setSize(250, 100);
		setVisible(true);
	}

	private class WindowCloser extends WindowAdapter {

		@Override
		public void windowClosing(WindowEvent e) {
			shutDown();
		}
	}

	private class startButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				registry = LocateRegistry.createRegistry(1099);
				logger.info("RMI registry ready.");
				// The next line binds a proxy in rmiregistry for client to look up.
				// You will study the Proxy pattern later in the course.
				Naming.rebind(bindName, new TaskEngineImpl());
				logger.info("Task engine is registered in rmiRegistry");
			} catch (MalformedURLException exc) {
				logger.log(Level.SEVERE,"Bind name is malformed. ", exc);
			} catch (IOException exc) {
				if (exc.getMessage().contains("Port already in use:")) {
					logger.log(Level.SEVERE,"Failed to start engine because there is another taskengine running on that port");
					return;
				}
				logger.log(Level.SEVERE,"Failed to start engine", exc);
				return;
			}
			startButton.setEnabled(false);
			stopButton.setEnabled(true);
		}
	}

	private class stopButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			startButton.setEnabled(false);
			shutDown();
		}
	}

	public void shutDown() {
		// Shut down the registry.
		try {
			UnicastRemoteObject.unexportObject(registry, true);
		} catch (NoSuchObjectException e) {
			logger.info("Registry is already closed");
		}
		logger.info("Registry is closed");
		startButton.setEnabled(true);
		stopButton.setEnabled(false);
	}

	public static void main(String[] args) {
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}
		new TaskEngineStarter();
	}

}
