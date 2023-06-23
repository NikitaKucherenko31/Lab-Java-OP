package TimeCucl;
import java.util.TreeMap;

public class TimeCalculator {
    private static final TreeMap<Long, String> timeFormats = new TreeMap<>();

    static {
        timeFormats.put(1L, "секунда");
        timeFormats.put(1L * 60, "минут");
        timeFormats.put(60L * 60 * 1, "час");
        timeFormats.put(60L * 60 * 24, "день");
        timeFormats.put(60L * 60 * 24 * 7, "неделя");
        timeFormats.put(60L * 60 * 24 * 30, "месяц");
        timeFormats.put(60L * 60 * 24 * 365, "год");
    }

    public static String formatDuration(long seconds) {
        if (seconds == 0) {
            return "0 секунд";
        }

        StringBuilder result = new StringBuilder();

        for (long format : timeFormats.descendingKeySet()) {
            if (seconds >= format) {
                long amount = seconds / format;
                seconds %= format;

                String label = timeFormats.get(format);

                if (result.length() > 0) {
                    if (seconds > 0) {
                        result.append(", ");
                    } else {
                        result.append(" и ");
                    }
                }

                result.append(amount).append(" ").append(label);
            }
        }

        return result.toString();
    }
}
