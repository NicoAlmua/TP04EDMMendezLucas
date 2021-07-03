package ar.edu.unju.edm.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ar.edu.unju.edm.model.Producto;
import ar.edu.unju.edm.service.IProductoService;

@Controller
public class ProductoController {
	private static final Log NICOLAS = LogFactory.getLog(ProductoController.class);
	
	@Autowired
	@Qualifier("mysql")
	IProductoService iProductoService;
	
	@GetMapping({ "/producto/mostrar" })
	public String cargarProducto(Model model){
		model.addAttribute("unProducto", iProductoService.obtenerProductoNuevo());
		model.addAttribute("productos", iProductoService.obtenerTodosProductos());
		return ("producto");
	}
	
	@PostMapping ("/producto/guardar")
	public String guardarNuevoProducto(@ModelAttribute("unProducto")Producto nuevoProducto, Model model){
		iProductoService.guardarProducto(nuevoProducto);
		System.out.println(iProductoService.obtenerTodosProductos().get(0).getMarca());
		//model.addAttribute("productos", iProductoService.obtenerTodosProductos());
		NICOLAS.info("solo de prueba");
		return "redirect:/producto/mostrar";
	}

	@GetMapping("/producto/editar/{codigo}")
	public String editarProducto (Model model, @PathVariable(name="codigo") int codigo) throws Exception {
		try {
			Producto productoEncontrado = iProductoService.encontrarUnProducto(codigo);
			model.addAttribute("unProducto", productoEncontrado);	
			model.addAttribute("editMode", "true");
		}

		catch (Exception e) {
			model.addAttribute("formUsuarioErrorMessage",e.getMessage());
			model.addAttribute("unProducto", iProductoService.crearProducto());
			model.addAttribute("editMode", "false");
		}
		model.addAttribute("productos", iProductoService.obtenerTodosProductos());
		return("producto");
	}


	@PostMapping("/producto/modificar")
	public String modificarProducto(@ModelAttribute("unProducto") Producto productoModificado, Model model) {


		try {
			iProductoService.modificarProducto(productoModificado);
			model.addAttribute("unProducto", new Producto());				
			model.addAttribute("editMode", "false");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// pasar las excepciones al html
			model.addAttribute("formUsuarioErrorMessage",e.getMessage());
			model.addAttribute("unProducto", productoModificado);			
			model.addAttribute("productos", iProductoService.obtenerTodosProductos());
			model.addAttribute("editMode","true");

		}

		model.addAttribute("productos", iProductoService.obtenerTodosProductos());
		return("producto");

	}
	
	@GetMapping("/producto/eliminarProducto/{id}")
	public String eliminarProducto(Model model, @PathVariable(name="id") int id) {
		try {
			iProductoService.eliminarProducto(id);			
		}
		catch(Exception e){
			model.addAttribute("listErrorMessage",e.getMessage());
		}			
		return "redirect:/producto/mostrar";
	}
	
	
}
