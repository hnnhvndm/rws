package rws.rwsapi.service;

import main.core.FindLocation;
import main.dao.Location;
import main.exception.IncorrectZipcodeException;
import org.springframework.stereotype.Service;
import rws.rwsapi.exception.BadRequestException;
import rws.rwsapi.exception.LocationNotFoundException;

import java.util.Optional;

@Service
public class LocationService {

    public Location findLocation(int zipcode) {
        Optional<Location> location;
        try {
            location = Optional.ofNullable(FindLocation.findLocation(zipcode));
        } catch (IncorrectZipcodeException e) {
            throw new BadRequestException("Bad Request: " + e.getMessage());
        }
        return Optional.of(location).get().orElseThrow(() -> new LocationNotFoundException(
                String.format("Location for zipcode '%d' has not been found", zipcode)));
    }
}
