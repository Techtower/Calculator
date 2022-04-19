package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {}

    public static String calc(String input) throws Exception {
        Scanner console = new Scanner(System.in);                                                                        // Считываем введённые пользователем данные в виде строки
        String numbers = console.nextLine();
        numbers = numbers.replaceAll("\\s", "");                                                         // Убираем пробелы в строке


        String firstSide, secondSide;                                                                                    // Создаём необходимые строки для сортировки
        String Arab = "12345678910";
        String Roman = "IIIVIIIX";


        if (numbers.contains("+")) {                                                                                     // Делим строку на массив
            String[] Sides = numbers.split("[+*/-]");
            firstSide = Sides[0];
            secondSide = Sides[1];
            if (Sides.length > 2) {                                                                                      // Фиксируем исключение при вводе более двух операнд
                throw new Exception("Формат математической операции не удовлетворяет заданию - два операнда " +
                        "и один оператор (+, -, *, /). Попробуйте ещё раз!");
            }
        } else if (numbers.contains("-")) {
            String[] Sides = numbers.split("[+*/-]");
            firstSide = Sides[0];
            secondSide = Sides[1];
            if (Sides.length > 2) {
                throw new Exception("Формат математической операции не удовлетворяет заданию - два операнда " +
                        "и один оператор (+, -, *, /). Попробуйте ещё раз!");
            }
        } else if (numbers.contains("*")) {
            String[] Sides = numbers.split("[+*/-]");
            firstSide = Sides[0];
            secondSide = Sides[1];
            if (Sides.length > 2) {
                throw new Exception("Формат математической операции не удовлетворяет заданию - два операнда " +
                        "и один оператор (+, -, *, /). Попробуйте ещё раз!");
            }
        } else if (numbers.contains("/")) {
            String[] Sides = numbers.split("[+*/-]");
            firstSide = Sides[0];
            secondSide = Sides[1];
            if (Sides.length > 2) {
                throw new Exception("Формат математической операции не удовлетворяет заданию - два операнда " +
                        "и один оператор (+, -, *, /). Попробуйте ещё раз!");
            }
        } else {
            throw new Exception("Оператор не найден! Строка не является математической операцией! " +                    // Фиксируем исключение при вводе одной операнды
                    "Попробуйте ещё раз, используя (+, -, *, /)!");
        }


        if (Arab.contains(firstSide) && Arab.contains(secondSide)) {
            Methods.ArabicNumerals(firstSide, secondSide, numbers);
        } else if (Roman.contains(firstSide) && Roman.contains(secondSide)) {
            Methods.RomanianNumerals(firstSide, secondSide, numbers);
        } else if ((Arab.contains(firstSide) && Roman.contains(secondSide)) ||
                (Roman.contains(firstSide) && Arab.contains(secondSide))) {
            throw new Exception("Ошибка! Одновременно используются разные системы счисления! " +
                    "Попробуйте ещё раз!");
        } else {
            throw new Exception("Калькулятор принимает на вход только числа от 1 до 10, если применяется арабская " +    // Фиксируем исключение (n > 10)
                    "система счисления, или от I до X, если применяется римская система счисления! " +
                    "Попробуйте ещё раз!");
        }

        return input;
    }
}

class Methods {

    public static void ArabicNumerals(String firstSide, String secondSide, String numbers) throws Exception {

        int a = Integer.parseInt(firstSide);
        int b = Integer.parseInt(secondSide);

        if (a == 0 || b == 0 || a > 10 || b > 10) {                                                                      // Фиксируем исключение при работе со строкой Arab (n > 10)
            throw new Exception("Калькулятор принимает на вход только числа от 1 до 10! " +
                    "Попробуйте ещё раз!");
        } else if (numbers.contains("-")) {
            int result = a - b;
            System.out.println("Ответ: " + result);
        } else if (numbers.contains("+")) {
            int result = a + b;
            System.out.println("Ответ: " + result);
        } else if (numbers.contains("*")) {
            int result = a * b;
            System.out.println("Ответ: " + result);
        } else if (numbers.contains("/")) {
            int result = a / b;
            System.out.println("Ответ: " + result);
        }
    }


    public static void RomanianNumerals(String firstSide, String secondSide, String numbers) throws Exception {

        String[] Romanian = {"Null","I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
                "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
                "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C",};

            int a = 0, b = 0, result;
            for (int i = 0; i < Romanian.length; i++) {
                String Character = Romanian[i];
                if (Character.equals(firstSide)) {
                    a = i;
                }

                if (Character.equals(secondSide)) {
                    b = i;
                }
            }

                if (numbers.contains("+")) {
                    result = a + b;
                        if (result <= 0) {
                            throw new Exception("Ошибка! При вычислении получилось отрицательное число. " +
                                    "В римской системе счисления нет отрицательных чисел.");
                        }
                    System.out.println(Romanian[result]);
                } else if (numbers.contains("-")) {
                    result = a - b;
                        if (result <= 0) {
                            throw new Exception("Ошибка! При вычислении получилось отрицательное число. " +
                                    "В римской системе счисления нет отрицательных чисел.");
                    }
                    System.out.println(Romanian[result]);
                } else if (numbers.contains("*")) {
                    result = a * b;
                        if (result <= 0) {
                            throw new Exception("Ошибка! При вычислении получилось отрицательное число. " +
                                    "В римской системе счисления нет отрицательных чисел.");
                    }
                    System.out.println(Romanian[result]);
                } else if (numbers.contains("/")) {
                    result = a / b;
                        if (result <= 0) {
                            throw new Exception("Ошибка! При вычислении получилось отрицательное число. " +
                                    "В римской системе счисления нет отрицательных чисел.");
                    }
                    System.out.println(Romanian[result]);
                }
    }
}
