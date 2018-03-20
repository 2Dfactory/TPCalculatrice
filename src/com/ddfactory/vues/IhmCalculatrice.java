package com.ddfactory.vues;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class IhmCalculatrice extends JFrame implements ActionListener{
	
	private JLabel jt = new JLabel();
	private JPanel buttonArea1 = new JPanel();
	private JPanel buttonArea2 = new JPanel();
	
	private String[] listOfButtonA1 = {"1","2","3","4","5","6","7","8","9","0",".","="};
	private String[] listOfButtonA2 = {"C","+","-","*","/"};
	

	public IhmCalculatrice() {
		
		this.setTitle("Calculatrice");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setSize(500, 500);
		
		//TODO Essai Border (ajout d'une cadre)
		Border line = BorderFactory.createLineBorder(Color.BLUE, 3);
		jt.setBorder(line);
		jt.setSize(500, 100);
		
		//Initialisation des layouts
		GridLayout glA1 = new GridLayout(4, 3);
		glA1.setHgap(5);
		glA1.setVgap(5);
		
		GridLayout glA2 = new GridLayout(5, 1);
		glA2.setHgap(5);
		glA2.setVgap(5);
		
		buttonArea1.setLayout(glA1);
		buttonArea2.setLayout(glA2);
		
		addButtonToPanel(listOfButtonA1, buttonArea1);
		addButtonToPanel(listOfButtonA2, buttonArea2);
		
		
		BorderLayout contentLayout = new BorderLayout();
		contentLayout.setHgap(5);
		contentLayout.setVgap(5);
		this.setLayout(contentLayout);
		this.getContentPane().add(jt, BorderLayout.NORTH);
		this.getContentPane().add(buttonArea1, BorderLayout.CENTER);
		this.getContentPane().add(buttonArea2, BorderLayout.EAST);

		
		this.setVisible(true);
		
	}
	
	private void addButtonToPanel(String[] listOfButton, JPanel panel) {
		
		for(String button : listOfButton) {
			
			panel.add(new JButton(button));
			
		}
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
