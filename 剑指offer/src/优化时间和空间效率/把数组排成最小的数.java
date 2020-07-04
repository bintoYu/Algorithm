/**
 * 
 */
package 优化时间和空间效率;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//通过测试
public class 把数组排成最小的数
{
    public String PrintMinNumber(int [] numbers) {
    	if(numbers == null || numbers.length == 0) return "";
		String[] numstr = new String[numbers.length];
		for(int i = 0; i < numbers.length; i++)
			numstr[i] = numbers[i] + "";
		
    	Arrays.sort(numstr,(A,B) -> {
    				String AB = A + B;
    				String BA = B + A;
    				return AB.compareTo(BA);
    		});
    	
    	StringBuilder sb = new StringBuilder();
    	for (String string : numstr)
		{
			sb.append(string);
		}
    	
    	return sb.toString();
    }
    
	
    public static void main(String[] args)
	{
    	int[] numbers = {3,32,321};
		String printMinNumber = new 把数组排成最小的数().PrintMinNumber(numbers);
		System.out.println(printMinNumber);
	}

}
