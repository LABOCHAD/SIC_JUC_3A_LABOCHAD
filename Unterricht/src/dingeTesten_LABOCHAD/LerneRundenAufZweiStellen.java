package dingeTesten_LABOCHAD;

import java.util.Scanner;
import java.text.DecimalFormat;


public class LerneRundenAufZweiStellen {
    public static void main(String[] args) {
        Scanner nameDesScannerObjekts = new Scanner(System.in);
        double eingang = 1.23456789;
        double ausgang;
        String str_ausgang;

        //Variante 1 math.round(x*100)/100
            //round rundet ganzzahlig, deshalb * darin
            // 100, weil 2 Nachkommastellen
            // ein Wert muss double sein, sonst kommt long (1.0) raus
        ausgang = Math.round(eingang*100)/(double)100;

        //Variante 2 DecimalFormatter (einfacher), aber als String
        //oben:         import java.text.DecimalFormat;
        DecimalFormat decimalFormat = new DecimalFormat("#.##"); //Für 2 Nachkommastellen
        str_ausgang = decimalFormat.format(eingang);



        System.out.println("Zahl: " + eingang);
        System.out.println("Gerundet als double mit math.round(x*100)/(double)100: " + ausgang); //1.23
        System.out.println("Gerundet als String mit DecimalFormat pattern #.## " + str_ausgang); //1,23
    }
}
