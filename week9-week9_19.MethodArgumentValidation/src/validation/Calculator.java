package validation;

public class Calculator {

    public int multiplication(int fromInteger) {
        if(fromInteger < 0) {
            throw new IllegalArgumentException("The number must be positive.");
        }
        int multiplication = 1;
        for (int i = 1; i <= fromInteger; i++) {
            multiplication *= i;
        }

        return multiplication;
    }

    public int binomialCoefficient(int setSize, int subsetSize) {
        if(setSize < 0 || subsetSize < 0 || subsetSize > setSize) {
            throw new IllegalArgumentException("Please make sure the "
                    + "sets are both positive and the subset is smaller "
                    + "than the set");
        }
        int numerator = multiplication(setSize);
        int denominator = multiplication(subsetSize) * multiplication(setSize - subsetSize);

        return numerator / denominator;
    }
}
