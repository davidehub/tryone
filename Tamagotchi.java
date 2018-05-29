package it.unibs.fp.lab.tamagotchi;
public class Tamagotchi {

	//attributi
	public static final double SOGLIA_TRISTE_INF = 30.0;
	public static final double SOGLIA_CIBO_TRISTE_SUP = 90.0;
	public static final double VALORE_MAX = 100.0;
	public static final double TROPPO_CIBO = VALORE_MAX;
	public static final double MODIFIER_CAREZZE = 2.0;
	public static final double MODIFIER_BISCOTTI = 4.0;
	public static final double PERCENTUALE_BISCOTTI = 10.0;

	private String nome;
	private double soddisfazione;
	private double sazieta;
	
	//metodi
	public Tamagotchi(String name, int satisfaction, int hunger ) {
		nome = name;
		soddisfazione = satisfaction;
		sazieta = hunger;
	}

	
	public String getNome() {
		return nome;
	}


	public double getSoddisfazione() {
		return soddisfazione;
	}


	public double getSazieta() {
		return sazieta;
	}

	
	
	public void riceviCarezze(int numCarezze)
	{	
		soddisfazione = Math.min(soddisfazione + numCarezze, VALORE_MAX);
		double diminuisci = numCarezze/MODIFIER_CAREZZE;
		sazieta = Math.max((sazieta - diminuisci), 0);
	}
	
	public void riceviBiscotti (int numBiscotti)
	{
		for(int i = numBiscotti; i > 0; i--)
		{	
			sazieta = (sazieta + (sazieta/PERCENTUALE_BISCOTTI));
		}
		sazieta = Math.min(sazieta, VALORE_MAX);		
		double diminuisci = numBiscotti/MODIFIER_BISCOTTI;
		soddisfazione = Math.max(soddisfazione - diminuisci, 0);
	}
	
	/*public boolean sonoFelice() {
		
		if (( getSoddisfazione() > SOGLIA_FELICE ) && ( getSazieta() > SOGLIA_FELICE ) && ( getSazieta() < SOGLIA_CIBO_TRISTE_SUP ))			
			return true;
		else
			return false;
		
	}*/
	
	public boolean sonoTriste() {
		
		if (( getSoddisfazione() < SOGLIA_TRISTE_INF ) || ( getSazieta() < SOGLIA_TRISTE_INF ) || ( getSazieta() > SOGLIA_CIBO_TRISTE_SUP )
				&& ( getSazieta() < VALORE_MAX ))
			return true;
		else
			return false;
	}
	
	public boolean sonoMorto() {
		if (( getSoddisfazione() == 0 ) || ( getSazieta() == 0 ) || ( getSazieta()==TROPPO_CIBO ))
			return true;
		else
			return false;
	}
	
	public String toString() {
		String status;
		
		status = String.format("Status %s : carezze: %.2f biscotti: %.2f\n", this.getNome(), this.getSoddisfazione(), this.getSazieta());
		
		String stringa = ("");
		if (sonoMorto() == true)
			stringa = "il tuo tamagotchi e' morto";
		else
			if (sonoTriste() == true)
				stringa  = ("Il tuo tamagotchi e' triste");
			/*else
			if (sonoFelice()==true)
			stringa = ("Il tuo tamagotchi è contento ");*/
			/*else
			stringa = ("il tuo tamagochi non prova niente");*/
		status = (status + stringa);
		
		return status;
	}

}