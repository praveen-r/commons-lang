/*******************************************************************************
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *******************************************************************************/
package org.apache.commons.lang3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.fail;

import org.junit.Test;


/**
 * Unit tests {@link Conversion}.
 * 
 * @version $Id$
 */
public class ConversionTest {

    /**
     * Tests {@link Conversion#hexDigitToInt(char)}.
     */
    @Test
    public void testHexDigitToInt() {
        assertEquals(0, Conversion.hexDigitToInt('0'));
        assertEquals(1, Conversion.hexDigitToInt('1'));
        assertEquals(2, Conversion.hexDigitToInt('2'));
        assertEquals(3, Conversion.hexDigitToInt('3'));
        assertEquals(4, Conversion.hexDigitToInt('4'));
        assertEquals(5, Conversion.hexDigitToInt('5'));
        assertEquals(6, Conversion.hexDigitToInt('6'));
        assertEquals(7, Conversion.hexDigitToInt('7'));
        assertEquals(8, Conversion.hexDigitToInt('8'));
        assertEquals(9, Conversion.hexDigitToInt('9'));
        assertEquals(10, Conversion.hexDigitToInt('A'));
        assertEquals(10, Conversion.hexDigitToInt('a'));
        assertEquals(11, Conversion.hexDigitToInt('B'));
        assertEquals(11, Conversion.hexDigitToInt('b'));
        assertEquals(12, Conversion.hexDigitToInt('C'));
        assertEquals(12, Conversion.hexDigitToInt('c'));
        assertEquals(13, Conversion.hexDigitToInt('D'));
        assertEquals(13, Conversion.hexDigitToInt('d'));
        assertEquals(14, Conversion.hexDigitToInt('E'));
        assertEquals(14, Conversion.hexDigitToInt('e'));
        assertEquals(15, Conversion.hexDigitToInt('F'));
        assertEquals(15, Conversion.hexDigitToInt('f'));
    }

    /**
     * Tests {@link Conversion#hexDigitM0ToInt(char)}.
     */
    @Test
    public void testHexDigitM0ToInt() {
        assertEquals(0x0, Conversion.hexDigitM0ToInt('0'));
        assertEquals(0x8, Conversion.hexDigitM0ToInt('1'));
        assertEquals(0x4, Conversion.hexDigitM0ToInt('2'));
        assertEquals(0xC, Conversion.hexDigitM0ToInt('3'));
        assertEquals(0x2, Conversion.hexDigitM0ToInt('4'));
        assertEquals(0xA, Conversion.hexDigitM0ToInt('5'));
        assertEquals(0x6, Conversion.hexDigitM0ToInt('6'));
        assertEquals(0xE, Conversion.hexDigitM0ToInt('7'));
        assertEquals(0x1, Conversion.hexDigitM0ToInt('8'));
        assertEquals(0x9, Conversion.hexDigitM0ToInt('9'));
        assertEquals(0x5, Conversion.hexDigitM0ToInt('A'));
        assertEquals(0x5, Conversion.hexDigitM0ToInt('a'));
        assertEquals(0xD, Conversion.hexDigitM0ToInt('B'));
        assertEquals(0xD, Conversion.hexDigitM0ToInt('b'));
        assertEquals(0x3, Conversion.hexDigitM0ToInt('C'));
        assertEquals(0x3, Conversion.hexDigitM0ToInt('c'));
        assertEquals(0xB, Conversion.hexDigitM0ToInt('D'));
        assertEquals(0xB, Conversion.hexDigitM0ToInt('d'));
        assertEquals(0x7, Conversion.hexDigitM0ToInt('E'));
        assertEquals(0x7, Conversion.hexDigitM0ToInt('e'));
        assertEquals(0xF, Conversion.hexDigitM0ToInt('F'));
        assertEquals(0xF, Conversion.hexDigitM0ToInt('f'));
    }

    /**
     * Tests {@link Conversion#hexDigitToBools(char)}.
     */
    @Test
    public void testHexDigitToBools() {
        assertBoolArrayEquals(
            new boolean[]{false, false, false, false}, Conversion.hexDigitToBools('0'));
        assertBoolArrayEquals(
            new boolean[]{true, false, false, false}, Conversion.hexDigitToBools('1'));
        assertBoolArrayEquals(
            new boolean[]{false, true, false, false}, Conversion.hexDigitToBools('2'));
        assertBoolArrayEquals(
            new boolean[]{true, true, false, false}, Conversion.hexDigitToBools('3'));
        assertBoolArrayEquals(
            new boolean[]{false, false, true, false}, Conversion.hexDigitToBools('4'));
        assertBoolArrayEquals(
            new boolean[]{true, false, true, false}, Conversion.hexDigitToBools('5'));
        assertBoolArrayEquals(
            new boolean[]{false, true, true, false}, Conversion.hexDigitToBools('6'));
        assertBoolArrayEquals(
            new boolean[]{true, true, true, false}, Conversion.hexDigitToBools('7'));
        assertBoolArrayEquals(
            new boolean[]{false, false, false, true}, Conversion.hexDigitToBools('8'));
        assertBoolArrayEquals(
            new boolean[]{true, false, false, true}, Conversion.hexDigitToBools('9'));
        assertBoolArrayEquals(
            new boolean[]{false, true, false, true}, Conversion.hexDigitToBools('A'));
        assertBoolArrayEquals(
            new boolean[]{false, true, false, true}, Conversion.hexDigitToBools('a'));
        assertBoolArrayEquals(
            new boolean[]{true, true, false, true}, Conversion.hexDigitToBools('B'));
        assertBoolArrayEquals(
            new boolean[]{true, true, false, true}, Conversion.hexDigitToBools('b'));
        assertBoolArrayEquals(
            new boolean[]{false, false, true, true}, Conversion.hexDigitToBools('C'));
        assertBoolArrayEquals(
            new boolean[]{false, false, true, true}, Conversion.hexDigitToBools('c'));
        assertBoolArrayEquals(
            new boolean[]{true, false, true, true}, Conversion.hexDigitToBools('D'));
        assertBoolArrayEquals(
            new boolean[]{true, false, true, true}, Conversion.hexDigitToBools('d'));
        assertBoolArrayEquals(
            new boolean[]{false, true, true, true}, Conversion.hexDigitToBools('E'));
        assertBoolArrayEquals(
            new boolean[]{false, true, true, true}, Conversion.hexDigitToBools('e'));
        assertBoolArrayEquals(
            new boolean[]{true, true, true, true}, Conversion.hexDigitToBools('F'));
        assertBoolArrayEquals(
            new boolean[]{true, true, true, true}, Conversion.hexDigitToBools('f'));
    }

    /**
     * Tests {@link Conversion#hexDigitM0ToBools(char)}.
     */
    @Test
    public void testHexDigitM0ToBools() {
        assertBoolArrayEquals(
            new boolean[]{false, false, false, false}, Conversion.hexDigitM0ToBools('0'));
        assertBoolArrayEquals(
            new boolean[]{false, false, false, true}, Conversion.hexDigitM0ToBools('1'));
        assertBoolArrayEquals(
            new boolean[]{false, false, true, false}, Conversion.hexDigitM0ToBools('2'));
        assertBoolArrayEquals(
            new boolean[]{false, false, true, true}, Conversion.hexDigitM0ToBools('3'));
        assertBoolArrayEquals(
            new boolean[]{false, true, false, false}, Conversion.hexDigitM0ToBools('4'));
        assertBoolArrayEquals(
            new boolean[]{false, true, false, true}, Conversion.hexDigitM0ToBools('5'));
        assertBoolArrayEquals(
            new boolean[]{false, true, true, false}, Conversion.hexDigitM0ToBools('6'));
        assertBoolArrayEquals(
            new boolean[]{false, true, true, true}, Conversion.hexDigitM0ToBools('7'));
        assertBoolArrayEquals(
            new boolean[]{true, false, false, false}, Conversion.hexDigitM0ToBools('8'));
        assertBoolArrayEquals(
            new boolean[]{true, false, false, true}, Conversion.hexDigitM0ToBools('9'));
        assertBoolArrayEquals(
            new boolean[]{true, false, true, false}, Conversion.hexDigitM0ToBools('A'));
        assertBoolArrayEquals(
            new boolean[]{true, false, true, false}, Conversion.hexDigitM0ToBools('a'));
        assertBoolArrayEquals(
            new boolean[]{true, false, true, true}, Conversion.hexDigitM0ToBools('B'));
        assertBoolArrayEquals(
            new boolean[]{true, false, true, true}, Conversion.hexDigitM0ToBools('b'));
        assertBoolArrayEquals(
            new boolean[]{true, true, false, false}, Conversion.hexDigitM0ToBools('C'));
        assertBoolArrayEquals(
            new boolean[]{true, true, false, false}, Conversion.hexDigitM0ToBools('c'));
        assertBoolArrayEquals(
            new boolean[]{true, true, false, true}, Conversion.hexDigitM0ToBools('D'));
        assertBoolArrayEquals(
            new boolean[]{true, true, false, true}, Conversion.hexDigitM0ToBools('d'));
        assertBoolArrayEquals(
            new boolean[]{true, true, true, false}, Conversion.hexDigitM0ToBools('E'));
        assertBoolArrayEquals(
            new boolean[]{true, true, true, false}, Conversion.hexDigitM0ToBools('e'));
        assertBoolArrayEquals(
            new boolean[]{true, true, true, true}, Conversion.hexDigitM0ToBools('F'));
        assertBoolArrayEquals(
            new boolean[]{true, true, true, true}, Conversion.hexDigitM0ToBools('f'));
    }

    /**
     * Tests {@link Conversion#boolsToHexDigit(boolean[])}.
     */
    @Test
    public void testBoolsToHexDigit() {
        assertEquals('0', Conversion.boolsToHexDigit(new boolean[]{false, false, false, false}));
        assertEquals('1', Conversion.boolsToHexDigit(new boolean[]{true, false, false, false}));
        assertEquals('2', Conversion.boolsToHexDigit(new boolean[]{false, true, false, false}));
        assertEquals('3', Conversion.boolsToHexDigit(new boolean[]{true, true, false, false}));
        assertEquals('4', Conversion.boolsToHexDigit(new boolean[]{false, false, true, false}));
        assertEquals('5', Conversion.boolsToHexDigit(new boolean[]{true, false, true, false}));
        assertEquals('6', Conversion.boolsToHexDigit(new boolean[]{false, true, true, false}));
        assertEquals('7', Conversion.boolsToHexDigit(new boolean[]{true, true, true, false}));
        assertEquals('8', Conversion.boolsToHexDigit(new boolean[]{false, false, false, true}));
        assertEquals('9', Conversion.boolsToHexDigit(new boolean[]{true, false, false, true}));
        assertEquals('A', Conversion.boolsToHexDigit(new boolean[]{false, true, false, true}));
        assertEquals('B', Conversion.boolsToHexDigit(new boolean[]{true, true, false, true}));
        assertEquals('C', Conversion.boolsToHexDigit(new boolean[]{false, false, true, true}));
        assertEquals('D', Conversion.boolsToHexDigit(new boolean[]{true, false, true, true}));
        assertEquals('E', Conversion.boolsToHexDigit(new boolean[]{false, true, true, true}));
        assertEquals('F', Conversion.boolsToHexDigit(new boolean[]{true, true, true, true}));
    }

    /**
     * Tests {@link Conversion#boolsBeM0ToHexDigit(boolean[], int)}.
     */
    @Test
    public void testBoolsToHexDigit_2args() {
        boolean[] shortArray = new boolean[]{false, true, true};
        assertEquals('6', Conversion.boolsToHexDigit(shortArray, 0));
        assertEquals('3', Conversion.boolsToHexDigit(shortArray, 1));
        assertEquals('1', Conversion.boolsToHexDigit(shortArray, 2));
        boolean[] longArray = new boolean[]{true, false, true, false, false, true, true};
        assertEquals('5', Conversion.boolsToHexDigit(longArray, 0));
        assertEquals('2', Conversion.boolsToHexDigit(longArray, 1));
        assertEquals('9', Conversion.boolsToHexDigit(longArray, 2));
        assertEquals('C', Conversion.boolsToHexDigit(longArray, 3));
        assertEquals('6', Conversion.boolsToHexDigit(longArray, 4));
        assertEquals('3', Conversion.boolsToHexDigit(longArray, 5));
        assertEquals('1', Conversion.boolsToHexDigit(longArray, 6));
    }

