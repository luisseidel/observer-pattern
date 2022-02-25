package org.acme;

import org.acme.IEstacaoMeteorologica;
import org.acme.Observer;

import java.util.ArrayList;
import java.util.List;


public class EstacaoMeteorologica implements IEstacaoMeteorologica {
	
	public List<Observer> observers;
	
	private double temperatura;
	private double pressao;
	private double umidade;
	
	public void atualizarInformacoes(double temperatura, double pressao, double umidade) {
		this.temperatura = temperatura;
		this.pressao = pressao;
		this.umidade = umidade;
		notificar();
	}
	
	public EstacaoMeteorologica() {
		this.observers = new ArrayList<Observer>();
	}
	
	@Override
	public void subcribe (Observer observer) {
		observers.add(observer);
	}
	
	@Override
	public void remove (Observer observer) {
		observers.remove(observer);
		System.out.println("observador saiu");
	}
	
	@Override
	public void notificar () {
		System.out.println("Nova Atualizacao");
		observers.stream().forEach(observer ->  {
			observer.update();
		});
	}
	
	public double getTemperatura () {
		return temperatura;
	}
	
	public void setTemperatura (double temperatura) {
		this.temperatura = temperatura;
	}
	
	public double getPressao () {
		return pressao;
	}
	
	public void setPressao (double pressao) {
		this.pressao = pressao;
	}
	
	public double getUmidade () {
		return umidade;
	}
	
	public void setUmidade (double umidade) {
		this.umidade = umidade;
	}
}