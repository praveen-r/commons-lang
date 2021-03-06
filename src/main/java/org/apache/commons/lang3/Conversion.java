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

/**
 * <p>
 * Static methods to convert a type into another, with endianness and bit ordering awareness.
 * </p>
 * <p>
 * The methods names follow a naming rule:
 * </p>
 * 
 * <pre>
 * &ltsource type&gt[source endianness][source bit ordering]To&ltdestination type&gt[destination endianness][destination bit ordering]
 * Source/Destination type fields: either of the following. An 's' added at the end indicate an array
 *  - "bool"
 *  - "byte"
 *  - "int"
 *  - "long"
 *  - "Hex": a String containing hexadecimal digits
 *  - "HexDigit": a Char containing a hexadecimal digit
 * Endianness field: little endian is the default, in this case the field is absent. In case of big endian, the field is "Be".
 * Bit ordering: Lsb0 is the default, in this case the field is absent. In case of Msb0, the field is "M0".
 * 
 * Example: intBeM0ToHex convert an int with big endian byte order and Msb0 bit order into its hexadecimal string representation
 * </pre>
 * <p>
 * Most of the methods provide only default encoding for destination, this limits the number of
 * ways to do one thing. Unless you are dealing with data from/to outside of the JVM platform,
 * you should not need to use "Be" and "M0" methods.
 * </p>
 * <p>
 * Development status: work on going, only a part of the little endian, Lsb0 methods implemented
 * so far.
 * </p>
 * 
 * @since Lang 3.2
 * @version $Id$
 */

public class Conversion {
    /**
     * <p>
     * Converts a hexadecimal digit into an int using the default (Lsb0) bit ordering.
     * </p>
     * <p>
     * '1' is converted to 1
     * </p>
     * 
     * @param hexDigit the hexadecimal digit to convert
     * @return an int equals to <code>hexDigit</code>
     */
    public static int hexDigitToInt(char hexDigit) {
        switch (hexDigit) {
        case '0':
            return 0;
        case '1':
            return 1;
        case '2':
            return 2;
        case '3':
            return 3;
        case '4':
            return 4;
        case '5':
            return 5;
        case '6':
            return 6;
        case '7':
            return 7;
        case '8':
            return 8;
        case '9':
            return 9;
        case 'a':// fall through
        case 'A':
            return 10;
        case 'b':// fall through
        case 'B':
            return 11;
        case 'c':// fall through
        case 'C':
            return 12;
        case 'd':// fall through
        case 'D':
            return 13;
        case 'e':// fall through
        case 'E':
            return 14;
        case 'f':// fall through
        case 'F':
            return 15;
        default:
            throw new IllegalArgumentException("Cannot interpret '"
                + hexDigit
                + "' as a hexadecimal digit");
        }
    }

    /**
     * <p>
     * Converts a hexadecimal digit into an int using the Msb0 bit ordering.
     * </p>
     * <p>
     * '1' is converted to 8
     * </p>
     * 
     * @param hexDigit the hexadecimal digit to convert
     * @return an int equals to <code>hexDigit</code>
     */
    public static int hexDigitM0ToInt(char hexDigit) {
        switch (hexDigit) {
        case '0':
            return 0x0;
        case '1':
            return 0x8;
        case '2':
            return 0x4;
        case '3':
            return 0xC;
        case '4':
            return 0x2;
        case '5':
            return 0xA;
        case '6':
            return 0x6;
        case '7':
            return 0xE;
        case '8':
            return 0x1;
        case '9':
            return 0x9;
        case 'a':// fall through
        case 'A':
            return 0x5;
        case 'b':// fall through
        case 'B':
            return 0xD;
        case 'c':// fall through
        case 'C':
            return 0x3;
        case 'd':// fall through
        case 'D':
            return 0xB;
        case 'e':// fall through
        case 'E':
            return 0x7;
        case 'f':// fall through
        case 'F':
            return 0xF;
        default:
            throw new IllegalArgumentException("Cannot interpret '"
                + hexDigit
                + "' as a hexadecimal digit");
        }
    }

    /**
     * <p>
     * Converts a hexadecimal digit into binary using the default (Lsb0) bit ordering.
     * </p>
     * <p>
     * '1' is converted as follow: (1, 0, 0, 0)
     * </p>
     * 
     * @param hexDigit the hexadecimal digit to convert
     * @return a boolean array with the binary representation of <code>hexDigit</code>
     */
    public static boolean[] hexDigitToBools(char hexDigit) {
        switch (hexDigit) {
        case '0':
            return new boolean[]{false, false, false, false};
        case '1':
            return new boolean[]{true, false, false, false};
        case '2':
            return new boolean[]{false, true, false, false};
        case '3':
            return new boolean[]{true, true, false, false};
        case '4':
            return new boolean[]{false, false, true, false};
        case '5':
            return new boolean[]{true, false, true, false};
        case '6':
            return new boolean[]{false, true, true, false};
        case '7':
            return new boolean[]{true, true, true, false};
        case '8':
            return new boolean[]{false, false, false, true};
        case '9':
            return new boolean[]{true, false, false, true};
        case 'a':// fall through
        case 'A':
            return new boolean[]{false, true, false, true};
        case 'b':// fall through
        case 'B':
            return new boolean[]{true, true, false, true};
        case 'c':// fall through
        case 'C':
            return new boolean[]{false, false, true, true};
        case 'd':// fall through
        case 'D':
            return new boolean[]{true, false, true, true};
        case 'e':// fall through
        case 'E':
            return new boolean[]{false, true, true, true};
        case 'f':// fall through
        case 'F':
            return new boolean[]{true, true, true, true};
        default:
            throw new IllegalArgumentException("Cannot interpret '"
                + hexDigit
                + "' as a hexadecimal digit");
        }
    }

