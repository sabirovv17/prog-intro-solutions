import java.util.Scanner;
import java.util.Arrays;

public class Reverse {
    public static void main(String[] args) {
        int[][] arr = new int[150][];
        int[][] arrrev = new int[150][];
        int counter1 = 0;
        Scanner scan1 = new Scanner(System.in);
        while (scan1.hasNextLine()) {
            Scanner scan2 = new Scanner(scan1.nextLine());
            int[] num = new int[150];
            int counter2 = 0;
            while (scan2.hasNextInt()) {
                if (num.length == counter2) {
                    int[] num2 = Arrays.copyOf(num, num.length * 3);
                    num = num2;
                }
                int currentNum = scan2.nextInt();
                num[counter2] = currentNum;
                counter2++;
            }
            if (arr.length == counter1) {
                int[][] newarr = Arrays.copyOf(arr, arr.length * 3);
                int[][] revArr2 = Arrays.copyOf(arrrev, arrrev.length * 3);
                arr = newarr;
                arrrev = revArr2;
            }
            int[] revNum = new int[counter2];
            for (int i = 0; i < counter2; i++) {
                revNum[counter2 - i - 1] = num[i];
            }
            arr[counter1] = Arrays.copyOf(num, counter2);
            arrrev[counter1] = Arrays.copyOf(revNum, counter2);
            counter1++;
        }
        for (int i = counter1 - 1; i >= 0; i--) {
            for (int j = 0; j < arrrev[i].length; j++) {
                System.out.print(arrrev[i][j] + " ");
            }
            System.out.print('\n');
        }
    }
}
