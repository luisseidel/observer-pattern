package org.acme;

import org.acme.Observer;


public interface IEstacaoMeteorologica {
	public void subcribe(Observer observer);
	public void remove(Observer observer);
	public void notificar();
}