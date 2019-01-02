import unittest

import solution


class TestProblem(unittest.TestCase):
    def test_function(self):
        self.assertEqual(42, solution.function(7, 3))

    def test_solution(self):
        self.assertNotEqual(332583006, solution.getMaxSum())

    def test_get_max(self):
        self.assertEqual(42, solution.getMaxFunction(7))


if __name__ == '__main__':
    unittest.main()
