package 笔试格式;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main
{
	public String bigNumProduct(String str)
	{
		//...
		return "";
	}
	
    public static void main(String[] args) {
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        try {
            line = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(new Main().bigNumProduct(line));
    }
}