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
