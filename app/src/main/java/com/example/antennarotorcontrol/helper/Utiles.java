package com.example.antennarotorcontrol.helper;

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public class Utiles {

    public static String parseId(String value) {
        try {
            return new SimpleDateFormat("yyyyMMddHHmmss"/*"hh:mm:ss dd.MM.yyyy"*/, Locale.GERMANY)
                    .format(new SimpleDateFormat("HH:mm:ss dd.MM.yyyy", Locale.GERMANY)
                            .parse(parseDate(value)));
        } catch (ParseException e) {
            e.printStackTrace();
            Log.e("idd", e.getLocalizedMessage());
            e.printStackTrace();
        }
        return parseDate(value);
    }

    public static String parseDate(String value) {
        value = value.replaceAll("^\\s+|\\s+\\s+|\\s+$", "");
        int epoch = Integer.parseInt(value.substring(0, 2), 10);
        double days = Double.parseDouble(value.substring(2));
        Date d = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(d);
        int year = calendar.get(Calendar.YEAR);
        int currentEpoch = year % 100;
        int century = year - currentEpoch;
        year = (epoch > currentEpoch + 1) ? century - 100 + epoch : century + epoch;

        double day = Math.floor(days);
        double hours = 24 * (days - day);
        double hour = Math.floor(hours);
        double minutes = 60 * (hours - hour);
        double minute = Math.floor(minutes);
        double seconds = 60 * (minutes - minute);
        double second = Math.floor(seconds);
        //double millisecond = 1000 * (seconds - second);
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss dd.MM.yyyy", Locale.GERMANY);
            dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            return dateFormat.format(new SimpleDateFormat("D.y HH:mm:ss", Locale.GERMANY)
                    .parse((int) (day +1) + "." + year + " " + (int) hour + ":" + (int) minute + ":" + (int) second));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }
}