    /**
     * <p>
     * Converts a hexadecimal digit into binary using the Msb0 bit ordering.
     * </p>
     * <p>
     * '1' is converted as follow: (0, 0, 0, 1)
     * </p>
     * 
     * @param hexDigit the hexadecimal digit to convert
     * @return a boolean array with the binary representation of <code>hexDigit</code>
     */
    public static boolean[] hexDigitM0ToBools(char hexDigit) {
        switch (hexDigit) {
        case '0':
            return new boolean[]{false, false, false, false};
        case '1':
            return new boolean[]{false, false, false, true};
        case '2':
            return new boolean[]{false, false, true, false};
        case '3':
            return new boolean[]{false, false, true, true};
        case '4':
            return new boolean[]{false, true, false, false};
        case '5':
            return new boolean[]{false, true, false, true};
        case '6':
            return new boolean[]{false, true, true, false};
        case '7':
            return new boolean[]{false, true, true, true};
        case '8':
            return new boolean[]{true, false, false, false};
        case '9':
            return new boolean[]{true, false, false, true};
        case 'a':// fall through
        case 'A':
            return new boolean[]{true, false, true, false};
        case 'b':// fall through
        case 'B':
            return new boolean[]{true, false, true, true};
        case 'c':// fall through
        case 'C':
            return new boolean[]{true, true, false, false};
        case 'd':// fall through
        case 'D':
            return new boolean[]{true, true, false, true};
        case 'e':// fall through
        case 'E':
            return new boolean[]{true, true, true, false};
        case 'f':// fall through
        case 'F':
            return new boolean[]{true, true, true, true};
        default:
            throw new IllegalArgumentException("Cannot interpret '"
                + hexDigit
                + "' as a hexadecimal digit");
        }
    }

    /**
     * <p>
     * Converts a boolean array to a hexadecimal digit using the default (Lsb0) bit ordering.
     * </p>
     * <p>
     * (1, 0, 0, 0) is converted as follow: '1'
     * </p>
     * 
     * @param src the boolean array to convert
     * @return a hexadecimal digit representing the selected bits
     */
    public static char boolsToHexDigit(boolean[] src) {
        return boolsToHexDigit(src, 0);
    }

    /**
     * <p>
     * Converts a boolean array to a hexadecimal digit using the default (Lsb0) bit ordering.
     * </p>
     * <p>
     * (1, 0, 0, 0) is converted as follow: '1'
     * </p>
     * 
     * @param src the boolean array to convert
     * @param srcPos the position of the lsb to start the conversion
     * @return a hexadecimal digit representing the selected bits
     */
    public static char boolsToHexDigit(boolean[] src, int srcPos) {
        if (src.length > srcPos + 3 && src[srcPos + 3]) {
            if (src.length > srcPos + 2 && src[srcPos + 2]) {
                if (src.length > srcPos + 1 && src[srcPos + 1]) {
                    if (src[srcPos]) return 'F';
                    else return 'E';
                } else {
                    if (src[srcPos]) return 'D';
                    else return 'C';
                }
            } else {
                if (src.length > srcPos + 1 && src[srcPos + 1]) {
                    if (src[srcPos]) return 'B';
                    else return 'A';
                } else {
                    if (src[srcPos]) return '9';
                    else return '8';
                }
            }
        } else {
            if (src.length > srcPos + 2 && src[srcPos + 2]) {
                if (src.length > srcPos + 1 && src[srcPos + 1]) {
                    if (src[srcPos]) return '7';
                    else return '6';
                } else {
                    if (src[srcPos]) return '5';
                    else return '4';
                }
            } else {
                if (src.length > srcPos + 1 && src[srcPos + 1]) {
                    if (src[srcPos]) return '3';
                    else return '2';
                } else {
                    if (src[srcPos]) return '1';
                    else return '0';
                }
            }
        }
    }

    /**
     * <p>
     * Converts a boolean array to a hexadecimal digit using the Msb0 bit ordering.
     * </p>
     * <p>
     * (1, 0, 0, 0) is converted as follow: '8'
     * </p>
     * 
     * @param src the boolean array to convert
     * @return a hexadecimal digit representing the selected bits
     * @warning src.length must be >= 4.
     */
    public static char boolsToHexDigitM0_4bits(boolean[] src) {
        return boolsToHexDigitM0_4bits(src, 0);
    }

    /**
     * <p>
     * Converts a boolean array to a hexadecimal digit using the Msb0 bit ordering.
     * </p>
     * <p>
     * (1, 0, 0, 0) is converted as follow: '8' (1,0,0,1,1,0,1,0) with srcPos = 3 is converted
     * to 'D'
     * </p>
     * 
     * @param src the boolean array to convert
     * @param srcPos the position of the lsb to start the conversion
     * @return a hexadecimal digit representing the selected bits
     * @warning src.length must be 8 at most.
     * @warning srcPos+4 must be <= src.length.
     */
    public static char boolsToHexDigitM0_4bits(boolean[] src, int srcPos) {
        if (src.length > 8)
            throw new IllegalArgumentException("src.length>8: src.length=" + src.length);
        if (src.length - srcPos < 4)
            throw new IllegalArgumentException("src.length-srcPos<4: src.length="
                + src.length
                + ", srcPos="
                + srcPos);
        if (src[srcPos + 3]) {
            if (src[srcPos + 2]) {
                if (src[srcPos + 1]) {
                    if (src[srcPos]) return 'F';
                    else return '7';
                } else {
                    if (src[srcPos]) return 'B';
                    else return '3';
                }
            } else {
                if (src[srcPos + 1]) {
                    if (src[srcPos]) return 'D';
                    else return '5';
                } else {
                    if (src[srcPos]) return '9';
                    else return '1';
                }
            }
        } else {
            if (src[srcPos + 2]) {
                if (src[srcPos + 1]) {
                    if (src[srcPos]) return 'E';
                    else return '6';
                } else {
                    if (src[srcPos]) return 'A';
                    else return '2';
                }
            } else {
                if (src[srcPos + 1]) {
                    if (src[srcPos]) return 'C';
                    else return '4';
                } else {
                    if (src[srcPos]) return '8';
                    else return '0';
                }
            }
        }
    }

