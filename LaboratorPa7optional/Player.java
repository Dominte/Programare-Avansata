import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

public abstract class Player implements Runnable {

    List<Token> tokenList = new ArrayList<>();
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
        this.tokenList.add(this.game.board.tokenList.get(number));
        this.game.board.RemoveTokenByNumber(number,numberOrder);

    }

    @Override
    public void run() {
        while (game.board.getSize() > 0 && game.duration > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.game.board.Sincronizare(game.getTura());
        }
        System.out.println("Game over for "+ this.getName().toLowerCase());
    }

    public abstract int PickToken();

}
