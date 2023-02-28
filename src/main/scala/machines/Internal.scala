package machines

import regex._
import dfa._

given Conversion[Char, RegularLanguage] =
    c => Character(c)

given Conversion[String, RegularLanguage] = 
    s => s.map(c => Character(c)).reduce(Concat(_,_))

given Conversion[RegularLanguage, DFA] =
    l => regexToDFA(l, findCharacters(l))

extension (l1 : RegularLanguage)
    def ||(l2 : RegularLanguage) : RegularLanguage = Union(l1,l2)
    def ~(l2 : RegularLanguage) : RegularLanguage = Concat(l1,l2)   
    def <*> : RegularLanguage = Star(l1)
    def <+> : RegularLanguage = Concat(l1, Star(l1))
    
    def apply (n : Int) : RegularLanguage = { 
        if (n <= 0) Epsilon 
        else Concat(l1, l1{n-1}) }

    def toDFA (using a : Set[Char]) : DFA = regexToDFA(l1, a)

def findCharacters(l: RegularLanguage) : Set[Char]  = l match
    case Empty => Set() 
    case Epsilon => Set() 
    case Character(c) => Set(c)
    case Union(l1, l2) => findCharacters(l1) | findCharacters(l2)
    case Concat(l1, l2) => findCharacters(l1) | findCharacters(l2)
    case Star(l1) => findCharacters(l1)