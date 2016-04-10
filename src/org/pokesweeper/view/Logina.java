package org.pokesweeper.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;


public class Logina extends JDialog {

	private static final long serialVersionUID = 1L;
	
	private final JLabel erabiltzailea = new JLabel("Erabiltzailea");
	private final JLabel maila = new JLabel("Maila");
	
	private final JTextField erabiltzaileField = new JTextField(15);
	
	private ButtonGroup bg;
	private JRadioButton r1, r2, r3;
	
    private final JButton jbtOk = new JButton("Ok");
    
    public Logina(JFrame frame) {
    	super(frame, "Logina");
    	this.setResizable(false);
    	
    	bg = new ButtonGroup();
    	r1 = new JRadioButton("1. Maila");
    	r2 = new JRadioButton("2. Maila");
    	r3 = new JRadioButton("3. Maila");
    	
    	r1.setSelected(true);
    	
    	bg.add(r1);
    	bg.add(r2);
    	bg.add(r3);
    	
    	JPanel p1 = new JPanel(new GridLayout(2,  1));
    	p1.add(erabiltzailea);
    	p1.add(maila);
    	
    	JPanel p3 = new JPanel(new GridLayout(1,  3));
    	p3.add(r1);
    	p3.add(r2);
    	p3.add(r3);
    	
    	JPanel p2 = new JPanel(new GridLayout(2,  1));
    	p2.add(erabiltzaileField);
    	p2.add(p3);
    	
    	JPanel p4 = new JPanel();
    	p4.add(p1);
    	p4.add(p2);
    	
    	JPanel p5 = new JPanel(new BorderLayout());
    	p5.add(p4, BorderLayout.NORTH);
    	p5.add(jbtOk, BorderLayout.CENTER);
 
    	add(p5);
    	this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
    	
    	pack();
    	setLocationRelativeTo(null);
    	
    	jbtOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!erabiltzaileField.getText().isEmpty()){
					setVisible(false);
					JokoaUI.erabiltzailea = erabiltzaileField.getText().trim();
					JokoaUI.getNireJokoa().setJMenuBar(new MenuaUI());
					if(r1.isSelected()) {
						JokoaUI.getNireJokoa().erreseteatu(7, 10, 7, false);
					}
					else if (r2.isSelected()) {
						JokoaUI.getNireJokoa().erreseteatu(10, 15, 20, false);
					}
					else if (r3.isSelected()) {
						JokoaUI.getNireJokoa().erreseteatu(12, 25, 36, false);
					}
				}
				
			}
		});
   
    }
    
    public String getUserName(){
    	String username = erabiltzaileField.getText().trim();
    	if (username.length()<=10){
    		username = username.substring(0, username.length());
    	}
    	else {
    		username = username.substring(0, 10);
    	}
    	return username;
    }

}