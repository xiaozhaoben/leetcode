package choiceQuestion;

public class classReference {
    public static class A {
        private B ref;

        public void setB(B b) {
            ref = b;
        }

        @Override
        public String toString() {
            return "A{" +
                    "ref=" + ref +
                    '}';
        }
    }

    public static class B {
        private A ref;

        public void setA(A a) {
            ref = a;
        }
    }

    public static void main(String args[]) {

        start();

    }

    public static void start() {
        A a = new A();
        B b = new B();
        a.setB(b);
        System.out.println(a);
        System.out.println(b);
        b = null; //
        System.out.println(a);
        a = null;
    }


}
