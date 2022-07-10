package ru.netology.domains;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.product.Book;
import ru.netology.product.Product;
import ru.netology.product.Smartphone;
import ru.netology.repository.ProductRepository;

public class ProductRepositoryTest {

    Product product1 = new Book(1235, "451° по Фаренгейту", 1_000, "Рэй Брэдбери");
    Product product2 = new Book(2578, "1984", 1_300, "Джордж Оруэлл");
    Product product3 = new Book(9562, "Мастер и Маргарита", 900, "Михаил Булгаков");
    Product product4 = new Smartphone(3562, "11T Pro", 1_000, "Xiaomi");
    Product product5 = new Smartphone(1425, "Galaxy S21 FE", 1_000, "Samsung");
    Product product6 = new Smartphone(7451, "iPhone 13 Pro", 1_000, "Apple");


    @Test
    public void shouldAddNewProduct() {
        ProductRepository repository = new ProductRepository();
        repository.addNewProduct(product1);
        repository.addNewProduct(product2);
        repository.addNewProduct(product3);


        Product[] expected = {product1, product2, product3};
        Product[] actual = repository.getProducts();

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldRemoveById() {

        ProductRepository repository = new ProductRepository();

        repository.addNewProduct(product1);
        repository.addNewProduct(product2);
        repository.addNewProduct(product3);
        repository.addNewProduct(product4);
        repository.addNewProduct(product5);
        repository.removeById(product2.getId());

        Product[] expected = {product1, product3, product4, product5};
        Product[] actual = repository.getProducts();

        Assertions.assertArrayEquals(expected, actual);

    }

}
