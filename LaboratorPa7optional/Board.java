import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Board {
    List<Token> tokenList = new ArrayList<>();
    Game game;

    public void RemoveToken(Token token){
        this.tokenList.remove(token);
    }
    public void RemoveTokenByNumber(int number,int i){
        this.game.players[i].tokenList.add(this.game.board.tokenList.get(number));
        this.tokenList.remove(number);
    }
    public void AddToken(Token token){
        this.tokenList.add(token);
    }
    public Token getTokenByNumber(int number){
        return this.tokenList.get(number);

    }

    public Board(ArrayList<Token> tokenList) {
        this.tokenList = tokenList;
    }

    public int getSize(){
        return this.tokenList.size();
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public synchronized void Sincronizare(int i) {

        while (this.game.players[i].getNumberOrder() !=game.getTura() && game.board.getSize()>0 && game.duration>0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (this.getSize() > 0) {

            int numarToken = this.game.players[i].PickToken();

            if(numarToken>=0) {

                System.out.println(this.game.players[game.getTura()].getName() + " removed the " + numarToken + " Token with value " + (this.game.board.tokenList.get(numarToken)).value);
                this.game.board.RemoveTokenByNumber(numarToken, i);
                System.out.println("Pieces left: " + this.getSize());
                game.urmTura();
            }
           else
                System.out.println("No more pieces to pull ");
            notifyAll();
        }
    }

}
