package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component

public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    public void addStudent(Student student){
        studentRepository.addStudent(student);
    }
    public void addTeacher(Teacher teacher){
        studentRepository.addTeacher(teacher);
    }

    public void addAllStudentTeacherPairToDB(String student, String teacher) {
        studentRepository.addStudentTeacherPairToDB(student, teacher);
    }

    public Student getStudentByName(String name) {
        return studentRepository.getStudentTeacherPairFromDB(name);
    }


    public Teacher getAllTeachersByName(String name) {
        return studentRepository.getTeacherByNameFromDB(name);
    }

    public List<String> getAllStudentsByTeacherName(String teacher) {

        return studentRepository.getStudentsByTeacherNameFromDB(teacher);
    }

    public List<String> findAllStudents() {
        return studentRepository.findAllStudentsFromDB();
    }

    public void deleteAllTeachersByName(String teacher) {
        studentRepository.deleteTeacherByNameFromDB(teacher);
    }

    public void deleteAllTeachers() {
        studentRepository.deleteAllTeachersFromDB();
    }
}
