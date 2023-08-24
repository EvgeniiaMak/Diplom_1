package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runners.Parameterized;

public class IngredientTest {

    @Test
    public void getPriceTest() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING,"cutlet",200);
        Assert.assertEquals(200, ingredient.getPrice(),0);
    }

    @Test
    public void getNameTest() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING,"cutlet",200);
        Assert.assertEquals("cutlet",ingredient.getName());
    }
    @Test
    public void getTypeTest() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING,"cutlet",200);
        Assert.assertEquals(IngredientType.FILLING,ingredient.getType());
    }

}
