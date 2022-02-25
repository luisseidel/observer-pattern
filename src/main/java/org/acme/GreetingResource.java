package org.acme;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Random;


@Path("/hello")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
		EstacaoMeteorologica estacao = new EstacaoMeteorologica();
		Inmet inmet = new Inmet(estacao);
		Climatempo climaTempo = new Climatempo(estacao);
		Clicktempo clicktempo = new Clicktempo(estacao);
		
		int count = 0;
		
		while(count<= 10) {
			double temp = new Random().nextDouble();
			double umidade = new Random().nextDouble();
			double pressao = new Random().nextDouble();
			
			estacao.atualizarInformacoes(temp, pressao, umidade);
			
			if (count == 3) {
				estacao.remove(inmet);
			}
			
			if (count == 6) {
				estacao.remove(climaTempo);
			}
			
			try {
				Thread.sleep(3000);
				
				if (count == 10) {
					System.out.println("Fimm...");
					System.exit(0);
				}
				count++;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		return "Hello RESTEasy";
    }
}