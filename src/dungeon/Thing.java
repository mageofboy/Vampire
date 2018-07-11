package dungeon;

public class Thing {
    protected int x;
    protected int y;
    protected int length;
    protected int height;
    protected String symbol = ".";

    public Thing(int x, int y, int length, int height) {
        this.x = x;
        this.y = y;
        this.length = length;
        this.height = height;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean moveN() {
        int placeholder = this.y - 1;
        boolean possible = validate(this.x, placeholder);
        if (possible) {
            this.y = placeholder;
            return  true;
        }   else {
            return false;
        }
    }
    public boolean moveW() {
        int placeholder = this.x - 1;
        boolean possible = validate(placeholder,this.y);
        if (possible) {
            this.x = placeholder;
            return  true;
        }   else {
            return false;
        }
    }
    public boolean moveE() {
        int placeholder = this.x + 1;

        boolean possible = validate(placeholder, this.y);
        if (possible) {
            this.x = placeholder;
            return  true;
        }   else {
            return false;
        }
    }
    public boolean moveS() {
        int placeholder = this.y + 1;
        boolean possible = validate(this.x, placeholder);
        if (possible) {
            this.y = placeholder;
            return  true;
        }   else {
            return false;
        }
    }
    @Override
    public String toString() {
        return this.symbol;
    }
    public boolean validate(int x, int y) {
        if (x < 0 || x >= this.length || y >= this.height || y < 0) {
            return false;
        }   else {
            return true;
        }
    }

}
