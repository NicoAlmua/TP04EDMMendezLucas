package ar.edu.unju.edm.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table (name="PRODUCTOS")
@Component
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int codigo;
	@Column
	private String nombre;
	@Column
	private double precio;
	@Column
	private String marca;
	@Column
	private int stock;
	@Column
	private Integer stock1;
	
	@OneToMany(mappedBy ="producto", cascade = CascadeType.ALL)
	private List<Venta> ventas = new ArrayList<Venta>();
	
	public Producto() {
		// TODO Auto-generated constructor stub
	}

	public Producto(int codigo, String nombre, double precio, String marca, int stock, Integer stock1) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
		this.marca = marca;
		this.stock = stock;
		this.stock1 = stock1;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Integer getStock1() {
		return stock1;
	}

	public void setStock1(Integer stock1) {
		this.stock1 = stock1;
	}
	
	
}
