public class GameScoring {

    private static final int[] POINTS = {0, 15, 30, 40};
    private int scorePlayerOne = 0;
    private int scorePlayerTwo = 0;
    private boolean isDeuce = false;

    private boolean advantageA = false;

    private boolean advantageB = false;

    public String play(String sequencePlayer) {
        if (sequencePlayer.isBlank() && sequencePlayer.isEmpty()) {
            throw new IllegalArgumentException("Should have two players");
        }
        if (!sequencePlayer.matches("[AB]*")) {
            throw new IllegalArgumentException("Invalid input: Sequence should only contain 'A' or 'B'");
        }

        for (char player : sequencePlayer.toCharArray()) {
            if (player == 'A') {
                scorePoint(player);
            }
            if (player == 'B') {
            }
        }
        return sequencePlayer;
    }

    private void scorePoint(char player) {
        if (player == 'A') {
            this.scorePlayerOne ++;
        }
        if (player == 'B') {
            this.scorePlayerTwo ++;
        }
    }


    public String print() {
        return String.valueOf(POINTS[this.scorePlayerOne]);
    }
}
