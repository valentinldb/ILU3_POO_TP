package cartes;

public class JeuDeCartes {

	public static final int NB_BORNE_25 = 10;
	public static final int NB_BORNE_50 = 10;
	public static final int NB_BORNE_75 = 10;
	public static final int NB_BORNE_100 = 12;
	public static final int NB_BORNE_200 = 4;

	public static final int NB_PARADE_FEU = 14;
	public static final int NB_PARADE_ESSENCE = 6;
	public static final int NB_PARADE_CREVAISON = 6;
	public static final int NB_PARADE_ACCIDENT = 6;

	public static final int NB_ATTAQUE_FEU = 5;
	public static final int NB_ATTAQUE_ESSENCE = 3;
	public static final int NB_ATTAQUE_CREVAISON = 3;
	public static final int NB_ATTAQUE_ACCIDENT = 3;

	public static final int NB_BOTTE_FEU = 1;
	public static final int NB_BOTTE_ESSENCE = 1;
	public static final int NB_BOTTE_CREVAISON = 1;
	public static final int NB_BOTTE_ACCIDENT = 1;

	public static final int NB_DEBUT_LIMITE = 6;
	public static final int NB_FIN_LIMITE = 4;

	private Configuration[] typesDeCartes = {
			// Kms
			new Configuration(new Borne(25), NB_BORNE_25), new Configuration(new Borne(50), NB_BORNE_50),
			new Configuration(new Borne(75), NB_BORNE_75), new Configuration(new Borne(100), NB_BORNE_100),
			new Configuration(new Borne(200), NB_BORNE_200),

			// Parades
			new Configuration(new Parade(Type.FEU), NB_PARADE_FEU),
			new Configuration(new Parade(Type.ESSENCE), NB_PARADE_ESSENCE),
			new Configuration(new Parade(Type.CREVAISON), NB_PARADE_CREVAISON),
			new Configuration(new Parade(Type.ACCIDENT), NB_PARADE_ACCIDENT),

			// Attaques
			new Configuration(new Attaque(Type.FEU), NB_ATTAQUE_FEU),
			new Configuration(new Attaque(Type.ESSENCE), NB_ATTAQUE_ESSENCE),
			new Configuration(new Attaque(Type.CREVAISON), NB_ATTAQUE_CREVAISON),
			new Configuration(new Attaque(Type.ACCIDENT), NB_ATTAQUE_ACCIDENT),

			// Bottes
			new Configuration(new Botte(Type.FEU), NB_BOTTE_FEU),
			new Configuration(new Botte(Type.ESSENCE), NB_BOTTE_ESSENCE),
			new Configuration(new Botte(Type.CREVAISON), NB_BOTTE_CREVAISON),
			new Configuration(new Botte(Type.ACCIDENT), NB_BOTTE_ACCIDENT),

			// Limites
			new Configuration(new FinLimite(), NB_DEBUT_LIMITE), new Configuration(new DebutLimite(), NB_FIN_LIMITE) };

	public String affichageJeuDeCartes() {
		StringBuilder msgBuilder = new StringBuilder("Jeu : \n");

		for (Configuration conf : typesDeCartes) {
			msgBuilder.append(conf.getNbExemplaire());
			msgBuilder.append(" ");
			msgBuilder.append(conf.getCarte());
			msgBuilder.append(".\n");
		}

		return msgBuilder.toString();
	}

	public Carte[] donnerCartes() {
		int nbCartes = 0;
		for (Configuration configuration : typesDeCartes) {
			nbCartes += configuration.getNbExemplaire();
		}
		Carte[] cartes = new Carte[nbCartes];
		int index = 0;
		for (Configuration configuration : typesDeCartes) {
			for (int i = 0; i < configuration.getNbExemplaire(); i++) {
				cartes[index] = configuration.getCarte();
				index++;
			}
		}
		return cartes;
	}

	public static final int NB_CARTES_JEU = 106;

	public boolean checkCount() {
		Carte[] cartes = donnerCartes();

		for (Configuration config : typesDeCartes) {
			int nbRef = config.getNbExemplaire();
			int nbRead = 0;

			for (Carte carte : cartes) {
				if (carte.equals(config.carte)) {
					nbRead++;
				}
			}

			if (nbRead != nbRef) {
				return false;
			}
		}

		return true;
	}

	private static class Configuration {

		private int nbExemplaire;
		private Carte carte;

		private Configuration(Carte carte, int nbExemplaire) {
			this.carte = carte;
			this.nbExemplaire = nbExemplaire;
		}

		public Carte getCarte() {
			return carte;
		}

		public int getNbExemplaire() {
			return nbExemplaire;
		}

	}
}
