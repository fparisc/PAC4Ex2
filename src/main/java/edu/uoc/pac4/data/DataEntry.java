package edu.uoc.pac4.data;

import edu.uoc.pac4.exception.DataEntryException;

import java.time.LocalDateTime;
import java.util.Objects;

public class DataEntry {

    private int id;
    private String title;
    private LocalDateTime timestamp;
    private String observations;

    public DataEntry(int id, String title, LocalDateTime timestamp, String observations) throws DataEntryException {
        setId(id);
        setTitle(title);
        setTimestamp(timestamp);
        setObservations(observations);
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

    @Override
    public String toString() {
        return String.format(
                "{\n  \"id\": %d,\n  \"title\": \"%s\",\n  \"timestamp\": \"%s\",\n  \"observations\": \"%s\"\n}",
                id, title, timestamp.toString(), observations
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
}
