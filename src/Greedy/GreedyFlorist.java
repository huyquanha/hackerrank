package Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class GreedyFlorist {
    static int getMinimumCost(int k, int[] c) {
        int minCost = 0;
        int n = c.length; // number of flowers
        if (k >= n) {
            for (int cost : c) minCost += cost;
            return minCost;
        } else {
            Arrays.sort(c);
            int i = n - 1;
            int round = 0;
            int j;
            while (i >= 0) {
                j = i - k;
                while (i >= 0 && i > j) {
                    minCost += (round + 1) * c[i];
                    i--;
                }
                round++;
            }
        }
        return minCost;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] nk = scanner.nextLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        int[] prices = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int minimumCost = getMinimumCost(k, prices);
        System.out.println(minimumCost);
    }
}
