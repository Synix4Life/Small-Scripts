/**
 * Method to calculate the Cross Sum
 * @param value The value
 * @return The Cross Sum
 */
int cross_sum(int value){
    int result = 0;
    while(value > 0){
        result += result % 10;
        result /= 10;
    }
    return result;
}