package edu.osu.cse.healthapp.helper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by siddhi on 4/7/15.
 */
public class Helper {
    public static String getDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Date date;
        date = new Date();
        return dateFormat.format(date);
    }

    public static boolean isValidInt(String s) {
        return (!s.isEmpty() && s.matches("[0-9]*"));
    }

    public static boolean isValid(String s) {
        return (!s.isEmpty() && s.matches("[0-9]*\\.?[0-9]*"));
    }
}
