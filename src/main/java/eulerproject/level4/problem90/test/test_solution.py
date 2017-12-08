import unittest

from eulerproject.level4.problem90.cube import Cube, CubesPair
from eulerproject.level4.problem90.solution import solution


class TestProblem(unittest.TestCase):

    def test_digit_map(self):
        """ This test shows what is wrong with my solution"""
        s = solution(["01", "69"])
        # assert s.digitMap == {0: 1, 1: 1, 6: 1, 9: 1}
        assert s.digitMap == {0: 1, 1: 1, 6: 2}


    def test_get_all_combinations_from_leaves(self):
        s = solution(["01", "29"])
        filtered = s.getAllCombinationsFromLeaves()
        assert not CubesPair(Cube([0, 6, 9]), Cube([1, 2])) in filtered
        assert CubesPair(Cube([0, 2]), Cube([1, 6])) in filtered
        assert CubesPair(Cube([0, 2]), Cube([1, 9])) in filtered
        assert CubesPair(Cube([0, 6]), Cube([1, 2])) in filtered
        assert CubesPair(Cube([0, 9]), Cube([1, 2])) in filtered

    def test_possible_solutions_from_small_set(self):
        s = solution(["01", "29"])
        res = s.getAllCombinations()
        assert (CubesPair(Cube([0, 1, 2, 3, 4, 5]), Cube([0, 1, 2, 3, 8, 9]))) in res

    def test_is_proper_pair(self):
        s = solution(solution.SQUARES)
        assert s.isProperPair(CubesPair(Cube([0, 1, 2, 7, 8, 9]), Cube([0, 1, 3, 4, 5, 7])))
        assert s.isProperPair(CubesPair(Cube([0, 1, 2, 7, 8, 9]), Cube([0, 1, 3, 4, 5, 8])))
        assert s.isProperPair(CubesPair(Cube([0, 1, 2, 7, 8, 9]), Cube([0, 3, 4, 5, 8, 9])))
        assert s.isProperPair(CubesPair(Cube([0, 1, 2, 7, 8, 9]), Cube([1, 3, 4, 5, 7, 9])))
        assert s.isProperPair(CubesPair(Cube([0, 1, 2, 7, 8, 9]), Cube([1, 3, 4, 5, 8, 9])))
        assert s.isProperPair(CubesPair(Cube([0, 1, 2, 6, 7, 8]), Cube([0, 1, 3, 4, 5, 7])))
        assert s.isProperPair(CubesPair(Cube([0, 1, 2, 6, 7, 8]), Cube([1, 3, 4, 5, 6, 7])))
        assert s.isProperPair(CubesPair(Cube([0, 4, 5, 6, 7, 8]), Cube([1, 2, 3, 4, 6, 7])))
        assert s.isProperPair(CubesPair(Cube([0, 4, 5, 6, 7, 8]), Cube([1, 2, 3, 4, 6, 7])))
        assert s.isProperPair(CubesPair(Cube([0, 1, 2, 3, 4, 5]), Cube([0, 1, 2, 3, 8, 9])))

    def test_possible_solutions(self):
        s = solution(solution.SQUARES)
        res = s.getAllCombinations()
        assert (CubesPair(Cube([0, 1, 2, 3, 4, 5]), Cube([0, 1, 2, 3, 8, 9]))) in res
        assert (CubesPair(Cube([0, 1, 2, 3, 4, 5]), Cube([0, 1, 2, 4, 8, 9]))) in res
        assert (CubesPair(Cube([0, 1, 2, 3, 4, 5]), Cube([0, 1, 2, 3, 8, 9]))) in res
        assert (CubesPair(Cube([0, 1, 2, 3, 4, 5]), Cube([0, 1, 2, 4, 8, 9]))) in res
        assert (CubesPair(Cube([0, 1, 2, 3, 4, 5]), Cube([0, 1, 2, 5, 8, 9]))) in res
        assert (CubesPair(Cube([0, 1, 2, 3, 4, 5]), Cube([0, 1, 2, 7, 8, 9]))) in res
        assert (CubesPair(Cube([0, 1, 2, 3, 4, 5]), Cube([0, 1, 2, 6, 8, 9]))) in res
        assert (CubesPair(Cube([0, 1, 2, 3, 4, 5]), Cube([0, 1, 3, 5, 8, 9]))) in res
        assert (CubesPair(Cube([0, 1, 2, 3, 4, 5]), Cube([0, 1, 4, 5, 8, 9]))) in res
        assert (CubesPair(Cube([0, 1, 2, 3, 4, 5]), Cube([0, 1, 5, 7, 8, 9]))) in res
        assert (CubesPair(Cube([0, 1, 2, 3, 4, 5]), Cube([0, 1, 5, 6, 8, 9]))) in res
        assert (CubesPair(Cube([0, 1, 2, 3, 4, 5]), Cube([0, 2, 3, 4, 8, 9]))) in res
        assert (CubesPair(Cube([0, 1, 2, 3, 4, 5]), Cube([0, 2, 3, 5, 8, 9]))) in res
        assert (CubesPair(Cube([0, 1, 2, 3, 4, 5]), Cube([0, 2, 3, 7, 8, 9]))) in res
        assert (CubesPair(Cube([0, 1, 2, 3, 4, 5]), Cube([0, 2, 3, 6, 8, 9]))) in res
        assert (CubesPair(Cube([0, 1, 2, 5, 6, 9]), Cube([1, 3, 4, 5, 8, 9]))) in res
        assert (CubesPair(Cube([0, 1, 2, 7, 8, 9]), Cube([0, 1, 3, 4, 5, 9]))) in res
        assert (CubesPair(Cube([0, 1, 2, 7, 8, 9]), Cube([1, 2, 3, 4, 5, 9]))) in res
        assert (CubesPair(Cube([0, 1, 2, 7, 8, 9]), Cube([1, 3, 4, 5, 6, 9]))) in res
        assert (CubesPair(Cube([0, 1, 2, 6, 7, 9]), Cube([0, 1, 3, 4, 5, 8]))) in res
        assert (CubesPair(Cube([0, 1, 2, 6, 7, 9]), Cube([0, 3, 4, 5, 8, 9]))) in res
        assert (CubesPair(Cube([0, 1, 2, 6, 7, 9]), Cube([1, 3, 4, 5, 8, 9]))) in res
        assert (CubesPair(Cube([0, 1, 2, 6, 8, 9]), Cube([0, 1, 3, 4, 5, 7]))) in res
        assert (CubesPair(Cube([0, 1, 2, 6, 8, 9]), Cube([0, 1, 3, 4, 5, 8]))) in res
        assert (CubesPair(Cube([0, 1, 2, 6, 8, 9]), Cube([0, 1, 3, 4, 5, 9]))) in res
        assert (CubesPair(Cube([0, 1, 2, 6, 8, 9]), Cube([0, 3, 4, 5, 8, 9]))) in res
        assert (CubesPair(Cube([0, 3, 5, 6, 8, 9]), Cube([1, 2, 3, 4, 7, 9]))) in res
        assert (CubesPair(Cube([0, 3, 5, 6, 8, 9]), Cube([1, 2, 3, 4, 8, 9]))) in res
        assert (CubesPair(Cube([0, 3, 5, 6, 8, 9]), Cube([1, 2, 3, 4, 6, 9]))) in res
        assert (CubesPair(Cube([0, 3, 5, 6, 8, 9]), Cube([1, 2, 4, 5, 7, 9]))) in res
        assert (CubesPair(Cube([0, 3, 5, 6, 8, 9]), Cube([1, 2, 4, 5, 8, 9]))) in res
        assert (CubesPair(Cube([0, 3, 5, 6, 8, 9]), Cube([1, 2, 4, 5, 6, 9]))) in res
        assert (CubesPair(Cube([0, 3, 5, 6, 8, 9]), Cube([1, 2, 4, 7, 8, 9]))) in res
        assert (CubesPair(Cube([0, 3, 5, 6, 8, 9]), Cube([1, 2, 4, 6, 7, 9]))) in res
        assert (CubesPair(Cube([0, 3, 5, 6, 8, 9]), Cube([1, 2, 4, 6, 8, 9]))) in res
        assert (CubesPair(Cube([0, 4, 5, 6, 7, 8]), Cube([1, 2, 3, 4, 5, 6]))) in res
        assert (CubesPair(Cube([0, 4, 5, 6, 7, 8]), Cube([1, 2, 3, 4, 6, 8]))) in res
        assert (CubesPair(Cube([0, 4, 5, 6, 7, 8]), Cube([1, 2, 3, 4, 6, 9]))) in res
        assert (CubesPair(Cube([0, 1, 2, 3, 4, 5]), Cube([0, 1, 2, 3, 6, 8]))) in res
        assert (CubesPair(Cube([0, 1, 2, 3, 4, 5]), Cube([0, 1, 2, 4, 6, 8]))) in res
        assert (CubesPair(Cube([0, 1, 2, 3, 4, 5]), Cube([0, 1, 2, 5, 6, 8]))) in res
        assert (CubesPair(Cube([0, 1, 2, 3, 4, 5]), Cube([0, 1, 2, 6, 7, 8]))) in res
        assert (CubesPair(Cube([0, 1, 2, 3, 4, 5]), Cube([0, 1, 3, 5, 6, 8]))) in res
        assert (CubesPair(Cube([0, 1, 2, 3, 4, 5]), Cube([0, 1, 4, 5, 6, 8]))) in res
        assert (CubesPair(Cube([0, 1, 2, 3, 4, 5]), Cube([0, 1, 5, 6, 7, 8]))) in res
        assert (CubesPair(Cube([0, 1, 2, 3, 4, 5]), Cube([0, 2, 3, 4, 6, 8]))) in res
        assert (CubesPair(Cube([0, 1, 2, 3, 4, 5]), Cube([0, 2, 3, 5, 6, 8]))) in res
        assert (CubesPair(Cube([0, 1, 2, 3, 4, 5]), Cube([0, 2, 3, 6, 7, 8]))) in res
        assert (CubesPair(Cube([0, 1, 2, 5, 6, 9]), Cube([1, 3, 4, 5, 6, 8]))) in res
        assert (CubesPair(Cube([0, 1, 2, 6, 7, 8]), Cube([0, 1, 3, 4, 5, 8]))) in res
        assert (CubesPair(Cube([0, 1, 2, 6, 7, 8]), Cube([0, 1, 3, 4, 5, 6]))) in res
        assert (CubesPair(Cube([0, 1, 2, 6, 7, 8]), Cube([0, 3, 4, 5, 6, 8]))) in res
        assert (CubesPair(Cube([0, 1, 2, 6, 7, 8]), Cube([1, 2, 3, 4, 5, 6]))) in res
        assert (CubesPair(Cube([0, 1, 2, 6, 7, 8]), Cube([1, 3, 4, 5, 6, 8]))) in res
        assert (CubesPair(Cube([0, 1, 2, 6, 7, 8]), Cube([1, 3, 4, 5, 6, 9]))) in res
        assert (CubesPair(Cube([0, 1, 2, 6, 7, 9]), Cube([0, 3, 4, 5, 6, 8]))) in res
        assert (CubesPair(Cube([0, 1, 2, 6, 7, 9]), Cube([1, 3, 4, 5, 6, 8]))) in res
        assert (CubesPair(Cube([0, 1, 2, 6, 8, 9]), Cube([0, 1, 3, 4, 5, 6]))) in res
        assert (CubesPair(Cube([0, 1, 2, 6, 8, 9]), Cube([0, 3, 4, 5, 6, 8]))) in res
        assert (CubesPair(Cube([0, 3, 5, 6, 8, 9]), Cube([1, 2, 3, 4, 6, 7]))) in res
        assert (CubesPair(Cube([0, 3, 5, 6, 8, 9]), Cube([1, 2, 3, 4, 6, 8]))) in res
        assert (CubesPair(Cube([0, 3, 5, 6, 8, 9]), Cube([1, 2, 3, 4, 6, 9]))) in res
        assert (CubesPair(Cube([0, 3, 5, 6, 8, 9]), Cube([1, 2, 4, 5, 6, 7]))) in res
        assert (CubesPair(Cube([0, 3, 5, 6, 8, 9]), Cube([1, 2, 4, 5, 6, 8]))) in res
        assert (CubesPair(Cube([0, 3, 5, 6, 8, 9]), Cube([1, 2, 4, 5, 6, 9]))) in res
        assert (CubesPair(Cube([0, 3, 5, 6, 8, 9]), Cube([1, 2, 4, 6, 7, 8]))) in res
        assert (CubesPair(Cube([0, 3, 5, 6, 8, 9]), Cube([1, 2, 4, 6, 7, 9]))) in res
        assert (CubesPair(Cube([0, 3, 5, 6, 8, 9]), Cube([1, 2, 4, 6, 8, 9]))) in res
        assert (CubesPair(Cube([0, 4, 5, 6, 7, 8]), Cube([1, 2, 3, 4, 5, 6]))) in res
        assert (CubesPair(Cube([0, 4, 5, 6, 7, 8]), Cube([1, 2, 3, 4, 6, 8]))) in res
        assert (CubesPair(Cube([0, 4, 5, 6, 7, 8]), Cube([1, 2, 3, 4, 6, 9]))) in res
        assert (CubesPair(Cube([0, 4, 5, 6, 8, 9]), Cube([1, 2, 3, 4, 5, 6]))) in res
        assert (CubesPair(Cube([0, 4, 5, 6, 8, 9]), Cube([1, 2, 3, 4, 6, 7]))) in res
        assert (CubesPair(Cube([0, 4, 5, 6, 8, 9]), Cube([1, 2, 3, 4, 6, 8]))) in res
        assert (CubesPair(Cube([0, 4, 5, 6, 8, 9]), Cube([1, 2, 3, 4, 6, 9]))) in res
        assert (CubesPair(Cube([0, 5, 6, 7, 8, 9]), Cube([1, 2, 3, 4, 5, 9]))) in res
        assert (CubesPair(Cube([0, 5, 6, 7, 8, 9]), Cube([1, 2, 3, 4, 6, 7]))) in res
        assert (CubesPair(Cube([0, 5, 6, 7, 8, 9]), Cube([1, 2, 3, 4, 6, 8]))) in res
        assert (CubesPair(Cube([0, 5, 6, 7, 8, 9]), Cube([1, 2, 3, 4, 6, 9]))) in res

    def test_possible_solutions_excluded(self):
        s = solution(solution.SQUARES)
        res = s.getAllCombinations()
        assert not (CubesPair(Cube([1, 2, 4, 8, 9, 9]), Cube([0, 1, 3, 5, 6, 9]))) in res

    def test_solution_missing(self):
        s = solution(solution.SQUARES)
        res = s.getAllCombinations()
        assert (CubesPair(Cube([0, 1, 2, 7, 8, 9]), Cube([0, 1, 3, 4, 5, 8]))) in res
        assert (CubesPair(Cube([0, 1, 2, 7, 8, 9]), Cube([0, 3, 4, 5, 8, 9]))) in res
        assert (CubesPair(Cube([0, 1, 2, 7, 8, 9]), Cube([1, 3, 4, 5, 7, 9]))) in res
        assert (CubesPair(Cube([0, 1, 2, 7, 8, 9]), Cube([1, 3, 4, 5, 8, 9]))) in res
        assert (CubesPair(Cube([0, 1, 2, 6, 7, 8]), Cube([0, 1, 3, 4, 5, 7]))) in res
        assert (CubesPair(Cube([0, 1, 2, 6, 7, 8]), Cube([1, 3, 4, 5, 6, 7]))) in res
        assert (CubesPair(Cube([0, 4, 5, 6, 7, 8]), Cube([1, 2, 3, 4, 6, 7]))) in res
        assert (CubesPair(Cube([0, 4, 5, 6, 7, 8]), Cube([1, 2, 3, 4, 6, 7]))) in res

    def test_get_all_combinations_from_leaves_exclude(self):
        s = solution(["06", "29"])
        filtered = s.getAllCombinationsFromLeaves()
        assert not CubesPair(Cube([9, 9]), Cube([0, 2])) in filtered


if __name__ == '__main__':
    unittest.main()
