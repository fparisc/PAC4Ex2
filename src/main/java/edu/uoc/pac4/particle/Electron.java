package edu.uoc.pac4.particle;

import edu.uoc.pac4.exception.ParticleException;

public class Electron extends Fermion {

    public Electron(String id, double mass, double charge, double spin,
                    double energy, int leptonNumber) throws ParticleException {
        super(id, mass, charge, spin, energy, leptonNumber);
    }

    @Override
    public String toString() {
        return String.format(
                "{\n" +
                        "  \"type\": \"electron\",\n" +
                        "  \"fermion\": %s\n" +
                        "}",
                super.toString()
        );
    }

    @Override
    public void simulate() {
        System.out.printf(
                "Electron [%s] with lepton number %d is stable and does not decay.%n",
                getId(),
                getLeptonNumber()
        );
    }
}