//варіант 13, тобто 3
package edu.mde.lab1;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
public class Main {
    /* Створити клас, що має статичні методи для обчислення
   значень функцій за даними розрахункових формул зазначених у
   таблиці 1 та наборами вхідних даних. */
    public static double calculateFunc1(double a, double b,
                                        double x) {
        return a/Math.pow(1/(Math.tan(x)), 3) - Math.cos(Math.pow(a * x + b, 2)); //обчислення за формулою першої функції
    }
    public static double calculateFunc2(double a, double b,
                                        double x) {
        return Math.exp(a * Math.cos(x)) + x * Math.pow(Math.log(Math.abs(x + b)), 2); //обчислення за формулою другої функції
    }
    /* Доповнити клас властивостями, які відповідають вхідним
   даним із таблиці 1, встановити їх значення за-замовченням із
   тієї ж таблиці. */
    private double a = 0.001;
    private double b = 0.3;
    private double x = -1;
    /* Доповнити клас методом, який ініціює введення вхідних
   даних, супроводжуючи ввід відповідним текстовим запитом для
   кожної властивості. */
    public void scanValues() {
        final Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть a:");
        this.a = scanner.nextDouble();
        System.out.print("Введіть b:");
        this.b = scanner.nextDouble();
        System.out.print("Введіть x:");
        this.x = scanner.nextDouble();
    }
    /* Доповнити клас методом, що виводить на екран значення
   вхідних даних, супроводжуючи вивід найменуваннями виведених
   змінних. */
    public void printValues() {
        System.out.format("a = %f", a).println();
        System.out.format("b = %f", b).println();
        System.out.format("x = %f", x).println();
    }
    /* Створити метод, що обчислює потрібні значення за
   вказаними формулами, та друкує потрібні результати. */
    public void printResults() {
        System.out.format("f1(x) = %f", calculateFunc1(a, b,
                x)).println();
        System.out.format("f2(x) = %f", calculateFunc2(a, b,
                x)).println();
    }
    /* Додати в клас статичний метод, що друкує поточну дату і
   час у вказаному в таблиці 1 форматі. */
    private static final SimpleDateFormat dateFormat =
            new SimpleDateFormat("MM.dd.yyyy E"); //формат місяць -> день -> рік -> день тижня
    public static void printCurrentDate() {
        final Date now = new Date();
        System.out.format("Поточна дата і час: %s",
                dateFormat.format(now)).println();
    }
    /* Додати в клас метод, що реалізує взаємодію програми із
   користувачем та передбачає наступні режими роботи (передбачити
   повторний вибір пунктів меню під час одного запуску програми):
    - введення значень вхідних даних;
    - виведення значень вхідних даних;
    - виведення обчислених значень заданих функцій;
    - виведення поточної дати і часу у заданому форматі;
    - вихід із меню. */
    public void printMenu() {
        System.out.println("Меню:");
        System.out.println("1. Введення значень вхідних даних");
        System.out.println("2. Виведення значень вхідних даних");
        System.out.println("3. Виведення обчислених значень функцій");
        System.out.println("4. Виведення поточної дати і часу");
        System.out.println("5. Вихід із меню");
    }
    public void runMenu() {
        final Scanner scanner = new Scanner(System.in);
        while (true) {
            printMenu();
            System.out.print("Оберіть пункт меню: ");
            final int selected = scanner.nextInt();
            switch (selected) {
                case 1:
                    scanValues();
                    break;
                case 2:
                    printValues();
                    break;
                case 3:
                    printResults();
                    break;
                case 4:
                    printCurrentDate();
                    break;
                case 5:
                    return;
                default:
                    System.out.println ("Уведене значення має бути у діапазоні 1..5");
            }
        }
    }
    /* Доповнити клас методом main, що є необхідним для
   використання класу, як автономної програми, та виконати
   програму. Програма починає свою роботу із запуском меню. */
    public static void main(String[] args) {
        final Main main = new Main();
        System.out.println("Розпочато роботу із програмою.");
        main.printValues();
        main.runMenu();
        System.out.println("Роботу програми закінчено.");
    }
}
