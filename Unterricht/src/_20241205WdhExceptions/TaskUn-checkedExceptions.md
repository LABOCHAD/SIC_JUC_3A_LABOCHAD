# Zusammenfassung: Unterschied zwischen checked und unchecked Exceptions

In dieser Aufgabe lernst du den Unterschied zwischen **checked** und **unchecked Exceptions** und wie du mit beiden Arten von Ausnahmen in Java umgehst. Hier sind die wichtigsten Punkte, die du verstehen und anwenden solltest:

## 1. **Checked Exceptions**

- **Was sind checked Exceptions?**
    - **Checked Exceptions** sind Ausnahmen, die vom Compiler überprüft werden. Wenn eine Methode eine **checked Exception** werfen kann, muss sie dies entweder in der Methodensignatur mit `throws` deklarieren oder die Exception innerhalb der Methode mit einem `try-catch`-Block behandeln.
    - Beispiel: Eine `DivisionDurchNullException`, die wir auslösen, wenn der Divisor 0 ist.

- **Wie gehst du mit checked Exceptions um?**
    - Du musst sicherstellen, dass du die **checked Exception** behandelst. Entweder mit einem `try-catch`-Block oder durch Deklarieren der Exception in der Methodensignatur.
    - Der Compiler zwingt dich, dies zu tun. Wenn du das nicht tust, wird ein Fehler angezeigt.

## 2. **Unchecked Exceptions**

- **Was sind unchecked Exceptions?**
    - **Unchecked Exceptions** sind Ausnahmen, die von `RuntimeException` oder einer ihrer Unterklassen erben. Diese Exceptions müssen nicht vom Compiler behandelt werden.
    - Sie treten in der Regel bei logischen Fehlern auf, z.B. wenn du versuchst, ein negatives Alter zu prüfen.

- **Wie gehst du mit unchecked Exceptions um?**
    - **Unchecked Exceptions** können entweder behandelt oder ignoriert werden. Wenn du sie ignorierst, wird das Programm ohne Fehler fortgesetzt (es sei denn, es gibt einen Absturz). Wenn du sie behandeln möchtest, kannst du einen `try-catch`-Block verwenden, aber der Compiler verlangt dies nicht.
    - Wenn du eine **unchecked Exception** wirfst und sie nicht behandelst, kann das Programm bei der Ausführung abstürzen.

## 3. **Erstellung von benutzerdefinierten Exceptions**

- Du kannst deine eigenen Ausnahmen erstellen, die entweder **checked** oder **unchecked** sind:
    - Eine **checked Exception** erbt von der `Exception`-Klasse.
    - Eine **unchecked Exception** erbt von der `RuntimeException`-Klasse.

- Beispiel:
    - Eine benutzerdefinierte **checked Exception**: `DivisionDurchNullException`.
    - Eine benutzerdefinierte **unchecked Exception**: `InvalidAgeException`.

## 4. **Verhalten der Exceptions**

- **Checked Exceptions** müssen explizit behandelt oder in der Methodensignatur deklariert werden. Der Compiler erzwingt dies.
- **Unchecked Exceptions** müssen nicht behandelt werden und können das Programm ohne Fehlerbehandlung zum Absturz bringen.

## 5. **Wichtige Punkte**

- **Checked Exceptions**: Du musst sie entweder in der Methode deklarieren oder behandeln. Der Compiler zeigt einen Fehler, wenn du dies nicht tust.
- **Unchecked Exceptions**: Du musst sie nicht behandeln, aber das Fehlen einer Behandlung kann dazu führen, dass das Programm während der Ausführung abstürzt.
- **Praktische Anwendung**: Du kannst lernen, wie du beide Arten von Exceptions im Code korrekt verwendest und warum es wichtig ist, zu wissen, welche Art von Exception du verwendest.

## 6. **Was du in dieser Aufgabe zeigen sollst**

