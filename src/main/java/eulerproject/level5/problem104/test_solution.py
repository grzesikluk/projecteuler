import unittest

import solution


class TestProblem(unittest.TestCase):
    def test_is_pandigit(self):
        self.assertTrue(solution.isPanDigit("0123456789"))
        self.assertTrue(solution.isPanDigit("9876543210"))
        self.assertTrue(solution.isPanDigit("987654321"))
        self.assertFalse(solution.isPanDigit("987654311"))

    def test_get_firstdigits(self):
        self.assertEqual(solution.getFirstDigits(123456, 2), "56")
        self.assertEqual(solution.getFirstDigits(23456, 2), "56")
        self.assertEqual(solution.getFirstDigits(6, 2), "6")

    def test_get_lastdigits(self):
        self.assertEqual(solution.getLastDigits(123456, 2), "12")
        self.assertEqual(solution.getLastDigits(23456, 2), "23")
        self.assertEqual(solution.getLastDigits(56, 2), "56")
        self.assertEqual(solution.getLastDigits(6, 2), "6")


if __name__ == '__main__':
    unittest.main()
