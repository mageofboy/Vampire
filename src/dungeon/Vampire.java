package dungeon;

import java.util.List;
import java.util.Random;

public class Vampire extends  Thing {
    private String symbol = "v";
    private Random random = new Random();
    public Vampire(int x, int y, int length, int height) {
        super(x,y, length, height);
    }

    @Override
    public String toString() {
        return this.symbol;
    }
    public boolean moveN() {
        return super.moveN();
    }
    public boolean moveW() {
        return super.moveW();
    }
    public boolean moveE() {
        return super.moveE();
    }
    public boolean moveS() {
        return super.moveS();
    }
    public String getPosition() {
        return this.symbol + " " + x + " " + y;
    }

    public void moveRandom(List<Vampire> position) {

        int move = random.nextInt(4);
        int x = this.x;
        int y = this.y;
        if (move == 0) {
            y -=1;
            if (this.overlap(position,x,y)) {
                moveN();
            }
        }   else if (move == 1) {
            x -=1;
            if (this.overlap(position,x,y)) {
            moveW();}
        }   else if (move == 2) {
            x +=1;
            if (this.overlap(position,x,y)) {
            moveE(); }
        }   else if (move== 3) {
            y += 1;
            if (this.overlap(position,x,y)) {
            moveS(); }
        }
    }
    public boolean overlap(List<Vampire> position, int x, int y) {
        boolean open = true;
        for (Vampire vampire: position) {
            if ((vampire.getX() == x) && (vampire.getY() == y)) {
                open = false;
            }
        }
        return open;
    }

}
