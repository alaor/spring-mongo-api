package com.dito.config;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class DateUtil {

    public static String now(){
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatador = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)
                .withLocale(new Locale("pt", "br"));
        return dateTime.format(formatador);
    }

}