    /**
     * Tests {@link Conversion#boolsToHexDigitM0_4bits(boolean[])}.
     */
    @Test
    public void testBoolsToHexDigitM0_bits() {
        assertEquals(
            '0', Conversion.boolsToHexDigitM0_4bits(new boolean[]{false, false, false, false}));
        assertEquals(
            '1', Conversion.boolsToHexDigitM0_4bits(new boolean[]{false, false, false, true}));
        assertEquals(
            '2', Conversion.boolsToHexDigitM0_4bits(new boolean[]{false, false, true, false}));
        assertEquals(
            '3', Conversion.boolsToHexDigitM0_4bits(new boolean[]{false, false, true, true}));
        assertEquals(
            '4', Conversion.boolsToHexDigitM0_4bits(new boolean[]{false, true, false, false}));
        assertEquals(
            '5', Conversion.boolsToHexDigitM0_4bits(new boolean[]{false, true, false, true}));
        assertEquals(
            '6', Conversion.boolsToHexDigitM0_4bits(new boolean[]{false, true, true, false}));
        assertEquals(
            '7', Conversion.boolsToHexDigitM0_4bits(new boolean[]{false, true, true, true}));
        assertEquals(
            '8', Conversion.boolsToHexDigitM0_4bits(new boolean[]{true, false, false, false}));
        assertEquals(
            '9', Conversion.boolsToHexDigitM0_4bits(new boolean[]{true, false, false, true}));
        assertEquals(
            'A', Conversion.boolsToHexDigitM0_4bits(new boolean[]{true, false, true, false}));
        assertEquals(
            'B', Conversion.boolsToHexDigitM0_4bits(new boolean[]{true, false, true, true}));
        assertEquals(
            'C', Conversion.boolsToHexDigitM0_4bits(new boolean[]{true, true, false, false}));
        assertEquals(
            'D', Conversion.boolsToHexDigitM0_4bits(new boolean[]{true, true, false, true}));
        assertEquals(
            'E', Conversion.boolsToHexDigitM0_4bits(new boolean[]{true, true, true, false}));
        assertEquals(
            'F', Conversion.boolsToHexDigitM0_4bits(new boolean[]{true, true, true, true}));
    }

    /**
     * Tests {@link Conversion#boolsToHexDigitM0_4bits(boolean[], int)}.
     */
    @Test
    public void testBoolsToHexDigitM0_4bits_2args() {
        // boolean[] shortArray = new boolean[]{true,true,false};
        // assertEquals('6', Conversion.boolsToHexDigitM0(shortArray,0));
        // assertEquals('3', Conversion.boolsToHexDigitM0(shortArray,1));
        // assertEquals('1', Conversion.boolsToHexDigitM0(shortArray,2));
        boolean[] shortArray = new boolean[]{true, true, false, true};
        assertEquals('D', Conversion.boolsToHexDigitM0_4bits(shortArray, 0));
        boolean[] longArray = new boolean[]{true, false, true, false, false, true, true};
        assertEquals('A', Conversion.boolsToHexDigitM0_4bits(longArray, 0));
        assertEquals('4', Conversion.boolsToHexDigitM0_4bits(longArray, 1));
        assertEquals('9', Conversion.boolsToHexDigitM0_4bits(longArray, 2));
        assertEquals('3', Conversion.boolsToHexDigitM0_4bits(longArray, 3));
        // assertEquals('6', Conversion.boolsToHexDigitM0(longArray,4));
        // assertEquals('3', Conversion.boolsToHexDigitM0(longArray,5));
        // assertEquals('1', Conversion.boolsToHexDigitM0(longArray,6));
        boolean[] maxLengthArray = new boolean[]{
            true, false, true, false, false, true, true, true};
        assertEquals('A', Conversion.boolsToHexDigitM0_4bits(maxLengthArray, 0));
        assertEquals('4', Conversion.boolsToHexDigitM0_4bits(maxLengthArray, 1));
        assertEquals('9', Conversion.boolsToHexDigitM0_4bits(maxLengthArray, 2));
        assertEquals('3', Conversion.boolsToHexDigitM0_4bits(maxLengthArray, 3));
        assertEquals('7', Conversion.boolsToHexDigitM0_4bits(maxLengthArray, 4));
        // assertEquals('7', Conversion.boolsToHexDigitM0(longArray,5));
        // assertEquals('3', Conversion.boolsToHexDigitM0(longArray,6));
        // assertEquals('1', Conversion.boolsToHexDigitM0(longArray,7));
        boolean[] javaDocCheck = new boolean[]{
            true, false, false, true, true, false, true, false};
        assertEquals('D', Conversion.boolsToHexDigitM0_4bits(javaDocCheck, 3));

    }

    /**
     * Tests {@link Conversion#boolsToHexDigit(boolean[])}.
     */
    @Test
    public void testBoolsBeM0ToHexDigit() {
        assertEquals(
            '0', Conversion.boolsBeM0ToHexDigit(new boolean[]{false, false, false, false}));
        assertEquals(
            '1', Conversion.boolsBeM0ToHexDigit(new boolean[]{false, false, false, true}));
        assertEquals(
            '2', Conversion.boolsBeM0ToHexDigit(new boolean[]{false, false, true, false}));
        assertEquals(
            '3', Conversion.boolsBeM0ToHexDigit(new boolean[]{false, false, true, true}));
        assertEquals(
            '4', Conversion.boolsBeM0ToHexDigit(new boolean[]{false, true, false, false}));
        assertEquals(
            '5', Conversion.boolsBeM0ToHexDigit(new boolean[]{false, true, false, true}));
        assertEquals(
            '6', Conversion.boolsBeM0ToHexDigit(new boolean[]{false, true, true, false}));
        assertEquals(
            '7', Conversion.boolsBeM0ToHexDigit(new boolean[]{false, true, true, true}));
        assertEquals(
            '8', Conversion.boolsBeM0ToHexDigit(new boolean[]{true, false, false, false}));
        assertEquals(
            '9', Conversion.boolsBeM0ToHexDigit(new boolean[]{true, false, false, true}));
        assertEquals(
            'A', Conversion.boolsBeM0ToHexDigit(new boolean[]{true, false, true, false}));
        assertEquals(
            'B', Conversion.boolsBeM0ToHexDigit(new boolean[]{true, false, true, true}));
        assertEquals(
            'C', Conversion.boolsBeM0ToHexDigit(new boolean[]{true, true, false, false}));
        assertEquals(
            'D', Conversion.boolsBeM0ToHexDigit(new boolean[]{true, true, false, true}));
        assertEquals(
            'E', Conversion.boolsBeM0ToHexDigit(new boolean[]{true, true, true, false}));
        assertEquals('F', Conversion.boolsBeM0ToHexDigit(new boolean[]{true, true, true, true}));
        assertEquals(
            '4',
            Conversion.boolsBeM0ToHexDigit(new boolean[]{
                true, false, false, false, false, false, false, false, false, false, false,
                false, false, true, false, false}));
    }

    /**
     * Tests {@link Conversion#boolsToHexDigit(boolean[], int)}.
     */
    @Test
    public void testBoolsBeM0ToHexDigit_2args() {
        assertEquals(
            '5',
            Conversion.boolsBeM0ToHexDigit(new boolean[]{
                true, false, false, false, false, false, false, false, false, false, false,
                true, false, true, false, false}, 2));

        boolean[] shortArray = new boolean[]{true, true, false};
        assertEquals('6', Conversion.boolsBeM0ToHexDigit(shortArray, 0));
        assertEquals('3', Conversion.boolsBeM0ToHexDigit(shortArray, 1));
        assertEquals('1', Conversion.boolsBeM0ToHexDigit(shortArray, 2));
        boolean[] shortArray2 = new boolean[]{true, true, true, false, false, true, false, true};
        assertEquals('5', Conversion.boolsBeM0ToHexDigit(shortArray2, 0));
        assertEquals('2', Conversion.boolsBeM0ToHexDigit(shortArray2, 1));
        assertEquals('9', Conversion.boolsBeM0ToHexDigit(shortArray2, 2));
        assertEquals('C', Conversion.boolsBeM0ToHexDigit(shortArray2, 3));
        assertEquals('E', Conversion.boolsBeM0ToHexDigit(shortArray2, 4));
        assertEquals('7', Conversion.boolsBeM0ToHexDigit(shortArray2, 5));
        assertEquals('3', Conversion.boolsBeM0ToHexDigit(shortArray2, 6));
        assertEquals('1', Conversion.boolsBeM0ToHexDigit(shortArray2, 7));
        boolean[] multiBytesArray = new boolean[]{
            true, true, false, false, true, false, true, false, true, true, true, false, false,
            true, false, true};
        assertEquals('5', Conversion.boolsBeM0ToHexDigit(multiBytesArray, 0));
        assertEquals('2', Conversion.boolsBeM0ToHexDigit(multiBytesArray, 1));
        assertEquals('9', Conversion.boolsBeM0ToHexDigit(multiBytesArray, 2));
        assertEquals('C', Conversion.boolsBeM0ToHexDigit(multiBytesArray, 3));
        assertEquals('E', Conversion.boolsBeM0ToHexDigit(multiBytesArray, 4));
        assertEquals('7', Conversion.boolsBeM0ToHexDigit(multiBytesArray, 5));
        assertEquals('B', Conversion.boolsBeM0ToHexDigit(multiBytesArray, 6));
        assertEquals('5', Conversion.boolsBeM0ToHexDigit(multiBytesArray, 7));

        assertEquals('A', Conversion.boolsBeM0ToHexDigit(multiBytesArray, 8));
        assertEquals('5', Conversion.boolsBeM0ToHexDigit(multiBytesArray, 9));
        assertEquals('2', Conversion.boolsBeM0ToHexDigit(multiBytesArray, 10));
        assertEquals('9', Conversion.boolsBeM0ToHexDigit(multiBytesArray, 11));
        assertEquals('C', Conversion.boolsBeM0ToHexDigit(multiBytesArray, 12));
        assertEquals('6', Conversion.boolsBeM0ToHexDigit(multiBytesArray, 13));
        assertEquals('3', Conversion.boolsBeM0ToHexDigit(multiBytesArray, 14));
        assertEquals('1', Conversion.boolsBeM0ToHexDigit(multiBytesArray, 15));

    }

    /**
     * Tests {@link Conversion#intToHexDigit(int)}.
     */
    @Test
    public void testIntToHexDigit() {
        assertEquals('0', Conversion.intToHexDigit(0));
        assertEquals('1', Conversion.intToHexDigit(1));
        assertEquals('2', Conversion.intToHexDigit(2));
        assertEquals('3', Conversion.intToHexDigit(3));
        assertEquals('4', Conversion.intToHexDigit(4));
        assertEquals('5', Conversion.intToHexDigit(5));
        assertEquals('6', Conversion.intToHexDigit(6));
        assertEquals('7', Conversion.intToHexDigit(7));
        assertEquals('8', Conversion.intToHexDigit(8));
        assertEquals('9', Conversion.intToHexDigit(9));
        assertEquals('A', Conversion.intToHexDigit(10));
        assertEquals('B', Conversion.intToHexDigit(11));
        assertEquals('C', Conversion.intToHexDigit(12));
        assertEquals('D', Conversion.intToHexDigit(13));
        assertEquals('E', Conversion.intToHexDigit(14));
        assertEquals('F', Conversion.intToHexDigit(15));
    }

    /**
     * Tests {@link Conversion#intToHexDigitM0(int)}.
     */
    @Test
    public void testIntToHexDigitM0() {
        assertEquals('0', Conversion.intToHexDigitM0(0));
        assertEquals('8', Conversion.intToHexDigitM0(1));
        assertEquals('4', Conversion.intToHexDigitM0(2));
        assertEquals('C', Conversion.intToHexDigitM0(3));
        assertEquals('2', Conversion.intToHexDigitM0(4));
        assertEquals('A', Conversion.intToHexDigitM0(5));
        assertEquals('6', Conversion.intToHexDigitM0(6));
        assertEquals('E', Conversion.intToHexDigitM0(7));
        assertEquals('1', Conversion.intToHexDigitM0(8));
        assertEquals('9', Conversion.intToHexDigitM0(9));
        assertEquals('5', Conversion.intToHexDigitM0(10));
        assertEquals('D', Conversion.intToHexDigitM0(11));
        assertEquals('3', Conversion.intToHexDigitM0(12));
        assertEquals('B', Conversion.intToHexDigitM0(13));
        assertEquals('7', Conversion.intToHexDigitM0(14));
        assertEquals('F', Conversion.intToHexDigitM0(15));
    }

    static String dbgPrint(boolean[] src) {
        StringBuilder sb = new StringBuilder();
        for (boolean e : src) {
            if (e) sb.append("1,");
            else sb.append("0,");
        }
        String out = sb.toString();
        return out.substring(0, out.length() - 1);
    }

