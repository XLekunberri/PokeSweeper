package org.pokesweeper.view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.pokesweeper.model.Helbideak;

public class KontadoreaUI extends JPanel {

	//Atributoak
	private static final long serialVersionUID = 1L;
	private JLabel[] kontadorea = new JLabel[3];

	//Eraikitzailea
	public KontadoreaUI() {
		this.setBackground(new Color(112, 200, 160));
		GridLayout grid = new GridLayout(1, 3, 0, 0);
		this.setLayout(grid);
		for(int i = 0; i < kontadorea.length; i++){
			kontadorea[i] = new JLabel(Helbideak.kontadorea[0]);
			this.add(kontadorea[i]);
		}
	}
	
	//Beste metodoak
	public void kontadoreaEguneratu(int pEhunekoa, int pHamarrekoa, int pBatekoa){
		kontadorea[0].setIcon(Helbideak.kontadorea[pEhunekoa]);
		kontadorea[1].setIcon(Helbideak.kontadorea[pHamarrekoa]);
		kontadorea[2].setIcon(Helbideak.kontadorea[pBatekoa]);
	}

}
