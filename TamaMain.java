package it.unibs.fp.lab.tamagotchi;

import it.unibs.fp.mylib.InputDati;

public class TamaMain {
	
	public static final int VALORE_MAX= 100;
	public static final int VALORE_MIN= 0;
	
	public static Tamagotchi creaTama (String stringa) {
		
		String nome = InputDati.leggiStringaNonVuota(stringa + "inserisci il nome del tuo Tamagotchi: "); 
		int soddisfazione;
		soddisfazione = InputDati.leggiIntero("inserisci il numero di carezze iniziali (0-100): ", VALORE_MIN, VALORE_MAX);
		
		int sazieta;
		sazieta = InputDati.leggiIntero("inserisci il numero di biscotti iniziali (0-100): ", VALORE_MIN , VALORE_MAX);
		
		return new Tamagotchi (nome, soddisfazione, sazieta);
	}
	
	public static String saluta() {
		
		String saluto="Ciao benvenuto al gioco del Tamagotchi:\n";
		return saluto;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(saluta());
		Tamagotchi tama1 = creaTama("Tamagotchi 1 - ");
	
		while(!tama1.sonoMorto() && TamaMyMenu.tamaMenu(tama1)!=0) {
			if (tama1.sonoMorto()) break;
			System.out.println("\n" + tama1.toString() + "\n");
		}	
	
		System.out.println("\n" + tama1.toString());

	}
}
