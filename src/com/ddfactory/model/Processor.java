package com.ddfactory.model;

import java.util.ArrayList;

import com.ddfactory.observer.Observable;
import com.ddfactory.observer.Observateur;

public class Processor implements Observable{

	private ArrayList<Observateur> listObs = new ArrayList<Observateur>();
	private String texte = "";
	private boolean operateur = false;
	private double op1 = 0, op2 = 0;
	private String typeOperateur = "";
	
	
	public void calculate(String str) {
		

		if(str.equalsIgnoreCase("c")) {
			this.texte = "";
			this.updateObservateur();
			return;
		}
		
		if(str.equalsIgnoreCase("=")) {
			resultatOperation(op1, op2, typeOperateur);
			this.operateur = false;
			this.updateObservateur();
			return;
		}
		
		if(str.equalsIgnoreCase("+") || str.equalsIgnoreCase("-") || str.equalsIgnoreCase("/") || str.equalsIgnoreCase("*")) {
			
			typeOperateur = str.toLowerCase();
			if(this.operateur) {
				op1 = resultatOperation(op1, op2, typeOperateur);
			}
			this.operateur = true;
		}
		
		this.texte+=str;
		
		
//		switch(str) {
//		case "c": this.texte = "";
//				break;
//		case "+" : this.operateur = true;
//				this.typeOperateur = str;
//		default : this.texte+=str;
//		}
		
		
		
		
		
		
		

		
		this.updateObservateur();
		
	}
	
	private double resultatOperation(double op1, double op2, String operateur) {
		
		
		return 0;
		
	}
	
	@Override
	public void addObservateur(Observateur obs) {

		this.listObs.add(obs);
		
	}

	@Override
	public void updateObservateur() {
		
		for(Observateur obs : listObs) obs.update(this.texte);
		
	}

	@Override
	public void delObservateur() {

		this.listObs = new ArrayList<Observateur>();
		
	}

}
