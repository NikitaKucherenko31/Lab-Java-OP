package packRangeSearch;
import java.util.Arrays;
// Задание 40
public class RangeSearch {
    public static String rangeSearch(int[] array) {
        StringBuilder sb = new StringBuilder("'");
        Arrays.sort(array);
        int min = array[0];
        int max = array[0];

        for ( int i : array ) {

            if ( max == i ) continue;

            if ( Math.abs(max-i) > 1 ){
                if ( sb.length() > 1 ) sb.append(",");
                sb.append(max == min ? min : min+"-"+max);
                min = i;
                max = i;
            } else {
                max = i;
            }
        }

        if ( sb.length() > 1 ) sb.append(",");
        sb.append(max == min ? min : min+"-"+max);
        sb.append("'");

        return sb.toString();
    }
}
