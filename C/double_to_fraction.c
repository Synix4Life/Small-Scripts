#include <stdio.h>
#include <math.h>

#define ERROR (1e-6)
#define MAX_ITERATIONS (10000)

void double_to_fraction(double value) {
    int numerator = 1;
    int denominator = 1;
    double diff;
    int iterations = 0;

    while (iterations < MAX_ITERATIONS) {
        diff = fabs(value - (double)numerator / denominator);

        if (diff < ERROR) {  // Tolerance for approximation
            printf("Fraction: %d/%d\n", numerator, denominator);
            return;
        }

        if ((double)numerator / denominator < value) {
            numerator++;
        } else {
            denominator++;
        }

        iterations++;
    }

    // If no accurate fraction was found within the max iterations
    printf("Could not find a fractional representation within %d iterations.\n", MAX_ITERATIONS);
}

int main() {
    double input;

    printf("Enter a double value: ");
    if (scanf("%lf", &input) != 1) {
        printf("Invalid input.\n");
        return 1;
    }

    double_to_fraction(input);

    return 0;
}