    /**
     * <p>
     * Converts the first 4 bits of a boolean array in big endian Msb0 bit ordering to a
     * hexadecimal digit.
     * </p>
     * <p>
     * (1, 0, 0, 0) is converted as follow: '8' (1,0,0,0,0,0,0,0, 0,0,0,0,0,1,0,0) is converted
     * to '4'
     * </p>
     * 
     * @param src the boolean array to convert
     * @return a hexadecimal digit representing the selected bits
     */
    public static char boolsBeM0ToHexDigit(boolean[] src) {
        return boolsBeM0ToHexDigit(src, 0);
    }

    /**
     * <p>
     * Converts a part of a boolean array in big endian Msb0 bit ordering to a hexadecimal
     * digit.
     * </p>
     * <p>
     * (1, 0, 0, 0) with srcPos = 0 is converted as follow: '8' (1,0,0,0,0,0,0,0,
     * 0,0,0,1,0,1,0,0) with srcPos = 2 is converted to '5'
     * </p>
     * 
     * @param src the boolean array to convert
     * @param srcPos the position of the lsb to start the conversion
     * @return a hexadecimal digit representing the selected bits
     */
    public static char boolsBeM0ToHexDigit(boolean[] src, int srcPos) {
        int beSrcPos = src.length - 1 - srcPos;
        int srcLen = Math.min(4, beSrcPos + 1);
        boolean[] paddedSrc = new boolean[4];
        System.arraycopy(src, beSrcPos + 1 - srcLen, paddedSrc, 4 - srcLen, srcLen);
        src = paddedSrc;
        srcPos = 0;
        if (src[srcPos]) {
            if (src.length > srcPos + 1 && src[srcPos + 1]) {
                if (src.length > srcPos + 2 && src[srcPos + 2]) {
                    if (src.length > srcPos + 3 && src[srcPos + 3]) return 'F';
                    else return 'E';
                } else {
                    if (src.length > srcPos + 3 && src[srcPos + 3]) return 'D';
                    else return 'C';
                }
            } else {
                if (src.length > srcPos + 2 && src[srcPos + 2]) {
                    if (src.length > srcPos + 3 && src[srcPos + 3]) return 'B';
                    else return 'A';
                } else {
                    if (src.length > srcPos + 3 && src[srcPos + 3]) return '9';
                    else return '8';
                }
            }
        } else {
            if (src.length > srcPos + 1 && src[srcPos + 1]) {
                if (src.length > srcPos + 2 && src[srcPos + 2]) {
                    if (src.length > srcPos + 3 && src[srcPos + 3]) return '7';
                    else return '6';
                } else {
                    if (src.length > srcPos + 3 && src[srcPos + 3]) return '5';
                    else return '4';
                }
            } else {
                if (src.length > srcPos + 2 && src[srcPos + 2]) {
                    if (src.length > srcPos + 3 && src[srcPos + 3]) return '3';
                    else return '2';
                } else {
                    if (src.length > srcPos + 3 && src[srcPos + 3]) return '1';
                    else return '0';
                }
            }
        }
    }

    /**
     * <p>
     * Converts the 4 lsb of an int to a hexadecimal digit.
     * </p>
     * <p>
     * 0 returns '0'
     * </p>
     * <p>
     * 1 returns '1'
     * </p>
     * <p>
     * 10 returns 'A' and so on...
     * </p>
     * 
     * @param nibble the int to convert, value outside of the range [0:15] are not allowed.
     * @return a hexadecimal digit representing the 4 lsb of <code>nibble</code>
     */
    public static char intToHexDigit(int nibble) {
        switch (nibble) {
        case 0x0:
            return '0';
        case 0x1:
            return '1';
        case 0x2:
            return '2';
        case 0x3:
            return '3';
        case 0x4:
            return '4';
        case 0x5:
            return '5';
        case 0x6:
            return '6';
        case 0x7:
            return '7';
        case 0x8:
            return '8';
        case 0x9:
            return '9';
        case 0xA:
            return 'A';
        case 0xB:
            return 'B';
        case 0xC:
            return 'C';
        case 0xD:
            return 'D';
        case 0xE:
            return 'E';
        case 0xF:
            return 'F';
        default:
            throw new IllegalArgumentException("nibble value not between 0 and 15: " + nibble);
        }
    }

    /**
     * <p>
     * Converts the 4 lsb of an int to a hexadecimal digit encoded using the Msb0 bit ordering.
     * </p>
     * <p>
     * 0 returns '0'
     * </p>
     * <p>
     * 1 returns '8'
     * </p>
     * <p>
     * 10 returns '5' and so on...
     * </p>
     * 
     * @param nibble the int to convert, value outside of the range [0:15] are not allowed.
     * @return a hexadecimal digit representing the 4 lsb of <code>nibble</code>
     */
    public static char intToHexDigitM0(int nibble) {
        switch (nibble) {
        case 0x0:
            return '0';
        case 0x1:
            return '8';
        case 0x2:
            return '4';
        case 0x3:
            return 'C';
        case 0x4:
            return '2';
        case 0x5:
            return 'A';
        case 0x6:
            return '6';
        case 0x7:
            return 'E';
        case 0x8:
            return '1';
        case 0x9:
            return '9';
        case 0xA:
            return '5';
        case 0xB:
            return 'D';
        case 0xC:
            return '3';
        case 0xD:
            return 'B';
        case 0xE:
            return '7';
        case 0xF:
            return 'F';
        default:
            throw new IllegalArgumentException("nibble value not between 0 and 15: " + nibble);
        }
    }

