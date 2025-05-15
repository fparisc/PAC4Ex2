package edu.uoc.pac4.data;

import edu.uoc.pac4.exception.DataRepositoryException;

import java.util.HashMap;

public class DataRepository implements Cloneable {

    private String name;
    private HashMap<Integer, DataEntry> dataEntries;

    public DataRepository(String name, DataEntry[] dataEntries) throws DataRepositoryException {

        this.dataEntries = new HashMap<>();

        setName(name);

        for (DataEntry entry : dataEntries) {
            addDataEntry(entry);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws DataRepositoryException {

        if (name == null || name.trim().isEmpty()) {
            throw new DataRepositoryException(DataRepositoryException.ERROR_NAME);
        }

        this.name = name.trim();
    }

    public void addDataEntry(DataEntry dataEntry) throws DataRepositoryException {

        if (dataEntry == null) {
            throw new DataRepositoryException(DataRepositoryException.ERROR_DATA_ENTRY_NULL);
        }

        if (dataEntries.containsKey(dataEntry.getId())) {
            throw new DataRepositoryException(DataRepositoryException.ERROR_ENTRY_ALREADY_EXISTS);
        }

        dataEntries.put(dataEntry.getId(), dataEntry);
    }

    public DataEntry getDataEntry(int id) throws DataRepositoryException {

        if (!dataEntries.containsKey(id)) {
            throw new DataRepositoryException(DataRepositoryException.ERROR_DATA_ENTRY_NOT_FOUND);
        }

        return dataEntries.get(id);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        sb.append("  \"name\": \"").append(name).append("\",\n");
        sb.append("  \"dataEntries\": [\n");

        int count = 0;
        int size = dataEntries.size();
        for (DataEntry entry : dataEntries.values()) {
            sb.append(entry.toString());
            count++;
            if (count < size) {
                sb.append(",\n");
            } else {
                sb.append("\n");
            }
        }

        sb.append("  ]\n}");
        return sb.toString();
    }


    @Override
    public Object clone() throws CloneNotSupportedException {
        try {
            DataEntry[] clonedEntries = new DataEntry[dataEntries.size()];
            int i = 0;
            for (DataEntry entry : dataEntries.values()) {
                clonedEntries[i++] = (DataEntry) entry.clone();
            }
            return new DataRepository(this.name, clonedEntries);
        } catch (Exception e) {
            throw new CloneNotSupportedException(e.toString());
        }
    }
}
