CREATE VIEW ListJobRoles AS
SELECT jobName AS 'Job Role' FROM JobRole ORDER BY bandLevelID DESC, jobName;

CREATE VIEW JobSpecification AS
SELECT jobName AS 'Job Role', jobSpec AS 'Job Spec Summary', jobURL AS 'SharePoint Link' FROM JobRole;

CREATE VIEW RoleCapability AS
SELECT jobName AS 'Job Role', capabilityName AS 'Capability'
FROM Capability, JobRole JOIN JobFamily ON JobFamily.jobFamilyID = JobRole.jobFamilyID WHERE JobFamily.capabilityID = Capability.capabilityID;

CREATE VIEW RoleBandLevel AS
SELECT jobName AS 'Job Role', BandLevel.bandName AS 'Band Level'
FROM JobRole, BandLevel WHERE BandLevel.bandLevelID = JobRole.BandLevelID;

CREATE VIEW FullData AS
SELECT jobID, jobName, jobSpec, jobURL, capabilityName, bandName
FROM (((JobRole
INNER JOIN JobFamily ON JobFamily.jobFamilyID = JobRole.jobFamilyID)
INNER JOIN Capability ON Capability.capabilityID = JobFamily.capabilityID)
INNER JOIN BandLevel ON BandLevel.bandLevelID = JobRole.bandLevelID);


SELECT Capability.capabilityID,  familyName FROM Capability, JobFamily WHERE Capability.capabilityID = JobFamily.capabilityID;

CREATE VIEW JobNamesView AS
SELECT jobName, capabilityName, bandName
FROM (((JobRole
INNER JOIN JobFamily ON JobFamily.jobFamilyID = JobRole.jobFamilyID)
INNER JOIN Capability ON Capability.capabilityID = JobFamily.capabilityID)
INNER JOIN BandLevel ON BandLevel.bandLevelID = JobRole.bandLevelID);

CREATE VIEW FullJobDataView AS
SELECT jobName, jobSpec, jobURL, capabilityName, bandName
FROM (((JobRole
INNER JOIN JobFamily ON JobFamily.jobFamilyID = JobRole.jobFamilyID)
INNER JOIN Capability ON Capability.capabilityID = JobFamily.capabilityID)
INNER JOIN BandLevel ON BandLevel.bandLevelID = JobRole.bandLevelID);

CREATE VIEW CapabilitiesView AS
SELECT capabilityName, CapabilityLead.leadName
FROM (Capability INNER JOIN CapabilityLead ON Capability.leadID = CapabilityLead.leadID);

CREATE VIEW FullCapabilityDataView AS
SELECT capabilityName, CapabilityLead.leadName, CapabilityLead.leadMessage, CapabilityLead.leadPhoto
FROM (Capability INNER JOIN CapabilityLead ON Capability.leadID = CapabilityLead.leadID);

"SELECT capabilityName, leadName, leadMessage, leadPhoto " +
        "FROM Capability " +
        "WHERE leadName = ?;");

