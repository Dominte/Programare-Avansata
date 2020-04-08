import java.util.Random;

public class RandomPlayer extends Player {

    public RandomPlayer(String name) {
        super(name);
    }

    @Override
    public int PickToken() {
        int size = this.game.board.getSize();
        Random random = new Random();
        int var = random.nextInt(size);
        return var;

    }


}
