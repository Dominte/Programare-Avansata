import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class GameClient {

    public GameClient() throws IOException {
        String serverAddress = "127.0.0.1";
        int PORT=8100;

        try(
            Socket socket = new Socket(serverAddress,PORT);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))
        ){

            while(true) {
                Scanner keyboard = new Scanner(System.in);
                System.out.println("Enter a command");

                String command = keyboard.nextLine();

                if(command.equals("exit")){
                    out.println("stop");
                    System.out.println("Exiting program...");
                    break;}
                else
                    out.println(command);

                    String serverResponse= in.readLine();
                    System.out.println(serverResponse);

            }

        }catch(IOException e){
            System.out.println(e);
        }
    }
}
