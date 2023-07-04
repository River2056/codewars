import unittest


def rgb(r, g, b):
    def get_hex(n):
        if n > 255:
            n = 255
        if n < 0 or n == 0:
            return "00"
        symbols = {
            10: "A",
            11: "B",
            12: "C",
            13: "D",
            14: "E",
            15: "F",
        }
        res = []
        while n > 0:
            remainder = n % 16
            res.append(f"{remainder}" if remainder < 10 else symbols[remainder])
            n //= 16
        res.reverse()
        if len(res) < 2:
            res.insert(0, "0")
        return "".join(res)

    return f"{get_hex(r)}{get_hex(g)}{get_hex(b)}"


class TestRgb(unittest.TestCase):
    def setUp(self):
        self.tests = [
            ((0, 0, 0), "000000"),
            ((1, 2, 3), "010203"),
            ((255, 255, 255), "FFFFFF"),
            ((254, 253, 252), "FEFDFC"),
            ((-20, 275, 125), "00FF7D"),
        ]

    def test_rgb(self):
        for input, expected in self.tests:
            with self.subTest(input=input, expected=expected):
                result = rgb(input[0], input[1], input[2])
                self.assertEqual(result, expected)


def main():
    rgb(0, 0, 0)
    rgb(1, 2, 3)
    rgb(255, 255, 255)
    rgb(254, 253, 252)
    rgb(-20, 275, 125)


if __name__ == "__main__":
    unittest.main()
