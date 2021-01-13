package Search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Triplet {
    static int rank(int[] arr, int x) {
        int lo = 0, hi = arr.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (x > arr[mid]) {
                lo = mid + 1;
            } else if (x < arr[mid]) {
                hi = mid - 1;
            } else {
                return mid + 1;
            }
        }
        return lo;
    }

    static int[] dedup(int[] arr) {
        List<Integer> tmp = new ArrayList<>();
        tmp.add(arr[0]);
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            if (arr[i] != arr[i - 1]) tmp.add(arr[i]);
        }
        return tmp.stream().mapToInt(i -> i).toArray();
    }

    static long triplets(int[] a, int[] b, int[] c) {
        // sort a and c
        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);
        // we need to remove duplicates from all arrays
        int[] dedupA = dedup(a);
        int[] dedupB = dedup(b);
        int[] dedupC = dedup(c);
        long count = 0;
        int n = dedupB.length;
        for (int i = 0; i < n; i++) {
            int ra = rank(dedupA, dedupB[i]);
            int rc = rank(dedupC, dedupB[i]);
            count += (long) ra * rc;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lena = scanner.nextInt();
        int lenb = scanner.nextInt();
        int lenc = scanner.nextInt();
        // because nextInt() leaves behind the end-of-line, we use this to skip the rest of this line
        scanner.nextLine();
        int[] a = new int[lena];
        int[] b = new int[lenb];
        int[] c = new int[lenc];
        String[] aItems = scanner.nextLine().split(" ");
        for (int i = 0; i < lena; i++) {
            a[i] = Integer.parseInt(aItems[i]);
        }
        String[] bItems = scanner.nextLine().split(" ");
        for (int i = 0; i < lenb; i++) {
            b[i] = Integer.parseInt(bItems[i]);
        }
        String[] cItems = scanner.nextLine().split(" ");
        for (int i = 0; i < lenc; i++) {
            c[i] = Integer.parseInt(cItems[i]);
        }
        System.out.println(triplets(a, b, c));
    }
}
