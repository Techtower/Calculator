package com.company;
import java.util.Scanner;

public class Main {

    public static void main (String [] args) throws Exception {

        Scanner console = new Scanner(System.in);                                                                        // Считываем введённые пользователем данные в виде строки
        String input = console.nextLine();
        System.out.println(Calc(input));
    }

     public static String Calc (String input) throws Exception {

        input = input.replaceAll("\\s", "");

        String firstSide, secondSide;                                                                                    // Создаём необходимые строки для сортировки
        String Arab = "12345678910";
        String Roman = "IIIVIIIX";


        if (input.contains("+")) {                                                                                       // Делим строку на массив
            String[] Sides = input.split("[+*/-]");
            firstSide = Sides[0];
            secondSide = Sides[1];
            if (Sides.length > 2) {                                                                                      // Фиксируем исключение при вводе более двух операнд
                throw new Exception("Формат математической операции не удовлетворяет заданию - два операнда " +
                        "и один оператор (+, -, *, /). Попробуйте ещё раз!");
            }
        } else if (input.contains("-")) {
            String[] Sides = input.split("[+*/-]");
            firstSide = Sides[0];
            secondSide = Sides[1];
            if (Sides.length > 2) {
                throw new Exception("Формат математической операции не удовлетворяет заданию - два операнда " +
                        "и один оператор (+, -, *, /). Попробуйте ещё раз!");
            }
        } else if (input.contains("*")) {
            String[] Sides = input.split("[+*/-]");
            firstSide = Sides[0];
            secondSide = Sides[1];
            if (Sides.length > 2) {
                throw new Exception("Формат математической операции не удовлетворяет заданию - два операнда " +
                        "и один оператор (+, -, *, /). Попробуйте ещё раз!");
            }
        } else if (input.contains("/")) {
            String[] Sides = input.split("[+*/-]");
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
            Methods.ArabicNumerals(firstSide, secondSide, input);
            String ReturnArabian = Methods.ArabicNumerals(firstSide, secondSide, input);
            input = ReturnArabian;
        } else if (Roman.contains(firstSide) && Roman.contains(secondSide)) {
            Methods.RomanianNumerals(firstSide, secondSide, input);
            String ReturnRomanian = Methods.RomanianNumerals(firstSide, secondSide, input);
            input = ReturnRomanian;
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

    public static String ArabicNumerals (String firstSide, String secondSide, String input) throws Exception {

        String[] Arabian = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
                "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
                "21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
                "31", "32", "33", "34", "35", "36", "37", "38", "39", "40",
                "41", "42", "43", "44", "45", "46", "47", "48", "49", "50",
                "51", "52", "53", "54", "55", "56", "57", "58", "59", "60",
                "61", "62", "63", "64", "65", "66", "67", "68", "69", "70",
                "71", "72", "73", "74", "75", "76", "77", "78", "79", "80",
                "81", "82", "83", "84", "85", "86", "87", "88", "89", "90",
                "91", "92", "93", "94", "95", "96", "97", "98", "99", "100",};

        int a = Integer.parseInt(firstSide);
        int b = Integer.parseInt(secondSide);
        int result = 0;

        if (a == 0 || b == 0 || a > 10 || b > 10) {                                                                      // Фиксируем исключение при работе со строкой Arab (n > 10)
            throw new Exception("Калькулятор принимает на вход только числа от 1 до 10! " +
                    "Попробуйте ещё раз!");
        } else if (input.contains("-")) {
            result = a - b;
        } else if (input.contains("+")) {
            result = a + b;
        } else if (input.contains("*")) {
            result = a * b;
        } else if (input.contains("/")) {
            result = a / b;
        }


            input = Arabian[result];
        return input;
    }


    public static String RomanianNumerals (String firstSide, String secondSide, String input) throws Exception {

        String [] Romanian = {"Null","I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
                "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
                "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};

            int a = 0, b = 0, result = 0;
            for (int i = 0; i < Romanian.length; i++) {
                String Character = Romanian[i];
                if (Character.equals(firstSide)) {
                    a = i;
                }

                if (Character.equals(secondSide)) {
                    b = i;
                }
            }

                if (input.contains("+")) {
                    result = a + b;
                        if (result <= 0) {
                            throw new Exception("Ошибка! При вычислении получилось отрицательное число. " +              // Фиксируем исключение при отрицательном ответе в работе с римскими числами
                                    "В римской системе счисления нет отрицательных чисел.");
                        }
                } else if (input.contains("-")) {
                    result = a - b;
                        if (result <= 0) {
                            throw new Exception("Ошибка! При вычислении получилось отрицательное число. " +
                                    "В римской системе счисления нет отрицательных чисел.");
                    }
                } else if (input.contains("*")) {
                    result = a * b;
                        if (result <= 0) {
                            throw new Exception("Ошибка! При вычислении получилось отрицательное число. " +
                                    "В римской системе счисления нет отрицательных чисел.");
                    }
                } else if (input.contains("/")) {
                    result = a / b;
                        if (result <= 0) {
                            throw new Exception("Ошибка! При вычислении получилось отрицательное число. " +
                                    "В римской системе счисления нет отрицательных чисел.");
                    }
                }

                    input = Romanian[result];
                return input;
    }
}
