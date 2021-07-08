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
    jobURL VARCHAR(300),
    bandLevelID INT,
    jobFamilyID INT,
    FOREIGN KEY (bandLevelID) REFERENCES BandLevel (bandLevelID),
    FOREIGN KEY (jobFamilyID) REFERENCES JobFamily (jobFamilyID)
);

ALTER TABLE JobRole ADD UNIQUE (jobName);
ALTER TABLE JobRole MODIFY jobURL varchar(300);
UPDATE JobRole SET jobURL ='https://kainossoftwareltd.sharepoint.com/people/Job%20Specifications/Artificial%20Intelligence/Job%20Profile%20-%20AI%20Engineering%20Manager%20(Manager).pdf' WHERE jobName = 'AI Engineering Manager';