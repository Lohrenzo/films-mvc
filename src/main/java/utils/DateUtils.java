package utils;
import java.util.Date;
import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;

public class DateUtils {
    public static String timeAgo(Timestamp date) {
    	long diff = new Date().getTime() - date.getTime();
        long minutes = TimeUnit.MINUTES.convert(diff, TimeUnit.MILLISECONDS);
        long hours = TimeUnit.HOURS.convert(diff, TimeUnit.MILLISECONDS);
        long days = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);

        if (diff < TimeUnit.MINUTES.toMillis(1)) {
            return "just now";
        } else if (diff < TimeUnit.HOURS.toMillis(1)) {
            return minutes + " minute" + (minutes == 1 ? "" : "s") + " ago";
        } else if (diff < TimeUnit.DAYS.toMillis(1)) {
            return hours + " hour" + (hours == 1 ? "" : "s") + " ago";
        } else if (diff < TimeUnit.DAYS.toMillis(7)) {
            return days + " day" + (days == 1 ? "" : "s") + " ago";
        } else {
            return new java.text.SimpleDateFormat("MMM dd, yyyy").format(date);
        }
    }
}
