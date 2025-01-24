package java21;

public class PatternMatchingStudy {
	public static void main(String[] args) {
		records();
	}

	public static void records() {
		Person p1 = new Person("Joe Bloggs", 22);
		System.out.println(p1.name() + "; " + p1.age());
		patternMatching(p1);
		patternMatching("abc");

		Pair<String> pairS = new Pair<>("Sean", "Kennedy");
		Pair<Integer> pairI = new Pair<>(10, 20);
		patternMatching(pairS);
		patternMatching(pairI);
	}

	public static void patternMatching(Object obj) {
		if (obj instanceof Person person) {
			System.out.println("PM: " + person.name() + "; " + person.age());
		} else if (obj instanceof Pair pair) {
			System.out.println("PM: " + pair.x() + "; " + pair.y());
		}
	}
	
	//pattern matching
	public static void recordPattern(){
        Person p1 = new Person("Joe Bloggs", 22);
        Person p2 = new Person("Mary Bloggs", 23);
        nonNesting(p1);  // Joe Bloggs; 22

        Player player1 = new Player(p1, Ability.WEAK);
        Player player2 = new Player(p2, Ability.STRONG);
        Doubles dbles  = new Doubles(player1, player2);
        nesting(dbles);
    }
    public static void nonNesting(Object obj){
        if(obj instanceof Person(String s, Integer nAge)){ // record pattern
            System.out.println(s + "; "+ nAge);
        }
    }
    
    public static void nesting(Doubles dbles){
        if (dbles instanceof Doubles(Player pl1, Player pl2)) {   // LVTI works also
            System.out.println(pl1.person() + "; " + pl1.ability());
        }
        if (dbles instanceof Doubles(Player(Person p1, Ability ability), var pl2)) { // LVTI works also
            System.out.println(p1.name() + "; "+p1.age() + "; "+ability.name());
            System.out.println(pl2.person());
        }
    }
}

record Person(String name, Integer age) {}

enum Ability {WEAK, AVERAGE, STRONG}

record Player(Person person, Ability ability) {}

record Doubles(Player player1, Player player2) {}

record Pair<T>(T x, T y) {}
