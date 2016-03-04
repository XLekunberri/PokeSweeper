package org.pokesweeper.view;

import org.pokesweeper.model.LaukiFactory;
import org.pokesweeper.model.Tableroa;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JPanel;

public class TableroaUI extends JPanel{
	
	//Atributoak
	private static final long serialVersionUID = 1L;
	public LaukiaUI laukia[][];
	private static TableroaUI helbidea;
	private final Tableroa tableroLogikoa = Tableroa.getNireTableroa();

	//Eraikitzailea
	public static TableroaUI getNireTableroaUI(){
		if (helbidea == null){
			helbidea = new TableroaUI();
		}
		return helbidea;
	}

	private TableroaUI() {
		this.setBackground(new Color(160, 224, 192));	
	}
	
	//Beste metodoak
	public void tableroaEraiki() {
		int errenkada = tableroLogikoa.getErrenkadaKop();
		int zutabe = tableroLogikoa.getZutabeKop();
		this.laukia = new LaukiaUI[errenkada][zutabe];
		this.removeAll();
									  
									  //(errenkadaKopurua, zutabeKopurua) -- GridLayout 
		GridLayout grid = new GridLayout(errenkada+2, zutabe+2, 0, 0);
		this.setLayout(grid);
		
		LaukiFactory factory = LaukiFactory.getNireFactory();
		this.add(factory.createKanpoLaukia(0));
		for(int zut = 0; zut < zutabe; zut++) {
			this.add(factory.createKanpoLaukia(1));
		}
		this.add(factory.createKanpoLaukia(2));
		for(int erren = 0; erren < errenkada; erren++) {
			this.add(factory.createKanpoLaukia(3));
			for(int zut = 0; zut < zutabe; zut++) {
				this.laukia[erren][zut] = factory.createLaukiUI(erren, zut);
				this.add(this.laukia[erren][zut]);
			}
			this.add(factory.createKanpoLaukia(5));
		}	
		this.add(factory.createKanpoLaukia(6));
		for(int zut = 0; zut < zutabe; zut++) {
			this.add(factory.createKanpoLaukia(7));
		}
		this.add(factory.createKanpoLaukia(8));
	}

}