import unittest


def binary_pyramid(m, n):
    def convert_to_binary(num):
        if num == 0:
            return str(num)
        res = []
        while num > 0:
            res.append(str(num % 2))
            num //= 2
        res.reverse()
        return "".join(res)

    return convert_to_binary(sum([int(convert_to_binary(i)) for i in range(m, n + 1)]))


class TestBinarypyramid(unittest.TestCase):
    def setUp(self):
        self.tests = [((1, 4), "1111010")]

    def test_binary_pyramid(self):
        for input, expected in self.tests:
            with self.subTest(input=input, expected=expected):
                result = binary_pyramid(input[0], input[1])
                self.assertEqual(result, expected)


def main():
    print(binary_pyramid(1, 4))


if __name__ == "__main__":
    unittest.main()
    # main()
