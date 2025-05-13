package edu.uoc.pac4.particle;

import edu.uoc.pac4.exception.ParticleException;

public abstract class QuasiParticle extends Particle {

    private double lifeTime;
    private double coherenceLength;
    private MaterialType materialType;

    public QuasiParticle(String id, double mass, double charge, double spin, double energy,
                         double lifeTime, double coherenceLength, MaterialType materialType) throws ParticleException {

        super(id, mass, charge, spin, energy);

        setLifeTime(lifeTime);
        setCoherenceLength(coherenceLength);
        setMaterialType(materialType);
    }

    public double getLifeTime() {
        return lifeTime;
    }

    public void setLifeTime(double lifeTime) throws ParticleException {
        if (lifeTime <= 0 || Double.isInfinite(lifeTime)) {
            throw new ParticleException(ParticleException.ERROR_LIFETIME);
        }
        this.lifeTime = lifeTime;
    }

    public double getCoherenceLength() {
        return coherenceLength;
    }

    public void setCoherenceLength(double coherenceLength) throws ParticleException {
        if (coherenceLength < 0 || Double.isInfinite(coherenceLength)) {
            throw new ParticleException(ParticleException.ERROR_COHERENCE_LENGTH);
        }
        this.coherenceLength = coherenceLength;
    }

    public MaterialType getMaterialType() {
        return materialType;
    }

    public void setMaterialType(MaterialType materialType) throws ParticleException {
        if (materialType == null) {
            throw new ParticleException(ParticleException.ERROR_MATERIAL_TYPE);
        }
        this.materialType = materialType;
    }

    @Override
    public String toString() {
        return String.format(
                """
                        {
                          "particle": %s,
                          "lifeTime": %.3e,
                          "coherenceLength": %.3e,
                          "materialType": %s
                        }""",
                super.toString(), lifeTime, coherenceLength, materialType.toString()
        );
    }
}
