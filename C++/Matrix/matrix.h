#pragma once

#include <vector>

class Matrix{
    private:
        int height;
        int width;
        mutable std::vector<std::vector<int>> matrix;
    public:
        Matrix(int height, int width);
        void all_zero();
        int get(int rowPos, int colPos);
        void set(int rowPos, int colPos, int value);
        void printMatrix();
        Matrix operator+(Matrix second);
        Matrix operator*(Matrix second);
        Matrix operator-(Matrix second);
        int getWidth(){ return width; }
        int getHeight(){ return height; }
        void setRandom(int lowerBound, int upperBound);
};