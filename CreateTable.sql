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