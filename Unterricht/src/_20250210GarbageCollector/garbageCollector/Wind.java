package _20250210GarbageCollector.garbageCollector;

public class Wind {
    int id;
    Wind(int id){
        this.id = id;
    }

    public static void main(String[] args) {
        new Wind(3).go();
    }

    void go(){
        Wind w1 = new Wind(1);
        Wind w2 = new Wind(2);
        System.out.println(w1.id + " " + w2.id);
    }
}
