/**
 * Class that calculates a PIN out of a String
 */
class StrToPIN{
    /**
     * Calculate the Cross Sum of an Integer
     * @param value The Integer
     * @return The Cross Sum
     */
    private static long CrossSum(long value){
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
     * @param Multiplication Shall the programm to Multiplication? Default is Addition
     * @return The PIN
     * @throws IllegalArgumentException If the MAXLength is less than 1
     */
    public static long calculatePIN(String Phrase, int MAXLength, boolean Multiplication) throws IllegalArgumentException{
        if(MAXLength<=0){
            throw new IllegalArgumentException("MAXLength isn't allowed to be less than 1!");
        }
        long result = Multiplication ? 1 : 0;
        for(char c: Phrase.toCharArray()){
            if(Multiplication){
                result *= (int) c;
            }
            else{
                result += (int) c;
            }
        }
        
        do{
            result = CrossSum(result);
        }while(result > MAXLength);
        
        return result;
    }

    /**
     * Calculate the PIN
     * @param Phrase The String
     * @return The PIN
     */
    public static long calculatePIN(String Phrase){
        return calculatePIN(Phrase, 4, false);
    }

    /**
     * Calculate the PIN
     * @param Phrase The String
     * @param MAXLength MaxLength of the PIN
     * @throws IllegalArgumentException If the MAXLength is less than 1
     * @return The PIN
     */
    public static long calculatePIN(String Phrase, int MAXLength) throws IllegalArgumentException{
        try{
            return calculatePIN(Phrase, MAXLength, false);
        }catch(IllegalArgumentException e){
            throw new IllegalArgumentException("MAXLength isn't allowed to be less than 1!");
        }
    }

    /**
     * Calculate the PIN
     * @param Phrase The String
     * @param Multiplication Shall the programm to Multiplication? Default is Addition
     * @return The PIN
     */
    public static long calculatePIN(String Phrase, boolean Multiplication){
        return calculatePIN(Phrase, 4, Multiplication);
    }

}
