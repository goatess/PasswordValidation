package passwordvalidation;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class passwordvalidationTest {

    @Test
    public void validate_password_when_it_has_more_than_8_characters() {
        final String MORE_THAN_EIGHT_CHAR_PASSWORD = "1234567890";
        PasswordValidation validation = new PasswordValidation();
        assertTrue(MORE_THAN_EIGHT_CHAR_PASSWORD, validation.isLargerThanMin(MORE_THAN_EIGHT_CHAR_PASSWORD));
    }

    @Test
    public void dont_validate_password_when_it_has_less_than_8_characters() {
        final String EIGHT_OR_LESS_CHAR_PASSWORD = "12345678";
        PasswordValidation validation = new PasswordValidation();
        assertFalse(EIGHT_OR_LESS_CHAR_PASSWORD, validation.isLargerThanMin(EIGHT_OR_LESS_CHAR_PASSWORD));
    }

    @Test
    public void validate_password_when_it_has_a_capital_letter() {
        final String CAPITAL_LETTER_PASSWORD = "A";
        PasswordValidation validation = new PasswordValidation();
        assertTrue(validation.hasCapitalLetter(CAPITAL_LETTER_PASSWORD));
    }

    @Test
    public void dont_validate_password_when_it_doesnt_have_a_capital_letter() {
        final String WITHOUT_CAPITAL_LETTER_PASSWORD = "a";
        PasswordValidation validation = new PasswordValidation();
        assertFalse(validation.hasCapitalLetter(WITHOUT_CAPITAL_LETTER_PASSWORD));
    }

    @Test
    public void validate_password_when_it_has_a_lower_letter() {
        final String LOWER_LETTER_PASSWORD = "a";
        PasswordValidation validation = new PasswordValidation();
        assertTrue(validation.hasLowerLetter(LOWER_LETTER_PASSWORD));
    }

    @Test
    public void dont_validate_password_when_it_doesnt_have_a_lower_letter() {
        final String WITHOUT_LOWER_LETTER_PASSWORD = "A";
        PasswordValidation validation = new PasswordValidation();
        assertFalse(validation.hasLowerLetter(WITHOUT_LOWER_LETTER_PASSWORD));
    }

    @Test
    public void validate_password_when_it_has_a_number() {
        final String NUMBER_PASSWORD = "12";
        PasswordValidation validation = new PasswordValidation();
        assertTrue(validation.hasNumber(NUMBER_PASSWORD));
    }

    @Test
    public void dont_validate_password_when_it_doesnt_have_a_number() {
        final String WITHOUT_NUMBER_PASSWORD = "armario";
        PasswordValidation validation = new PasswordValidation();
        assertFalse(validation.hasNumber(WITHOUT_NUMBER_PASSWORD));
    }

    @Test
    public void validate_password_when_it_has_an_underscore() {
        final String UNDERSCORE_PASSWORD = "armario_";
        PasswordValidation validation = new PasswordValidation();
        assertTrue(validation.hasUnderscore(UNDERSCORE_PASSWORD));
    }

    @Test
    public void dont_validate_password_when_it_doesnt_have_an_underscore() {
        final String WITHOUT_UNDERSCORE_PASSWORD = "armario";
        PasswordValidation validation = new PasswordValidation();
        assertFalse(validation.hasUnderscore(WITHOUT_UNDERSCORE_PASSWORD));
    }

    @Test
    public void return_when_a_password_is_valid() {
        final String VALID_PASSWORD = "123456_Az";
        PasswordValidation validation = new PasswordValidation();
        assertTrue(validation.isValid(VALID_PASSWORD));
    }

    @Test
    public void return_when_a_password_is_invalid() {
        final String NO_UNDERSCORE_PASSWORD = "1234567Az";
        final String NO_CAPITAL_PASSWORD = "123456_az";
        final String NO_LOWER_PASSWORD = "123456_AZ";
        final String EIGHT_CHAR_PASSWORD = "12345_Az";
        final String NO_NUMBER_PASSWORD = "abcdef_Az";

        PasswordValidation validation = new PasswordValidation();
        assertFalse(validation.isValid(NO_UNDERSCORE_PASSWORD));
        assertFalse(validation.isValid(NO_CAPITAL_PASSWORD));
        assertFalse(validation.isValid(NO_LOWER_PASSWORD));
        assertFalse(validation.isValid(EIGHT_CHAR_PASSWORD));
        assertFalse(validation.isValid(NO_NUMBER_PASSWORD));
    }

    @Test
    public void return_when_a_password_is_valid2() {
        final String VALID_PASSWORD = "12345Az";
        PasswordValidation validation = new PasswordValidation();
        assertTrue(validation.isValid(VALID_PASSWORD,6,true,true,true,false));
    }

    @Test
    public void return_when_a_password_is_invalid2() {
        final String NO_CAPITAL_PASSWORD = "12345az";
        final String NO_LOWER_PASSWORD = "12345AZ";
        final String SIX_CHAR_PASSWORD = "1234Az";
        final String NO_NUMBER_PASSWORD = "AbCdEfG";

        PasswordValidation validation = new PasswordValidation();
        assertFalse(validation.isValid(NO_CAPITAL_PASSWORD,6,true,true,true,false));
        assertFalse(validation.isValid(NO_LOWER_PASSWORD,6,true,true,true,false));
        assertFalse(validation.isValid(SIX_CHAR_PASSWORD,6,true,true,true,false));
        assertFalse(validation.isValid(NO_NUMBER_PASSWORD,6,true,true,true,false));
    }

    @Test
    public void return_when_a_password_is_valid3() {
        final String VALID_PASSWORD = "ABCDEFGH_abcdefgh";
        PasswordValidation validation = new PasswordValidation();
        assertTrue(validation.isValid(VALID_PASSWORD,16,true,true,false,true));
    }

    @Test
    public void return_when_a_password_is_invalid3() {
        final String NO_UNDERSCORE_PASSWORD = "ABCDEFGHIabcdefgh";
        final String NO_CAPITAL_PASSWORD = "abcdefgh_abcdefgh";
        final String NO_LOWER_PASSWORD = "ABCDEFGH_ABCDEFGH";
        final String SIXTEEN_CHAR_PASSWORD = "ABCDEFG__abcdefg";

        PasswordValidation validation = new PasswordValidation();
        assertFalse(validation.isValid(NO_UNDERSCORE_PASSWORD,16,true,true,false,true));
        assertFalse(validation.isValid(NO_CAPITAL_PASSWORD,16,true,true,false,true));
        assertFalse(validation.isValid(NO_LOWER_PASSWORD,16,true,true,false,true));
        assertFalse(validation.isValid(SIXTEEN_CHAR_PASSWORD,16,true,true,false,true));
    }
}