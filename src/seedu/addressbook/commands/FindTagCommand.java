package seedu.addressbook.commands;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import seedu.addressbook.data.person.ReadOnlyPerson;

/**
 * Finds and lists all persons in address book whose tag contains any of the argument keywords.
 * Keyword matching is case insensitive.
 */
public class FindTagCommand extends Command {

    public static final String COMMAND_WORD = "findtag";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds all persons whose tag contain any of "
            + "the specified keywords (case-insensitive) and displays them as a list with index numbers.\n"
            + "Parameters: KEYWORD [MORE_KEYWORDS]...\n"
            + "Example: " + COMMAND_WORD + " owemoney bestfriend collegue";

    private final Set<String> keywords;

    public FindTagCommand(Set<String> keywords) {
        this.keywords = keywords;
    }

    /**
     * Returns a copy of keywords in this command.
     */
    public Set<String> getKeywords() {
        return new HashSet<>(keywords);
    }

    @Override
    public CommandResult execute() {
        final List<ReadOnlyPerson> personsFound = getPersonsWithTagContainingAnyKeyword(keywords);
        return new CommandResult(getMessageForPersonListShownSummary(personsFound), personsFound);
    }

    /**
     * Retrieves all persons in the address book whose names contain some of the specified keywords.
     *
     * @param keywords for searching
     * @return list of persons found
     */
    private List<ReadOnlyPerson> getPersonsWithTagContainingAnyKeyword(Set<String> keywords) {
        final List<ReadOnlyPerson> matchedPersons = new ArrayList<>();
        for (ReadOnlyPerson person : addressBook.getAllPersons()) {
            final Set<String> wordsInName = new HashSet<>(person.getTags().getTagInPerson());
            if (!IsDisjointSet(wordsInName, keywords)) {
                matchedPersons.add(person);
            }
        }
        return matchedPersons;
    }

    /**
     * Check if both set are disjoint
     *
     * @param firstSet
     * @param secondSet
     * @return true if two both set are disjoint
     */
    private boolean IsDisjointSet(Set<String> firstSet, Set<String> secondSet) {
        return Collections.disjoint(toLower(firstSet), toLower(secondSet));
    }

    /**
     * Function to convert a set of string values to all small letters
     *
     * @param strings
     * @return orignal set with all string to lowercase
     */
    private Set<String> toLower(Set<String> strings) {
        String[] stringsArray = strings.toArray(new String[0]);
        Set<String> returnString = new HashSet<>();

        for (int i=0; i<stringsArray.length; ++i) {
            stringsArray[i] = stringsArray[i].toLowerCase();
        }

        returnString.addAll(Arrays.asList(stringsArray));
        return returnString;
    }

}
