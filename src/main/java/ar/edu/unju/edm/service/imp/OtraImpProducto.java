package ar.edu.unju.edm.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Producto;
import ar.edu.unju.edm.repository.IProductoDAO;
import ar.edu.unju.edm.service.IProductoService;

@Service
@Qualifier ("mysql")
public class OtraImpProducto implements IProductoService {

	@Autowired
	Producto unProducto;
	
	@Autowired
	IProductoDAO productoDAO;
	
	@Override
	public void guardarProducto(Producto unProducto) {
		// TODO Auto-generated method stub
		productoDAO.save(unProducto);
	}

	@Override
	public List<Producto> obtenerTodosProductos() {
		// TODO Auto-generated method stub
		return (List<Producto>)productoDAO.findAll();
	}

	@Override
	public Producto obtenerProductoNuevo() {
		// TODO Auto-generated method stub
		return unProducto;
	}

	@Override
	public Producto obtenerUltimoProducto() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Producto encontrarUnProducto(int codigo) throws Exception {
		// TODO Auto-generated method stub
		return productoDAO.findByCodigo(codigo).orElseThrow(()->new Exception("EL producto no existe"));
	}

	@Override
	public Producto crearProducto() {
		// TODO Auto-generated method stub
		return unProducto;
	}

	@Override
	public void modificarProducto(Producto productoModificado) throws Exception {
		// TODO Auto-generated method stub
		Producto productoAModificar = productoDAO.findByCodigo(productoModificado.getCodigo()).orElseThrow(()->new Exception("El Producto no fue encontrado"));
		cambiarProducto(productoModificado, productoAModificar);
		productoDAO.save(productoAModificar);
	}

	private void cambiarProducto(Producto desde, Producto hacia) {
		// TODO Auto-generated method stub
		hacia.setCodigo(desde.getCodigo());
		hacia.setMarca(desde.getMarca());
		hacia.setNombre(desde.getNombre());
		hacia.setPrecio(desde.getPrecio());
		hacia.setStock(desde.getStock());
	}

	@Override
	public void eliminarProducto(int codigo) throws Exception {
		// TODO Auto-generated method stub
		Producto productoEliminar = productoDAO.findByCodigo(codigo).orElseThrow(()->new Exception("El Producto no fue encontrado"));
		productoDAO.delete(productoEliminar);
	}

}
