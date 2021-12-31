DROP TABLE IF EXISTS name;
  
CREATE TABLE name (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first VARCHAR(250) NOT NULL,
  middle VARCHAR(1) NULL,
  last VARCHAR(250) NOT NULL
   
);
  
INSERT INTO name (id, first, middle, last) VALUES
  (1, 'James', 'J', 'mill');
  
INSERT INTO name (id, first, last) VALUES
  (2, 'Mike', 'Siscoe');
  
INSERT INTO name (id, first, middle, last) VALUES
  (3, 'Judy', 'P', 'Jones');
