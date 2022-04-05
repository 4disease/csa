## Tech Talk 2 : Calculator

### Process
- Tokenize (Separate into different values)
  - Use hashmaps for this
- Put into reverse polish notation (Two numbers before the operator, easier for computers to read)
  - Ex. 3 + 4 becomes 3 4 +
- Calculate by popping 2 numbers into stack, finding next operator, popping result back into stack

### Tokenizer
```java
    // Term Tokenizer takes original expression and converts it to ArrayList of tokens
    private void termTokenizer() {
        // contains final list of tokens
        this.tokens = new ArrayList<>();

        int start = 0;  // term split starting index
        StringBuilder multiCharTerm = new StringBuilder();    // term holder
        for (int i = 0; i < this.expression.length(); i++) {
            Character c = this.expression.charAt(i);
            if ( isOperator(c.toString() ) || isSeperator(c.toString())  ) {
                // 1st check for working term and add if it exists
                if (multiCharTerm.length() > 0) {
                    tokens.add(this.expression.substring(start, i));
                }
                // Add operator or parenthesis term to list
                if (c != ' ') {
                    tokens.add(c.toString());
                }
                // Get ready for next term
                start = i + 1;
                multiCharTerm = new StringBuilder();
            } else {
                // multi character terms: numbers, functions, perhaps non-supported elements
                // Add next character to working term
                multiCharTerm.append(c);
            }

        }
        // Add last term
        if (multiCharTerm.length() > 0) {
            tokens.add(this.expression.substring(start));
        }
    }
```

### Putting into RPN
```java
// Takes tokens and converts to Reverse Polish Notation (RPN), this is one where the operator follows its operands.
    private void tokensToReversePolishNotation () {
        // contains final list of tokens in RPN
        this.reverse_polish = new ArrayList<>();

        // stack is used to reorder for appropriate grouping and precedence
        Stack tokenStack = new Stack();
        for (String token : tokens) {
            switch (token) {
                // If left bracket push token on to stack
                case "(":
                    tokenStack.push(token);
                    break;
                case ")":
                    while (tokenStack.peek() != null && !tokenStack.peek().equals("("))
                    {
                        reverse_polish.add( (String)tokenStack.pop() );
                    }
                    tokenStack.pop();
                    break;
                case "+":
                case "-":
                case "*":
                case "/":
                case "%":
                    // While stack
                    // not empty AND stack top element
                    // and is an operator
                    while (tokenStack.peek() != null && isOperator((String) tokenStack.peek()))
                    {
                        if ( isPrecedent(token, (String) tokenStack.peek() )) {
                            reverse_polish.add((String)tokenStack.pop());
                            continue;
                        }
                        break;
                    }
                    // Push the new operator on the stack
                    tokenStack.push(token);
                    break;
                default:    // Default should be a number, there could be test here
                    this.reverse_polish.add(token);
            }
        }
        // Empty remaining tokens
        while (tokenStack.peek() != null) {
            reverse_polish.add((String)tokenStack.pop());
        }

    }
```

### Calculator Code

```java
    // Takes RPN and produces a final result
    private void rpnToResult()
    {
        // Stack used to hold calculation while process RPN
        Stack calculation = new Stack();

        for (int i = 0; i < reverse_polish.size(); i++) // for loop to process RPN
        {
            // If the token is a number
            if (!(isOperator(reverse_polish.get(i)))) {
                // Push number to stack
                calculation.push(reverse_polish.get(i));
            } else {
                double firstPop = Double.valueOf(calculation.pop().toString());
                double secondPop = Double.valueOf(calculation.pop().toString());
                // Pop the two top entries
                // Based off of Token operator calculate result
                if (reverse_polish.get(i).equals("%")) {
                    result = secondPop % firstPop;
                } else if (reverse_polish.get(i).equals("^")) {
                    result = Math.pow(secondPop, firstPop);
                } else if (reverse_polish.get(i).equals("*")) {
                    result = secondPop * firstPop;
                } else if (reverse_polish.get(i).equals("/")) {
                    result = secondPop / firstPop;
                } else if (reverse_polish.get(i).equals("+")) {
                    result = secondPop + firstPop;
                } else if (reverse_polish.get(i).equals("-")) {
                    result = secondPop - firstPop;
                }

                // Push result back onto the stack
                calculation.push(result);
            }
        }
        // Pop final result and set as final result for expression
        this.result = (double)calculation.pop();
    }
```

For this segment, we had to write a method that would calculate the result from an array of numbers in RPN format.
I was able to fulfill this task by using a for loop. Numbers are pushed to a stack, and calculations are made based on the order of the array. 
If statements are used to make the calculations and return them to the stack. 

| Replit |           Review Ticket                              | 
|-----------------------------|-----------------------------|  
 [Replit](https://replit.com/@4DISEASE/csa#hacks/Calculator2.java) | [Review Ticket](https://github.com/4disease/csa/issues/3) |


