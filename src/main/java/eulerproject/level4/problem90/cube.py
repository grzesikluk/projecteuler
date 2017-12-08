import copy
import itertools

DIGITS = set([0, 1, 2, 3, 4, 5, 6, 7, 8, 9])
DIGITS_69 = set([6, 9])


class Cube(object):
    def __init__(self, numbers=[]):
        self.sides = copy.deepcopy(numbers)

    def __eq__(self, other):
        if isinstance(other, Cube):
            s1 = sorted(self.sides)
            s2 = sorted(other.sides)

            if len(s1) == len(s2):

                for i in range(0, len(s1)):
                    if s1[i] == s2[i]:
                        pass
                    else:
                        return False

                return True
            else:
                return False
        else:
            return False

    def __lt__(self, other):
        """Cube A with ordered numbers is less from B if:
         - has less digits on sides
         - comparing sorted sides ai from lower to uper side ai is lower
        """
        s1 = sorted(self.sides)
        s2 = sorted(other.sides)

        if len(s1) == len(s2):
            for i in range(0, len(s1)):
                if s1[i] == s2[i]:
                    pass
                elif s1[i] < s2[i]:
                    return True
                else:
                    return False
        elif len(s1) < len(s2):
            return True
        else:
            return False
        return False

    def __gt__(self, other):
        return not (self.__lt__(other) or self.__eq__(other))

    def addSide(self, val=0):
        assert (len(self.sides) < 6)
        self.sides.append(val)

    def clear(self):
        self.sides = []

    def hasEmptySide(self, expected=6):

        if len(self.sides) != expected:
            return True

        for i in self.sides:
            if (i == None):
                return True
        return False

    def hasDupes(self):
        return len(self.sides) != len(set(self.sides))

    def allVariants(self):
        k = 6 - len(self.sides)
        remainingDigits = DIGITS.difference(set(self.sides))
        remainingCombinations = list(itertools.combinations(remainingDigits, k))

        result = []
        for var in remainingCombinations:
            value = copy.deepcopy(self.sides)
            value.extend(var)
            result.append(Cube(value))

        return result

    def allSixNineVariants(self):
        result = []

        if 6 in self.sides and 9 in self.sides:
            result.append(self)
        if 6 in self.sides:
            result.append(self)
            result.append(Cube([9 if x == 6 else x for x in self.sides]))
        elif 9 in self.sides:
            result.append(self)
            result.append(Cube([6 if x == 9 else x for x in self.sides]))
        else:
            result.append(self)
        return result

    def __str__(self):
        return sorted(self.sides).__str__()

    def __len__(self):
        return len([x for x in self.sides if x is not None])

    def __repr__(self):
        return "Item(%s)" % (sorted(self.sides))

    def __hash__(self):
        return hash(self.__repr__())

    def __contains__(self, item):
        # todo: update this since containment means a lot more than below, cubes with undefined digits might contain a lot the other
        return set(item.sides).issubset(self.sides)

    def __sizeof__(self):
        result = 1
        for i in range(10 - len(self), 10 - 6, -1):
            result *= i
        return result


class CubesPair(object):
    def __init__(self, c1=None, c2=None):
        self.cubes = [c1, c2]

    def __lt__(self, other):
        if self.cubes[0] < other.cubes[0]:
            return True
        elif self.cubes[0] == other.cubes[0]:
            if self.cubes[1] < other.cubes[1]:
                return True
            else:
                return False
        else:
            return False

        return (self.cubes[0] == other.cubes[0]) and (self.cubes[1] == other.cubes[1])

    def __eq__(self, other):
        if isinstance(other, CubesPair):
            return (self.cubes[0] == other.cubes[0]) and (self.cubes[1] == other.cubes[1]) or \
                   (self.cubes[1] == other.cubes[0]) and (self.cubes[0] == other.cubes[1])
        else:
            return False

    def __ne__(self, other):
        return not self.__eq__(other)

    def __gt__(self, other):
        return not (self.__lt__(other) or self.__eq__(other))

    def getCubes(self):
        return self.cubes

    def __str__(self):
        if (self.cubes[0] > self.cubes[1]):
            return "{" + self.cubes[0].__str__() + ", " + self.cubes[1].__str__() + "}"
        else:
            return "{" + self.cubes[1].__str__() + ", " + self.cubes[0].__str__() + "}"

    def __repr__(self):
        if (self.cubes[0] > self.cubes[1]):
            return "Item(%s %s)" % (self.cubes[0], self.cubes[1])
        else:
            return "Item(%s %s)" % (self.cubes[1], self.cubes[0])

    def __hash__(self):
        return hash(self.__repr__())

    def __contains__(self, item):
        return self.cubes[0] in item.cubes[0] and self.cubes[1] in item.cubes[1] or \
               self.cubes[0] in item.cubes[1] and self.cubes[1] in item.cubes[0]

    def allVariants(self):
        result = set()

        firstCubeVariants = self.getCubes()[0].allVariants()
        secondCubeVariants = self.getCubes()[1].allVariants()

        for c1 in firstCubeVariants:
            for c2 in secondCubeVariants:
                result.add(CubesPair(c1, c2))

        return list(result)

    def allSixNineVariants(self):
        c1 = self.getCubes()[0]
        c2 = self.getCubes()[1]

        c1_var = c1.allSixNineVariants()
        c2_var = c2.allSixNineVariants()

        result = []

        for i in itertools.product(c1_var, c2_var):
            result.append(CubesPair(i[0], i[1]))

        return result


if __name__ == "__main__":
    pass
