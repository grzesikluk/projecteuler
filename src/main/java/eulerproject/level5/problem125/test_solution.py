import unittest

from eulerproject.level5.problem125.solution import isPalindromeNumber, getSumAndCountOfPalindromes


class TestProblem(unittest.TestCase):
    def test_isPalindrome(self):
        self.assertFalse(isPalindromeNumber(152))
        self.assertFalse(isPalindromeNumber(1552))
        self.assertFalse(isPalindromeNumber(15652))
        self.assertTrue(isPalindromeNumber(151))
        self.assertTrue(isPalindromeNumber(1551))
        self.assertTrue(isPalindromeNumber(15651))
        self.assertTrue(isPalindromeNumber(1))

    def test_solution(self):
        self.assertEqual((4164, 11), getSumAndCountOfPalindromes(1000))

if __name__ == '__main__':
    unittest.main()
