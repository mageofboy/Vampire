package dungeon;



import javax.smartcardio.CommandAPDU;
import java.util.*;

public class Dungeon {
    private int length;
    private int height;
    private int vampires;
    private int moves;
    private Player player;
    private Scanner reader = new Scanner(System.in);
    private List<Thing> position = new ArrayList<Thing>();
    private VampireTeam vampireteam;
    private boolean vampiresMove;

    public Dungeon(int length, int height, int vampires, int moves, boolean vampiresMove) {
        this.length = length;
        this.height = height;
        this.vampires = vampires;
        this.moves = moves;
        this.vampiresMove = vampiresMove;
        this.player = new Player(0,0,length,height);
        this.vampireteam = new VampireTeam(vampires, length, height, this.player);
    }
    public void run() {

        System.out.print(position());
        start();
        Board board = new Board(this.position, length, height);
        board.prints();

        while ( this.moves > 0) {
            moveChar();
            System.out.print(position());
            start();
            board = new Board(this.position, length, height);
            board.prints();
            if (win()) {
                System.out.println("YOU WIN");
                break;
            }
        }
        if (!win()) {
            System.out.println("YOU LOSE");
        }
    }
    public void moveChar() {
        System.out.print("Move char: ");
        String commands = reader.nextLine();
        this.moves -= 1;
        for (int i = 0; i < commands.length(); i++) {
            char command = commands.charAt(i);
            if (this.vampiresMove) {
                this.vampireteam.moveVampire();
            }
            if (command == 'w') {
                this.player.moveN();
            }   else if (command == 's') {
                this.player.moveS();
            }   else if (command == 'a') {
                this.player.moveW();
            }   else if (command == 'd') {
                this.player.moveE();
            }
            if ((this.vampireteam.getVampPosition().containsKey(this.player.getX() + "" +  this.player.getY()))) {
                this.vampireteam.removeVamp(this.player.getX() + "" +  this.player.getY());
                this.vampires -= 1;
            }

        }
    }
    public boolean win() {
        if (this.vampires == 0) {
            return true;
        }   else {
            return false;
        }
    }
    public String position() {
        String position = "";
        position += this.moves + "\n \n";
        position += this.player.getPosition() ;
        for (Vampire vampire: this.vampireteam.getVampireteam()) {
            position += "\n" + vampire.getPosition();
        }
        return position + "\n \n";
    }

    public void start() {
        this.position = new ArrayList<Thing>();
        Map<String,Vampire> map = this.vampireteam.getVampPosition();
        for (int y = 0; y < this.height; y++) {
            for (int x = 0; x < this.length; x++) {
                if (this.player.position().equals(x+""+y)) {
                    this.position.add(this.player);
                    if (this.vampireteam.getVampPosition().containsKey(x+""+y)) {
                        this.vampireteam.removeVamp(x+""+y);
                        this.vampireteam.updatePosition();
                        this.vampires -= 1;
                    }
                } else
                if (this.vampireteam.getVampPosition().containsKey(x+""+y)) {
                    this.position.add(this.vampireteam.getVampPosition().get(x+""+y));
                } else {
                    this.position.add(new Thing(x, y, this.length, this.height));
                }
            }
        }
    }
}
