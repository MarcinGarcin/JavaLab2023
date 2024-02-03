package tmp;

import java.util.Arrays;



    public class Main {
        public static int rearrangeToNextSmallest(int number) {
            char[] digits = Integer.toString(number).toCharArray();

            int i = digits.length - 2;
            while (i >= 0 && digits[i] >= digits[i + 1]) {
                i--;
            }

            if (i >= 0) {
                int j = digits.length - 1;
                while (digits[j] <= digits[i]) {
                    j--;
                }

                // Zamiana miejscami znalezionego punktu i cyfry większej
                swap(digits, i, j);
            }

            // Sortowanie cyfr poza punktem
            Arrays.sort(digits, i + 1, digits.length);

            // Konwersja z powrotem na liczbę
            return Integer.parseInt(new String(digits));
        }

        private static void swap(char[] arr, int i, int j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        public static void main(String[] args) {
            int originalNumber = 199999999;
            int result = rearrangeToNextSmallest(originalNumber);

            System.out.println("Original Number: " + originalNumber);
            System.out.println("Next Smallest Number: " + result);
        }
    }




