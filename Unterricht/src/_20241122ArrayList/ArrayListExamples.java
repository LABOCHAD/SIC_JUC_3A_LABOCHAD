package _20241122ArrayList;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExamples {

    // Eine ArrayList von Strings erstellen
    ArrayList<String> list = new ArrayList<>();

    //Beispiele: Verschiedene Varianten der Deklaration, die auch in den Test zu finden sein werden
    //TODO Korrekter Import
    //TODO Bitte um Erklärung zum Unterschied von Liste und Arrays bzw. Array-Listen
    List list2 = new ArrayList();

    //Copy an existing list
    ArrayList<String> stringList = new ArrayList<String>(list);

    //List is of type Students
    List<Student> list1 = new ArrayList<>();
}

//Only helper for no error in line 15
class Student{}