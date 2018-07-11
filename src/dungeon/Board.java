package dungeon;

import java.util.List;

public class Board {
    private List<Thing> board;
    private int height;
    private int length;
    public Board(List<Thing> things, int length, int height) {
        this.board = things;
        this.height = height;
        this.length = length;
    }

    public void prints() {
        String boardgame = "";
        int currHeight = 0;
        int currLength = 0;

        for (int height = 0; height < this.height; height++ ) {
            for (int length = 0; length < this.length; length++) {

                for (Thing x: this.board) {
                    if ((x.getX() == length) && (x.getY() == height)) {
                        boardgame += x;
                        currLength++;

                    }
                }
            }
            boardgame += "\n";
        }
        System.out.println(boardgame);
    }
}
