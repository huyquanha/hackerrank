package Strings;

/**
 * given a String s and its length n, find the number of substrings satisfying either:
 * - all characters are the same (aaa)
 * - all but the middle characters are the same (aba)
 */
public class SpecialString {
    static long substrCount(int n, String s) {
        int res = 0, i = 0, j = 0, count = 0;
        int[] sameCharCount = new int[n];
        while (i < n) {
            j = i + 1;
            count = 1;
            while (j < n && s.charAt(j) == s.charAt(i)) {
                j++;
                count++;
            }
            res += ((count + 1) * count) >> 1; // similar to / 2
            sameCharCount[i] = count;
            i = j;
        }
        for (int k = 1; k < n - 1; k++) {
            if (s.charAt(k) == s.charAt(k - 1)) {
                sameCharCount[k] = sameCharCount[k - 1];
            }
            if (s.charAt(k - 1) == s.charAt(k + 1) && s.charAt(k) != s.charAt(k - 1)) {
                res += Math.min(sameCharCount[k - 1], sameCharCount[k + 1]);
            }
        }
        return res;
    }
}
