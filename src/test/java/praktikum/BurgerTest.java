package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Test
    public void getPriceTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.getPrice();
        Mockito.when(bun.getPrice()).thenReturn(100f);
        Mockito.when(ingredient.getPrice()).thenReturn(200f);
        Assert.assertEquals(400f, burger.getPrice(),0);

    }

    @Test
    public void getReceiptTest() {
        Bun bun = new Bun("black bun", 200);
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "sausage", 250.05f);
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        StringBuilder receipt = new StringBuilder(String.format("(==== %s ====)%n", "black bun"));
        receipt.append(String.format("= %s %s =%n", IngredientType.FILLING.toString().toLowerCase(), "sausage"));
        receipt.append(String.format("(==== %s ====)%n", "black bun"));
        receipt.append(String.format("%nPrice: %f%n", 650.05f));

        Assert.assertEquals(receipt.toString(), burger.getReceipt());
    }

    @Test
    public void  removeIngredientTest(){
        Burger burger = new Burger();
        Database database = new Database();
        burger.addIngredient(database.availableIngredients().get(0));
        burger.addIngredient(database.availableIngredients().get(1));
        burger.addIngredient(database.availableIngredients().get(2));
        burger.removeIngredient(0);
        Assert.assertEquals(2, burger.ingredients.size());
    }

    @Test
    public void  moveIngredientTest(){
        Burger burger = new Burger();
        Database database = new Database();
        burger.addIngredient(database.availableIngredients().get(0));
        burger.addIngredient(database.availableIngredients().get(1));
        burger.addIngredient(database.availableIngredients().get(2));
        burger.moveIngredient(0,2);
        Assert.assertEquals(database.availableIngredients().get(0),burger.ingredients.get(2));
    }
}
