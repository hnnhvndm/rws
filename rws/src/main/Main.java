package main;

import main.core.FindLocation;
import main.dao.Location;
import main.exception.IncorrectZipcodeException;

public class Main {
    public static void main(String[] args) throws IncorrectZipcodeException {

        for (String argument : args) {
            Location location = FindLocation.findLocation(Integer.parseInt((argument)));
            System.out.printf("Location found for '%s':%n %s", Integer.parseInt(argument), location);
        }
    }
}

