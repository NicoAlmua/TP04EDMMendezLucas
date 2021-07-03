package ar.edu.unju.edm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Producto;

@Service
public interface IProductoService {
	//que hace con producto
	
	public void guardarProducto(Producto unProducto);
	public List<Producto> obtenerTodosProductos();
	public Producto obtenerProductoNuevo();
	public Producto obtenerUltimoProducto();
	public Producto encontrarUnProducto(int codigo) throws Exception;
	public Producto crearProducto();
	public void modificarProducto(Producto productoModificado) throws Exception;
	public void eliminarProducto(int codigo) throws Exception;
}
