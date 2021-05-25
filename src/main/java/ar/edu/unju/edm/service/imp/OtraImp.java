package ar.edu.unju.edm.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Cliente;
import ar.edu.unju.edm.repository.IclienteDAO;
import ar.edu.unju.edm.service.IClienteService;

@Service
@Qualifier("mysql")
public class OtraImp implements IClienteService{

	@Autowired
	Cliente unCliente;
	
	@Autowired
	IclienteDAO clienteDAO;
	
	
	@Override
	public void guardarCliente(Cliente unCliente) {
		// TODO Auto-generated method stub
		//puedo implementar guardar en una BD y no en un listado
		clienteDAO.save(unCliente);
	}

	@Override
	public Cliente crearCliente() {
		// TODO Auto-generated method stub
		return unCliente;
	}

	@Override
	public List<Cliente> obtenerTodosClientes() {
		// TODO Auto-generated method stub
		return (List<Cliente>)clienteDAO.findAll();
	}

	@Override
	public Cliente encontrarUnCliente(int dni) throws Exception {
		// TODO Auto-generated method stub
		return clienteDAO.findByNroDocumento(dni).orElseThrow(()->new Exception("EL cliente no existe"));
	}

	@Override
	public void modificarCliente(Cliente unClienteModificado) throws Exception {
		// TODO Auto-generated method stub
		Cliente clienteAModificar = clienteDAO.findByNroDocumento(unClienteModificado.getNroDocumento()).orElseThrow(()->new Exception("El Cliente no fue encontrado"));
		cambiarCliente(unClienteModificado, clienteAModificar);
		clienteDAO.save(clienteAModificar);
	}

	private void cambiarCliente(Cliente desde, Cliente hacia) {
		hacia.setNroDocumento(desde.getNroDocumento());
		hacia.setTipoDocumento(desde.getTipoDocumento());
		hacia.setFechaNacimiento(desde.getFechaNacimiento());
		hacia.setCodigoAreaTelefono(desde.getCodigoAreaTelefono());
		hacia.setNumTelefono(desde.getNumTelefono());
		hacia.setEmail(desde.getEmail());
	}
	
	@Override
	public void eliminarCliente(int dni) throws Exception {
		// TODO Auto-generated method stub
		Cliente clienteEliminar = clienteDAO.findByNroDocumento(dni).orElseThrow(()->new Exception("El Cliente no fue encontrado"));
		clienteDAO.delete(clienteEliminar);
	}

}
