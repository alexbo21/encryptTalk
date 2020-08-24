package client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class log {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 9000;

        int last = 0;

        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            int pingRes = Integer.valueOf(cnt(host,port, "[L]{ASK}"));



            if(pingRes > last){
                for(int i = (last + 1); i != (pingRes + 1); i++){
                    System.out.println(cnt(host,port, "[A]{"+i+"}"));
                }

                last = pingRes;
            } else if(pingRes < 0){
                System.out.println("ERROR");
            }

        }
    }
    


    
    public static String cnt (String host, int port, String request){
		try
		{
			Socket soc = new Socket(host, port);

			PrintWriter out = new PrintWriter(soc.getOutputStream(), true);
			out.println(request);

			BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
			String returnVlu = in.readLine();

			soc.close();
			
			return returnVlu;
		}
		catch (Exception e)
		{
			return "-1";
        }
    }
}