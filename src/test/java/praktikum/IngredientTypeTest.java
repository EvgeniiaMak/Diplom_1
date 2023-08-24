package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    String name;
    IngredientType expected;

    public IngredientTypeTest(String name, IngredientType expected) {
        this.name = name;
        this.expected = expected;
    }


    @Test
    public void getValueTest() {
        IngredientType actual = IngredientType.valueOf(name);
        Assert.assertEquals(expected, actual);
    }

    @Parameterized.Parameters
    public static Object[][] getSexAndHasManeData() {
        return new Object[][]{
                {"SAUCE", IngredientType.SAUCE},
                {"FILLING", IngredientType.FILLING},
        };
    }
}
