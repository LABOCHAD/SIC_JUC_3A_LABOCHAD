package dingeTesten_LABOCHAD;


    class Parent {
        static {
            System.out.println("Static Parent");
        }

        {
            System.out.println("Instance Parent");
        }
    }

    class Child extends Parent {
        static {
            System.out.println("Static Child");
        }

        {
            System.out.println("Instance Child");
        }
    }

    public class ReihenfolgeBlöckeKonstruktoren {
        public static void main(String[] args) {
            Child obj = new Child();
        }
    }

