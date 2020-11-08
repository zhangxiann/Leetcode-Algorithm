public class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        int l=0, h=nums.length-1;

        while (l<=h){
            int mid=l+(h-l)/2;
            if (nums[mid]>=target)
                h=mid-1;
            else
                l=mid+1;
        }
        if (l==nums.length || nums[l]!=target)
            return new int[]{-1,-1};

        int left = l;

        l=0; h=nums.length-1;
        while (l<=h){
            int mid=l+(h-l)/2;
            if (nums[mid]<=target)
                l=mid+1;
            else
                h=mid-1;
        }
        return new int[]{left,h};
    }


/*    public int[] searchRange(int[] nums, int target) {
        int l=0, h=nums.length;

        while (l<h){
            int mid=l+(h-l)/2;
            if (nums[mid]>=target)
                h=mid;
            else
                l=mid+1;
        }
        if (l==nums.length || nums[l]!=target)
            return new int[]{-1,-1};

        int left = l;

        l=0; h=nums.length;
        while (l<h){
            int mid=l+(h-l)/2;
            if (nums[mid]<=target)
                l=mid+1;

            else
                h=mid;
        }
        return new int[]{left,h-1};
    }*/

    public static void main(String[] args) {
        int[] res =new Solution34().searchRange(new int[]{5,7,7,8,8,10}, 8);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }
}
