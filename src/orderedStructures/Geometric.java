package orderedStructures;

public class Geometric extends Progression {

	private double commonFactor; 
	
	public Geometric(double firstValue, double commonFactor) { 
		super(firstValue); 
		this.commonFactor = commonFactor; 
	}
	
	@Override
	public double nextValue() throws IllegalStateException {
		if(!firstWasCalled)
			throw new IllegalStateException("printAllTerms: No initial value exists.");
		current = current * commonFactor; 
		return current;
	}

	@Override
	public String toString(){
		return "Geom(" + firstValue() + ", " + commonFactor + ")";
		}
	
	@Override
	public double getTerm(int n) throws IndexOutOfBoundsException { 
		if (n <= 0) 
			throw new IndexOutOfBoundsException("printAllTerms: Invalid argument value = " + n); 

		double value = this.firstValue(); 
		value = value * Math.pow(commonFactor, n-1);
//		for (int i=1; i<n; i++) 
//			value = this.nextValue(); 
		return value; 
	}
	
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Arithmetic)) {
			return false;
		}
		else return (this.firstValue() == ((Geometric) o).firstValue() && this.commonFactor == ((Geometric) o).commonFactor);
	}
}
