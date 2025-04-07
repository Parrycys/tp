package seedu.address.model.person;

import java.util.List;
import java.util.function.Predicate;

import seedu.address.commons.util.ToStringBuilder;

/**
 * Tests that a {@code Person}'s {@code Phone} matches any of the keywords given.
 */
public class PhoneNumberContainsKeywordsPredicate implements Predicate<Person> {
    public static final String MESSAGE_CONSTRAINTS =
            "Phone search terms must be 3-18 digits long";
    private static final String VALIDATION_REGEX = "\\d{3,15}";
    private final List<String> keywords;

    public PhoneNumberContainsKeywordsPredicate(List<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public boolean test(Person person) {
        return keywords.stream()
                .anyMatch(keyword -> person.getPhone().toString().contains(keyword));
    }

    public static boolean isValidPhoneSearchTerm(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof PhoneNumberContainsKeywordsPredicate)) {
            return false;
        }

        PhoneNumberContainsKeywordsPredicate otherPhoneNumberContainsKeywordsPredicate =
                (PhoneNumberContainsKeywordsPredicate) other;
        return keywords.equals(otherPhoneNumberContainsKeywordsPredicate.keywords);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).add("keywords", keywords).toString();
    }
}
