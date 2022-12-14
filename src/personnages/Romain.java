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
	
//	public void recevoirCoup(int forceCoup) {
//		assert force > 0;
//		int forceInv = force;
//		force -= forceCoup;
//		if (force > 0) {
//			parler("Aie");
//		} else {
//			parler("J'abandonne...");
//		}
//		assert forceInv > force;
//	}
	
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// pr?condition
		assert force > 0;
		int oldForce = force;
		
		forceCoup = calculResistanceEquipement(forceCoup);
		
		force -= forceCoup;
		if(force > 0) {
			parler("Aie");
		}
		else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}
		// post condition la force ? diminuer
		assert force < oldForce;
		return equipementEjecte;
	}
	
	private int calculResistanceEquipement(int forceCoup) {
		String texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup + " !";
		int resistanceEquipement = 0;
		if(nbEquipement != 0) {
			texte += "\nMais heureusement, grace ? mon ?quipement sa force est diminu? de ";
			for(int i = 0; i<nbEquipement; i++) {
				if((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER))) {
					resistanceEquipement += 8;
				}
				else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
				texte += resistanceEquipement;
			}
		}
		forceCoup -= resistanceEquipement;
		parler(texte);
		return forceCoup;
	}
	
	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'?quipement de " + nom + " s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		for(int i = 0; i < nbEquipement; i++) {
			if(equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte ++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;
	}

	
	public void sEquiper(Equipement equipement) {
		switch(nbEquipement) {
			case 2 :
				System.out.println("Le soldat " + nom + " est d?j?? bien prot?g? !");
				break;
			case 1 :
				if(equipements[nbEquipement-1] == equipement) {
					System.out.println("Le soldat "+ nom + " poss?de d?j?? un " + equipement + " !");
				}
				else {
					equipements[nbEquipement] = equipement;
					nbEquipement ++;
					System.out.println("Le soldat "+ nom +" s'?quipe avec un "+ equipement + ".");
				}
				break;
			default :
				equipements[nbEquipement] = equipement;
				nbEquipement ++;
				System.out.println("Le soldat "+ nom +" s'?quipe avec un "+ equipement + ".");
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
