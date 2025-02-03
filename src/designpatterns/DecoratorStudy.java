package designpatterns;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DecoratorStudy {
//	Decorator is a structural design pattern that lets you attach new behaviors to objects by 
//	placing these objects inside special wrapper objects that contain the behaviors.

	public static void main(String[] args) {

		try {
			BufferedInputStream bis = new BufferedInputStream(
					new FileInputStream(new File("hello.txt")));
			int data;
			while ((data = bis.read()) != -1) {
				System.out.print((char) data);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
