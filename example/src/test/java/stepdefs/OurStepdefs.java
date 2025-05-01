package stepdefs;

import calculator.OurCalculator;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class OurStepdefs {
    private static OurCalculator calculator;
    private int value1;
    private int value2;
    private String opt;
    private float result;
    private boolean exceptionThrown;

    @BeforeAll
    public static void setUp() {
        calculator = new OurCalculator();
    }

    @Given("Two input numbers, {int} and {int}")
    public void twoInputNumbersAnd(int int1, int int2) {
        value1 = int1;
        value2 = int2;
    }

    @Given("I add the two numbers")
    public void iAddTheTwoNumbers() {
        try {
            result = calculator.add(value1, value2);
            exceptionThrown = false;
        } catch (ArithmeticException e) {
            exceptionThrown = true;
        }
    }


    @Given("I subtract the two numbers")
    public void iSubtractTheTwoNumbers() {
        try {
            result = calculator.subtract(value1, value2);
            exceptionThrown = false;
        } catch (ArithmeticException e) {
            exceptionThrown = true;
        }
    }

    @Given("I multiply the two numbers")
    public void iMultiplyTheTwoNumbers() {
        try {
            result = calculator.multiply(value1, value2);
            exceptionThrown = false;
        } catch (ArithmeticException e) {
            exceptionThrown = true;
        }
    }

    @Given("I divide the two numbers")
    public void iDivideTheTwoNumbers() {
        try {
            result = calculator.divide(value1, value2);
            exceptionThrown = false;
        } catch (ArithmeticException e) {
            exceptionThrown = true;
        }
    }

    @Given("I raise the first number to the power of the second number")
    public void iRaiseTheFirstNumberToThePowerOfTheSecondNumber() {
        try {
            result = calculator.power(value1, value2);
            exceptionThrown = false;
        } catch (ArithmeticException e) {
            exceptionThrown = true;
        }
    }


    @Given("the result should be {float}")
    public void theResultShouldBe(float expected) {
        Assert.assertEquals(expected, result, 0.001);
        Assert.assertFalse(exceptionThrown);
    }

    @Given("the result should be an error")
    public void theResultShouldBeAnError() {
        Assert.assertTrue(exceptionThrown);
    }

    @Given("Two input numbers, {int} and {int}, and operand *")
    public void twoInputNumbersAndOperand(int int1, int int2) {
        value1 = int1;
        value2 = int2;
        opt = "*";
    }

    @Given("Two input numbers, {int} and {int}, and operand \\/")
    public void twoInputNumbersAndOperand2(int int1, int int2) {
        value1 = int1;
        value2 = int2;
        opt = "/";
    }

    @Given("Two input numbers, {int} and {int}, and operand +")
    public void twoInputNumbersAndOperand3(int int1, int int2) {
        value1 = int1;
        value2 = int2;
        opt = "+";
    }

    @Given("Two input numbers, {int} and {int}, and operand -")
    public void twoInputNumbersAndOperand4(int int1, int int2) {
        value1 = int1;
        value2 = int2;
        opt = "-";
    }

    @Given("Two input numbers, {int} and {int}, and operand ^")
    public void twoInputNumbersAndOperand5(int int1, int int2) {
        value1 = int1;
        value2 = int2;
        opt = "^";
    }

    @When("I perform the operation")
    public void iPerformTheOperation() {
        try {
            result = calculator.calculate(value1, value2, opt);
            exceptionThrown = false;
        } catch (ArithmeticException e) {
            exceptionThrown = true;
        }
    }
}
