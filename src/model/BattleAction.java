package model;

public class BattleAction {
    public enum ActionType {
        MOVE, SWITCH
    }

    private final ActionType type;
    private final int targetIndex; // move (0-3) or roster (0-5)

    private BattleAction(ActionType type, int targetIndex) {
        this.type = type;
        this.targetIndex = targetIndex;
    }

    public static BattleAction createMove(int moveIndex) {
        return new BattleAction(ActionType.MOVE, moveIndex);
    }

    public static BattleAction createSwitch(int rosterIndex) {
        return new BattleAction(ActionType.SWITCH, rosterIndex);
    }

    public ActionType getType() {
        return type;
    }

    public int getTargetIndex() {
        return targetIndex;
    }
}
