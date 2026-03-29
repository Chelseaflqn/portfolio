// ============================================================
// JEU DU JUSTE PRIX - jeu.js
// Fonctionnement : le joueur entre son pseudo, devine un nombre
// entre 1 et 100. Son meilleur score (= moins de tentatives)
// est sauvegardé et affiché dans un classement partagé (Supabase).
// ============================================================

// ============================================================
// CONNEXION À SUPABASE
// ============================================================
const SUPABASE_URL = "https://lnjthzxpnkxsbjmzfpsz.supabase.co"; 
const SUPABASE_KEY = "sb_publishable_IrmGIFDtg7w8Kux-I076KA_x4A7xle7"; 

// Initialisation officielle du client Supabase
const supabaseClient = supabase.createClient(SUPABASE_URL, SUPABASE_KEY);

// --- Variables globales du jeu ---
let nombreSecret = 0;       // Le nombre aléatoire à deviner
let tentatives = 0;         // Compteur de tentatives pour la partie en cours
let pseudoJoueur = "";      // Pseudo du joueur actif
let jeuActif = false;       // Empêche de jouer sans avoir entré un pseudo


// ============================================================
// INITIALISATION AU CHARGEMENT DE LA PAGE
// ============================================================
window.addEventListener("load", () => {
    afficherClassement();       // On charge et affiche les scores existants depuis Supabase
    afficherEcranPseudo();      // On affiche d'abord la saisie du pseudo
});


// ============================================================
// GESTION DU PSEUDO
// Affiche le formulaire de saisie du pseudo avant de jouer
// ============================================================
function afficherEcranPseudo() {
    const zone = document.getElementById("game-wrapper-inner");
    zone.innerHTML = `
        <div style="text-align:center; padding: 10px 0;">
            <p style="margin-bottom: 14px; font-size: 0.95rem; color: #555;">Entre ton pseudo pour jouer :</p>
            <input type="text" id="pseudoInput" maxlength="20" placeholder="Ton pseudo..."
                style="padding: 10px; border: 2px solid #d4a5b2; border-radius: 8px;
                       font-size: 1rem; text-align: center; width: 180px; outline: none;">
            <br>
            <button onclick="validerPseudo()" 
                style="margin-top: 14px; padding: 10px 28px; background: #d4a5b2;
                       color: white; border: none; border-radius: 50px; font-size: 1rem;
                       cursor: pointer; font-family: inherit;">
                Jouer
            </button>
        </div>
    `;
    // Permet de valider avec la touche Entrée
    document.getElementById("pseudoInput").addEventListener("keydown", (e) => {
        if (e.key === "Enter") validerPseudo();
    });
}

// Valide le pseudo et lance la partie
function validerPseudo() {
    const input = document.getElementById("pseudoInput");
    const valeur = input.value.trim();

    if (!valeur) {
        input.style.borderColor = "#e74c3c";  // Bordure rouge si vide
        return;
    }

    pseudoJoueur = valeur;
    demarrerPartie();
}


// ============================================================
// DÉMARRAGE D'UNE PARTIE
// Génère un nouveau nombre secret et réinitialise les compteurs
// ============================================================
function demarrerPartie() {
    nombreSecret = Math.floor(Math.random() * 100) + 1;
    tentatives = 0;
    jeuActif = true;

    afficherZoneJeu();
}

// Affiche l'interface de jeu une fois le pseudo validé
function afficherZoneJeu() {
    const zone = document.getElementById("game-wrapper-inner");
    zone.innerHTML = `
        <div style="text-align:center;">
            <p style="margin-bottom: 6px; font-size: 0.9rem; color: #888;">
                Joueur : <strong style="color: #d4a5b2;">${pseudoJoueur}</strong>
            </p>
            <p style="margin-bottom: 14px; font-size: 0.95rem;">Devine le nombre entre 1 et 100</p>
            <input type="number" id="guessInput" min="1" max="100" placeholder="?"
                style="width: 100px; padding: 10px; border: 2px solid #d4a5b2;
                       border-radius: 8px; font-size: 1.2rem; text-align: center; outline: none;">
            <br>
            <button onclick="verifierReponse()"
                style="margin-top: 12px; padding: 10px 28px; background: #d4a5b2;
                       color: white; border: none; border-radius: 50px; font-size: 1rem;
                       cursor: pointer; font-family: inherit;">
                Valider
            </button>
            <div id="game-message" style="margin: 14px 0; font-weight: 600; min-height: 24px; font-size: 0.95rem;"></div>
            <p style="font-size: 0.85rem; color: #888;">
                Tentatives : <span id="attempts-count" style="font-weight:600; color: #555;">0</span>
            </p>
            <button onclick="nouvellePartie()"
                style="margin-top: 8px; background: none; border: none; color: #aaa;
                       cursor: pointer; text-decoration: underline; font-size: 0.8rem; font-family: inherit;">
                Changer de joueur
            </button>
        </div>
    `;
    // Permet de valider avec la touche Entrée
    document.getElementById("guessInput").addEventListener("keydown", (e) => {
        if (e.key === "Enter") verifierReponse();
    });
}


