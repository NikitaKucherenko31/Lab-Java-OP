import CountNumbInRange.NumbersInRange;
// Задание 42
public class Main {
    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {6, 10}, {11, 15}};
        int count = NumbersInRange.countNumbersInRange(intervals);
        System.out.println("Количество чисел между интервалами: " +
                NumbersInRange.intervalsToString(intervals) + " => " + count);
    }
}