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
			this.op1 = 0;
			this.op2 = 0;
			this.typeOperateur = "";
			str = "";
			this.texte = "";
		}
		
		if(str.equalsIgnoreCase("=")) {
			str = "";
			this.texte = resultatOperation(typeOperateur);
			this.operateur = false;

			if(this.texte.equalsIgnoreCase("Division par 0")) {
				this.updateObservateur();
				this.texte = "";
				return;
			}
			
			this.updateObservateur();
			this.texte = "";
			return;
		}
		
		if(str.equalsIgnoreCase("+") || str.equalsIgnoreCase("-") || str.equalsIgnoreCase("/") || str.equalsIgnoreCase("*")) {
			
			if(this.operateur) {
				
				this.texte = resultatOperation(typeOperateur);
				
				if(this.texte.equalsIgnoreCase("Division par 0")) {
					this.updateObservateur();
					this.texte = "";
					return;
				}
				
				op1 = Double.valueOf(this.texte);
				typeOperateur = str.toLowerCase();
				this.updateObservateur();
				this.texte = "";
				return;
			} else {
				op1 = Double.valueOf(this.texte);
				//this.texte = "";
			}
			
			typeOperateur = str.toLowerCase();
			this.operateur = true;
			str = "";
			
			this.updateObservateur();
			this.texte = "";
			
		}
		
		this.texte+=str;
		
		if(!this.texte.isEmpty()) {
			if(!this.operateur) {
				op1 = Double.valueOf(this.texte);
			}
			else {
				op2 = Double.valueOf(this.texte);
			}
		}
		
		this.updateObservateur();
		
	}
	
	private String resultatOperation(String operateur) {
		
		double resultOp = 0;
		
		switch(operateur) {
		case "+" : resultOp = op1 + op2;
				break;
		case "-" : resultOp = op1 - op2;
				break;
		case "*" : resultOp = op1 * op2;
				break;
		case "/" : 
				if(op2 == 0) return "Division par 0";
				resultOp = op1 / op2;
				break;
		default : 
				break;
		}
		
		this.op1 = 0;
		this.op2 = 0;
		
		return String.valueOf(resultOp);
		
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
