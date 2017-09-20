import java.util.List;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Main {
	
	/**
	* Fonction qui prend un fichier en argument et qui construit une liste de String
	* @param fichier, le nom du fichier
	* @return la liste de string contenus dans la fichier
	**/
	public static ArrayList<String> getLignes(String fichier){
		ArrayList<String> lignes = new ArrayList<String>();
		try{
			InputStream flux = new FileInputStream(fichier);
			InputStreamReader lecture = new InputStreamReader(flux);
			BufferedReader buff = new BufferedReader(lecture);
			String ligne;
			while ((ligne=buff.readLine())!=null){
				lignes.add(ligne);
			}
			buff.close();
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}

		return lignes;
	}
	
	// Fonction qui prend un texte et l'écrit dans le fichier nomFicher
	
	// Fonction qui prend la liste des lignes et qui crée la liste des catégories
	public static HashSet<String> getCategories(ArrayList<String> listeLignes) {
		HashSet Categories = new HashSet(); // on crée notre Set
		for (int i = 0; i < listeLignes.size(); i++) {
			Categories.add(listeLignes.get(i).split(";")[2]); 
		}
		return Categories;
	}
	
	// Fonction qui prend la liste des lignes et qui crée la liste des utilisateurs
	public static HashSet<String> getUtilisateurs(ArrayList<String> listeLignes) {
		HashSet Utilisateurs = new HashSet(); // on crée notre Set
		for (int i = 0; i < listeLignes.size(); i++) {
			Utilisateurs.add(listeLignes.get(i).split(";")[1]); 
		}
		return Utilisateurs;
	}
	
	// Fonction qui crée le nombre d'occurence 
	public static ArrayList<String[]> getMatrice () {
		// On parcourt la liste de base
		ArrayList<String> listeComplete = getLignes("Logs-clients-themes.txt");
		HashSet listeCategories = new HashSet();
		
		HashSet listeCategories = this.getCategories(listeComplete);
		HashSet listeUtilisateurs = this.getUtilisateurs(listeComplete);
		
		Iterator i = listeUtilisateurs.iterator();
		Iterator j = listeCategories.iterator();
		
		while(i.hasNext()) // tant qu'on a un suivant
		{
			while (j.hasNext()) {
				System.out.println(i.next());
				System.out.println(j.next());				
			}

		}
	
		return null;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<String> lignes = getLignes("Logs-clients-themes.txt");
		ArrayList<String> Categories = new ArrayList<String>(getCategories(lignes));
		ArrayList<String> Utilisateurs = new ArrayList<String>(getUtilisateurs(lignes));		
		ArrayList<String[]> result = new ArrayList<String[]>();

		for (int u = 0; u < Utilisateurs.size(); u++) {
			for (int c = 0; c < Categories.size(); c++) {
				//result.add({Utilisateurs.get(u); Categories.get(c); "0"};)
				//System.out.println(Utilisateurs.get(u) + " " + Categories.get(c));
			}
		}
	}

}
