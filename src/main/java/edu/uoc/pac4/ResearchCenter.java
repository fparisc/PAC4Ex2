package edu.uoc.pac4;

import edu.uoc.pac4.data.DataRepository;
import edu.uoc.pac4.exception.ResearchCenterException;

import java.util.regex.Pattern;

public class ResearchCenter {

    private String name;
    private String city;
    private String address;
    private String phoneNumber;
    private String email;
    private DataRepository dataRepository;

    public ResearchCenter(String name, String city, String address, String phoneNumber, String email, DataRepository dataRepository) throws ResearchCenterException {
        setName(name);
        setCity(city);
        setAddress(address);
        setPhoneNumber(phoneNumber);
        setEmail(email);
        setDataRepository(dataRepository);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws ResearchCenterException {
        if (name == null || name.isBlank()) {
            throw new ResearchCenterException(ResearchCenterException.ERROR_NAME);
        }

        this.name = name.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) throws ResearchCenterException {
        if (city == null) {
            throw new ResearchCenterException(ResearchCenterException.ERROR_CITY);
        }

        this.city = city.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) throws ResearchCenterException {
        if (address == null) {
            throw new ResearchCenterException(ResearchCenterException.ERROR_ADDRESS);
        }

        this.address = address.trim();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phone) throws ResearchCenterException {
        if (phone == null || !phone.matches( "^\\+?[0-9]{7,}$")) {
            throw new ResearchCenterException(ResearchCenterException.ERROR_PHONE_NUMBER);
        }

        this.phoneNumber = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws ResearchCenterException {
        if (email == null || !Pattern.matches("^[a-z0-9._-]+@[a-z0-9-]+\\.[a-z]{2,}$", email)) {
            throw new ResearchCenterException(ResearchCenterException.ERROR_EMAIL);
        }

        this.email = email;
    }

    public DataRepository getDataRepository() {
        return dataRepository;
    }

    public void setDataRepository(DataRepository dataRepository) throws ResearchCenterException {
        if (dataRepository == null) {
            throw new ResearchCenterException(ResearchCenterException.ERROR_DATA_REPOSITORY);
        }

        this.dataRepository = dataRepository;
    }

    @Override
    public String toString() {
        return String.format(
                "{\n  \"name\": \"%s\",\n  \"city\": \"%s\",\n  \"address\": \"%s\",\n  \"phoneNumber\": \"%s\",\n  \"email\": \"%s\",\n  \"dataRepository\": %s\n}",
                name, city, address, phoneNumber, email, dataRepository
        );
    }
}
