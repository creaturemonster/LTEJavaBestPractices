import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;

public class SecurityConf {
	public static void main(String[] args) {
		new SecurityConf().configure();
	}
	private void configure() {
		File policyFile = new File("wod.policy");
		System.out.println("Writing wod.policy file");
		try (PrintWriter writer = new PrintWriter(new FileWriter(policyFile));) {
			InetAddress localhost = InetAddress.getLocalHost();
			String hostname = localhost.getHostName();
			writer.write("grant {\n"
					+ "   permission java.net.SocketPermission \"127.0.0.1:1099\", \"accept, connect, resolve\";\n"
					+ "   permission java.net.SocketPermission \"127.0.0.1:*\", \"accept, resolve\";\n"
					+ "   permission java.net.SocketPermission \"*\", \"connect, resolve\";\n"
					+ "   permission java.io.FilePermission \"./logs/logging.log\", \"read, write\";\n"
					+ "   permission java.io.FilePermission \"../data/*\", \"read\";\n"
					+ "   permission java.io.FilePermission \"../work\", \"read\";\n"
					+ "   permission java.io.FilePermission \"../work/-\", \"read, write, delete\";\n"
					+ "   permission java.io.FilePermission \"../codeTables/-\", \"read\";\n"
					+ "   permission java.lang.RuntimePermission \"getStackWalkerWithClassReference\";\n"
					+ "   permission java.net.SocketPermission \""+hostname+":*\", \"accept,resolve\";" + "\n};\n");
			writer.flush();
			System.out.println("Done!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
