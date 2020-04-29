import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread {
    private Socket socket = null;

    public void cancel() {
        interrupt();
    }

    public ClientThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            while (true) {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String request = in.readLine();
                if (request.equals("stop")) {
                    System.out.println("Client disconnected");
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    out.println("Server stopped");
                    socket.close();
                    cancel();
                } else {
                    String raspuns = "Commanda primita: " + request + "!";
                    System.out.println(raspuns);
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    out.println("Server received the request ...");
                }
            }

        } catch (IOException e) {
            System.out.println("Socket is closed");
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                System.out.println("Socket is closed");
            }
        }
    }
}
