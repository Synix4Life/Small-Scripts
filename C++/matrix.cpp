#include "matrix.h"

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#include <cstdlib>
#include <vector>

/**
 * @brief Constructor
 */
Matrix::Matrix(int height, int width){
    this->width = width;
    this->height = height;
    this->matrix = std::vector<std::vector<int>>(height, std::vector<int>(width, 0));
}

/**
 * @brief Set all values to zero
 */
void Matrix::all_zero(){
    for(int i=0; i<height; i++){
        for(int j=0; j<width; j++){
            matrix[i][j] = 0;
        }
    }
}

/**
 * @brief Get an element
 */
int Matrix::get(int rowPos, int colPos){
    return matrix[rowPos][colPos];
}

/**
 * @brief Set an element
 */
void Matrix::set(int rowPos, int colPos, int value){
    matrix[rowPos][colPos] = value;
}

void Matrix::printMatrix(){
    printf("\n");
    for(int i=0; i<height; i++){
        for(int j=0; j<width; j++){
            printf("%d\t", matrix[i][j]);
        }
        printf("\n");
    }
    printf("\n");
}

/**
 * @brief Addition Overload
 */
Matrix Matrix::operator+(Matrix second){
    if(this->width != second.getWidth() || this->height != second.getHeight()){
        perror("Matrix second needs to have the same dimensions!");
        exit(1);
    }
    Matrix returnable(this->height, this->width);
    for(int i=0; i<height; i++){
        for(int j=0; j<width; j++){
            returnable.set(i, j, this->get(i,j) + second.get(i,j));
        }
    }
    return returnable;
}

/**
 * @brief Multiplication Overload
 */
Matrix Matrix::operator*(Matrix second){
    if(this->width != second.getHeight()){
        perror("Matrix second needs to have the same dimensions!");
        exit(1);
    }
    Matrix returnable(this->height, second.width);
    for (int i = 0; i < this->height; i++) {
        for (int j = 0; j < second.width; j++) {
            int sum = 0;
            for (int k = 0; k < this->width; k++) {
                sum += this->get(i, k) * second.get(k, j);
            }
            returnable.set(i, j, sum);
        }
    }

    return returnable;
}

/**
 * @brief Subtraction Overload
 */
Matrix Matrix::operator-(Matrix second){
    if(this->width != second.getWidth() || this->height != second.getHeight()){
        perror("Matrix second needs to have the same dimensions!");
        exit(1);
    }
    Matrix returnable(this->height, this->width);
    for(int i=0; i<height; i++){
        for(int j=0; j<width; j++){
            returnable.set(i, j, this->get(i,j) - second.get(i,j));
        }
    }
    return returnable;
}

/**
 * @brief Fill random
 * 
 * Fill the Matrix with random values in a given closed intervall [lowertBound upperBound]
 */
void Matrix::setRandom(int lowerBound, int upperBound) {
    srand(time(0));

    for (int i = 0; i < height; i++) {
        for (int j = 0; j < width; j++) {
            int randomValue = lowerBound + (rand() % (upperBound - lowerBound + 1)); 
            this->matrix[i][j] = randomValue;
        }
    }
}