import unittest

import solution


class TestProblem(unittest.TestCase):
    def test_primeFactors(self):
        self.assertEqual([2, 3], solution.primeFactors(6))
        self.assertEqual([5], solution.primeFactors(5))
        self.assertEqual([3, 3], solution.primeFactors(9))
        self.assertEqual([2, 2, 5], solution.primeFactors(20))

    def test_rad(self):
        self.assertEqual(6, solution.rad(6))
        self.assertEqual(42, solution.rad(504))

    def test_solve(self):
        self.assertEqual(8, solution.solve(4, 10))
        self.assertEqual(9, solution.solve(6, 10))

if __name__ == '__main__':
    unittest.main()
