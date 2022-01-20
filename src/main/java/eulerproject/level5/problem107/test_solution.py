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
        self.assertIsNone(edgesStructure.get((0, 0)))
        self.assertIsNone(edgesStructure.get((0, 4)))
        self.assertIsNone(edgesStructure.get((5, 5)))
        self.assertEqual(11, edgesStructure.get((4, 6)))
        self.assertEqual(23, edgesStructure.get((3, 6)))

    def testSortedEdges(self):
        graphArray = solution.readFile("test_network.txt")
        edgesStructure = solution.createEdges(graphArray)
        sorted = solution.sortEdgesByWeight(edgesStructure)
        self.assertEqual(11, sorted[0][1])
        self.assertEqual(12, sorted[1][1])
        self.assertEqual(16, sorted[2][1])

    def test(self):
        self.assertEqual(solution.solution("./test_network.txt"), 150)

    def testHasCycles(self):
        graphArray = solution.readFile("test_network_cycled.txt")
        self.assertTrue(solution.hasCycles(graphArray))

    def testDoesntHaveCycles(self):
        graphArray = solution.readFile("test_network_non_cycled.txt")
        self.assertFalse(solution.hasCycles(graphArray))

    def testAddEdge(self):
        graphArray = solution.readFile("test_network.txt")
        edgesStructure = solution.createEdges(graphArray)
        sortedEdges = solution.sortEdgesByWeight(edgesStructure)
        forestArray = [[-1]*len(graphArray)]*len(graphArray)

        solution.addEdge(sortedEdges[0], forestArray)
        solution.addEdge(sortedEdges[1], forestArray)
        solution.addEdge(sortedEdges[2], forestArray)

        self.assertEqual(11, forestArray[4][6])
        self.assertEqual(12, forestArray[0][2])
        self.assertEqual(16, forestArray[0][1])

if __name__ == '__main__':
    unittest.main()
