package demo.project.test;

import demo.project.driver.Driver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JunitBeforeAfterTest extends Driver {

    @Test
    public void test1(){

        System.out.println("test1");
        int urunSayisi = 1;
        Assertions.assertTrue(1 == urunSayisi);
        // urun sayısı 1 artırıldı
        Assertions.assertTrue(2 == urunSayisi,"actual urun sayisi: " + urunSayisi + " urun sayisi 2 olmalı");
        Assertions.assertTrue(5 == 5);
    }

    @Test
    public void test2(){

        System.out.println("test2");
        int expectedProductCount = 1;
        int actualProductCount = 1;
        Assertions.assertEquals(expectedProductCount, actualProductCount,"expected product count: "
                + expectedProductCount + " actual product count: " + actualProductCount);
        expectedProductCount++;
        Assertions.assertEquals(expectedProductCount, actualProductCount,"expected product count: "
                + expectedProductCount + " actual product count: " + actualProductCount);
    }

    @Test
    public void test3(){

        System.out.println("test3");
        Assertions.fail("Database baglanılamadı");
    }

    @Test
    public void test4(){

        int x = 1;
        Assertions.assertFalse(false,"deger false olmalı");
        Assertions.assertNotEquals(3, x,x + " deger 3 olmamalı");
        Assertions.assertNull(null);
        Assertions.assertNotNull(x);
        System.out.println("test4");
    }
}
