import unittest

from solution import Solution


class TestProblem(unittest.TestCase):
    def setUp(self):
        self.solution = Solution(1)

    def test_product(self):
        self.assertEquals(self.solution.product([2, 3, 4]), 24)

    def test_sum(self):
        self.assertEquals(self.solution.sum([2, 3, 4]), 9)

    def test_getN(self):
        self.assertEquals(self.solution.getN([2, 3, 4]), 15)

    def test_allfactors_2_12(self):
        self.assertIn([3, 3], self.solution.getAllFactors(12))
        self.assertIn([6, 2], self.solution.getAllFactors(12))
        self.assertNotIn([2, 7], self.solution.getAllFactors(12))
        self.assertNotIn([3, 5], self.solution.getAllFactors(12))


    def test_allfactors_3_10(self):
        self.assertIn([2, 2, 2], self.solution.getAllFactors(10))
        self.assertNotIn([10, 2, 2], self.solution.getAllFactors(10))
        self.assertNotIn([3, 3, 2], self.solution.getAllFactors(10))
        self.assertNotIn([3, 2, 2], self.solution.getAllFactors(10))

    def test_allfactors_3_12(self):
        self.assertIn([2, 2, 2], self.solution.getAllFactors(12))
        self.assertIn([3, 2, 2], self.solution.getAllFactors(12))
        self.assertNotIn([3, 3, 3], self.solution.getAllFactors(12))

    def test_mps_6(self):
        s1 = Solution(6)
        self.assertEquals(s1.mps(), [0, 0, 4, 6, 8, 8, 12])

    def test_mps_12(self):
        s2 = Solution(12)
        self.assertEquals(set(s2.mps()), set([0, 4, 6, 8, 12, 15, 16]))

    def test_solution_6(self):
        s3 = Solution(6)
        self.assertEquals(s3.solve(), 30)

    def test_solution_12(self):
        s4 = Solution(12)
        self.assertEquals(s4.solve(), 61)

    # @unittest.skip("takes long time")
    def test_solution_500(self):
        s5 = Solution(500)
        self.assertEquals(s5.solve(), 29836)

    # @unittest.skip("takes long time")
    def test_solution_1500(self):
        s5 = Solution(1500)
        self.assertEquals(s5.solve(), 187741)

    @unittest.skip("for printing")
    def test_allfactors_print(self):
        k = 100
        s6 = Solution(k)

        for factor in range(2, 5):
            for i in s6.allFactors(factor, k):
                self.assertLessEqual(s6.product(i), k)
                print i



if __name__ == '__main__':
    unittest.main()
