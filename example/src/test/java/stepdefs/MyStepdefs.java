package stepdefs;

import calculator.Calculator;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.Before;

public class MyStepdefs {
    private Calculator calculator;
    private int value1;
    private int value2;
    private int result;

    @Before
    public void before() {
        calculator = new Calculator();
    }


    @Given("Two input values, {int} and {int}")
    public void two_input_values_and(Integer int1, Integer int2) {
        value1 = int1;
        value2 = int2;
    }
    @When("I add the two values")
    public void i_add_the_two_values() {
        calculator = new Calculator();
        result = calculator.add(value1, value2);
        System.out.println(result);
    }
    @Then("I expect the result {int}")
    public void i_expect_the_result(Integer int1) {
        int expected = int1;
        Assert.assertEquals(expected, result);
    }
}