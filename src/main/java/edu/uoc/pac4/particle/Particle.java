package edu.uoc.pac4.particle;

import edu.uoc.pac4.exception.ParticleException;

public abstract class Particle implements Cloneable, Simulatable {

    private String id;
    private double mass;
    private double charge;
    private double spin;
    private double energy;

    public Particle(String id, double mass, double charge, double spin, double energy) throws ParticleException {
        setId(id);
        setMass(mass);
        setCharge(charge);
        setSpin(spin);
        setEnergy(energy);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) throws ParticleException {

        if (id == null || id.trim().isEmpty()) {
            throw new ParticleException(ParticleException.ERROR_ID);
        }

        this.id = id;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) throws ParticleException {

        if (mass < 0 || Double.isInfinite(mass)) {
            throw new ParticleException(ParticleException.ERROR_MASS);
        }

        this.mass = mass;
    }

    public double getCharge() {
        return charge;
    }

    public void setCharge(double charge) throws ParticleException {

        if (Double.isInfinite(charge)) {
            throw new ParticleException(ParticleException.ERROR_CHARGE);
        }

        this.charge = charge;
    }

    public double getSpin() {
        return spin;
    }

    public void setSpin(double spin) throws ParticleException {

        if (spin < 0 || Double.isInfinite(spin)) {
            throw new ParticleException(ParticleException.ERROR_SPIN);
        }

        this.spin = spin;
    }

    public double getEnergy() {
        return energy;
    }

    public void setEnergy(double energy) throws ParticleException {

        if (energy < 0 || Double.isInfinite(energy)) {
            throw new ParticleException(ParticleException.ERROR_ENERGY);
        }

        this.energy = energy;
    }

    @Override
    public String toString() {
        return String.format(
                "{\n  \"id\": \"%s\",\n  \"mass\": %.2f,\n  \"charge\": %.2f,\n  \"spin\": %.2f,\n  \"energy\": %.2f\n}",
                id, mass, charge, spin, energy
        );
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
