package q08;

public class Main {
	public static void main(final String[] argv) {
		//implement the necessary interface, and abstract class hierarchy
		//NOTE: Class B must be unimplemented, meaning it has an empty body
		
//		A::foo
//		A::foo
//		A::foo
		
		I ib = new B();
		A ab = new B();
		B bb = new B();
		go(ib);
		go(ab);
		go(bb);
		
		
	}
	
	private static void go(final I i) {
		i.foo();
	}

}

interface I{
	public void foo();
}

abstract class A implements I{
	public void foo() {
		System.out.println("A::foo");
	}
}
class B extends A{
	
}

