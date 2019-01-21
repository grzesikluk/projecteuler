import unittest

import solution


class TestProblem(unittest.TestCase):
    def testGetInitialChunks(self):
        self.assertEqual([[1, 1, 0, 0, 0], [0, 1, 1, 0, 0], [0, 0, 1, 1, 0], [0, 0, 0, 1, 1]],
                         solution.getInitialChunks([0, 0, 0, 0, 0], 2, 1))

        self.assertEqual([[1, 1, 1, 0, 0], [0, 1, 1, 1, 0], [0, 0, 1, 1, 1]],
                         solution.getInitialChunks([0, 0, 0, 0, 0], 3, 1))

        self.assertEqual([[1, 1, 1, 1, 1]],
                         solution.getInitialChunks([0, 0, 0, 0, 0], 5, 1))

        self.assertEqual([],
                         solution.getInitialChunks([0, 0, 0, 0, 0], 6, 1))

        if __name__ == '__main__':
            unittest.main()

    def testGetFragmentedIndexes(self):
        self.assertEqual([(2, 3), (3, 4)], solution.getArrayIndexesToFragment([0, 1, 0, 0, 0], 2))
        self.assertEqual([(0, 1), (3, 4)], solution.getArrayIndexesToFragment([0, 0, 1, 0, 0], 2))
        self.assertEqual([(0, 1), (3, 4)], solution.getArrayIndexesToFragment([0, 0, 0, 0, 0], 2))

    def testCreateNewArraysGeneration(self):
        self.assertEqual([[1, 1, 0, 0, 0], [0, 1, 1, 0, 0], [0, 0, 1, 1, 0], [0, 0, 0, 1, 1]],
                         solution.createNewArraysGeneration([0, 0, 0, 0, 0], 2))
        self.assertEqual([[1, 1, 2, 2, 0], [1, 1, 0, 2, 2]], solution.createNewArraysGeneration([1, 1, 0, 0, 0], 2))
        self.assertEqual([], solution.createNewArraysGeneration([1, 1, 0, 2, 2], 2))
        self.assertEqual([[1, 1, 3, 3, 2, 2]], solution.createNewArraysGeneration([1, 1, 0, 0, 2, 2], 2))

    def testReduceGenerationsInArray(self):
        print(solution.reduceGenerationsInArray([1, 2, 9, 0, 0, 3]))

    def testSolution(self):
        self.assertEqual(7, len(solution.solution(5, 2)))
        self.assertEqual(3, len(solution.solution(5, 3)))
        self.assertEqual(2, len(solution.solution(5, 4)))


    def testSolution2(self):
        solution.solution(6,2)