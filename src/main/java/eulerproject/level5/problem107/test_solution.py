import unittest
import solution

class TestProblem(unittest.TestCase):

    def test(self):
        self.assertEqual(solution.solution("./test_network.txt"), 150)

if __name__ == '__main__':
    unittest.main()