    // org.junit.Assert(boolean[], boolean[]) does not exist in JUnit 4.2
    static void assertBoolArrayEquals(boolean[] expected, boolean[] actual) {
        assertEquals(expected.length, actual.length);
        for (int i = 0; i < expected.length; i++ ) {
            try {
                assertEquals(expected[i], actual[i]);
            } catch (Throwable e) {
                String msg = "Mismatch at index "
                    + i
                    + " between:\n"
                    + dbgPrint(expected)
                    + " and\n"
                    + dbgPrint(actual);
                fail(msg + "\n" + e.getMessage());
            }
        }
    }

    /**
     * Tests {@link Conversion#intsToLong(int[], int, long, int, int)}.
     */
    @Test
    public void testIntsToLong() {
        int[] src = new int[]{0xCDF1F0C1, 0x0F123456, 0x78000000};
        assertEquals(0x0000000000000000L, Conversion.intsToLong(src, 0, 0L, 0, 0));
        assertEquals(0x0000000000000000L, Conversion.intsToLong(src, 1, 0L, 0, 0));
        assertEquals(0x00000000CDF1F0C1L, Conversion.intsToLong(src, 0, 0L, 0, 1));
        assertEquals(0x0F123456CDF1F0C1L, Conversion.intsToLong(src, 0, 0L, 0, 2));
        assertEquals(0x000000000F123456L, Conversion.intsToLong(src, 1, 0L, 0, 1));
        assertEquals(
            0x123456789ABCDEF0L, Conversion.intsToLong(src, 0, 0x123456789ABCDEF0L, 0, 0));
        assertEquals(
            0x1234567878000000L, Conversion.intsToLong(src, 2, 0x123456789ABCDEF0L, 0, 1));
        // assertEquals(0x0F12345678000000L,Conversion.intsToLong(src,1,0x123456789ABCDEF0L,32,2));
    }

    /**
     * Tests {@link Conversion#shortsToLong(short[], int, long, int, int)}.
     */
    @Test
    public void testShortsToLong() {
        short[] src = new short[]{
            (short)0xCDF1, (short)0xF0C1, (short)0x0F12, (short)0x3456, (short)0x7800};
        assertEquals(0x0000000000000000L, Conversion.shortsToLong(src, 0, 0L, 0, 0));
        assertEquals(0x000000000000CDF1L, Conversion.shortsToLong(src, 0, 0L, 0, 1));
        assertEquals(0x00000000F0C1CDF1L, Conversion.shortsToLong(src, 0, 0L, 0, 2));
        assertEquals(0x780034560F12F0C1L, Conversion.shortsToLong(src, 1, 0L, 0, 4));
        assertEquals(
            0x123456789ABCDEF0L, Conversion.shortsToLong(src, 0, 0x123456789ABCDEF0L, 0, 0));
        assertEquals(
            0x123456CDF1BCDEF0L, Conversion.shortsToLong(src, 0, 0x123456789ABCDEF0L, 24, 1));
        assertEquals(
            0x123478003456DEF0L, Conversion.shortsToLong(src, 3, 0x123456789ABCDEF0L, 16, 2));
    }

    /**
     * Tests {@link Conversion#bytesToLong(byte[], int, long, int, int)}.
     */
    @Test
    public void testBytesToLong() {
        byte[] src = new byte[]{
            (byte)0xCD, (byte)0xF1, (byte)0xF0, (byte)0xC1, (byte)0x0F, (byte)0x12, (byte)0x34,
            (byte)0x56, (byte)0x78};
        assertEquals(0x0000000000000000L, Conversion.bytesToLong(src, 0, 0L, 0, 0));
        assertEquals(0x00000000000000CDL, Conversion.bytesToLong(src, 0, 0L, 0, 1));
        assertEquals(0x00000000C1F0F1CDL, Conversion.bytesToLong(src, 0, 0L, 0, 4));
        assertEquals(0x000000000FC1F0F1L, Conversion.bytesToLong(src, 1, 0L, 0, 4));
        assertEquals(
            0x123456789ABCDEF0L, Conversion.bytesToLong(src, 0, 0x123456789ABCDEF0L, 0, 0));
        assertEquals(
            0x12345678CDBCDEF0L, Conversion.bytesToLong(src, 0, 0x123456789ABCDEF0L, 24, 1));
        assertEquals(
            0x123456789A7856F0L, Conversion.bytesToLong(src, 7, 0x123456789ABCDEF0L, 8, 2));
    }

    /**
     * Tests {@link Conversion#shortsToInt(short[], int, int, int, int)}.
     */
    @Test
    public void testShortsToInt() {
        short[] src = new short[]{
            (short)0xCDF1, (short)0xF0C1, (short)0x0F12, (short)0x3456, (short)0x7800};
        assertEquals(0x00000000, Conversion.shortsToInt(src, 0, 0, 0, 0));
        assertEquals(0x0000CDF1, Conversion.shortsToInt(src, 0, 0, 0, 1));
        assertEquals(0xF0C1CDF1, Conversion.shortsToInt(src, 0, 0, 0, 2));
        assertEquals(0x0F12F0C1, Conversion.shortsToInt(src, 1, 0, 0, 2));
        assertEquals(0x12345678, Conversion.shortsToInt(src, 0, 0x12345678, 0, 0));
        assertEquals(0xCDF15678, Conversion.shortsToInt(src, 0, 0x12345678, 16, 1));
        // assertEquals(0x34567800,Conversion.shortsToInt(src, 3, 0x12345678, 16, 2));
    }

    /**
     * Tests {@link Conversion#bytesToInt(byte[], int, int, int, int)}.
     */
    @Test
    public void testBytesToInt() {
        byte[] src = new byte[]{
            (byte)0xCD, (byte)0xF1, (byte)0xF0, (byte)0xC1, (byte)0x0F, (byte)0x12, (byte)0x34,
            (byte)0x56, (byte)0x78};
        assertEquals(0x00000000, Conversion.bytesToInt(src, 0, 0, 0, 0));
        assertEquals(0x000000CD, Conversion.bytesToInt(src, 0, 0, 0, 1));
        assertEquals(0xC1F0F1CD, Conversion.bytesToInt(src, 0, 0, 0, 4));
        assertEquals(0x0FC1F0F1, Conversion.bytesToInt(src, 1, 0, 0, 4));
        assertEquals(0x12345678, Conversion.bytesToInt(src, 0, 0x12345678, 0, 0));
        assertEquals(0xCD345678, Conversion.bytesToInt(src, 0, 0x12345678, 24, 1));
        // assertEquals(0x56341278,Conversion.bytesToInt(src, 5, 0x01234567, 8, 4));
    }

    /**
     * Tests {@link Conversion#bytesToShort(byte[], int, short, int, int)}.
     */
    @Test
    public void testBytesToShort() {
        byte[] src = new byte[]{
            (byte)0xCD, (byte)0xF1, (byte)0xF0, (byte)0xC1, (byte)0x0F, (byte)0x12, (byte)0x34,
            (byte)0x56, (byte)0x78};
        assertEquals((short)0x0000, Conversion.bytesToShort(src, 0, (short)0, 0, 0));
        assertEquals((short)0x00CD, Conversion.bytesToShort(src, 0, (short)0, 0, 1));
        assertEquals((short)0xF1CD, Conversion.bytesToShort(src, 0, (short)0, 0, 2));
        assertEquals((short)0xF0F1, Conversion.bytesToShort(src, 1, (short)0, 0, 2));
        assertEquals((short)0x1234, Conversion.bytesToShort(src, 0, (short)0x1234, 0, 0));
        assertEquals((short)0xCD34, Conversion.bytesToShort(src, 0, (short)0x1234, 8, 1));
        // assertEquals((short)0x5678,Conversion.bytesToShort(src, 7, (short) 0x0123, 8, 2));
    }

    /**
     * Tests {@link Conversion#hexsToLong(String, int, long, int, int)}.
     */
    @Test
    public void testHexsToLong() {
        String src = "CDF1F0C10F12345678";
        assertEquals(0x0000000000000000L, Conversion.hexsToLong(src, 0, 0L, 0, 0));
        assertEquals(0x000000000000000CL, Conversion.hexsToLong(src, 0, 0L, 0, 1));
        assertEquals(0x000000001C0F1FDCL, Conversion.hexsToLong(src, 0, 0L, 0, 8));
        assertEquals(0x0000000001C0F1FDL, Conversion.hexsToLong(src, 1, 0L, 0, 8));
        assertEquals(
            0x123456798ABCDEF0L, Conversion.hexsToLong(src, 0, 0x123456798ABCDEF0L, 0, 0));
        assertEquals(
            0x1234567876BCDEF0L, Conversion.hexsToLong(src, 15, 0x123456798ABCDEF0L, 24, 3));
    }

    /**
     * Tests {@link Conversion#hexsToInt(String, int, int, int, int)}.
     */
    @Test
    public void testHexsToInt() {
        String src = "CDF1F0C10F12345678";
        assertEquals(0x00000000, Conversion.hexsToInt(src, 0, 0, 0, 0));
        assertEquals(0x0000000C, Conversion.hexsToInt(src, 0, 0, 0, 1));
        assertEquals(0x1C0F1FDC, Conversion.hexsToInt(src, 0, 0, 0, 8));
        assertEquals(0x01C0F1FD, Conversion.hexsToInt(src, 1, 0, 0, 8));
        assertEquals(0x12345679, Conversion.hexsToInt(src, 0, 0x12345679, 0, 0));
        assertEquals(0x87645679, Conversion.hexsToInt(src, 15, 0x12345679, 20, 3));
    }

    /**
     * Tests {@link Conversion#hexsToShort(String, int, short, int, int)}.
     */
    @Test
    public void testHexsToShort() {
        String src = "CDF1F0C10F12345678";
        assertEquals((short)0x0000, Conversion.hexsToShort(src, 0, (short)0, 0, 0));
        assertEquals((short)0x000C, Conversion.hexsToShort(src, 0, (short)0, 0, 1));
        assertEquals((short)0x1FDC, Conversion.hexsToShort(src, 0, (short)0, 0, 4));
        assertEquals((short)0xF1FD, Conversion.hexsToShort(src, 1, (short)0, 0, 4));
        assertEquals((short)0x1234, Conversion.hexsToShort(src, 0, (short)0x1234, 0, 0));
        assertEquals((short)0x8764, Conversion.hexsToShort(src, 15, (short)0x1234, 4, 3));
    }

    /**
     * Tests {@link Conversion#hexsToByte(String, int, byte, int, int)}.
     */
    @Test
    public void testHexsToByte() {
        String src = "CDF1F0C10F12345678";
        assertEquals((byte)0x00, Conversion.hexsToByte(src, 0, (byte)0, 0, 0));
        assertEquals((byte)0x0C, Conversion.hexsToByte(src, 0, (byte)0, 0, 1));
        assertEquals((byte)0xDC, Conversion.hexsToByte(src, 0, (byte)0, 0, 2));
        assertEquals((byte)0xFD, Conversion.hexsToByte(src, 1, (byte)0, 0, 2));
        assertEquals((byte)0x34, Conversion.hexsToByte(src, 0, (byte)0x34, 0, 0));
        assertEquals((byte)0x84, Conversion.hexsToByte(src, 17, (byte)0x34, 4, 1));
    }

    /**
     * Tests {@link Conversion#boolsToLong(boolean[], int, long, int, int)}.
     */
    @Test
    public void testBoolsToLong() {
        boolean[] src = new boolean[]{
            false, false, true, true, true, false, true, true, true, true, true, true, true,
            false, false, false, true, true, true, true, false, false, false, false, false,
            false, true, true, true, false, false, false, false, false, false, false, true,
            true, true, true, true, false, false, false, false, true, false, false, true, true,
            false, false, false, false, true, false, true, false, true, false, false, true,
            true, false, true, true, true, false, false, false, false, true};
        // conversion of "CDF1F0C10F12345678" by hexsToBools
        assertEquals(0x0000000000000000L, Conversion.boolsToLong(src, 0, 0L, 0, 0));
        assertEquals(0x000000000000000CL, Conversion.boolsToLong(src, 0, 0L, 0, 1 * 4));
        assertEquals(0x000000001C0F1FDCL, Conversion.boolsToLong(src, 0, 0L, 0, 8 * 4));
        assertEquals(0x0000000001C0F1FDL, Conversion.boolsToLong(src, 1 * 4, 0L, 0, 8 * 4));
        assertEquals(
            0x123456798ABCDEF0L, Conversion.boolsToLong(src, 0, 0x123456798ABCDEF0L, 0, 0));
        assertEquals(
            0x1234567876BCDEF0L,
            Conversion.boolsToLong(src, 15 * 4, 0x123456798ABCDEF0L, 24, 3 * 4));
    }

