package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import java.util.Arrays;

import org.junit.Test;

import seedu.address.logic.commands.FindPhoneCommand;
import seedu.address.model.person.PhoneContainsKeywordsPredicate;

//@@author Labradorites
public class FindPhoneCommandParserTest {

    private FindPhoneCommandParser parser = new FindPhoneCommandParser();

    @Test
    public void parse_emptyArg_throwsParseException() {
        assertParseFailure(parser, "     ",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindPhoneCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_validArgs_returnsFindPhoneCommand() {
        // no leading and trailing whitespaces
        FindPhoneCommand expectedFindPhoneCommand =
                new FindPhoneCommand(new PhoneContainsKeywordsPredicate(Arrays.asList("85355255", "22222222")));
        assertParseSuccess(parser, " 85355255 22222222", expectedFindPhoneCommand);

        // multiple whitespaces between keywords
        assertParseSuccess(parser, " \n 85355255 \n \t 22222222  \t", expectedFindPhoneCommand);
    }

}
