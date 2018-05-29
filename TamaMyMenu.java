package it.unibs.fp.lab.tamagotchi;

import it.unibs.fp.mylib.EstrazioniCasuali;
import it.unibs.fp.mylib.MyMenu;

public class TamaMyMenu {
	public static final int MIN_RAND = 0;
	public static final int MAX_RAND = 5;
	
	
	public static int tamaMenu(Tamagotchi tama) {
	int termina = 1;
	
		String[] opzione = new String[] {"dai carezze","dai biscotti"};
		MyMenu myMenu = new MyMenu("scelta opzioni", opzione);
		int scelta = myMenu.scegli();
		switch (scelta) {
			
		
			case 0: {
						termina = 0;
						break; 
					}
	
		 
			case 1: {	
						int carezze;				
						carezze = EstrazioniCasuali.estraiIntero(MIN_RAND, MAX_RAND);
						//System.out.println("numero generato: " + carezze);
						tama.riceviCarezze(carezze);
						break;
					}	
		
			case 2: {	
						int biscotti;
						biscotti = EstrazioniCasuali.estraiIntero(MIN_RAND, MAX_RAND);
						//System.out.println("numero generato: " + biscotti);
						tama.riceviBiscotti(biscotti);
						break;
					}
		}
		return termina;
	}
}