    /**
     * Tests {@link Conversion#boolsToInt(boolean[], int, int, int, int)}.
     */
    @Test
    public void testBoolsToInt() {
        boolean[] src = new boolean[]{
            false, false, true, true, true, false, true, true, true, true, true, true, true,
            false, false, false, true, true, true, true, false, false, false, false, false,
            false, true, true, true, false, false, false, false, false, false, false, true,
            true, true, true, true, false, false, false, false, true, false, false, true, true,
            false, false, false, false, true, false, true, false, true, false, false, true,
            true, false, true, true, true, false, false, false, false, true};
        // conversion of "CDF1F0C10F12345678" by hexsToBools
        assertEquals(0x00000000, Conversion.boolsToInt(src, 0 * 4, 0, 0, 0 * 4));
        assertEquals(0x0000000C, Conversion.boolsToInt(src, 0 * 4, 0, 0, 1 * 4));
        assertEquals(0x1C0F1FDC, Conversion.boolsToInt(src, 0 * 4, 0, 0, 8 * 4));
        assertEquals(0x01C0F1FD, Conversion.boolsToInt(src, 1 * 4, 0, 0, 8 * 4));
        assertEquals(0x12345679, Conversion.boolsToInt(src, 0 * 4, 0x12345679, 0, 0 * 4));
        assertEquals(0x87645679, Conversion.boolsToInt(src, 15 * 4, 0x12345679, 20, 3 * 4));
    }

    /**
     * Tests {@link Conversion#boolsToShort(boolean[], int, short, int, int)}.
     */
    @Test
    public void testBoolsToShort() {
        boolean[] src = new boolean[]{
            false, false, true, true, true, false, true, true, true, true, true, true, true,
            false, false, false, true, true, true, true, false, false, false, false, false,
            false, true, true, true, false, false, false, false, false, false, false, true,
            true, true, true, true, false, false, false, false, true, false, false, true, true,
            false, false, false, false, true, false, true, false, true, false, false, true,
            true, false, true, true, true, false, false, false, false, true};
        // conversion of "CDF1F0C10F12345678" by hexsToBools
        assertEquals((short)0x0000, Conversion.boolsToShort(src, 0 * 4, (short)0, 0, 0 * 4));
        assertEquals((short)0x000C, Conversion.boolsToShort(src, 0 * 4, (short)0, 0, 1 * 4));
        assertEquals((short)0x1FDC, Conversion.boolsToShort(src, 0 * 4, (short)0, 0, 4 * 4));
        assertEquals((short)0xF1FD, Conversion.boolsToShort(src, 1 * 4, (short)0, 0, 4 * 4));
        assertEquals(
            (short)0x1234, Conversion.boolsToShort(src, 0 * 4, (short)0x1234, 0, 0 * 4));
        assertEquals(
            (short)0x8764, Conversion.boolsToShort(src, 15 * 4, (short)0x1234, 4, 3 * 4));
    }

    /**
     * Tests {@link Conversion#boolsToByte(boolean[], int, byte, int, int)}.
     */
    @Test
    public void testBoolsToByte() {
        boolean[] src = new boolean[]{
            false, false, true, true, true, false, true, true, true, true, true, true, true,
            false, false, false, true, true, true, true, false, false, false, false, false,
            false, true, true, true, false, false, false, false, false, false, false, true,
            true, true, true, true, false, false, false, false, true, false, false, true, true,
            false, false, false, false, true, false, true, false, true, false, false, true,
            true, false, true, true, true, false, false, false, false, true};
        // conversion of "CDF1F0C10F12345678" by hexsToBools
        assertEquals((byte)0x00, Conversion.boolsToByte(src, 0 * 4, (byte)0, 0, 0 * 4));
        assertEquals((byte)0x0C, Conversion.boolsToByte(src, 0 * 4, (byte)0, 0, 1 * 4));
        assertEquals((byte)0xDC, Conversion.boolsToByte(src, 0 * 4, (byte)0, 0, 2 * 4));
        assertEquals((byte)0xFD, Conversion.boolsToByte(src, 1 * 4, (byte)0, 0, 2 * 4));
        assertEquals((byte)0x34, Conversion.boolsToByte(src, 0 * 4, (byte)0x34, 0, 0 * 4));
        assertEquals((byte)0x84, Conversion.boolsToByte(src, 17 * 4, (byte)0x34, 4, 1 * 4));
    }

    /**
     * Tests {@link Conversion#longToInts(long, int, int[], int, int)}.
     */
    @Test
    public void testLongToInts() {
        assertArrayEquals(
            new int[]{}, Conversion.longToInts(0x0000000000000000L, 0, new int[]{}, 0, 0));
        assertArrayEquals(
            new int[]{}, Conversion.longToInts(0x0000000000000000L, 100, new int[]{}, 0, 0));
        assertArrayEquals(
            new int[]{}, Conversion.longToInts(0x0000000000000000L, 0, new int[]{}, 100, 0));
        assertArrayEquals(
            new int[]{0xFFFFFFFF, 0xFFFFFFFF, 0xFFFFFFFF, 0xFFFFFFFF},
            Conversion.longToInts(0x1234567890ABCDEFL, 0, new int[]{-1, -1, -1, -1}, 0, 0));
        assertArrayEquals(
            new int[]{0x90ABCDEF, 0xFFFFFFFF, 0xFFFFFFFF, 0xFFFFFFFF},
            Conversion.longToInts(0x1234567890ABCDEFL, 0, new int[]{-1, -1, -1, -1}, 0, 1));
        assertArrayEquals(
            new int[]{0x90ABCDEF, 0x12345678, 0xFFFFFFFF, 0xFFFFFFFF},
            Conversion.longToInts(0x1234567890ABCDEFL, 0, new int[]{-1, -1, -1, -1}, 0, 2));
        // assertArrayEquals(new
        // int[]{0x90ABCDEF,0x12345678,0x90ABCDEF,0x12345678},Conversion.longToInts(0x1234567890ABCDEFL,
        // 0,new int[]{-1,-1,-1,-1},0,4));//rejected by assertion
        // assertArrayEquals(new
        // int[]{0xFFFFFFFF,0x90ABCDEF,0x12345678,0x90ABCDEF},Conversion.longToInts(0x1234567890ABCDEFL,
        // 0,new int[]{-1,-1,-1,-1},1,3));
        assertArrayEquals(
            new int[]{0xFFFFFFFF, 0xFFFFFFFF, 0x90ABCDEF, 0x12345678},
            Conversion.longToInts(0x1234567890ABCDEFL, 0, new int[]{-1, -1, -1, -1}, 2, 2));
        assertArrayEquals(
            new int[]{0xFFFFFFFF, 0xFFFFFFFF, 0x90ABCDEF, 0xFFFFFFFF},
            Conversion.longToInts(0x1234567890ABCDEFL, 0, new int[]{-1, -1, -1, -1}, 2, 1));
        assertArrayEquals(
            new int[]{0xFFFFFFFF, 0xFFFFFFFF, 0xFFFFFFFF, 0x90ABCDEF},
            Conversion.longToInts(0x1234567890ABCDEFL, 0, new int[]{-1, -1, -1, -1}, 3, 1));
        assertArrayEquals(
            new int[]{0xFFFFFFFF, 0xFFFFFFFF, 0x4855E6F7, 0xFFFFFFFF},
            Conversion.longToInts(0x1234567890ABCDEFL, 1, new int[]{-1, -1, -1, -1}, 2, 1));
        assertArrayEquals(
            new int[]{0xFFFFFFFF, 0xFFFFFFFF, 0x242AF37B, 0xFFFFFFFF},
            Conversion.longToInts(0x1234567890ABCDEFL, 2, new int[]{-1, -1, -1, -1}, 2, 1));
        assertArrayEquals(
            new int[]{0xFFFFFFFF, 0xFFFFFFFF, 0x121579BD, 0xFFFFFFFF},
            Conversion.longToInts(0x1234567890ABCDEFL, 3, new int[]{-1, -1, -1, -1}, 2, 1));
        assertArrayEquals(
            new int[]{0xFFFFFFFF, 0xFFFFFFFF, 0x890ABCDE, 0xFFFFFFFF},
            Conversion.longToInts(0x1234567890ABCDEFL, 4, new int[]{-1, -1, -1, -1}, 2, 1));
        // assertArrayEquals(new
        // int[]{0x4855E6F7,0x091A2B3C,0x4855E6F7,0x091A2B3C},Conversion.longToInts(0x1234567890ABCDEFL,
        // 1,new int[]{-1,-1,-1,-1},0,4));//rejected by assertion
        assertArrayEquals(
            new int[]{0x091A2B3C},
            Conversion.longToInts(0x1234567890ABCDEFL, 33, new int[]{0}, 0, 1));
    }

    /**
     * Tests {@link Conversion#longToShorts(long, int, short[], int, int)}.
     */
    @Test
    public void testLongToShorts() {
        assertArrayEquals(
            new short[]{}, Conversion.longToShorts(0x0000000000000000L, 0, new short[]{}, 0, 0));
        assertArrayEquals(
            new short[]{},
            Conversion.longToShorts(0x0000000000000000L, 100, new short[]{}, 0, 0));
        assertArrayEquals(
            new short[]{},
            Conversion.longToShorts(0x0000000000000000L, 0, new short[]{}, 100, 0));
        assertArrayEquals(
            new short[]{(short)0xFFFF, (short)0xFFFF, (short)0xFFFF, (short)0xFFFF},
            Conversion.longToShorts(0x1234567890ABCDEFL, 0, new short[]{-1, -1, -1, -1}, 0, 0));
        assertArrayEquals(
            new short[]{(short)0xCDEF, (short)0xFFFF, (short)0xFFFF, (short)0xFFFF},
            Conversion.longToShorts(0x1234567890ABCDEFL, 0, new short[]{-1, -1, -1, -1}, 0, 1));
        assertArrayEquals(
            new short[]{(short)0xCDEF, (short)0x90AB, (short)0xFFFF, (short)0xFFFF},
            Conversion.longToShorts(0x1234567890ABCDEFL, 0, new short[]{-1, -1, -1, -1}, 0, 2));
        assertArrayEquals(
            new short[]{(short)0xCDEF, (short)0x90AB, (short)0x5678, (short)0xFFFF},
            Conversion.longToShorts(0x1234567890ABCDEFL, 0, new short[]{-1, -1, -1, -1}, 0, 3));
        assertArrayEquals(
            new short[]{(short)0xCDEF, (short)0x90AB, (short)0x5678, (short)0x1234},
            Conversion.longToShorts(0x1234567890ABCDEFL, 0, new short[]{-1, -1, -1, -1}, 0, 4));
        assertArrayEquals(
            new short[]{(short)0xFFFF, (short)0xCDEF, (short)0x90AB, (short)0x5678},
            Conversion.longToShorts(0x1234567890ABCDEFL, 0, new short[]{-1, -1, -1, -1}, 1, 3));
        assertArrayEquals(
            new short[]{(short)0xFFFF, (short)0xFFFF, (short)0xCDEF, (short)0x90AB},
            Conversion.longToShorts(0x1234567890ABCDEFL, 0, new short[]{-1, -1, -1, -1}, 2, 2));
        assertArrayEquals(
            new short[]{(short)0xFFFF, (short)0xFFFF, (short)0xCDEF, (short)0xFFFF},
            Conversion.longToShorts(0x1234567890ABCDEFL, 0, new short[]{-1, -1, -1, -1}, 2, 1));
        assertArrayEquals(
            new short[]{(short)0xFFFF, (short)0xFFFF, (short)0xFFFF, (short)0xCDEF},
            Conversion.longToShorts(0x1234567890ABCDEFL, 0, new short[]{-1, -1, -1, -1}, 3, 1));
        assertArrayEquals(
            new short[]{(short)0xFFFF, (short)0xFFFF, (short)0xE6F7, (short)0xFFFF},
            Conversion.longToShorts(0x1234567890ABCDEFL, 1, new short[]{-1, -1, -1, -1}, 2, 1));
        assertArrayEquals(
            new short[]{(short)0xFFFF, (short)0xFFFF, (short)0xF37B, (short)0xFFFF},
            Conversion.longToShorts(0x1234567890ABCDEFL, 2, new short[]{-1, -1, -1, -1}, 2, 1));
        assertArrayEquals(
            new short[]{(short)0xFFFF, (short)0xFFFF, (short)0x79BD, (short)0xFFFF},
            Conversion.longToShorts(0x1234567890ABCDEFL, 3, new short[]{-1, -1, -1, -1}, 2, 1));
        assertArrayEquals(
            new short[]{(short)0xFFFF, (short)0xFFFF, (short)0xBCDE, (short)0xFFFF},
            Conversion.longToShorts(0x1234567890ABCDEFL, 4, new short[]{-1, -1, -1, -1}, 2, 1));
        assertArrayEquals(
            new short[]{(short)0xE6F7, (short)0x4855, (short)0x2B3C, (short)0x091A},
            Conversion.longToShorts(0x1234567890ABCDEFL, 1, new short[]{-1, -1, -1, -1}, 0, 4));
        assertArrayEquals(
            new short[]{(short)0x2B3C},
            Conversion.longToShorts(0x1234567890ABCDEFL, 33, new short[]{0}, 0, 1));
    }

