import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameScoringSecondSolutionTest {

    GameScoringSecondSolution game;
    @Before
    public void setUp() {
        game = new GameScoringSecondSolution();

    }

    @Test
    public void player_one_player_two_deuce() {
        this.game.play("BBBAAA");
        assertEquals(this.game.printTheScoreSecondImplementation(), "Deuce");
    }

    @Test
    public void player_one_player_has_advantage() {
        this.game.play("BBBAAAA");
        assertEquals(this.game.printTheScoreSecondImplementation(), "advantage for A");
    }

    @Test
    public void player_two_player_has_advantage() {
        this.game.play("BBBAAAB");
        assertEquals(this.game.printTheScoreSecondImplementation(), "advantage for B");
    }

    @Test
    public void player_two_player_win_the_game() {
        this.game.play("BBBAAABAAA");
        assertEquals(this.game.printTheScoreSecondImplementation(), "Player A wins the game");
    }
}
