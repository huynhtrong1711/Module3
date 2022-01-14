USE quan_ly_sinh_vien;

SELECT `subject`.SubId, `subject`.SubName FROM `subject`;

SELECT `subject`.*, MAX(mark) FROM `subject` JOIN mark ON `subject`.SubId = mark.SubId;

SELECT student.*, AVG(mark) FROM student JOIN mark on student.student_id = mark.student_id GROUP BY student_id
ORDER BY AVG(mark) DESC;