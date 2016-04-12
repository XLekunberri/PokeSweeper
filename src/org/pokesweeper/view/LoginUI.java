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
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import org.pokesweeper.model.Login;
import org.pokesweeper.model.Helbideak;


public class LoginUI extends JDialog {
	
	//Atributoak
	private static final long serialVersionUID = 1L;
	private final JLabel erabiltzailea = new JLabel("Erabiltzailea: ");
	private final JLabel pasahitza = new JLabel("Pasahitza:  ");
	private final JLabel maila = new JLabel("Maila: ");
	private final JTextField erabiltzaileField = new JTextField(15);
	private final JTextField pasahitzaField = new JPasswordField(16);
	private ButtonGroup bg;
	private JRadioButton r1, r2, r3;
    private final JButton jbtOk = new JButton("Sartu");
    
    //Eraikitzailea
    public LoginUI(JFrame frame) {
    	super(frame, "Logina");
    	this.setResizable(false);
    	
    	bg = new ButtonGroup();
    	r1 = new JRadioButton("1. Maila");
    	r2 = new JRadioButton("2. Maila");
    	r3 = new JRadioButton("3. Maila");
    	
    	r1.setSelected(true);
    	r1.setFocusPainted(false);
    	r2.setFocusPainted(false);
    	r3.setFocusPainted(false);
    	
    	bg.add(r1);
    	bg.add(r2);
    	bg.add(r3);
    	
    	JPanel p1 = new JPanel();
    	p1.add(erabiltzailea);
    	p1.add(erabiltzaileField);
    	
    	JPanel p12 = new JPanel();
    	p12.add(pasahitza);
    	p12.add(pasahitzaField);
    	
    	JPanel p13 = new JPanel(new BorderLayout());
    	p13.add(p1, BorderLayout.NORTH);
    	p13.add(p12, BorderLayout.SOUTH);
    	
    	JPanel p3 = new JPanel(new GridLayout(1,  3));
    	p3.add(r1);
    	p3.add(r2);
    	p3.add(r3);
    	
    	JPanel p2 = new JPanel();
    	p2.add(maila);
    	p2.add(p3);
    	
    	JPanel p4 = new JPanel(new GridLayout(2, 1));
    	p4.add(p13);
    	p4.add(p2);
    	
    	JPanel p5 = new JPanel(new BorderLayout());
    	p5.add(p4, BorderLayout.NORTH);
    	p5.add(jbtOk, BorderLayout.CENTER);
    	
    	JLabel oak = new JLabel(Helbideak.oak);
        
        JPanel p6 = new JPanel();
        p6.setLayout(new BorderLayout(0, 0));
        p6.add(oak, BorderLayout.NORTH);
        p6.add(p5, BorderLayout.SOUTH);
        
    	add(p6);
    	
    	getRootPane().setDefaultButton(jbtOk);
    	
    	this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
    	
    	pack();
    	setLocationRelativeTo(null);
    	
    	jbtOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String erabiltzailea = erabiltzaileField.getText().trim();
				String pasahitza = pasahitzaField.getText().trim();
				if (!(erabiltzailea == null || pasahitza == null)){
					if(Login.getNireLogin().logeatu(erabiltzailea, pasahitza)){
						setVisible(false);
						JokoaUI.erabiltzailea = erabiltzailea;
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
				
			}
		});
   
    }
    
    //Beste metodoak
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