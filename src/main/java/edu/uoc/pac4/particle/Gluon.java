package edu.uoc.pac4.particle;

import edu.uoc.pac4.exception.ParticleException;

public class Gluon extends Boson {

    private String colorCharge;

    public Gluon(String id, double mass, double charge, double spin, double energy,
                 boolean forceCarrier, String colorCharge) throws ParticleException {

        super(id, mass, charge, spin, energy, forceCarrier);
        setColorCharge(colorCharge);
    }

    public String getColorCharge() {
        return colorCharge;
    }

    public void setColorCharge(String colorCharge) throws ParticleException {

        if (colorCharge == null || colorCharge.trim().isEmpty()) {
            throw new ParticleException(ParticleException.ERROR_COLOR_CHARGE);
        }

        this.colorCharge = colorCharge.trim();
    }

    @Override
    public String toString() {
        return String.format(
                """
                        {
                          "type": "gluon",
                          "boson": %s,
                          "colorCharge": "%s"
                        }""", super.toString(), colorCharge
        );
    }

    @Override
    public void simulate() {
        System.out.printf("Gluon [%s] interaction: carrying color charge %s to mediate strong force.%n",
                getId(), colorCharge);
    }
}