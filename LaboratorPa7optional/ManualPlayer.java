import java.sql.SQLOutput;
import java.util.Scanner;

public class ManualPlayer extends Player {
    public ManualPlayer(String name) {
        super(name);
    }

    @Override
    public int PickToken() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println(this.getName()+" please insert a number: ");
        int var=keyboard.nextInt();
        int m=this.game.board.getSize();
        return var%m;
    }
}
