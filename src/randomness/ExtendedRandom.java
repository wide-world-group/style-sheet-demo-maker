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
    
    // TODO: Write tests for this
    public static int nextInt(int bound) {
        return Integer.MAX_VALUE;
    }
    
    // TODO: Write tests for this
    public static int nextInt(int origin, int bound) {
        return Integer.MIN_VALUE;
    }
    
    // TODO: Write tests for this
    public static String alphanumeric() {
        return "SORRY, NOT IMPLEMENTED YET";
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
