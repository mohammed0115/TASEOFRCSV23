-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 21, 2023 at 10:51 AM
-- Server version: 10.4.19-MariaDB
-- PHP Version: 7.3.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `taseofrcs`
--

-- --------------------------------------------------------

--
-- Table structure for table `beams`
--

CREATE TABLE `beams` (
  `name` varchar(50) NOT NULL,
  `volume` int(11) NOT NULL,
  `loss` int(11) NOT NULL,
  `id` int(11) NOT NULL,
  `buid_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `beams`
--

INSERT INTO `beams` (`name`, `volume`, `loss`, `id`, `buid_id`) VALUES
('B0', 0, 0, 414, 100032),
('B1', 88, 0, 415, 100032),
('B0', 0, 0, 416, 100034),
('B1', 0, 0, 417, 100034),
('B2', 0, 0, 418, 100034),
('B0', 0, 0, 419, 100035),
('B1', 0, 0, 420, 100035),
('B0', 0, 0, 583, 100033),
('B1', 0, 0, 584, 100033),
('B2', 0, 0, 585, 100033),
('B3', 0, 0, 586, 100033);

-- --------------------------------------------------------

--
-- Table structure for table `buiding`
--

CREATE TABLE `buiding` (
  `Buiding_name` varchar(50) DEFAULT NULL,
  `id` int(15) NOT NULL,
  `Buiding_profile` varchar(50) DEFAULT NULL,
  `location` varchar(50) DEFAULT NULL,
  `owner_id` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `buildingServiceAge` int(11) DEFAULT NULL,
  `designBuildingAge` int(11) DEFAULT NULL,
  `numberOfFlour` int(11) DEFAULT NULL,
  `TotalSlabNum` int(11) DEFAULT NULL,
  `TotalBeamNum` int(11) DEFAULT NULL,
  `TotalColumnNum` int(11) DEFAULT NULL,
  `TotalWallNum` int(11) DEFAULT NULL,
  `SlabsCost` int(11) DEFAULT NULL,
  `BeamCost` int(11) DEFAULT NULL,
  `ColumnCost` int(11) DEFAULT NULL,
  `WallCost` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `buiding`
--

INSERT INTO `buiding` (`Buiding_name`, `id`, `Buiding_profile`, `location`, `owner_id`, `date`, `buildingServiceAge`, `designBuildingAge`, `numberOfFlour`, `TotalSlabNum`, `TotalBeamNum`, `TotalColumnNum`, `TotalWallNum`, `SlabsCost`, `BeamCost`, `ColumnCost`, `WallCost`) VALUES
('project test 2023', 100033, 'test', 'khartoum', 2, '2023-10-10', 10, 10, 0, 4, 3, 5, 6, 0, 0, 0, 0),
('project test ', 100034, 'test4545', 'khartoum', 1, '2023-10-10', 10, 10, 0, 4, 2, 1, 5, 0, 0, 0, 0),
('project test 2023', 100035, 'test', 'khartoum', 1, '2023-10-10', 10, 10, 0, 1, 1, 1, 1, 0, 0, 0, 0),
('project test ', 100036, 'test', 'khartoum', 1, '2023-10-10', 10, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0),
('project test ', 100037, 'test', 'khartoum', 1, '2023-10-10', 10, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0),
('project test ', 100038, 'test', 'khartoum', 1, '2023-10-10', 10, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0),
('project test ', 100039, 'test', 'khartoum', 1, '2023-10-10', 10, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0),
('project test ', 100040, 'test', 'khartoum', 1, '2023-10-10', 10, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0),
('project test ', 100041, 'test', 'khartoum', 1, '2023-10-10', 10, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0),
('project test ', 100042, 'test', 'khartoum', 1, '2023-10-10', 10, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0),
('project test ', 100043, 'test', 'khartoum', 1, '2023-10-10', 10, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0),
('project test ', 100044, 'test', 'khartoum', 1, '2023-10-10', 10, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0),
('project test ', 100045, 'test', 'khartoum', 1, '2023-10-10', 10, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0),
('project test ', 100046, 'test', 'khartoum', 1, '2023-10-10', 10, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0),
('project test ', 100047, 'test', 'khartoum', 1, '2023-10-10', 10, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0),
('project test ', 100048, 'test', 'khartoum', 1, '2023-10-10', 10, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0),
('project test ', 100049, 'test', 'khartoum', 1, '2023-10-10', 10, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0),
('project test ', 100050, 'test', 'khartoum', 1, '2023-10-10', 10, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0),
('project test ', 100051, 'test', 'khartoum', 1, '2023-10-10', 10, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0),
('project test ', 100052, 'test', 'khartoum', 1, '2023-10-10', 10, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0),
('project kfhkkjdkdfkhhkfdfhd', 100053, 'test', 'khartoum', 1, '2023-10-10', 10, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0),
('project test ', 100054, 'test', 'khartoum', 1, '2023-10-10', 10, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0),
('project test ', 100055, 'test', 'khartoum', 1, '2023-10-10', 10, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0),
('project test ', 100057, 'test', 'khartoum', 1, '2023-10-10', 10, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `buildingclassification`
--

CREATE TABLE `buildingclassification` (
  `id` int(11) NOT NULL,
  `sub_criteria` int(11) NOT NULL,
  `linguistic_variable` int(11) NOT NULL,
  `StateCondition` varchar(200) NOT NULL,
  `StateCoditinClassification` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `buildingclassification`
--

INSERT INTO `buildingclassification` (`id`, `sub_criteria`, `linguistic_variable`, `StateCondition`, `StateCoditinClassification`) VALUES
(1112, 1, 100001, 'No change of shape and/or usage', 3),
(1113, 1, 100002, 'Partial change of shape and/or usage with slight increase of load.', 3),
(1114, 1, 100003, 'Overall change of shape and/or usage with slight increase of load.', 3),
(1115, 1, 100004, 'Partial change of shape and/or usage with large increase of load', 3),
(1116, 1, 100005, 'Overall change of shape and/or usage with large increase of load.', 3),
(1117, 2, 100001, 'No alteration of structural members', 3),
(1118, 2, 100002, 'Partial alteration of structural members with slight effect', 3),
(1119, 2, 100003, 'Moderate effect due to alteration of structural member', 3),
(1120, 2, 100004, 'Severe effect due to alteration of structural member.', 3),
(1121, 2, 100005, 'Overall alteration of structural members with extensive effect', 3),
(1122, 3, 100001, 'No records for accident history.', 3),
(1123, 3, 100002, 'Records of accident with slight structural effects.', 3),
(1124, 3, 100003, 'Records of accident with moderate structural effect.', 3),
(1125, 3, 100004, 'Records of repeated accident with bad structural effects', 3),
(1126, 3, 100005, 'Records of repeated accident with extensive structural effect.', 3),
(1127, 4, 100001, 'Lifespan is less than 10 years', 3),
(1128, 4, 100002, 'Lifespan ranges from 10 to 30 years.', 3),
(1129, 4, 100003, 'Lifespan ranges from 30 to 50 years', 3),
(1130, 4, 100004, 'Lifespan ranges from 50 to 70 years.', 3),
(1131, 4, 100005, 'Lifespan is more than 70 years.', 3),
(1132, 5, 100001, 'No exposure to salt damage.', 4),
(1133, 5, 100002, 'Small concentrations of salt in the atmosphere, away from seacoast)', 4),
(1134, 5, 100003, 'Moderate connotation of salts (relatively close to the coast).', 4),
(1135, 5, 100004, 'Exposed to large amount of salts in atmosphere (close to the coast  with sewage and water pipes problems).', 4),
(1136, 5, 100005, 'Exposed to severe attack by salts and appearance of efflorescence.', 4),
(1137, 6, 100001, 'Exposed to natural temperature, atmospheric temperature', 4),
(1138, 6, 100002, 'Exposed to high temperature above normal but less than 300ÂºC (normal concrete color).', 4),
(1139, 6, 100003, 'Exposed temperature ranges from 300 to 600ÂºC (pink or red color).', 4),
(1140, 6, 100004, 'Exposed temperature ranges from 600 to 1000ÂºC (Gray color)', 4),
(1141, 6, 100005, 'Exposed to temperature more than 1000ÂºC (buff color).', 4),
(1142, 7, 100001, 'No neighbor constructions', 4),
(1143, 7, 100002, 'Neighbor constructions exposed to damage with no effects.', 4),
(1144, 7, 100003, 'Neighbor constructions exposed to a bombing with slight effect.', 4),
(1145, 7, 100004, 'Neighbor constructions exposed to bombings with massive effects', 4),
(1146, 7, 100005, 'Severe structural effects due to neighbor constructions.', 4),
(1147, 8, 100001, 'No surface deterioration', 5),
(1148, 8, 100002, 'Visible shrinkage cracking only, micro cracks.', 5),
(1149, 8, 100003, 'Moderate deterioration with possible deformation and cracks', 5),
(1150, 8, 100004, 'Bad deterioration (crack extended into the concrete member), crushed concrete, and/or deformation of concrete surface', 5),
(1151, 8, 100005, 'Severe deterioration, crushing large amount of concrete', 5),
(1152, 9, 100001, 'Hair cracks, Maximum crack width less than 0.4 mm', 5),
(1153, 9, 100002, 'Very small cracks, Maximum crack width ranges from 0.4 to 0.8 mm', 5),
(1154, 9, 100003, 'Visible cracks, Maximum crack width ranges from 0.6 to 1.0 mm', 5),
(1155, 9, 100004, 'Large cracks, Maximum crack width ranges from 0.8 to 1.2 mm', 5),
(1156, 9, 100005, 'Very large cracks, Maximum crack width greater than 1.2 mm', 5),
(1157, 10, 100001, 'No noticeable deflection, Maximum deflection less than L/250', 5),
(1158, 10, 100002, 'Light deflection, Maximum deflection ranges from L/240 to L/210', 5),
(1159, 10, 100003, 'Maximum deflection ranges from L/200 to L/180', 5),
(1160, 10, 100004, 'Maximum deflection ranges from L/170 to L/160', 5),
(1161, 10, 100005, 'Severe deflection, Maximum deflection greater L/150', 5),
(1162, 11, 100001, 'No noticeable tilting, Story drift is less than 0.004 hs', 5),
(1163, 11, 100002, 'story drift ranges from 0.005 hs to 0.007 hs', 5),
(1164, 11, 100003, 'Moderate tilting, story drift ranges from 0.008 hs to 0.010 hs', 5),
(1165, 11, 100004, 'story drift ranges from 0.010 hs to 0.012 hs', 5),
(1166, 11, 100005, 'Severe tilting, story drift is greater than 0.012 hs', 5),
(1167, 12, 100001, 'No observed settlement.', 5),
(1168, 12, 100002, 'Cracks in nonstructural elements (approximate settlement â‰¤50 mm)', 5),
(1169, 12, 100003, 'Observed cracks in nonstructural and, slight cracks of structural elements related to foundation settlements', 5),
(1170, 12, 100004, 'Heavy cracks in structural elements related to foundation settlement', 5),
(1171, 12, 100005, 'Severe cracks, approximate settlement â‰¥ 1000mm', 5),
(1172, 13, 100006, 'No scaling / spalling.', 6),
(1173, 13, 100007, 'Loss of surface mortar without exposure of coarse aggregate.', 6),
(1174, 13, 100008, 'Loss of surface mortar with exposure of coarse aggregate (depth of surface mortar loss ranges from 5 to 10 mm).', 6),
(1175, 13, 100009, 'Loss of surface mortar with some loss of coarse aggregate (depth of surface mortar loss ranges from 10 to 20 mm).', 6),
(1176, 13, 100010, 'Loss of coarse aggregate as well as surface mortar (depth of surface mortar loss is greater than 20 mm).', 6),
(1177, 14, 100006, 'No observed leakage', 6),
(1178, 14, 100007, 'Slight leakage in small area', 6),
(1179, 14, 100008, 'Moderate leakage', 6),
(1180, 14, 100009, 'Bad leakage in big area', 6),
(1181, 14, 100010, 'Very extensive leakage', 6),
(1182, 15, 100006, 'No observed corrosion.', 6),
(1183, 15, 100007, 'Observed cracks with no delamination due to corrosion', 6),
(1184, 15, 100008, 'Sound test indicates moderate delamination', 6),
(1185, 15, 100009, 'Sound test indicates bad delamination', 6),
(1186, 15, 100010, 'Spalling delamination of concrete due to corrosion', 6),
(1187, 16, 100006, 'No exposure condition for corrosion', 6),
(1188, 16, 100007, 'Slight corrosion conditions', 6),
(1189, 16, 100008, 'Moderate corrosion conditions', 6),
(1190, 16, 100009, 'Bad conditions', 6),
(1191, 16, 100010, 'Sever conditions', 6),
(1192, 17, 100006, 'No damage', 6),
(1193, 17, 100007, 'Partial slight damage', 6),
(1194, 17, 100008, 'Overall slight damage', 6),
(1195, 17, 100009, 'Partial severe damage', 6),
(1196, 17, 100010, 'Overall severe damage', 6),
(1290, 18, 100007, '0.2 mm', 7),
(1291, 18, 100008, '0. 3 mm', 7),
(1292, 18, 100009, '0.4 mm', 7),
(1293, 18, 100010, 'Greater than 0.4 mm', 7),
(1294, 19, 100006, '--', 7),
(1295, 19, 100007, '1/150', 7),
(1296, 19, 100008, '1/100', 7),
(1297, 19, 100009, '\"1/75\"', 7),
(1298, 19, 100010, 'Greater than 1/50', 7),
(1299, 20, 100006, '--', 7),
(1300, 20, 100007, '1/400', 7),
(1301, 20, 100008, '1/300', 7),
(1302, 20, 100009, '1/200', 7),
(1303, 20, 100010, 'Greater than 1/200', 7),
(1304, 21, 100006, '--', 7),
(1305, 21, 100007, '--', 7),
(1306, 21, 100008, '20', 7),
(1307, 21, 100009, '30', 7),
(1308, 21, 100010, 'Greater than 30', 7),
(1309, 22, 100006, '--', 7),
(1310, 22, 100007, '5', 7),
(1311, 22, 100008, '10', 7),
(1312, 22, 100009, '20', 7),
(1313, 22, 100010, 'Greaterthan 20', 7),
(1314, 23, 100006, '--', 8),
(1315, 23, 100007, '0.2 mm', 8),
(1316, 23, 100008, '0.3 mm', 8),
(1317, 23, 100009, '0.4 mm', 8),
(1318, 23, 100010, 'Greater than 0.4 mm', 8),
(1319, 24, 100006, '0.1 mm', 8),
(1320, 24, 100007, '0.3 mm', 8),
(1321, 24, 100008, '0.4 mm', 8),
(1322, 24, 100009, '0.5 mm', 8),
(1323, 24, 100010, 'Greater than 0.5 mm', 8),
(1324, 25, 100006, '5', 8),
(1325, 25, 100007, '10', 8),
(1326, 25, 100008, '15', 8),
(1327, 25, 100009, '25', 8),
(1328, 25, 100010, 'Greater  than 25', 8),
(1329, 26, 100006, '--', 8),
(1330, 26, 100007, '5', 8),
(1331, 26, 100008, '10', 8),
(1332, 26, 100009, '20', 8),
(1333, 26, 100010, 'Grater than 20', 8),
(1334, 27, 100006, '--', 8),
(1335, 27, 100007, '--', 8),
(1336, 27, 100008, '--', 8),
(1337, 27, 100009, '--', 8),
(1338, 27, 100010, '--', 8),
(1339, 28, 100006, 'There is no damage to the protective layers of the concrete, some capillary cracks in the non-insulated surfaces', 9),
(1340, 28, 100007, 'There is a destroy in the protective layers in some areas, there are oily, wet or salt stains', 9),
(1341, 29, 100006, 'The thickness of the concrete covering layer is less than the design by up to 20%', 9),
(1342, 29, 100007, 'The thickness of the concrete covering layer is less than the design by up to 30% and within an area not exceeding 30% of the surface of the element', 9),
(1343, 29, 100008, 'Exposure of secondary structural steel reinforcement, some of which are cut off due to oxidation, no cracks in this area', 9),
(1344, 29, 100009, 'crash in the concrete in the main concrete section after the covering layer', 9),
(1345, 29, 100010, 'crash in the concrete in the concrete section after the covering layer and the exclusion of some large stones', 9),
(1346, 30, 100006, 'Reinforcing steel surfaces are clean after inspection', 9),
(1347, 30, 100007, 'There are oxidation phenomena for accidental or secondary rebar on the protective layers in some areas, there are no phenomena of oxidation of working rebar', 9),
(1348, 30, 100008, 'Oxidation or staining phenomena in rebar working in the longitudinal cracks area', 9),
(1349, 30, 100009, '--', 9),
(1350, 30, 100010, 'Disruption of reinforcing steel columns and pressed elements and the area of inclined cracks, breaks in some working tensioned rebar bars, buckling in the stress area reinforcing steel', 9),
(1351, 31, 100006, 'Nothing', 10),
(1352, 31, 100007, 'In the coverage layer, not more than 3 areas and with limit of not more than 30 cm2 in each area', 10),
(1353, 31, 100008, 'In the coverage layer and with a limit of not more than 50 cm2 in each area except in the joint area ', 10),
(1354, 31, 100009, 'With a depth exceeding the coverage layer but not more than 5cm except in the joint area', 10),
(1355, 31, 100010, 'Deep more than 5 cm', 10),
(1356, 32, 100006, '0.1 mm', 10),
(1357, 32, 100007, '0.3 mm', 10),
(1358, 32, 100008, '0.5 mm', 10),
(1359, 32, 100009, '1.0 mm', 10),
(1360, 32, 100010, 'Greater than 1 mm', 10),
(1361, 33, 100006, '--', 10),
(1362, 33, 100007, '5', 10),
(1363, 33, 100008, '20', 10),
(1364, 33, 100009, '30', 10),
(1365, 33, 100010, 'Greater than 30', 10),
(1366, 34, 100006, 'None', 10),
(1367, 34, 100007, 'None', 10),
(1368, 34, 100008, 'Purple', 10),
(1369, 34, 100009, 'Purple to Red', 10),
(1370, 34, 100010, 'Untile Dark Yellow', 10),
(1371, 35, 100006, 'Drift less than 0.004 hs', 11),
(1372, 35, 100007, 'Drift ranging from 0.005 hs to0.007 hs', 11),
(1373, 35, 100008, 'Drift ranging from 0.010 hs to 0.008 hs', 11),
(1374, 35, 100009, 'Drift ranging from 0.012hs to 0.0107 hs', 11),
(1375, 35, 100010, 'Drift greater than 0.012 hs', 11),
(1376, 36, 100006, 'No signs of soil subsidence', 11),
(1377, 36, 100007, 'Cracks appearing in non-structural elements of the building(approximate subsidence < 50mm)', 11),
(1378, 36, 100008, 'Cracks in non-structural elements for the building, light cracks in the elements', 11),
(1379, 36, 100009, 'Many cracks in the structural elements caused by subsidence in the foundation of the building', 11),
(1380, 36, 100010, 'Severe cracks in the building (approximate subsidence > or = 1000mm)', 11);

-- --------------------------------------------------------

--
-- Table structure for table `columns_`
--

CREATE TABLE `columns_` (
  `name` varchar(50) NOT NULL,
  `volume` int(11) NOT NULL,
  `loss` int(11) NOT NULL,
  `id` int(11) NOT NULL,
  `buid_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `columns_`
--

INSERT INTO `columns_` (`name`, `volume`, `loss`, `id`, `buid_id`) VALUES
('C0', 0, 0, 435, 100032),
('C1', 0, 25, 436, 100032),
('C0', 0, 0, 437, 100034),
('C1', 0, 0, 438, 100034),
('C0', 0, 0, 439, 100035),
('C1', 0, 0, 440, 100035),
('C0', 0, 0, 683, 100033),
('C1', 0, 0, 684, 100033),
('C2', 0, 0, 685, 100033),
('C3', 0, 0, 686, 100033),
('C4', 0, 0, 687, 100033),
('C5', 0, 0, 688, 100033);

-- --------------------------------------------------------

--
-- Table structure for table `linguistic_variable`
--

CREATE TABLE `linguistic_variable` (
  `id` int(11) NOT NULL,
  `name` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `linguistic_variable`
--

INSERT INTO `linguistic_variable` (`id`, `name`) VALUES
(100001, 'Very Good'),
(100002, 'Good'),
(100003, 'Moderate'),
(100004, 'Bad'),
(100005, 'Very Bad'),
(100006, 'The item meets the function\r\n'),
(100008, 'The item meets the  function in a limited way'),
(100009, 'The item does not meet  the function'),
(100010, 'The item is in a state of breakdown'),
(100011, 'Cracks width up to 0.5 mm, depth of depression up to 5 mm, with a number not exceeding 3 per square meter'),
(100012, 'crack width up to 2 mm, column curvature up to 1/200 of height'),
(100013, 'The incisions are more than 2 mm wide'),
(100014, 'Cracks widening up to 0.5 mm'),
(100015, 'Cracks width up to 2 mm total length of \r\nshrinkage cracks not \r\nmore than 0.8 m on an \r\narea of 1m2');

-- --------------------------------------------------------

--
-- Table structure for table `slabs`
--

CREATE TABLE `slabs` (
  `name` varchar(50) NOT NULL,
  `volume` int(11) NOT NULL,
  `loss` int(11) NOT NULL,
  `id` int(11) NOT NULL,
  `buid_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `slabs`
--

INSERT INTO `slabs` (`name`, `volume`, `loss`, `id`, `buid_id`) VALUES
('S0', 0, 0, 502, 100032),
('S1', 0, 0, 503, 100032),
('S0', 0, 0, 504, 100034),
('S1', 0, 0, 505, 100034),
('S2', 0, 0, 506, 100034),
('S3', 0, 0, 507, 100034),
('S4', 0, 0, 508, 100034),
('S0', 0, 0, 509, 100035),
('S1', 0, 0, 510, 100035),
('S0', 0, 0, 713, 100033),
('S1', 0, 0, 714, 100033),
('S2', 0, 0, 715, 100033),
('S3', 0, 0, 716, 100033),
('S4', 0, 0, 717, 100033);

-- --------------------------------------------------------

--
-- Table structure for table `statecoditinclassification`
--

CREATE TABLE `statecoditinclassification` (
  `id` int(11) NOT NULL,
  `name` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `statecoditinclassification`
--

INSERT INTO `statecoditinclassification` (`id`, `name`) VALUES
(3, 'State conditions for Building History state\r\n'),
(4, 'State conditions for environmental condition sub-criteria\r\n'),
(5, 'State conditions for structural capacity sub-criteria\r\n'),
(6, 'State conditions for durability sub-criteria\r\n'),
(7, 'Structural Evaluation of reinforced concrete beams and slabs\r\n'),
(8, 'Structural Evaluation of the elements of columns and reinforced concrete walls\r\n'),
(9, 'Structural Evaluation of reinforced concrete elements\r\n'),
(10, 'Structural Evaluation of reinforced concrete elements as a result of fire\r\n'),
(11, 'Evaluation of the tilt and stability of structure'),
(12, 'Physical loss ratios for the value of slabs and beams \r\n');

-- --------------------------------------------------------

--
-- Table structure for table `structuralevaluation`
--

CREATE TABLE `structuralevaluation` (
  `damage_type` int(11) NOT NULL,
  `Item_classification` int(11) NOT NULL,
  `damage_value` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `sub_criteria`
--

CREATE TABLE `sub_criteria` (
  `id` int(11) NOT NULL,
  `name` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `sub_criteria`
--

INSERT INTO `sub_criteria` (`id`, `name`) VALUES
(1, 'Shape and usage change.'),
(2, 'Alteration  of structural members'),
(3, 'Accident  history.'),
(4, 'service years'),
(5, 'Exposure to salt damage'),
(6, 'exposure to high temperature'),
(7, 'neighbor constructions'),
(8, 'Visual surface inspection.'),
(9, 'Crack width'),
(10, 'Deflection'),
(11, 'Tilting of structure'),
(12, 'settlement of soi'),
(13, 'Scaling / Spalling'),
(14, 'Leakage'),
(15, 'Bar corrosion'),
(16, 'Corrosion exposure conditions'),
(17, 'finishing metrial state '),
(18, 'Widening diagonal cracks'),
(19, 'Beam Deflection'),
(20, 'deflection of Beam winches'),
(21, 'low resistance'),
(22, 'decrease in the cross-sectional area of steel reinforcement due to oxidation'),
(23, 'The widening of the longitudinal cracks'),
(24, 'Widening of the horizental cracks'),
(25, 'Decrease in concrete section due to corrosion'),
(26, 'Reduction in the section of the reinforcement due to oxidation'),
(27, 'Bulge in compressed rebar'),
(28, 'Protection layer for structural elements'),
(29, 'concrete covering layer'),
(30, 'Damage to rebar'),
(31, 'Eruption in the layers of concrete as a result of the fire'),
(32, 'Cracks in the concrete as a result of the fire'),
(33, 'Decrease in concrete resistance due to fire'),
(34, 'The color of the concrete changed as a result of the fire'),
(35, 'building tilt'),
(36, 'Soil subsidence'),
(37, 'Cracks in the contact area of the slab with the walls'),
(38, 'Cracks in the slabs towards the working length of the slab and shrinkage cracks'),
(39, 'Cracks in slab perpendicular to the working direction, many shrinkage cracks'),
(40, 'Cracks, curvature, traces of leakage or infiltration of water'),
(41, 'Crack development in the bearing area, curvature'),
(42, 'Cracks increase with time'),
(43, 'Cracks in the tensile and compressive area around the perimeter of the column, slack in the concrete covering layer, bending in the reinforcement steel, bending in the column'),
(44, 'Cracks over the entire height of the shaft in the tensile and compression area, erosion in the concrete covering layer over the entire height, corrosion in the reinforcement steel, deflection in the c');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `firstName` varchar(50) NOT NULL,
  `LastName` varchar(50) NOT NULL,
  `phone` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `firstName`, `LastName`, `phone`) VALUES
(1, 'mohammed', 'kamal', '0994915556'),
(2, 'saadia', 'sami', '099524441'),
(3, 'Hawa ', 'Mohammed', '24999941555556'),
(4, 'hh', 'hhh', '55778799'),
(5, 'sofyan ', 'kamal', '4545787'),
(6, 'mmmm', '4545', '554'),
(7, 'mustafa', 'mohammed ', '099996547'),
(8, 'musa', 'Ahmed ', '1254548');

-- --------------------------------------------------------

--
-- Table structure for table `walls`
--

CREATE TABLE `walls` (
  `name` varchar(50) NOT NULL,
  `volume` int(11) NOT NULL,
  `loss` int(11) NOT NULL,
  `id` int(11) NOT NULL,
  `buid_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `walls`
--

INSERT INTO `walls` (`name`, `volume`, `loss`, `id`, `buid_id`) VALUES
('W0', 0, 0, 364, 100032),
('W1', 0, 0, 365, 100032),
('W0', 0, 0, 366, 100034),
('W1', 0, 0, 367, 100034),
('W2', 0, 0, 368, 100034),
('W3', 0, 0, 369, 100034),
('W4', 0, 0, 370, 100034),
('W5', 0, 0, 371, 100034),
('W0', 0, 0, 372, 100035),
('W1', 0, 0, 373, 100035),
('W0', 0, 0, 656, 100033),
('W1', 0, 0, 657, 100033),
('W2', 0, 0, 658, 100033),
('W3', 0, 0, 659, 100033),
('W4', 0, 0, 660, 100033),
('W5', 0, 0, 661, 100033),
('W6', 0, 0, 662, 100033);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `beams`
--
ALTER TABLE `beams`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `buiding`
--
ALTER TABLE `buiding`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `buildingclassification`
--
ALTER TABLE `buildingclassification`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `columns_`
--
ALTER TABLE `columns_`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `linguistic_variable`
--
ALTER TABLE `linguistic_variable`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `slabs`
--
ALTER TABLE `slabs`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `statecoditinclassification`
--
ALTER TABLE `statecoditinclassification`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `walls`
--
ALTER TABLE `walls`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `beams`
--
ALTER TABLE `beams`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=587;

--
-- AUTO_INCREMENT for table `buiding`
--
ALTER TABLE `buiding`
  MODIFY `id` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=100058;

--
-- AUTO_INCREMENT for table `buildingclassification`
--
ALTER TABLE `buildingclassification`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1381;

--
-- AUTO_INCREMENT for table `columns_`
--
ALTER TABLE `columns_`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=689;

--
-- AUTO_INCREMENT for table `linguistic_variable`
--
ALTER TABLE `linguistic_variable`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=100016;

--
-- AUTO_INCREMENT for table `slabs`
--
ALTER TABLE `slabs`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=718;

--
-- AUTO_INCREMENT for table `statecoditinclassification`
--
ALTER TABLE `statecoditinclassification`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `walls`
--
ALTER TABLE `walls`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=663;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
