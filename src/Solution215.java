import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution215 {

/*    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int n: nums){
            queue.add(n);
            if (queue.size()>k)
                queue.poll();
        }
        return queue.peek();
    }*/


    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int i = partition(nums, l, h);
            if (i == k)
                break;
            else if (i < k)
                l = i + 1;
            else
                h = i - 1;
        }
        return nums[k];
    }

    private int partition(int[] nums, int l, int h) {
        int left = l, right = h;
        int tmp = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= tmp)
                right--;
            if (left < right) {
                nums[left] = nums[right];
                left++;
            }

            while (left < right && nums[left] <= tmp) left++;
            if (left < right) {
                nums[right] = nums[left];
                right--;
            }
        }
        nums[left] = tmp;
        return left;
    }

    public static void main(String[] args) {
        int[] nums={7,6,5,4,3,2,1};
        int k=2;
        Solution215 solution215 = new Solution215();
        int res = solution215.findKthLargest(nums,k);
        System.out.println(res);
    }



/*    public int findKthLargest(int[] nums, int k) {
        //Arrays.sort(nums);
        quickQort(nums,0,nums.length-1);
        return nums[nums.length-k];
    }

    private void quickQort(int[] nums, int l, int r){
        int left =l, right=r;
        if (left>=right)
            return;
        int tmp=nums[left];
        while (left<right){
            while (left<right && nums[right]>=tmp) right--;
            if (left<right){
                nums[left]=nums[right];
                left++;
            }
            while (left<right && nums[left]<=tmp) left++;
            if (left<right) {
                nums[right]=nums[left];
                right--;
            }
        }
        nums[left]=tmp;
        quickQort(nums,l,left-1);
        quickQort(nums,left+1, r);
    }*/


}
