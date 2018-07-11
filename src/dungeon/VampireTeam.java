package dungeon;

import java.util.*;

public class VampireTeam {

    private Map<String,Vampire> vampPosition = new HashMap<String,Vampire>();
    private Random random = new Random();
    private int height;
    private int length;
    private int vampires;
    private List<String> closedposition = new ArrayList<String>();
    private Player player;


    public VampireTeam(int vampires, int length, int height, Player player) {
        this.height = height;
        this.length = length;
        this.vampires = vampires;
        this.addVampires();
        this.player = player;
    }
    public void addVampires() {
        int x;
        int y;
        for (int i = 0; i < this.vampires; i++) {
            while (true) {
                x = random.nextInt(this.length );
                y = random.nextInt(this.height);
                if (!(x + "" + y).equals("00")) {
                    if (!this.closedposition.contains(x + "" + y)) {
                        break;
                    }
                }
            }
            this.vampPosition.put(x + "" + y,new Vampire(x,y, this.length,this.height));
            this.closedposition.add(x + "" + y);
        }
    }

    public void moveVampire() {
        this.closedposition = updatePosition();
        for (Vampire vampire: this.vampPosition.values()) {
            vampire.moveRandom(vampireTeam());
            this.closedposition = updatePosition();
        }
    }
    public List<Vampire> vampireTeam() {
        List<Vampire> vampteam = new ArrayList<Vampire>();
        for (Vampire vampire: this.vampPosition.values()) {
            vampteam.add(vampire);
        }
        return vampteam;
    }
    public List<Vampire> getVampireteam() {
        return vampireTeam();
    }
    public Map<String,Vampire> getVampPosition() {
        return this.vampPosition;
    }

    public List<String> updatePosition() {
        List<String> newposition = new ArrayList<String>();
        Map<String,Vampire> newpair = new HashMap<String,Vampire>();
        for (Vampire vampire: this.vampPosition.values()) {
            newposition.add(vampire.getX() + "" + vampire.getY());
            newpair.put(vampire.getX() + "" + vampire.getY(), vampire);
        }
        this.vampPosition = newpair;
        return newposition;

    }
    public void removeVamp(String location) {
        this.vampPosition.remove(location);


    }
}
