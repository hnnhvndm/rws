package rws.rwsapi.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import rws.rwsapi.exception.BadRequestException;
import rws.rwsapi.exception.LocationNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class LocationServiceTest {

    LocationService locationService;

    @BeforeEach
    void init() {
        this.locationService = new LocationService();
    }

    @Test
    void Should_ThrowBadRequestException_When_IncorrectZipcodeExceptionIsThrown() {
        String errorMessage = "Bad Request: Invalid zipcode: zipcode (123) cannot be 0 or negative and must be four digits";

        //act
        BadRequestException badRequestException = Assertions.assertThrows(
                BadRequestException.class, () -> locationService.findLocation(123));

        //assert
        assertEquals(errorMessage, badRequestException.getMessage());
    }

    @Test
    void Should_ThrowLocationNotFoundException_When_LocationIsNull() {
        String errorMessage = "Location for zipcode '1466' has not been found";

        //act
        LocationNotFoundException notFoundException = Assertions.assertThrows(
                LocationNotFoundException.class, () -> locationService.findLocation(1466)); //zipcode does not exist

        //assert
        assertEquals(errorMessage, notFoundException.getMessage());
    }
}
