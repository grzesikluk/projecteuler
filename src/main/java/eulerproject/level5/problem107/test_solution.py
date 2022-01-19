import unittest

import solution


class TestProblem(unittest.TestCase):

    def testRead(self):
        graphArray = solution.readFile("test_network.txt")
        self.assertEqual(-1, graphArray[0][0])
        self.assertEqual(16, graphArray[0][1])
        self.assertEqual(12, graphArray[0][2])
        self.assertEqual(17, graphArray[1][3])
        self.assertEqual(-1, graphArray[6][6])

    def testWeight(self):
        graphArray = solution.readFile("test_network.txt")
        self.assertEqual(243, solution.countWeight(graphArray))

    def testBidirectionaWeighted(self):
        graphArray = solution.readFile("test_network.txt")
        self.assertTrue(solution.isBidirectionalWeighted(graphArray))

    def testNotBidirectionalWeighted(self):
        graphArray = solution.readFile("test_network_not_weighted.txt")
        self.assertFalse(solution.isBidirectionalWeighted(graphArray))

    @unittest.skip
    def test(self):
        self.assertEqual(solution.solution("./test_network.txt"), 150)

if __name__ == '__main__':
    unittest.main()