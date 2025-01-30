//Chelsea Florquin BTS1 23/01/2025

nbrmot (phrase): 
n=len(phrase)
mot_en_cours=False
compt=0

for i in range(n):
    if phrase[i]==" ":
        if mot_en_cours:
            compt=compt+1
            mot_en_cours=False
    else :
        mot_en_cours=True
if phrase[n-1]!=" ":
    compt=compt+1
return compt
