import java.util.Random;
import java.util.TreeSet;

public class Player implements Runnable {


    String name;
    Game game;
    int numberOrder;

    public Player(String name) {
        this.name = name;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public int getNumberOrder() {
        return numberOrder;
    }

    public void setNumberOrder(int numberOrder) {
        this.numberOrder = numberOrder;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void Extract(Token token) {
        this.game.board.RemoveToken(token);
    }

    public void ExtractByNumber(int number) {
        this.game.board.RemoveTokenByNumber(number);
    }

    @Override
    public void run() {
        while (game.board.getSize() > 0) {
            this.game.board.Sincronizare(game.getTura());
        }
        System.out.println("Game over for "+ this.getName().toLowerCase());
    }


}
