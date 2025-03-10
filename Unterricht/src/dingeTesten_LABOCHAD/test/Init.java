package dingeTesten_LABOCHAD.test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Init {
    public static void main(String[] args) {

        LocalDateTime dt = LocalDateTime.of(2014, 7, 31, 1, 1);

        dt.plusDays(30);

        dt.plusMonths(1);

        System.out.print(dt.format(DateTimeFormatter.ISO_DATE));

    }
}
