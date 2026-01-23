/*
 * Copyright (C) 2026 Alonso del Arte
 *
 * This program is free software: you can redistribute it and/or modify it under 
 * the terms of the GNU General Public License as published by the Free Software 
 * Foundation, either version 3 of the License, or (at your option) any later 
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT 
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS 
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more 
 * details.
 *
 * You should have received a copy of the GNU General Public License along with 
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */
package randomness;

import java.awt.Color;
import java.math.BigInteger;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;

import javax.naming.ldap.Rdn;

import org.junit.Test;
import static org.junit.Assert.*;

import static org.testframe.api.Asserters.assertThrows;

/**
 * Tests of the ExtendedRandom class.
 * @author Alonso del Arte
 */
public class ExtendedRandomTest {
    
    private static final Random RANDOM 
            = new Random(-System.currentTimeMillis() >> 4);
    
    /**
     * Test of the nextInt function, of the ExtendedRandom class.
     */
    @Test
    public void testNextInt() {
        System.out.println("nextInt");
        int capacity = 2048;
        Set<Integer> numbers = new HashSet<>(capacity);
        for (int i = 0; i < capacity; i++) {
            numbers.add(ExtendedRandom.nextInt());
        }
        int expected = 15 * capacity / 16;
        int actual = numbers.size();
        String msg = "Expected at least " + expected
                + " distinct integers out of " + capacity + ", got " + actual;
        System.out.println(msg);
        assert actual >= expected : msg;
    }
    
    @Test
    public void testNextIntBoundedByZeroThrowsException() {
        Throwable t = assertThrows(() -> {
            int badResult = ExtendedRandom.nextInt(0);
            System.out.println("Calling nextInt with bound 0 gave "
                    + badResult);
        }, IllegalArgumentException.class);
        String excMsg = t.getMessage();
        assert excMsg != null : "Message should not be null";
        assert !excMsg.isEmpty() : "Message should not be empty";
        System.out.println("\"" + excMsg + "\"");
    }

    /**
     * Test of the nextInt function, of the ExtendedRandom class.
     */
    @Test
    public void testNextIntBounded() {
        int capacity = 2048;
        int bound = capacity - RANDOM.nextInt(128);
        Set<Integer> numbers = new HashSet<>(capacity);
        for (int i = 0; i < capacity; i++) {
            int number = ExtendedRandom.nextInt(bound);
            String msg = "Pseudorandom number " + number
                    + " should be at least 0 but less than " + bound;
            assert number >= 0 : msg;
            assert number < bound : msg;
            numbers.add(number);
        }
        int expected = capacity / 2;
        int actual = numbers.size();
        String msg = "Expected at least " + expected
                + " distinct integers in the range 0 to " + (bound - 1)
                + " out of " + capacity + ", got " + actual;
        System.out.println(msg);
        assert actual >= expected : msg;
    }
    
    @Test
    public void testNextIntBoundedByNegative() {
        int capacity = 2048;
        int bound = -(capacity - RANDOM.nextInt(128));
        Set<Integer> numbers = new HashSet<>(capacity);
        for (int i = 0; i < capacity; i++) {
            try {
                int number = ExtendedRandom.nextInt(bound);
                String msg = "Pseudorandom number " + number
                        + " should be at most 0 but also more than " + bound;
                assert number <= 0 : msg;
                assert number > bound : msg;
                numbers.add(number);
            } catch (IllegalArgumentException iae) {
                String errMsg = "Bound " + bound
                        + " shouldn't've caused IllegalArgumentException";
                throw new AssertionError(errMsg, iae);
            }
        }
        int expected = capacity / 2;
        int actual = numbers.size();
        String msg = "Expected at least " + expected
                + " distinct integers in the range " + (bound - 1)
                + " to 0 out of " + capacity + ", got " + actual;
        System.out.println(msg);
        assert actual >= expected : msg;
    }

