public class validator {
    //all types of characters into differnt strings
    public static final String LOWERCASE_CHARACTERS = "abcdefghijklmnopqrstuvwxyz";
    public static final String UPPERCASE_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String SPECIAL_CHARACTERS = "~!@#$%^&*()_-+={}[]|:;'<>;,.?/";
    public static final String NUMBERS = "0123456789";

    public boolean passwordValid( boolean inUppercase, boolean inLowercase, boolean inNumbers, boolean inSpecial_Characters, String pass){
        boolean Uppercase = false;
        boolean Lowercase = false;
        boolean Numbers = false;
        boolean SpecialChars = false;

    for (char c : pass.toCharArray()) {
        if (Character.isUpperCase(c)) {
            Uppercase = true;
        } else if (Character.isLowerCase(c)) {
            Lowercase = true;
        } else if (Character.isDigit(c)) {
            Numbers = true;
        } else if (SPECIAL_CHARACTERS.indexOf(c) != -1) {
            SpecialChars = true;
        }
    }

    return inUppercase == Uppercase &&
           inLowercase == Lowercase &&
           inNumbers == Numbers &&
           inSpecial_Characters == SpecialChars;
    }
}
