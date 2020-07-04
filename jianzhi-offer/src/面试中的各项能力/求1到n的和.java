/**
 * 
 */
package 面试中的各项能力;

public class 求1到n的和
{
    public int Sum_Solution(int n) {
        if(n==0) return 0;
        return n+Sum_Solution(n-1);
    }
    
    public static void main(String[] args)
	{
		int sum_Solution = new 求1到n的和().Sum_Solution(100);
		System.out.println(sum_Solution);
	}
}
