package general;

import java.util.Objects;

public class RecordStudy {
	
//	Records are immutable data classes that require only the type and name of fields.
	
//	The equals, hashCode, and toString methods, as well as the private, final fields and public constructor, are generated
}

record PersonRecord (String name, String address) {
	//optional: validation
	public PersonRecord {
        Objects.requireNonNull(name);
        Objects.requireNonNull(address);
    }
}

class Person {

    private final String name;
    private final String address;

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (!(obj instanceof Person)) {
            return false;
        } else {
            Person other = (Person) obj;
            return Objects.equals(name, other.name)
              && Objects.equals(address, other.address);
        }
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", address=" + address + "]";
    }

    // standard getters
}