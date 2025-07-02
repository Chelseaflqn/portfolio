import sqlite3
from tkinter import *
from tkinter import messagebox, ttk

# Connexion à la base de données
conn = sqlite3.connect('clients.db')
cursor = conn.cursor()
cursor.execute('''
    CREATE TABLE IF NOT EXISTS clients (
        id INTEGER PRIMARY KEY AUTOINCREMENT,
        nom TEXT, prenom TEXT, adresse TEXT, ville TEXT,
        codePostal TEXT, telephone TEXT, email TEXT, travaux TEXT,
        facture TEXT, observation TEXT, annee TEXT
    )
''')
conn.commit()

# === Fonctions ===

def enregistrer_client():
    data = (
        entry_nom.get(), entry_prenom.get(), entry_adresse.get(), entry_ville.get(), entry_codePostal.get(),
        entry_telephone.get(), entry_email.get(), var_travaux.get(),
        var_facture.get(), text_observation.get("1.0", END).strip(), entry_annee.get()
    )

    if not data[0]:
        messagebox.showwarning("Champs requis", "Le nom est obligatoire.")
        return

    cursor.execute('''
        INSERT INTO clients 
        (nom, prenom, adresse, ville, codePostal, telephone, email, travaux, facture, observation, annee)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
    ''', data)
    conn.commit()
    messagebox.showinfo("Succès", "Client enregistré avec succès.")
    effacer_champs()

def effacer_champs():
    for entry in [entry_nom, entry_prenom, entry_adresse, entry_ville, entry_codePostal, entry_telephone, entry_email, entry_facture, entry_annee]:
        entry.delete(0, END)
    var_travaux.set("Non")
    text_observation.delete("1.0", END)

def ouvrir_fenetre_clients():
    def filtrer_clients(*args):
        terme = entry_filtre.get().strip().lower()
        for row in tree.get_children():
            tree.delete(row)
        cursor.execute("SELECT * FROM clients ORDER BY annee ASC, nom ASC")
        for client in cursor.fetchall():
            ligne = [str(item).lower() for item in client]
            if any(terme in champ for champ in ligne):
                tree.insert("", END, values=client[1:], tags=(client[0],))

    def supprimer_client():
        selected_item = tree.selection()
        if not selected_item:
            messagebox.showwarning("Sélection requise", "Veuillez sélectionner un client à supprimer.")
            return
        client_id = tree.item(selected_item)["tags"][0]
        confirmation = messagebox.askyesno("Confirmation", "Voulez-vous vraiment supprimer ce client ?")
        if confirmation:
            cursor.execute("DELETE FROM clients WHERE id = ?", (client_id,))
            conn.commit()
            tree.delete(selected_item)
            messagebox.showinfo("Succès", "Client supprimé.")

    def modifier_client():
        selected_item = tree.selection()
        if not selected_item:
            messagebox.showwarning("Sélection requise", "Veuillez sélectionner un client à modifier.")
            return

        client_id = tree.item(selected_item)["tags"][0]
        cursor.execute("SELECT * FROM clients WHERE id = ?", (client_id,))
        client = cursor.fetchone()

        fenetre_modif = Toplevel(fenetre_clients)
        fenetre_modif.title("Modifier le client")
        fenetre_modif.geometry("600x600")
        fenetre_modif.configure(bg="#f0f0f5")

        champs = ["Nom", "Prénom", "Adresse", "Ville", "Code Postal", "Téléphone", "Email", "Travaux", "Qualibat", "Observation", "Année"]
        entrees = {}

        for i, champ in enumerate(champs):
            Label(fenetre_modif, text=champ, bg="#f0f0f5", font=("Arial", 11)).pack(anchor=W, padx=10, pady=(10, 0))
            if champ in ["Travaux", "Qualibat"]:
                var = StringVar(value=client[i+1])
                entrees[champ] = var
                frame_radio = Frame(fenetre_modif, bg="#f0f0f5")
                frame_radio.pack(anchor=W, padx=10)
                Radiobutton(frame_radio, text="Oui", variable=var, value="Oui", bg="#f0f0f5").pack(side=LEFT)
                Radiobutton(frame_radio, text="Non", variable=var, value="Non", bg="#f0f0f5").pack(side=LEFT)
            elif champ == "Observation":
                text_obs = Text(fenetre_modif, height=4, font=("Arial", 11))
                text_obs.insert("1.0", client[i+1])
                text_obs.pack(fill=X, padx=10)
                entrees[champ] = text_obs
            else:
                entry = Entry(fenetre_modif, font=("Arial", 11))
                entry.insert(0, client[i+1])
                entry.pack(fill=X, padx=10)
                entrees[champ] = entry

        def enregistrer_modif():
            new_data = (
                entrees["Nom"].get(),
                entrees["Prénom"].get(),
                entrees["Adresse"].get(),
                entrees["Ville"].get(),
                entrees["Code Postal"].get(),
                entrees["Téléphone"].get(),
                entrees["Email"].get(),
                entrees["Travaux"].get(),
                entrees["Facture"].get(),
                entrees["Observation"].get("1.0", END).strip(),
                entrees["Année"].get(),
                client_id
            )
            cursor.execute('''
                UPDATE clients SET
                    nom = ?, prenom = ?, adresse = ?, ville = ?, codePostal = ?,
                    telephone = ?, email = ?, travaux = ?, facture = ?, observation = ?, annee = ?
                WHERE id = ?
            ''', new_data)
            conn.commit()
            messagebox.showinfo("Succès", "Client modifié avec succès.")
            fenetre_modif.destroy()
            filtrer_clients()

        Button(fenetre_modif, text="💾 Enregistrer les modifications", command=enregistrer_modif, bg="#4CAF50", fg="white", font=("Arial", 12)).pack(pady=20)

    fenetre_clients = Toplevel(fenetre)
    fenetre_clients.title("Liste de tous les clients")
    fenetre_clients.geometry("1200x650")
    fenetre_clients.configure(bg="#f0f0f5")

    Label(fenetre_clients, text="🔍 Rechercher dans la liste :", bg="#f0f0f5", font=("Arial", 11)).pack(pady=(10, 0))
    entry_filtre = Entry(fenetre_clients, font=("Arial", 11), width=50)
    entry_filtre.pack()
    entry_filtre.bind("<KeyRelease>", filtrer_clients)

    tree = ttk.Treeview(
        fenetre_clients,
        columns=("Nom", "Prénom", "Adresse", "Ville", "Code Postal", "Téléphone", "Email", "Travaux", "Facture", "Observation", "Année"),
        show="headings"
    )
    for col in tree["columns"]:
        tree.heading(col, text=col)
        tree.column(col, width=100, anchor="center")
    tree.pack(fill=BOTH, expand=True, padx=10, pady=10)

    bouton_frame = Frame(fenetre_clients, bg="#f0f0f5")
    bouton_frame.pack(pady=10)

    Button(bouton_frame, text="✏️ Modifier le client sélectionné", command=modifier_client, bg="#2196F3", fg="white", font=("Arial", 11)).pack(side=LEFT, padx=10)
    Button(bouton_frame, text="🗑 Supprimer le client sélectionné", command=supprimer_client, bg="#e53935", fg="white", font=("Arial", 11)).pack(side=LEFT, padx=10)

    cursor.execute("SELECT * FROM clients ORDER BY annee ASC, nom ASC")
    for client in cursor.fetchall():
        tree.insert("", END, values=client[1:], tags=(client[0],))

