package client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Send {
    public static void main(String[] args){
        while(true){
            String out = scnr("Type message and press enter to send:");
            cnt("localhost",9000, "[S]{"+out+"}");

        }
    }


    public static String cnt (String host, int port, String request){
		try
		{
			System.out.println("Client Started");
			Socket soc = new Socket(host, port);

			PrintWriter out = new PrintWriter(soc.getOutputStream(), true);
			out.println(request);

			BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
			System.out.println(in.readLine());

			soc.close();
			
			return in.readLine();
		}
		catch (Exception e)
		{
			return "err";
        }
    }

    public static String scnr (String question){
        Scanner in = new Scanner(System.in);

        System.out.println(question);
        String str = in.nextLine();
        return str; 
    }
}