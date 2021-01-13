package Search;

import java.util.*;

public class WhatFlavor {
    static void whatFlavors(int[] cost, int money) {
        Map<Integer, LinkedList<Integer>> map = new HashMap<>();
        int n = cost.length;
        for (int i = 0; i < n; i++) {
            if (map.get(cost[i]) == null) {
                map.put(cost[i], new LinkedList<>());
            }
            map.get(cost[i]).add(i + 1);
        }
        Arrays.sort(cost);
        int i = 0, j = n - 1;
        while (cost[i] + cost[j] != money) {
            if (cost[i] + cost[j] < money) {
                i++;
            }
            if (cost[i] + cost[j] > money) {
                j--;
            }
        }
        // always be a unique solution
        int iID = map.get(cost[i]).removeFirst();
        int jID = map.get(cost[j]).removeLast();
        if (iID < jID) {
            System.out.println(iID + " " + jID);
        } else {
            System.out.println(jID + " " + iID);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int money = scanner.nextInt();
            int n = scanner.nextInt();
            int[] cost = new int[n];
            String[] costItems = scanner.nextLine().split(" ");
            for (int j = 0; j < n; j++) {
                cost[j] = Integer.parseInt(costItems[j]);
            }
            whatFlavors(cost, money);
        }
    }
}
