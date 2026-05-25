package model;

import java.util.EnumMap;

public enum Type {
    NORMAL, FIRE, WATER, GRASS, ELECTRIC;

    private static final EnumMap<Type, EnumMap<Type, Double>> effectiveness = new EnumMap<>(Type.class);

    static {
        // NORMAL attacking
        EnumMap<Type, Double> normal = new EnumMap<>(Type.class);
        normal.put(NORMAL, 1.0);
        normal.put(FIRE, 1.0);
        normal.put(WATER, 1.0);
        normal.put(GRASS, 1.0);
        normal.put(ELECTRIC, 1.0);

        // FIRE attacking
        EnumMap<Type, Double> fire = new EnumMap<>(Type.class);
        fire.put(NORMAL, 1.0);
        fire.put(FIRE, 0.5);
        fire.put(WATER, 0.5);
        fire.put(GRASS, 2.0);
        fire.put(ELECTRIC, 1.0);

        // WATER attacking
        EnumMap<Type, Double> water = new EnumMap<>(Type.class);
        water.put(NORMAL, 1.0);
        water.put(FIRE, 2.0);
        water.put(WATER, 0.5);
        water.put(GRASS, 0.5);
        water.put(ELECTRIC, 1.0);

        // GRASS attacking
        EnumMap<Type, Double> grass = new EnumMap<>(Type.class);
        grass.put(NORMAL, 1.0);
        grass.put(FIRE, 0.5);
        grass.put(WATER, 2.0);
        grass.put(GRASS, 0.5);
        grass.put(ELECTRIC, 1.0);

        // ELECTRIC attacking
        EnumMap<Type, Double> electric = new EnumMap<>(Type.class);
        electric.put(NORMAL, 1.0);
        electric.put(FIRE, 1.0);
        electric.put(WATER, 2.0);
        electric.put(GRASS, 0.5);
        electric.put(ELECTRIC, 0.5);

        effectiveness.put(NORMAL, normal);
        effectiveness.put(FIRE, fire);
        effectiveness.put(WATER, water);
        effectiveness.put(GRASS, grass);
        effectiveness.put(ELECTRIC, electric);
    }

    public static double getEffectiveness(Type attacker, Type defender) {
        return effectiveness.get(attacker).get(defender);
    }
}