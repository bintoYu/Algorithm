/**
 * 
 */
package 面试需要的基础知识;

public class 数组中重复的数字
{
	/**
	 * 方法1：挪动数组，但保证不使用额外空间
	 * @param numbers
	 * @param length
	 * @param duplication
	 * @return
	 */
    public boolean duplicate1(int numbers[],int length,int [] duplication) {
    	if(numbers == null || numbers.length == 0) return false;
    	
        for(int i = 0; i < length; i++)
        {
        	while(numbers[i] != i)
        	{
	        	//如果不相同，交换
	        	if(numbers[numbers[i]] == numbers[i])
	        	{
	        		duplication[0] = numbers[i];
	        		return true;
	        	}
	    		int tmp = numbers[numbers[i]];
	    		numbers[numbers[i]] = numbers[i];
	    		numbers[i] = tmp;
        	}
        }
        return false;
    }
    
    /**
     * 不允许更改原数组，但可以额外空间,使用map
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public boolean duplicate(int numbers[],int length,int [] duplication) {
    	return false;
    }
    
    public static void main(String[] args)
	{
		int[] numbers = {2,1,3,0,4};
		int[] duplication = new int[5];
		System.out.println(new 数组中重复的数字().duplicate(numbers, 5, duplication));
	}
}