# === Interface principale ===

fenetre = Tk()
fenetre.title("Fichier Client")
fenetre.geometry("1000x800")
fenetre.configure(bg="#f0f0f5")

font_label = ("Arial", 12)
font_entry = ("Arial", 11)

def label_input(label_text):
    Label(frame_form, text=label_text, font=font_label, bg="#f0f0f5").pack(anchor=W, padx=10, pady=(10, 0))

frame_form = Frame(fenetre, bg="#f0f0f5")
frame_form.pack(pady=10, fill=X)

# Champs
label_input("Nom *")
entry_nom = Entry(frame_form, font=font_entry)
entry_nom.pack(fill=X, padx=10)

label_input("Prénom")
entry_prenom = Entry(frame_form, font=font_entry)
entry_prenom.pack(fill=X, padx=10)

label_input("Adresse")
entry_adresse = Entry(frame_form, font=font_entry)
entry_adresse.pack(fill=X, padx=10)

label_input("Ville")
entry_ville = Entry(frame_form, font=font_entry)
entry_ville.pack(fill=X, padx=10)

label_input("Code Postal")
entry_codePostal = Entry(frame_form, font=font_entry)
entry_codePostal.pack(fill=X, padx=10)

label_input("Téléphone")
entry_telephone = Entry(frame_form, font=font_entry)
entry_telephone.pack(fill=X, padx=10)

label_input("Email")
entry_email = Entry(frame_form, font=font_entry)
entry_email.pack(fill=X, padx=10)

label_input("Travaux")
var_travaux = StringVar(value="Non")
frame_travaux = Frame(frame_form, bg="#f0f0f5")
frame_travaux.pack(anchor=W, padx=10)
Radiobutton(frame_travaux, text="Oui", variable=var_travaux, value="Oui", bg="#f0f0f5").pack(side=LEFT)
Radiobutton(frame_travaux, text="Non", variable=var_travaux, value="Non", bg="#f0f0f5").pack(side=LEFT)

label_input("Facture")
entry_facture = Entry(frame_form, font=font_entry)
entry_facture.pack(fill=X, padx=10)

label_input("Observation")
text_observation = Text(frame_form, height=4, font=font_entry)
text_observation.pack(fill=X, padx=10)

label_input("Année")
entry_annee = Entry(frame_form, font=font_entry)
entry_annee.pack(fill=X, padx=10)

# Boutons Enregistrer & Effacer sur la même ligne
frame_boutons = Frame(fenetre, bg="#f0f0f5")
frame_boutons.pack(pady=10)
Button(frame_boutons, text="✅ Enregistrer", command=enregistrer_client, font=("Arial", 12), bg="#4CAF50", fg="white").pack(side=LEFT, padx=10)
Button(frame_boutons, text="🧹 Effacer", command=effacer_champs, font=("Arial", 12), bg="#f44336", fg="white").pack(side=LEFT, padx=10)

Button(fenetre, text="📋 Voir tous les clients", command=ouvrir_fenetre_clients, font=("Arial", 12), bg="#9C27B0", fg="white").pack(pady=10)

# Lancement
fenetre.mainloop()
conn.close()
