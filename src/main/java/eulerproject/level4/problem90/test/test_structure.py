import unittest
from eulerproject.level4.problem90.structure import tree
from eulerproject.level4.problem90.cube import Cube, CubesPair

class TestProblem(unittest.TestCase):

    def test_tree_adding(self):
        root = tree("1")
        root.addBranch("2")
        root.addBranch("3")
        root.addBranch("4")
        root.addBranch("7")

        assert root.getBranch(0).data == "2"
        assert root.getBranch(1).data == "3"
        assert root.getBranch(2).data == "4"
        assert root.getBranch(3).data == "7"

        assert len(root) == 4

        branch = root.getBranch(0)
        branch.addBranch("5")
        branch.addBranch("3")
        branch.addBranch("3")
        assert len(branch) == 3

        assert root.getBranch(0).getBranch(0).data == "5"
        assert root.search("3") == [root.getBranch(0).getBranch(1), root.getBranch(0).getBranch(2), root.getBranch(1)]

        assert root.leaves() == [root.getBranch(0).getBranch(0),
                         root.getBranch(0).getBranch(1),
                         root.getBranch(0).getBranch(2),
                         root.getBranch(1),
                         root.getBranch(2),
                         root.getBranch(3)]

    def test_tree_equals(self):
        assert tree("2") == tree("2")
        assert not tree("3") == tree("2")

    def test_tree_set_len(self):
        assert len(set([tree("2"), tree("3")])) == 2
        assert len(set([tree("2"), tree("2")])) == 1

    def test_tree_set_cubes_pair(self):
        c1 = Cube([0, 4])
        c2 = Cube([0, 4])
        c3 = Cube([])
        c4 = Cube([0, 1, 4])

        t1 = tree(CubesPair(c3, c4))
        t2 = tree(CubesPair(c1, c2))
        t3 = tree(CubesPair(c1, c2))
        t4 = tree(CubesPair(c2, c1))

        a1 = []
        a1.append(t1)
        a1.append(t2)

        a2 = []
        a2.append(t3)
        a2.append(t4)

        assert len(set(a1)) == 2
        assert len(set(a2)) == 1

        t5 = tree(CubesPair(Cube([0, 1, 4]), Cube([0])))
        t6 = tree(CubesPair(Cube([0]), Cube([0, 1, 4])))

        assert len(set([t5, t6])) == 1


    def test_contains(self):
        root = tree("1")
        assert root.leaves()[0] == tree("1")
        assert tree("1") in root.leaves()


if __name__ == '__main__':
    unittest.main()