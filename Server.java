import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Server {
    public static void main(String[] args){
        System.out.println(script("[L]{Hello World}"));
    }

    public static String script(String input){



        //FORMAT:
        // SEND:   [s]{Message}
        // ASK MESSAGE:    [a]{(int: Last recorded message)}
        // LAST MESSAGE: [L]

        String[] inputSplit = input.split("");

        String message = "";

        for(int i = 4; i != (inputSplit.length - 1); i++){
            message = message + inputSplit[i];
            
        }

        char inV = input.charAt(1);

        if(inV == 'S'){
          Main.msg++;
            makeFile(Main.fileroot + Main.msg);
            writeToFile(Main.fileroot + Main.msg, message);
            return "{[DONE]}";
        } else if (inV == 'A') {
            try{
              return readFile(Main.fileroot + message);
            } 
            catch (Exception e){
                return "{[NORETURN]}";
            } 
        } else if (inV == 'L') {
            return Integer.toString(Main.msg);
        } else {
            return "{ERROR + "+inputSplit[1]+"}";
        }
    }


        public static void makeFile(String filename) {
          try {
            File myObj = new File(filename);
            if (myObj.createNewFile()) {
              System.out.println("File created: " + myObj.getName());
            } else {
              System.out.println("File already exists.");
            }
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
        }

        public static void writeToFile(String filename, String text) {
            try {
              FileWriter myWriter = new FileWriter(filename);
              myWriter.write(text);
              myWriter.close();
              System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
              System.out.println("An error occurred.");
              e.printStackTrace();
            }
        }

        public static String readFile (String filename) {
            try {
              File myObj = new File(filename);
              Scanner myReader = new Scanner(myObj);
              String data = "";
              while (myReader.hasNextLine()) {
                data = myReader.nextLine();
              }
              myReader.close();
              return data;
            } catch (FileNotFoundException e) {
              System.out.println("An error occurred.");
              e.printStackTrace();
              return "messageError404>>_4";
            }
          }
}