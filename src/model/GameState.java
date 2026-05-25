package model;

import java.util.ArrayList;
import java.util.List;

public class GameState {
    private final Team playerA;
    private final Team playerB;
    private int turnCount;

    public GameState(Team playerA, Team playerB) {
        this.playerA = playerA;
        this.playerB = playerB;
        turnCount = 1;
    }

    public boolean isGameOver() {
        return playerA.isDefeated() || playerB.isDefeated();
    }

    // Generates all legal actions for a players team
    // MCTS relies on this heavily to expand tree nodes
    public List<BattleAction> getLegalActions(Team team) {
        List<BattleAction> actions = new ArrayList<>();

        if (!team.getActive().isFainted()) {
            for (int i = 0; i < team.getActive().getMoves().length; i++) { // iterate through moves for active pokemon
                if (team.getActive().getMoves()[i].getCurrentPp() > 0) { // ensure pp > 0
                    actions.add(BattleAction.createMove(i));
                }
            }
        }

        for (int i = 0; i < team.getRoster().length; i++) {
            if (i != team.getActiveIndex() && !team.getRoster()[i].isFainted()) {
                actions.add(BattleAction.createSwitch(i));
            }
        }

        return actions;
    }

    public Team getPlayerA() {
        return playerA;
    }

    public Team getPlayerB() {
        return playerB;
    }

    public int getTurnCount() {
        return turnCount;
    }

    public void incrementTurn() {
        this.turnCount++;
    }

    public GameState clone() {
        GameState copy = new GameState(this.playerA.clone(), this.playerB.clone());
        copy.turnCount = this.turnCount;
        return copy;
    }
}
