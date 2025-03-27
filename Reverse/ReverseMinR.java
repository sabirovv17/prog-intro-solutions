import java.util.Scanner;
import java.util.Arrays;
public class ReverseMinR {
    public static void main(String[] args) {
        int[][] arr = new int[150][];
        int[][] minArr = new int[150][];
        Scanner scan1 = new Scanner(System.in);
        int counter1 = 0;
        while (scan1.hasNextLine()) {
            Scanner scan2 = new Scanner(scan1.nextLine());
            int[] num = new int[150];
            int[] minNum = new int[150];
            int counter2 = 0;
            while (scan2.hasNextInt()) {
                if (num.length == counter2) {
                    int[] num2 = Arrays.copyOf(num, num.length * 3);
                    int[] minNum2 = Arrays.copyOf(minNum, minNum.length * 3);
                    num = num2;
                    minNum = minNum2;
                }
                int currentNum = scan2.nextInt();
                num[counter2] = currentNum;
                int min = num[0];
                for (int i = 1; i <= counter2; i++) {
                    if (num[i] < min) {
                        min = num[i];
                    }
                }
                minNum[counter2] = min;
                counter2++;
            }
            if (arr.length == counter1) {
                int[][] newarr = Arrays.copyOf(arr, arr.length * 3);
                int[][] minArr2 = Arrays.copyOf(minArr, minArr.length * 3);
                arr = newarr;
                minArr = minArr2;
            }
            arr[counter1] = Arrays.copyOf(num, counter2);
            minArr[counter1] = Arrays.copyOf(minNum, counter2);
            counter1++;
        }
        for(int i = 0; i < counter1; i++) {
            for(int j = 0; j < minArr[i].length; j++) {
                System.out.print(minArr[i][j] + " ");
            }
            System.out.print('\n');
        }
    }
}
