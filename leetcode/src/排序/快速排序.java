/**
 * 
 */
package 排序;

/**
 * @author Administrator
 *
 * @date 2018年11月5日  
 * @version 1.0  
 */
public class 快速排序
{
	    public void sort(int[] nums){
        quickSort(nums,0,nums.length-1);
    }

    private void quickSort(int[] nums,int start,int end) {
        if (start < end) {
            int index = partition(nums,start,end);
            quickSort(nums,start,index-1);
            quickSort(nums,index+1,end);
        }
    }

    private int partition(int[] nums, int start, int end) {
        int key = nums[start];
        while (end > start) {
            //从后往前扫，找到比基准小的
            while (end > start && nums[end] > key) {
                end--;
            }
            nums[start] = nums[end];
            //从前往后扫，找到比基准大的
            while (end > start && nums[start] <= key) {
                start++;
            }
            nums[end] = nums[start];
        }
        nums[start] = key;

        return start;
    }

    public static void main(String[] args) {
        int[] nums = {2,4,6,8,4,1,3,5,7,9};
        new 快速排序().sort(nums);
        System.out.println(Arrays.asList(nums));
    }
}
