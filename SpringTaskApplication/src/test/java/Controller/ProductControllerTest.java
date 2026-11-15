package Controller;
import Entity.Product;
import Service.ProductService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.ArgumentCaptor;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    @Mock
    private ProductService service;

    @InjectMocks
    private ProductController controller;

    @ParameterizedTest
    @ValueSource(longs = {1L, 2L, 5L})
    void testGetProduct(Long id) {

        Product product =
                new Product("Laptop", "Electronics", 55000);

        when(service.getProduct(id)).thenReturn(product);

        Product result = controller.getProduct(id);

        assertEquals("Laptop", result.getName());

        verify(service).getProduct(id);
    }

    @Test
    void testAddProduct() {

        Product product =
                new Product("Mobile", "Electronics", 20000);

        when(service.addProduct(product)).thenReturn(product);

        controller.addProduct(product);

        ArgumentCaptor<Product> captor =
                ArgumentCaptor.forClass(Product.class);

        verify(service).addProduct(captor.capture());

        assertEquals("Mobile", captor.getValue().getName());
        assertEquals(20000, captor.getValue().getPrice());
    }
}

