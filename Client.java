
/**
 *
 * @author Federico Cocco
 */
import java.util.Scanner;
import java.net.*;
import java.io.*;

public class Client {

    public static void main(String[] args) throws Exception {

        //Exceptions handling
        try {

            //Open connection towards clients 
            System.out.println("Attempting socket connection to localhost:1337");
            InetAddress address = InetAddress.getByName("localhost");

            //Open a new socket belonging to one client towards a server at a specific address and port
            Socket client = new Socket("localhost", 1337);
            System.out.println("Client ready.\n");

            //Create classes to access outputs from the clients and write
            InputStreamReader reader = new InputStreamReader(client.getInputStream());
            BufferedReader inbox = new BufferedReader(reader);
            OutputStreamWriter writer = new OutputStreamWriter(client.getOutputStream());
            BufferedWriter outbox = new BufferedWriter(writer);

            //Ask the user to type 
            String inputStr = userInput();
            System.out.println("user selected the letter : " + inputStr);

            //Sends the user's choice off to the server
            outbox.write(inputStr + "\n", 0, inputStr.length() + 1);
            //This method forces any buffered output bytes to be written out
            outbox.flush();

            //Receives result from server
            String playerResult = inbox.readLine();
            System.out.println(playerResult);

            //Exceptions are handled if no connections are present or program times out  
        } catch (IOException e) {
            System.out.println(e);
        }
    }

//This method allows the user entering an input from the keyboard and store it as a string
    private static String userInput() {
        Scanner in = new Scanner(System.in);
        String inputStr = null;
        do {
            System.out.print("Enter R for Rock, S for Scissor or P for Paper: ");
            inputStr = in.next();
        } while (!("R".equals(inputStr)) && !("S".equals(inputStr)) && !("P".equals(inputStr)));
        return inputStr;
    }
}
