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

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests of the HTMLElement class.
 * @author Alonso del Arte
 */
public class HTMLElementTest {
    
    /**
     * Test of the autofocus function, of the HTMLElement class.
     */
    @Test
    public void testAutofocus() {
        System.out.println("autofocus");
        HTMLElement instance = new HTMLElementImpl();
        boolean expected = false;
        boolean actual = instance.autofocus();
        String msg = "HTML element should not have autofocus by default";
        assert expected == actual : msg;
    }

    /**
     * Test of classification method, of class HTMLElement.
     */
    @org.junit.Ignore
    @Test
    public void testClassification() {
        System.out.println("classification");
        HTMLElement instance = new HTMLElementImpl();
        String expResult = "";
        String result = instance.classification();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of identification method, of class HTMLElement.
     */
    @org.junit.Ignore
    @Test
    public void testIdentification() {
        System.out.println("identification");
        HTMLElement instance = new HTMLElementImpl();
        String expResult = "";
        String result = instance.identification();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of language method, of class HTMLElement.
     */
    @org.junit.Ignore
    @Test
    public void testLanguage() {
        System.out.println("language");
        HTMLElement instance = new HTMLElementImpl();
        String expResult = "";
        String result = instance.language();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of tabindex method, of class HTMLElement.
     */
    @org.junit.Ignore
    @Test
    public void testTabindex() {
        System.out.println("tabindex");
        HTMLElement instance = new HTMLElementImpl();
        int expResult = 0;
        int result = instance.tabindex();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of title method, of class HTMLElement.
     */
    @org.junit.Ignore
    @Test
    public void testTitle() {
        System.out.println("title");
        HTMLElement instance = new HTMLElementImpl();
        String expResult = "";
        String result = instance.title();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    private class HTMLElementImpl extends HTMLElement {
    }
    
}