    /**
     * Tests {@link Conversion#intToShorts(int, int, short[], int, int)}.
     */
    @Test
    public void testIntToShorts() {
        assertArrayEquals(
            new short[]{}, Conversion.intToShorts(0x00000000, 0, new short[]{}, 0, 0));
        assertArrayEquals(
            new short[]{}, Conversion.intToShorts(0x00000000, 100, new short[]{}, 0, 0));
        assertArrayEquals(
            new short[]{}, Conversion.intToShorts(0x00000000, 0, new short[]{}, 100, 0));
        assertArrayEquals(
            new short[]{(short)0xFFFF, (short)0xFFFF, (short)0xFFFF, (short)0xFFFF},
            Conversion.intToShorts(0x12345678, 0, new short[]{-1, -1, -1, -1}, 0, 0));
        assertArrayEquals(
            new short[]{(short)0x5678, (short)0xFFFF, (short)0xFFFF, (short)0xFFFF},
            Conversion.intToShorts(0x12345678, 0, new short[]{-1, -1, -1, -1}, 0, 1));
        assertArrayEquals(
            new short[]{(short)0x5678, (short)0x1234, (short)0xFFFF, (short)0xFFFF},
            Conversion.intToShorts(0x12345678, 0, new short[]{-1, -1, -1, -1}, 0, 2));
        // assertArrayEquals(new
        // short[]{(short)0x5678,(short)0x1234,(short)0x5678,(short)0xFFFF},Conversion.intToShorts(0x12345678,
        // 0,new short[]{-1,-1,-1,-1},0,3));//rejected by assertion
        // assertArrayEquals(new
        // short[]{(short)0x5678,(short)0x1234,(short)0x5678,(short)0x1234},Conversion.intToShorts(0x12345678,
        // 0,new short[]{-1,-1,-1,-1},0,4));
        // assertArrayEquals(new
        // short[]{(short)0xFFFF,(short)0x5678,(short)0x1234,(short)0x5678},Conversion.intToShorts(0x12345678,
        // 0,new short[]{-1,-1,-1,-1},1,3));
        assertArrayEquals(
            new short[]{(short)0xFFFF, (short)0xFFFF, (short)0x5678, (short)0x1234},
            Conversion.intToShorts(0x12345678, 0, new short[]{-1, -1, -1, -1}, 2, 2));
        assertArrayEquals(
            new short[]{(short)0xFFFF, (short)0xFFFF, (short)0x5678, (short)0xFFFF},
            Conversion.intToShorts(0x12345678, 0, new short[]{-1, -1, -1, -1}, 2, 1));
        assertArrayEquals(
            new short[]{(short)0xFFFF, (short)0xFFFF, (short)0xFFFF, (short)0x5678},
            Conversion.intToShorts(0x12345678, 0, new short[]{-1, -1, -1, -1}, 3, 1));
        assertArrayEquals(
            new short[]{(short)0xFFFF, (short)0xFFFF, (short)0x2B3C, (short)0xFFFF},
            Conversion.intToShorts(0x12345678, 1, new short[]{-1, -1, -1, -1}, 2, 1));
        assertArrayEquals(
            new short[]{(short)0xFFFF, (short)0xFFFF, (short)0x159E, (short)0xFFFF},
            Conversion.intToShorts(0x12345678, 2, new short[]{-1, -1, -1, -1}, 2, 1));
        assertArrayEquals(
            new short[]{(short)0xFFFF, (short)0xFFFF, (short)0x8ACF, (short)0xFFFF},
            Conversion.intToShorts(0x12345678, 3, new short[]{-1, -1, -1, -1}, 2, 1));
        assertArrayEquals(
            new short[]{(short)0xFFFF, (short)0xFFFF, (short)0x4567, (short)0xFFFF},
            Conversion.intToShorts(0x12345678, 4, new short[]{-1, -1, -1, -1}, 2, 1));
        // assertArrayEquals(new
        // short[]{(short)0xE6F7,(short)0x4855,(short)0x2B3C,(short)0x091A},Conversion.intToShorts(0x12345678,
        // 1,new short[]{-1,-1,-1,-1},0,4));//rejected by assertion
        // assertArrayEquals(new short[]{(short)0x2B3C},Conversion.intToShorts(0x12345678,33,new
        // short[]{0},0,1));//rejected by assertion
        assertArrayEquals(
            new short[]{(short)0x091A},
            Conversion.intToShorts(0x12345678, 17, new short[]{0}, 0, 1));
    }

    /**
     * Tests {@link Conversion#longToBytes(long, int, byte[], int, int)}.
     */
    @Test
    public void testLongToBytes() {
        assertArrayEquals(
            new byte[]{}, Conversion.longToBytes(0x0000000000000000L, 0, new byte[]{}, 0, 0));
        assertArrayEquals(
            new byte[]{}, Conversion.longToBytes(0x0000000000000000L, 100, new byte[]{}, 0, 0));
        assertArrayEquals(
            new byte[]{}, Conversion.longToBytes(0x0000000000000000L, 0, new byte[]{}, 100, 0));
        assertArrayEquals(
            new byte[]{
                (byte)0xFF, (byte)0xFF, (byte)0xFF, (byte)0xFF, (byte)0xFF, (byte)0xFF,
                (byte)0xFF, (byte)0xFF, (byte)0xFF, (byte)0xFF, (byte)0xFF},
            Conversion.longToBytes(0x1234567890ABCDEFL, 0, new byte[]{
                -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}, 0, 0));
        assertArrayEquals(
            new byte[]{
                (byte)0xEF, (byte)0xFF, (byte)0xFF, (byte)0xFF, (byte)0xFF, (byte)0xFF,
                (byte)0xFF, (byte)0xFF, (byte)0xFF, (byte)0xFF, (byte)0xFF},
            Conversion.longToBytes(0x1234567890ABCDEFL, 0, new byte[]{
                -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}, 0, 1));
        assertArrayEquals(
            new byte[]{
                (byte)0xEF, (byte)0xCD, (byte)0xFF, (byte)0xFF, (byte)0xFF, (byte)0xFF,
                (byte)0xFF, (byte)0xFF, (byte)0xFF, (byte)0xFF, (byte)0xFF},
            Conversion.longToBytes(0x1234567890ABCDEFL, 0, new byte[]{
                -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}, 0, 2));
        assertArrayEquals(
            new byte[]{
                (byte)0xEF, (byte)0xCD, (byte)0xAB, (byte)0x90, (byte)0xFF, (byte)0xFF,
                (byte)0xFF, (byte)0xFF, (byte)0xFF, (byte)0xFF, (byte)0xFF},
            Conversion.longToBytes(0x1234567890ABCDEFL, 0, new byte[]{
                -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}, 0, 4));
        assertArrayEquals(
            new byte[]{
                (byte)0xEF, (byte)0xCD, (byte)0xAB, (byte)0x90, (byte)0x78, (byte)0x56,
                (byte)0x34, (byte)0xFF, (byte)0xFF, (byte)0xFF, (byte)0xFF},
            Conversion.longToBytes(0x1234567890ABCDEFL, 0, new byte[]{
                -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}, 0, 7));
        assertArrayEquals(
            new byte[]{
                (byte)0xEF, (byte)0xCD, (byte)0xAB, (byte)0x90, (byte)0x78, (byte)0x56,
                (byte)0x34, (byte)0x12, (byte)0xFF, (byte)0xFF, (byte)0xFF},
            Conversion.longToBytes(0x1234567890ABCDEFL, 0, new byte[]{
                -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}, 0, 8));
        assertArrayEquals(
            new byte[]{
                (byte)0xFF, (byte)0xFF, (byte)0xFF, (byte)0xEF, (byte)0xFF, (byte)0xFF,
                (byte)0xFF, (byte)0xFF, (byte)0xFF, (byte)0xFF, (byte)0xFF},
            Conversion.longToBytes(0x1234567890ABCDEFL, 0, new byte[]{
                -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}, 3, 1));
        assertArrayEquals(
            new byte[]{
                (byte)0xFF, (byte)0xFF, (byte)0xFF, (byte)0xEF, (byte)0xCD, (byte)0xFF,
                (byte)0xFF, (byte)0xFF, (byte)0xFF, (byte)0xFF, (byte)0xFF},
            Conversion.longToBytes(0x1234567890ABCDEFL, 0, new byte[]{
                -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}, 3, 2));
        assertArrayEquals(
            new byte[]{
                (byte)0xFF, (byte)0xFF, (byte)0xFF, (byte)0xEF, (byte)0xCD, (byte)0xAB,
                (byte)0x90, (byte)0xFF, (byte)0xFF, (byte)0xFF, (byte)0xFF},
            Conversion.longToBytes(0x1234567890ABCDEFL, 0, new byte[]{
                -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}, 3, 4));
        assertArrayEquals(
            new byte[]{
                (byte)0xFF, (byte)0xFF, (byte)0xFF, (byte)0xEF, (byte)0xCD, (byte)0xAB,
                (byte)0x90, (byte)0x78, (byte)0x56, (byte)0x34, (byte)0xFF},
            Conversion.longToBytes(0x1234567890ABCDEFL, 0, new byte[]{
                -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}, 3, 7));
        assertArrayEquals(
            new byte[]{
                (byte)0xFF, (byte)0xFF, (byte)0xFF, (byte)0xEF, (byte)0xCD, (byte)0xAB,
                (byte)0x90, (byte)0x78, (byte)0x56, (byte)0x34, (byte)0x12},
            Conversion.longToBytes(0x1234567890ABCDEFL, 0, new byte[]{
                -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}, 3, 8));
        assertArrayEquals(
            new byte[]{
                (byte)0xF7, (byte)0xFF, (byte)0xFF, (byte)0xFF, (byte)0xFF, (byte)0xFF,
                (byte)0xFF, (byte)0xFF, (byte)0xFF, (byte)0xFF, (byte)0xFF},
            Conversion.longToBytes(0x1234567890ABCDEFL, 1, new byte[]{
                -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}, 0, 1));
        assertArrayEquals(
            new byte[]{
                (byte)0x7B, (byte)0xFF, (byte)0xFF, (byte)0xFF, (byte)0xFF, (byte)0xFF,
                (byte)0xFF, (byte)0xFF, (byte)0xFF, (byte)0xFF, (byte)0xFF},
            Conversion.longToBytes(0x1234567890ABCDEFL, 2, new byte[]{
                -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}, 0, 1));
        assertArrayEquals(
            new byte[]{
                (byte)0xFF, (byte)0x00, (byte)0xFF, (byte)0x6F, (byte)0x5E, (byte)0x85,
                (byte)0xC4, (byte)0xB3, (byte)0xA2, (byte)0x91, (byte)0x00},
            Conversion.longToBytes(0x1234567890ABCDEFL, 5, new byte[]{
                -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1}, 3, 8));
        // assertArrayEquals(new
        // byte[]{(byte)0xFF,(byte)0x00,(byte)0xFF,(byte)0x5E,(byte)0x85,(byte)0xC4,(byte)0xB3,(byte)0xA2,(byte)0x91,(byte)0x00,(byte)0x00},Conversion.longToBytes(0x1234567890ABCDEFL,13,new
        // byte[]{-1, 0,-1,-1,-1,-1,-1,-1,-1,-1,-1},3,8));//rejected by assertion
        assertArrayEquals(
            new byte[]{
                (byte)0xFF, (byte)0x00, (byte)0xFF, (byte)0x5E, (byte)0x85, (byte)0xC4,
                (byte)0xB3, (byte)0xA2, (byte)0x91, (byte)0x00, (byte)0xFF},
            Conversion.longToBytes(0x1234567890ABCDEFL, 13, new byte[]{
                -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1}, 3, 7));
    }

