package com.krakedev.productos.prubasUnitarias;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.krakedev.productos.entidad.Producto;
import com.krakedev.productos.servicio.ProductoService;

public class ProductoServiceTest {

    // 1. Crear producto correctamente
    @Test
    public void testCrearProducto() {

        ProductoService servicio = new ProductoService();

        Producto producto = new Producto(
                "P001",
                "Laptop Lenovo",
                850.50,
                10);

        Producto resultado = servicio.crear(producto);

        // Se espera que el producto se cree correctamente
        assertEquals("P001", resultado.getCodigo());
        assertEquals("Laptop Lenovo", resultado.getNombre());
        assertEquals(850.50, resultado.getPrecio());
        assertEquals(10, resultado.getStock());
    }

    // 2. Crear producto duplicado
    @Test
    public void testCrearProductoDuplicado() {

        ProductoService servicio = new ProductoService();

        Producto producto1 = new Producto(
                "P001",
                "Laptop Lenovo",
                850.50,
                10);

        Producto producto2 = new Producto(
                "P001",
                "Mouse Logitech",
                35.99,
                50);

        servicio.crear(producto1);

        Producto resultado = servicio.crear(producto2);

        // Se espera null porque el código ya existe
        assertNull(resultado);
    }

    // 3. Buscar producto existente
    @Test
    public void testBuscarProductoExistente() {

        ProductoService servicio = new ProductoService();

        Producto producto = new Producto(
                "P002",
                "Teclado Redragon",
                70.00,
                25);

        servicio.crear(producto);

        Producto encontrado =
                servicio.buscarPorCodigo("P002");

        // Se espera encontrar el producto
        assertEquals("Teclado Redragon",
                encontrado.getNombre());

        assertEquals(70.00,
                encontrado.getPrecio());

        assertEquals(25,
                encontrado.getStock());
    }

    // 4. Buscar producto no existente
    @Test
    public void testBuscarProductoNoExistente() {

        ProductoService servicio =
                new ProductoService();

        Producto encontrado =
                servicio.buscarPorCodigo("X999");

        // Se espera null porque el producto no existe
        assertNull(encontrado);
    }

    // 5. Listar productos
    @Test
    public void testListarProductos() {

        ProductoService servicio =
                new ProductoService();

        Producto producto1 = new Producto(
                "P001",
                "Monitor Samsung",
                250.00,
                8);

        Producto producto2 = new Producto(
                "P002",
                "Audifonos Sony",
                120.00,
                15);

        servicio.crear(producto1);
        servicio.crear(producto2);

        List<Producto> productos =
                servicio.listar();

        // Se espera que existan 2 productos
        assertEquals(2, productos.size());
    }

    // 6. Actualizar producto existente
    @Test
    public void testActualizarProductoExistente() {

        ProductoService servicio =
                new ProductoService();

        Producto producto = new Producto(
                "P003",
                "Tablet Samsung",
                400.00,
                12);

        servicio.crear(producto);

        Producto actualizado = new Producto(
                "P003",
                "Tablet Samsung Pro",
                650.00,
                20);

        Producto resultado =
                servicio.actualizar(
                        "P003",
                        actualizado);

        // Se espera que los datos se actualicen
        assertEquals("Tablet Samsung Pro",
                resultado.getNombre());

        assertEquals(650.00,
                resultado.getPrecio());

        assertEquals(20,
                resultado.getStock());
    }

    // 7. Actualizar producto no existente
    @Test
    public void testActualizarProductoNoExistente() {

        ProductoService servicio =
                new ProductoService();

        Producto actualizado = new Producto(
                "P999",
                "Producto Fantasma",
                999.00,
                1);

        Producto resultado =
                servicio.actualizar(
                        "P999",
                        actualizado);

        // Se espera null porque no existe
        assertNull(resultado);
    }

    // 8. Eliminar producto existente
    @Test
    public void testEliminarProductoExistente() {

        ProductoService servicio =
                new ProductoService();

        Producto producto = new Producto(
                "P004",
                "Impresora Epson",
                300.00,
                5);

        servicio.crear(producto);

        boolean eliminado =
                servicio.eliminar("P004");

        // Se espera true porque sí existe
        assertTrue(eliminado);
    }

    // 9. Eliminar producto no existente
    @Test
    public void testEliminarProductoNoExistente() {

        ProductoService servicio =
                new ProductoService();

        boolean eliminado =
                servicio.eliminar("P999");

        // Se espera false porque no existe
        assertFalse(eliminado);
    }
}