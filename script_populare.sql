insert into Clienti(Nume,Email) values ('Tudor Ionescu','t_i@yahoo.com');
insert into Clienti(Nume,Email) values ('Razvan Vilciu','razvan-vilciu@asd.co');
insert into Clienti(Nume,Email) values ('Mihai Codreanu','mc1999@here.com');
insert into Clienti(Nume,Email) values ('Patrick Rosca','gush@hotmail.com');
insert into Clienti(Nume,Email) values ('Onose Marcel','onofreimargel@a.co');


insert into Detalii_Livrare(Adresa) values ('Str Acolo 15');
insert into Detalii_Livrare(Adresa) values ('Str Viteazu 33');
insert into Detalii_Livrare(Adresa) values ('Str Nicaieri 42B');
insert into Detalii_Livrare(Adresa) values ('Str Aici 20');
insert into Detalii_Livrare(Adresa) values ('Str NuStiu 1');

insert into Comenzi(ID_Client,ID_Adresa) values (1,1);
insert into Comenzi(ID_Client,ID_Adresa) values (1,2);
insert into Comenzi(ID_Client,ID_Adresa) values (2,4);
insert into Comenzi(ID_Client,ID_Adresa) values (3,3);
insert into Comenzi(ID_Client,ID_Adresa) values (3,5);


insert into Facturi(ID_Comanda) values (1);
insert into Facturi(ID_Comanda) values (1);
insert into Facturi(ID_Comanda) values (3);
insert into Facturi(ID_Comanda) values (2);
insert into Facturi(ID_Comanda) values (4);
insert into Facturi(ID_Comanda) values (5);


insert into Categorii(Nume_Categorie) values ('Procesoare');
insert into Categorii(Nume_Categorie) values ('Placi video');
insert into Categorii(Nume_Categorie) values ('RAM');
insert into Categorii(Nume_Categorie) values ('Carcase');
insert into Categorii(Nume_Categorie) values ('SSD-uri');


insert into Produse(Denumire,Caracteristica,ID_Categorie,Pret,Cantitate) values ('I7','4.6GHz',1,100,3);
insert into Produse(Denumire,Caracteristica,ID_Categorie,Pret,Cantitate) values ('I5','3.6GHz',1,75,2);
insert into Produse(Denumire,Caracteristica,ID_Categorie,Pret,Cantitate) values ('I3','2.2GHz',1,50,10);
insert into Produse(Denumire,Caracteristica,ID_Categorie,Pret,Cantitate) values ('GTX 1080','192-bit',2,1000,2);
insert into Produse(Denumire,Caracteristica,ID_Categorie,Pret,Cantitate) values ('GTX 1050','128-bit',2,750,3);
insert into Produse(Denumire,Caracteristica,ID_Categorie,Pret,Cantitate) values ('RX 580','192-bit',2,1000,2);
insert into Produse(Denumire,Caracteristica,ID_Categorie,Pret,Cantitate) values ('Corsair','8GB',3,60,3);
insert into Produse(Denumire,Caracteristica,ID_Categorie,Pret,Cantitate) values ('Kingston','16GB',3,50,2);

insert into Compatibilitati values (1,4);
insert into Compatibilitati values (2,5);
insert into Compatibilitati values (3,6);
insert into Compatibilitati values (1,10);
insert into Compatibilitati values (1,11);
insert into Compatibilitati values (2,10);
insert into Compatibilitati values (2,11);
insert into Compatibilitati values (3,10);
insert into Compatibilitati values (3,11);
insert into Compatibilitati values (4,10);
insert into Compatibilitati values (5,10);
insert into Compatibilitati values (6,11);


insert into Produse_Pe_Comanda values (1,1,1);
insert into Produse_Pe_Comanda values (4,1,1);
insert into Produse_Pe_Comanda values (11,1,1);
insert into Produse_Pe_Comanda values (1,1,2);
insert into Produse_Pe_Comanda values (4,1,2);
insert into Produse_Pe_Comanda values (11,1,2);
insert into Produse_Pe_Comanda values (11,3,3);
insert into Produse_Pe_Comanda values (1,2,4);
insert into Produse_Pe_Comanda values (2,2,4);
insert into Produse_Pe_Comanda values (4,4,5);
