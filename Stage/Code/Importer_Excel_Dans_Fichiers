import pandas as pd
import sqlite3

# 1. Lire le fichier Excel
df = pd.read_excel("fichier_clients.xlsx")

# Nettoyer les noms de colonnes
df.columns = [col.strip().upper() for col in df.columns]  # Pour éviter les erreurs de casse

# Remplacer les valeurs vides par une chaîne vide
df = df.fillna("")

# 2. Connexion à la base de données SQLite
conn = sqlite3.connect("clients.db")
cursor = conn.cursor()

# 3. Parcourir les lignes du fichier et insérer dans la base
for index, row in df.iterrows():
    cursor.execute("""
        INSERT INTO clients (
            nom, prenom, adresse, ville, codePostal, telephone, email,
            travaux, facture, observation, annee
        ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
    """, (
        row["NOM"],
        row["PRENOM"],
        row["ADRESSE"],
        row["VILLE"],
        row["CODE POSTAL"],
        row["TELEPHONE"],
        row["EMAIL"],
        row["TRAVAUX"],
        row["FACTURE"],
        row["OBSERVATION"],
        row["ANNEE"]
    ))

# 4. Sauvegarder et fermer
conn.commit()
conn.close()

print("Import terminé avec succès.")
