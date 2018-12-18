import copy

from eulerproject.level4.problem90.cube import Cube, CubesPair
from eulerproject.level4.problem90.structure import tree


class solution(object):
    DIGITS = ["0", "1", "2", "3", "4", "5", "6", "7", "8", "9"]
    DIGITS_69 = ["6", "9"]
    DIGITS_69_INT = [6, 9]
    SQUARES = ("01", "04", "09", "16", "25", "36", "49", "64", "81")

    def __init__(self, squares=[]):
        self.squares = squares
        self.digitMap = self.getDigitMap()

    def getAllCombinationsFromLeaves(self):
        t = self.createNewTree()
        leaves = t.leaves()
        result = []

        for i in set(leaves):
            if self.isProperPair(i.data):
                for j in i.data.allSixNineVariants():
                    if self.isProperPair(j):
                        result.append(j)
        return result

    def getAllCombinations(self):
        result = list(self.createAllSolutions(self.getAllCombinationsFromLeaves()))
        self.storeToFile("all_solutions.txt", result)
        # result = self.filterProperPairs(result)
        # self.storeToFile("all_proper_pairs.txt", result)
        return result

    def solve(self):
        return len(self.getAllCombinations())

    def createNewTree(self):
        t = tree(CubesPair(Cube([]), Cube([])))

        for digit in self.digitMap.keys():
            self.addNewDigit(t, digit)

        return t

    def storeToFile(self, filename="result.txt", data=[]):
        with open(filename, 'w') as f:
            for d in data:
                f.write("{}\n".format(str(d)))
            f.close()

    def createAllSolutions(self, cubesPairs=[]):
        result = set()

        for i in cubesPairs:
            for j in i.allVariants():
                result.add(j)

        return result

    def removeContained(self, cubesPairs=[]):
        result = []

        for cp in cubesPairs:
            if not self._isContainedInList(cp, cubesPairs):
                result.append(cp)

        return result

    def _isContainedInList(self, cp, list=[]):
        for element in list:
            if cp != element:
                if cp in element:
                    return True
        return False

    def isProperPair(self, pair):

        if pair.getCubes()[0] and pair.getCubes()[1]:

            for cube in pair.getCubes():
                if cube.hasDupes():
                    return False

            for square in self.squares:
                if self.isNumberInCube(square[0], pair.getCubes()[0]) and self.isNumberInCube(square[1],
                                                                                              pair.getCubes()[1]):
                    pass
                elif self.isNumberInCube(square[1], pair.getCubes()[0]) and self.isNumberInCube(square[0],
                                                                                                pair.getCubes()[1]):
                    pass
                else:
                    return False
            return True
        else:
            return False

    def filterProperPairs(self, input):
        output = []

        for i in input:
            if self.isProperPair(i):
                output.append(i)
        return output

    def isNumberInCube(self, digit, cube):
        # all but 6,9
        if digit in set(self.DIGITS).difference(set(self.DIGITS_69)):
            return int(digit) in cube.sides
        else:
            return Cube([6]) in cube or Cube([9]) in cube

    def addNewDigit(self, tree, digit):
        digit_cubes_number = self.digitMap[digit]

        for leaf in tree.leaves():

            if len(leaf.data.getCubes()[0]) < 6 and len(leaf.data.getCubes()[1]) < 6:

                if digit_cubes_number == 1:

                    onepair = copy.deepcopy(leaf.data)
                    secondpair = copy.deepcopy(leaf.data)

                    onepair.getCubes()[0].addSide(digit)
                    secondpair.getCubes()[1].addSide(digit)

                    leaf.addBranch(onepair)
                    leaf.addBranch(secondpair)

                elif digit_cubes_number == 2:

                    onepair = copy.deepcopy(leaf.data)
                    secondpair = copy.deepcopy(leaf.data)
                    thirdpair = copy.deepcopy(leaf.data)

                    onepair.getCubes()[0].addSide(digit)
                    secondpair.getCubes()[1].addSide(digit)
                    thirdpair.getCubes()[0].addSide(digit)
                    thirdpair.getCubes()[1].addSide(digit)

                    leaf.addBranch(onepair)
                    leaf.addBranch(secondpair)
                    leaf.addBranch(thirdpair)

                else:
                    pass

    def countSolutions(self, pair):
        result = 1

        firstCube = pair.getCubes()[0]
        secondCube = pair.getCubes()[1]

        result *= firstCube.__sizeof__()
        result *= secondCube.__sizeof__()

        return result

    def __countRemainigVariants(self, cubeLen):
        result = 1
        for i in range(10 - cubeLen, 10 - 6, -1):
            result *= (i - 2)
        return result

    def getDigitMap(self):
        result = {}

        for square in self.squares:
            digit1 = int(square[0])
            digit2 = int(square[1])

            self._addDigitToMap(result, digit1)
            self._addDigitToMap(result, digit2)

        return result

    def _addDigitToMap(self, map, d):

        if d in self.DIGITS_69_INT:
            self.__addToDigitMap(map, 6)
            # self.__addToDigitMap(map, 9)
        else:
            self.__addToDigitMap(map, d)

    def __addToDigitMap(self, map, d):
        if d in map:
            if map[d] < 2:
                map[d] = map[d] + 1;
        else:
            map[d] = 1


if __name__ == "__main__":
    s = solution(solution.SQUARES)
    print (s.solve())
