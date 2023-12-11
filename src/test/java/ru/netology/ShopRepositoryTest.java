
package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    Product product1 = new Product(1, "Хлеб", 49);
    Product product2 = new Product(2, "Молоко", 55);
    Product product3 = new Product(3, "Сахар", 70);

    @Test
    public void shouldAllProduct() {
        ShopRepository repo = new ShopRepository();
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Product[] expected = { product1, product2, product3 };
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }
    @Test
    public void shouldDeleteProduct() {
        ShopRepository repo = new ShopRepository();
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.removeById(1);

        Product[] expected = {product2, product3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void test() {
        ShopRepository repo =  new ShopRepository();
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(55);
        });
    }
}
