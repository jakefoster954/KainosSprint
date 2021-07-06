INSERT INTO `Capability` VALUES (1, 'Artificial Intelligence');
INSERT INTO `Capability` VALUES (2, 'Business Development and Marketing');
INSERT INTO `Capability` VALUES (3, 'Operations');
INSERT INTO `Capability` VALUES (4, 'Data');
INSERT INTO `Capability` VALUES (5, 'Cyber Security');
INSERT INTO `Capability` VALUES (6, 'Engineering');
INSERT INTO `Capability` VALUES (7, 'Delivery');
INSERT INTO `Capability` VALUES (8, 'People Team');
INSERT INTO `Capability` VALUES (9, 'Product');
INSERT INTO `Capability` VALUES (10, 'Testing');
INSERT INTO `Capability` VALUES (11, 'Workday');
INSERT INTO `Capability` VALUES (12, 'Commercial and Financial Management');
INSERT INTO `Capability` VALUES (13, 'Experience Design');
INSERT INTO `Capability` VALUES (14, 'Organisational Strategy and Planning');
INSERT INTO `Capability` VALUES (15, 'Platforms');

INSERT INTO JobFamily VALUES (1, 'AI Engineering', 1);
INSERT INTO JobFamily VALUES (2, 'Data Science', 1);

INSERT INTO JobFamily VALUES (3, 'Business Development and Marketing Strategy and Planning', 2);
INSERT INTO JobFamily VALUES (4, 'Bid Production', 2);
INSERT INTO JobFamily VALUES (5, 'Business Development', 2);
INSERT INTO JobFamily VALUES (6, 'Client Management', 2);
INSERT INTO JobFamily VALUES (7, 'Inside Sales', 2);
INSERT INTO JobFamily VALUES (8, 'Marketing - Business', 2);
INSERT INTO JobFamily VALUES (9, 'Marketing - Martech and Ops', 2);
INSERT INTO JobFamily VALUES (10, 'Partners', 2);

INSERT INTO JobFamily VALUES (11, 'Business Support', 3);
INSERT INTO JobFamily VALUES (12, 'Operations Strategy and Planning', 3);
INSERT INTO JobFamily VALUES (13, 'Operational Management', 3);
INSERT INTO JobFamily VALUES (14, 'Programme Management Office', 3);
INSERT INTO JobFamily VALUES (15, 'Staff Management', 3);


INSERT INTO JobFamily VALUES (16, 'Analysis & Data Architecture', 4);
INSERT INTO JobFamily VALUES (17, 'Data Engineering', 4);

INSERT INTO JobFamily VALUES (18, 'Corporate Security', 5);
INSERT INTO JobFamily VALUES (19, 'Cyber Security Engineering', 5);

INSERT INTO JobFamily VALUES (20, 'Engineering', 6);
INSERT INTO JobFamily VALUES (21, 'Engineering Strategy and Planning', 6);
INSERT INTO JobFamily VALUES (22, 'Product Specialist', 6);
INSERT INTO JobFamily VALUES (23, 'Architecture', 6);
INSERT INTO JobFamily VALUES (24, 'Testing and Quality Assurance', 6);


INSERT INTO JobFamily VALUES (25, 'Service Management', 7);
INSERT INTO JobFamily VALUES (26, 'Delivery Management Strategy and Planning', 7);
INSERT INTO JobFamily VALUES (27, 'Delivery Management', 7);
INSERT INTO JobFamily VALUES (28, 'Engagement Management', 7);

INSERT INTO JobFamily VALUES (29, 'People Strategy and Planning', 8);
INSERT INTO JobFamily VALUES (30, 'Organisational Development and Learning', 8);
INSERT INTO JobFamily VALUES (31, 'People Support', 8);
INSERT INTO JobFamily VALUES (32, 'Talent Acquisition', 8);

INSERT INTO JobFamily VALUES (33, 'Product Management', 9);

INSERT INTO JobFamily VALUES (34, 'Testing and Quality Assurance', 10);

