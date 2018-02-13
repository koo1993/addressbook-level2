package seedu.addressbook.commands;

import static org.junit.Assert.assertEquals;

import java.util.Collections;
import org.junit.Test;

import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.util.TypicalPersons;

public class SortCommandTest {

    private final AddressBook sortedAddressBook = new TypicalPersons().getTypicalAddressBook();
    private final AddressBook unsortedAddressBook = new TypicalPersons().getTypicalUnsortedAddressBook();

    @Test
    public void execute() throws IllegalValueException {
        assertSortCommandBehavior();
    }

    /**
     * Execute sort command in the unsortedAddressbook
     * to compare with the original sortedAddressbook
     */
    private void assertSortCommandBehavior() {
        SortCommand command = createSortCommand();
        command.execute();
        assertEquals(unsortedAddressBook, sortedAddressBook);
    }

    private SortCommand createSortCommand() {
        SortCommand command = new SortCommand();
        command.setData(this.unsortedAddressBook, Collections.emptyList());
        return command;
    }
}