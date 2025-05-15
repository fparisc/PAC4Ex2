package edu.uoc.pac4.particle;

import edu.uoc.pac4.exception.ParticleException;

public interface QuantumDecaying {

    double getDecayTime();
    void setDecayTime(double decayTime) throws ParticleException;
}
