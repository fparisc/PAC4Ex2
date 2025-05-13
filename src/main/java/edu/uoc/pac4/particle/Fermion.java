package edu.uoc.pac4.particle;

import edu.uoc.pac4.exception.ParticleException;

public abstract class Fermion extends Particle {

    private int leptonNumber;

    public Fermion(String id, double mass, double charge, double spin, double energy, int leptonNumber) throws ParticleException {
        super(id, mass, charge, spin, energy);
        setLeptonNumber(leptonNumber);
    }

    public int getLeptonNumber() {
        return leptonNumber;
    }

    public void setLeptonNumber(int leptonNumber) throws ParticleException {

        if (leptonNumber < 0) {
            throw new ParticleException(ParticleException.ERROR_LEPTON_NUMBER);
        }

        this.leptonNumber = leptonNumber;
    }

    @Override
    public String toString() {
        return String.format(
                """
                        {
                          "particle": %s,
                          "leptonNumber": %d
                        }""",
                super.toString(), leptonNumber
        );
    }
}

