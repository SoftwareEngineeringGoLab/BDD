@tag
  Feature: OurCalculator

    Scenario: Add two numbers
      Given Two input numbers, 2 and 3
      When I add the two numbers
      Then the result should be 5

    Scenario: Subtract two numbers
        Given Two input numbers, 5 and 3
        When I subtract the two numbers
        Then the result should be 2

    Scenario: Multiply two numbers
        Given Two input numbers, 2 and 3
        When I multiply the two numbers
        Then the result should be 6

    Scenario: Divide two numbers
        Given Two input numbers, 6 and 3
        When I divide the two numbers
        Then the result should be 2

    Scenario: Divide by zero
        Given Two input numbers, 6 and 0
        When I divide the two numbers
        Then the result should be an error

    Scenario: Add two negative numbers
        Given Two input numbers, -2 and -3
        When I add the two numbers
        Then the result should be -5

    Scenario: Subtract two negative numbers
        Given Two input numbers, -5 and -3
        When I subtract the two numbers
        Then the result should be -2

    Scenario: Multiply two negative numbers
        Given Two input numbers, -2 and -3
        When I multiply the two numbers
        Then the result should be 6

    Scenario: Divide two negative numbers
        Given Two input numbers, -6 and -3
        When I divide the two numbers
        Then the result should be 2

    Scenario: Add a positive and a negative number
        Given Two input numbers, 2 and -3
        When I add the two numbers
        Then the result should be -1

    Scenario: Subtract a positive and a negative number
        Given Two input numbers, 2 and -3
        When I subtract the two numbers
        Then the result should be 5

    Scenario: Multiply a positive and a negative number
        Given Two input numbers, 2 and -3
        When I multiply the two numbers
        Then the result should be -6

    Scenario: Divide a positive and a negative number
        Given Two input numbers, 6 and -3
        When I divide the two numbers
        Then the result should be -2

    Scenario: Add two large numbers
        Given Two input numbers, 1000000 and 2000000
        When I add the two numbers
        Then the result should be 3000000

    Scenario: Subtract two large numbers
        Given Two input numbers, 2000000 and 1000000
        When I subtract the two numbers
        Then the result should be 1000000

    Scenario: Multiply two large numbers
        Given Two input numbers, 1000 and 2000
        When I multiply the two numbers
        Then the result should be 2000000

    Scenario: Divide two large numbers
        Given Two input numbers, 2000000 and 1000000
        When I divide the two numbers
        Then the result should be 2

    Scenario: Divide undivisible numbers
        Given Two input numbers, 7 and 3
        When I divide the two numbers
        Then the result should be 2.333

    Scenario: Overflow in addition
        Given Two input numbers, 2147483647 and 1
        When I add the two numbers
        Then the result should be an error

    Scenario: Overflow in subtraction
        Given Two input numbers, -2147483648 and 1
        When I subtract the two numbers
        Then the result should be an error

    Scenario: Underflow in addition
        Given Two input numbers, -2147483648 and -1
        When I add the two numbers
        Then the result should be an error

    Scenario: Underflow in subtraction
        Given Two input numbers, 2147483647 and -1
        When I subtract the two numbers
        Then the result should be an error

    Scenario: Power of two numbers
        Given Two input numbers, 2 and 3
        When I raise the first number to the power of the second number
        Then the result should be 8

    Scenario: Power of a negative number by an even number
        Given Two input numbers, -2 and 4
        When I raise the first number to the power of the second number
        Then the result should be 16

    Scenario: Power of a negative number by an odd number
        Given Two input numbers, -2 and 3
        When I raise the first number to the power of the second number
        Then the result should be -8

    Scenario: Power of zero
        Given Two input numbers, 0 and 3
        When I raise the first number to the power of the second number
        Then the result should be 0

    Scenario: Power of a number by zero
        Given Two input numbers, 2 and 0
        When I raise the first number to the power of the second number
        Then the result should be 1

    Scenario: Power of zero by zero
        Given Two input numbers, 0 and 0
        When I raise the first number to the power of the second number
        Then the result should be an error


    Scenario Outline:
      Given Two input numbers, <first> and <second>, and operand <opt>
      When I perform the operation
      Then the result should be <result>

      Examples:
        | first | second | opt | result |
        | 6 | 2 | * | 12 |
        | 6 | 2 | / | 3 |
        | 6 | 2 | ^ | 36 |
        | 100 | -2 | * | -200 |
        | 100 | -2 | / | -50 |
        | 100 | -2 | ^ | 0.0001 |
        | 100 | 0 | * | 0 |
        | 100 | 0 | / | an error |
        | 100 | 0 | ^ | 1 |
        | 0 | 100 | * | 0 |
        | 0 | 100 | / | 0 |
        | 0 | 100 | ^ | 0 |
        | 0 | 0 | * | 0 |
        | 0 | 0 | / | an error |
        | 0 | 0 | ^ | an error |
        | 13 | 2 | / | 6.5 |
        | 13 | 2 | * | 26 |