    /**
     * <p>
     * Converts an array of int into a long using the default (little endian, Lsb0) byte and bit
     * ordering.
     * </p>
     * 
     * @param src the int array to convert
     * @param srcPos the position in <code>src</code>, in int unit, from where to start the
     *            conversion
     * @param dstInit initial value of the destination long
     * @param dstPos the position of the lsb, in bits, in the result long
     * @param nInts the number of int to convert
     * @return a long containing the selected bits
     */
    public static long intsToLong(int[] src, int srcPos, long dstInit, int dstPos, int nInts) {
        if (0 == nInts) return dstInit;
        long out = dstInit;
        int shift = 0;
        for (int i = 0; i < nInts; i++ ) {
            shift = i * 32 + dstPos;
            long bits = ((0xffffffffL & src[i + srcPos]) << shift);
            long mask = (0xffffffffL << shift);
            out = ((out & ~mask) | bits);
        }
        if (shift >= 64)
            throw new IllegalArgumentException(
                "(nInts-1)*32+dstPos is greather or equal to than 64");
        return out;
    }

    /**
     * <p>
     * Converts an array of short into a long using the default (little endian, Lsb0) byte and
     * bit ordering.
     * </p>
     * 
     * @param src the int array to convert
     * @param srcPos the position in <code>src</code>, in short unit, from where to start the
     *            conversion
     * @param dstInit initial value of the destination long
     * @param dstPos the position of the lsb, in bits, in the result long
     * @param nShorts the number of short to convert
     * @return a long containing the selected bits
     */
    public static long shortsToLong(short[] src, int srcPos, long dstInit, int dstPos,
        int nShorts) {
        if (0 == nShorts) return dstInit;
        long out = dstInit;
        int shift = 0;
        for (int i = 0; i < nShorts; i++ ) {
            shift = i * 16 + dstPos;
            long bits = (0xffffL & src[i + srcPos]) << shift;
            long mask = 0xffffL << shift;
            out = (out & ~mask) | bits;
        }
        if (shift >= 64)
            throw new IllegalArgumentException(
                "(nShorts-1)*16+dstPos is greather or equal to than 64");
        return out;
    }

    /**
     * <p>
     * Converts an array of short into a int using the default (little endian, Lsb0) byte and
     * bit ordering.
     * </p>
     * 
     * @param src the int array to convert
     * @param srcPos the position in <code>src</code>, in short unit, from where to start the
     *            conversion
     * @param dstInit initial value of the destination int
     * @param dstPos the position of the lsb, in bits, in the result int
     * @param nShorts the number of short to convert
     * @return a int containing the selected bits
     */
    public static int shortsToInt(short[] src, int srcPos, int dstInit, int dstPos, int nShorts) {
        if (0 == nShorts) return dstInit;
        int out = dstInit;
        int shift = 0;
        for (int i = 0; i < nShorts; i++ ) {
            shift = i * 16 + dstPos;
            int bits = (0xffff & src[i + srcPos]) << shift;
            int mask = 0xffff << shift;
            out = (out & ~mask) | bits;
        }
        if (shift >= 32)
            throw new IllegalArgumentException(
                "(nShorts-1)*16+dstPos is greather or equal to than 32");
        return out;
    }

    /**
     * <p>
     * Converts an array of byte into a long using the default (little endian, Lsb0) byte and
     * bit ordering.
     * </p>
     * 
     * @param src the int array to convert
     * @param srcPos the position in <code>src</code>, in byte unit, from where to start the
     *            conversion
     * @param dstInit initial value of the destination long
     * @param dstPos the position of the lsb, in bits, in the result long
     * @param nBytes the number of byte to convert
     * @return a long containing the selected bits
     */
    public static long bytesToLong(byte[] src, int srcPos, long dstInit, int dstPos, int nBytes) {
        if (0 == nBytes) return dstInit;
        long out = dstInit;
        int shift = 0;
        for (int i = 0; i < nBytes; i++ ) {
            shift = i * 8 + dstPos;
            long bits = (0xffL & src[i + srcPos]) << shift;
            long mask = 0xffL << shift;
            out = (out & ~mask) | bits;
        }
        if (shift >= 64)
            throw new IllegalArgumentException(
                "(nBytes-1)*8+dstPos is greather or equal to than 64");
        return out;
    }

    /**
     * <p>
     * Converts an array of byte into a int using the default (little endian, Lsb0) byte and bit
     * ordering.
     * </p>
     * 
     * @param src the int array to convert
     * @param srcPos the position in <code>src</code>, in byte unit, from where to start the
     *            conversion
     * @param dstInit initial value of the destination int
     * @param dstPos the position of the lsb, in bits, in the result int
     * @param nBytes the number of byte to convert
     * @return a int containing the selected bits
     */
    public static int bytesToInt(byte[] src, int srcPos, int dstInit, int dstPos, int nBytes) {
        if (0 == nBytes) return dstInit;
        int out = dstInit;
        int shift = 0;
        for (int i = 0; i < nBytes; i++ ) {
            shift = i * 8 + dstPos;
            int bits = (0xff & src[i + srcPos]) << shift;
            int mask = 0xff << shift;
            out = (out & ~mask) | bits;
        }
        if (shift >= 32)
            throw new IllegalArgumentException(
                "(nBytes-1)*8+dstPos is greather or equal to than 32");
        return out;
    }

    /**
     * <p>
     * Converts an array of byte into a short using the default (little endian, Lsb0) byte and
     * bit ordering.
     * </p>
     * 
     * @param src the int array to convert
     * @param srcPos the position in <code>src</code>, in byte unit, from where to start the
     *            conversion
     * @param dstInit initial value of the destination short
     * @param dstPos the position of the lsb, in bits, in the result short
     * @param nBytes the number of byte to convert
     * @return a short containing the selected bits
     */
    public static short bytesToShort(byte[] src, int srcPos, short dstInit, int dstPos,
        int nBytes) {
        if (0 == nBytes) return dstInit;
        short out = dstInit;
        int shift = 0;
        for (int i = 0; i < nBytes; i++ ) {
            shift = i * 8 + dstPos;
            int bits = (0xff & src[i + srcPos]) << shift;
            int mask = 0xff << shift;
            out = (short)((out & ~mask) | bits);
        }
        if (shift >= 16)
            throw new IllegalArgumentException(
                "(nBytes-1)*8+dstPos is greather or equal to than 16");
        return out;
    }

