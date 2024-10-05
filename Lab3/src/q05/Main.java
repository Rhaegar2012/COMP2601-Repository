package q05;

public class Main {
	public static void main(final String[] argv) {
		//implement the necessary interface, and class hierarchy
		
//		A::foo
//		B::foo
//		A::foo
//		B::foo
//		B::foo
		
		I ia = new A();//I ia an Interface
		I ib = new B();
		A aa = new A();
		A ab = new B();
		B bb = new B();
		go(ia);
		go(ib);
		go(aa);
		go(ab);
		go(bb);
	}
	
	private static void go(final I i) {
		i.foo();
	}
}

interface I{
	
	void foo();
	
}

class A implements I{
	public void foo() {
		System.out.println("A::foo");
	}
}

class B extends A{
	public void foo() {
		System.out.println("B::foo");
	}
}
