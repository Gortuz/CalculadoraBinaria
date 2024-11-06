package com.example.binary;

public class BinaryCalculator {

    public String add(String a, String b) {
        int num1 = binaryToDecimal(a);
        int num2 = binaryToDecimal(b);
        int sum = num1 + num2;
        return decimalToBinary(sum);
    }

    // Subtracts the second binary number from the first
    public String subtract(String a, String b) {
        int num1 = binaryToDecimal(a);
        int num2 = binaryToDecimal(b);
        int difference = num1 - num2;
        return decimalToBinary(difference);
    }

    // Multiplies two binary numbers
    public String multiply(String a, String b) {
        int num1 = binaryToDecimal(a);
        int num2 = binaryToDecimal(b);
        int product = num1 * num2;
        return decimalToBinary(product);
    }

    // Divides the first binary number by the second
    public String divide(String a, String b) {
        int num1 = binaryToDecimal(a);
        int num2 = binaryToDecimal(b);
        if (num2 == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        int quotient = num1 / num2;
        return decimalToBinary(quotient);
    }

    // Converts a binary string to a decimal integer
    public int binaryToDecimal(String binary) {
        int decimal = 0;
        int base = 1; // 2^0

        // Process the binary string from right to left
        for (int i = binary.length() - 1; i >= 0; i--) {
            if (binary.charAt(i) == '1') {
                decimal += base;
            }
            base *= 2; // Increment base as powers of 2
        }
        return decimal;
    }

    // Converts a decimal integer to a binary string
    public String decimalToBinary(int decimal) {
        if (decimal == 0) {
            return "0";
        }

        StringBuilder binary = new StringBuilder();

        // Perform division-by-2 repeatedly and collect remainders
        while (decimal > 0) {
            int remainder = decimal % 2;
            binary.insert(0, remainder); // Append remainder at the beginning
            decimal /= 2;
        }
        return binary.toString();
    }



//    public String add(String a, String b) {
//        int num1 = Integer.parseInt(a, 2); // Convert binary to decimal
//        int num2 = Integer.parseInt(b, 2);
//        int sum = num1 + num2;
//        return Integer.toBinaryString(sum); // Convert result back to binary
//    }
//
//    // Subtracts the second binary number from the first
//    public String subtract(String a, String b) {
//        int num1 = Integer.parseInt(a, 2);
//        int num2 = Integer.parseInt(b, 2);
//        int difference = num1 - num2;
//        return Integer.toBinaryString(difference);
//    }
//
//    // Multiplies two binary numbers
//    public String multiply(String a, String b) {
//        int num1 = Integer.parseInt(a, 2);
//        int num2 = Integer.parseInt(b, 2);
//        int product = num1 * num2;
//        return Integer.toBinaryString(product);
//    }
//
//    // Divides the first binary number by the second
//    public String divide(String a, String b) {
//        int num1 = Integer.parseInt(a, 2);
//        int num2 = Integer.parseInt(b, 2);
//        if (num2 == 0) {
//            throw new ArithmeticException("Division by zero is not allowed.");
//        }
//        int quotient = num1 / num2;
//        return Integer.toBinaryString(quotient);
//    }
//
//    public String binaryToDecimal(String binary) {
//        return Integer.parseInt(binary, 2)+"";
//    }


}
