package q04;

public class Main {
	public static void main(final String[] argv) {
		//implement the necessary method and class hierarchy
		
//		A::foo
//		B::foo
//		B::foo
		
		A aa = new A();
		A ab = new B();
		B bb = new B();
		go(aa);
		go(ab);
		go(bb);
		
	}
	
	private static void go(A a) {
		a.foo();
	}
}

class A{
	public void foo() {
		System.out.println("A::foo");
	}
	
}

class B extends A{
	public void foo() {
		System.out.println("B::foo");
	}
}
