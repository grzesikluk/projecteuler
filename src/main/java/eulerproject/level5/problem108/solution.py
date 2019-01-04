import itertools


class Tuple():
    def __init__(self, x, y):
        self.x = x
        self.y = y

    def __eq__(self, other):
        return (self.x == other.x and self.y == other.y) or \
               (self.x == other.y and self.y == other.x)

    def __str__(self):
        return "({},{})".format(self.x, self.y)

    def __repr__(self):
        return self.__str__()

    def __hash__(self):
        return hash(self.x + self.y)


def diophantineSolution(k, m, n):
    return k * m * (m + n), k * n * (m + n), k * m * n


def getNumberOfSolutions(max):
    r = range(1, max + 1)
    result = []
    counter = {}

    for k, m, n in itertools.product(r, r, r):
        x, y, z = diophantineSolution(k, m, n)

        if z in counter:
            counter[z] += 1
        else:
            counter[z] = 1

        if counter[z] > 2000:
            result.append(z)
    return sorted(set(result))


def getNumberOfSolutionsOptimised(max):
    r = range(1, max + 1)
    counter = {}

    for k in r:
        for m in range(1, int(max / k) + 1):
            for n in range(1, (max / (m * k)) + 1):
                x, y, z = diophantineSolution(k, m, n)
                # print("{}".format((k, m, n)))
                if z >= max:
                    break
                else:
                    if z in counter:
                        counter[z].append(Tuple(x, y))
                    else:
                        counter[z] = [(Tuple(x, y))]

    return counter


def extractResult(set_counter, threshold):
    len_counter = {}
    result = []

    for k, v in set_counter.iteritems():
        len_counter[k] = len(set(v))

    for k, v in len_counter.iteritems():
        if v >= threshold:
            return k

    return 0


if __name__ == "__main__":
    solution = getNumberOfSolutionsOptimised(250000)
    print(extractResult(solution, 1000))
