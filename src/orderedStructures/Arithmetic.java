package orderedStructures;

import interfaces.Combinable;

public class Arithmetic extends Progression implements Combinable{
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
	
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Arithmetic)) {
			return false;
		}
		else return (this.firstValue() == ((Arithmetic) o).firstValue() && this.commonDifference == ((Arithmetic) o).commonDifference);
	}

	public Progression add(Progression other) throws IllegalArgumentException{
		if(!(other instanceof Arithmetic)) {
			throw new IllegalArgumentException("Argument must be of type Arithmetic");
		}
		return new Arithmetic(this.firstValue() + ((Arithmetic) other).firstValue(), this.commonDifference + ((Arithmetic) other).commonDifference);
	}

}
