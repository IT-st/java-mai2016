# mai2016
Proiect training Mai 2016

Aplicatie tip consola ce face managementul training-urilor. Ca si actori avem traineri, cursanti si cursurile predate de traineri.

Aplicatia permite:  
...1. Crearea de traineri, fiecare trainer avand o lista de expertize (materie pe care o poate preda)
...2. Crearea de cursanti
...3. Crearea de cursuri compuse din 1 topic, 1 trainer, o lista de cursanti.

Introducerea datelor se poate face din linia de comanda sau prin incarcarea unui fisier initial exportat din aplicatie (serializare). Ex: salvat.out  
Introducerea trainerilor se poate face dintr-un fisier text. Formatul este urmatorul: Pe prima linie, separate prin ','
numele si prenumele trainerului. Pe a doua linie, separate prin ',' expertizele acestuia.

**Ex:** <br/>
Ion,Popescu  
C++,Java,Python  