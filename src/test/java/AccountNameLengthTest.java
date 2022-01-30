import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AccountNameLengthTest {

    private final String name;
    private final boolean expected;
    private final String textOfError;

    private final static String NAME_TEMPLATE_WITH_LENGTH_3 = "М Р";
    private final static String NAME_TEMPLATE_WITH_LENGTH_19 = "Мйцукенг Ршщзхфывап";
    private final static String NAME_TEMPLATE_WITH_LENGTH_10 = "Мйцу Ршщзх";
    private final static String NAME_TEMPLATE_WITH_LENGTH_2 = "РР";
    private final static String NAME_TEMPLATE_WITH_LENGTH_1 = "Р";
    private final static String NAME_TEMPLATE_WITH_LENGTH_20 = "Мйцукенгл Ршщзхфывап";
    private final static String NAME_TEMPLATE_WITH_LENGTH_0 = "";

    public AccountNameLengthTest(String name, boolean expected, String textOfError){
        this.name = name;
        this.expected = expected;
        this.textOfError = textOfError;
    }

    @Parameterized.Parameters
    public static Object[][] getName() {
        return new Object[][] {
                {NAME_TEMPLATE_WITH_LENGTH_3, true, "Не корректная обработка данных с 3 символами"},
                {NAME_TEMPLATE_WITH_LENGTH_19, true, "Не корректная обработка данных с 19 символами"},
                {NAME_TEMPLATE_WITH_LENGTH_10, true, "Не корректная обработка данных с 10 символами"},
                {NAME_TEMPLATE_WITH_LENGTH_2, false, "Не корректная обработка данных с 2 символами"},
                {NAME_TEMPLATE_WITH_LENGTH_1, false, "Не корректная обработка данных с 1 символами"},
                {NAME_TEMPLATE_WITH_LENGTH_20, false, "Не корректная обработка данных с 20 символами"},
                {NAME_TEMPLATE_WITH_LENGTH_0, false, "Не корректная обработка данных с 0 символами"},
        };
    }

    @Test
    public void testCheckingLengthOfName(){
        Account account = new Account(name);
        assertEquals(textOfError, expected, account.checkNameToEmboss());
    }
}
