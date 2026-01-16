import java.util.*;

public class MergeIntervals {

    public static int[][] merge(int[][] intervals) {
        if (intervals.length == 0)
            return new int[0][0];

        // Sorting without lambda (works in old Java versions)
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        List<int[]> res = new ArrayList<int[]>();
        int[] cur = intervals[0];

        for (int i = 0; i < intervals.length; i++) {
            int[] in = intervals[i];

            if (in[0] <= cur[1]) {
                cur[1] = Math.max(cur[1], in[1]); // merge
            } else {
                res.add(cur);
                cur = in;
            }
        }
        res.add(cur);

        return res.toArray(new int[res.size()][2]);
    }

    public static void main(String[] args) {
        int[][] in = { {1,3}, {2,6}, {8,10}, {15,18} };
        int[][] out = merge(in);

        for (int i = 0; i < out.length; i++) {
            System.out.println(Arrays.toString(out[i]));
        }
    }
}
