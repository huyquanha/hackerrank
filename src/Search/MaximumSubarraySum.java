package Search;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * - Compute the modulo m of every prefix of the array
 * - We use the following formula as the basis to compute the modulo sum of each sub-array:
 *      sum(subArr(j,i)) % m = (prefix[i] - prefix[j-1] + m) % m (j, i inclusive, j <= i)
 * - However, we can see that the formula is a bit redundant. If prefix[j - 1] <= prefix[i]
 * then (prefix[i] - prefix[j-1] + m) % m < prefix[i] => there's no need to compute this because we are looking
 * for the max modulo m => we would only want to compute this where prefix[j-1] > prefix[i]
 * - Furthermore, among all prefix[j-1] that is larger than prefix[i], we only want the first larger element, the reason
 * being that the larger the distance between the 2, the more negative prefix[i] - prefix[j-1] will be => the smaller
 * the modulo m => we don't care about them. That's why we only retrieve the next higher element in prefixTree.
 * - When we are about to insert prefix[i] to prefixTree, prefix[0...i-1] were already inserted and sorted, so
 * all we need to do is just retrieve the next higher element if any from prefixTree and apply the formula
 */
public class MaximumSubarraySum {
    static long maximumSum(long[] a, long m) {
        long maxSum = 0;
        int n = a.length;
        long[] prefix = new long[n];
        long cur = 0;
        TreeSet<Long> prefixTree = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            prefix[i] = (cur + a[i] % m) % m;
            maxSum = Math.max(maxSum, prefix[i]);
            // we only need the first larger element, because the larger
            // the element, the more negative prefix[i] - largerPrefix will be =>
            // the smaller prefix[i] - largerPrefix + m will be
            Long nextLarger = prefixTree.higher(prefix[i]);
            if (nextLarger != null) {
                maxSum = Math.max(maxSum, (prefix[i] - nextLarger + m) % m);
            }
            prefixTree.add(prefix[i]);
            cur = prefix[i];
        }
        return maxSum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < q; i++) {
            String[] nm = scanner.nextLine().split(" ");
            int n = Integer.parseInt(nm[0]);
            long m = Long.parseLong(nm[1]);
            long[] a = new long[n];
            String[] items = scanner.nextLine().split(" ");
            for (int j = 0; j < n; j++) {
                a[i] = Long.parseLong(items[j]);
            }
            long maxSum = maximumSum(a, m);
            System.out.println(maxSum);
        }
    }
}
