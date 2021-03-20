package a;

public class _16 {

	/*
	 * 数值的整数次方
	 */
	public double Power(double base,int n) {
		double res=1,curr=base;
		int exponent;
		
		if(n>0) {
			exponent=n;
		}else if(n<0){
			if(base==0) {
				throw new RuntimeException("分母不能为0");
			}
			exponent=-n;
		}else {   //n=0
			return 1;
		}
		
		double result=PowerWithUnsignedExponent(base, exponent);
		
		if(exponent<0)
			result=1.0/result;
		
		return result;
	}
	
	double PowerWithUnsignedExponent(double base,int exponent) {
		double result=1.0;
		for(int i=1;i<=exponent;i++) {
			result*=base;
		}
		return result;
	}
}