    /**
     * <p>
     * Converts an array of Char into a long using the default (little endian, Lsb0) byte and
     * bit ordering.
     * </p>
     * 
     * @param src the int array to convert
     * @param srcPos the position in <code>src</code>, in Char unit, from where to start the
     *            conversion
     * @param dstInit initial value of the destination long
     * @param dstPos the position of the lsb, in bits, in the result long
     * @param nHexs the number of Char to convert
     * @return a long containing the selected bits
     */
    public static long hexsToLong(String src, int srcPos, long dstInit, int dstPos, int nHexs) {
        if (0 == nHexs) return dstInit;
        long out = dstInit;
        int shift = 0;
        for (int i = 0; i < nHexs; i++ ) {
            shift = i * 4 + dstPos;
            long bits = (0xfL & hexDigitToInt(src.charAt(i + srcPos))) << shift;
            long mask = 0xfL << shift;
            out = (out & ~mask) | bits;
        }
        if (shift >= 64)
            throw new IllegalArgumentException(
                "(nHexs-1)*4+dstPos is greather or equal to than 64");
        return out;
    }

    /**
     * <p>
     * Converts an array of Char into a int using the default (little endian, Lsb0) byte and bit
     * ordering.
     * </p>
     * 
     * @param src the int array to convert
     * @param srcPos the position in <code>src</code>, in Char unit, from where to start the
     *            conversion
     * @param dstInit initial value of the destination int
     * @param dstPos the position of the lsb, in bits, in the result int
     * @param nHexs the number of Char to convert
     * @return a int containing the selected bits
     */
    public static int hexsToInt(String src, int srcPos, int dstInit, int dstPos, int nHexs) {
        if (0 == nHexs) return dstInit;
        int out = dstInit;
        int shift = 0;
        for (int i = 0; i < nHexs; i++ ) {
            shift = i * 4 + dstPos;
            int bits = (0xf & hexDigitToInt(src.charAt(i + srcPos))) << shift;
            int mask = 0xf << shift;
            out = (out & ~mask) | bits;
        }
        if (shift >= 32)
            throw new IllegalArgumentException(
                "(nHexs-1)*4+dstPos is greather or equal to than 32");
        return out;
    }

    /**
     * <p>
     * Converts an array of Char into a short using the default (little endian, Lsb0) byte and
     * bit ordering.
     * </p>
     * 
     * @param src the int array to convert
     * @param srcPos the position in <code>src</code>, in Char unit, from where to start the
     *            conversion
     * @param dstInit initial value of the destination short
     * @param dstPos the position of the lsb, in bits, in the result short
     * @param nHexs the number of Char to convert
     * @return a short containing the selected bits
     */
    public static short hexsToShort(String src, int srcPos, short dstInit, int dstPos, int nHexs) {
        if (0 == nHexs) return dstInit;
        short out = dstInit;
        int shift = 0;
        for (int i = 0; i < nHexs; i++ ) {
            shift = i * 4 + dstPos;
            int bits = (0xf & hexDigitToInt(src.charAt(i + srcPos))) << shift;
            int mask = 0xf << shift;
            out = (short)((out & ~mask) | bits);
        }
        if (shift >= 16)
            throw new IllegalArgumentException(
                "(nHexs-1)*4+dstPos is greather or equal to than 16");
        return out;
    }

    /**
     * <p>
     * Converts an array of Char into a byte using the default (little endian, Lsb0) byte and
     * bit ordering.
     * </p>
     * 
     * @param src the int array to convert
     * @param srcPos the position in <code>src</code>, in Char unit, from where to start the
     *            conversion
     * @param dstInit initial value of the destination byte
     * @param dstPos the position of the lsb, in bits, in the result byte
     * @param nHexs the number of Char to convert
     * @return a byte containing the selected bits
     */
    public static byte hexsToByte(String src, int srcPos, byte dstInit, int dstPos, int nHexs) {
        if (0 == nHexs) return dstInit;
        byte out = dstInit;
        int shift = 0;
        for (int i = 0; i < nHexs; i++ ) {
            shift = i * 4 + dstPos;
            int bits = (0xf & hexDigitToInt(src.charAt(i + srcPos))) << shift;
            int mask = 0xf << shift;
            out = (byte)((out & ~mask) | bits);
        }
        if (shift >= 8)
            throw new IllegalArgumentException(
                "(nHexs-1)*4+dstPos is greather or equal to than 8");
        return out;
    }

    /**
     * <p>
     * Converts an array of boolean into a long using the default (little endian, Lsb0) byte and
     * bit ordering.
     * </p>
     * 
     * @param src the int array to convert
     * @param srcPos the position in <code>src</code>, in boolean unit, from where to start the
     *            conversion
     * @param dstInit initial value of the destination long
     * @param dstPos the position of the lsb, in bits, in the result long
     * @param nBools the number of boolean to convert
     * @return a long containing the selected bits
     */
    public static long boolsToLong(boolean[] src, int srcPos, long dstInit, int dstPos,
        int nBools) {
        if (0 == nBools) return dstInit;
        long out = dstInit;
        int shift = 0;
        for (int i = 0; i < nBools; i++ ) {
            shift = i * 1 + dstPos;
            long bits = (0x1L & ((src[i + srcPos]) ? 1 : 0)) << shift;
            long mask = 0x1L << shift;
            out = (out & ~mask) | bits;
        }
        if (shift >= 64)
            throw new IllegalArgumentException(
                "(nBools-1)*1+dstPos is greather or equal to than 64");
        return out;
    }

