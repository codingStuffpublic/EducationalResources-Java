package general;

import java.lang.reflect.Constructor;

import designpatterns.LazySingleton;

public class ReflectionStudy {

	public static void main(String[] args) {
		LazySingleton instanceOne = LazySingleton.getInstance();
		LazySingleton instanceTwo = null;
		try {
			Constructor[] constructors = LazySingleton.class.getDeclaredConstructors();
			for (Constructor constructor : constructors) {
				// java.lang.IllegalAccessException: class ReflectionStudy cannot access a
				// member of class LazySingleton with modifiers "private"
				constructor.setAccessible(true);
				instanceTwo = (LazySingleton) constructor.newInstance();
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(instanceOne.hashCode());
		System.out.println(instanceTwo.hashCode());
	}
}
