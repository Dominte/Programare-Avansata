import java.util.Timer;
import java.util.TimerTask;

public class Game {
    Board board;
    int tokenNumber;
    Player[] players;
    Thread[] threads;
    int tura;
    int timerSecunde = 0;
    int duration=20;


    public int getTura() {
        return tura;
    }

    public void setTura(int tura) {
        this.tura = tura;
    }

    public void urmTura() {
        this.tura = this.tura + 1;
        this.tura = this.tura % players.length;
    }

    public Game(Board board, int tokenNumber, Player[] players) {
        this.board = board;
        this.board.setGame(this);
        this.tokenNumber = tokenNumber;
        this.players = players;
    }


    public void StartGame() throws InterruptedException {
        this.setTura(0);

        this.threads = new Thread[players.length ];
        Timer timer = new Timer("timekeeper", true);

        TimerTask displayTimer = new TimerTask() {
            @Override
            public void run() {
                duration=duration-10;
                System.out.println("Time left: " + duration);
                if(duration==0 || board.getSize()==0) {
                    timer.cancel();

                }
            }
        };

        timer.schedule(displayTimer, 0, 10000);


        System.out.println("Start Game \n");
        for (int i = 0; i < players.length; i++) {
            threads[i] = new Thread(players[i]);
            players[i].setGame(this);
            players[i].setNumberOrder(i);
            threads[i].start();
        }


    }
}
