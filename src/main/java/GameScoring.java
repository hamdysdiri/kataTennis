public class GameScoring {

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
            if (player == 'A') {
                this.scorePlayerOne ++;
            }
            if (player == 'B') {
                this.scorePlayerTwo ++;
            }
        }
    }


    public String printTheScore() {
        if (this.scorePlayerOne == this.scorePlayerTwo && this.scorePlayerTwo >= 3) {
            this.isDeuce = true;
            return "deuce";
        }
        
        if (this.scorePlayerOne - this.scorePlayerTwo == 1 && this.scorePlayerOne >=3){
            this.isAdvantageA = ! this.isAdvantageA;
            this.isAdvantageB = false;
            return "advantage for A";
        } else if (this.scorePlayerTwo - this.scorePlayerOne == 1 && this.scorePlayerOne >=3){
            this.isAdvantageA = false;
            this.isAdvantageB = ! this.isAdvantageB;
            return "advantage for B";
        }

        if (this.scorePlayerOne >= 4 && !isDeuce && !isAdvantageB) {
            return "Player A wins the game";
        } else if  (this.scorePlayerTwo >= 4 && !isDeuce && !isAdvantageA) {
            return "Player B wins the game";
        }
        return "Player A : "+POINTS[Math.min(this.scorePlayerOne,3)]+" / Player B : "+POINTS[Math.min(this.scorePlayerTwo,3)]+"";
    }
}
