package array;

public class Arithmetic_Slices_413
{
    public int numberOfArithmeticSlices(int[] A) {
        if(A.length < 3) return 0;
        int[] dp = new int[A.length];
        dp[0]=0;
        dp[1]=0;
        int res = 0;
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i-1] == A[i-1] - A[i-2])
                dp[i] = dp[i-1] + 1;
            res += dp[i];
        }
        return res;
    }
}
