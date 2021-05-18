CREATE TABLE film
(
    id int NOT NULL PRIMARY KEY,
    title varchar(255),
    genre  varchar(255),
    release_date int,
    running_time int,
    nd_de_sold int,
    CONSTRAINT fk_reservation FOREIGN KEY (title) REFERENCES reservation (title_film)
);

CREATE TABLE members
(
    mail varchar(255),
    password int,
    nom varchar(255),
    prenom varchar(255),
    reduction varchar(255)
);

CREATE TABLE reduction
(
    nom varchar(255) PRIMARY key,
    montant int NOT NULL,
    CONSTRAINT fk_reduction FOREIGN KEY (nom) REFERENCES film (title)
);

CREATE TABLE reservation
(
    nb_Ticket int,
    nb_de_res int,
    id_acheteur int,
    title_film varchar(255),
    reduction int
);

CREATE TABLE employee
(
    mail varchar(255),
    password varchar(255)
);