INSERT INTO JobFamily VALUES (35, 'Adaptive Planning', 11);
INSERT INTO JobFamily VALUES (36, 'Change and User Adoption', 11);
INSERT INTO JobFamily VALUES (37, 'Data', 11);
INSERT INTO JobFamily VALUES (38, 'Financials and payroll', 11);
INSERT INTO JobFamily VALUES (39, 'HCM', 11);
INSERT INTO JobFamily VALUES (40, 'Intergrations', 11);
INSERT INTO JobFamily VALUES (41, 'Workday Product Development', 11);
INSERT INTO JobFamily VALUES (42, 'Workday ProductServices', 11);

INSERT INTO JobFamily VALUES (43, 'Commercial', 12);
INSERT INTO JobFamily VALUES (44, 'Commercial and Financial ManagementStrategy and Planning', 12);
INSERT INTO JobFamily VALUES (45, 'Financial Management', 12);

INSERT INTO JobFamily VALUES (46, 'Insights Research', 13);
INSERT INTO JobFamily VALUES (47, 'Content Design', 13);
INSERT INTO JobFamily VALUES (48, 'Service Design', 13);
INSERT INTO JobFamily VALUES (49, 'Experience Strategy', 13);
INSERT INTO JobFamily VALUES (50, 'User Research', 13);
INSERT INTO JobFamily VALUES (51, 'User Design', 13);

INSERT INTO JobFamily VALUES (52, 'Organisational Strategy and Planning', 14);

INSERT INTO JobFamily VALUES (53, 'Cloud Migration', 15);
INSERT INTO JobFamily VALUES (54, 'Platform Engineering', 15);
INSERT INTO JobFamily VALUES (55, 'Systems', 15);
INSERT INTO JobFamily VALUES (56, 'Platform Architecture', 15);
INSERT INTO JobFamily VALUES (57, 'Platform Specialist', 15);

INSERT INTO `BandLevel` VALUES (1, 'Apprentice');
INSERT INTO `BandLevel` VALUES (2, 'Trainee');
INSERT INTO `BandLevel` VALUES (3, 'Associate');
INSERT INTO `BandLevel` VALUES (4, 'Senior Associate');
INSERT INTO `BandLevel` VALUES (5, 'Consultant');
INSERT INTO `BandLevel` VALUES (6, 'Manager');
INSERT INTO `BandLevel` VALUES (7, 'Principal');
INSERT INTO `BandLevel` VALUES (8, 'Leadership Community');
INSERT INTO `BandLevel` VALUES (9, 'CTO');
INSERT INTO `BandLevel` VALUES (10, 'CEO');

INSERT INTO JobRole VALUES (1, 'AI Engineering Manager', 'Later', 'Later', 6, 1);
INSERT INTO JobRole VALUES (2, 'Account Lead', 'Later', 'Later', 8, 3);
INSERT INTO JobRole VALUES (3, 'BU Chief Operating Officer', 'Later', 'Later', 8, 12);
INSERT INTO JobRole VALUES (4, 'Data Analyst', 'Later', 'Later', 3, 16);
INSERT INTO JobRole VALUES (5, 'Corporate Security Manager', 'Later', 'Later', 6, 18);
INSERT INTO JobRole VALUES (6, 'Apprentice Software Engineer', 'Later', 'Later', 1, 20);
INSERT INTO JobRole VALUES (7, 'Client Service Manager', 'Later', 'Later', 5, 25);
INSERT INTO JobRole VALUES (8, 'Entry Level Partner', 'Later', 'Later', 6, 30);
INSERT INTO JobRole VALUES (9, 'Product Consultant', 'Later', 'Later', 3, 33);
INSERT INTO JobRole VALUES (10, 'Lead Test Engineer', 'Later', 'Later', 5, 34);
INSERT INTO JobRole VALUES (11, 'Adaptive Planning Consultant', 'Later', 'Later', 3, 35);
INSERT INTO JobRole VALUES (12, 'Commercial Consultant', 'Later', 'Later', 5, 43);
INSERT INTO JobRole VALUES (13, 'User Reseacher', 'Later', 'Later', 2, 46);
INSERT INTO JobRole VALUES (14, 'BU COO', 'Later', 'Later', 8, 52);
INSERT INTO JobRole VALUES (15, 'Cloud Migration Architect', 'Later', 'Later', 6, 53);
INSERT INTO JobRole VALUES (16, 'CEO', 'Later', 'Later', 10,1);