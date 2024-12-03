package com.walking.intensive.chapter2.task8;

/**
 * Добираясь в школу на трамвае Вова проверяет, является ли купленный билет счастливым.
 * Если является, то нужно загадать желание и съесть билетик.
 *
 * <p>Билет содержит 6 цифр, комбинации подбираются случайным образом от 000000 до 999999.
 *
 * <p>Билет считается счастливым, если сумма первых трех цифр равна сумме последних трех цифр.
 *
 * <p>Пример: 123411 – счастливый (1 + 2 + 3 == 4 + 1 + 1).
 *
 * <p>Реализуйте метод getHappyTicketChance(), который будет возвращать вероятность
 * выпадения счастливого билета.
 *
 * <p>P.S. Вероятность – это отношение благоприятных исходов к числу всех исходов.
 * Вероятность не может принимать значение больше 1.
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task8 {
    public static void main(String[] args) {
        System.out.println("сумма разрядов числа 999 равна " + getDigitsSum(999));
        System.out.printf("Вероятность выпадения счастливого билета равна %.6f \n", getHappyTicketChance());
    }

    static double getHappyTicketChance() {
        int happyTicketsNumber = 0;

        for (int i = 0; i <= 999_999; i++) {
            if (getDigitsSum(i / 1000) == getDigitsSum(i % 1000)) {
                happyTicketsNumber++;
            }
        }

        return happyTicketsNumber / 1000000.;
    }

    static int getDigitsSum(int num) {
        if (num < 1) {
            return 0;
        }

        return num % 10 + getDigitsSum(num / 10);
    }
}
