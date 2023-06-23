package SumStrings;

public class AddStrings {
    public static String addStrings(String number1, String number2) {
        StringBuilder sb = new StringBuilder();
        int mentally = 0;
        int i = number1.length() - 1;
        int j = number2.length() - 1;
        while (i >= 0 || j >= 0) {
            int digit1 = i >= 0 ? number1.charAt(i) - '0' : 0;
            int digit2 = j >= 0 ? number2.charAt(j) - '0' : 0;
            int sum = digit1 + digit2 + mentally;
            mentally = sum / 10;
            sb.append(sum % 10);
            i--;
            j--;
        }
        if (mentally != 0) {
            sb.append(mentally);
        }
        return sb.reverse().toString();
    }

}
