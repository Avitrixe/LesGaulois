package personnages;

public class Romain {
	
	private String nom;
	private int force;
	private Equipement[] equipements;
	private int nbEquipement = 0;
	
	public Romain(String nom, int force) {
		assert force > 0;
		this.equipements = new Equipement[2];
		this.nom = nom;
		this.force = force;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "<< " + texte + ">>");
	}
	
	private String prendreParole() {
		// TODO Auto-generated method stub
		return "Le romain " + nom + " : ";
	}
	
	public void recevoirCoup(int forceCoup) {
		assert force > 0;
		int forceInv = force;
		force -= forceCoup;
		if (force > 0) {
			parler("Aie");
		} else {
			parler("J'abandonne...");
		}
		assert forceInv > force;
	}
	
	public void sEquiper(Equipement equipement) {
		switch(nbEquipement) {
			case 2 :
				System.out.println("Le soldat " + nom + " est déjà bien protégé !");
				break;
			case 1 :
				if(equipements[nbEquipement-1] == equipement) {
					System.out.println("Le soldat "+ nom + " possède déjà un " + equipement + " !");
				}
				else {
					equipements[nbEquipement] = equipement;
					nbEquipement ++;
					System.out.println("Le soldat "+ nom +" s'équipe avec un "+ equipement + ".");
				}
				break;
			default :
				equipements[nbEquipement] = equipement;
				nbEquipement ++;
				System.out.println("Le soldat "+ nom +" s'équipe avec un "+ equipement + ".");
				break;
		}
	}
	
	public static void main(String[] args) {
		Romain minus = new Romain("minus", 6);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.BOUCLIER);
	}


}
