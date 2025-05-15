package edu.uoc.pac4.particle;

import edu.uoc.pac4.exception.ParticleException;

import java.util.Locale;

public class EmergentPhonon extends QuasiParticle {

    private String vibrationMode;

    public EmergentPhonon(String id, double mass, double charge, double spin, double energy,
                          double lifeTime, double coherenceLength, MaterialType materialType,
                          String vibrationMode) throws ParticleException {

        super(id, mass, charge, spin, energy, lifeTime, coherenceLength, materialType);
        setVibrationMode(vibrationMode);
    }

    public String getVibrationMode() {
        return vibrationMode;
    }

    public void setVibrationMode(String vibrationMode) throws ParticleException {

        if (vibrationMode == null || vibrationMode.trim().isEmpty()) {
            throw new ParticleException(ParticleException.ERROR_VIBRATION_MODE);
        }

        this.vibrationMode = vibrationMode;
    }

    @Override
    public String toString() {
        return String.format(
                """
                        {
                          "type": "emergentPhonon",
                          "quasiParticle": %s,
                          "vibrationMode": "%s"
                        }""",
                super.toString(),
                vibrationMode
        );
    }

    @Override
    public void simulate() {
        System.out.printf(Locale.US,
                "EmergentPhonon [%s] vibrating in %s mode with lifetime %.2e s.%n",
                getId(),
                vibrationMode,
                getLifeTime()
        );
    }
}
