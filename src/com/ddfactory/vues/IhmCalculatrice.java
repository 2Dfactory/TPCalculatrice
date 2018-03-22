package com.ddfactory.vues;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
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
	
	private JLabel label = new JLabel();
	private JPanel labelPane = new JPanel();
	//private JPanel centerPane = new JPanel();
	private JPanel buttonArea1 = new JPanel();
	private JPanel buttonArea2 = new JPanel();
	private String[] listOfButtonA1 = {"1","2","3","4","5","6","7","8","9","0",".","="};
	private String[] listOfButtonA2 = {"C","+","-","*","/"};
	private String str ="";

	public IhmCalculatrice() {
		
		this.setTitle("Calculatrice");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setSize(300,400);
		
		//TODO Essai Border (ajout d'une cadre)
		Border line = BorderFactory.createLineBorder(Color.BLACK, 2);
		label.setBorder(line);
		label.setPreferredSize(new Dimension((int)(this.getWidth()-20), (int)(this.getHeight()-(this.getHeight()-40))));;
		
		//labelPane.setPreferredSize(new Dimension((int)(this.getWidth()-20), (int)(this.getHeight()-350)));
		
		labelPane.add(label);
		labelPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		//Initialisation des layouts
		GridLayout glA1 = new GridLayout(4, 3);
		glA1.setHgap(5);
		glA1.setVgap(5);
		
		GridLayout glA2 = new GridLayout(5, 1);
		glA2.setHgap(5);
		glA2.setVgap(5);
		
		buttonArea1.setLayout(glA1);
		//buttonArea1.setPreferredSize(new Dimension((int)(size.getWidth()-100), (int)(size.getHeight()-40)));
		buttonArea1.getInsets();
		buttonArea1.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 0));
		
		buttonArea2.setLayout(glA2);
		buttonArea2.setPreferredSize(new Dimension((int)(this.getWidth()-(this.getWidth()-80)), (int)(this.getHeight()-40)));
		buttonArea2.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 10));
		
		addButtonToPanel(listOfButtonA1, buttonArea1);
		addButtonToPanel(listOfButtonA2, buttonArea2);
		
		
		BorderLayout contentLayout = new BorderLayout();
		contentLayout.setHgap(10);
		contentLayout.setVgap(10);
		this.setLayout(contentLayout);

		this.getContentPane().add(labelPane, BorderLayout.NORTH);
		this.getContentPane().add(buttonArea1, BorderLayout.CENTER);
		this.getContentPane().add(buttonArea2, BorderLayout.EAST);

		this.setVisible(true);
		
	}
	
	private void addButtonToPanel(String[] listOfButton, JPanel panel) {
		
		for(String button : listOfButton) {
			JButton bouton = new JButton(button);
			bouton.addActionListener(this);
			panel.add(bouton);
			
		}
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		System.out.println(str);
		
		switch(((JButton)e.getSource()).getText().toLowerCase()) {
		case "c": str ="";
				break;
		default:str+=((JButton)e.getSource()).getText();
			
		}
		
		label.setText(str);
		
	}
	
	
	
}