    /**
     * Test of nextInt method, of class ExtendedRandom.
     */
    @org.junit.Ignore
    @Test
    public void testNextInt_int_int() {
        System.out.println("nextInt");
        int origin = 0;
        int bound = 0;
        int expResult = 0;
        int result = ExtendedRandom.nextInt(origin, bound);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testAlphanumericRejectsNegativeLength() {
        int badLength = -RANDOM.nextInt(1024) - 1;
        Throwable t = assertThrows(() -> {
            String badString = ExtendedRandom.alphanumeric(badLength);
            System.out.println("Trying to get random alphanumeric of length "
                    + badLength + " should not have given \"" + badString
                    + "\"");
        }, IllegalArgumentException.class);
        String excMsg = t.getMessage();
        assert excMsg != null : "Exception message should not be null";
        System.out.println("\"" + excMsg + "\"");
        String badLengthStr = Integer.toString(badLength);
        String msg = "Exception message should include \"" + badLengthStr
                + "\"";
        assert excMsg.contains(badLengthStr) : msg;
    }

    @Test
    public void testAlphanumericGivesStringOfSpecifiedLength() {
        for (int expected = 1; expected < 21; expected++) {
            String s = ExtendedRandom.alphanumeric(expected);
            int actual = s.length();
            String message = "\"" + s + "\" should be of requested length";
            assertEquals(message, expected, actual);
        }
    }

    private static boolean isASCIILetterOrDigit(char ch) {
        boolean isDigit = ch >= '0' && ch <= '9';
        boolean isUppercaseLetter = ch >= 'A' && ch <= 'Z';
        boolean isLowercaseLetter = ch >= 'a' && ch <= 'z';
        return isDigit || isUppercaseLetter || isLowercaseLetter;
    }

    /**
     * Test of the alphanumeric function, of the ExtendedRandom class.
     */
    @Test
    public void testAlphanumeric() {
        System.out.println("alphanumeric");
        int capacity = RANDOM.nextInt(64) + 36;
        Set<String> strings = new HashSet<>(capacity);
        int length = RANDOM.nextInt(16) + 4;
        for (int i = 0; i < capacity; i++) {
            String s = ExtendedRandom.alphanumeric(length);
            strings.add(s);
        }
        int expected = 9 * capacity / 10;
        int actual = strings.size();
        String msg = "alphanumeric should've given at least " + expected
                + " distinct, gave " + actual + " distinct";
        System.out.println(msg);
        assert actual >= expected : msg;
    }

    /**
     * Test of chooseBMPBlock method, of class ExtendedRandom.
     */
    @org.junit.Ignore
    @Test
    public void testChooseBMPBlock() {
        System.out.println("chooseBMPBlock");
        Character.UnicodeBlock expResult = null;
        Character.UnicodeBlock result = ExtendedRandom.chooseBMPBlock();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of chooseBMPBlockOtherThan method, of class ExtendedRandom.
     */
    @org.junit.Ignore
    @Test
    public void testChooseBMPBlockOtherThan() {
        System.out.println("chooseBMPBlockOtherThan");
        Character.UnicodeBlock block = null;
        Character.UnicodeBlock expResult = null;
        Character.UnicodeBlock result = ExtendedRandom.chooseBMPBlockOtherThan(block);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of chooseCharacterFromBlock method, of class ExtendedRandom.
     */
    @org.junit.Ignore
    @Test
    public void testChooseCharacterFromBlock() {
        System.out.println("chooseCharacterFromBlock");
        Character.UnicodeBlock block = null;
        char expResult = ' ';
        char result = ExtendedRandom.chooseCharacterFromBlock(block);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of makeStringWithBlockCharacters method, of class ExtendedRandom.
     */
    @org.junit.Ignore
    @Test
    public void testMakeStringWithBlockCharacters() {
        System.out.println("makeStringWithBlockCharacters");
        Character.UnicodeBlock block = null;
        String expResult = "";
        String result = ExtendedRandom.makeStringWithBlockCharacters(block);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of nextColor method, of class ExtendedRandom.
     */
    @org.junit.Ignore
    @Test
    public void testNextColor() {
        System.out.println("nextColor");
        Color expResult = null;
        Color result = ExtendedRandom.nextColor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
