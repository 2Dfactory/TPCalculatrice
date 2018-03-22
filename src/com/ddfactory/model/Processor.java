package com.ddfactory.model;

import java.util.ArrayList;

import com.ddfactory.observer.Observable;
import com.ddfactory.observer.Observateur;

public class Processor implements Observable{

	private ArrayList<Observateur> listObs = new ArrayList<Observateur>();
	private String texte = "";
	
	public void calculate(String str) {
		
		switch(str) {
		case "c": this.texte ="";
				break;
		default:this.texte+=str;
			
		}
		
		this.updateObservateur();
		
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
