package java17;

import java.util.Comparator;
import java.util.Random;
import java.util.random.RandomGeneratorFactory;
import java.util.stream.IntStream;

public class PseudoRandomGenerator {

	public static void main(String[] args) {
		RandomGeneratorFactory.all()
		  .sorted(Comparator.comparing(RandomGeneratorFactory::name))
		  .forEach(factory -> System.out.println(String.format("%s\t%s\t%s\t%s",
		    factory.group(),
		    factory.name(),
		    factory.isJumpable(),
		    factory.isSplittable())));
		
		var rng = RandomGeneratorFactory.getDefault().create();
		System.out.println(rng);
		
		var rngf = RandomGeneratorFactory.of("L64X128StarStarRandom").create();
		System.out.println(rngf);
		assert !rng.isDeprecated();

	}
	
	public IntStream getPseudoInts(String algorithm, int streamSize) {
	    // returns an IntStream with size @streamSize of random numbers generated using the @algorithm
	    // where the lower bound is 0 and the upper is 100 (exclusive)
	    return RandomGeneratorFactory.of(algorithm)
	            .create()
	            .ints(streamSize, 0,100);
	}
	
	static void oldRandom() {
		Random random = new Random();
		int number = random.nextInt(10);
//		assertThat(number).isPositive().isLessThan(10);
	}

}
