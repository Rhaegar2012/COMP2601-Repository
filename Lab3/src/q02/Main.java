package q02;

public class Main {
	public static void main(final String[] argv) {
		//implement the necessary methods and classes
		
//		A::foo
//		B::foo
		
		A a = new A();
		B b = new B();
		go(a);
		go(b);
	}
	
	
	public static  void go (A a) {
		a.foo();
	}
	
	public static void go (B b) {
		b.foo();
	}

	
}

class A{
	public void foo() {
		System.out.println("A::Foo");
	}
	
}

class B{
	public void foo() {
		System.out.println("B::Foo");
	}
	
}



