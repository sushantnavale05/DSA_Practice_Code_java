import java.util.*;

public class KthLargest
{
    public static int findKthLargest(int[] nums, int k)
    {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        for(int x : nums)
        {
            pq.add(x);
            if(pq.size() > k)
            {
                pq.poll();
            }
        }
        return pq.peek();
    } 
    public static void main(String[] args)
    {
        int[] nums = {3,4,5,1,2,6,7};
        System.out.println(findKthLargest(nums, 6));
    }

}