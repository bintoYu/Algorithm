/**
 * 
 */
package 算法和数据操作;

public class 斐波那契数列
{
    public int Fibonacci(int n) {
    	int[] dp = new int[n+1];
    	dp[0] = 0;
    	dp[1] = 1;
    	for(int i = 2; i < n+1 ; i++)
    	{
    		dp[i] = dp[i-1] + dp[i-2];
    	}
    	
    	return dp[n];
    }
	
    /**
     * 本题不适合用递归，因为效率太低
     * @param n
     * @return
     */
    public int BadFibonacci(int n) {
    	if(n <= 0)
    		return 0;
    	if(n == 1)
    		return 1;
    	
    	return BadFibonacci(n-1) + BadFibonacci(n-2);
    }
    
    public static void main(String[] args)
	{
		int badFibonacci = new 斐波那契数列().BadFibonacci(10);
		System.out.println(badFibonacci);
		
		int fibonacci = new 斐波那契数列().Fibonacci(10);
		System.out.println(fibonacci);
	}
}
