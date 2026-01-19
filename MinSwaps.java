import java.util.*;

public class MinSwaps {

    public static int minSwaps(int[] arr) {
        int n = arr.length;
        int[][] pair = new int[n][2];

        // Store value and original index
        for (int i = 0; i < n; i++) {
            pair[i][0] = arr[i];
            pair[i][1] = i;
        }

        // Sort pair array by values (without lambda)
        Arrays.sort(pair, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        boolean[] vis = new boolean[n];
        int swaps = 0;

        // Count cycles
        for (int i = 0; i < n; i++) {

            // Skip if already visited or already in correct place
            if (vis[i] || pair[i][1] == i)
                continue;

            int cycle = 0;
            int j = i;

            // Traverse the cycle
            while (!vis[j]) {
                vis[j] = true;
                j = pair[j][1];
                cycle++;
            }

            // Add swaps needed for this cycle
            if (cycle > 1)
                swaps += cycle - 1;
        }

        return swaps;
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 1};
        System.out.println(minSwaps(arr));
    }
}
