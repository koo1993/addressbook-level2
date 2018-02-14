package seedu.addressbook.commands;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.util.TypicalPersons;

public class FindTagCommandTest {

    private final AddressBook addressBook = new TypicalPersons().getTypicalAddressBook();
    private final TypicalPersons td = new TypicalPersons();

    @Test
    public void execute() throws IllegalValueException {
        //same word, same case: matched
        assertFindCommandBehavior(new String[]{"friends"}, Arrays.asList( td.bill));

        //same word, different case: matched
        assertFindCommandBehavior(new String[]{"frIends"},  Arrays.asList( td.bill));

        //partial word:  unmatched
        assertFindCommandBehavior(new String[]{"my"},  Collections.emptyList());

        //repeated keywords: matched
        assertFindCommandBehavior(new String[]{"Test", "test"}, Arrays.asList(td.dan, td.bill));

        //Keyword matching a word in address: not matched
        assertFindCommandBehavior(new String[]{"Clementi"}, Collections.emptyList());
    }

    /**
     * Executes the find command for the given keywords and verifies
     * the result matches the persons in the expectedPersonList exactly.
     */
    private void assertFindCommandBehavior(String[] keywords, List<ReadOnlyPerson> expectedPersonList) {
        FindTagCommand command = createFindTagCommand(keywords);
        CommandResult result = command.execute();

        assertEquals(Command.getMessageForPersonListShownSummary(expectedPersonList), result.feedbackToUser);
    }

    private FindTagCommand createFindTagCommand(String[] keywords) {
        final Set<String> keywordSet = new HashSet<>(Arrays.asList(keywords));
        FindTagCommand command = new FindTagCommand(keywordSet);
        command.setData(addressBook, Collections.emptyList());
        return command;
    }

}
