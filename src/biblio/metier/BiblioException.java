package biblio.metier;

/*
 * Exceptions sur l'application Bibliotheque
 */

public class BiblioException extends Exception {


	public BiblioException() {
		super("Erreur dans l'application");
	}

	public BiblioException(String message) {
		super(message);
	}

}