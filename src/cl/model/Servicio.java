package cl.model;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;

/**
 * Session Bean implementation class Servicio
 */
@Singleton
@LocalBean
public class Servicio implements ServicioLocal {

	private ArrayList<Cliente> lista= new ArrayList();
	
    /**
     * Default constructor. 
     */
    public Servicio() {
        lista.add(new Cliente("Juan","Perez", "9666516"));
        lista.add(new Cliente("Fabian","Carrasco", "98765432"));
    }

	@Override
	public void addCliente(Cliente cli) {
		lista.add(cli);
	}
	
	@Override
	public ArrayList<Cliente> getClientes() {
		// TODO Auto-generated method stub
		return lista;
	}

	@Override
	public Cliente buscarRut(String rut) {
		for(Cliente cliente: lista){
			if(cliente.getRut().equalsIgnoreCase(rut)){
				return cliente;
			}
		}
		return null;
	}

	@Override
	public String eliminar(String rut) {
		Cliente cliente = buscarRut(rut);
		if (cliente == null){	
			return "rut no encontrado";
		}
		else{
			lista.remove(cliente);
			return "cliente eliminado";
		}
		
	}

	@Override
	public void actualizar(Cliente cliente) {
		this.eliminar(cliente.getRut());
		lista.add(cliente);

	}

}
