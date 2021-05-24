CREATE TABLE DOG (
    id IDENTITY,
    name VARCHAR(50),
    breed VARCHAR (50),
    origin VARCHAR (50),
    PRIMARY KEY(id)
);

INSERT INTO DOG VALUES (1, 'pico', 'french bulldog', 'visalia');
INSERT INTO DOG VALUES (2, 'tula', 'french bulldog', 'san francisco');
INSERT INTO DOG VALUES (3, 'taurinus', 'bull', 'manhattan');