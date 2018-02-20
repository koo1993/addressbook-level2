package seedu.addressbook.common;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class UtilsTest {


    @Test
    public void elementsAreUnique() throws Exception {
        // empty list
        assertAreUnique();

        // only one object
        assertAreUnique((Object) null);
        assertAreUnique(1);
        assertAreUnique("");
        assertAreUnique("abc");

        // all objects unique
        assertAreUnique("abc", "ab", "a");
        assertAreUnique(1, 2);

        // some identical objects
        assertNotUnique("abc", "abc");
        assertNotUnique("abc", "", "abc", "ABC");
        assertNotUnique("", "abc", "a", "abc");
        assertNotUnique(1, new Integer(1));
        assertNotUnique(null, 1, new Integer(1));
        assertNotUnique(null, null);
        assertNotUnique(null, "a", "b", null);
    }

    @Test
    public void elementisAnyNull() throws Exception {
        Integer nullObject = null;

        //single object for Not null
        assertAnyIsNotNull("this is a string object");
        assertAnyIsNotNull(new Integer(10));

        //multiple object for Not null
        assertAnyIsNotNull("this is not null", new Integer(10), new ArrayList<Integer>());

        //single object check for null
        assertAnyIsNull((Object) null);
        assertAnyIsNull(nullObject);

        //multiple object for null
        assertAnyIsNull(null, nullObject);

    }

    private void assertAreUnique(Object... objects) {
        assertTrue(Utils.elementsAreUnique(Arrays.asList(objects)));
    }

    private void assertNotUnique(Object... objects) {
        assertFalse(Utils.elementsAreUnique(Arrays.asList(objects)));
    }

    private void assertAnyIsNull(Object... objects) {
        assertTrue(Utils.isAnyNull(objects));
    }

    private void assertAnyIsNotNull(Object... objects) {
        assertFalse(Utils.isAnyNull(objects));
    }



}
