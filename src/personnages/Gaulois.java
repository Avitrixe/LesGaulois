package personnages;

public class Gaulois {
	
	private String nom;
	private int force;
	private int nbTrophees;
	private int effetPotion = 1;
	private Equipement[] trophees = new Equipement[100];
	
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "<< " + texte + ">>");
	}
	
//	private String prendreParole() {
//		// TODO Auto-generated method stub
//		return "Le gaulois " + nom + " : ";
//	}
	
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}
	
//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoie un grand coup dans la machoire de " + romain.getNom());
//		romain.recevoirCoup((force/3)*effetPotion);
//	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans le mâchoire de " + romain.getNom());
		Equipement[] newTrophees = romain.recevoirCoup((force / 3) * effetPotion);
		for(int i = 0; newTrophees != null && i < newTrophees.length; i++, nbTrophees++) {
			this.trophees[nbTrophees] = newTrophees[i];
		}
	}
	
	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
		parler("Merci Druide, je sens que ma force est "+ effetPotion +" fois dÃ©cuplÃ©e.");
	}
	
	public void faireUneDonation(Musee musee) {
		if(nbTrophees == 0)
		{
			parler("Je n'ai aucun équipement à donner au musée.");
		}
		else
		{
			parler("Je donne au musee tous mes trophees :");
			while(nbTrophees > 0)
			{
				nbTrophees --;
				System.out.println("- " + trophees[nbTrophees]);
				musee.donnerTrophees(this, trophees[nbTrophees]);
			}
		}
	}

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 50);
		Romain minus = new Romain("Minus", 2);
		Musee musee = new Musee();
		
		minus.sEquiper(Equipement.BOUCLIER);
		asterix.parler("Coucou, qui veut un pain ?");
		asterix.frapper(minus);
		
		asterix.faireUneDonation(musee);
		
		System.out.println(musee.extraireInstructionsCaml());
		
	}

}