- **Verständnis des Unterschieds** zwischen **checked** und **unchecked Exceptions**.
- **Erstellung und Verwendung von benutzerdefinierten Exceptions** (mit beiden Arten von Ausnahmen).
- **Behandlung von checked Exceptions** mit `try-catch`-Blöcken.
- **Verhalten von unchecked Exceptions**: Du kannst sie entweder behandeln oder das Fehlen der Behandlung zeigen, was zum Absturz des Programms führen kann.

Nutze diese Erkenntnisse, um den Unterschied in der Praxis zu sehen und zu verstehen, wie du mit Ausnahmen in Java umgehen kannst!

# Aufgabe: Unterschied zwischen checked und unchecked Exceptions

## Aufgabenstellung

Du sollst eine kleine Anwendung erstellen, die mit verschiedenen Arten von Ausnahmen arbeitet, um den Unterschied zwischen **checked** und **unchecked** Exceptions in Java zu demonstrieren.

### 1. Erstelle die Klasse `Mathematik`
In dieser Klasse soll eine Methode `teilen(int a, int b)` erstellt werden, die zwei Zahlen durchführt. Wenn der Divisor `b` null ist, soll eine **checked Exception** geworfen werden, z.B. `DivisionDurchNullException`.

### 2. Erstelle die Klasse `Benutzer`
In dieser Klasse soll eine Methode `alterPruefen(int alter)` erstellt werden, die überprüft, ob das Alter negativ ist. Wenn das Alter negativ ist, soll eine **unchecked Exception** geworfen werden, z.B. `InvalidAgeException` (die eine `RuntimeException` ist).

### 3. Verwende beide Methoden in der `Main`-Klasse
In der `main`-Methode rufst du die Methoden `teilen()` und `alterPruefen()` auf. Stelle sicher, dass du:
- Die **checked Exception** korrekt mit einem `try-catch`-Block behandelst.
- Die **unchecked Exception** entweder explizit fängst oder nicht fängst, um den Unterschied zu zeigen (optional kannst du auch zeigen, wie sie durch das Fehlen eines `try-catch`-Blocks eine Anwendung zum Absturz bringen kann).

### Anforderungen:
1. **Erstelle eine `DivisionDurchNullException`**:  
   Dies ist eine benutzerdefinierte **checked Exception**. Diese Exception wird geworfen, wenn versucht wird, eine Zahl durch null zu teilen.

2. **Erstelle eine `InvalidAgeException`**:  
   Dies ist eine benutzerdefinierte **unchecked Exception** (von `RuntimeException` abgeleitet). Diese Exception wird geworfen, wenn ein ungültiges (negatives) Alter eingegeben wird.

3. **Verwende die Exceptions in der `main`-Methode**:
    - Zeige den Unterschied, indem du versuchst, eine Division durch null durchzuführen und die `DivisionDurchNullException` mit einem `try-catch`-Block abfängst.
    - Zeige ebenfalls, wie die `InvalidAgeException` geworfen wird und entweder abgefangen oder nicht abgefangen wird.

### Hinweise:
- **Checked Exception:** Eine **checked Exception** (wie `DivisionDurchNullException`) muss entweder in der Methode, die sie wirft, mit `throws` deklariert werden, oder sie muss in einem `try-catch`-Block abgefangen werden. Der Compiler verlangt, dass mit diesen Ausnahmen explizit umgegangen wird.

- **Unchecked Exception:** Eine **unchecked Exception** (wie `InvalidAgeException`) ist eine Ausnahme, die nicht zwingend abgefangen werden muss. Sie ist eine Unterklasse von `RuntimeException`, und der Compiler erzwingt nicht, dass mit ihr umgegangen wird.

### Erweiterung (Optional):
- Füge einen weiteren Block hinzu, der den Versuch zeigt, beide Exceptions zu behandeln oder die Anwendung bei der `unchecked Exception` abstürzen zu lassen, um den Unterschied noch klarer zu machen.
