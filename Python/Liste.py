//19/12/2024 Liste en Python + Minimum de la liste et fréquence de l'apparition d'un nombre (f)

from random import*
liste=[randint(1,10) for i in range(20)]
plus_petit=min(liste)
print("Liste généré", liste)
print("Le plus petit nombre est", plus_petit)
       
for i in range (1,101) :
	compt = 0
	for j in liste :
		if i==j :
			compt = compt +1
			f = compt/100
			print (i,f)
