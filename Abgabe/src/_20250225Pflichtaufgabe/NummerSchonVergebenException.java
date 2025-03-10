package _20250225Pflichtaufgabe;

public class NummerSchonVergebenException extends Exception {
    // Checked Exception
    NummerSchonVergebenException(){super("Diese Nummer gibt es schon.");}
    NummerSchonVergebenException(String message){super(message);}

}
