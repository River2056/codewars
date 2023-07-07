import unittest


def last_digit(n1, n2):
    if n1 == 0 and n2 == 0:
        return 1
    if n1 == 0:
        return 0
    if n2 == 0:
        return 1

    exp = 0
    if n2 % 4 == 0:
        exp = 4
    else:
        exp = n2 % 4

    return (n1**exp) % 10


class TestLastdigit(unittest.TestCase):
    def setUp(self):
        self.tests = [
            ((4, 1), 4),
            ((4, 2), 6),
            ((9, 7), 9),
            ((10, 10**10), 0),
            ((2**200, 2**300), 6),
            (
                (
                    3715290469715693021198967285016729344580685479654510946723,
                    68819615221552997273737174557165657483427362207517952651,
                ),
                7,
            ),
        ]

    def test_last_digit(self):
        for input, expected in self.tests:
            with self.subTest(input=input, expected=expected):
                result = last_digit(input[0], input[1])
                self.assertEqual(result, expected)


def main():
    print(
        last_digit(
            2417563836157593451216991931380267568969972518600952554992,
            3788969595047325099582362508108677719762161554839275278094,
        )
    )


if __name__ == "__main__":
    # unittest.main()
    main()
