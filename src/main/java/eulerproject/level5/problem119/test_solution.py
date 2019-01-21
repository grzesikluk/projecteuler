import unittest

from eulerproject.level5.problem119 import solution


class TestProblem(unittest.TestCase):
    def test_getSumOfDigits(self):
        self.assertEqual(6, solution.getSumOfDigits(123))
        self.assertEqual(10, solution.getSumOfDigits(1234))
        self.assertEqual(1, solution.getSumOfDigits(10))
        self.assertEqual(1, solution.getSumOfDigits(1))
        self.assertEqual(1, solution.getSumOfDigits(100))
        self.assertEqual(6, solution.getSumOfDigits(12300))

    def test_solution(self):
        self.assertTrue(solution.checkIfEqualToPowerOfDigitSum(512))

if __name__ == '__main__':
    unittest.main()