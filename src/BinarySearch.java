public class BinarySearch {
/*    public int binarySearch(int[] nums, int key){
        int l=0, h=nums.length-1;
        while (l<=h){
            int mid = l+(h-l)/2;
            if (nums[mid]==key)
                return mid;
            else if (nums[mid]>key)
                h=mid-1;
            else
                l=mid+1;
        }
        return -1;
    }*/

    public int binarySearch(int[] nums, int key){
        int l=0, h=nums.length;
        while (l<h){
            int mid = l + (h-l)/2;
            if (nums[mid]>=key)
                h=mid;
            else
                l=mid+1;
        }
        return l;
    }
}
