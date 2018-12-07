## Other ideas with `CharCounter`s:
- DON'T create them all from the beginning
- Instead, we check to see if we already have a counter for a character. If we do, use it. If not, make a new one for that character
- This is all taken care of by our wrapper class
- can remove "index" from `CharCounter`

### How can we make this performant?
- Option 1: We use a `Map` from `Character` to `CharCounter`
- Option 2: We use a `Map` from `Character` to `Integer`. Screw `CharCounter`; We can do this with a `Map`
- Option 3: We use a `Set` of `CharCounter`s and have `CharCounter` delegate `equals()` and `hashCode()` to `Character`. This is a Hack! But I like it :P


# "Algorithm":

We need to parse the input string into `Word`s, which wrap an array of `SolvableCharacter`s. `SolvableCharacter`s can either be solved or unsolved. See the design discussion below. All of the `Word`s' `SolvableCharacter`s will start unsolved except special characters (non-letters)

When parsing the input, we also build up the character counts

We also need a "table" that has a list of letters in the order of most common to least common, and whether that character is the solution for an encrypted character yet

I also recommend putting the character counts and the table into some sort of key or legend.

Obviously, we need a dictionary of possible words

Now, we start the actual algorithm, which is actually pretty simple, but it's also will go through all possible character combinations:
1) "Solve" a letter

   We take the `CharCounter` with the highest count that isn't solved yet and "solve" it as the most common character that isn't used yet
2) We check that against the dictionary to see if all the words have a possibility

   If so: we recursively call this algorithm to try and solve the next character
   If not: we use the NEXT most common character. If we go through all those possibilities and don't find something, then we exit with no solutions for the call higher in the stack, telling it that it needs to try something different. If this is the highest call in the stack, then the crypto is unsolvable using our dictionary

That's it. If we wanted to, we could try to improve the speed by trying shorter words first (There are only 2 one-letter words in English, and shorter words have fewer possibilities). With this, we don't need the table of solved-to characters to be in order of most common, since we'll be basing solution guesses on trying to make a certain word.

Our toughest issue will be checking whether our partially solved words have equivalents in the dictionary. I don't know what capabilities the dictionary lib you found has.

## `SolvableCharacter` design discussion:  
API:  
`char getOriginalCharacter()`  
`boolean isSolved()`  
`char getSolutionCharacter()`  

There a 3 ways to do this that I can think of:
1) `SolvableCharacter` simply has two `char`/`Character` fields and `isSolved(`) just checks if the solution character is not null (or some kind of flag character)
2) `SolvableCharacter` has a `char` field for the original character and a `Solution` for the solution character  
   
   `Solution` interface has two subtypes: `Solved` and `Unsolved`.  `getSolutionCharacter()` and `isSolved()` will delegate to `Solution`
   
   `Solved` will have a field for the solution character which `getSolutionCharacter()` will return; `Solved`'s `isSolved()` method will always return `true`.  
   
   `Unsolved` will have no fields; `getSolutionCharacter()` will either throw an exception or return null or flag character and `isSolved` will always return `false`
3) `SolvableCharacter` is an interface and has two implementations: `UnsolvedCharacter` and `SolvedCharacter`

There's also the complete alternative of `Word`s just holding the string of characters and we just check the Legend/Key which could hold these solvable characters...

Or `SolvableCharacters` only hold the original character and the `isSolved()` and `getSolutionCharacter()` methods take a `Key` as an argument to ask it.
