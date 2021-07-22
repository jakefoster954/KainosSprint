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

CREATE TABLE `User`(
    userID INT PRIMARY KEY AUTO_INCREMENT,
    userEmail VARCHAR(50),
    userPassword VARCHAR(50),
    userType ENUM('ADMIN','EMPLOYEE')
);

CREATE TABLE Training(
    trainingID INT PRIMARY KEY AUTO_INCREMENT,
    trainingName VARCHAR(200),
    trainingLink VARCHAR(300)
);
CREATE TABLE `BandLevel-Training`(
    bandLevelID INT,
    trainingID INT,
    FOREIGN KEY (bandLevelID) REFERENCES BandLevel (bandLevelID),
    FOREIGN KEY (trainingID) REFERENCES Training (trainingID)
);



ALTER TABLE JobRole ADD UNIQUE (jobName);
ALTER TABLE JobRole MODIFY jobURL varchar(300);

UPDATE JobRole SET jobURL ='https://tinyurl.com/4rc7u6tr' WHERE jobName = 'AI Engineering Manager';
UPDATE JobRole SET jobURL ='https://tinyurl.com/zm2k2n2u' WHERE jobName = 'Account Lead';
UPDATE JobRole SET jobURL ='https://tinyurl.com/ymvvfe2r' WHERE jobName = 'BU Chief Operating Officer';
UPDATE JobRole SET jobURL ='https://tinyurl.com/3sb4kbdk' WHERE jobName = 'Data Analyst';
UPDATE JobRole SET jobURL ='https://tinyurl.com/2xvmwcrr' WHERE jobName = 'Corporate Security Manager';
UPDATE JobRole SET jobURL ='https://tinyurl.com/vwzx22v7' WHERE jobName = 'Apprentice Software Engineer';
UPDATE JobRole SET jobURL ='https://tinyurl.com/r2aruthh' WHERE jobName = 'Client Service Manager';
UPDATE JobRole SET jobURL ='https://tinyurl.com/3ppwwpd4' WHERE jobName = 'Entry Level Partner';
UPDATE JobRole SET jobURL ='https://tinyurl.com/5pj6rf7f' WHERE jobName = 'Product Consultant';
UPDATE JobRole SET jobURL ='https://tinyurl.com/2utc886k' WHERE jobName = 'Lead Test Engineer';
UPDATE JobRole SET jobURL ='https://tinyurl.com/sjyy3bk' WHERE jobName = 'Adaptive Planning Consultant';
UPDATE JobRole SET jobURL ='https://tinyurl.com/88adtm9w' WHERE jobName = 'Commercial Consultant';
UPDATE JobRole SET jobURL ='https://tinyurl.com/3berfpfz' WHERE jobName = 'User Reseacher';
UPDATE JobRole SET jobURL ='https://tinyurl.com/y7fbpa8s' WHERE jobName = 'BU COO';

UPDATE Capability SET capabilityName = 'Business Development and Marketing' WHERE capabilityID = 2;

ALTER TABLE JobRole MODIFY jobSpec varchar(2000);

ALTER TABLE Capability ADD UNIQUE (capabilityName);
ALTER TABLE BandLevel ADD UNIQUE (bandName);
ALTER TABLE JobFamily ADD CONSTRAINT familyCapability UNIQUE (familyName, capabilityID);
ALTER TABLE JobRole ADD CONSTRAINT jobRoleUnique UNIQUE (jobName, bandLevelID, jobFamilyID);

