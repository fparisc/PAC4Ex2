package edu.uoc.pac4.particle;

import java.util.Locale;

public enum MaterialType {

    SILICON("Silicon", 2.33),
    GRAPHENE("Graphene", 2.26),
    SEMICONDUCTOR("Semiconductor", 2.33),
    SUPERCONDUCTOR("Superconductor", 8.96);

    private final String name;
    private final double density;

    MaterialType(String name, double density) {
        this.name = name;
        this.density = density;
    }

    public String getName() {
        return name;
    }

    public double getDensity() {
        return density;
    }

    @Override
    public String toString() {
        return String.format(Locale.US,"{\n  \"name\": \"%s\",\n  \"density\": %.2f\n}", name, density);
    }
}
