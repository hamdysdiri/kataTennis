public class GameScoringSecondSolution {

    private static final int[] POINTS = {0, 15, 30, 40};
    private int scorePlayerOne = 0;
    private int scorePlayerTwo = 0;

    private boolean isDeuce = false;

    private boolean isAdvantageA = false;

    private boolean isAdvantageB = false;

    public void play(String sequencePlayer) {
        validateSequence(sequencePlayer);
        countScoreForBothPlayers(sequencePlayer);
    }

    private void validateSequence(String sequencePlayer) {
        if (sequencePlayer.isBlank() && sequencePlayer.isEmpty()) {
            throw new IllegalArgumentException("Should have two players");
        }
        if (!sequencePlayer.matches("[AB]*")) {
            throw new IllegalArgumentException("Invalid input: Sequence should only contain 'A' or 'B'");
        }
    }

    private void countScoreForBothPlayers(String sequencePlayer) {
        for (char player : sequencePlayer.toCharArray()) {
            updateScore(player == 'A');
        }
    }

    /**
     * Another implementation
     */
    private void updateScore(boolean isPlayerA) {
        if (this.isDeuce) {
            if (isPlayerA) {
                this.isAdvantageA = true;
                this.isAdvantageB = false;
                this.scorePlayerOne ++;
            } else {
                this.isAdvantageB = true;
                this.isAdvantageA = false;
                this.scorePlayerTwo ++;
            }
        } else if ((isPlayerA && this.isAdvantageB) || (!isPlayerA && this.isAdvantageA)) {
            this.isAdvantageA = false;
            this.isAdvantageB = false;
            this.isDeuce = true;
        } else {
            if (isPlayerA) {
                this.scorePlayerOne++;
            } else {
                this.scorePlayerTwo++;

            }
            if (this.scorePlayerOne == 3 && this.scorePlayerTwo == 3) {
                this.isDeuce = true;
            }
        }
    }

    public String printTheScoreSecondImplementation() {

        if (this.isDeuce && !this.isAdvantageA &!this.isAdvantageB ) {
            return "Deuce";
        } else if (this.scorePlayerOne - this.scorePlayerTwo >=2 && this.isAdvantageA) {
            return "Player A wins the game";
        } else if (this.scorePlayerTwo - this.scorePlayerTwo >=2 && this.isAdvantageB) {
            return "Player A wins the game";
        } else if (this.isAdvantageA) {
            return "advantage for A";
        } else if (this.isAdvantageB) {
            return "advantage for B";
        }
        else {
            return "Player A : " + POINTS[Math.min(scorePlayerOne, 3)] + " / Player B : " + POINTS[Math.min(scorePlayerTwo, 3)];
        }
    }
}
