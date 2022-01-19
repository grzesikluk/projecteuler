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

    def testCreateEdges(self):
        graphArray = solution.readFile("test_network.txt")
        edgesStructure = solution.createEdges(graphArray)
        print(edgesStructure)
        self.assertIsNone(edgesStructure.get((0,0)))
        self.assertIsNone(edgesStructure.get((0,4)))
        self.assertIsNone(edgesStructure.get((5,5)))
        self.assertEqual(11, edgesStructure.get((4,6)))
        self.assertEqual(23, edgesStructure.get((3,6)))

    def testSortedEdges(self):
        graphArray = solution.readFile("test_network.txt")
        edgesStructure = solution.createEdges(graphArray)
        sorted = solution.sortEdgesByWeight(edgesStructure)
        self.assertEqual(11, sorted[0][1])
        self.assertEqual(12, sorted[1][1])
        self.assertEqual(16, sorted[2][1])

    @unittest.skip
    def test(self):
        self.assertEqual(solution.solution("./test_network.txt"), 150)

if __name__ == '__main__':
    unittest.main()