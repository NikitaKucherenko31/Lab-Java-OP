package CountNumbInRange;

public class NumbersInRange {
    public static int countNumbersInRange(int[][] intervals) {
        int count = 0;
        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0]; // взятие первого элемента интервала
            int end = intervals[i][1]-1; // взятие второго элемента интервала
            if (start < end) {
                for (int j = start; j <= end; j++) {
                    count++;
                }
            } else {
                for (int j = start; j >= end; j--) {
                    count++;
                }
            }
        }
        return count;
    }

    public static String intervalsToString(int[][] intervals) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < intervals.length; i++) {
            sb.append("[" + intervals[i][0] + ", " + intervals[i][1] + "]");
            if (i < intervals.length - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
}
