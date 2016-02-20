package ws.security.service.utils;

import javax.xml.bind.DatatypeConverter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class DateAdapter {

    /**
     * Date time
     *
     * @param s - A string containing lexical representation of xsd:Date.
     * @return - Date representing the time value.
     */
    public static Date parseDate(String s) {
        if (s == null) {
            return null;
        }
        return DatatypeConverter.parseDateTime(s).getTime();
    }

    /**
     * Convert data as dateTime in format Gregorian calendar
     *
     * @param dt - date the given Date
     * @return - A string containing a lexical representation of xsd:datetime
     */
    public static String printDate(Date dt) {
        if (dt == null) {
            return null;
        }
        Calendar cal = new GregorianCalendar();
        cal.setTime(dt);
        return DatatypeConverter.printDateTime(cal);
    }

    /**
     * Convert data in format Gregorian calendar
     *
     * @param dt - date the given Date
     * @return - A string containing a lexical representation of xsd:date
     */
    public static String printDateOnly(Date dt) {
        if (dt == null) {
            return null;
        }
        Calendar cal = new GregorianCalendar();
        cal.setTime(dt);
        return DatatypeConverter.printDate(cal);
    }
}
