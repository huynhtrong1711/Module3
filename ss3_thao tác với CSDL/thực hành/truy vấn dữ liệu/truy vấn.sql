USE quan_ly_sinh_vien;

SELECT * FROM student;

SELECT * FROM student WHERE `status` = true;

SELECT * FROM `subject` WHERE credit < 10;

SELECT S.student_id, S.student_name, C.class_name FROM student S join class C on S.class_id = C.class_id;

SELECT S.student_id, S.student_name, C.class_name FROM student S join class C on S.class_id = C.class_id
WHERE C.class_name = 'A1';

SELECT S.student_id, S.student_name, Sub.SubName, M.mark
FROM student S join mark M on S.student_id = M.student_id join `subject` Sub on M.SubId = Sub.SubId;

SELECT S.student_id, S.student_name, Sub.SubName, M.mark
FROM student S join mark M on S.student_id = M.student_id join `subject` Sub on M.SubId = Sub.SubId
WHERE Sub.SubName = 'CF';