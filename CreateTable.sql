CREATE DATABASE KainosSprint;

USE KainosSprint;

CREATE TABLE Capability(
    capabilityID INT PRIMARY KEY AUTO_INCREMENT,
    capabilityName VARCHAR(30)
);

CREATE TABLE JobFamily(
    jobFamilyID INT PRIMARY KEY AUTO_INCREMENT,
    familyName VARCHAR(50),
    capabilityID INT,
    FOREIGN KEY (capabilityID) REFERENCES Capability (capabilityID)
);

CREATE TABLE BandLevel(
    bandLevelID INT PRIMARY KEY AUTO_INCREMENT,
    bandName VARCHAR(30)
);

CREATE TABLE JobRole(
    jobID INT PRIMARY KEY AUTO_INCREMENT,
    jobName VARCHAR(50),
    jobSpec VARCHAR(300),
    jobURL VARCHAR(150),
    bandLevelID INT,
    jobFamilyID INT,
    FOREIGN KEY (bandLevelID) REFERENCES BandLevel (bandLevelID),
    FOREIGN KEY (jobFamilyID) REFERENCES JobFamily (jobFamilyID)
);

ALTER TABLE JobRole ADD UNIQUE (jobName);
