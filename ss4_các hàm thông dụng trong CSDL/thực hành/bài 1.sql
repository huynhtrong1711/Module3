USE quan_ly_sinh_vien;

SELECT address, COUNT(student_id) AS 'Số Lượng Học Viên' FROM student GROUP BY address;

SELECT student.student_id, student_name, AVG(mark) FROM student JOIN mark on student.student_id = mark.student_id
GROUP BY student.student_id, student.student_name;

SELECT student.student_id, student_name, AVG(mark) FROM student JOIN mark on student.student_id = mark.student_id
GROUP BY student.student_id, student.student_name HAVING AVG(mark) > 15;

SELECT student.student_id, student_name, AVG(mark) FROM student JOIN mark on student.student_id = mark.student_id
GROUP BY student.student_id, student.student_name
HAVING AVG(mark) >= ALL (SELECT AVG(mark) FROM mark GROUP BY mark.student_id);