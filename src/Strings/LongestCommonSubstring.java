package Strings;

import java.util.Scanner;

public class LongestCommonSubstring {
    static int longestCommonSubstr(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] arr = new int[m + 1][n + 1];
        int longest = 0;
        int last1 = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    arr[i][j] = arr[i-1][j-1] + 1;
                    if (arr[i][j] > longest) {
                        longest = arr[i][j];
                        last1 = i - 1;
                    }
                }
            }
        }
        System.out.println("Longest substring: " + s1.substring(last1 - longest + 1, last1 + 1));
        return longest;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        System.out.println(longestCommonSubstr(s1, s2));
    }
}
