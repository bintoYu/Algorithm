/**
 * 
 */
package 面试中的各项能力;

import java.util.ArrayList;

public class 和为s的两个数字
{
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        if(array == null || array.length == 0) return list;
        int left = 0,right = array.length-1;
        while(left < right)
        {
        	int num = array[left] + array[right];
        	if(num < sum) left++;
        	else if(num > sum) right--;
        	else 
        	{
        		list.add(array[left]);
        		list.add(array[right]);
        		break;
       		}
        }
        return list;
    }
}
