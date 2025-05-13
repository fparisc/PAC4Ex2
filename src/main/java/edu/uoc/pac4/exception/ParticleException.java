package edu.uoc.pac4.exception;

public class ParticleException extends AppException {

    public static final String ERROR_ID = "ID cannot be null or blank.";
    public static final String ERROR_MASS = "Mass cannot be negative or infinite.";
    public static final String ERROR_CHARGE = "Charge cannot be infinite.";
    public static final String ERROR_SPIN = "Spin cannot be negative or infinite.";
    public static final String ERROR_ENERGY = "Energy cannot be negative or infinite.";
    public static final String ERROR_WAVELENGTH = "Wavelength cannot be negative or infinite.";
    public static final String ERROR_COLOR_CHARGE = "Color charge cannot be null or blank.";
    public static final String ERROR_LIFETIME = "Lifetime cannot be negative, zero or infinite.";
    public static final String ERROR_COHERENCE_LENGTH = "Coherence length cannot be negative or infinite.";
    public static final String ERROR_MATERIAL_TYPE = "Material type cannot be null.";
    public static final String ERROR_VIBRATION_MODE = "Vibration mode cannot be null or blank.";
    public static final String ERROR_SPIN_FLIP_COUNT = "Spin flip count cannot be negative.";
    public static final String ERROR_LEPTON_NUMBER = "Lepton number cannot be negative.";
    public static final String ERROR_DECAY_TIME = "Decay time cannot be negative or infinite.";
    public static final String ERROR_BINDING_ENERGY = "Binding energy cannot be negative or infinite.";

    public ParticleException(String message) {
        super(message);
    }
}
