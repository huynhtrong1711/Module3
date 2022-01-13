USE quan_ly_sinh_vien;

SELECT student.* FROM student WHERE student.student_name LIKE "h%";

SELECT class.* FROM class WHERE class.start_date LIKE"____-12%";

SELECT `subject`.* FROM `subject` WHERE `subject`.Credit BETWEEN 3 AND 5;

SET SQL_SAFE_UPDATES = 0;
UPDATE student SET class_id = 2 WHERE student.student_name = "hung";
SET SQL_SAFE_UPDATES = 1;

SELECT student.student_name, `subject`.SubName, mark.mark FROM student JOIN mark ON student.student_id = mark.student_id
JOIN `subject` ON mark.SubId = `subject`.SubId ORDER BY mark.mark DESC, mark.mark_id;