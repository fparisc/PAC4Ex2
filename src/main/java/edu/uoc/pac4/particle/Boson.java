package edu.uoc.pac4.particle;

import edu.uoc.pac4.exception.ParticleException;

public abstract class Boson extends Particle {

    private boolean forceCarrier;

    public Boson(String id, double mass, double charge, double spin, double energy, boolean forceCarrier) throws ParticleException {
        super(id, mass, charge, spin, energy);
        this.forceCarrier = forceCarrier;
    }

    public boolean isForceCarrier() {
        return forceCarrier;
    }

    public void setForceCarrier(boolean forceCarrier) {
        this.forceCarrier = forceCarrier;
    }

    @Override
    public String toString() {
        return String.format(
                """
                        {
                          "particle": %s,
                          "forceCarrier": %b
                        }""", super.toString(), forceCarrier
        );
    }
}
