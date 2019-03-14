create table Category
(
	IdCategory serial primary key not null,
	Name text not null
);

create table Joke
(
	IdJoke serial primary key not null,
	Content text not null,
	Likes int check (Likes >= 0) not null,
	Dislikes int check (Dislikes >= 0) not null,
	Razlika int check (Razlika >= 0) not null,
	CategoryId serial references Category(IdCategory) not null
);

INSERT INTO Category (idcategory, name) VALUES (1, 'Chuck Norris');
INSERT INTO Category (idcategory, name) VALUES (2, 'Škola');
INSERT INTO Category (idcategory, name) VALUES (3, 'Mujo');

INSERT INTO Joke (idjoke, content, likes, dislikes, razlika, categoryid) VALUES (1, 'Zašto je Chuck Norris najjači? Zato što vježba dva dana dnevno', 0, 0, 0, 1);
INSERT INTO Joke (idjoke, content, likes, dislikes, razlika, categoryid) VALUES (2, 'Pita nastavnica hrvatskog jezika mladog osnovnoškolca: Reci ti meni što su to prilozi? Prilozi su: ketchup, majoneza, luk, salata...', 0, 0, 0, 2);
INSERT INTO Joke (idjoke, content, likes, dislikes, razlika, categoryid) VALUES (3, 'Pričaju dvije gimnazijalke: Nema mi roditelja doma ovaj vikend! Bože, pa koja si ti sretnica! Možeš učiti naglas!', 0, 0, 0, 2);
INSERT INTO Joke (idjoke, content, likes, dislikes, razlika, categoryid) VALUES (4, 'Došao Mujo u pizzeriju i naručio pizzu. Konobar ga upita: Želite da vam izrežem pizzu na 6 ili 12 komada? Ma na 6 komada, nema šanse da pojedem 12.', 0, 0, 0, 3);