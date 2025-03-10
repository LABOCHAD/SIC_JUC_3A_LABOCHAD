package dingeTesten_LABOCHAD;

public class BooleanArrayNull {
    public static void main(String[] args) {
        Boolean[] bool = new Boolean[2];
        bool[0] = new Boolean("false");
        bool[1] = new Boolean(null);
        System.out.println(bool[0]+" "+bool[1]);
        //Das null wird vom Boolean-Konstruktor zu false gemacht.
        //Alles was case-ignoring true ergibt es true. Alles andere einschließlich null ist false.
    }
}
