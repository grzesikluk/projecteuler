### Problem 98

#### Description
By replacing each of the letters in the word CARE with 1, 2, 9, and 6 respectively, we form a square number: 1296 = 36^2. What is remarkable is that, by using the same digital substitutions, the anagram, RACE, also forms a square number: 9216 = 96^2. We shall call CARE (and RACE) a square anagram word pair and specify further that leading zeroes are not permitted, neither may a different letter have the same digital value as another letter.

Using words.txt (right click and 'Save Link/Target As...'), a 16K text file containing nearly two-thousand common English words, find all the square anagram word pairs (a palindromic word is NOT considered to be an anagram of itself).

What is the largest square number formed by any member of such a pair?

NOTE: All anagrams formed must be contained in the given text file.

#### Solution

##### Ideas
* as a initial table - create square numbers of length between (min, max) of all words from file **DONE**
* assign the values so the value of square number is created
* one by one check words of the same length that contain all the letters in the same amount - create some comparator
for that, - anagrams checking needed **DONE**
* for all anagrams assing some values and check if square number is produced
* note that letters must mach the same digit limiting possible variants
* create data structure - sets of words that anagrams, remove sets with size 1 **DONE**


##### Algorithm
* read file **DONE**
* get min max from words lengths **DONE**
* create square numbers array of length min to max **DONE**
* divide all words to sets of anagrams, removing it from main set when done **DONE**
* for each set do try to find if there is any square anagram pair, if yes store it (how to do this?)
* return max number from all found pairs

##### Links


Created by Lukasz 2017-08-28