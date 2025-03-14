package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.model.Model;
import seedu.address.model.person.NameContainsKeywordsPredicate;

/**
 * Finds and lists all persons in address book whose name contains any of the argument keywords.
 * Keyword matching is case insensitive.
 */
public class FilterTagCommand extends Command {

    public static final String COMMAND_WORD = "filter";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds all persons with any tags containing "
            + "the specified keywords (case-insensitive) and displays them as a list with index numbers.\n"
            + "Parameters: KEYWORD [MORE_KEYWORDS]...\n"
            + "Example: " + COMMAND_WORD + " friend";

    private final String tempPredicate;

    public FilterTagCommand(String tempPredicate) {
        this.tempPredicate = tempPredicate;
    }

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        // model.updateFilteredPersonList(tempPredicate);
        return new CommandResult(
                String.format(Messages.MESSAGE_PERSONS_LISTED_OVERVIEW, model.getFilteredPersonList().size()));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof FilterTagCommand)) {
            return false;
        }

        FilterTagCommand otherFindCommand = (FilterTagCommand) other;
        return tempPredicate.equals(otherFindCommand.tempPredicate);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("predicate", tempPredicate)
                .toString();
    }
}
