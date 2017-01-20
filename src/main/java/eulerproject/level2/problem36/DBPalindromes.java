package net.euler.problems.sol.pr36;
import net.euler.problems.sol.pr32.Number;
import net.euler.problems.sol.pr42.Word;
/**
 Double-base palindromes
 Problem 36
 The decimal number, 585(dec) = 1001001001(binary), is palindromic in both bases.

 Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2.

 (Please note that the palindromic number, in either base, may not include leading zeros.)
 */
public class DBPalindromes {
    public static int SIZE = 1000000;
    public static int sum = 0;

    public static void main(String[] args) {

        for (int i = 0; i < SIZE; i++) {
            Number a = new Number(i);
            Word   w = new Word(a.getBinaryRepres());
            Word   d = new Word(a.toString());

            if( d.isPalindrom() && w.isPalindrom())  {
                System.out.println("a=" + a + " a(bin)="+a.getBinaryRepres());
                sum+=a.getI();

            }
        }
        System.out.println("sum="+sum);

    }
}
