package edu.uoc.pac4.particle;

import edu.uoc.pac4.exception.ParticleException;

public class Muon extends Fermion implements QuantumDecaying {

    private double decayTime;

    public Muon(String id, double mass, double charge, double spin, double energy,
                int leptonNumber, double decayTime) throws ParticleException {
        super(id, mass, charge, spin, energy, leptonNumber);
        setDecayTime(decayTime);
    }

    public double getDecayTime() {
        return decayTime;
    }

    public void setDecayTime(double decayTime) throws ParticleException {
        if (decayTime < 0 || Double.isInfinite(decayTime)) {
            throw new ParticleException(ParticleException.ERROR_DECAY_TIME);
        }
        this.decayTime = decayTime;
    }

    @Override
    public String toString() {
        return String.format(
                "{\n" +
                        "  \"type\": \"muon\",\n" +
                        "  \"fermion\": %s,\n" +
                        "  \"decayTime\": %.3e\n" +
                        "}",
                super.toString(),
                decayTime
        );
    }

    @Override
    public void simulate() {
        System.out.printf(
                "Muon [%s] with lepton number %d decays after %.2e s.%n",
                getId(),
                getLeptonNumber(),
                decayTime
        );
    }
}
