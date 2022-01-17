delimiter // 

CREATE PROCEDURE getCusById

(IN cusNum INT(11))

BEGIN 

SELECT * FROM customers WHERE customerNumber = cusNum;

END // 

delimiter ;

CALL getCusById (175);

delimiter //

CREATE PROCEDURE GetCustomersCountByCity (

IN in_city VARCHAR (50),

OUT total INT

)

BEGIN 

SELECT COUNT(customerNumber)

INTO total 

FROM customers

WHERE city = in_city;

END //

delimiter ;

call GetCustomersCountByCity('Lyon', @total);
select @total;

delimiter // 

create procedure SetCounter(

inout counter int,

in inc INT
)

begin 

set counter = counter + inc;

end // 

delimiter ;

set @counter = 1;

call SetCounter(@counter,1);
call SetCounter(@counter,1);
call SetCounter(@counter,5);
select @counter;