UPDATE Capability SET leadName ='Josh Kelso', leadPhoto = 'https://tinyurl.com/5bdwfj42', leadMessage = 'Howdy Partner' WHERE capabilityID = '1';
UPDATE Capability SET leadName ='Andrew Barker', leadPhoto = 'R', leadMessage = 'Hello' WHERE capabilityID = '2';
UPDATE Capability SET leadName ='Marcus Gormley', leadPhoto = 'R', leadMessage = 'Hello' WHERE capabilityID = '3';
UPDATE Capability SET leadName ='Simon Toothill', leadPhoto = 'R', leadMessage = 'Hello' WHERE capabilityID = '4';
UPDATE Capability SET leadName ='Michal Gorski', leadPhoto = 'R', leadMessage = 'Hello' WHERE capabilityID = '5';
UPDATE Capability SET leadName ='Chris Burns', leadPhoto = 'R', leadMessage = 'Hello' WHERE capabilityID = '6';
UPDATE Capability SET leadName ='Aislinn McBride', leadPhoto = 'R', leadMessage = 'Hello' WHERE capabilityID = '7';
UPDATE Capability SET leadName ='Joe McGrath', leadPhoto = 'R', leadMessage = 'Hello' WHERE capabilityID = '8';
UPDATE Capability SET leadName ='Dougie Johnson', leadPhoto = 'R', leadMessage = 'Hello' WHERE capabilityID = '9';
UPDATE Capability SET leadName ='Aislinn McBride', leadPhoto = 'R', leadMessage = 'Hello' WHERE capabilityID = '10';
UPDATE Capability SET leadName ='Andy Burnage', leadPhoto = 'R', leadMessage = 'Hello' WHERE capabilityID = '11';
UPDATE Capability SET leadName ='Eimear Rooney', leadPhoto = 'R', leadMessage = 'Hello' WHERE capabilityID = '12';
UPDATE Capability SET leadName ='Peter Gallagher', leadPhoto = 'R', leadMessage = 'Hello' WHERE capabilityID = '13';
UPDATE Capability SET leadName ='Mack Magill', leadPhoto = 'R', leadMessage = 'Hello' WHERE capabilityID = '14';
UPDATE Capability SET leadName ='Andrew Walker', leadPhoto = 'R', leadMessage = 'Hello' WHERE capabilityID = '15';

ALTER TABLE Capability ADD leadPhoto VARCHAR(1000);

CREATE TABLE CapabilityLead(
    leadID INT PRIMARY KEY AUTO_INCREMENT,
    leadName VARCHAR(100),
    leadMessage text,
    leadPhoto VARCHAR(1000)
);

UPDATE Capability SET leadName ='Josh Kelso', leadPhoto = 'https://tinyurl.com/5bdwfj42', leadMessage = 'Howdy Partner' WHERE capabilityID = '1';
UPDATE Capability SET leadName ='Andrew Barker', leadPhoto = 'R', leadMessage = 'Hello' WHERE capabilityID = '2';
UPDATE Capability SET leadName ='Marcus Gormley', leadPhoto = 'R', leadMessage = 'Hello' WHERE capabilityID = '3';
UPDATE Capability SET leadName ='Simon Toothill', leadPhoto = 'R', leadMessage = 'Hello' WHERE capabilityID = '4';
UPDATE Capability SET leadName ='Michal Gorski', leadPhoto = 'R', leadMessage = 'Hello' WHERE capabilityID = '5';
UPDATE Capability SET leadName ='Chris Burns', leadPhoto = 'R', leadMessage = 'Hello' WHERE capabilityID = '6';
UPDATE Capability SET leadName ='Aislinn McBride', leadPhoto = 'R', leadMessage = 'Hello' WHERE capabilityID = '7';
UPDATE Capability SET leadName ='Joe McGrath', leadPhoto = 'R', leadMessage = 'Hello' WHERE capabilityID = '8';
UPDATE Capability SET leadName ='Dougie Johnson', leadPhoto = 'R', leadMessage = 'Hello' WHERE capabilityID = '9';
UPDATE Capability SET leadName ='Aislinn McBride', leadPhoto = 'R', leadMessage = 'Hello' WHERE capabilityID = '10';
UPDATE Capability SET leadName ='Andy Burnage', leadPhoto = 'R', leadMessage = 'Hello' WHERE capabilityID = '11';
UPDATE Capability SET leadName ='Eimear Rooney', leadPhoto = 'R', leadMessage = 'Hello' WHERE capabilityID = '12';
UPDATE Capability SET leadName ='Peter Gallagher', leadPhoto = 'R', leadMessage = 'Hello' WHERE capabilityID = '13';
UPDATE Capability SET leadName ='Mack Magill', leadPhoto = 'R', leadMessage = 'Hello' WHERE capabilityID = '14';
UPDATE Capability SET leadName ='Andrew Walker', leadPhoto = 'R', leadMessage = 'Hello' WHERE capabilityID = '15';

