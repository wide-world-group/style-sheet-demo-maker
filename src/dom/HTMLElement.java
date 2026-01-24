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
package dom;

/**
 *
 * @author Alonso del Arte
 */
public abstract class HTMLElement {
    
    // TODO: Write tests for this. Default false
    public boolean autofocus() {
        return true;
    }
    
    // TODO: Write tests for this
    // TODO: Write Javadoc explaining this corresponds to HTML class attribute
    public String classification() {
        return "SORRY, NOT IMPLEMENTED YET";
    }
    
    // TODO: Write tests for this
    // TODO: Write Javadoc explaining this corresponds to HTML id attribute
    public String identification() {
        return "SORRY, NOT IMPLEMENTED YET";
    }
    
    // TODO: Write tests for this
    // TODO: Write Javadoc explaining this corresponds to HTML lang attribute
    public String language() {
        return "SORRY, NOT IMPLEMENTED YET";
    }
    
    // TODO: Write tests for this. Default zero?
    public int tabindex() {
        return Integer.MIN_VALUE;
    }
    
    // TODO: Write tests for this. Default null?
    public String title() {
        return "SORRY, NOT IMPLEMENTED YET";
    }
    
}
