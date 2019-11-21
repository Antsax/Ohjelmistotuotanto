package ohtu;

import ohtu.Player;

public class TennisGame {
    
    private Player player1;
    private Player player2;

    public TennisGame(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
    }

    public void wonPoint(String playerName) {
        if (player1.getName().equals( playerName ))
            player1.addPoint();
        else
            player2.addPoint();
    }

    public String call(int points) {
        String call;
        switch(points) {
            case 0:
                call = "Love";
                break;

            case 1:
                call = "Fifteen";
                break;

            case 2:
                call = "Thirty";
                break;

            case 3:
                call = "Forty";
                break;

            default:
                call = "Deuce";
                break;
        }

        return call;
    }

    public String getScore() {
        String scorePlayerOne = call(player1.getScore());
        String scorePlayerTwo = call(player2.getScore());

        if (player1.getScore() >= 4 || player2.getScore() >=4)
        {
            int minusResult = player1.getScore() - player2.getScore();
            if (minusResult==1) return "Advantage player1";
            else if (minusResult == 0) return "Deuce";
            else if (minusResult ==-1) return "Advantage player2";
            else if (minusResult>=2) return "Win for player1";
            else return "Win for player2";
        }

        if (scorePlayerOne.equals(scorePlayerTwo)) {
            return scorePlayerOne + "-All";
        }

        return scorePlayerOne + "-" + scorePlayerTwo;
    }
}