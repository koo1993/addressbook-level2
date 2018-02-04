package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, some street, #11-246, 730224";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses format should be of BLOCK, STREET, UNIT, POSTAL_CODE";
    public static final String ADDRESS_VALIDATION_REGEX = ".+,.+,.+,.+";
    public static final String COMMA = ", ";

    private final int BLOCK = 0;
    private final int STREET = 1;
    private final int UNIT = 2;
    private final int POSTALCODE = 3;

    private Block block;
    private Street street;
    private Unit unit;
    private PostalCode postalCode;
    private boolean isPrivate;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String trimmedAddress = address.trim();
        this.isPrivate = isPrivate;
        if (!isValidAddress(trimmedAddress)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        processAddress(trimmedAddress);
    }

    /**
     * process Address string and initialize block, street, unit, postalCode
     */
    private void processAddress(String trimmedAddress) {
        String[] result = trimmedAddress.split(",");
        block = new Block(result[BLOCK].trim());
        street = new Street(result[STREET].trim());
        unit = new Unit(result[UNIT].trim());
        postalCode = new PostalCode(result[POSTALCODE].trim());
    }

    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    /**
     *
     * @return Address in the form of BLOCK, STREET, UNIT, POSTALCODE
     */
    private String getAddressString() {
        return block + COMMA + street + COMMA + unit + COMMA + postalCode;
    }

    @Override
    public String toString() {
        return getAddressString();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && getAddressString().equals(((Address) other).getAddressString())); // state check
    }

    @Override
    public int hashCode() {
        return getAddressString().hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
