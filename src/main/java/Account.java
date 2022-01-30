public class Account {

    private final String name;
    private static final String REGEX_FOR_CHECKING_NAME = "(?=^.{3,19}$)(^[a-zA-ZА-ёЁ]+\\s[a-zA-ZА-ёЁ]+$)";

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {
        return name.matches(REGEX_FOR_CHECKING_NAME);
    }

}