package ar.edu.unju.edm.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="VENTAS")
public class Venta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer codVenta;
	@ManyToOne
	@JoinColumn(name = "codigo")
	private Producto producto;
	@ManyToOne
	@JoinColumn(name = "nroDocumento")
	private Cliente cliente;
	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaVenta;
	@Column
	private Integer cantProductos;
	
	public Venta() {
		// TODO Auto-generated constructor stub
	}

	public Integer getCodVenta() {
		return codVenta;
	}

	public void setCodVenta(Integer codVenta) {
		this.codVenta = codVenta;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public LocalDate getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(LocalDate fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public Integer getCantProductos() {
		return cantProductos;
	}

	public void setCantProductos(Integer cantProductos) {
		this.cantProductos = cantProductos;
	}
	
	
}
