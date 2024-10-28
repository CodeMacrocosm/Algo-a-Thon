#include <stdio.h>

int main() {
    double first, second, temp;

    // Prompt user for the first number
    printf("Enter first number: ");
    scanf("%lf", &first);

    // Prompt user for the second number
    printf("Enter second number: ");
    scanf("%lf", &second);

    // Swap the values
    temp = first;   // Store the value of 'first' in 'temp'
    first = second; // Assign the value of 'second' to 'first'
    second = temp;  // Assign the value of 'temp' (initial 'first') to 'second'

    // Display the swapped values, formatted to 2 decimal points
    printf("\nAfter swapping, first number = %.2lf\n", first);
    printf("After swapping, second number = %.2lf\n", second);

    return 0;
}
