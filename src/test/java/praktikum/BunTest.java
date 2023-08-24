package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class BunTest {

    @Test
    public void getNameTest() {
        Bun bun = new Bun("с кунжутом", 200);
        Assert.assertEquals("с кунжутом", bun.getName());
    }

    @Test
    public void getPriceTest(){
        Bun bun = new Bun("с кунжутом", 200);
        Assert.assertEquals(200, bun.getPrice(),0);
    }

}
