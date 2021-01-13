package Search;

import java.util.*;

/**
 * - In-order traversal print after each swap
 * - Nodes are indexed from [1...n] with root at 1
 * - Need to perform t swap operations
 */
public class SwapNodes {
    static void inorder(ArrayList<Integer> result, int[][] indexes, int node) {
        if (node == -1) return;
        inorder(result, indexes, indexes[node - 1][0]);
        result.add(node);
        inorder(result, indexes, indexes[node - 1][1]);
    }

    static int[][] swapNodes(int[][] indexes, int[] queries) {
        int n = indexes.length;
        int[] depths = new int[n + 1]; // we don't use the first position
        depths[1] = 1; // use index 1 to represent the root, and depth of root is 1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                if (indexes[i][j] != -1) {
                    depths[indexes[i][j]] = depths[i + 1] + 1;
                }
            }
        }
        Map<Integer, List<Integer>> depthMap = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            if (!depthMap.containsKey(depths[i])) {
                depthMap.put(depths[i], new ArrayList<>());
            }
            depthMap.get(depths[i]).add(i);
        }
        int queriesCount = queries.length;
        int[][] result = new int[queriesCount][];
        for (int qIdx = 0; qIdx < queriesCount; qIdx++) {
            int k = queries[qIdx];
            int d = k;
            while (k < n) {
                if (!depthMap.containsKey(d)) break;
                List<Integer> nodeWithDepths = depthMap.get(d);
                for (int nodeId : nodeWithDepths) {
                    // grab the children line
                    int[] childrenRow = indexes[nodeId - 1];
                    // swap 2 children
                    int tmp = childrenRow[0];
                    childrenRow[0] = childrenRow[1];
                    childrenRow[1] = tmp;
                }
                d += k;
            }
            ArrayList<Integer> list = new ArrayList<>();
            inorder(list, indexes, 1);
            result[qIdx] = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                result[qIdx][i] = list.get(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] indexes = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] items = scanner.nextLine().split(" ");
            for (int j = 0; j < 2; j++) {
                int indexItem = Integer.parseInt(items[j].trim());
                indexes[i][j] = indexItem;
            }
        }
        int queriesCount = scanner.nextInt();
        int[] queries = new int[queriesCount];
        for (int i = 0; i < queriesCount; i++) {
            // each queries[i] is a number k
            queries[i] = scanner.nextInt();
        }

        int[][] result = swapNodes(indexes, queries);

        // Each query should result in one row in the result
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; i++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
