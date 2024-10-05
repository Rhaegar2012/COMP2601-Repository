package q01;

public class Main {
	public static void main(final String[] argv) {
		//implement the necessary classes
		
//		A::foo
//		B::foo
		
		A a = new A();
		B b = new B();
		a.foo();
		b.foo();
	}
}


class A {
	public void foo() {
		System.out.println("A:Foo");
	}
}

class B{
	public void foo() {
		System.out.println("B:foo");
	}
}