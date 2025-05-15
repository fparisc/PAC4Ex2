package edu.uoc.pac4.data;

import edu.uoc.pac4.exception.DataEntryException;
import edu.uoc.pac4.particle.Particle;

import java.time.LocalDateTime;
import java.util.Objects;

public class DataEntry implements  Cloneable {

    private int id;
    private String title;
    private LocalDateTime timestamp;
    private String observations;
    private Particle particle;

    public DataEntry(int id, String title, LocalDateTime timestamp, String observations, Particle particle) throws DataEntryException {
        setId(id);
        setTitle(title);
        setTimestamp(timestamp);
        setObservations(observations);
        setParticle(particle);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) throws DataEntryException {
        if (id <= 0) {
            throw new DataEntryException(DataEntryException.ERROR_ID);
        }

        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) throws DataEntryException {
        if (title == null || title.trim().isEmpty()) {
            throw new DataEntryException(DataEntryException.ERROR_TITLE);
        }

        this.title = title.trim();
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) throws DataEntryException {
        if (timestamp == null || timestamp.isAfter(LocalDateTime.now())) {
            throw new DataEntryException(DataEntryException.ERROR_TIMESTAMP);
        }

        this.timestamp = timestamp;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) throws DataEntryException {
        if (observations == null) {
            throw new DataEntryException(DataEntryException.ERROR_OBSERVATIONS);
        }

        this.observations = observations.trim();
    }

    public Particle getParticle() {return particle;}

    public void setParticle(Particle particle) throws DataEntryException {
        if (particle == null) {
            throw new DataEntryException(DataEntryException.ERROR_PARTICLE);
        }
        this.particle = particle;
    }

    @Override
    public String toString() {
        return String.format(
                "{\n  \"id\": %d,\n  \"title\": \"%s\",\n  \"timestamp\": \"%s\",\n  \"observations\": \"%s\",\n  \"particle\": %s\n}",
                id, title, timestamp.toString(), observations, particle
        );
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof DataEntry other)) {
            return false;
        }

        return Objects.equals(this.title, other.title)
                && Objects.equals(this.timestamp, other.timestamp)
                && Objects.equals(this.observations, other.observations);
    }

    @Override
    public DataEntry clone() throws CloneNotSupportedException {
        try {
            Particle clonedParticle = (Particle) particle.clone();
            return new DataEntry(id, title, timestamp, observations, clonedParticle);
        } catch (DataEntryException e) {
            throw new RuntimeException(e);
        }
    }
}
