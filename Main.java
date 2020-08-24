import java.io.File;
import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static String fileroot;
    public static int request;
    public static int msg = 0;
    public static void main(String[] args){

        Server func = new Server();

        LocalDate localDateClass = LocalDate.now(); String localDate = localDateClass.toString();
        LocalTime localTimeClass = LocalTime.now(); String localTime = localTimeClass.toString();
        
        fileroot = localDate + ";" + localTime + "/";
        mkDir(fileroot);

        while(true){ request++;
            boolean socketStatus = Skt.server(5000, func);

            
            if(socketStatus == true){
                System.out.println("Served Sucsessfully");
            } else {
                System.out.println("Error while serving");
            }
        }
    }

    public static void mkDir (String path) {
        //Creating a File object
        File file = new File(path);
        //Creating the directory
        boolean bool = file.mkdirs();
        if(bool){
           System.out.println("Directory created successfully");
        }else{
           System.out.println("Sorry couldnt create specified directory");
        }
     }
}