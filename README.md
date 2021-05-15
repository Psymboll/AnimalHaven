# AnimalHaven
Just a basic website developed through Spring MVC

here is the schema of the different tables on the db


CREATE TABLE `animal` (
  `id` int NOT NULL AUTO_INCREMENT,
  `animalname` varchar(20) DEFAULT NULL,
  `animalage` int DEFAULT NULL,
  `animaltype` varchar(100) DEFAULT NULL,
  `ownerid` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_idx` (`ownerid`),
  CONSTRAINT `id` FOREIGN KEY (`ownerid`) REFERENCES `owner` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `animaltypes` (
  `animaltype` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `owner` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `email` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

