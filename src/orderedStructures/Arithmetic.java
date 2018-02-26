package orderedStructures;

public class Arithmetic extends Progression {
	private double commonDifference; 
	
	public Arithmetic(double firstValue, double commonDifference) { 
		super(firstValue); 
		this.commonDifference = commonDifference; 
	}
	
	@Override
	public double nextValue() throws IllegalStateException {
		if(!firstWasCalled)
			throw new IllegalStateException("printAllTerms: No initial value exists.");
		current = current + commonDifference; 
		return current;
	}
	
	@Override
	public String toString(){
		return "Arith(" + firstValue() + ", " + commonDifference + ")";
		}
	
	@Override
	public double getTerm(int n) throws IndexOutOfBoundsException { 
		if (n <= 0) 
			throw new IndexOutOfBoundsException("printAllTerms: Invalid argument value = " + n); 

		double value = this.firstValue(); 
		value += (n-1)*commonDifference;
//		for (int i=1; i<n; i++) 
//			value = this.nextValue(); 
		return value; 
	}

}
