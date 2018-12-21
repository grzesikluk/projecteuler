import unittest
import solution

class TestProblem(unittest.TestCase):
    def test_is_bouncy(self):
        self.assertFalse(solution.isBouncyNumber(123))
        self.assertFalse(solution.isBouncyNumber(321))
        self.assertFalse(solution.isBouncyNumber(333))
        self.assertFalse(solution.isBouncyNumber(11113))
        self.assertTrue(solution.isBouncyNumber(111132))
        self.assertTrue(solution.isBouncyNumber(312))
        self.assertTrue(solution.isBouncyNumber(132))
        self.assertTrue(solution.isBouncyNumber(11113222224))
        self.assertTrue(solution.isBouncyNumber(4132))
        self.assertTrue(solution.isBouncyNumber(412))
        self.assertFalse(solution.isBouncyNumber(41))


if __name__ == '__main__':
    unittest.main()