    /**
     * <p>
     * Converts an array of boolean into a int using the default (little endian, Lsb0) byte and
     * bit ordering.
     * </p>
     * 
     * @param src the int array to convert
     * @param srcPos the position in <code>src</code>, in boolean unit, from where to start the
     *            conversion
     * @param dstInit initial value of the destination int
     * @param dstPos the position of the lsb, in bits, in the result int
     * @param nBools the number of boolean to convert
     * @return a int containing the selected bits
     */
    public static int boolsToInt(boolean[] src, int srcPos, int dstInit, int dstPos, int nBools) {
        if (0 == nBools) return dstInit;
        int out = dstInit;
        int shift = 0;
        for (int i = 0; i < nBools; i++ ) {
            shift = i * 1 + dstPos;
            int bits = (0x1 & ((src[i + srcPos]) ? 1 : 0)) << shift;
            int mask = 0x1 << shift;
            out = (out & ~mask) | bits;
        }
        if (shift >= 32)
            throw new IllegalArgumentException(
                "(nBools-1)*1+dstPos is greather or equal to than 32");
        return out;
    }

    /**
     * <p>
     * Converts an array of boolean into a short using the default (little endian, Lsb0) byte
     * and bit ordering.
     * </p>
     * 
     * @param src the int array to convert
     * @param srcPos the position in <code>src</code>, in boolean unit, from where to start the
     *            conversion
     * @param dstInit initial value of the destination short
     * @param dstPos the position of the lsb, in bits, in the result short
     * @param nBools the number of boolean to convert
     * @return a short containing the selected bits
     */
    public static short boolsToShort(boolean[] src, int srcPos, short dstInit, int dstPos,
        int nBools) {
        if (0 == nBools) return dstInit;
        short out = dstInit;
        int shift = 0;
        for (int i = 0; i < nBools; i++ ) {
            shift = i * 1 + dstPos;
            int bits = (0x1 & ((src[i + srcPos]) ? 1 : 0)) << shift;
            int mask = 0x1 << shift;
            out = (short)((out & ~mask) | bits);
        }
        if (shift >= 16)
            throw new IllegalArgumentException(
                "(nBools-1)*1+dstPos is greather or equal to than 16");
        return out;
    }

    /**
     * <p>
     * Converts an array of boolean into a byte using the default (little endian, Lsb0) byte and
     * bit ordering.
     * </p>
     * 
     * @param src the int array to convert
     * @param srcPos the position in <code>src</code>, in boolean unit, from where to start the
     *            conversion
     * @param dstInit initial value of the destination byte
     * @param dstPos the position of the lsb, in bits, in the result byte
     * @param nBools the number of boolean to convert
     * @return a byte containing the selected bits
     */
    public static byte boolsToByte(boolean[] src, int srcPos, byte dstInit, int dstPos,
        int nBools) {
        if (0 == nBools) return dstInit;
        byte out = dstInit;
        int shift = 0;
        for (int i = 0; i < nBools; i++ ) {
            shift = i * 1 + dstPos;
            int bits = (0x1 & ((src[i + srcPos]) ? 1 : 0)) << shift;
            int mask = 0x1 << shift;
            out = (byte)((out & ~mask) | bits);
        }
        if (shift >= 8)
            throw new IllegalArgumentException(
                "(nBools-1)*1+dstPos is greather or equal to than 8");
        return out;
    }

    /**
     * <p>
     * Converts a long into an array of int using the default (little endian, Lsb0) byte and bit
     * ordering.
     * </p>
     * 
     * @param src the long to convert
     * @param srcPos the position in <code>src</code>, in bits, from where to start the
     *            conversion
     * @param dst the destination array
     * @param dstPos the position in <code>dst</code> where to copy the result
     * @param nInts the number of int to copy to <code>dst</code>. must be smaller or equal to
     *            the width of the input (from srcPos to msb)
     * @return <code>dst</code>
     */
    public static int[] longToInts(long src, int srcPos, int[] dst, int dstPos, int nInts) {
        if (0 == nInts) return dst;
        int shift = 0;
        assert ((nInts - 1) * 32 < 64 - srcPos);
        for (int i = 0; i < nInts; i++ ) {
            shift = i * 32 + srcPos;
            dst[dstPos + i] = (int)(0xffffffff & (src >> shift));
        }
        return dst;
    }

    /**
     * <p>
     * Converts a long into an array of short using the default (little endian, Lsb0) byte and
     * bit ordering.
     * </p>
     * 
     * @param src the long to convert
     * @param srcPos the position in <code>src</code>, in bits, from where to start the
     *            conversion
     * @param dst the destination array
     * @param dstPos the position in <code>dst</code> where to copy the result
     * @param nShorts the number of short to copy to <code>dst</code>. must be smaller or equal
     *            to the width of the input (from srcPos to msb)
     * @return <code>dst</code>
     */
    public static short[] longToShorts(long src, int srcPos, short[] dst, int dstPos,
        int nShorts) {
        if (0 == nShorts) return dst;
        int shift = 0;
        assert ((nShorts - 1) * 16 < 64 - srcPos);
        for (int i = 0; i < nShorts; i++ ) {
            shift = i * 16 + srcPos;
            dst[dstPos + i] = (short)(0xffff & (src >> shift));
        }
        return dst;
    }

    /**
     * <p>
     * Converts a int into an array of short using the default (little endian, Lsb0) byte and
     * bit ordering.
     * </p>
     * 
     * @param src the int to convert
     * @param srcPos the position in <code>src</code>, in bits, from where to start the
     *            conversion
     * @param dst the destination array
     * @param dstPos the position in <code>dst</code> where to copy the result
     * @param nShorts the number of short to copy to <code>dst</code>. must be smaller or equal
     *            to the width of the input (from srcPos to msb)
     * @return <code>dst</code>
     */
    public static short[] intToShorts(int src, int srcPos, short[] dst, int dstPos, int nShorts) {
        if (0 == nShorts) return dst;
        int shift = 0;
        assert ((nShorts - 1) * 16 < 32 - srcPos);
        for (int i = 0; i < nShorts; i++ ) {
            shift = i * 16 + srcPos;
            dst[dstPos + i] = (short)(0xffff & (src >> shift));
        }
        return dst;
    }

