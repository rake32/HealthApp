package edu.osu.cse.healthapp.helper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by siddhi on 4/7/15.
 */
public class Helper {
    public static Date getDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd", Locale.getDefault());
        Date date;
        date = new Date();
        return date;
        //return dateFormat.format(date);
    }

    public static boolean isValidInt(String s) {
        return (!s.isEmpty() && s.matches("[0-9]*"));
    }

    public static boolean isValid(String s) {
        return (!s.isEmpty() && s.matches("[0-9]*\\.?[0-9]*"));
    }
}
