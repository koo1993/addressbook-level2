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

    private void assertAreUnique(Object... objects) {
        assertTrue(Utils.elementsAreUnique(Arrays.asList(objects)));
    }

    private void assertNotUnique(Object... objects) {
        assertFalse(Utils.elementsAreUnique(Arrays.asList(objects)));
    }


    @Test
    public void utils_isAnyNull() throws Exception {
        Integer nullObject = null;

        //single object check Not null
        assertFalse(Utils.isAnyNull("this is a string object"));
        assertFalse(Utils.isAnyNull(new Integer(10)));

        //multiple object for Not null
        assertFalse(Utils.isAnyNull("this is not null", new Integer(10), new ArrayList<Integer>()));

        //single object check for null
        assertTrue(Utils.isAnyNull((Object) null));
        assertTrue(Utils.isAnyNull(nullObject));

        //multiple object for null
        assertTrue(Utils.isAnyNull(null, nullObject));

    }
}
