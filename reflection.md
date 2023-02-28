# Reflection on implementing regular expressions of a DSL

## Which operators were easiest to implement and why?

We thought that operators like ||, ~, and <*> were the easiest to implement because we just had to substitute in expressions from our RegularLanguage implementation where they were needed. All in all, it was a pretty straightforward task. We definitely had a lot more trouble with the operators that required a bit more thinking to get working!

## Which operators were most difficult to implement and why?

The most difficult one was {n} becuase we encountered a weird error with our recursion. For some reason, Empty instead of epsilon as a base case cause runtime errors. Eventually we figured it out. Despite this, from the onset we had a pretty good idea of what we were supposed to do, and then we did it! We also had some trouble implementing the conversion from Strings to RegularLanguages. This is because we had to use some higher-order functions (map and reduce) together in a clever way. It took us some time, but understanding these higher-order functions well will help us in future assignments as well as our upcoming projects! 

## Comment on the design of this internal DSL

Overal the final use of the internal dsl is very clean and non verbose. Unlike normal functions, we can use them much easier and the final result is very readable with operators. It's also good that our design is not too stuffy with types; all the conversions we did are doing good work to make it more usable! Implicit conversion is a very powerful feature, and luckily it seems to work in a simple non instrusive way. Only changes *you would expect* occur. 

Sadly, this current implementation requires alot of parentheses in order to maintain proper expected results. My least favourite part of Haskell was have much of a requirement parentheses were. The symbols we used were also not ideal. the <> part made it awkward to read and type, since we rely on prexisting symbols +, *, etc.

One thing that might make the language better is changing the syntax for the repetition operator. {} is terse, but for someone reading the code for the first time, it's not immediately obvious what those brackets are doing. I also dont have experience using the operator like that in traditional regular expressions. A more readable replacement for {} in this language could be exp <rep> num. 
Scala's rules for valid identifiers prevent the above from being something non clunky - in order to have an input it must be in {} or after a space, so we couldn't have an input in <> or other triggers. 




Write a few brief paragraphs that discuss:

- What works about this design? (For example, what things seem easy and
  natural to say, using the DSL?)
- What doesn't work about this design? (For example, what things seem
  cumbersome to say?)
- Think of a syntactic change that might make the language better. How would
  you implement it _or_ what features of Scala would prevent you from
  implementing it? (You don't have to write code for this part. You could say
  "I would use extension to..." or "Scala's rules for valid
  identifiers prevent...")