// ============================================================
// VÉRIFICATION DE LA RÉPONSE
// Compare la proposition du joueur au nombre secret
// ============================================================
function verifierReponse() {
    if (!jeuActif) return;

    const input = document.getElementById("guessInput");
    const proposition = parseInt(input.value);
    const message = document.getElementById("game-message");
    const compteur = document.getElementById("attempts-count");

    if (isNaN(proposition) || proposition < 1 || proposition > 100) {
        message.style.color = "#e74c3c";
        message.textContent = "Entre un nombre entre 1 et 100 !";
        return;
    }

    tentatives++;
    compteur.textContent = tentatives;
    input.value = "";

    if (proposition < nombreSecret) {
        message.style.color = "#3498db";
        message.textContent = "Trop petit !";
    } else if (proposition > nombreSecret) {
        message.style.color = "#e67e22";
        message.textContent = "Trop grand !";
    } else {
        message.style.color = "#27ae60";
        message.textContent = `Bravo ${pseudoJoueur} ! Trouvé en ${tentatives} tentative(s) !`;
        jeuActif = false;
        
        // Appel de la fonction de sauvegarde en ligne
        sauvegarderScore(pseudoJoueur, tentatives);

        const btn = document.createElement("button");
        btn.textContent = "Rejouer";
        btn.style.cssText = "margin-top: 12px; padding: 8px 22px; background: #27ae60; color: white; border: none; border-radius: 50px; font-size: 0.9rem; cursor: pointer; font-family: inherit;";
        btn.onclick = () => demarrerPartie();
        message.after(btn);
    }
}


// ============================================================
// SAUVEGARDE DU SCORE SUR SUPABASE
// ============================================================
async function sauvegarderScore(pseudo, score) {
    try {
        // On vérifie si ce joueur a déjà un score enregistré
        const { data: existant, error: fetchError } = await supabaseClient
            .from('scores')
            .select('score')
            .ilike('pseudo', pseudo)
            .maybeSingle();

        if (fetchError) throw fetchError;

        if (existant) {
            // Si le nouveau score est meilleur (moins de tentatives), on met à jour
            if (score < existant.score) {
                const { error: updateError } = await supabaseClient
                    .from('scores')
                    .update({ score: score })
                    .ilike('pseudo', pseudo);
                
                if (updateError) throw updateError;
            }
        } else {
            // Si c'est un nouveau joueur, on l'ajoute à la base de données
            const { error: insertError } = await supabaseClient
                .from('scores')
                .insert([{ pseudo: pseudo, score: score }]);
                
            if (insertError) throw insertError;
        }

        // On rafraîchit le classement pour tout le monde
        afficherClassement();

    } catch (err) {
        console.error("Erreur lors de la sauvegarde du score :", err);
    }
}


// ============================================================
// RÉCUPÉRATION DES SCORES DEPUIS SUPABASE
// ============================================================
async function recupererScores() {
    try {
        const { data, error } = await supabaseClient
            .from('scores')
            .select('pseudo, score')
            .order('score', { ascending: true }) // Du plus petit au plus grand
            .limit(10); // Top 10

        if (error) throw error;
        return data || [];
    } catch (err) {
        console.error("Erreur lors de la récupération des scores :", err);
        return [];
    }
}


// ============================================================
// AFFICHAGE DU CLASSEMENT
// ============================================================
async function afficherClassement() {
    const liste = document.getElementById("leaderboard-list");
    if (!liste) return;

    // On récupère les scores depuis le serveur
    const scores = await recupererScores();

    if (scores.length === 0) {
        liste.innerHTML = `<p style="font-size: 0.85rem; color: #aaa; text-align:center; margin-top: 10px;">Aucun score encore.</p>`;
        return;
    }

    const medailles = ["🥇", "🥈", "🥉"];

    liste.innerHTML = scores.map((s, i) => `
        <div style="display: flex; justify-content: space-between; align-items: center;
                    padding: 8px 10px; margin-bottom: 6px; border-radius: 8px;
                    background: ${i === 0 ? '#fff8e1' : '#fafafa'};
                    border: 1px solid ${i === 0 ? '#ffe082' : '#eee'};
                    font-size: 0.85rem;">
            <span style="font-weight: 600; color: #555;">
                ${medailles[i] || (i + 1) + "."} ${s.pseudo}
            </span>
            <span style="color: #d4a5b2; font-weight: 700;">${s.score} essai${s.score > 1 ? 's' : ''}</span>
        </div>
    `).join("");
}

// ============================================================
// NOUVELLE PARTIE / CHANGER DE JOUEUR
// ============================================================
function nouvellePartie() {
    pseudoJoueur = "";
    jeuActif = false;
    afficherEcranPseudo();
}