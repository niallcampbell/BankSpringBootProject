-- The data.sql file is used to add data to the H2 DB on startup.
-- Spring Boot creates the tables in the H2 DB for us based on our @Entity classes.

-- Insert data into the Customer table.
INSERT INTO Customer(CUSTOMER_ID, CUSTOMER_NAME, CUSTOMER_AGE)
VALUES (1, 'John Smith', 48);

INSERT INTO Customer(CUSTOMER_ID, CUSTOMER_NAME, CUSTOMER_AGE)
VALUES (2, 'Jack Jones', 23);

INSERT INTO Customer(CUSTOMER_ID, CUSTOMER_NAME, CUSTOMER_AGE)
VALUES (3, 'Steve Byrne', 62);

-- Insert data into the Bank_Account table.
-- Note, Bank_Account has a FK dependency on the CUSTOMER_ID field in the Customer table.
-- As such, the Customer data needs to be inserted first.
INSERT INTO Bank_Account(ACCOUNT_ID, ACCOUNT_TYPE, CUSTOMER_ID)
VALUES (123, 'Current', 1);

INSERT INTO Bank_Account(ACCOUNT_ID, ACCOUNT_TYPE, CUSTOMER_ID)
VALUES (456, 'Current', 2);

INSERT INTO Bank_Account(ACCOUNT_ID, ACCOUNT_TYPE, CUSTOMER_ID)
VALUES (789, 'Current', 3);