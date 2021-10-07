import java.util.Arrays;

public class BinaryNumber {
	
	private int data[];
	private boolean overFlow = false;

	public BinaryNumber(int length) {
	    data = new int[length];
	}
	    
	public BinaryNumber(String str) {
	    data = new int[str.length()];
	    for(int i=0; i<str.length(); i++) {
	    	data[i] = Character.getNumericValue(str.charAt(i));
	    }
	}
	public int getLength() {
        return data.length;
    }
    public int getDigit(int index) {
        return data[index];
    }
    public int toDecimal() {
        int result = 0;
	    for(int i=0; i<data.length; i++) {
	    	result = (int) (result + (data[i]*(Math.pow(2, i))));
	    }	
	    return(result);
    }    
    public void shiftR(int amount) {
        int myArray[] = Arrays.copyOf(data, data.length + amount);
        for(int i=myArray.length-1; i>=amount; i--) {
            myArray[i] = data[i-amount];
        }
        for(int i=0; i<amount; i++) {
            myArray[i] = 0;
        }
        data = myArray;
    }
    public void add(BinaryNumber aBinaryNumber) {
        if (getLength() != aBinaryNumber.getLength()) {
            System.out.println("Lengths Not Equal!");
        } else {
            int carried = 0;
            for (int i = 0; i < data.length; i++) {
                int myInnerInt = carried + getDigit(i) + aBinaryNumber.getDigit(i);
                if (myInnerInt >= 10) {
                    myInnerInt = myInnerInt - 10;
                    carried = 1;
                } else {
                    carried = 0;
                }
                data[i] = myInnerInt;
            }
            if (carried != 0) {
                overFlow = true;
            } else {
            	overFlow = false;
            } 
          }  
        }
    
    @Override
    public String toString() {
    	String myString = "";
    	if (overFlow = true) {
    		myString = "overFlow";
    	} else {
    		
    		for(int i=0; i<data.length; i++) {
    		myString = myString + Integer.toString(data[i]);
    		
    		}
    	}
    	return myString;
    }
    
    public void clearOverflow() {
        overFlow = false;
    }


	  public static void main(String[] args) {

		  
	  }
}	  