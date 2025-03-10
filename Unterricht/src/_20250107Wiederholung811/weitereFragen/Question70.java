package _20250107Wiederholung811.weitereFragen;

public class Question70 {
    public static void main(String[] args) {
        Boolean[] bool = {Boolean.parseBoolean("true"), null};
/*        Boolean[] bool = new Boolean[2];
        bool[0] = Boolean.parseBoolean("true"); //bei null
        bool[1] = new Boolean(null);*/ //wird zu false intern umgewandelt, alles was nicht "true" auch false
        System.out.println(bool[0] + " " + bool[1]);
    }
}
