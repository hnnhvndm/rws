package main.dao;

import java.util.Objects;

public class Location {

    int id;

    int zipcode;

    String city;

    String municipality;

    String province;

    Coordinates coordinates;

    public Location(int id, int zipcode, String city, String municipality, String province, Coordinates coordinates) {
        this.id = id;
        this.zipcode = zipcode;
        this.city = city;
        this.municipality = municipality;
        this.province = province;
        this.coordinates = coordinates;
    }

    public Location() {
        //no-args constructor
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public int getId() {
        return id;
    }

    public int getZipcode() {
        return zipcode;
    }

    public String getCity() {
        return city;
    }

    public String getMunicipality() {
        return municipality;
    }

    public String getProvince() {
        return province;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return id == location.id && zipcode == location.zipcode && city.equals(location.city) && municipality.equals(location.municipality) && province.equals(location.province) && coordinates.equals(location.coordinates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, zipcode, city, municipality, province, coordinates);
    }

    /**
     * @return String representation of 'Location' in JSON format
     */
    @Override
    public String toString() {
        return String.format("""
                "Location": { \s
                \t"id": "%d", \s
                \t"zipcode": "%d", \s
                \t"city": "%s", \s
                \t"municipality": "%s", \s
                \t"province": "%s", \s
                \t"Coordinates": {
                \t\t"latitude": "%f", \s
                \t\t"longitude": "%f" \s
                \t}
                }
                """, id, zipcode, city, municipality, province, coordinates.latitude, coordinates.longitude);
    }
}
