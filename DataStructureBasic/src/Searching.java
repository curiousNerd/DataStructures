public class Searching {

    /**
     * Algorithm:
     * The below implementation works for sorted arrays only
     *
     * Output: Accepted
     *
     * Time Complexity -> O(log n)
     * Space Complexity -> O(1)
     *
     * */
    public static void binarySearch(int [] nums, int target){

        int first = 0;
        int last = nums.length - 1;

        int mid = first + (last - first)/2;

        while(first <= last){
            if(nums[mid] < target){
                first = mid + 1;
            }else if(nums[mid] > target){
                last = mid - 1;
            }else{
                System.out.println("Element found at index "+mid);
                break;
            }
            mid = first + (last - first)/2;
        }

        if(first > last){
            System.out.println("Element not found");
        }

    }

    public static int binarySearch_recursion(int [] nums, int first, int last, int target){

        int mid = first + (last - first)/2;

        if(last >= first){
            if(nums[mid] == target)
                return mid;

            if(nums[mid] > target){
                return binarySearch_recursion(nums,first,last-1, target);
            }else{
                return binarySearch_recursion(nums,first + 1,last,target);
            }
        }
        return -1;

    }

    public static void main(String [] args){

        int [] arr = {10,20,30,40,50};

        Searching.binarySearch(arr,40);
        System.out.println("-----");
        int output = Searching.binarySearch_recursion(arr,0,arr.length-1,40);
        if(output != -1){
            System.out.println("Number found at index :"+output);
        }else{
            System.out.println("Number not found");
        }

    }
}
