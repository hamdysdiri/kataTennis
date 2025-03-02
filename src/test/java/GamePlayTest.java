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
        assertEquals(this.game.printTheScore(), "Player A : 15 / Player B : 0");
    }

    @Test
    public void player_one_score_TWO_point() {
        this.game.play("AA");
        assertEquals(this.game.printTheScore(), "Player A : 30 / Player B : 0");
    }

    @Test
    public void player_one_score_three_straight_point() {
        this.game.play("AAA");
        assertEquals(this.game.printTheScore(), "Player A : 40 / Player B : 0");
    }

    @Test
    public void player_one_score_Fourth_straight_point() {
        this.game.play("AAAA");
        assertEquals(this.game.printTheScore(), "Player A wins the game");
    }

    @Test
    public void player_two_score_Fourth_straight_point() {
        this.game.play("BBBB");
        assertEquals(this.game.printTheScore(), "Player B wins the game");
    }

    @Test
    public void player_one_two_has_deuce() {
        this.game.play("BBBAAA");
        assertEquals(this.game.printTheScore(), "deuce");
    }

    @Test
    public void player_one_has_advantage() {
        this.game.play("BBBAAAA");
        assertEquals(this.game.printTheScore(), "advantage for A");
    }

    /*        BBBB 15 30 40
        AAAA    15 30 40
*/
    @Test
    public void player_one_has_advantage_then_lose_it() {
        this.game.play("BBBAAAAB");
        assertEquals(this.game.printTheScore(), "deuce");
    }

    @Test
    public void player_one_has_advantage_then_win() {
        this.game.play("BBBAAAAA");
        assertEquals(this.game.printTheScore(), "Player A wins the game");
    }
}
