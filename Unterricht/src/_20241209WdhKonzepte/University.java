package _20241209WdhKonzepte;

/**
 * Erstelle eine Klasse, die die Verwaltung eines Universitäts-Kurses simuliert. Verwende static und final Variablen sowie Methoden, um Informationen zu speichern und zu verwalten.
 * Anforderungen:
 * Statische Variablen:
 * Implementiere eine statische Variable studentCount, die die Anzahl der eingeschriebenen Studenten zählt.
 * Statische Methoden:
 * Implementiere eine statische Methode incrementStudentCount(), um die Anzahl der eingeschriebenen Studenten zu erhöhen.
 * Implementiere eine statische Methode decrementStudentCount(), um die Anzahl der eingeschriebenen Studenten zu verringern.
 * Implementiere eine statische Methode printCourseInfo(), um die Kursinformationen auszugeben.
 * Finale Variablen:
 * Implementiere eine finale Variable courseName, die den Namen des Kurses speichert und im Konstruktor initialisiert wird.
 * Implementiere eine finale Variable MAX_STUDENTS, die die maximale Anzahl der Studenten festlegt und mit einem statischen Block initialisiert wird.
 * Statische Initialisierungsblöcke:
 * Implementiere einen statischen Block zur Initialisierung der finalen Variablen.
 * Statische verschachtelte Klasse:
 * Implementiere eine statische verschachtelte Klasse Student, die Informationen über die Studenten speichert.
 *
 */


public class University {
    private static int studentCount;
    private final String COURSE_NAME;

    University(){
        COURSE_NAME = "Java in 9 Monaten";
    }


    public static void incrementStudentCount(){
        studentCount++;
    }

    public static void decrementStudentCount(){
        studentCount--;
    }

    public static void printCourseInfo(){
        University uni = new University();
        System.out.println(uni.COURSE_NAME);
    }
    
    


}
