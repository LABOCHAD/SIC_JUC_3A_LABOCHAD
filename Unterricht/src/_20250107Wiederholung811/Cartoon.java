package _20250107Wiederholung811;

class Cartoon {
    String name;

    Cartoon(String name) {
        this.name = name;
    }

    // line n1
    //@Override
    public boolean equals(Cartoon c) {
        return this.name.equals(c.name);

    }

    public static void main(String[] args) {
        Cartoon c1 = new Cartoon("tom");
        Cartoon c2 = new Cartoon("tom");
// line n2
        System.out.println(c2.name.equals(c1.name));
        System.out.println(c1.equals(c2));
    }

}
