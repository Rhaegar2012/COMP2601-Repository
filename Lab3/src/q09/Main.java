package q09;

public class Main {
	public static void main(String[] args) {
		//implement the necessary abstract class hierarchy
		//NOTE: Star does not extend any of the other classes, only Object
		
//		Bar::go
//		Car::go
//		Star::go
//		Bar::go
//		Bar::go
//		Bar::go
//		Car::go
//		Star::go
		
		Foo a = new Bar();
		Foo b = new Car();
		Foo c = new Star();
		AbstractFoo d = new Bar();
		AbstractFoo e = new Bar();
		Bar f = new Bar();
		Bar g = new Car();
		Star h = new Star();
		a.go();
		b.go();
		c.go();
		d.go();
		e.go();
		f.go();
		g.go();
		h.go();
	}
}

interface Foo {
	public void go();
}

abstract class AbstractFoo implements Foo{
	abstract public void go() ;
	
}

class Bar extends AbstractFoo{
	public void go() {
		System.out.println("Bar::go");
	}
}

class Car extends Bar{
	public void go() {
		System.out.println("Car::go");
	}
}

class Star implements Foo{
	public void go() {
		System.out.println("Star::go");
	}
}