-- Generated by Oracle SQL Developer Data Modeler 22.2.0.165.1149
--   at:        2022-12-23 13:28:09 EET
--   site:      Oracle Database 11g
--   type:      Oracle Database 11g



-- predefined type, no DDL - MDSYS.SDO_GEOMETRY

-- predefined type, no DDL - XMLTYPE

CREATE TABLE categorii (
    id_categorie   NUMBER NOT NULL,
    nume_categorie VARCHAR2(20) NOT NULL
);

ALTER TABLE categorii ADD CHECK ( REGEXP_LIKE ( nume_categorie,
                                                '^[A-Za-z-_ ]*' ) );

ALTER TABLE categorii ADD CONSTRAINT categorii_pk PRIMARY KEY ( id_categorie );


ALTER TABLE categorii ADD CONSTRAINT categorii__nume_un UNIQUE ( nume_categorie );

CREATE TABLE clienti (
    id_client NUMBER NOT NULL,
    nume      VARCHAR2(20) NOT NULL,
    email     VARCHAR2(20) NOT NULL
);

ALTER TABLE clienti ADD CHECK ( REGEXP_LIKE ( nume,
                                              '^[a-zA-Z_ ]*' ) );

ALTER TABLE clienti ADD CHECK ( REGEXP_LIKE ( email,
                                              '[a-z0-9._%-]+@[a-z0-9._%-]+\.[a-z]{2,4}' ) );

ALTER TABLE clienti ADD CONSTRAINT clienti_pk PRIMARY KEY ( id_client );

ALTER TABLE clienti ADD CONSTRAINT clienti_email_un UNIQUE ( email );

ALTER TABLE clienti ADD CONSTRAINT clienti_nume_un UNIQUE ( nume );

CREATE TABLE comenzi (
    id_comanda NUMBER NOT NULL,
    id_client  NUMBER NOT NULL,
    id_adresa  NUMBER NOT NULL
);

CREATE UNIQUE INDEX comenzi__idx ON
    comenzi (
        id_adresa
    ASC );

ALTER TABLE comenzi ADD CONSTRAINT comenzi_pk PRIMARY KEY ( id_comanda );

CREATE TABLE compatibilitati (
    id_produs  NUMBER NOT NULL,
    id_produs2 NUMBER NOT NULL
);

CREATE TABLE detalii_livrare (
    id_adresa NUMBER NOT NULL,
    adresa    NCHAR(20) NOT NULL
);

ALTER TABLE detalii_livrare ADD CHECK ( REGEXP_LIKE ( Adresa,
                                                      '^[a-zA-Z0-9_ ]*' ) );

ALTER TABLE detalii_livrare ADD CONSTRAINT detalii_livrare_pk PRIMARY KEY ( id_adresa );

CREATE TABLE facturi (
    id_factura NUMBER NOT NULL,
    id_comanda NUMBER NOT NULL
);

ALTER TABLE facturi ADD CONSTRAINT facturi_pk PRIMARY KEY ( id_factura );

CREATE TABLE produse (
    id_produs      NUMBER NOT NULL,
    denumire       VARCHAR2(20),
    caracteristica VARCHAR2(20) NOT NULL,
    id_categorie   NUMBER NOT NULL,
    pret           NUMBER(5) NOT NULL,
    cantitate      NUMBER(5) NOT NULL
);

ALTER TABLE produse ADD CHECK ( REGEXP_LIKE ( denumire,
                                              '^[a-zA-Z_ ]*' ) );

ALTER TABLE produse ADD CONSTRAINT produse_pk PRIMARY KEY ( id_produs );

ALTER TABLE produse ADD CONSTRAINT produse_denumire_un UNIQUE ( denumire );

CREATE TABLE produse_pe_comanda (
    id_produs  NUMBER NOT NULL,
    id_comanda NUMBER NOT NULL,
    id_factura NUMBER
);

