package DynamicProgramming;

import java.util.Scanner;

public class Abbreviation {
    static String abbreviation(String a, String b) {
        int m = b.length(), n = a.length();
        boolean[][] arr = new boolean[m + 1][n + 1]; // all initialized to false
        for (int i = 0; i <= m; i ++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) {
                    if (j == 0) arr[i][j] = true;
                    else if (a.charAt(j - 1) < 97) {
                        arr[i][j] = false;
                    } else {
                        arr[i][j] = arr[i][j - 1];
                    }
                } else if (j == 0) {
                    arr[i][j] = false;
                } else {
                    if (a.charAt(j - 1) == b.charAt(i - 1)) {
                        arr[i][j] = arr[i - 1][j - 1];
                    } else if (a.charAt(j - 1) < 97) {
                        // uppercase
                        arr[i][j] = false;
                    } else if (a.charAt(j - 1) - 32 != b.charAt(i - 1)) {
                        // lowercase
                        arr[i][j] = arr[i][j - 1];
                    } else {
                        arr[i][j] = arr[i][j - 1] || arr[i - 1][j - 1];
                    }
                }
            }
        }
        if (arr[m][n]) {
            return "YES";
        }
        return "NO";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = Integer.parseInt(scanner.nextLine());
        String[] results = new String[q];
        for (int i = 0; i < q; i++) {
            String a = scanner.nextLine();
            String b = scanner.nextLine();
            results[i] = abbreviation(a, b);
        }
        scanner.close();
        for (int i = 0; i < q; i++) {
            System.out.println(results[i]);
        }
    }
}
