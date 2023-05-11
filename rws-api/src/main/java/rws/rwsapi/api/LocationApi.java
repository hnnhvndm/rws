package rws.rwsapi.api;

import main.dao.Location;
import main.exception.IncorrectZipcodeException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

public interface LocationApi {

    ResponseEntity<Location> getLocation(@RequestParam int zipcode) throws IncorrectZipcodeException;
}
