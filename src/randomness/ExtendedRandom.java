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

import java.util.Random;

/**
 *
 * @author Alonso del Arte
 */
public class ExtendedRandom {
    
    private static final Random RANDOM = new Random();
    
    public static int nextInt() {
        return RANDOM.nextInt();
    }
    
    public static int nextInt(int bound) {
        if (bound == 0) {
            String excMsg = "Bound 0 is not valid";
            throw new IllegalArgumentException(excMsg);
        }
        return RANDOM.nextInt(bound);
    }
    
    public static int nextInt(int origin, int bound) {
        return RANDOM.nextInt(origin, bound);
    }
    
    private static char chooseASCIIChar() {
        boolean chooseDigit = RANDOM.nextBoolean();
        if (chooseDigit) {
            return (char) (RANDOM.nextInt(10) + '0');
        } else {
            int choice = RANDOM.nextInt(26);
            boolean chooseUpperCase = RANDOM.nextBoolean();
            if (chooseUpperCase) {
                return (char) (choice + 'A');
            } else {
                return (char) (choice + 'a');
            }
        }
    }
    
    /**
     * Gives a {@code String} of alphanumeric gibberish. Output will include at 
     * least one ASCII digit, one ASCII uppercase letter and one ASCII lowercase 
     * letter if the requested length is sufficient.
     * @param length The length. For example, 24. May be 0, but there might not 
     * be much point to that. Should not be negative.
     * @return A {@code String} of the specified length. For example, 
     * "85aPFqs92Gzfd4THK964U163". In the case of {@code length} being 0, always 
     * the empty {@code String}.
     * @throws IllegalArgumentException If {@code length} is negative.
     */
    public static String alphanumeric(int length) {
        if (length < 0) {
            String excMsg = "Length " + length + " is not valid";
            throw new IllegalArgumentException(excMsg);
        }
        char[] value = new char[length];
        for (int i = 0; i < length; i++) {
            value[i] = chooseASCIIChar();
        }
        return new String(value);
    }
    
    // TODO: Write tests for this
    public static String alphanumericWithLetterStart(int length) {
        if (length < 0) {
            String excMsg = "Length " + length + " is not valid";
            throw new IllegalArgumentException(excMsg);
        }
        return "SORRY, NOT IMPLEMENTED YET".substring(0, length);
    }

    // TODO: Write tests for this
    public static Character.UnicodeBlock chooseBMPBlock() {
        return Character.UnicodeBlock.ADLAM;
    }
    
    // TODO: Write tests for this
    public static Character.UnicodeBlock 
        chooseBMPBlockOtherThan(Character.UnicodeBlock block) {
        return block;
    }
    
    // TODO: Write tests for this
    public static char chooseCharacterFromBlock(Character.UnicodeBlock block) {
        return '?';
    }

    // TODO: Write tests for this
    public static String 
        makeStringWithBlockCharacters(Character.UnicodeBlock block) {
        return "SORRY, NOT IMPLEMENTED YET";
    }
        
    // TODO: Write tests for this
    public static Color nextColor() {
        return Color.BLACK;
    }

}
