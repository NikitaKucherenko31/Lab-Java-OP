package convToRoman;

public class AgeConverter {
    public static String convertToRoman(int age) {
        String[] thousands = {"", "M", "MM", "MMM", "IV", "V", "VI", "VII", "VII", "IX"};
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return thousands[age / 1000] + hundreds[(age % 1000) / 100] + tens[(age % 100) / 10] + ones[age % 10];
    }
}
