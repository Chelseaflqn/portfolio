#Chelsea Florquin BTS 1/ 16/01/2025

#Entre une phrase
phrase = input("Saisir une phrase")
#Calculer la taille de la phrase
p=len(phrase)
voyelles = "aeiouyAEIOUY"
compte=0
for i in range(p):
        for j in range(len(voyelles)):
            if phrase[i]==voyelles[j]:
                compte+=1

print("Le nombre dans voyelle dans la phrase est", compte)
