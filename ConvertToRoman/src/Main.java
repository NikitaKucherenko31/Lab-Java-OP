import convToRoman.AgeConverter;
import java.util.Scanner;
// Задание 45
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите количество лет (1 < n < 10000): ");
        int age = sc.nextInt();
        if (age < 1 || age > 9999) {
            System.out.println("Неверный ввод!");
            return;
        }
        String romanAge = AgeConverter.convertToRoman(age);
        System.out.println("Римское представление: " + romanAge);
    }
}