    /**
     * <p>
     * Converts a long into an array of byte using the default (little endian, Lsb0) byte and
     * bit ordering.
     * </p>
     * 
     * @param src the long to convert
     * @param srcPos the position in <code>src</code>, in bits, from where to start the
     *            conversion
     * @param dst the destination array
     * @param dstPos the position in <code>dst</code> where to copy the result
     * @param nBytes the number of byte to copy to <code>dst</code>. must be smaller or equal to
     *            the width of the input (from srcPos to msb)
     * @return <code>dst</code>
     */
    public static byte[] longToBytes(long src, int srcPos, byte[] dst, int dstPos, int nBytes) {
        if (0 == nBytes) return dst;
        int shift = 0;
        assert ((nBytes - 1) * 8 < 64 - srcPos);
        for (int i = 0; i < nBytes; i++ ) {
            shift = i * 8 + srcPos;
            dst[dstPos + i] = (byte)(0xff & (src >> shift));
        }
        return dst;
    }

    /**
     * <p>
     * Converts a int into an array of byte using the default (little endian, Lsb0) byte and bit
     * ordering.
     * </p>
     * 
     * @param src the int to convert
     * @param srcPos the position in <code>src</code>, in bits, from where to start the
     *            conversion
     * @param dst the destination array
     * @param dstPos the position in <code>dst</code> where to copy the result
     * @param nBytes the number of byte to copy to <code>dst</code>. must be smaller or equal to
     *            the width of the input (from srcPos to msb)
     * @return <code>dst</code>
     */
    public static byte[] intToBytes(int src, int srcPos, byte[] dst, int dstPos, int nBytes) {
        if (0 == nBytes) return dst;
        int shift = 0;
        assert ((nBytes - 1) * 8 < 32 - srcPos);
        for (int i = 0; i < nBytes; i++ ) {
            shift = i * 8 + srcPos;
            dst[dstPos + i] = (byte)(0xff & (src >> shift));
        }
        return dst;
    }

    /**
     * <p>
     * Converts a short into an array of byte using the default (little endian, Lsb0) byte and
     * bit ordering.
     * </p>
     * 
     * @param src the short to convert
     * @param srcPos the position in <code>src</code>, in bits, from where to start the
     *            conversion
     * @param dst the destination array
     * @param dstPos the position in <code>dst</code> where to copy the result
     * @param nBytes the number of byte to copy to <code>dst</code>. must be smaller or equal to
     *            the width of the input (from srcPos to msb)
     * @return <code>dst</code>
     */
    public static byte[] shortToBytes(short src, int srcPos, byte[] dst, int dstPos, int nBytes) {
        if (0 == nBytes) return dst;
        int shift = 0;
        assert ((nBytes - 1) * 8 < 16 - srcPos);
        for (int i = 0; i < nBytes; i++ ) {
            shift = i * 8 + srcPos;
            dst[dstPos + i] = (byte)(0xff & (src >> shift));
        }
        return dst;
    }

    /**
     * <p>
     * Converts a long into an array of Char using the default (little endian, Lsb0) byte and
     * bit ordering.
     * </p>
     * 
     * @param src the long to convert
     * @param srcPos the position in <code>src</code>, in bits, from where to start the
     *            conversion
     * @param dstInit the initial value for the result String
     * @param dstPos the position in <code>dst</code> where to copy the result
     * @param nHexs the number of Char to copy to <code>dst</code>. must be smaller or equal to
     *            the width of the input (from srcPos to msb)
     * @return <code>dst</code>
     */
    public static String longToHexs(long src, int srcPos, String dstInit, int dstPos, int nHexs) {
        if (0 == nHexs) return dstInit;
        StringBuilder sb = new StringBuilder(dstInit);
        int shift = 0;
        assert ((nHexs - 1) * 4 < 64 - srcPos);
        for (int i = 0; i < nHexs; i++ ) {
            shift = i * 4 + srcPos;
            int bits = (int)(0xF & (src >> shift));
            sb.setCharAt(dstPos + i, intToHexDigit(bits));
        }
        return sb.toString();
    }

    /**
     * <p>
     * Converts a int into an array of Char using the default (little endian, Lsb0) byte and bit
     * ordering.
     * </p>
     * 
     * @param src the int to convert
     * @param srcPos the position in <code>src</code>, in bits, from where to start the
     *            conversion
     * @param dstInit the initial value for the result String
     * @param dstPos the position in <code>dst</code> where to copy the result
     * @param nHexs the number of Char to copy to <code>dst</code>. must be smaller or equal to
     *            the width of the input (from srcPos to msb)
     * @return <code>dst</code>
     */
    public static String intToHexs(int src, int srcPos, String dstInit, int dstPos, int nHexs) {
        if (0 == nHexs) return dstInit;
        StringBuilder sb = new StringBuilder(dstInit);
        int shift = 0;
        assert ((nHexs - 1) * 4 < 32 - srcPos);
        for (int i = 0; i < nHexs; i++ ) {
            shift = i * 4 + srcPos;
            int bits = 0xF & (src >> shift);
            sb.setCharAt(dstPos + i, intToHexDigit(bits));
        }
        return sb.toString();
    }

