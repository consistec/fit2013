#!/usr/bin/env python
# -*- coding: utf-8 -*-

import unittest
from encoder import encode

class TestInput1(unittest.TestCase):

    def setUp(self):
        self.input = "bcd\n"
        self.output = "ABC\n"

    def test_encoding(self):
        self.assertTrue(encode(self.input) == self.output)

class TestInput2(unittest.TestCase):

    def setUp(self):
        self.input = "abcwxy\n"
        self.output = "NABXYZ\n"

    def test_encoding(self):
        self.assertTrue(encode(self.input) == self.output)

class TestInput3(unittest.TestCase):

    def setUp(self):
        self.input = "Wir wollen Euch testen und sind sehr gespannt auf die Antworten. Hoffentlich sind es mehr als 2.\n"
        self.output = "yHS XPKKDM cVBG UDTUDM VMC THMC TDGS FDTQNMMU NVE CHD mMUXPSUDM. fPEEDMUKHBG THMC DT LDGS NKT 2.\n"

    def test_encoding(self):
        self.assertTrue(encode(self.input) == self.output)

if __name__ == '__main__':
    unittest.main()
