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
		
		int start =900;
		int end = 1000;
	
	 int max = 	maxCycle(start, end);
	 
	 System.out.println(start + " " + end + " " +max);
	}
	
	
	public static int maxCycle(int start, int end){
		
		int maxCycle = 0;
		
		int currentValue = start;
		
		while(currentValue<=end){
			int currentCycle = getCycle(currentValue);
			if(currentCycle>maxCycle){
				maxCycle = currentCycle;
			//	System.out.println("maxValue:"+currentValue);
			}
			currentValue++;
		}
		
		// 18 9 28 14 7 22 11 34 17 52 26 13 40 20 10 5 16 8 4 2 1
		
		return maxCycle;
		
		
	}
	
	public static int getCycle(int num){
		
		int cycle = 1;
		
		while(num!=1){
			if(num%2==0){
				num = num/2;
				cycle++;
			}else{
				num = 3*num+1;
				cycle++;
			}
		}
		return cycle;
	}

}
