The program is aid to provide Romans Numerial converter,

either from Romans Numerial to Decimals, or from Romans Numerial to Decimals


Design behind the program:


The entry point of the program is org.roman.RomanNumerals.

The program try to make use of interpret pattern and Strategy pattern to improve the design.



As mentioned in wikipidia

http://en.wikipedia.org/wiki/Roman_numerals

There has been no standardization, there may be multiple ways of representing 
the same number in Roman numerals.


Anytime the programmer want to use new solution to convert the Romans Numerial,
they just need to develop a rule implement interface org.roman.rule.Rule.
And inject the implementation into the program in order to make use of new solution.






Limitation of the program:

Only accept the conversion with decimal value from 1 to 3999

The full command-line invocation for the the program:
  > mvn package
  > java -cp target/roman-1.0-SNAPSHOT.jar org.roman.RomanNumerals <numeral to be converted>
  
e.g. 
  > mvn package
  > java -cp target/roman-1.0-SNAPSHOT.jar org.roman.RomanNumerals 123 



Class Description:

org.roman.RomanNumerals -  Entry point of the program
org.roman.Context - Context class, store the variable be used in the conversion 
org.roman.Const   - Constants class
org.sudoku.Sudoku  -  Entry point of the program
org.roman.expression.Expression - Representation to interpret numeral conversion
org.roman.expression.OneExpression - Interpret the Roman Numerals which's decimal value is from 1 to 9 
org.roman.expression.TenExpression - Interpret the Roman Numerals which's decimal value is from 10 to 90 
org.roman.expression.HundredExpression - Interpret the Roman Numerals which's decimal value is from 100 to 900 
org.roman.expression.ThousandExpression - Interpret the Roman Numerals which's decimal value is from 1000 to 399
org.roman.rule.Rule - The rule to convert the Numeral
org.roman.rule.DecimalsToRomansRuleImpl - The rule implementation to convert Decimals to Roman Numerial
org.roman.rule.RomansToDecimalsRuleImpl - The rule implementation  to convert Roman Numerial to Decimals 

org.roman.NumeralsRomansTest - Test case class to test the conversion from Decimals to Romans Numerals
org.roman.RomansNumeralsTest - Test case class to test the conversion from Romans Numerals to Decimals

