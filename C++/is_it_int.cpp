#include <iostream>

/**
 * @brief Is it an integer?
 * 
 * This function attempts to read an integer from the user. If the input is
 * not a valid integer (e.g. a non-numeric value), it displays an error
 * message. Otherwise, it confirms that the input is a valid integer.
 * 
 * @return void
 */
int main(){
    int theVar;

    std::cout << "Give me the value you want to check!" << std::endl;

    std::cin >> theVar;
    
    if (std::cin.fail()) {
        std::cout << "Nope, not an integer :-(" << std::endl;
    } else {
        std::cout << "Indeed! An integer! " << std::endl;
    }
    
    return 0;
}