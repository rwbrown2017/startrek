package Tests;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import GameObjects.Game;

public class TestGame {

    private final int INIT_KLINGONS = 2;
    private final int INIT_STARBASES = 5;
    private final int INIT_STARDATES = 10;
    Game game;

    @Before
    public void initGame() {
        game = new Game(INIT_KLINGONS, INIT_STARBASES, INIT_STARDATES);
    }

    @Test
    public void testKlingonCount() {
        Assert.assertEquals(game.getKlingons(), INIT_KLINGONS);
    }

}
