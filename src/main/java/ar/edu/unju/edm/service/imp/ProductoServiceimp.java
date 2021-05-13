package ar.edu.unju.edm.service.imp;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Producto;
import ar.edu.unju.edm.service.ProductoService;
import ar.edu.unju.edm.util.ListadoProductos;

@Service
public class ProductoServiceimp implements ProductoService {
	//como se hace la solucion del problema
	
	private static final Log LOGGER = LogFactory.getLog(ProductoServiceimp.class);
	
	private List<Producto> listaDeProductos = ListadoProductos.productos;
	
	@Autowired
	Producto unProducto;
	
	@Override
	public void guardarProducto(Producto unProducto) {
		// TODO Auto-generated method stub
		System.out.println(unProducto.getNombre());
		listaDeProductos.add(unProducto);
		System.out.println(listaDeProductos.size());
		
		LOGGER.info("METHOD: ingresando a Guardar Producto");
		LOGGER.info("RESULT: guardado " + listaDeProductos.get(listaDeProductos.size()-1).getNombre());
	}

	@Override
	public List<Producto> obtenerTodosProductos() {
		// TODO Auto-generated method stub
		return listaDeProductos;
	}

	@Override
	public Producto obtenerProductoNuevo() {
		// TODO Auto-generated method stub
		return unProducto;
	}

	@Override
	public Producto obtenerUltimoProducto() {
		// TODO Auto-generated method stub
		int i = listaDeProductos.size() - 1;
		return listaDeProductos.get(i);
	}

	@Override
	public Producto encontrarUnProducto(int codigo) {
		
		for (int i = 0; i < listaDeProductos.size(); i++) {
			unProducto = listaDeProductos.get(i);
		}
		return unProducto;
	}

	@Override
	public Producto crearProducto() {
		// TODO Auto-generated method stub
		return unProducto;
	}

	@Override
	public void modificarProducto(Producto productoModificado) {
		// TODO Auto-generated method stub
		for (int i = 0; i < listaDeProductos.size(); i++) {
			if (listaDeProductos.get(i).getCodigo() == productoModificado.getCodigo()) {
				listaDeProductos.set(i, productoModificado);
			}
		}
		
	}
	
}
