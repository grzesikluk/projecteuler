import decimal


class Point:
    def __init__(self, x=0.0, y=0.0):
        self.x = decimal.Decimal(x)
        self.y = decimal.Decimal(y)

    def __str__(self):
        return "({},{})".format(self.x, self.y)

    def __eq__(self, other):
        return self.x == other.x and self.y == other.y


class Triangle:
    def __init__(self, p1, p2, p3):
        self.p1 = p1
        self.p2 = p2
        self.p3 = p3

    def getBaricentricAlpha(self, p):
        """Get alpha baricentric parameter. Return type - decimal.Decimal"""
        return ((self.p2.y - self.p3.y) * (p.x - self.p3.x) + (self.p3.x - self.p2.x) * (p.y - self.p3.y)) / (
                (self.p2.y - self.p3.y) * (self.p1.x - self.p3.x) + (self.p3.x - self.p2.x) * (self.p1.y - self.p3.y))

    def getBaricentricBeta(self, p):
        """Get beta baricentric parameter. Return type - decimal.Decimal"""
        return ((self.p3.y - self.p1.y) * (p.x - self.p3.x) + (self.p1.x - self.p3.x) * (p.y - self.p3.y)) / (
                (self.p2.y - self.p3.y) * (self.p1.x - self.p3.x) + (self.p3.x - self.p2.x) * (self.p1.y - self.p3.y))

    def getBaricentricGamma(self, p):
        """Get gamma baricentric parameter. Return type - decimal.Decimal"""
        return decimal.Decimal(1.0) - self.getBaricentricAlpha(p) - self.getBaricentricBeta(p)

    def triangleContainsPointByArea(self, p):
        t1 = Triangle(self.p1, self.p2, p)
        t2 = Triangle(self.p1, self.p3, p)
        t3 = Triangle(self.p2, self.p3, p)
        return (t1.area() + t2.area() + t3.area()) == self.area()

    def triangleContainsPointsByBaricentricParameters(self, p):
        return self.getBaricentricAlpha(p) > decimal.Decimal(0.0) and \
               self.getBaricentricBeta(p) > decimal.Decimal(0.0) and \
               self.getBaricentricGamma(p) > decimal.Decimal(0.0)

    def triangleContainsPoint(self, p):
        return self.triangleContainsPointByArea(p)

    def area(self):
        result = ((self.p1.x * (self.p2.y - self.p3.y) + self.p2.x * (self.p3.y - self.p1.y) + self.p3.x * (
                self.p1.y - self.p2.y)) / decimal.Decimal(2.0))
        return result.__abs__();

    def __str__(self):
        return "[{},{},{}]".format(self.p1, self.p2, self.p3)

    def __eq__(self, other):
        return self.p1 == other.p1 and self.p2 == other.p2 and self.p3 == other.p3


def readTriangles(fileName):
    """Parse triangle definition files"""
    triangles = []
    file = open(fileName, "r")

    for line in file:
        numbers = [int(number) for number in line.split(",")]
        triangles.append(
            Triangle(Point(numbers[0], numbers[1]), Point(numbers[2], numbers[3]), Point(numbers[4], numbers[5])))

    return triangles


def solve(triangles):
    solution = 0
    center = Point(0, 0)
    for triangle in triangles:
        if triangle.triangleContainsPoint(center):
            solution += 1
    return solution


if __name__ == "__main__":
    decimal.getcontext().prec = 10
    allTriangles = readTriangles("triangles.txt")
    print solve(allTriangles)
