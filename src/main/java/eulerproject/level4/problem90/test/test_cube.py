import unittest

from eulerproject.level4.problem90.cube import Cube


class TestProblem(unittest.TestCase):

    def test_contains(self):
        assert 3 in Cube([1, 2, 3, 4, 5, 6]).sides
        assert not 7 in Cube([1, 2, 3, 4, 5, 6]).sides
        assert len(Cube([1, 2, 3, 4, 5, 6])) == 6

    def test_cube_equals(self):
        assert Cube([1, 2, 3, 4, 5, 6]) == Cube([1, 2, 3, 4, 5, 6])
        assert Cube([6, 2, 3, 4, 5, 1]) == Cube([1, 2, 3, 4, 5, 6])

        assert not Cube([1, 2, 3, 4, 5, 6]) == Cube([1, 2, 3, 4, 5, 9])
        assert not Cube([1, 2, 3, 4, 5]) == Cube([1, 2, 3, 4, 5, 6])
        assert not Cube([1, 2, 3, 4, 5, 6]) == Cube([1, 2, 3, 4, 5, 9])
        assert not Cube([1, 2, 3, 4, 5, 0]) == Cube([1, 2, 3, 4, 5, 9])

    def test_cube_has_empty_side(self):
        assert not Cube([1, 2, 3, 4, 5, 0]).hasEmptySide()
        assert Cube([1, 2, 3, 4, 5]).hasEmptySide()
        assert Cube([1, 2, None, 4, 5, 9]).hasEmptySide()

    def test_cube_less_or_bigger(self):
        assert Cube([1, 2, 3, 4, 5]) < Cube([1, 2, 3, 4, 5, 9])
        assert Cube([1, 2, 3, 4, 5, 0]) < Cube([1, 2, 3, 4, 5, 9])
        assert Cube([1, 2, 3, 4, 5, 0]) > Cube([1, 2, 3, 4, 5])
        assert Cube([]) < Cube([1, 2, 3, 4, 5, 9])

        assert not Cube([]) < Cube([])
        assert not Cube([]) > Cube([])
        assert not Cube([1, 2, 3, 4, 5, 7]) > Cube([1, 2, 3, 4, 5, 7])
        assert not Cube([1, 2, 3, 4, 5, 7]) < Cube([1, 2, 3, 4, 5, 7])

    def test_cube_len(self):
        assert len(Cube([3, 4, 5])) == 3
        assert len(Cube([3, 4, 5, None])) == 3

    def test_cube_sizeof(self):
        assert Cube([]).__sizeof__() == 151200
        assert Cube([1]).__sizeof__() == 15120
        assert Cube([1, 2]).__sizeof__() == 1680
        assert Cube([1, 2, 3]).__sizeof__() == 210
        assert Cube([1, 2, 3, 4]).__sizeof__() == 30
        assert Cube([1, 2, 3, 4, 5]).__sizeof__() == 5

    def test_cube_in(self):
        assert Cube([1, 2]) in Cube([1, 2, 3, 4])
        assert not Cube([3, 4]) in Cube([1, 2])
        assert not Cube([1, 4]) in Cube([1, 2])
        assert Cube([]) in Cube([1, 2])
        assert not Cube([1,2]) in Cube([])
        assert Cube([]) in Cube([1,2])

    def test_cube_allvariants(self):
        assert Cube([1, 2, 3, 4, 5, 6]) in Cube([1, 2, 3, 4, 5]).allVariants()
        assert Cube([1, 2, 3, 4, 5, 7]) in Cube([1, 2, 3, 4, 5]).allVariants()
        assert Cube([1, 2, 3, 4, 5, 8]) in Cube([1, 2, 3, 4, 5]).allVariants()
        assert Cube([1, 2, 3, 4, 5, 9]) in Cube([1, 2, 3, 4, 5]).allVariants()
        assert Cube([0, 2, 3, 4, 5, 9]) in Cube([]).allVariants()

        assert Cube([0, 1, 3, 4, 5, 7]) in Cube([0, 1, 3, 4, 5]).allVariants()

    def test_all_sixninevariants_1(self):
        variants = Cube([1, 6]).allSixNineVariants()
        assert Cube([1, 6]) in variants
        assert Cube([1, 9]) in variants

    def test_all_sixninevariants_2(self):
        variants = Cube([2, 9]).allSixNineVariants()
        assert Cube([2, 6]) in variants
        assert Cube([2, 9]) in variants

    def test_all_sixninevariants_2(self):
        variants = Cube([6, 9]).allSixNineVariants()
        assert Cube([6, 9]) in variants

    def test_has_dupes(self):
        assert Cube([1, 1]).hasDupes()
        assert Cube([9, 9]).hasDupes()


if __name__ == '__main__':
    unittest.main()
