package passwordvalidation;

public class PasswordValidation {
    private int min = 8;

    public boolean isValid(String PASSWORD) {
        boolean isValid = true;

        if (!isLargerThanMin(PASSWORD)) {
            isValid = false;
        }
        if (!hasCapitalLetter(PASSWORD)) {
            isValid = false;
        }
        if (!hasLowerLetter(PASSWORD)) {
            isValid = false;
        }
        if (!hasNumber(PASSWORD)) {
            isValid = false;
        }
        if (!hasUnderscore(PASSWORD)) {
            isValid = false;
        }
        return isValid;
    }

    public boolean isValid(String PASSWORD, int min, boolean capital, boolean lower, boolean number,
            boolean underscore) {
        this.min = min;
        boolean isValid = true;

        if (!isLargerThanMin(PASSWORD)) {
            isValid = false;
        }
        if (capital) {
            if (!hasCapitalLetter(PASSWORD)) {
                isValid = false;
            }
        }
        if (lower) {
            if (!hasLowerLetter(PASSWORD)) {
                isValid = false;
            }
        }
        if (number) {
            if (!hasNumber(PASSWORD)) {
                isValid = false;
            }
        }
        if (underscore) {
            if (!hasUnderscore(PASSWORD)) {
                isValid = false;
            }
        }
        return isValid;
    }

    public boolean isLargerThanMin(String PASSWORD) {
        if (PASSWORD.length() > min) {
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