import unittest

from solution import getU, point, interpolate, getFirstIncorrectTerm, solve, getUPoints


class TestProblem(unittest.TestCase):
    def test_un(self):
        expected = [1, 1, 683, 44287, 838861, 8138021, 51828151, 247165843, 954437177, 3138105961]
        for i in range(0, len(expected)):
            self.assertEqual(expected[i], getU(i))

    def test_interpolate_equals_for_points_less_than_polynomial_order(self):
        data = [point(x, x * x * x) for x in range(0, 10)]
        for k in range(1, 3):
            self.assertEqual(data[k].y, interpolate(data, k, 3))

    def test_interpolate_not_equals_for_points_equal_and_greater_than_polynomial_order(self):
        data = [point(x, long(x * x * x)) for x in range(0, 10)]
        for k in range(4, 6):
            self.assertNotEqual(data[k].y, interpolate(data, k, 3))

    def test_get_fit(self):
        data = [point(x, x * x * x) for x in range(0, 11)]
        expected = [1, 15, 58]

        for i in range(1, 4):
            self.assertEqual(expected[i - 1], getFirstIncorrectTerm(data, i))

    def test_solve(self):
        data = [point(x, x * x * x) for x in range(0, 100)]
        self.assertEqual(74, solve(data, 3))

    def test_solve_small(self):
        data = [point(x, x * x * x) for x in range(0, 11)]
        self.assertEqual(74L, solve(data, 3))

if __name__ == '__main__':
    unittest.main()
