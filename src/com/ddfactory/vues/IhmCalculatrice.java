package com.ddfactory.vues;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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

import com.ddfactory.model.Processor;
import com.ddfactory.observer.Observateur;

public class IhmCalculatrice extends JFrame implements ActionListener{
	
	private JLabel label = new JLabel("0");
	private JPanel labelPane = new JPanel();
	private JPanel buttonArea1 = new JPanel();
	private JPanel buttonArea2 = new JPanel();
	private String[] listOfButtonA1 = {"1","2","3","4","5","6","7","8","9","0",".","="};
	private String[] listOfButtonA2 = {"C","+","-","*","/"};
	private String str ="";
	private Processor calc;

	public IhmCalculatrice() {
		
		this.setTitle("Calculatrice");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setSize(300,300);
		
		this.calc = new Processor();
		this.calc.addObservateur(new Observateur() {
			
			@Override
			public void update(String text) {

				label.setText(text);
				
			}
		});
		
		//Choix de la police
		Font police = new Font("Arial", Font.BOLD, 30);
		label.setFont(police);
		//Positionnement du texte dans le JLabel
		label.setHorizontalAlignment(JLabel.RIGHT);
		
		//Ajout d'un cadre au label (Border)
		Border line = BorderFactory.createLineBorder(Color.BLACK, 2);
		label.setBorder(line);
		
		//Dimensionnement du label
		label.setPreferredSize(new Dimension((int)(this.getWidth()-20), (int)(this.getHeight()-(this.getHeight()-40))));;
		
		//Ajout du JLabel "label" dans le JPanel "labelPane"
		labelPane.add(label);
		
		//Initialisation des layouts des JPanel contenant les boutons
		//Utilisation d'un GridLayout pour la zone 1 avec 4 lignes et 3 colonnes
		GridLayout glA1 = new GridLayout(4, 3);
		//Ajout d'un espace de 5px sur chaque objet
		glA1.setHgap(5);
		glA1.setVgap(5);
		
		//Utilisation d'un GridLayout pour la zone 2 avec 5 lignes et 1 colonne
		GridLayout glA2 = new GridLayout(5, 1);
		//Ajout d'un espace de 5px sur chaque objet
		glA2.setHgap(5);
		glA2.setVgap(5);
		
		//Ajout du layout au JPanel de la zone 1
		buttonArea1.setLayout(glA1);
		//Cette zone étant définie en zone centre du BorderLayout, elle occupera tout l'espace
		//Pas de nécessité de définir ses dimensions
		//Ajout d'une bordure invisible afin de séparer le panel du bord de la fenêtre
		buttonArea1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 5));
		
		//Ajout du layout au JPanel de la zone 2
		buttonArea2.setLayout(glA2);
		//Spécification des dimensions du JPanel contenu à droite du BorderLayout
		buttonArea2.setPreferredSize(new Dimension((int)(this.getWidth()-(this.getWidth()-80)), (int)(this.getHeight()-40)));
		//Ajout d'une bordure invisible afin de séparer le panel du bord de la fenêtre
		buttonArea2.setBorder(BorderFactory.createEmptyBorder(10, 5, 10, 10));
		
		//Ajout des boutons dans les zones définies
		addButtonToPanel(listOfButtonA1, buttonArea1);
		addButtonToPanel(listOfButtonA2, buttonArea2);

		//Ajout des JPanel dans le ContentPane du Jframe
		this.getContentPane().add(labelPane, BorderLayout.NORTH);
		this.getContentPane().add(buttonArea1, BorderLayout.CENTER);
		this.getContentPane().add(buttonArea2, BorderLayout.EAST);

		this.setVisible(true);
		
	}
	
	//Fonction prenant un tableau de String et s'en servant pour créer des JButton
	//Implémente un ActionListener sur chaque bouton
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
		
		this.calc.calculate(((JButton)e.getSource()).getText().toLowerCase());
		
	}
	
	
	
}
