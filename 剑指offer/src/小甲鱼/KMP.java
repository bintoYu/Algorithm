package 小甲鱼;

public class KMP
{
	public static void getNext(char[] T,int[] next){
		next[0]=-1;
		int i = 0,j=-1;
		while(i < T.length-1) {
			if(j==-1 || T[i] == T[j]){
				i++;
				j++;
				next[i] = j;
			}
			else {
				//回溯
				j = next[j];
			}
		}
	}
	
	public static int KMPSearch(char[] a, char[] b){
		int[] next = new int[b.length];
		getNext(b, next);
		
		int i = 0,j=0;
		while(i<a.length && j < b.length){
			if(j==-1 || a[i] == b[j]){
				i++;
				j++;
			}else{
				//回溯
				j = next[j];
			}
		}
		
		if(j==b.length){
			return i-j;
		}
		else{
			return -1;
		}
	}
	
	public static void main(String[] args)
	{
		//子串或模式串
		char p[] = "ABCDABD".toCharArray();
		
		//主串
		char s[] = "BBC ABCDAB ABCDABCDABDE".toCharArray();//23个字符
		
		int res = KMPSearch(s, p);
		System.out.println(res);
	}
}
