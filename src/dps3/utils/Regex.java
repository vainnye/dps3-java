package dps3.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {    
    /**
     * Cherche un motif regex dans un texte donné et retourne les correspondances.
     * @param text Le texte dans lequel chercher.
     * @param patternRegex Le motif regex à chercher.
     * @return Les correspondances trouvées sous forme de tableau de chaînes de caractères.
     */
    public static String[] searchPattern(String text, String patternRegex) {
        // Compiler le motif regex
        Pattern pattern = Pattern.compile(patternRegex);

        // Créer un matcher pour le texte
        Matcher matcher = pattern.matcher(text);

        // Utiliser un StringBuilder pour collecter les correspondances
        StringBuilder matches = new StringBuilder();

        // Parcourir les correspondances
        while (matcher.find()) {
            matches.append(matcher.group()).append(",");
        }

        // Si aucune correspondance n'a été trouvée, retourner un tableau vide
        if (matches.length() == 0) {
            return new String[0];
        }

        // Convertir les correspondances en tableau de chaînes
        return matches.toString().split(",");
    }
}