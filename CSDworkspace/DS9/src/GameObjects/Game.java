package GameObjects;

public class Game {

    private int klingons;
    private int starbases;
    private int stardates;

    public Game(int klingonsNum, int starbasesNum, int stardatesNum) {

        klingons = klingonsNum;
        starbases = starbasesNum;
        stardates = stardatesNum;
    }

    public int getKlingons() {
        return klingons;
    }

}
