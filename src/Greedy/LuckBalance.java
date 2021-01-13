package Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LuckBalance {
    static int luckBalance(int k, int[][] contests) {
        int luck = 0;
        int n = contests.length;
        List<Integer> importantLucks = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (contests[i][1] == 0) {
                luck += contests[i][0];
            } else {
                importantLucks.add(contests[i][0]);
            }
        }
        if (k >= importantLucks.size()) {
            for (int importantLuck : importantLucks) luck += importantLuck;
        } else {
            Collections.sort(importantLucks, Collections.reverseOrder());
            for (int i = 0; i < importantLucks.size(); i++) {
                if (i < k) {
                    luck += importantLucks.get(i);
                } else {
                    luck -= importantLucks.get(i);
                }
            }
        }
        return luck;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] nk = scanner.nextLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        int[][] contests = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] contest = scanner.nextLine().split(" ");
            contests[i][0] = Integer.parseInt(contest[0]);
            contests[i][1] = Integer.parseInt(contest[1]);
        }
        int result = luckBalance(k, contests);
        System.out.println(result);
    }
}
