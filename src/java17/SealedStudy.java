package java17;

public class SealedStudy {
	//class or interface can be sealed or explicitly non-sealed
}

// sealed affects only direct child
sealed abstract class SealedAbstract permits PermitClass {}

non-sealed class PermitClass extends SealedAbstract {}

class PermitClass2 extends PermitClass {}

//interface example. permits affects extending and implementing an Interface too
sealed abstract interface SealedAbstractI permits PermitInterface, WhoImplementsASealed {}

non-sealed class WhoImplementsASealed implements SealedAbstractI {}

non-sealed interface PermitInterface extends SealedAbstractI {}

interface PermitClass2I extends PermitInterface {}

//another example
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
