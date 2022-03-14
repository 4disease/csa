## Review

Encapsulation:
- Fundamental concept of object-oriented programming
- Wraps the data (variables) and code that acts on the data (methods) in one unit (class)
- Why make instance variables private?
- Restrict access (read-only)
- Option to provide validation checks
- make instance variables private for CSA
- Getters: return value of variable/data
- Setters: Set value of variable/data

//Single line comment//
/* multi linecomment */

Accessor methods ("Getters")
- Allow safe access to instance variables
  -often referred to get methods/getters
- Must be public (provide visibility to everything esle)
  -Return type must match the type of the instance variable to be accessed
- No parameters
  -Naming conventions getNameOfVariable
  toString method
- Overridden method that is included in classes to provide a diescription of a specific object (includes what values are stored in the the instance data of the object

Mutator methods ("setters")
- Mutator methods are often void methods that change the values of instance variables or static variables

When static is used in a method, the class owns the method
When you don't use static, an individual object owns the method

Static methods
- Associated with class, not object
- Include keyword static in the header
- Static methods cannot access instance variables
- Do not have a this reference, unable to use class instance variables or call non static methods

Variable scope
- Local variables can be declared in the body of constructors and methods - may only be used within the constructor or method - cannot be declared public or private
- When there is a local variable with the same name as an instance variable, it will refer to the local
- Formal parameters and variables declared in a method or constructor can only be used within that method or constructor
