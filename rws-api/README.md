# Data location API
This API allows you to extract location data for a given zipcode.

## Getting started

Before using the API, make sure to import the JAR-file from the `rws` project as a dependency into this project. 

The JAR-file can be found at the following path : `4pp/rws/out/artifacts/rws_jar/rws.jar`

### Endpoint(s):
- `GET /location/{zipcode}` – Returns the location data for a given zipcode

### Error handling
The API may throw the following exceptions:
- BadRequestException – Thrown when the provided zipcode is invalid. This can occur if the given integer is 0, 
negative or not four characters in length.
- LocationNotFoundException – Thrown when no location is found for the given zipcode.

### Example usage
To retrieve location data for a given zipcode, make a GET-request to the location endpoint with the zipcode 
as a path parameter. For example:

`GET http://localhost:8080/location/2622` 

If successful, the API will return a JSON object containing the location data:

```
{
    "id": 842,
    "zipcode": 2622,
    "city": "Delft",
    "municipality": "Delft",
    "province": "Zuid-Holland",
    "coordinates": {
        "latitude": 51.9814255,
        "longitude": 4.3411751
    }
}
```

# Getting Started

The 4pp-project is split into two projects:
1. `rws`
2. `rws-api`

Before using each project, follow the instructions in their README-files. 
First complete the instructions for the `rws` project before using the `rws-api` project.

Refer to the README-files for each project for detailed instructions on how to get started.
