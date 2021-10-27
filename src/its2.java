import java.util.InputMismatchException;
import java.util.Scanner;

//В программе, где требуется для квадратной матрицы с элементами, введенными
//с клавиатуры, вывести максимальный четный элемент на побочной диагонали,
//могут возникать ошибки в следующих случаях:
//– ввод строки вместо числа;
//– нет четных чисел.
public class its2 {
    private static Scanner scanner = new Scanner(System.in,"cp1251");

    private static int size;
    private static int matrix[][];

    public static void main(String[] args) {
        System.out.println("Введите длину стороны квадратной матрицы");
        try {
            inputMatrix();
            System.out.println("максимальное четное число в побочной диагонали: " + findGreatestEvenInSizeDiagonal());
        } catch (InputMismatchException e) {
            System.out.println("Введено неправильное значение!");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    private static int findGreatestEvenInSizeDiagonal() {
        int biggestEven = matrix[size - 1][0];
        for (int i = 1; i < size; i++) {
            int current = matrix[(size - 1) - i][i];
            if (biggestEven % 2 != 0)
                biggestEven = current;
            else if ((current % 2 == 0) && (current > biggestEven))
                biggestEven = current;
        }
        if (biggestEven%2 != 0)
            throw new RuntimeException("В побочной диагонали нет четных чисел");
        return biggestEven;
    }

    private static void inputMatrix() throws InputMismatchException {
        size = typeInt();
        matrix = new int[size][size];
        System.out.println("Введите элементы матрицы: ");
        for (int i = 0; i < size * size; i++) {
            System.out.print("[" + i % size + ", " + i / size + "]: ");
            matrix[i % size][i / size] = typeInt();
        }
    }

    private static int typeInt() {
        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }
}
