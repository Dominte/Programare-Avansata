
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class GameServer {
    public static final int PORT = 8100;
    public int userIndex=0;

    public GameServer() throws IOException {
        ServerSocket serverSocket = null;
        try {
            System.out.println("Waiting for a client...");
            serverSocket = new ServerSocket(PORT);
            while (true) {

                userIndex++;
                Socket socket = serverSocket.accept();
                System.out.println("Client "+userIndex+" joined the server...");
                System.out.println("Waiting for another client...");
                new ClientThread(socket).start();
            }
        } catch (IOException e) {
            System.out.println("Quit");
        } finally {
            assert serverSocket != null;
            serverSocket.close();
        }
    }
}
