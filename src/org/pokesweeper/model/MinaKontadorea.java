package org.pokesweeper.model;

import org.pokesweeper.view.JokoaUI;

public class MinaKontadorea extends Kontadorea{
	
	//Atributoak
	
	//Eraikitzailea
	public MinaKontadorea(){
		super();
	}
	
	//Beste metodoak
	protected void kontadoreaEguneratu(){
		int ehunekoa = this.kont/100;
		int hamarrekoa = (this.kont%100)/10;
		int batekoa = (this.kont%100) % 10;
		JokoaUI.minaKontadorea.kontadoreaEguneratu(ehunekoa, hamarrekoa, batekoa);
	}
	
	public void kontadoreaErreseteatu() {
		this.kont = 0;
		this.kontadoreaEguneratu();
	}
	
	public void minaGehitu() {
		this.kont++;
		this.kontadoreaEguneratu();
	}
	
	public void minaKendu(){
		this.kont--;
		this.kontadoreaEguneratu();
	}
	public void minaKopuruaJarri(int pZenbakia){
		this.kont = pZenbakia;
		this.kontadoreaEguneratu();
	}
}
