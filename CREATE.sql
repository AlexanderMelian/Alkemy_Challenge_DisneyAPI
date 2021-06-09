CREATE DATABASE DisneyAPI;

USE DisneyAPI;

CREATE TABLE Movies(
    PK_movieID INT PRIMARY KEY AUTO_INCREMENT,
    image VARCHAR(100),
    title VARCHAR(20),
    creation_date DATE,
    rating TINYINT
);

CREATE TABLE Characters(
    PK_characterID INT PRIMARY KEY AUTO_INCREMENT,
    image VARCHAR(100),
    name VARCHAR(20),
    age INT,
    weight INT,
    history TEXT,
    movie_serieID INT,
    FOREIGN KEY (movie_serieID) REFERENCES Movies(PK_movieID)
);

CREATE TABLE Genders(
    PK_genderID INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(10),
    image VARCHAR(100),
    movie_serieID INT,
    FOREIGN KEY (movie_serieID) REFERENCES Movies(PK_movieID)
);