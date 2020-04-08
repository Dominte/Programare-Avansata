import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Player[] players = new Player[4];
        players[0] = new RandomPlayer("First player");
        players[1] = new ManualPlayer("Second player");
        players[2] = new SmartPlayer("Third player");
        players[3] = new RandomPlayer("Fourth player");
        int tokenNumber = 40;
        int previous = 0;
        int value;

        Token token;
        ArrayList<Token> tokenList = new ArrayList<>();
        for (int i = 1; i <= tokenNumber; i++) {
            Random random = new Random();
            value = random.nextInt(i)*2 + previous+1;
            previous=value;

            if (value == 0) {
                tokenList.add(new Token(0, 1000, true));

            } else {
                tokenList.add(new Token(value, 1000, false));

            }

        }

        Board board = new Board(tokenList);
        System.out.println(board.tokenList.size());
        Game game = new Game(board, tokenNumber, players);


        System.out.println(tokenList);

        game.StartGame();

        System.out.println(players[0].tokenList.toString());

    }
}
