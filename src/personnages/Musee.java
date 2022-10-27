package personnages;

public class Musee {
	private int nbTrophee = 0;
	private Trophee[] trophees = new Trophee[200];
	
	public void donnerTrophees(Gaulois gaulois, Equipement equipement) {
		Trophee trophee = new Trophee(gaulois, equipement);
		trophees[nbTrophee] = trophee;
		nbTrophee ++;
	}
	
	public String extraireInstructionsCaml() {
		String instruction = "let musee = [\n";
		for(int i = 0; i < nbTrophee; i++)
		{
			instruction += "     \"" + trophees[i].getNomGaulois() + "\", \"" + trophees[i].getEquipement() + "\";\n";
			
		}
		
		instruction += "]";
		
		return instruction;
	}
		

}
