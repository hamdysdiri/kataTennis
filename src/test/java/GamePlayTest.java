import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

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
}
