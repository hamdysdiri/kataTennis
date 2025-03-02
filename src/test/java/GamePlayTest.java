import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class GamePlayTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    GameScoring game;
    @Before
    public void setUp() {
        game = new GameScoring();

    }

    @Test
    public void game_have_only_two_player() {
        assertThrows(IllegalArgumentException.class, () -> {
            this.game.play("AABBC");
        });
    }

    @Test
    public void player_one_score_a_point() {
        this.game.play("A");
        assertEquals(this.game.print(), "15");
    }
}
