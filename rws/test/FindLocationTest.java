import main.core.FindLocation;
import main.dao.Coordinates;
import main.dao.Location;
import main.exception.IncorrectZipcodeException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static main.core.FindLocation.findLocation;
import static org.junit.jupiter.api.Assertions.*;

class FindLocationTest {

    @Test
    void Should_FindLocation_When_GivenValidZipcode() throws IncorrectZipcodeException {
        //arrange
        Location expected = new Location();
        expected.setId(842);
        expected.setZipcode(2622);
        expected.setCity("Delft");
        expected.setMunicipality("Delft");
        expected.setProvince("Zuid-Holland");
        expected.setCoordinates(new Coordinates(51.9814255, 4.3411751));

        //act
        Location actual = findLocation(2622);

        //assert
        assertNotNull(actual);
        assertEquals(expected, actual);
    }

    @Test
    void Should_ReturnNull_When_LocationIsNotFound() throws IncorrectZipcodeException {
        //arrange
        int zipcode = 1466; //zipcode does not exist

        //act
        Location location = FindLocation.findLocation(zipcode);

        //assert
        assertNull(location);
    }

    @ParameterizedTest(name = "{index} - Invalid zipcode: {0}")
    @ValueSource(ints = {0, -1, 12345, 123})
    void Should_ThrowInvalidZipcodeException_When_ZipcodeIsInvalid(int zipcode) {
        assertThrows(IncorrectZipcodeException.class, () -> FindLocation.findLocation(zipcode));
    }
}
