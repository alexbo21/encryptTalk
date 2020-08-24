

import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;



public class Skt {
	public static boolean server (int port, Server method){
		try
		{
			System.out.println("Waiting for Connections");
			ServerSocket ss = new ServerSocket(port);
			Socket soc = ss.accept();

			System.out.println("Connection Established!");

			BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
			String input =  in.readLine();
			String sockOut = Server.script(input);
			PrintWriter out = new PrintWriter(soc.getOutputStream(), true);
			out.println(sockOut);

			ss.close();

			return true;

			


		}
		catch (Exception e)
		{
			return false;
		}
	}
}