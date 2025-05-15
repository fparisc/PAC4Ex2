package edu.uoc.pac4.particle;

import edu.uoc.pac4.exception.ParticleException;

import java.util.Locale;

public class Exciton extends QuasiParticle implements QuantumDecaying {

    private double bindingEnergy;
    private double decayTime;

    public Exciton(String id, double mass, double charge, double spin, double energy,
                   double lifeTime, double coherenceLength, MaterialType materialType,
                   double bindingEnergy, double decayTime) throws ParticleException {
        super(id, mass, charge, spin, energy, lifeTime, coherenceLength, materialType);
        setBindingEnergy(bindingEnergy);
        setDecayTime(decayTime);
    }

    public double getBindingEnergy() {
        return bindingEnergy;
    }

    public void setBindingEnergy(double bindingEnergy) throws ParticleException {
        if (bindingEnergy < 0 || Double.isInfinite(bindingEnergy)) {
            throw new ParticleException(ParticleException.ERROR_BINDING_ENERGY);
        }
        this.bindingEnergy = bindingEnergy;
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
        return String.format(Locale.US,
                """
                        {
                          "type": "exciton",
                          "quasiParticle": %s,
                          "bindingEnergy": %.2f,
                          "decayTime": %.2e
                        }""",
                super.toString(),
                bindingEnergy,
                decayTime
        );
    }

    @Override
    public void simulate() {
        System.out.printf(Locale.US,
                "Exciton [%s] with binding energy %.2f eV decays after %.2e s.%n",
                getId(),
                bindingEnergy,
                decayTime
        );
    }
}

