import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int i = new Random().nextInt(2001);
        System.out.println("Число от 0 до 2000: " + i);
        String binary = Integer.toBinaryString(i);
        System.out.println("Перевод в двоичный вид: " + binary);
        int n = 0;
        for (int j = binary.length() - 1; j >= 0; j--) {
            if (binary.charAt(j) == '1') {
                n = binary.length() - j;
                break;
            }
        }
        System.out.println("Номер старшего значащего бита: " + n);

        int count = 0;
        for (int j = i; j <= Short.MAX_VALUE; j++) {
            if (j % n == 0) {
                count++;
            }
        }

        int[] m1 = new int[count];
        int j = 0;
        for (int k = i; k <= Short.MAX_VALUE; k++) {
            if (k % n == 0) {
                m1[j] = k;
                j++;
            }
        }

        System.out.println("Найденные числа, кратные " + n + ": ");
        for (int number : m1) {
            System.out.print(number + " ");
        }

        int count1 = 0;
        for (int m = Short.MIN_VALUE; m <= i; m++) {
            if (m % n != 0) {
                count1++;
            }
        }

        int[] m2 = new int[count1];
        int l = 0;
        for (int m = Short.MIN_VALUE; m <= i; m++) {
            if (m % n != 0) {
                m2[l] = m;
                l++;
            }
        }

        System.out.println("\nНайденные числа, некратные " + n + ": ");
        for (int number : m2) {
            System.out.print(number + " ");
        }
    }
}




//1. Выбросить случайное целое число в диапазоне от 0 до 2000 и сохранить в i
//2. Посчитать и сохранить в n номер старшего значащего бита выпавшего числа
//3. Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE сохранить в массив m1
//4. Найти все некратные n числа в диапазоне от Short.MIN_VALUE до i и сохранить в массив m2
//
//        Пункты реализовать в методе main
//        *Пункты реализовать в разных методах
//
//        int i = new Random().nextInt(k); //это кидалка случайных чисел!)