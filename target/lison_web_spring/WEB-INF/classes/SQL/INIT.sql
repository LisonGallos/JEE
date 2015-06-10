CREATE DATABASE test;


CREATE TABLE ASSOCIATION (

	ID INTEGER NOT NULL AUTO_INCREMENT,
	NAME VARCHAR(255) NOT NULL,
	REGION VARCHAR(255) NOT NULL,
	
	PRIMARY KEY (ID)
);

CREATE TABLE COMPETITION (

	ID INTEGER NOT NULL AUTO_INCREMENT,
	NAME VARCHAR(255) NOT NULL,
	POINT INTEGER NOT NULL,
	
	PRIMARY KEY (ID)
);

CREATE TABLE ROLE (

	ID INTEGER NOT NULL AUTO_INCREMENT,
	NOM VARCHAR(255) NOT NULL,
	
	PRIMARY KEY (ID)
);

CREATE TABLE VALIDE (

	ID INTEGER NOT NULL AUTO_INCREMENT,
	NOM VARCHAR(255) NOT NULL,
	
	PRIMARY KEY (ID)
);

CREATE TABLE MEMBRE (

	ID INTEGER NOT NULL AUTO_INCREMENT,
	NAME VARCHAR(255) NOT NULL,
	LAST_NAME VARCHAR(255) NOT NULL,
	PASSWORD VARCHAR(255) NOT NULL,
	MAIL VARCHAR(100) NOT NULL,
	BIRTH_DATE DATE,
	CREATION_DATE DATE NOT NULL,
	ID_ROLE INTEGER NOT NULL,
	ID_VALIDE INTEGER NOT NULL,
	IDTMP INTEGER,
	ID_ASSO INTEGER NOT NULL,
	MESSAGE VARCHAR(500),
	
	PRIMARY KEY (ID),
	FOREIGN KEY (ID_ASSO)REFERENCES ASSOCIATION(ID),
	FOREIGN KEY (ID_ROLE)REFERENCES ROLE(ID),
	FOREIGN KEY (ID_VALIDE)REFERENCES VALIDE(ID)
);

CREATE TABLE PERFORMANCE (

	ID INTEGER NOT NULL AUTO_INCREMENT,
	NAME VARCHAR(255) NOT NULL,
	POINT INTEGER NOT NULL,
	PERF_DT DATE,
	IDTMP INTEGER,
	ID_COMP INTEGER NOT NULL,
	ID_MBR INTEGER NOT NULL,
	
	PRIMARY KEY (ID),
	FOREIGN KEY (ID_COMP)REFERENCES COMPETITION(ID),
	FOREIGN KEY (ID_MBR)REFERENCES MEMBRE(ID)
);


CREATE TABLE REL_COMP_MBR (

	ID INTEGER NOT NULL AUTO_INCREMENT,
	IDTMP INTEGER,
	ID_MBR INTEGER NOT NULL,
	ID_COMP INTEGER NOT NULL,
	
	PRIMARY KEY (ID),
	FOREIGN KEY (ID_MBR)REFERENCES MEMBRE(ID),
	FOREIGN KEY (ID_COMP)REFERENCES COMPETITION(ID)
);




INSERT INTO COMPETITION VALUES ('1', 'Select', 'Select'), 
('2', 'RandoCompet', '200'),
('3', 'Frappachoux', '600'),
('4', 'Lemurien', '500');

INSERT INTO ASSOCIATION VALUES ('1', 'Select', 'Select'),
('2', 'Nordobasket', 'Nord'),
('3', 'jeveuxbouger', 'Vaucluse'),
('4', 'LibAssos', 'Picardie');


INSERT INTO ROLE VALUES ('1', 'VISITEUR'),
('2', 'MEMBRE'),
('3', 'REFERENT'),
('4', 'ADMIN');

INSERT INTO VALIDE VALUES ('1', 'EN ATTENTE'),
('2', 'VALIDE'),
('3', 'NON VALIDE');

INSERT INTO MEMBRE VALUES ('1', 'Visiteur', ' ', ' ', ' ',
'1900-01-01','2000-01-01', '1', '2', '0' , '1', '' ),
('2', 'De Gazou', 'Ilios', 'ztw68_19', 'ilios@gmail.com',
'1992-03-20','2015-05-24', '4', '2', '0' , '2', '' ),
('3', 'De la steve', 'Frantz', 'Lg&ju689', 'Frantz@gmail.com',
'1992-04-20','2015-05-25', '3', '2', '0', '2', '' ),
('4', 'Bertelard', 'Freiya', 'zjw3i610', 'Freiya@gmail.com',
'1990-03-28','2015-05-26', '3', '2', '0' , '3', '' ),
('5', 'De Gazouille', 'Iasis', 'lgt595_j', 'diasis@gmail.com',
'1986-03-01','2015-05-27', '3', '2', '0' , '4', '' ),
('6', 'Douglas', 'Ijit', '2bg76&35', 'douglas@gmail.com',
'1976-07-01','2015-05-30', '2', '2', '0' , '4', '' ),
('7', 'Copii', 'Shlomo', '9652gjyt', 'copicopi@gmail.com',
'1988-12-15','2015-06-02', '2', '1', '0' , '3', '' ),
('8', 'Pif', 'Baltazar', '97kiuh63', 'Baltazar@gmail.com',
'1982-07-01','2015-05-24', '2', '1', '0' , '2', '' ),
('9', 'Copii', 'Shlomo', '9652gjyt', 'copicopi@gmail.com',
'1988-12-15','2015-06-02', '2', '1', '0' , '2', '' ),
('10', 'Iliose', 'Jean-Jacques', 'kkkjh689', 'ljj@gmail.com',
'1985-03-20','2015-05-24', '2', '1', '0' , '4', '' );


INSERT INTO PERFORMANCE VALUES ('1', 'Perf110m', '180', '2015-10-25', '0', '3', '3'),
('2', 'sprint', '25', '2015-10-25', '0', '3', '10'),
('3', 'Perf110m', '190', '2015-10-25', '0',  '3', '2'),
('4', 'Panier de basket', '66', '2015-01-25', '0', '2', '4'),
('5', 'Panier de basket', '110', '2014-01-25', '0',  '2', '3'),
('6', 'Panier de basket', '110', '2014-01-25', '0', '2', '6'),
('7', 'Panier de basket', '66', '2014-01-25', '0', '2', '7'),
('8', 'Panier de basket', '130', '2014-01-25', '0', '2', '8'),
('9', 'Panier de basket', '100', '2014-01-25', '0', '2', '5'),
('10', 'sprint', '410', '2014-11-25', '0', '4', '2'),
('11', 'sprint', '460', '2014-11-25', '0', '4', '7'),
('12', 'sprint', '401', '2014-11-25', '0', '4', '3'),
('13', 'sprint', '320', '2014-11-25', '0', '4', '9'),
('14', 'sprint', '210', '2014-11-25', '0', '4', '10');

INSERT INTO REL_COMP_MBR VALUES ('1', '0', '2', '3'),
('2', '0', '2', '4'), 
('3', '0',  '3', '3'),
('4', '0',  '3', '2'),
('5', '0', '3', '4'), 
('6', '0', '4', '2'), 
('7', '0', '5', '2'), 
('8', '0', '6', '2'), 
('9', '0', '7', '2'), 
('10', '0', '7', '4'), 
('11', '0', '8', '2'), 
('12', '0', '9', '4'), 
('13', '0', '10', '3'), 
('14', '0', '10', '4');