INSERT INTO CapabilityLead (leadName, leadMessage, leadPhoto) VALUES ('Josh Kelso', 'Howdy Partner', 'https://tinyurl.com/5bdwfj42');
INSERT INTO CapabilityLead (leadName, leadMessage, leadPhoto) VALUES ('Andrew Barker', 'Barking up the wrong tree', 'https://tinyurl.com/6shn3dym');
INSERT INTO CapabilityLead (leadName, leadMessage, leadPhoto) VALUES ('Marcus Gormley', 'Gormed', 'https://tinyurl.com/3yauxrd3');
INSERT INTO CapabilityLead (leadName, leadMessage, leadPhoto) VALUES ('Simon Toothill', 'hehe toot', 'https://tinyurl.com/3yauxrd3');
INSERT INTO CapabilityLead (leadName, leadMessage, leadPhoto) VALUES ('Michal Gorski', 'How about you go(r) ski', 'https://tinyurl.com/3xjtk7yt');
INSERT INTO CapabilityLead (leadName, leadMessage, leadPhoto) VALUES ('Chris Burns', 'Need some cold water on that burns', 'https://tinyurl.com/yvfcvdrm');
INSERT INTO CapabilityLead (leadName, leadMessage, leadPhoto) VALUES ('Aislinn McBride', 'Need no McGroom', 'https://tinyurl.com/e628djmd');
INSERT INTO CapabilityLead (leadName, leadMessage, leadPhoto) VALUES ('Joe McGrath', 'Joe of all trades', 'https://tinyurl.com/yuf9ysnw');
INSERT INTO CapabilityLead (leadName, leadMessage, leadPhoto) VALUES ('Dougie Johnson', 'Already half vaccinated', 'https://tinyurl.com/r7ptn6f3');
INSERT INTO CapabilityLead (leadName, leadMessage, leadPhoto) VALUES ('Aislie Rooney', 'Also not the football manager', 'https://tinyurl.com/s82ewujw');
INSERT INTO CapabilityLead (leadName, leadMessage, leadPhoto) VALUES ('Andy Burnage', 'Feel the Burnage', 'https://tinyurl.com/3rmpw43e');
INSERT INTO CapabilityLead (leadName, leadMessage, leadPhoto) VALUES ('Eimear Rooney', 'Not the football manager', 'https://tinyurl.com/mr8z3ypc');
INSERT INTO CapabilityLead (leadName, leadMessage, leadPhoto) VALUES ('Peter Gallagher', 'The Gall(agher) of some people', 'https://tinyurl.com/22c3mcfk');
INSERT INTO CapabilityLead (leadName, leadMessage, leadPhoto) VALUES ('Mack Magill', 'Return of the Mack', 'https://tinyurl.com/ybmf5x22');
INSERT INTO CapabilityLead (leadName, leadMessage, leadPhoto) VALUES ('Andrew Walker', 'Better than the crisp', 'https://tinyurl.com/296kssk4');

ALTER TABLE Capability ADD leadID INT;

ALTER TABLE Capability ADD FOREIGN KEY (leadID) REFERENCES CapabilityLead(leadID);

UPDATE Capability SET leadID = 1 WHERE capabilityID = '1';
UPDATE Capability SET leadID = 2 WHERE capabilityID = '2';
UPDATE Capability SET leadID = 3 WHERE capabilityID = '3';
UPDATE Capability SET leadID = 4 WHERE capabilityID = '4';
UPDATE Capability SET leadID = 5 WHERE capabilityID = '5';
UPDATE Capability SET leadID = 6 WHERE capabilityID = '6';
UPDATE Capability SET leadID = 7 WHERE capabilityID = '7';
UPDATE Capability SET leadID = 8 WHERE capabilityID = '8';
UPDATE Capability SET leadID = 9 WHERE capabilityID = '9';
UPDATE Capability SET leadID = 10 WHERE capabilityID = '10';
UPDATE Capability SET leadID = 11 WHERE capabilityID = '11';
UPDATE Capability SET leadID = 12 WHERE capabilityID = '12';
UPDATE Capability SET leadID = 13 WHERE capabilityID = '13';
UPDATE Capability SET leadID = 14 WHERE capabilityID = '14';
UPDATE Capability SET leadID = 15 WHERE capabilityID = '15';


ALTER TABLE Capability DROP COLUMN leadName, leadMessage, leadPhoto;

UPDATE User SET userEmail = 'admin@kainos.com' WHERE userID = 2;

UPDATE Capability SET leadID = 1 WHERE capabilityID = 2;

ALTER TABLE JobFamily MODIFY familyName varchar(300);