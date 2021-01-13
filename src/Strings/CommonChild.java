package Strings;

import java.util.ArrayList;
import java.util.List;

// https://en.wikipedia.org/wiki/Longest_common_subsequence_problem
public class CommonChild {
    static int commonChild(String s1, String s2) {
        int m = s1.length();
        int n = s2.length(); // the problem says m and n are the same, but the code can work even if they are different
        // we add 1 to include the zero-length prefix for each string
        int[][] arr = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
               if (s1.charAt(i) == s2.charAt(j)) {
                   arr[i][j] = arr[i - 1][j - 1] + 1;
               } else {
                   arr[i][j] = Math.max(arr[i][j-1], arr[i - 1][j]);
               }
            }
        }
        return arr[m][n];
    }
}
