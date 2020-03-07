package main;

/**
 * Suite de Conway
 * 
 * @author Kévin Constantin Le 28/02/2020
 *
 */
public class ConwaySuite {

	private String startingString;

	public ConwaySuite(String str) {
		this.startingString = str;
	}

	/**
	 * Retourne la chaîne n+1 de la chaîne en paramètre.
	 * 
	 * @param str
	 * @return
	 */
	private String newSuite(String str) {
		String ret = "";

		// Pour chaque caractère de la chaîne
		for (int i = 0; i < str.length(); i++) {
			char currentChar = str.charAt(i);

			// Si la graine est de taille 1
			if (str.length() == 1) {
				return "1" + currentChar;
			} else {
				int occurence = 1;

				// Tant que l'on se trouve encore dans la chaîne en regardant au caractère
				// suivant de la chaîne
				while ((i + 1) < str.length()) {

					// On regarde s'il s'agit du même chiffre
					if (currentChar == str.charAt(i + 1)) {

						// Dans ce cas on incrémente le compteur du nombre d'occurence pour ce chiffre
						occurence++;

						// Et on oublie pas d'avancer l'indice sur la chaîne initiale pour ne pas
						// regarder plusieurs fois un caractère déjà vérifié
						i++;
					} else { // Il s'agit d'un caractère différent de celui enregistré
						break;
					}
				}
				// On rajoute à la chaîne qu'on va retourner à la fin le nombre d'occurence du
				// caractère
				// courant ainsi que celui-ci
				ret += occurence + "" + currentChar;
			}
		}
		return ret;
	}

	/**
	 * Affiche n itération de la suite de Conway en utilisant pour graine l'attribut
	 * <code>startingString</code>
	 * 
	 * @param howManyLoop Le nombre d'itération souhaité
	 */
	public void iterativeSuite(int howManyLoop) {
		String current = startingString;
		System.out.println("Step 1:" + startingString);
		for (int i = 2; i <= howManyLoop; i++) {
			current = newSuite(current);
			System.out.println("Step " + i + ":" + current);
		}
	}

	public static void main(String[] args) {
		ConwaySuite cs = new ConwaySuite("1");
		cs.iterativeSuite(30);
	}
}
