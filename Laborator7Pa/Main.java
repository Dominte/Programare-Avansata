import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Player[] players = new Player[4];
        players[0] = new Player("First player");
        players[1] = new Player("Second player");
        players[2] = new Player("Third player");
        players[3] = new Player("Fourth player");
        int tokenNumber = 40;
        int previous = 0;
        int value;

        Token token;
        ArrayList<Token> tokenList = new ArrayList<>();
        for (int i = 1; i <= tokenNumber; i++) {
            Random random = new Random();
            value = random.nextInt(i)*2 + previous;

            if (value == 0) {
                tokenList.add(new Token(0, 500, true));

            } else {
                tokenList.add(new Token(value, 500, false));

            }

        }

        Board board = new Board(tokenList);
        System.out.println(board.tokenList.size());
        Game game = new Game(board, tokenNumber, players);

        game.StartGame();


    }
}
