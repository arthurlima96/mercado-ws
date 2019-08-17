package br.com.crudjdbc.database.servico;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import br.com.crudjdbc.database.factories.ConnectionFactory;

@Path("servico")
public class Servicos {
	
	
	@GET
	@Path("conexao")
	public String test() {
		ConnectionFactory.getConnection();
		return "Funciona";
	}
	
}
