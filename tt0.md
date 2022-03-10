## Tech Talk 0 : Data structures

### What is a data structure?
Method of organizing data
- Single value
- Sequence of numbers
- Table of data
- Database

### Paradigms
Paradigm: An approach or method to be followed for writing software.

Imperative Paradigm: Sequence of events based off of a choice. Think about it like a flowchart.
- Uses statements to change a program's state
- Focuses on describing "how" a program code works
- Which method to execute based on user input?
- Procedural programming: Type of imperative programming where the program is built from one or more procedures

Object-oriented Paradigm: Paradigm that relies on the concept of classes and objects. Think about it like a UML diagram.
- Uses reusable pieces of code blueprints to create individual instances of objects

### Data Structures

Arrays/Lists
``` java 
public static Animal[] animalData() {
	return new Animal[]{
	        new Animal("Lion", 8, "Gold"),
	        new Animal("Pig", 3, "Pink"),
		new Animal("Robin", 7, "Red"),
		new Animal("Cat", 10, "Black"),
		new Animal("Kitty", 1, "Calico"),
		new Animal("Dog", 14, "Brown")
	};
}

//this is a comment
```

Java HashMap
```
private final Map<String, Integer> OPERATORS = new HashMap<>();
    {
        // Map<"token", precedence>
        OPERATORS.put("*", 3);
        OPERATORS.put("/", 3);
        OPERATORS.put("%", 3);
        OPERATORS.put("+", 4);
        OPERATORS.put("-", 4);
    }
```

Algorithms always accompany data structures.

