package ar.edu.unju.edm.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ar.edu.unju.edm.model.Producto;
import ar.edu.unju.edm.service.ProductoService;

@Controller
public class ProductoController {
	private static final Log NICOLAS = LogFactory.getLog(ProductoController.class);
	
	@Autowired
	ProductoService iProductoService;
	
	@GetMapping({ "/producto" })
	public String cargarProducto(Model model){
		model.addAttribute("unProducto", iProductoService.obtenerProductoNuevo());
		return "producto";
	}
	
	@PostMapping ("/producto")
	public String guardarNuevoProducto(@ModelAttribute("unProducto")Producto nuevoProducto, Model model){
		iProductoService.guardarProducto(nuevoProducto);
		System.out.println(iProductoService.obtenerTodosProductos().get(0).getMarca());
		model.addAttribute("productos", iProductoService.obtenerTodosProductos());
		NICOLAS.info("solo de prueba");
		return "/producto";
	}

}
