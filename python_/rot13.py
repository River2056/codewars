import re
import unittest

def rot13(message):
    decode = "abcdefghijklmnopqrstuvwxyz"
    res = []
    for c in message:
        if re.match("[A-Z]", c):
            res.append(decode[(decode.index(c.lower()) + 13) % 26].upper())
        elif re.match("[a-z]", c):
            res.append(decode[(decode.index(c) + 13) % 26])
        else:
            res.append(c)
    return "".join(res)

def rot13_attempt2(message):
    res = []
    for c in message:
        if re.match("[A-Z]", c):
            res.append(chr((ord(c) - ord("A") + 13) % 26 + ord("A")))
        elif re.match("[a-z]", c):
            res.append(chr((ord(c) - ord("a") + 13) % 26 + ord("a")))
        else:
            res.append(c)
    return "".join(res)

class TestRot13(unittest.TestCase):

    def setUp(self):
        self.testCase = [
            ("EBG13 rknzcyr.", "ROT13 example."),
            ("How can you tell an extrovert from an\nintrovert at NSA? Va gur ryringbef,\ngur rkgebireg ybbxf ng gur BGURE thl'f fubrf.", "Ubj pna lbh gryy na rkgebireg sebz na\nvagebireg ng AFN? In the elevators,\nthe extrovert looks at the OTHER guy's shoes."),
            ("123", "123"),
            ("Guvf vf npghnyyl gur svefg xngn V rire znqr. Gunaxf sbe svavfuvat vg! :)", "This is actually the first kata I ever made. Thanks for finishing it! :)"),
        ]

    def test_rot13(self):
        for input, expected in self.testCase:
            with self.subTest(input=input, expected=expected):
                result = rot13(input)
                self.assertEqual(result, expected)

    def test_rot13_attempt2(self):
        for input, expected in self.testCase:
            with self.subTest(input=input, expected=expected):
                result = rot13_attempt2(input)
                self.assertEqual(result, expected)

if __name__ == "__main__":
    unittest.main()
    # print(rot13("How can you tell an extrovert from an\nintrovert at NSA? Va gur ryringbef,\ngur rkgebireg ybbxf ng gur BGURE thl'f fubrf."))
