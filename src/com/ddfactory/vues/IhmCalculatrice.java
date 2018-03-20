package com.ddfactory.vues;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class IhmCalculatrice extends JFrame implements ActionListener{
	
	private JTextArea jt = new JTextArea();
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
		
		buttonArea1.setLayout(new GridLayout(4,3));
		buttonArea2.setLayout(new GridLayout(5,1));
		
		addButtonToPanel(listOfButtonA1, buttonArea1);
		addButtonToPanel(listOfButtonA2, buttonArea2);
		
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
