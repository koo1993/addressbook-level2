package seedu.addressbook.data.person;


/**
 * Represents a type of contact in a person
 */
public class Contact {

    protected String value;
    protected boolean isPrivate;


    public Contact(String value, boolean isPrivate) {
        this.value = value;
        this.isPrivate = isPrivate;
    }


    @Override
    public String toString() {
        return value;
    }


    @Override
    public int hashCode() {
        return value.hashCode();
    }


    public boolean isPrivate() {
        return isPrivate;
    }
}