    /**
     * Tests {@link Conversion#intToBytes(int, int, byte[], int, int)}.
     */
    @Test
    public void testIntToBytes() {
        assertArrayEquals(
            new byte[]{}, Conversion.intToBytes(0x00000000, 0, new byte[]{}, 0, 0));
        assertArrayEquals(
            new byte[]{}, Conversion.intToBytes(0x00000000, 100, new byte[]{}, 0, 0));
        assertArrayEquals(
            new byte[]{}, Conversion.intToBytes(0x00000000, 0, new byte[]{}, 100, 0));
        assertArrayEquals(
            new byte[]{
                (byte)0xFF, (byte)0xFF, (byte)0xFF, (byte)0xFF, (byte)0xFF, (byte)0xFF,
                (byte)0xFF, (byte)0xFF, (byte)0xFF, (byte)0xFF, (byte)0xFF},
            Conversion.intToBytes(0x90ABCDEF, 0, new byte[]{
                -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}, 0, 0));
        assertArrayEquals(
            new byte[]{
                (byte)0xEF, (byte)0xFF, (byte)0xFF, (byte)0xFF, (byte)0xFF, (byte)0xFF,
                (byte)0xFF, (byte)0xFF, (byte)0xFF, (byte)0xFF, (byte)0xFF},
            Conversion.intToBytes(0x90ABCDEF, 0, new byte[]{
                -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}, 0, 1));
        assertArrayEquals(
            new byte[]{
                (byte)0xEF, (byte)0xCD, (byte)0xFF, (byte)0xFF, (byte)0xFF, (byte)0xFF,
                (byte)0xFF, (byte)0xFF, (byte)0xFF, (byte)0xFF, (byte)0xFF},
            Conversion.intToBytes(0x90ABCDEF, 0, new byte[]{
                -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}, 0, 2));
        assertArrayEquals(
            new byte[]{
                (byte)0xEF, (byte)0xCD, (byte)0xAB, (byte)0x90, (byte)0xFF, (byte)0xFF,
                (byte)0xFF, (byte)0xFF, (byte)0xFF, (byte)0xFF, (byte)0xFF},
            Conversion.intToBytes(0x90ABCDEF, 0, new byte[]{
                -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}, 0, 4));
        assertArrayEquals(
            new byte[]{
                (byte)0xFF, (byte)0xFF, (byte)0xFF, (byte)0xEF, (byte)0xFF, (byte)0xFF,
                (byte)0xFF, (byte)0xFF, (byte)0xFF, (byte)0xFF, (byte)0xFF},
            Conversion.intToBytes(0x90ABCDEF, 0, new byte[]{
                -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}, 3, 1));
        assertArrayEquals(
            new byte[]{
                (byte)0xFF, (byte)0xFF, (byte)0xFF, (byte)0xEF, (byte)0xCD, (byte)0xFF,
                (byte)0xFF, (byte)0xFF, (byte)0xFF, (byte)0xFF, (byte)0xFF},
            Conversion.intToBytes(0x90ABCDEF, 0, new byte[]{
                -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}, 3, 2));
        assertArrayEquals(
            new byte[]{
                (byte)0xFF, (byte)0xFF, (byte)0xFF, (byte)0xEF, (byte)0xCD, (byte)0xAB,
                (byte)0x90, (byte)0xFF, (byte)0xFF, (byte)0xFF, (byte)0xFF},
            Conversion.intToBytes(0x90ABCDEF, 0, new byte[]{
                -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}, 3, 4));
        assertArrayEquals(
            new byte[]{
                (byte)0xF7, (byte)0xFF, (byte)0xFF, (byte)0xFF, (byte)0xFF, (byte)0xFF,
                (byte)0xFF, (byte)0xFF, (byte)0xFF, (byte)0xFF, (byte)0xFF},
            Conversion.intToBytes(0x90ABCDEF, 1, new byte[]{
                -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}, 0, 1));
        assertArrayEquals(
            new byte[]{
                (byte)0x7B, (byte)0xFF, (byte)0xFF, (byte)0xFF, (byte)0xFF, (byte)0xFF,
                (byte)0xFF, (byte)0xFF, (byte)0xFF, (byte)0xFF, (byte)0xFF},
            Conversion.intToBytes(0x90ABCDEF, 2, new byte[]{
                -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}, 0, 1));
        assertArrayEquals(
            new byte[]{
                (byte)0xFF, (byte)0x00, (byte)0xFF, (byte)0x6F, (byte)0x5E, (byte)0x85,
                (byte)0xFC, (byte)0xFF, (byte)0xFF, (byte)0xFF, (byte)0xFF},
            Conversion.intToBytes(0x90ABCDEF, 5, new byte[]{
                -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1}, 3, 4));
        // assertArrayEquals(new
        // byte[]{(byte)0xFF,(byte)0x00,(byte)0xFF,(byte)0x5E,(byte)0x85,(byte)0xFC,(byte)0x00,(byte)0xFF,(byte)0xFF,(byte)0xFF,(byte)0xFF},Conversion.intToBytes(0x90ABCDEF,13,new
        // byte[]{-1, 0,-1,-1,-1,-1,-1,-1,-1,-1,-1},3,4));//rejected by assertion
        assertArrayEquals(
            new byte[]{
                (byte)0xFF, (byte)0x00, (byte)0xFF, (byte)0x5E, (byte)0x85, (byte)0xFC,
                (byte)0xFF, (byte)0xFF, (byte)0xFF, (byte)0xFF, (byte)0xFF},
            Conversion.intToBytes(0x90ABCDEF, 13, new byte[]{
                -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1}, 3, 3));
    }

    /**
     * Tests {@link Conversion#shortToBytes(short, int, byte[], int, int)}.
     */
    @Test
    public void testShortToBytes() {
        assertArrayEquals(
            new byte[]{}, Conversion.shortToBytes((short)0x0000, 0, new byte[]{}, 0, 0));
        assertArrayEquals(
            new byte[]{}, Conversion.shortToBytes((short)0x0000, 100, new byte[]{}, 0, 0));
        assertArrayEquals(
            new byte[]{}, Conversion.shortToBytes((short)0x0000, 0, new byte[]{}, 100, 0));
        assertArrayEquals(
            new byte[]{
                (byte)0xFF, (byte)0xFF, (byte)0xFF, (byte)0xFF, (byte)0xFF, (byte)0xFF,
                (byte)0xFF}, Conversion.shortToBytes((short)0xCDEF, 0, new byte[]{
                -1, -1, -1, -1, -1, -1, -1}, 0, 0));
        assertArrayEquals(
            new byte[]{
                (byte)0xEF, (byte)0xFF, (byte)0xFF, (byte)0xFF, (byte)0xFF, (byte)0xFF,
                (byte)0xFF}, Conversion.shortToBytes((short)0xCDEF, 0, new byte[]{
                -1, -1, -1, -1, -1, -1, -1}, 0, 1));
        assertArrayEquals(
            new byte[]{
                (byte)0xEF, (byte)0xCD, (byte)0xFF, (byte)0xFF, (byte)0xFF, (byte)0xFF,
                (byte)0xFF}, Conversion.shortToBytes((short)0xCDEF, 0, new byte[]{
                -1, -1, -1, -1, -1, -1, -1}, 0, 2));
        assertArrayEquals(
            new byte[]{
                (byte)0xFF, (byte)0xFF, (byte)0xFF, (byte)0xEF, (byte)0xFF, (byte)0xFF,
                (byte)0xFF}, Conversion.shortToBytes((short)0xCDEF, 0, new byte[]{
                -1, -1, -1, -1, -1, -1, -1}, 3, 1));
        assertArrayEquals(
            new byte[]{
                (byte)0xFF, (byte)0xFF, (byte)0xFF, (byte)0xEF, (byte)0xCD, (byte)0xFF,
                (byte)0xFF}, Conversion.shortToBytes((short)0xCDEF, 0, new byte[]{
                -1, -1, -1, -1, -1, -1, -1}, 3, 2));
        assertArrayEquals(
            new byte[]{
                (byte)0xF7, (byte)0xFF, (byte)0xFF, (byte)0xFF, (byte)0xFF, (byte)0xFF,
                (byte)0xFF}, Conversion.shortToBytes((short)0xCDEF, 1, new byte[]{
                -1, -1, -1, -1, -1, -1, -1}, 0, 1));
        assertArrayEquals(
            new byte[]{
                (byte)0x7B, (byte)0xFF, (byte)0xFF, (byte)0xFF, (byte)0xFF, (byte)0xFF,
                (byte)0xFF}, Conversion.shortToBytes((short)0xCDEF, 2, new byte[]{
                -1, -1, -1, -1, -1, -1, -1}, 0, 1));
        assertArrayEquals(
            new byte[]{
                (byte)0xFF, (byte)0x00, (byte)0xFF, (byte)0x6F, (byte)0xFE, (byte)0xFF,
                (byte)0xFF}, Conversion.shortToBytes((short)0xCDEF, 5, new byte[]{
                -1, 0, -1, -1, -1, -1, -1}, 3, 2));
        // assertArrayEquals(new
        // byte[]{(byte)0xFF,(byte)0x00,(byte)0xFF,(byte)0x5E,(byte)0xFF,(byte)0xFF,(byte)0xFF},Conversion.shortToBytes((short)0xCDEF,13,new
        // byte[]{-1, 0,-1,-1,-1,-1,-1},3,2));//rejected by assertion
        assertArrayEquals(
            new byte[]{
                (byte)0xFF, (byte)0x00, (byte)0xFF, (byte)0xFE, (byte)0xFF, (byte)0xFF,
                (byte)0xFF}, Conversion.shortToBytes((short)0xCDEF, 13, new byte[]{
                -1, 0, -1, -1, -1, -1, -1}, 3, 1));
    }

    /**
     * Tests {@link Conversion#longToHexs(long, int, String, int, int)}.
     */
    @Test
    public void testLongToHexs() {
        assertEquals("", Conversion.longToHexs(0x0000000000000000L, 0, "", 0, 0));
        assertEquals("", Conversion.longToHexs(0x0000000000000000L, 100, "", 0, 0));
        assertEquals("", Conversion.longToHexs(0x0000000000000000L, 0, "", 100, 0));
        assertEquals(
            "FFFFFFFFFFFFFFFFFFFFFFFF",
            Conversion.longToHexs(0x1234567890ABCDEFL, 0, "FFFFFFFFFFFFFFFFFFFFFFFF", 0, 0));
        assertEquals(
            "3FFFFFFFFFFFFFFFFFFFFFFF",
            Conversion.longToHexs(0x1234567890ABCDE3L, 0, "FFFFFFFFFFFFFFFFFFFFFFFF", 0, 1));
        assertEquals(
            "FEFFFFFFFFFFFFFFFFFFFFFF",
            Conversion.longToHexs(0x1234567890ABCDEFL, 0, "FFFFFFFFFFFFFFFFFFFFFFFF", 0, 2));
        assertEquals(
            "FEDCFFFFFFFFFFFFFFFFFFFF",
            Conversion.longToHexs(0x1234567890ABCDEFL, 0, "FFFFFFFFFFFFFFFFFFFFFFFF", 0, 4));
        assertEquals(
            "FEDCBA098765432FFFFFFFFF",
            Conversion.longToHexs(0x1234567890ABCDEFL, 0, "FFFFFFFFFFFFFFFFFFFFFFFF", 0, 15));
        assertEquals(
            "FEDCBA0987654321FFFFFFFF",
            Conversion.longToHexs(0x1234567890ABCDEFL, 0, "FFFFFFFFFFFFFFFFFFFFFFFF", 0, 16));
        assertEquals(
            "FFF3FFFFFFFFFFFFFFFFFFFF",
            Conversion.longToHexs(0x1234567890ABCDE3L, 0, "FFFFFFFFFFFFFFFFFFFFFFFF", 3, 1));
        assertEquals(
            "FFFFEFFFFFFFFFFFFFFFFFFF",
            Conversion.longToHexs(0x1234567890ABCDEFL, 0, "FFFFFFFFFFFFFFFFFFFFFFFF", 3, 2));
        assertEquals(
            "FFFFEDCFFFFFFFFFFFFFFFFF",
            Conversion.longToHexs(0x1234567890ABCDEFL, 0, "FFFFFFFFFFFFFFFFFFFFFFFF", 3, 4));
        assertEquals(
            "FFFFEDCBA098765432FFFFFF",
            Conversion.longToHexs(0x1234567890ABCDEFL, 0, "FFFFFFFFFFFFFFFFFFFFFFFF", 3, 15));
        assertEquals(
            "FFFFEDCBA0987654321FFFFF",
            Conversion.longToHexs(0x1234567890ABCDEFL, 0, "FFFFFFFFFFFFFFFFFFFFFFFF", 3, 16));
        assertEquals(
            "7FFFFFFFFFFFFFFFFFFFFFFF",
            Conversion.longToHexs(0x1234567890ABCDEFL, 1, "FFFFFFFFFFFFFFFFFFFFFFFF", 0, 1));
        assertEquals(
            "BFFFFFFFFFFFFFFFFFFFFFFF",
            Conversion.longToHexs(0x1234567890ABCDEFL, 2, "FFFFFFFFFFFFFFFFFFFFFFFF", 0, 1));
        assertEquals(
            "FFFDB975121FCA86420FFFFF",
            Conversion.longToHexs(0x1234567890ABCDEFL, 3, "FFFFFFFFFFFFFFFFFFFFFFFF", 3, 16));
        // assertEquals("FFFFFFFFFFFFFFFFFFFFFFFF",Conversion.longToHexs(0x1234567890ABCDEFL,4,"FFFFFFFFFFFFFFFFFFFFFFFF",3,16));//rejected
        // by assertion
        assertEquals(
            "FFFEDCBA0987654321FFFFFF",
            Conversion.longToHexs(0x1234567890ABCDEFL, 4, "FFFFFFFFFFFFFFFFFFFFFFFF", 3, 15));
    }

