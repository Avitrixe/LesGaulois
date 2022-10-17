package personnages;

import java.util.*;

public class Druide {
	
	private String nom;
	private int effetPotionMin;
	private int effetPotionMax;
	private int forcePotion = 1;
	
	public Druide(String nom, int effetPotionMin, int effetPotionMax) {
		this.nom = nom;
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax = effetPotionMax;
		parler("Bonjour, je suis le druide " + nom + " et ma potion peut aller d'une force " + effetPotionMin + " � " + effetPotionMax + ".");
	}
	
	private void parler(String texte) {
		// TODO Auto-generated method stub
		System.out.println(prendreParole() + "<< " + texte + ">>");
	}

	private String prendreParole() {
		// TODO Auto-generated method stub
		return "Le druide " + nom + " : ";
	}

	public String getNom() {
		return nom;
	}
	
	public void preparerPotion() {
		Random random = new Random();
		while(forcePotion < effetPotionMin) {
		forcePotion = random.nextInt(effetPotionMax);
		}
		if (forcePotion > 7) {
			parler("J'ai préparé une super potion de force "+ forcePotion);
		}
		else {
			parler("Je n'ai pas trouvé tous les ingrédients, ma potion est seulement de force "+ forcePotion);
		}
	}
	
	public void booster(Gaulois gaulois) {
		if(gaulois.getNom() != "Obélix") {
			gaulois.boirePotion(forcePotion);
		}
		else {
			parler("Non, Obélix... Tu n'auras pas de potion magique !");
			gaulois.parler("Par Bélénos, ce n'est pas juste !");
		}
	}
	
	public static void main(String[] args) {
		Druide panoramix = new Druide("Panoramix", 5, 10);
		panoramix.preparerPotion();
	}

}