ALTER TABLE comenzi
    ADD CONSTRAINT comenzi_clienti_fk FOREIGN KEY ( id_client )
        REFERENCES clienti ( id_client );

ALTER TABLE comenzi
    ADD CONSTRAINT comenzi_detalii_livrare_fk FOREIGN KEY ( id_adresa )
        REFERENCES detalii_livrare ( id_adresa );

ALTER TABLE compatibilitati
    ADD CONSTRAINT compatibilitati_produse_fk FOREIGN KEY ( id_produs )
        REFERENCES produse ( id_produs );

ALTER TABLE compatibilitati
    ADD CONSTRAINT compatibilitati_produse_fkv1 FOREIGN KEY ( id_produs2 )
        REFERENCES produse ( id_produs );

ALTER TABLE facturi
    ADD CONSTRAINT facturi_comenzi_fk FOREIGN KEY ( id_comanda )
        REFERENCES comenzi ( id_comanda );

ALTER TABLE produse
    ADD CONSTRAINT produse_categorii_fk FOREIGN KEY ( id_categorie )
        REFERENCES categorii ( id_categorie );

ALTER TABLE produse_pe_comanda
    ADD CONSTRAINT produse_pe_comanda_comenzi_fk FOREIGN KEY ( id_comanda )
        REFERENCES comenzi ( id_comanda );

ALTER TABLE produse_pe_comanda
    ADD CONSTRAINT produse_pe_comanda_facturi_fk FOREIGN KEY ( id_factura )
        REFERENCES facturi ( id_factura );

ALTER TABLE produse_pe_comanda
    ADD CONSTRAINT produse_pe_comanda_produse_fk FOREIGN KEY ( id_produs )
        REFERENCES produse ( id_produs );

CREATE SEQUENCE categorii_id_categorie_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER categorii_id_categorie_trg BEFORE
    INSERT ON categorii
    FOR EACH ROW
    WHEN ( new.id_categorie IS NULL )
BEGIN
    :new.id_categorie := categorii_id_categorie_seq.nextval;
END;
/

CREATE SEQUENCE clienti_id_client_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER clienti_id_client_trg BEFORE
    INSERT ON clienti
    FOR EACH ROW
    WHEN ( new.id_client IS NULL )
BEGIN
    :new.id_client := clienti_id_client_seq.nextval;
END;
/

CREATE SEQUENCE comenzi_id_comanda_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER comenzi_id_comanda_trg BEFORE
    INSERT ON comenzi
    FOR EACH ROW
    WHEN ( new.id_comanda IS NULL )
BEGIN
    :new.id_comanda := comenzi_id_comanda_seq.nextval;
END;
/

CREATE SEQUENCE detalii_livrare_id_adresa_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER detalii_livrare_id_adresa_trg BEFORE
    INSERT ON detalii_livrare
    FOR EACH ROW
    WHEN ( new.id_adresa IS NULL )
BEGIN
    :new.id_adresa := detalii_livrare_id_adresa_seq.nextval;
END;
/

CREATE SEQUENCE facturi_id_factura_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER facturi_id_factura_trg BEFORE
    INSERT ON facturi
    FOR EACH ROW
    WHEN ( new.id_factura IS NULL )
BEGIN
    :new.id_factura := facturi_id_factura_seq.nextval;
END;
/

CREATE SEQUENCE produse_id_produs_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER produse_id_produs_trg BEFORE
    INSERT ON produse
    FOR EACH ROW
    WHEN ( new.id_produs IS NULL )
BEGIN
    :new.id_produs := produse_id_produs_seq.nextval;
END;
/



-- Oracle SQL Developer Data Modeler Summary Report: 
-- 
-- CREATE TABLE                             8
-- CREATE INDEX                             1
-- ALTER TABLE                             25
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           6
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          6
-- CREATE MATERIALIZED VIEW                 0
-- CREATE MATERIALIZED VIEW LOG             0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
