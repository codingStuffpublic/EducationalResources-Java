package java8;

import java.util.Optional;

public class OptionalStudy {
	public static void main(String[] args) {
        Optional<String> emptyOpt = Optional.empty();
        Optional<String> nonEmptyOpt = Optional.of("Hello!");
        Optional<String> nullableOpt = Optional.ofNullable(null); // Optional that may contain null

        System.out.println("Is present: " + nonEmptyOpt.isPresent());
        System.out.println("Is empty: " + emptyOpt.isEmpty());

        System.out.println("Get value: " + nonEmptyOpt.get());
        // System.out.println(emptyOpt.get()); // Throws NoSuchElementException

        System.out.println("orElse: " + emptyOpt.orElse("Default Value"));
        System.out.println("orElseGet: " + emptyOpt.orElseGet(() -> "Generated Value"));

        // 5. Handling Nulls safely
        String nullableValue = null;
        String result = Optional.ofNullable(nullableValue).orElse("Fallback Value");
        System.out.println("Handling nulls: " + result);

        // 6. Using orElseThrow()
        try {
            emptyOpt.orElseThrow(() -> new RuntimeException("No value present!"));
        } catch (Exception e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

        // Transforming values with map()
        Optional<Integer> lengthOpt = nonEmptyOpt.map(String::length);
        System.out.println("Mapped value (String length): " + lengthOpt.orElse(0));

        // Filtering values
        Optional<String> filteredOpt = nonEmptyOpt.filter(s -> s.startsWith("Hello"));
        System.out.println("Filtered Optional: " + filteredOpt.orElse("Not matched"));

        // Using ifPresent()
        nonEmptyOpt.ifPresent(value -> System.out.println("ifPresent: " + value));

        // Using ifPresentOrElse()
        emptyOpt.ifPresentOrElse(
            value -> System.out.println("Value: " + value),
            () -> System.out.println("No value present")
        );

        // Chaining Optionals with flatMap()
        Optional<Optional<String>> nestedOpt = Optional.of(Optional.of("Nested Value"));
        Optional<String> flatMappedOpt = nestedOpt.flatMap(opt -> opt);
        System.out.println("flatMapped value: " + flatMappedOpt.orElse("Empty"));

        // Converting Optional to Stream
        nonEmptyOpt.stream().forEach(System.out::println);

        // Optional with primitive types
        Optional<Integer> optionalNumber = Optional.of(10);
        optionalNumber.map(n -> n * 2).ifPresent(n -> System.out.println("Doubled: " + n));
    }
}





