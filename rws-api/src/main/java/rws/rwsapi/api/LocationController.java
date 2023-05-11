package rws.rwsapi.api;

import main.dao.Location;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rws.rwsapi.service.LocationService;

@RestController
@RequestMapping("/location")
public class LocationController implements LocationApi {

    LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/{zipcode}")
    public ResponseEntity<Location> getLocation(@PathVariable int zipcode) {
        Location location = locationService.findLocation(zipcode);
        return ResponseEntity.ok(location);
    }
}
