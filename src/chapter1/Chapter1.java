package chapter1;

public class Chapter1 {
	
	public static int divide(int divisor,int dividend){
		
		if(divisor==0){
			throw new IllegalArgumentException("Division by 0 is not valid");
		}
		
		int quotient = 0;
		
		if(dividend==divisor){
			quotient = 1;
		}else if(dividend > divisor){
			int multiple = divisor;
			for(int i=1;i<dividend;i++){
				if(multiple==dividend){
					
					quotient=i;
					break;
				}else if(multiple>dividend){
					quotient = i-1;
					break;
				}else{
					multiple = multiple +divisor;
				}
			}
		}
		
		
		return quotient;
	}
	
	
	public static int divideFast(int num,int den){
	 int	quotient = 0;
			int	quot_accumulator = 1;
			int	den_accumulator = den;

				while (num >= den){
				//	System.out.println("num:"+num);
				//	System.out.println("quotient:"+quotient);
				//	System.out.println("quot_acc:"+quot_accumulator);
					if( num < den_accumulator){
						den_accumulator = den;
						quot_accumulator = 1;
					}
						

					num = num - den_accumulator;
					quotient = quotient + quot_accumulator;
					quot_accumulator = quot_accumulator + quot_accumulator;
					den_accumulator = den_accumulator + den_accumulator;
				}
					
				
				return quotient;
	}
	
	public static void main(String[] args) {
		System.out.println(System.currentTimeMillis());
		
		System.out.println(divide(2, 1000000));
		System.out.println(System.currentTimeMillis());
		System.out.println(divideFast(1000000, 2));
		System.out.println(System.currentTimeMillis());
	}

}
