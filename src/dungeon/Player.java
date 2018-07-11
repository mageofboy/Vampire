package dungeon;

public class Player extends  Thing{
    private String symbol = "@";

    public Player(int x, int y, int length, int height) {
        super(x,y, length, height);
    }

    public String getPosition() {
        return this.symbol + " " + x + " " + y;
    }
    public String position() {
        return this.x + "" + this.y;
    }

    @Override
    public String toString() {
        return  this.symbol;
    }
}
