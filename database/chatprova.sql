drop database if exists ChatDocApp;
create database ChatDocApp;
use ChatDocApp;

create table Utente(
	idutente int primary key auto_increment,
    nickname varchar(16) not null,
    email varchar(40) unique,
    psw varchar(64),
    salt varchar(25) unique
);

create table Conversazione(
	idconversazione bigint primary key auto_increment,
    nomechat varchar(25) not null,
    iduser int,
    foreign key (iduser) references Utente(idutente)
);

create table Messaggio(
	idmessaggio bigint auto_increment,
    idconversazione bigint,
    iduser int,
    testo text not null,
    tms timestamp,
    primary key (idmessaggio, idconversazione),
    foreign key (iduser) references Utente(idutente),
    foreign key (idconversazione) references Conversazione(idconversazione)
);