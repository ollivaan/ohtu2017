package ohtu;

import java.util.HashMap;
import java.util.Map;

public class TennisGame {
    
    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;
    
    private final Map<Integer, String> tieNames;
    private final Map<Integer, String> nameParts;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        
        tieNames = new HashMap<>();
        tieNames.put(0, "Love-All");
        tieNames.put(1, "Fifteen-All");
        tieNames.put(2, "Thirty-All");
        tieNames.put(3, "Forty-All");
        
        nameParts = new HashMap<>();
        nameParts.put(0, "Love");
        nameParts.put(1, "Fifteen");
        nameParts.put(2, "Thirty");
        nameParts.put(3, "Forty");
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            m_score1 += 1;
        else
            m_score2 += 1;
    }

    public String getScore() {
        if (m_score1==m_score2) return getTieName();
        
        if (m_score1>=4 || m_score2>=4)return getPlayerAlmostVictoriousName();
        
        return getOtherCases();
    }
    
    private String getTieName(){
        return tieNames.getOrDefault(m_score1, "Deuce");
    }
    
    private String getPlayerAlmostVictoriousName(){
        int minusResult = m_score1-m_score2;
        
        if (minusResult==1) return "Advantage player1";
        if (minusResult ==-1) return "Advantage player2";
        if (minusResult>=2) return "Win for player1";
        return "Win for player2";
    }
    
    private String getOtherCases(){
        return nameParts.get(m_score1) + "-"+ nameParts.get(m_score2);
    }
}