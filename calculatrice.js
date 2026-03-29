// ============================================================
// CALCULATRICE - calculatrice.js
// Récupération de l'élément HTML qui sert d'écran d'affichage.
// On le stocke dans une variable pour pouvoir le modifier facilement
// depuis toutes les fonctions sans avoir à le rechercher à chaque fois.
// ============================================================
let aff = document.getElementById("affichage");
 
 
// --- Ajouter un chiffre ou une parenthèse à l'écran ---
// Si l'écran affiche "0" (valeur par défaut), on le remplace par le chiffre saisi.
// Sinon, on ajoute le chiffre à la suite de ce qui est déjà affiché.
function ajouterChiffre(n) {
    if (aff.value === "0") aff.value = n;
    else aff.value += n;
}
 
 
// --- Ajouter un opérateur mathématique (+, -, *, /) ---
// On concatène l'opérateur à la suite de l'expression en cours.
function ajouterOperation(op) {
    aff.value += op;
}
 
 
// --- Réinitialiser l'affichage ---
// Remet l'écran à "0", comme si on venait d'allumer la calculatrice.
function clearAffichage() {
    aff.value = "0";
}
 
 
// --- Calculer le résultat de l'expression affichée ---
// On remplace d'abord les symboles visuels (×, ÷, −) par leurs équivalents
// reconnus en JavaScript (*, /, -).
// eval() interprète la chaîne de caractères comme une expression mathématique
// et retourne le résultat.
// Le bloc try/catch permet d'afficher "Erreur" si l'expression est invalide
// (ex : division par zéro, parenthèse non fermée...).
function calculer() {
    try {
        let calcul = aff.value.replace('×', '*').replace('÷', '/').replace('−', '-');
        aff.value = eval(calcul);
    } catch {
        aff.value = "Erreur";
    }
}
 
 
// --- Calculer la racine carrée du nombre affiché ---
// Math.sqrt() est une fonction intégrée de JavaScript.
// eval() convertit le texte affiché en nombre avant le calcul.
function racine() { aff.value = Math.sqrt(eval(aff.value)); }
 
 
// --- Élever le nombre affiché au carré (x²) ---
// Math.pow(nombre, exposant) calcule une puissance.
// Ici on l'utilise avec l'exposant 2 pour obtenir x².
function carre() { aff.value = Math.pow(eval(aff.value), 2); }
 
 
// --- Calculer l'inverse du nombre affiché (1/x) ---
// On divise 1 par la valeur affichée.
function inverse() { aff.value = 1 / eval(aff.value); }
 
 
// --- Inverser le signe du nombre affiché (+/-) ---
// On multiplie la valeur par -1 pour passer de positif à négatif ou inversement.
function negatif() { aff.value = eval(aff.value) * -1; }
 
 
// --- Ajouter un point décimal ---
// On vérifie d'abord qu'il n'y a pas déjà un point dans l'affichage
// pour éviter des nombres invalides comme "3.1.4".
function ajouterPoint() { if (!aff.value.includes('.')) aff.value += '.'; }
 
 
// --- Supprimer le dernier caractère saisi (bouton ←) ---
// slice(0, -1) retourne la chaîne sans son dernier caractère.
// Si l'écran est vide après suppression, on remet "0" par défaut.
function supprimerDernier() {
    aff.value = aff.value.slice(0, -1);
    if (aff.value === "") aff.value = "0";
}