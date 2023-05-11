package rws.rwsapi.api;

import main.dao.Location;
import main.exception.IncorrectZipcodeException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

public interface LocationApi {

    ResponseEntity<Location> getLocation(@PathVariable int zipcode) throws IncorrectZipcodeException;
}
