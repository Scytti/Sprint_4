import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AccountSpaceInNameTest {

    private final String name;
    private final boolean expected;
    private final String textOfError;

    private final static String NAME_TEMPLATE_WITH_1_FIRST_SPACE = " ТимотиШаламе";
    private final static String NAME_TEMPLATE_WITH_1_LAST_SPACE = "ТимотиШаламе ";
    private final static String NAME_TEMPLATE_WITHOUT_SPACE = "ТимотиШаламе";
    private final static String NAME_TEMPLATE_WITH_2_SPACE_IN_A_ROW = "Тимоти  Шаламе";
    private final static String NAME_TEMPLATE_WITH_2_SPACE_IN_DIFFERENT_PLACE = "Тим оти Шаламе";
    private final static String NAME_TEMPLATE_WITH_3_SPACE = "   ";
    private final static String NAME_TEMPLATE_WITH_1_SPACE = " ";
    private final static String NAME_TEMPLATE_WITH_2_SPACE = "  ";

    public AccountSpaceInNameTest(String name, boolean expected, String textOfError){
        this.name = name;
        this.expected = expected;
        this.textOfError = textOfError;
    }

    @Parameterized.Parameters
    public static Object[][] getName() {
        return new Object[][] {
                {NAME_TEMPLATE_WITH_1_FIRST_SPACE, false, "Не корректная обработка данных с 1 пробелом в начале строки"},
                {NAME_TEMPLATE_WITH_1_LAST_SPACE, false, "Не корректная обработка данных с 1 пробелом в конце строки"},
                {NAME_TEMPLATE_WITHOUT_SPACE, false, "Не корректная обработка данных без пробела"},
                {NAME_TEMPLATE_WITH_2_SPACE_IN_A_ROW, false, "Не корректная обработка данных с 2 пробелами подряд"},
                {NAME_TEMPLATE_WITH_2_SPACE_IN_DIFFERENT_PLACE, false, "Не корректная обработка данных с 2 пробелами в разных местах"},
                {NAME_TEMPLATE_WITH_1_SPACE, false, "Не корректная обработка данных лишь с 1 пробелом"},
                {NAME_TEMPLATE_WITH_2_SPACE, false, "Не корректная обработка данных лишь с 2 пробелами"},
                {NAME_TEMPLATE_WITH_3_SPACE, false, "Не корректная обработка данных лишь с 3 пробелами"},
        };
    }

    @Test
    public void testCheckingSpaceInName(){
        Account account = new Account(name);
        assertEquals(textOfError, expected, account.checkNameToEmboss());
    }
}