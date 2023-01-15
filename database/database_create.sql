drop database if exists docapp;
create database docapp;
use docapp;

create table Studente(
email varchar(40) primary key not null,
nickname varchar(16) unique not null,
pwd varchar(64) not null,
salt varchar(25) not null,
is_admin bool not null
);

create table Documento(
id bigint primary key not null,
nome varchar(30) not null,
descrizione text not null,
università varchar(40) not null,
facoltà varchar(40) not null,
corso_di_studio varchar(30) not null,
dimensione bigint not null
);

create table Feedback(
documento bigint not null,
studente varchar(30) not null,
primary key(documento, studente),
foreign key (documento) references Documento(id),
foreign key(studentei) references Studente(email)
);

create Table Caricamento(
documento bigint not null,
studente varchar(30) not null,
primary key (documento, studente),
foreign key (documento) references Documento(id),
foreign key(studentei) references Studente(email)
);


CREATE table Post(
id bigint not null primary key,
titolo varchar(30) not null,
testo text not null,
is_domanda bool not null
);
create Table InterazionePost(
post bigint not null,
studente varchar(30) not null,
primary key (post, studente),
foreign key(post) references Post(id),
foreign key(studente) references Studente(email)
);


create table Messaggio(
id bigint not null primary key,
conversazione bigint not null,
studente varchar(40) not null,
testo text not null,
timestamp_msg timestamp not null,
primary key(conversazione, studente),
foreign key (conversazione) references Conversazione(id),
foreign key (studente) references Studente(email)
);

create table Conversazione(

id bigint not null primary key,
nome_conversazione varchar(25) not null,
studente varchar(30) not null,
primary key (studente),
foreign key (studente) references Studente(email)

);
create Table DocumentiVisualizzati(
documento bigint not null,
studente varchar(30) not null,
primary key (documento, studente),
foreign key (documento) references Documento(id),
foreign key (studente) references Studente(email)
);

INSERT INTO roles(name) VALUES('ROLE_USER');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');
