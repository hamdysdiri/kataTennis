public class GameScoring {

    private static final int[] POINTS = {0, 15, 30, 40};


    public String play(String sequencePlayer) {
        if (sequencePlayer.isBlank() && sequencePlayer.isEmpty()) {
            print("Should have two players");
            throw new IllegalArgumentException("Should have two players");
        }
        if (!sequencePlayer.matches("[AB]*")) {
            throw new IllegalArgumentException("Invalid input: Sequence should only contain 'A' or 'B'");
        }

        for (char player : sequencePlayer.toCharArray()) {
            if (player == 'A') {
                scorePoint();
            }
            if (player == 'B') {
                
            }
        }
        return sequencePlayer;
    }

    private void scorePoint() {
    }

    private void print(String message) {
        System.out.println(message);
    }
}
