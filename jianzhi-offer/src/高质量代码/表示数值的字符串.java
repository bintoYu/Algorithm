package 高质量代码;

//所有的判断前面都要加index < number.length()
//测试通过
public class 表示数值的字符串
{
	private int index = 0;
	public boolean isNumeric(String number)
	{
		if(number == null || number.length() == 0)
			return false;
		
		//查看A
		boolean numeric = scanInteger(number);
		
		//查看[.[B]]
		if(index < number.length() && number.charAt(index) == '.')
		{
			index++;
			//如果面试官认为.123和123.不算合法的话，那么||要改成&&
			//一定要把numeric放在后面！！
			numeric = scanUnsignedInteger(number) || numeric;
		}
		//查看[e|EC]
		if(index < number.length() && (number.charAt(index) == 'e' || number.charAt(index) == 'E'))
		{
			index++;
			numeric =  scanInteger(number) && numeric ;
		}
		
		return numeric && (index==number.length()); 
	}

	private boolean scanInteger(String number)
	{
		if(index < number.length() && (number.charAt(index) == '+' || number.charAt(index) == '-'))
			index++;
		return scanUnsignedInteger(number);
	}

	private boolean scanUnsignedInteger(String number)
	{
		int before = index;
		while(index < number.length() && number.charAt(index)>='0' && number.charAt(index)<='9')
			index++;
		return index>before;
	}
	
	public static void main(String[] args)
	{
		String number = "12e+5.4";
		boolean numeric = new 表示数值的字符串().isNumeric(number);
		System.out.println(numeric);
	}
	
	
	
	
}
