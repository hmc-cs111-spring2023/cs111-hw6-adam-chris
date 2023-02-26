package machines

import regex._
import dfa._

// TODO: Add your code below

given Conversion[Char, RegularLanguage] =
    c => Character(c)

given Conversion[String, RegularLanguage] = 
    s => s.map(c => Character(c)).reduce(Concat(_,_))

extension (l1 : RegularLanguage)
    def ||(l2 : RegularLanguage) : RegularLanguage = Union(l1,l2)
    def ~(l2 : RegularLanguage) : RegularLanguage = Concat(l1,l2)   
    def <*> : RegularLanguage = Star(l1)
    def <+> : RegularLanguage = Concat(l1, Star(l1))
    
    def apply (n : Int) : RegularLanguage = { 
        if (n <= 0) Empty 
        else Concat(l1, l1{n-1}) }
    
    // {
    //     var output = Empty
    //     var b = n
    //     while(b > 0) {
    //         output = Concat(output, l1) 
    //         b = b-1
    //     } output
    // }
