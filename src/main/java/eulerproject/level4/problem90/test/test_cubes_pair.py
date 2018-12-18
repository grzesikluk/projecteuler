import unittest
from eulerproject.level4.problem90.cube import CubesPair, Cube


class TestProblem(unittest.TestCase):

    def test_cubes_pair_in(self):
        assert CubesPair(Cube([1,2,3]), Cube([1,2])) in CubesPair(Cube([1,2]), Cube([1,2]))
        assert not CubesPair(Cube([4,5]), Cube([1,2])) in CubesPair(Cube([1,2]), Cube([1,2]))
        assert CubesPair(Cube([0,1,4]),Cube([0])) in CubesPair(Cube([1,4]),Cube([0]))


    def test_cubes_pair_equals(self):
        assert CubesPair(Cube([1, 2, 3, 4, 5, 7]) , Cube([1, 2, 3, 4, 5, 6]) ) == CubesPair(Cube([1, 2, 3, 4, 5, 7]) , Cube([1, 2, 3, 4, 5, 6]) )
        assert CubesPair(Cube([1, 2, 3, 4, 5, 7]) , Cube([1, 2, 3, 4, 5, 6]) ) == CubesPair(Cube([1, 2, 3, 4, 5, 6]) , Cube([1, 2, 3, 4, 5, 7]) )
        assert CubesPair(Cube([1, 2, 3, 4, 5, 6]) , Cube([1, 2, 3, 4, 5, 7]) ) == CubesPair(Cube([1, 2, 3, 4, 5, 7]) , Cube([1, 2, 3, 4, 5, 6]) )
        assert not CubesPair(Cube([1, 2, 3, 4, 5, 7]) , Cube([1, 2, 3, 4, 5, 6]) ) == CubesPair(Cube([1, 2, 3, 4, 5, 6]) , Cube([1, 2, 3, 4, 5, 8]) )
        assert CubesPair(Cube([1, 3, 4, 5, 6, 8]), Cube([1, 2, 3, 4, 5, 6])) == CubesPair(Cube([1, 2, 3, 4, 5, 6]), Cube([1, 3, 4, 5, 6, 8]))
        assert not CubesPair(Cube([1, 2, 3, 4, 5, 6]), Cube([1, 2, 3, 4, 5, 6])) == CubesPair(Cube([1, 3, 4, 5, 6, 8]), Cube([1, 2, 3, 4, 5, 6]))
        assert not CubesPair(Cube([1, 3, 4, 5, 6, 8]), Cube([1, 2, 3, 4, 5, 6])) == CubesPair(Cube([1, 2, 3, 4, 5, 6]), Cube([1, 2, 3, 4, 5, 6]))
        assert CubesPair(Cube([1, 2, 3, 4, 5, 6]), Cube([1, 2, 3, 4, 5, 6])).getCubes()[0] == Cube([1, 2, 3, 4, 5, 6])


    def test_cubes_pair_bigger(self):
        assert CubesPair(Cube([1, 2, 3, 4, 5, 7]) , Cube([1, 2, 3, 4, 5, 6]) ) > CubesPair(Cube([1, 2, 3, 4, 5, 6]) , Cube([1, 2, 3, 4, 5, 8]) )
        assert CubesPair(Cube([1, 2, 3, 4, 5, 6]), Cube([1, 3, 4, 5, 6, 8])) > CubesPair(Cube([1, 2, 3, 4, 5, 6]) , Cube([1, 2, 3, 4, 5, 8]) )

    def test_cubes_pair_length(self):
        assert len(set([Cube([1, 2, 3, 4, 5, 6]), Cube([1, 3, 4, 5, 6, 2])])) == 1


    def test_cubes_unique_in_set(self):
        assert len(set([CubesPair(Cube([1, 2, 3, 4, 5, 6]), Cube([1, 2, 3, 4, 5, 6])), CubesPair(Cube([1, 2, 3, 4, 5, 6]), Cube([1, 2, 3, 4, 5, 6]))])) == 1
        assert len(set([CubesPair(Cube([1, 2, 3, 4, 5, 6]), Cube([1, 2, 3, 4, 5, 6])), CubesPair(Cube([1, 2, 7, 4, 5, 6]), Cube([1, 2, 3, 4, 5, 6]))])) == 2
        assert len(set([CubesPair(Cube([]), Cube([1, 3, 4, 5, 6, 8])),  CubesPair(Cube([1, 3, 4, 5, 6, 8]), Cube([]))])) == 1

    def test_cubes_pair_all_variants(self):
        assert CubesPair(Cube([1, 2, 3, 4, 5, 6]), Cube([1, 2, 3, 4, 5, 6])) in CubesPair(Cube([1, 2, 3, 4, 5]), Cube([1, 2, 3, 4, 5, 6])).allVariants()
        assert CubesPair(Cube([1, 2, 3, 4, 5, 7]), Cube([1, 2, 3, 4, 5, 6])) in CubesPair(Cube([1, 2, 3, 4, 5]), Cube([1, 2, 3, 4, 5, 6])).allVariants()
        assert CubesPair(Cube([1, 2, 3, 4, 5, 8]), Cube([1, 2, 3, 4, 5, 6])) in CubesPair(Cube([1, 2, 3, 4, 5]), Cube([1, 2, 3, 4, 5, 6])).allVariants()
        assert CubesPair(Cube([1, 2, 3, 4, 5, 9]), Cube([1, 2, 3, 4, 5, 6])) in CubesPair(Cube([1, 2, 3, 4, 5]), Cube([1, 2, 3, 4, 5, 6])).allVariants()
        assert CubesPair(Cube([1, 2, 3, 4, 5, 9]), Cube([1, 2, 3, 4, 5, 6])) in CubesPair(Cube([1, 2, 3, 4]), Cube([1, 2, 3, 4])).allVariants()
        assert CubesPair(Cube([1, 2, 3, 4, 5, 9]), Cube([1, 2, 3, 4, 5, 6])) in CubesPair(Cube([1]), Cube([1, 2, 3, 4])).allVariants()
        assert CubesPair(Cube([1, 2, 3, 4, 5, 9]), Cube([1, 2, 3, 4, 5, 6])) in CubesPair(Cube([]), Cube([])).allVariants()

    def test_all_sixnine_variants(self):

        assert CubesPair(Cube([1, 6]), Cube([1, 6])) in CubesPair(Cube([1, 6]), Cube([1, 6])).allSixNineVariants()
        assert CubesPair(Cube([1, 9]), Cube([1, 6])) in CubesPair(Cube([1, 6]), Cube([1, 6])).allSixNineVariants()
        assert CubesPair(Cube([1, 9]), Cube([1, 9])) in CubesPair(Cube([1, 6]), Cube([1, 6])).allSixNineVariants()
        assert CubesPair(Cube([1, 6]), Cube([1, 9])) in CubesPair(Cube([1, 6]), Cube([1, 6])).allSixNineVariants()

    def test_cubes_pair_str(self):
        assert str(CubesPair(Cube([1, 2, 3, 8, 5, 6]), Cube([1, 2, 3, 6, 5, 4]))) == "{[1, 2, 3, 5, 6, 8], [1, 2, 3, 4, 5, 6]}"


if __name__ == '__main__':
    unittest.main()