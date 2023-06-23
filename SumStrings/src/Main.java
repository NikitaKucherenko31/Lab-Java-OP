import SumStrings.AddStrings;
import java.util.Scanner;
// Задание 44
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите первое число: ");
        String number1 = sc.nextLine();
        System.out.print("Введите второе число: ");
        String number2 = sc.nextLine();
        String result = AddStrings.addStrings(number1, number2);
        System.out.print("Сумма: ");
        System.out.print(result);
    }
}