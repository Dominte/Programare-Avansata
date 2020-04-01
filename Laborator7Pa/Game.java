public class Game {
    Board board;
    int tokenNumber;
    Player[] players;
    Thread[] threads;
    int tura;

    public int getTura() {
        return tura;
    }

    public void setTura(int tura) {
        this.tura = tura;
    }
    public void urmTura(){
        this.tura=this.tura+1;
        this.tura=this.tura%players.length;
    }

    public Game(Board board, int tokenNumber, Player[] players) {
        this.board = board;
        this.board.setGame(this);
        this.tokenNumber = tokenNumber;
        this.players = players;
    }

    public void StartGame() {
        this.setTura(0);
        this.threads = new Thread[players.length];
        System.out.println("Start Game \n");
        for (int i = 0; i < players.length; i++) {
            threads[i] = new Thread(players[i]);
            players[i].setGame(this);
            players[i].setNumberOrder(i);
            threads[i].start();
        }


    }
}
