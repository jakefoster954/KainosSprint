CREATE VIEW ListJobRoles AS
SELECT jobName AS 'Job Role' FROM JobRole ORDER BY bandLevelID DESC, jobName;

CREATE VIEW JobSpecification AS
SELECT jobName AS 'Job Role', jobSpec AS 'Job Spec Summary', jobURL AS 'SharePoint Link' FROM JobRole;

CREATE VIEW RoleCapability AS
SELECT jobName AS 'Job Role', capabilityName AS 'Capability' FROM Capability, JobRole JOIN JobFamily ON JobFamily.jobFamilyID = JobRole.jobFamilyID WHERE JobFamily.capabilityID = Capability.capabilityID;

CREATE VIEW RoleBandLevel AS
SELECT jobName AS 'Job Role', BandLevel.bandName AS 'Band Level' FROM JobRole, BandLevel WHERE BandLevel.bandLevelID = JobRole.BandLevelID;
