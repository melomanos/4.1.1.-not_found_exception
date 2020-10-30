package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
  private ProductRepository repository = new ProductRepository();
  private Book coreJava = new Book(1, "Книга", 1000, "Автор", 222, 2020);

  @Test
  public void shouldRemoveElement() {
    repository.save(coreJava);
    repository.removeById(1);

    Product[] expected = new Product[]{};
    Product[] actual = repository.findAll();
    assertArrayEquals(expected, actual);
  }

  @Test
  public void shouldRemoveNonExistentElement() {

    int id = 2;
    repository.save(coreJava);

    Product[] expected = new Product[]{coreJava};
    Product[] actual = repository.findAll();

    assertThrows(NotFoundException.class, () -> repository.removeById(id), "Element with id: " + id + " not found");
  }

//  @Test
//  public void shouldRemoveNonExistentElementWithTryCatch() {
//    repository.save(coreJava);
//
//    try {
//      repository.removeById(2);
//    } catch (NotFoundException e) {
//      e.printStackTrace();
//    }
//
//    Product[] expected = new Product[]{coreJava};
//    Product[] actual = repository.findAll();
//    assertArrayEquals(expected, actual);
//  }
}
