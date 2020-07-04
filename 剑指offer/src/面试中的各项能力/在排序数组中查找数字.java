/**
 * 
 */
package 面试中的各项能力;

public class 在排序数组中查找数字
{	
    public int GetNumberOfK(int [] array , int k) {
        if(array == null || array.length==0)
            return 0;
         int first = getFirst(array,k);
         int last = getLast(array,k);
         if(first == -1 || last == -1) return 0;
         else
             return last-first+1;
     }
     
     public int getFirst(int[] nums,int target)
     {
         int left = 0,right = nums.length-1;
         while(left<=right)
         {
             int mid = (left+right)/2;
             if(nums[mid] > target) right=mid-1;
             else if(nums[mid] < target) left=mid+1;
             else
             {
                 if(mid == 0)
                     return mid;
                 if(mid-1 >= 0 && nums[mid-1]!=target)
                     return mid;
                 else
                     right = mid-1;
             }
         }
         return -1;
     }
     
     public int getLast(int[] nums,int target)
     {
         int left = 0,right = nums.length-1;
         while(left<=right)
         {
             int mid = (left+right)/2;
             if(nums[mid] > target) right=mid-1;
             else if(nums[mid] < target) left=mid+1;
             else
             {
                 if(mid == nums.length-1)
                     return mid;
                 if(mid+1 <= nums.length-1 && nums[mid+1]!=target)
                     return mid;
                 else
                     left = mid+1;
             }
         }
         return -1;
     }
	
	public static void main(String[] args)
	{
		int[] nums = {1,2,3,3,3,3,4,5};
		int getNumberOfK = new 在排序数组中查找数字().GetNumberOfK(nums, 4);
		System.out.println(getNumberOfK);
	}
}
