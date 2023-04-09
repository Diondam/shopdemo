ALTER TABLE Product
ADD sellName VARCHAR(20) NOT NULL DEFAULT 'N/A';


UPDATE Product
SET sellName = 'anh'
WHERE sellid = 3;