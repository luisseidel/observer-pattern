package org.acme;

public class Climatempo implements Observer {
	
	public EstacaoMeteorologica estacao;
	
	Climatempo (EstacaoMeteorologica estacao) {
		this.estacao = estacao;
		this.estacao.subcribe(this);
	}
	
	@Override
	public void update () {
		System.out.println(this.getClass().getName() + " dados atualizados: ");
		System.out.println("Temperatura: " + String.format("%.2f", estacao.getTemperatura()));
		System.out.println("Umidade: " + String.format("%.2f", estacao.getUmidade()));
		System.out.println("Pressão: " + String.format("%.2f", estacao.getPressao()));
	}
}
