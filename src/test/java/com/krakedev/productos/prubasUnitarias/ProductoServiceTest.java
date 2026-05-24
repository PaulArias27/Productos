package com.krakedev.productos.prubasUnitarias;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.krakedev.productos.entidad.Producto;
import com.krakedev.productos.servicio.ProductoService;

public class ProductoServiceTest {

    @Test
    public void testCrearProducto() {

        ProductoService servicio =
                new ProductoService();

        Producto producto =
                new Producto(
                        "P001",
                        "Laptop",
                        900.0);

        Producto resultado =
                servicio.crear(producto);

        assertEquals(
                "Laptop",
                resultado.getNombre());
    }

    @Test
    public void testBuscarProducto() {

        ProductoService servicio =
                new ProductoService();

        Producto producto =
                new Producto(
                        "P001",
                        "Mouse",
                        50.0);

        servicio.crear(producto);

        Producto encontrado =
                servicio.buscarPorCodigo("P001");

        assertEquals(
                "Mouse",
                encontrado.getNombre());
    }

    @Test
    public void testActualizarProducto() {

        ProductoService servicio =
                new ProductoService();

        Producto producto =
                new Producto(
                        "P001",
                        "Monitor",
                        300.0);

        servicio.crear(producto);

        Producto actualizado =
                new Producto(
                        "P001",
                        "Monitor Gamer",
                        500.0);

        Producto resultado =
                servicio.actualizar(
                        "P001",
                        actualizado);

        assertEquals(
                "Monitor Gamer",
                resultado.getNombre());
    }

    @Test
    public void testEliminarProducto() {

        ProductoService servicio =
                new ProductoService();

        Producto producto =
                new Producto(
                        "P001",
                        "Teclado",
                        80.0);

        servicio.crear(producto);

        boolean eliminado =
                servicio.eliminar("P001");

        assertTrue(eliminado);
    }

    @Test
    public void testProductoNoExiste() {

        ProductoService servicio =
                new ProductoService();

        Producto encontrado =
                servicio.buscarPorCodigo("X999");

        assertNull(encontrado);
    }

    @Test
    public void testEliminarNoExistente() {

        ProductoService servicio =
                new ProductoService();

        boolean eliminado =
                servicio.eliminar("X999");

        assertFalse(eliminado);
    }
}