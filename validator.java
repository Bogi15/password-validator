public class validator {
    //all types of characters into differnt strings
    public static final String LOWERCASE_CHARACTERS = "abcdefghijklmnopqrstuvwxyz";
    public static final String UPPERCASE_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String SPECIAL_CHARACTERS = "~!@#$%^&*()_-+={}[]|:;'<>;,.?/";
    public static final String NUMBERS = "0123456789";

    public boolean passwordValid( boolean inUppercase, boolean inLowercase, boolean inNumbers, boolean inSpecial_Characters, String pass){
        String all="";
        if(inLowercase) all += LOWERCASE_CHARACTERS;
        if(inUppercase) all += UPPERCASE_CHARACTERS; 
        if(inSpecial_Characters) all += SPECIAL_CHARACTERS;
        if(inNumbers) all += NUMBERS;

        for (char c : pass.toCharArray()) {
            if (all.indexOf(c) == -1) {
                return false; 
            }
        }
        return true;
    }
}
