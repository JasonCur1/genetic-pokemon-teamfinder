package model;

import java.util.Arrays;

public class Team {
    private Pokemon[] roster;
    private int activeIndex; // currently battling pokemon

    public Team(Pokemon[] roster) {
        this.roster = roster;
        this.activeIndex = 0;
    }

    public Pokemon getActive() {
        return roster[activeIndex];
    }

    public void setActiveIndex(int index) {
        if (index < 0 || index >= roster.length) {
            throw new IllegalArgumentException("Out of bounds");
        } else if (roster[index].isFainted()) {
            throw new IllegalArgumentException("Pokemon is fainted");
        }

        this.activeIndex = index;
    }

    public boolean isDefeated() {
        return Arrays.stream(roster).allMatch(Pokemon::isFainted); // double colon refers to method without executing
                                                                   // it. Essentially just passing the method I want the
                                                                   // stream to use here. Cool
    }

    public Pokemon[] getRoster() {
        return this.roster;
    }

    public int getActiveIndex() {
        return activeIndex;
    }

    public Team clone() {
        Pokemon[] clonedRoster = Arrays.stream(this.roster).map(Pokemon::clone).toArray(Pokemon[]::new);
        Team copy = new Team(clonedRoster);
        copy.activeIndex = this.activeIndex;
        return copy;
    }
}