    /**
     * Tests {@link Conversion#intToHexs(int, int, String, int, int)}.
     */
    @Test
    public void testIntToHexs() {
        assertEquals("", Conversion.intToHexs(0x00000000, 0, "", 0, 0));
        assertEquals("", Conversion.intToHexs(0x00000000, 100, "", 0, 0));
        assertEquals("", Conversion.intToHexs(0x00000000, 0, "", 100, 0));
        assertEquals(
            "FFFFFFFFFFFFFFFFFFFFFFFF",
            Conversion.intToHexs(0x90ABCDEF, 0, "FFFFFFFFFFFFFFFFFFFFFFFF", 0, 0));
        assertEquals(
            "3FFFFFFFFFFFFFFFFFFFFFFF",
            Conversion.intToHexs(0x90ABCDE3, 0, "FFFFFFFFFFFFFFFFFFFFFFFF", 0, 1));
        assertEquals(
            "FEFFFFFFFFFFFFFFFFFFFFFF",
            Conversion.intToHexs(0x90ABCDEF, 0, "FFFFFFFFFFFFFFFFFFFFFFFF", 0, 2));
        assertEquals(
            "FEDCFFFFFFFFFFFFFFFFFFFF",
            Conversion.intToHexs(0x90ABCDEF, 0, "FFFFFFFFFFFFFFFFFFFFFFFF", 0, 4));
        assertEquals(
            "FEDCBA0FFFFFFFFFFFFFFFFF",
            Conversion.intToHexs(0x90ABCDEF, 0, "FFFFFFFFFFFFFFFFFFFFFFFF", 0, 7));
        assertEquals(
            "FEDCBA09FFFFFFFFFFFFFFFF",
            Conversion.intToHexs(0x90ABCDEF, 0, "FFFFFFFFFFFFFFFFFFFFFFFF", 0, 8));
        assertEquals(
            "FFF3FFFFFFFFFFFFFFFFFFFF",
            Conversion.intToHexs(0x90ABCDE3, 0, "FFFFFFFFFFFFFFFFFFFFFFFF", 3, 1));
        assertEquals(
            "FFFFEFFFFFFFFFFFFFFFFFFF",
            Conversion.intToHexs(0x90ABCDEF, 0, "FFFFFFFFFFFFFFFFFFFFFFFF", 3, 2));
        assertEquals(
            "FFFFEDCFFFFFFFFFFFFFFFFF",
            Conversion.intToHexs(0x90ABCDEF, 0, "FFFFFFFFFFFFFFFFFFFFFFFF", 3, 4));
        assertEquals(
            "FFFFEDCBA0FFFFFFFFFFFFFF",
            Conversion.intToHexs(0x90ABCDEF, 0, "FFFFFFFFFFFFFFFFFFFFFFFF", 3, 7));
        assertEquals(
            "FFFFEDCBA09FFFFFFFFFFFFF",
            Conversion.intToHexs(0x90ABCDEF, 0, "FFFFFFFFFFFFFFFFFFFFFFFF", 3, 8));
        assertEquals(
            "7FFFFFFFFFFFFFFFFFFFFFFF",
            Conversion.intToHexs(0x90ABCDEF, 1, "FFFFFFFFFFFFFFFFFFFFFFFF", 0, 1));
        assertEquals(
            "BFFFFFFFFFFFFFFFFFFFFFFF",
            Conversion.intToHexs(0x90ABCDEF, 2, "FFFFFFFFFFFFFFFFFFFFFFFF", 0, 1));
        assertEquals(
            "FFFDB97512FFFFFFFFFFFFFF",
            Conversion.intToHexs(0x90ABCDEF, 3, "FFFFFFFFFFFFFFFFFFFFFFFF", 3, 8));
        // assertEquals("FFFFFFFFFFFFFFFFFFFFFFFF",Conversion.intToHexs(0x90ABCDEF,
        // 4,"FFFFFFFFFFFFFFFFFFFFFFFF",3,8));//rejected by assertion
        assertEquals(
            "FFFEDCBA09FFFFFFFFFFFFFF",
            Conversion.intToHexs(0x90ABCDEF, 4, "FFFFFFFFFFFFFFFFFFFFFFFF", 3, 7));
    }

    /**
     * Tests {@link Conversion#shortToHexs(short, int, String, int, int)}.
     */
    @Test
    public void testShortToHexs() {
        assertEquals("", Conversion.shortToHexs((short)0x0000, 0, "", 0, 0));
        assertEquals("", Conversion.shortToHexs((short)0x0000, 100, "", 0, 0));
        assertEquals("", Conversion.shortToHexs((short)0x0000, 0, "", 100, 0));
        assertEquals(
            "FFFFFFFFFFFFFFFFFFFFFFFF",
            Conversion.shortToHexs((short)0xCDEF, 0, "FFFFFFFFFFFFFFFFFFFFFFFF", 0, 0));
        assertEquals(
            "3FFFFFFFFFFFFFFFFFFFFFFF",
            Conversion.shortToHexs((short)0xCDE3, 0, "FFFFFFFFFFFFFFFFFFFFFFFF", 0, 1));
        assertEquals(
            "FEFFFFFFFFFFFFFFFFFFFFFF",
            Conversion.shortToHexs((short)0xCDEF, 0, "FFFFFFFFFFFFFFFFFFFFFFFF", 0, 2));
        assertEquals(
            "FEDFFFFFFFFFFFFFFFFFFFFF",
            Conversion.shortToHexs((short)0xCDEF, 0, "FFFFFFFFFFFFFFFFFFFFFFFF", 0, 3));
        assertEquals(
            "FEDCFFFFFFFFFFFFFFFFFFFF",
            Conversion.shortToHexs((short)0xCDEF, 0, "FFFFFFFFFFFFFFFFFFFFFFFF", 0, 4));
        assertEquals(
            "FFF3FFFFFFFFFFFFFFFFFFFF",
            Conversion.shortToHexs((short)0xCDE3, 0, "FFFFFFFFFFFFFFFFFFFFFFFF", 3, 1));
        assertEquals(
            "FFFFEFFFFFFFFFFFFFFFFFFF",
            Conversion.shortToHexs((short)0xCDEF, 0, "FFFFFFFFFFFFFFFFFFFFFFFF", 3, 2));
        assertEquals(
            "7FFFFFFFFFFFFFFFFFFFFFFF",
            Conversion.shortToHexs((short)0xCDEF, 1, "FFFFFFFFFFFFFFFFFFFFFFFF", 0, 1));
        assertEquals(
            "BFFFFFFFFFFFFFFFFFFFFFFF",
            Conversion.shortToHexs((short)0xCDEF, 2, "FFFFFFFFFFFFFFFFFFFFFFFF", 0, 1));
        assertEquals(
            "FFFDB9FFFFFFFFFFFFFFFFFF",
            Conversion.shortToHexs((short)0xCDEF, 3, "FFFFFFFFFFFFFFFFFFFFFFFF", 3, 4));
        // assertEquals("FFFFFFFFFFFFFFFFFFFFFFFF",Conversion.shortToHexs((short)0xCDEF,
        // 4,"FFFFFFFFFFFFFFFFFFFFFFFF",3,4));//rejected by assertion
        assertEquals(
            "FFFEDCFFFFFFFFFFFFFFFFFF",
            Conversion.shortToHexs((short)0xCDEF, 4, "FFFFFFFFFFFFFFFFFFFFFFFF", 3, 3));
    }

    /**
     * Tests {@link Conversion#byteToHexs(byte, int, String, int, int)}.
     */
    @Test
    public void testByteToHexs() {
        assertEquals("", Conversion.byteToHexs((byte)0x00, 0, "", 0, 0));
        assertEquals("", Conversion.byteToHexs((byte)0x00, 100, "", 0, 0));
        assertEquals("", Conversion.byteToHexs((byte)0x00, 0, "", 100, 0));
        assertEquals("00000", Conversion.byteToHexs((byte)0xEF, 0, "00000", 0, 0));
        assertEquals("F0000", Conversion.byteToHexs((byte)0xEF, 0, "00000", 0, 1));
        assertEquals("FE000", Conversion.byteToHexs((byte)0xEF, 0, "00000", 0, 2));
        assertEquals("000F0", Conversion.byteToHexs((byte)0xEF, 0, "00000", 3, 1));
        assertEquals("000FE", Conversion.byteToHexs((byte)0xEF, 0, "00000", 3, 2));
        assertEquals("70000", Conversion.byteToHexs((byte)0xEF, 1, "00000", 0, 1));
        assertEquals("B0000", Conversion.byteToHexs((byte)0xEF, 2, "00000", 0, 1));
        assertEquals("000DF", Conversion.byteToHexs((byte)0xEF, 3, "00000", 3, 2));
        // assertEquals("00000",Conversion.byteToHexs((byte)0xEF, 4,"00000",3,2));//rejected by
        // assertion
        assertEquals("000E0", Conversion.byteToHexs((byte)0xEF, 4, "00000", 3, 1));
    }

    /**
     * Tests {@link Conversion#longToBools(long, int, boolean[], int, int)}.
     */
    @Test
    public void testLongToBools() {
        assertBoolArrayEquals(
            new boolean[]{},
            Conversion.longToBools(0x0000000000000000L, 0, new boolean[]{}, 0, 0));
        assertBoolArrayEquals(
            new boolean[]{},
            Conversion.longToBools(0x0000000000000000L, 100, new boolean[]{}, 0, 0));
        assertBoolArrayEquals(
            new boolean[]{},
            Conversion.longToBools(0x0000000000000000L, 0, new boolean[]{}, 100, 0));
        assertBoolArrayEquals(
            new boolean[69],
            Conversion.longToBools(0x1234567890ABCDEFL, 0, new boolean[69], 0, 0));

        assertBoolArrayEquals(
            new boolean[]{
                true, false, false, false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false, false, false, false,
                false, false, false},
            Conversion.longToBools(0x1234567890ABCDEFL, 0, new boolean[69], 0, 1));
        assertBoolArrayEquals(
            new boolean[]{
                true, true, false, false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false, false, false, false,
                false, false, false},
            Conversion.longToBools(0x1234567890ABCDEFL, 0, new boolean[69], 0, 2));
        assertBoolArrayEquals(
            new boolean[]{
                true, true, true, false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false, false, false, false,
                false, false, false},
            Conversion.longToBools(0x1234567890ABCDEFL, 0, new boolean[69], 0, 3));
        assertBoolArrayEquals(
            new boolean[]{
                true, true, true, true, false, true, true, true, true, false, true, true,
                false, false, true, true, true, true, false, true, false, true, false, true,
                false, false, false, false, true, false, false, true, false, false, false,
                true, true, true, true, false, false, true, true, false, true, false, true,
                false, false, false, true, false, true, true, false, false, false, true, false,
                false, true, false, false, false, false, false, false, false, false},
            Conversion.longToBools(0x1234567890ABCDEFL, 0, new boolean[69], 0, 63));
        assertBoolArrayEquals(
            new boolean[]{
                true, true, true, true, false, true, true, true, true, false, true, true,
                false, false, true, true, true, true, false, true, false, true, false, true,
                false, false, false, false, true, false, false, true, false, false, false,
                true, true, true, true, false, false, true, true, false, true, false, true,
                false, false, false, true, false, true, true, false, false, false, true, false,
                false, true, false, false, false, false, false, false, false, false},
            Conversion.longToBools(0x1234567890ABCDEFL, 0, new boolean[69], 0, 64));
        assertBoolArrayEquals(
            new boolean[]{
                false, false, true, false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false, false, false, false,
                false, false, false},
            Conversion.longToBools(0x1234567890ABCDEFL, 0, new boolean[69], 2, 1));
        assertBoolArrayEquals(
            new boolean[]{
                false, false, true, true, true, true, false, true, true, true, true, false,
                true, true, false, false, true, true, true, true, false, true, false, true,
                false, true, false, false, false, false, true, false, false, true, false,
                false, false, true, true, true, true, false, false, true, true, false, true,
                false, true, false, false, false, true, false, true, true, false, false, false,
                true, false, false, true, false, false, false, false, false, false},
            Conversion.longToBools(0x1234567890ABCDEFL, 0, new boolean[69], 2, 64));
        assertBoolArrayEquals(
            new boolean[]{
                true, true, true, false, true, true, true, true, false, true, true, false,
                false, true, true, true, true, false, true, false, true, false, true, false,
                false, false, false, true, false, false, true, false, false, false, true, true,
                true, true, false, false, true, true, false, true, false, true, false, false,
                false, true, false, true, true, false, false, false, true, false, false, true,
                false, false, false, false, false, false, false, false, false},
            Conversion.longToBools(0x1234567890ABCDEFL, 1, new boolean[69], 0, 63));
        assertBoolArrayEquals(
            new boolean[]{
                true, true, false, true, true, true, true, false, true, true, false, false,
                true, true, true, true, false, true, false, true, false, true, false, false,
                false, false, true, false, false, true, false, false, false, true, true, true,
                true, false, false, true, true, false, true, false, true, false, false, false,
                true, false, true, true, false, false, false, true, false, false, true, false,
                false, false, false, false, false, false, false, false, false},
            Conversion.longToBools(0x1234567890ABCDEFL, 2, new boolean[69], 0, 62));

        // assertBoolArrayEquals(new boolean[]{false,false,false, true, true, false, true, true,
        // true, true, false, true, true, false, false, true, true, true, true, false, true,
        // false, true, false, true, false, false, false, false, true, false, false, true,
        // false, false, false, true, true, true, true, false, false, true, true, false, true,
        // false, true, false, false, false, true, false, true, true, false, false, false, true,
        // false, false, true, false, false, false
        // ,false,false,false,false},Conversion.longToBools(0x1234567890ABCDEFL, 2,new
        // boolean[69], 3, 63));//rejected by assertion
        assertBoolArrayEquals(
            new boolean[]{
                false, false, false, true, true, false, true, true, true, true, false, true,
                true, false, false, true, true, true, true, false, true, false, true, false,
                true, false, false, false, false, true, false, false, true, false, false,
                false, true, true, true, true, false, false, true, true, false, true, false,
                true, false, false, false, true, false, true, true, false, false, false, true,
                false, false, true, false, false, false, false, false, false, false},
            Conversion.longToBools(0x1234567890ABCDEFL, 2, new boolean[69], 3, 62));
    }

