import unittest

from solution import Point, Triangle, readTriangles, solve


class TestProblem(unittest.TestCase):
    def test_triangle_contains(self):
        self.assertTrue(
            Triangle(Point(-340, 495), Point(-153, -910), Point(835, -947)).triangleContainsPoint(Point(0, 0)))

    def test_triangle_doesnt_contain(self):
        self.assertFalse(
            Triangle(Point(-175, 41), Point(-421, -714), Point(574, -645)).triangleContainsPoint(Point(0, 0)))

    def test_read_triangles(self):
        triangles = readTriangles("triangles.txt")
        self.assertEqual(1000, len(triangles))
        self.assertEqual(triangles[0], Triangle(Point(-340, 495), Point(-153, -910), Point(835, -947)))

    def test_solution(self):
        self.assertEqual(solve(
            [Triangle(Point(-340, 495), Point(-153, -910), Point(835, -947)),
             Triangle(Point(-175, 41), Point(-421, -714), Point(574, -645))]
        ), 1)

    def test_wrong_solution(self):
        allTriangles = readTriangles("triangles.txt")
        self.assertEqual(len(allTriangles), 1000)
        self.assertNotEqual(solve(allTriangles), 238)
        self.assertNotEqual(solve(allTriangles), 210)


if __name__ == '__main__':
    unittest.main()
