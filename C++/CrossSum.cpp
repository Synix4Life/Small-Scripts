#include <iostream>

int cross_sum(int value){
    int result = 0;
    while(value > 0){
        result += result % 10;
        result /= 10;
    }
    return result;
}

int main(int argc, char* argv[]){
    int in;
    std::cout << "Please enter an Integer: ";
    std::cin >> in;
    std:: cout << "For " << in << ", we got " << cross_sum(in) << std::endl;
}