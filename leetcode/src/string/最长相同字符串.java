/**
 * 
 */
package string;

public class 最长相同字符串
{
	public int longestCommonSubstring(String A, String B) {
        // write your code here
        int max=0;//记录最长子串的大小
        char[] AStr=A.toCharArray();
        char[] BStr=B.toCharArray();
        int x=0,y=0;//记录最长子串结束的位置
        int dp[][]=new int[A.length()][B.length()];//初始化矩阵
        
        for(int i=0;i<A.length();i++){
            for(int j=0;j<B.length();j++){
                if(AStr[i]==BStr[j]){
                    if(i==0||j==0){
                        dp[i][j]=1;
                    }else{
                        dp[i][j]=dp[i-1][j-1]+1;
                    }
                    
                    if(dp[i][j]>max){
                        max=dp[i][j];
                        x=i;
                        y=j;
                    }
                }
                else dp[i][j]=0;
            }
        }
        return max;
    }

}
