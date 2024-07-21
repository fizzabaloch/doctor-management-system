-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 25, 2024 at 08:40 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `doctors`
--

-- --------------------------------------------------------

--
-- Table structure for table `doctors`
--

CREATE TABLE `doctors` (
  `name` varchar(20) NOT NULL,
  `speciality` varchar(50) NOT NULL,
  `timing` varchar(50) NOT NULL,
  `fees` varchar(100) NOT NULL,
  `degree` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `edoctors`
--

CREATE TABLE `edoctors` (
  `DName` varchar(100) NOT NULL,
  `DType` varchar(100) NOT NULL,
  `DTiming` varchar(100) NOT NULL,
  `DFees` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `edoctors`
--

INSERT INTO `edoctors` (`DName`, `DType`, `DTiming`, `DFees`) VALUES
('Dr. Aisha Nadeem', 'Cardiologist', 'Timing: 12.00 to 4.00 PM', 'Fees: Rs. 2000'),
('Dr. Shamsher Ali', 'Gastroenterologist, Hepatologist', 'Timing: 7.00 to 10.00 PM', 'Fees: Rs. 1200'),
('Dr. Sana Abro', 'Ganeocologist, Obstrecian', 'Timing: 1.00 to 5.00 PM', 'Fees: Rs. 1000'),
('Dr. Rizwan Mushtaq', 'Psychiatrist', 'Timing: 8.00 to 12.00 PM', 'Fees: Rs. 1700'),
('Dr. Jameel Ahmed', 'Family Physician, General Physician', 'Timing: 12.00 to 5.00 PM', 'Fees: Rs. 500'),
('Dr. Sorath Qureshi', 'Eye Specialist, Eye Surgeon', 'Timing: 6.00 to 10.00 PM', 'Fees: Rs. 900'),
('Dr.Fizza', 'Nephrologist', 'MBBS', '12.30 TO 4.00 PM'),
('Dr.Maaz', 'Anesthesian', 'Bachelors', '7.00 to 9.00PM');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
