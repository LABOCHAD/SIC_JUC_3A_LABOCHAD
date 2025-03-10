package _20250207WdhBedingungenSchleifenArrays;

import java.util.Arrays;

public class ÜbungArraySchülerNoten {
    public static void main(String[] args) {
        System.out.println();
        String[] schueler = {"Anna", "Ben", "Clara", "David", "Emma"};
        int[][] noten = {{2, 3, 1}, {4, 2, 5}, {1, 1, 2}, {3, 4, 2}, {2, 3, 3}};
        String bestStudent = "";
        double bestAverageFound = 6.0; //wenn überschrieben, wenn besseren Schnitt gefunden

        for (int s = 0; s < schueler.length; s++) { //schüler
            int gradeSum = 0;

            for (int n = 0; n < noten[s].length; n++) {
                gradeSum += noten[s][n];
            }

            //könnte auch einfach 3 sein, aber so ist es dynamischer
            double average = (double) gradeSum / noten[s].length;
            System.out.printf("%s: Durschnittsnote = %.2f%n", schueler[s], average);

            if (average < bestAverageFound) {
                bestAverageFound = average;
                bestStudent = schueler[s];
            }
        }

        System.out.printf("%n%s hat mit %.2f den besten Notendurchschnitt.", bestStudent, bestAverageFound);
    }
}