    /**
     * <p>
     * Converts a short into an array of Char using the default (little endian, Lsb0) byte and
     * bit ordering.
     * </p>
     * 
     * @param src the short to convert
     * @param srcPos the position in <code>src</code>, in bits, from where to start the
     *            conversion
     * @param dstInit the initial value for the result String
     * @param dstPos the position in <code>dst</code> where to copy the result
     * @param nHexs the number of Char to copy to <code>dst</code>. must be smaller or equal to
     *            the width of the input (from srcPos to msb)
     * @return <code>dst</code>
     */
    public static String shortToHexs(short src, int srcPos, String dstInit, int dstPos,
        int nHexs) {
        if (0 == nHexs) return dstInit;
        StringBuilder sb = new StringBuilder(dstInit);
        int shift = 0;
        assert ((nHexs - 1) * 4 < 16 - srcPos);
        for (int i = 0; i < nHexs; i++ ) {
            shift = i * 4 + srcPos;
            int bits = 0xF & (src >> shift);
            sb.setCharAt(dstPos + i, intToHexDigit(bits));
        }
        return sb.toString();
    }

    /**
     * <p>
     * Converts a byte into an array of Char using the default (little endian, Lsb0) byte and
     * bit ordering.
     * </p>
     * 
     * @param src the byte to convert
     * @param srcPos the position in <code>src</code>, in bits, from where to start the
     *            conversion
     * @param dstInit the initial value for the result String
     * @param dstPos the position in <code>dst</code> where to copy the result
     * @param nHexs the number of Char to copy to <code>dst</code>. must be smaller or equal to
     *            the width of the input (from srcPos to msb)
     * @return <code>dst</code>
     */
    public static String byteToHexs(byte src, int srcPos, String dstInit, int dstPos, int nHexs) {
        if (0 == nHexs) return dstInit;
        StringBuilder sb = new StringBuilder(dstInit);
        int shift = 0;
        assert ((nHexs - 1) * 4 < 8 - srcPos);
        for (int i = 0; i < nHexs; i++ ) {
            shift = i * 4 + srcPos;
            int bits = 0xF & (src >> shift);
            sb.setCharAt(dstPos + i, intToHexDigit(bits));
        }
        return sb.toString();
    }

    /**
     * <p>
     * Converts a long into an array of boolean using the default (little endian, Lsb0) byte and
     * bit ordering.
     * </p>
     * 
     * @param src the long to convert
     * @param srcPos the position in <code>src</code>, in bits, from where to start the
     *            conversion
     * @param dst the destination array
     * @param dstPos the position in <code>dst</code> where to copy the result
     * @param nBools the number of boolean to copy to <code>dst</code>. must be smaller or equal
     *            to the width of the input (from srcPos to msb)
     * @return <code>dst</code>
     */
    public static boolean[] longToBools(long src, int srcPos, boolean[] dst, int dstPos,
        int nBools) {
        if (0 == nBools) return dst;
        int shift = 0;
        assert ((nBools - 1) * 1 < 64 - srcPos);
        for (int i = 0; i < nBools; i++ ) {
            shift = i * 1 + srcPos;
            dst[dstPos + i] = ((0x1 & (src >> shift)) != 0);
        }
        return dst;
    }

    /**
     * <p>
     * Converts a int into an array of boolean using the default (little endian, Lsb0) byte and
     * bit ordering.
     * </p>
     * 
     * @param src the int to convert
     * @param srcPos the position in <code>src</code>, in bits, from where to start the
     *            conversion
     * @param dst the destination array
     * @param dstPos the position in <code>dst</code> where to copy the result
     * @param nBools the number of boolean to copy to <code>dst</code>. must be smaller or equal
     *            to the width of the input (from srcPos to msb)
     * @return <code>dst</code>
     */
    public static boolean[] intToBools(int src, int srcPos, boolean[] dst, int dstPos,
        int nBools) {
        if (0 == nBools) return dst;
        int shift = 0;
        assert ((nBools - 1) * 1 < 32 - srcPos);
        for (int i = 0; i < nBools; i++ ) {
            shift = i * 1 + srcPos;
            dst[dstPos + i] = ((0x1 & (src >> shift)) != 0);
        }
        return dst;
    }

    /**
     * <p>
     * Converts a short into an array of boolean using the default (little endian, Lsb0) byte
     * and bit ordering.
     * </p>
     * 
     * @param src the short to convert
     * @param srcPos the position in <code>src</code>, in bits, from where to start the
     *            conversion
     * @param dst the destination array
     * @param dstPos the position in <code>dst</code> where to copy the result
     * @param nBools the number of boolean to copy to <code>dst</code>. must be smaller or equal
     *            to the width of the input (from srcPos to msb)
     * @return <code>dst</code>
     */
    public static boolean[] shortToBools(short src, int srcPos, boolean[] dst, int dstPos,
        int nBools) {
        if (0 == nBools) return dst;
        int shift = 0;
        assert ((nBools - 1) * 1 < 16 - srcPos);
        for (int i = 0; i < nBools; i++ ) {
            shift = i * 1 + srcPos;
            dst[dstPos + i] = ((0x1 & (src >> shift)) != 0);
        }
        return dst;
    }

    /**
     * <p>
     * Converts a byte into an array of boolean using the default (little endian, Lsb0) byte and
     * bit ordering.
     * </p>
     * 
     * @param src the byte to convert
     * @param srcPos the position in <code>src</code>, in bits, from where to start the
     *            conversion
     * @param dst the destination array
     * @param dstPos the position in <code>dst</code> where to copy the result
     * @param nBools the number of boolean to copy to <code>dst</code>. must be smaller or equal
     *            to the width of the input (from srcPos to msb)
     * @return <code>dst</code>
     */
    public static boolean[] byteToBools(byte src, int srcPos, boolean[] dst, int dstPos,
        int nBools) {
        if (0 == nBools) return dst;
        int shift = 0;
        assert ((nBools - 1) * 1 < 8 - srcPos);
        for (int i = 0; i < nBools; i++ ) {
            shift = i * 1 + srcPos;
            dst[dstPos + i] = ((0x1 & (src >> shift)) != 0);
        }
        return dst;
    }
}
