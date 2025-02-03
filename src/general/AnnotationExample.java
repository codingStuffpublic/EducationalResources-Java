package general;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target; 

//create a custom Annotation 
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME) 
@interface Annotation { 
	public String key(); 
	public String value(); 
} 

//and pass values for annotation 
@Annotation(key = "GFG", value = "GeeksForGeeks") 
public class AnnotationExample { 

	public static void main(String[] args) throws ClassNotFoundException { 
		Class<AnnotationExample> myClass = AnnotationExample.class; 

		System.out.println("Class represented by myClass: "	+ myClass.toString()); 

		System.out.println( "Is there any annotation in myClass: "
			+ myClass.isAnnotationPresent(Annotation.class)); 
	} 
} 

