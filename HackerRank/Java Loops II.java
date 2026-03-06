import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] argh) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();

        for (int i = 0; i < q; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();

            int currentValue = a;
            for (int j = 0; j < n; j++) {
                currentValue += (int) (Math.pow(2, j) * b);
                System.out.print(currentValue + " ");
            }
            System.out.println();
        }
        in.close();
    }
}
