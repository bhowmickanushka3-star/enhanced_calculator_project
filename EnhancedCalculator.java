import java.util.Scanner;
import java.util.InputMismatchException;

public class EnhancedCalculator {

    private static Scanner sc = new Scanner(System.in);

    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero!");
        }
        return a / b;
    }

    public static double power(double base, double exp) {
        return Math.pow(base, exp);
    }

    public static double squareRoot(double num) {
        return Math.sqrt(num);
    }

    public static double sine(double angle) {
        return Math.sin(Math.toRadians(angle));
    }

    public static double cosine(double angle) {
        return Math.cos(Math.toRadians(angle));
    }

    public static double tangent(double angle) {
        return Math.tan(Math.toRadians(angle));
    }

    public static double log(double num) {
        return Math.log(num);
    }

    public static double celsiusToFahrenheit(double c) {
        return (c * 9 / 5) + 32;
    }

    public static double fahrenheitToCelsius(double f) {
        return (f - 32) * 5 / 9;
    }

    public static double inrToUsd(double inr) {
        return inr / 83.0; 
    }

    public static double usdToInr(double usd) {
        return usd * 83.0; 
    }

    public static void displayMenu() {
        System.out.println("\n--- Enhanced Console Calculator ---");
        System.out.println("1. Basic Arithmetic (+, -, *, /)");
        System.out.println("2. Scientific Functions (pow, sqrt, sin, cos, tan, log)");
        System.out.println("3. Unit Conversion (Temperature, Currency)");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
    }

    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            try {
                displayMenu();
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter first number: ");
                        double a = sc.nextDouble();
                        System.out.print("Enter second number: ");
                        double b = sc.nextDouble();
                        System.out.println("Choose operation (+, -, *, /): ");
                        char op = sc.next().charAt(0);

                        switch (op) {
                            case '+': System.out.println("Result: " + add(a, b)); break;
                            case '-': System.out.println("Result: " + subtract(a, b)); break;
                            case '*': System.out.println("Result: " + multiply(a, b)); break;
                            case '/': System.out.println("Result: " + divide(a, b)); break;
                            default: System.out.println("Invalid operation!");
                        }
                        break;

                    case 2:
                        System.out.println("Choose function (1: pow, 2: sqrt, 3: sin, 4: cos, 5: tan, 6: log): ");
                        int func = sc.nextInt();
                        double num1, num2;
                        switch (func) {
                            case 1:
                                System.out.print("Enter base: ");
                                num1 = sc.nextDouble();
                                System.out.print("Enter exponent: ");
                                num2 = sc.nextDouble();
                                System.out.println("Result: " + power(num1, num2));
                                break;
                            case 2:
                                System.out.print("Enter number: ");
                                num1 = sc.nextDouble();
                                System.out.println("Result: " + squareRoot(num1));
                                break;
                            case 3:
                                System.out.print("Enter angle (degrees): ");
                                num1 = sc.nextDouble();
                                System.out.println("Result: " + sine(num1));
                                break;
                            case 4:
                                System.out.print("Enter angle (degrees): ");
                                num1 = sc.nextDouble();
                                System.out.println("Result: " + cosine(num1));
                                break;
                            case 5:
                                System.out.print("Enter angle (degrees): ");
                                num1 = sc.nextDouble();
                                System.out.println("Result: " + tangent(num1));
                                break;
                            case 6:
                                System.out.print("Enter number: ");
                                num1 = sc.nextDouble();
                                System.out.println("Result: " + log(num1));
                                break;
                            default:
                                System.out.println("Invalid function choice!");
                        }
                        break;

                    case 3:
                        System.out.println("Choose conversion (1: C->F, 2: F->C, 3: INR->USD, 4: USD->INR): ");
                        int conv = sc.nextInt();
                        double value;
                        switch (conv) {
                            case 1:
                                System.out.print("Enter Celsius: ");
                                value = sc.nextDouble();
                                System.out.println("Fahrenheit: " + celsiusToFahrenheit(value));
                                break;
                            case 2:
                                System.out.print("Enter Fahrenheit: ");
                                value = sc.nextDouble();
                                System.out.println("Celsius: " + fahrenheitToCelsius(value));
                                break;
                            case 3:
                                System.out.print("Enter INR: ");
                                value = sc.nextDouble();
                                System.out.println("USD: " + inrToUsd(value));
                                break;
                            case 4:
                                System.out.print("Enter USD: ");
                                value = sc.nextDouble();
                                System.out.println("INR: " + usdToInr(value));
                                break;
                            default:
                                System.out.println("Invalid conversion choice!");
                        }
                        break;

                    case 4:
                        exit = true;
                        System.out.println("Exiting... Thank you!");
                        break;

                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter numbers only.");
                sc.nextLine(); 
            } catch (ArithmeticException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}

