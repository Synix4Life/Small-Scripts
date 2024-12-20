import Exception.ParameterException;

/**
 * Class that calculates a PIN out of a String
 */
class StrToPIN{
    /**
     * Calculate the Cross Sum of an Integer
     * @param value The Integer
     * @return The Cross Sum
     */
    private static long crossSum(long value){
        int result = 0;
        while(value > 0){
            result += value % 10;
            value /= 10;
        }
        return result;
    }

    /**
     * Calculate the PIN
     * @param Phrase The String
     * @param MAXLength MaxLength of the PIN
     * @param MINLength MINLength of the PIN
     * @param Multiplication Shall the programm to Multiplication? Default is Addition
     * @return The PIN
     * @throws IllegalArgumentException If the MAXLength is less than 1
     * @throws ParameterException If the MAXLength<= MINLength
     * @throws ArithmeticException If a calculation error occurs
     */
    public static long calculatePIN(String phrase, final int maxLength, final int minLength, final boolean multiplication) throws IllegalArgumentException, ParameterException, ArithmeticException{
        if(maxLength<=0){
            throw new IllegalArgumentException("MAXLength isn't allowed to be less than 1!");
        }
        if(maxLength < minLength){
            throw new ParameterException("MINLength <= MAXLength!");
        }
        long result = multiplication ? 1 : 0;
        for(char c: phrase.toCharArray()){
            if(multiplication){
                result *= (int) c;
            }
            else{
                result += (int) c;
            }
        }
        
        int i;
        for(i=0; i<501; i++){
            if(result > maxLength){
                result = crossSum(result);
            }
            else if(result < minLength){
                result += crossSum(result);
            }
            else{ 
                break; 
            }
        }

        if(i==500){
            throw new ArithmeticException("Calculation Error");
        }
        
        return result;
    }
}
