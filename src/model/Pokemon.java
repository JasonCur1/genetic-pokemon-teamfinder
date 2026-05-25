package model;

import java.util.Arrays;

public class Pokemon {
    private final String speciesName;
    private final Type type1;
    private final Type type2; // can be null

    private final int maxHp;
    private int currentHp;
    private final int attack;
    private final int defense;
    private final int speed;

    private final Move[] moves;

    public Pokemon(String speciesName, Type type1, Type type2, int maxHp, int attack, int defense,
            int speed, Move[] moves) {
        this.speciesName = speciesName;
        this.type1 = type1;
        this.type2 = type2;
        this.maxHp = maxHp;
        this.currentHp = maxHp;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.moves = moves;
    }

    public String getSpeciesName() {
        return speciesName;
    }

    public Type getType1() {
        return type1;
    }

    public Type getType2() {
        return type2;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getSpeed() {
        return speed;
    }

    public Move[] getMoves() {
        return moves;
    }

    public boolean isFainted() {
        return this.currentHp <= 0;
    }

    public void takeDamage(int amount) {
        this.currentHp = Math.max(0, this.currentHp - amount);
    }

    // Deep copy for genetic
    public Pokemon clone() {
        Move[] clonedMoves = Arrays.stream(this.moves)
                .map(Move::clone)
                .toArray(Move[]::new);
        Pokemon copy = new Pokemon(speciesName, type1, type2, maxHp, attack, defense, speed, clonedMoves);
        copy.currentHp = this.currentHp;
        return copy;
    }
}
