package ru.netology.domains;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.product.Book;
import ru.netology.product.Product;
import ru.netology.product.Smartphone;
import ru.netology.repository.ProductManager;
import ru.netology.repository.ProductRepository;

public class ProductManagerTest {

    Product product1 = new Book(1235, "451° по Фаренгейту", 1_000, "Рэй Брэдбери");
    Product product2 = new Book(2578, "1984", 1_300, "Джордж Оруэлл");
    Product product3 = new Book(9562, "Мастер и Маргарита", 900, "Михаил Булгаков");
    Product product4 = new Smartphone(3562, "11T Pro", 1_000, "Xiaomi");
    Product product5 = new Smartphone(1425, "Galaxy S21 FE", 1_000, "Samsung");
    Product product6 = new Smartphone(7451, "iPhone 13 Pro", 1_000, "Apple");


    @Test
    public void shouldAddProduct() {

        ProductManager manager = new ProductManager(new ProductRepository());

        manager.addProduct(product1);
        manager.addProduct(product2);
        manager.addProduct(product3);

        Product[] expected = {product1, product2, product3};
        Product[] actual = manager.getAddProduct();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchProduct() {

        ProductManager manager = new ProductManager(new ProductRepository());

        manager.addProduct(product1);
        manager.addProduct(product2);
        manager.addProduct(product3);
        manager.addProduct(product4);

        Product[] expected = {product2};
        Product[] actual = manager.searchBy("1984");

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldNoSearchProduct() {

        ProductManager manager = new ProductManager(new ProductRepository());


        Product[] expected = {};
        Product[] actual = manager.searchBy("Мастер и Маргарита");

        Assertions.assertArrayEquals(expected, actual);
    }
}
