package _20250207WdhBedingungenSchleifenArrays;

public class JobAgeTernary {
    public static void main(String[] args) {
        int age = 25;
        boolean isStudent = true;
        boolean hasJob = false;
        String result = "";


        if (age < 18) {
            result = "Du bist noch ein Jugendlicher.";
        } else if (age >= 18 && age <= 30) {
            if (isStudent) {
                result = "Du bist ein Student.";
            } else {
                result = "Du bist ein junger Erwachsener.";
            }
        } else {
            result = "Du bist ein erfahrener Erwachsener.";
        }

        System.out.println(result);

        result = (age < 18) ? "Du bist noch ein Jugendlicher." :
                ((age <= 30) ?
                        ((isStudent) ? "Du bist ein Student."
                            : "Du bist ein junger Erwachsener.")

                        : "Du bist ein erfahrener Erwachsener.");

        System.out.println(result);
    }

}