    /**
     * Tests {@link Conversion#intToBools(int, int, boolean[], int, int)}.
     */
    @Test
    public void testIntToBools() {
        assertBoolArrayEquals(
            new boolean[]{}, Conversion.intToBools(0x00000000, 0, new boolean[]{}, 0, 0));
        assertBoolArrayEquals(
            new boolean[]{}, Conversion.intToBools(0x00000000, 100, new boolean[]{}, 0, 0));
        assertBoolArrayEquals(
            new boolean[]{}, Conversion.intToBools(0x00000000, 0, new boolean[]{}, 100, 0));
        assertBoolArrayEquals(
            new boolean[69], Conversion.intToBools(0x90ABCDEF, 0, new boolean[69], 0, 0));
        assertBoolArrayEquals(new boolean[]{
            true, false, false, false, false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, false, false, false, false, false,
            false}, Conversion.intToBools(0x90ABCDEF, 0, new boolean[37], 0, 1));
        assertBoolArrayEquals(new boolean[]{
            true, true, false, false, false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, false, false, false, false, false,
            false}, Conversion.intToBools(0x90ABCDEF, 0, new boolean[37], 0, 2));
        assertBoolArrayEquals(new boolean[]{
            true, true, true, false, false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, false, false, false, false, false,
            false}, Conversion.intToBools(0x90ABCDEF, 0, new boolean[37], 0, 3));
        assertBoolArrayEquals(
            new boolean[]{
                true, true, true, true, false, true, true, true, true, false, true, true,
                false, false, true, true, true, true, false, true, false, true, false, true,
                false, false, false, false, true, false, false, false, false, false, false,
                false, false}, Conversion.intToBools(0x90ABCDEF, 0, new boolean[37], 0, 31));
        assertBoolArrayEquals(
            new boolean[]{
                true, true, true, true, false, true, true, true, true, false, true, true,
                false, false, true, true, true, true, false, true, false, true, false, true,
                false, false, false, false, true, false, false, true, false, false, false,
                false, false}, Conversion.intToBools(0x90ABCDEF, 0, new boolean[37], 0, 32));
        assertBoolArrayEquals(new boolean[]{
            false, false, true, false, false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, false, false, false, false, false,
            false}, Conversion.intToBools(0x90ABCDEF, 0, new boolean[37], 2, 1));
        assertBoolArrayEquals(
            new boolean[]{
                false, false, true, true, true, true, false, true, true, true, true, false,
                true, true, false, false, true, true, true, true, false, true, false, true,
                false, true, false, false, false, false, true, false, false, true, false,
                false, false}, Conversion.intToBools(0x90ABCDEF, 0, new boolean[37], 2, 32));
        assertBoolArrayEquals(
            new boolean[]{
                true, true, true, false, true, true, true, true, false, true, true, false,
                false, true, true, true, true, false, true, false, true, false, true, false,
                false, false, false, true, false, false, true, false, false, false, false,
                false, false}, Conversion.intToBools(0x90ABCDEF, 1, new boolean[37], 0, 31));
        assertBoolArrayEquals(
            new boolean[]{
                true, true, false, true, true, true, true, false, true, true, false, false,
                true, true, true, true, false, true, false, true, false, true, false, false,
                false, false, true, false, false, true, false, false, false, false, false,
                false, false}, Conversion.intToBools(0x90ABCDEF, 2, new boolean[37], 0, 30));
        // assertBoolArrayEquals(new boolean[]{false, false, false, true, true, false, true,
        // true,
        // true, true, false, true, true, false, false, true, true, true, true, false, true,
        // false, true, false, true, false, false, false, false, true, false, false, false,
        // false, false, false, false},Conversion.intToBools(0x90ABCDEF, 2,new boolean[37],
        // 3,31));//rejected by assertion
        assertBoolArrayEquals(
            new boolean[]{
                false, false, false, true, true, false, true, true, true, true, false, true,
                true, false, false, true, true, true, true, false, true, false, true, false,
                true, false, false, false, false, true, false, false, true, false, false,
                false, false}, Conversion.intToBools(0x90ABCDEF, 2, new boolean[37], 3, 30));
    }

    /**
     * Tests {@link Conversion#shortToBools(short, int, boolean[], int, int)}.
     */
    @Test
    public void testShortToBools() {
        assertBoolArrayEquals(
            new boolean[]{}, Conversion.shortToBools((short)0x0000, 0, new boolean[]{}, 0, 0));
        assertBoolArrayEquals(
            new boolean[]{}, Conversion.shortToBools((short)0x0000, 100, new boolean[]{}, 0, 0));
        assertBoolArrayEquals(
            new boolean[]{}, Conversion.shortToBools((short)0x0000, 0, new boolean[]{}, 100, 0));
        assertBoolArrayEquals(
            new boolean[69], Conversion.shortToBools((short)0xCDEF, 0, new boolean[69], 0, 0));
        assertBoolArrayEquals(
            new boolean[]{
                true, false, false, false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false, false, false},
            Conversion.shortToBools((short)0xCDEF, 0, new boolean[21], 0, 1));
        assertBoolArrayEquals(
            new boolean[]{
                true, true, false, false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false, false, false},
            Conversion.shortToBools((short)0xCDEF, 0, new boolean[21], 0, 2));
        assertBoolArrayEquals(
            new boolean[]{
                true, true, true, false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false, false, false},
            Conversion.shortToBools((short)0xCDEF, 0, new boolean[21], 0, 3));
        assertBoolArrayEquals(
            new boolean[]{
                true, true, true, true, false, true, true, true, true, false, true, true,
                false, false, true, false, false, false, false, false, false},
            Conversion.shortToBools((short)0xCDEF, 0, new boolean[21], 0, 15));
        assertBoolArrayEquals(
            new boolean[]{
                true, true, true, true, false, true, true, true, true, false, true, true,
                false, false, true, true, false, false, false, false, false},
            Conversion.shortToBools((short)0xCDEF, 0, new boolean[21], 0, 16));
        assertBoolArrayEquals(
            new boolean[]{
                false, false, true, false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false, false, false},
            Conversion.shortToBools((short)0xCDEF, 0, new boolean[21], 2, 1));
        assertBoolArrayEquals(
            new boolean[]{
                false, false, true, true, true, true, false, true, true, true, true, false,
                true, true, false, false, true, true, false, false, false},
            Conversion.shortToBools((short)0xCDEF, 0, new boolean[21], 2, 16));
        assertBoolArrayEquals(
            new boolean[]{
                true, true, true, false, true, true, true, true, false, true, true, false,
                false, true, true, false, false, false, false, false, false},
            Conversion.shortToBools((short)0xCDEF, 1, new boolean[21], 0, 15));
        assertBoolArrayEquals(
            new boolean[]{
                true, true, false, true, true, true, true, false, true, true, false, false,
                true, true, false, false, false, false, false, false, false},
            Conversion.shortToBools((short)0xCDEF, 2, new boolean[21], 0, 14));
        // assertArrayEquals(new boolean[]{false, false, false, true, true, false, true, true,
        // true, true, false, true, true, false, false, true, false, false, false, false,
        // false},Conversion.shortToBools((short)0xCDEF, 2,new boolean[21], 3,15));//rejected by
        // assertion
        assertBoolArrayEquals(
            new boolean[]{
                false, false, false, true, true, false, true, true, true, true, false, true,
                true, false, false, true, true, false, false, false, false},
            Conversion.shortToBools((short)0xCDEF, 2, new boolean[21], 3, 14));
    }

    /**
     * Tests {@link Conversion#byteToBools(byte, int, boolean[], int, int)}.
     */
    @Test
    public void testByteToBools() {
        assertBoolArrayEquals(
            new boolean[]{}, Conversion.byteToBools((byte)0x00, 0, new boolean[]{}, 0, 0));
        assertBoolArrayEquals(
            new boolean[]{}, Conversion.byteToBools((byte)0x00, 100, new boolean[]{}, 0, 0));
        assertBoolArrayEquals(
            new boolean[]{}, Conversion.byteToBools((byte)0x00, 0, new boolean[]{}, 100, 0));
        assertBoolArrayEquals(
            new boolean[69], Conversion.byteToBools((byte)0xEF, 0, new boolean[69], 0, 0));
        assertBoolArrayEquals(new boolean[]{
            true, false, false, false, false, false, false, false, false, false, false, false,
            false}, Conversion.byteToBools((byte)0x95, 0, new boolean[13], 0, 1));
        assertBoolArrayEquals(new boolean[]{
            true, false, false, false, false, false, false, false, false, false, false, false,
            false}, Conversion.byteToBools((byte)0x95, 0, new boolean[13], 0, 2));
        assertBoolArrayEquals(new boolean[]{
            true, false, true, false, false, false, false, false, false, false, false, false,
            false}, Conversion.byteToBools((byte)0x95, 0, new boolean[13], 0, 3));
        assertBoolArrayEquals(new boolean[]{
            true, false, true, false, true, false, false, false, false, false, false, false,
            false}, Conversion.byteToBools((byte)0x95, 0, new boolean[13], 0, 7));
        assertBoolArrayEquals(new boolean[]{
            true, false, true, false, true, false, false, true, false, false, false, false,
            false}, Conversion.byteToBools((byte)0x95, 0, new boolean[13], 0, 8));
        assertBoolArrayEquals(new boolean[]{
            false, false, true, false, false, false, false, false, false, false, false, false,
            false}, Conversion.byteToBools((byte)0x95, 0, new boolean[13], 2, 1));
        assertBoolArrayEquals(new boolean[]{
            false, false, true, false, true, false, true, false, false, true, false, false,
            false}, Conversion.byteToBools((byte)0x95, 0, new boolean[13], 2, 8));
        assertBoolArrayEquals(new boolean[]{
            false, true, false, true, false, false, true, false, false, false, false, false,
            false}, Conversion.byteToBools((byte)0x95, 1, new boolean[13], 0, 7));
        assertBoolArrayEquals(new boolean[]{
            true, false, true, false, false, true, false, false, false, false, false, false,
            false}, Conversion.byteToBools((byte)0x95, 2, new boolean[13], 0, 6));
        // assertArrayEquals(new boolean[]{false, false, false, true, true, false, true, true,
        // false, false, false, false, false},Conversion.byteToBools((byte)0x95, 2,new
        // boolean[13], 3, 7));//rejected by assertion
        assertBoolArrayEquals(new boolean[]{
            false, false, false, true, false, true, false, false, true, false, false, false,
            false}, Conversion.byteToBools((byte)0x95, 2, new boolean[13], 3, 6));
    }
}
