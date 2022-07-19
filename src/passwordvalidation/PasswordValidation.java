package passwordvalidation;

public class PasswordValidation {

    public boolean isValid(String PASSWORD) {
        if (isLargerThanEightChar(PASSWORD) && hasCapitalLetter(PASSWORD) && hasLowerLetter(PASSWORD)
                && hasUnderscore(PASSWORD) && hasNumber(PASSWORD)) {
            return true;
        } else
            return false;
    }

    public boolean isLargerThanEightChar(String PASSWORD) {
        if (PASSWORD.length() > 8) {
            return true;
        }
        return false;
    }

    public String[] splitPassword(String PASSWORD) {
        String[] splitPassword = PASSWORD.split("");
        return splitPassword;
    }

    public boolean hasCapitalLetter(String PASSWORD) {
        String[] splitted = splitPassword(PASSWORD);
        for (String character : splitted) {
            if (character.codePointAt(0) >= 65 && character.codePointAt(0) <= 90) {
                return true;
            }
        }
        return false;
    }

    public boolean hasLowerLetter(String PASSWORD) {
        String[] splitted = splitPassword(PASSWORD);
        for (String character : splitted) {
            if (character.codePointAt(0) >= 97 && character.codePointAt(0) <= 122) {
                return true;
            }
        }
        return false;
    }

    public boolean hasNumber(String PASSWORD) {
        String[] splitted = splitPassword(PASSWORD);
        for (String character : splitted) {
            if (character.codePointAt(0) >= 48 && character.codePointAt(0) <= 57) {
                return true;
            }
        }
        return false;
    }

    public boolean hasUnderscore(String PASSWORD) {
        String[] splitted = splitPassword(PASSWORD);
        for (String character : splitted) {
            if (character.codePointAt(0) == 95) {
                return true;
            }
        }
        return false;
    }

}
