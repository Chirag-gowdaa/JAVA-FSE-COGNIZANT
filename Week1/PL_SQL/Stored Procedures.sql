-- Scenario 1: The bank needs to process monthly interest for all savings accounts.
-- Question: Write a stored procedure ProcessMonthlyInterest that calculates and updates the balance of all savings accounts by applying an interest rate of 1% to the current balance.
DELIMITER $$

CREATE PROCEDURE ProcessMonthlyInterest()
BEGIN
    UPDATE accounts
    SET balance = balance + (balance * 0.01)
    WHERE account_type = 'SAVINGS';

    COMMIT;
END$$

DELIMITER ;


-- Scenario 2: The bank wants to implement a bonus scheme for employees based on their performance.
-- Question: Write a stored procedure UpdateEmployeeBonus that updates the salary of employees in a given department by adding a bonus percentage passed as a parameter.

DELIMITER //

CREATE PROCEDURE UpdateEmployeeBonus(
    IN p_department VARCHAR(50),
    IN p_bonus DECIMAL(5,2)
)
BEGIN
    UPDATE employees
    SET salary = salary + (salary * p_bonus / 100)
    WHERE department = p_department;
END //

DELIMITER ;

-- Scenario 3: Customers should be able to transfer funds between their accounts.
-- Question: Write a stored procedure TransferFunds that transfers a specified amount from one account to another, checking that the source account has sufficient balance before making the transfer.

DELIMITER //

CREATE PROCEDURE TransferFunds(
    IN from_acc INT,
    IN to_acc INT,
    IN amount DECIMAL(10,2)
)
BEGIN
    UPDATE accounts
    SET balance = balance - amount
    WHERE account_id = from_acc;

    UPDATE accounts
    SET balance = balance + amount
    WHERE account_id = to_acc;
END //

DELIMITER ;
