/**
 * 
 */
package 高质量代码;

public class 数值的整数次方
{
	private boolean isInputInvalid;
	public double power(double base,int exponent)
	{
		isInputInvalid = false;
		if(Math.abs(base-0.0) <= 0)
		{
			if(exponent<=0)
				isInputInvalid = true;
			return 0.0;
		}
		else
		{
			if(exponent == 0)
				return 1;
			else if(exponent > 0)
				return powerWithUnsignedExponent(base, exponent);
			else
				return 1.0/powerWithUnsignedExponent(base, -exponent);
		}
	}
	
	public double powerWithUnsignedExponent(double base, int exponent)
	{
		if(exponent == 0)
			return 1;
		if(exponent == 1)
			return base;
		double result = powerWithUnsignedExponent(base, exponent/2);
		result *= result;
		if(exponent%2 == 1)
			result *= base;
		return result;
	}
}
