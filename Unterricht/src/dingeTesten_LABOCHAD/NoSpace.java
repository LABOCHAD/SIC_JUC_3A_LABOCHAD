package dingeTesten_LABOCHAD;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class NoSpace {
    public static void main(String[] args) {
        char[]c = new char[10]; //hier darf das Leerzeichen fehlen nach den [], length variable, nicht length() methode
        //charc = new char[10]; //hier wieder nicht
        
        LocalDateTime now = LocalDateTime.now();
        now.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT));
    }
}
