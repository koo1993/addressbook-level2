package seedu.addressbook.commands;



/**
 * Sort all persons in the address book to the user.
 */
public class SortCommand extends Command {

    public static final String COMMAND_WORD = "sort";
    public static final String MESSAGE_SORTED = "Your contacts are sorted";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Sort all persons in the address book in alphabetical order.\n"
            + "Example: " + COMMAND_WORD;

    @Override
    public CommandResult execute() {
        addressBook.SortAddressBook();
        return new CommandResult(MESSAGE_SORTED);
    }
}
