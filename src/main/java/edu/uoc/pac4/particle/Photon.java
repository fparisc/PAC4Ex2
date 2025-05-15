package edu.uoc.pac4.particle;

import edu.uoc.pac4.exception.ParticleException;

import java.util.Locale;

public class Photon extends Boson {

    private double wavelength;

    public Photon(String id, double mass, double charge, double spin, double energy,
                  boolean forceCarrier, double wavelength) throws ParticleException {

        super(id, mass, charge, spin, energy, forceCarrier);
        setWavelength(wavelength);

    }

    public double getWavelength() {
        return wavelength;
    }

    public void setWavelength(double wavelength) throws ParticleException {

        if (wavelength < 0 || Double.isInfinite(wavelength)) {
            throw new ParticleException(ParticleException.ERROR_WAVELENGTH);
        }

        this.wavelength = wavelength;
    }

    @Override
    public String toString() {
        return String.format(Locale.US,
                """
                        {
                          "type": "photon",
                          "boson": %s,
                          "wavelength": %.2f
                        }""", super.toString(), wavelength
        );
    }

    @Override
    public void simulate() {
        System.out.printf(Locale.US, "Photon [%s] with wavelength %.2f nm has been absorbed, transferring %.2f eV of energy.%n",
                getId(), wavelength, getEnergy());
    }
}
