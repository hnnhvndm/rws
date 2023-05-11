package main.core;

import main.config.MySqlConnection;
import main.dao.Coordinates;
import main.dao.Location;
import main.exception.IncorrectZipcodeException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FindLocation {

    private static final Logger LOGGER = Logger.getLogger(FindLocation.class.getName());

    private FindLocation() {
        //private constructor to hide the implicit public one
    }

    public static Location findLocation(int zipcode) throws IncorrectZipcodeException {
        if (!isZipcodeValid(zipcode)) {
            throw new IncorrectZipcodeException(String.format(
                    "Invalid zipcode: zipcode (%d) cannot be 0 or negative and must be four digits", zipcode)
            );
        }

        try (Connection connection = MySqlConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM 4pp WHERE postcode = ?")) {
            stmt.setInt(1, zipcode);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Location location = new Location();
                    location.setId(rs.getInt("id"));
                    location.setZipcode(zipcode);
                    location.setCity(rs.getString("woonplaats"));
                    location.setMunicipality(rs.getString("gemeente"));
                    location.setProvince(rs.getString("provincie"));
                    location.setCoordinates(new Coordinates(
                            rs.getDouble("latitude"),
                            rs.getDouble("longitude"))
                    );
                    return location;
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
        }
        return null;
    }

    /**
     * Determines whether a given integer is not 0 or negative
     *  and if the zipcode has length of four digits.
     * @param zipcode the integer to check.
     * @return returns true when integer has length of exactly four characters.
     */
    private static boolean isZipcodeValid(int zipcode) {
        if (zipcode == 0 || zipcode < 0) {
            return false;
        }
        return String.valueOf(zipcode).length() == 4;
    }
}
