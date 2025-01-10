package java15;

public class SealedStudy {
	
	//class can be sealed or explicitly non-sealed
}

sealed interface Vehicle permits Car, Truck {

    String getRegistrationNumber();

}

record Car(int numberOfSeats, String registrationNumber) implements Vehicle {

    @Override
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

}

//The type Truck22 that implements a sealed interface Vehicle should be a permitted subtype of Vehicle
record Truck(int loadCapacity, String registrationNumber) implements Vehicle {

    @Override
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public int getLoadCapacity() {
        return loadCapacity;
    }

}
