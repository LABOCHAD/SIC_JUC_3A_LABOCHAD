# Aufgaben – Wiederholungs-Montag – Unterricht

## Aufgabe „static“

Erstelle ein Programm, das die Fläche eines Kreises und eines Rechtecks berechnet. Definiere die folgenden Konstanten in einer eigenen Klasse:

- Der Wert von PI für die Berechnung der Kreisfläche.
- Die Länge und Breite für die Berechnung der Fläche eines Rechtecks.

Verlagere die Berechnungsmethoden in eine separate Klasse und stelle sicher, dass die Konstanten in einer eigenen Klasse zentral verwaltet werden. Die Berechnungen sollen mit den Konstanten aus der separaten Klasse erfolgen.

- Die Formel für die Fläche des Kreises ist: `A = PI * r²` (wobei r der Radius des Kreises ist).
- Die Formel für die Fläche des Rechtecks ist: `A = Länge * Breite`.

Verwende die `static final` Deklaration für die Konstanten, um sicherzustellen, dass ihre Werte nach der Initialisierung nicht mehr verändert werden können.

## Aufgabe „ternäre Operator“

Schreibe ein Programm, das eine Zahl überprüft und angibt, ob sie gerade oder ungerade ist. Verwende sowohl den ternären Operator als auch die `if`-Anweisung, um dies zu tun.

Die Ausgabe soll folgendermaßen aussehen:

„Die Zahl [Zahl] ist gerade.“ oder „Die Zahl [Zahl] ist ungerade.“

- Erstelle dazu zwei Methoden: eine, die den ternären Operator verwendet, und eine, die eine `if`-Anweisung verwendet.
- Vergleiche die beiden Ansätze und erkläre, wann der ternäre Operator sinnvoll eingesetzt wird. (In einem Kommentar)

## Aufgabe „Schleifen“

Schreibe zwei Methoden, die die Zahlen von 1 bis 10 sowohl mit einer kopfgesteuerten als auch mit einer fußgesteuerten Schleife ausgibt.

- Verwende eine `for`-Schleife für die kopfgesteuerte Schleife.
- Verwende eine `do-while`-Schleife für eine fußgesteuerte Schleife.
- Vergleiche die beiden Ansätze und erkläre, wann welche Schleife sinnvoll eingesetzt wird. (In einem Kommentar)

## Aufgabe „Wrapper und Casten“

Stell dir vor, du hast ein System zur Verwaltung von Produktpreisen in einem Online-Shop. Der Preis eines Produkts wird als `double` gespeichert, aber du musst auch mit verschiedenen Wrapper-Klassen arbeiten, um mit der Datenbank zu interagieren (die Werte als `Double` speichert) und später mit den Produktpreisen Rechnungen zu erstellen, die auf `int` basieren.

- Erstelle eine Methode, die einen Produktpreis als `double` empfängt, diesen in ein `Double` (Wrapper-Klasse) umwandelt und die Mehrwertsteuer (z.B. 19%) darauf berechnet.
- Erstelle eine Methode, die den Mehrwertsteuerbetrag als `Double` empfängt, diesen in den primitiven Datentyp `double` umwandelt und den Endpreis des Produkts berechnet (Preis inkl. MwSt.).
- Erstelle eine weitere Methode, die einen `Double` Preis empfängt, diesen in `int` umwandelt und den Endpreis in Cent zurückgibt.
