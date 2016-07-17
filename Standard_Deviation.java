import java.math.BigDecimal;

public class Standard_Deviation {
	
	private boolean error;
	private BigDecimal StandardDeviation;
	private BigDecimal Variance;
	private BigDecimal Mean;
		
	/****
	 *	Calculates the standard deviation. 
	 *	Returns true if there was an error
	 *	
	 *	To calculate the Standard Deviation
	 *		1) Calculate the mean
	 *		2) Calculate the variance
	 *		3) Standard Deviation is the square root of the variance
	 *
	 *****/
	public boolean CalculateStandardDeivation(BigDecimal[] input){
		error = false;
		BigDecimal mean = new BigDecimal(0);
		BigDecimal variance = new BigDecimal(0);
		BigDecimal standardDeviation = new BigDecimal(0);
		
		if(input.length <= 0){
			this.error = true;
			return error;
		}
		
		// Calculate the mean
		try{
			mean  = calculateMean(input);
		}
		catch(Exception e){
			this.error = true;
			return error;
		}
		this.Mean = mean;
			
		// Calculate the variance
		try{
			variance = calculateVariance(input, mean);
		}
		catch(Exception e){
			this.error = true;
			return error;
		}
		this.Variance = variance;
		
		// Calculate standard deviation from the variance
		try{
			standardDeviation = calculateStandardDeviation(input, variance);
		}
		catch(Exception e){
			this.error = true;
			return error; 
			
		}
		this.StandardDeviation = standardDeviation; 
		
		return error;
	}


	/****
	 * Finds the variance for the inputed BigDecimal array 
	 * 
	 * To find the variance 
	 * 	1) Subtract the mean from each number in the input
	 *  2) Square the result
	 *  3) Find the sum
	 *  4) Divide by n-1
	 *  
	 * @param input 
	 *****/
	private BigDecimal calculateVariance(BigDecimal[] input, BigDecimal mean){
		
		//Subtract the mean, and square the result. Store back into input array 
		for(int i = 0; i < input.length; i++){
			input[i] = BigFunctions.intPower((input[i].subtract(mean)),2,10);
		}
		
		//Sum the array
		BigDecimal sum = getSum(input);
		
		//Divide by n-1
		return sum.divide(new BigDecimal(input.length - 1));
	}
	
	/****
	 * Calculates the mean of BigDecimal array
	 * 
	 * 
	 * @param input
	 * 
	 */
	private BigDecimal calculateMean(BigDecimal[] input){
		BigDecimal sum = getSum(input);
		BigDecimal mean = new BigDecimal(0);
		
		mean = sum.divide(new BigDecimal(input.length));
		
		return mean;
		
	}
	
	/****
	 *  Finds the Standard deviation given the variance
	 * 
	 *  To calculate the standard deviation for the variance
	 *  	1) Take the square root of the variance
	 *
	 * @param variance
	 *****/
	private BigDecimal calculateStandardDeviation(BigDecimal[] input, BigDecimal variance){
		return BigFunctions.intRoot(variance, 2, 10);
	}
	
	/****
	 * Returns the sum of an inputed BigDecimal array
	 * 
	 * @param input
	 * @return sum as BigDecimal
	 ****/
	private BigDecimal getSum(BigDecimal[] input) {

		BigDecimal sum = new BigDecimal(0);
		
		for(int i = 0; i < input.length; i++){
			sum = sum.add(input[i]);
		}
		return sum;
	}
	
	// Getters
	public BigDecimal getStandardDeviation(){
		return this.StandardDeviation;
	}
	public BigDecimal getVariance(){
		return this.Variance;
	}
	public BigDecimal getMean(){
		return this.Mean;
	}
	public boolean getError(){
		return this.error;
	}

}