package passwordvalidation;

public class PasswordValidation {

    public boolean isValid(String PASSWORD) {

        if (isLargerThanEightChar(PASSWORD)) {
            
            return true;
        } 
        return false;
    }

    public boolean isLargerThanEightChar(String EIGHT_CHAR_PASSWORD) {
        if (EIGHT_CHAR_PASSWORD.length()>8) {
            return true;
        }
        return false;
    }

    public String[] splitPassword(String PASSWORD){
        String[] splitPassword = PASSWORD.split("");
        return splitPassword;
    }

    public boolean hasCapitalLetter(String CAPITAL_LETTER_PASSWORD) {
        String[] splitted = splitPassword(CAPITAL_LETTER_PASSWORD);
        for (String character : splitted) {
            if (character.codePointAt(0) >= 65 && character.codePointAt(0) <= 90){
                return true;
            }
        }
        return false;
    }

    public boolean hasLowerLetter(String LOWER_LETTER_PASSWORD) {
        String[] splitted = splitPassword(LOWER_LETTER_PASSWORD);
        for (String character : splitted) {
            if (character.codePointAt(0) >= 97 && character.codePointAt(0) <= 122){
                return true;
            }
        }
        return false;
    }

    public boolean hasNumber(String NUMBER_PASSWORD) {
        String[] splitted = splitPassword(NUMBER_PASSWORD);
        for (String character : splitted) {
            if (character.codePointAt(0) >= 48 && character.codePointAt(0) <= 57){
                return true;
            }
        }
        return false;
    }

    public boolean hasUnderscore(String UNDERSCORE_PASSWORD) {
        String[] splitted = splitPassword(UNDERSCORE_PASSWORD);
        for (String character : splitted) {
            if (character.codePointAt(0) == 95){
                return true;
            }
        }
        return false;
    }



    

}
