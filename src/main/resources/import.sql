INSERT INTO "buchung"("halbtag", "status", "stornieren")
    VALUES (FALSE, FALSE, TRUE);
INSERT INTO "buchung"("halbtag", "status", "stornieren")
    VALUES (FALSE, TRUE, TRUE);
INSERT INTO "buchung"("halbtag", "status", "stornieren")
    VALUES (TRUE, FALSE, TRUE);

INSERT INTO "rolle"(id, titel)
	VALUES (1, 'mitglied');
INSERT INTO "rolle"(id, titel)
	VALUES (2,'admin');

INSERT INTO "rang"(id, titel)
    VALUES (1, 'c1');
INSERT INTO "rang"(id, titel)
    VALUES (2, 'c2');
INSERT INTO "rang"(id, titel)
    VALUES (3, 'c3');

INSERT INTO "benutzer"(id, vorname, nachname, email, passwort, rolle_id, rang_id)
	VALUES (1, 'David','Kresic','david.kresic@gmail.com', 123, 1, 1);
INSERT INTO "benutzer"(id, vorname, nachname, email, passwort, rolle_id, rang_id)
	VALUES (2, 'Ryan','Carpio','ryan.carpio@gmail.com', 123, 2, 2);
INSERT INTO "benutzer"(id, vorname, nachname, email, passwort, rolle_id, rang_id)
	VALUES (3, 'Marua','Farag', 'marua.farag@gmail.com', 123, 2, 3);

INSERT INTO "raum"("status",name)
    VALUES (TRUE,'Focus room');
INSERT INTO "raum"("status",name)
    VALUES (FALSE,'Meeting Room');
INSERT INTO "raum"("status",name)
    VALUES (TRUE,'Shared room');