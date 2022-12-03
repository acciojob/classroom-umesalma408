package com.driver;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Repository
@Component
public class StudentRepository {
    HashMap<String, Student> studentInDB= new HashMap<>();
    HashMap<Teacher, List<String>> ListOfTeachersInDB= new HashMap<>();
    public void addStudent(Student student) {
        studentInDB.put(student.getName(), student);
    }

    public void addTeacher(Teacher teacher) {
        List<String>studentListOfTeachers = new LinkedList<String>();
        ListOfTeachersInDB.put(teacher, studentListOfTeachers);
    }

   public void addStudentTeacherPairToDB(String studentName, String teacherName) {
        for(Teacher teacher : ListOfTeachersInDB.keySet()){
            if(Objects.equals(teacher.getName(),teacherName)){
                List<String> temp;
                temp = ListOfTeachersInDB.get(teacher);
                temp.add(studentName);
                ListOfTeachersInDB.put(teacher,temp);
                break;
            }
        }
    }


    public Student getStudentTeacherPairFromDB(String name) {
        return studentInDB.get(name);
    }

    public Teacher getTeacherByNameFromDB(String name) {
        for(Teacher teacher : ListOfTeachersInDB.keySet()){
            if(Objects.equals(teacher.getName(),name)){
                return teacher;
            }
        }
        return null;
    }

    public List<String> getStudentsByTeacherNameFromDB(String name) {
        for(Teacher teacher : ListOfTeachersInDB.keySet()){
            if(Objects.equals(teacher.getName(),name)){
                return ListOfTeachersInDB.get(teacher);
            }
        }
        return null;

    }

    public List<String> findAllStudentsFromDB() {
        LinkedList<String> listOfStudents = new LinkedList<>();
        for(Student student: studentInDB.values()){
            listOfStudents.add(student.getName());
        }
        return listOfStudents;
    }

    public void deleteTeacherByNameFromDB(String teacherName) {
        for(Teacher teacher : ListOfTeachersInDB.keySet()){
            if(Objects.equals(teacher.getName(),teacherName)){
                List<String> temp;
                temp = ListOfTeachersInDB.get(teacher);
               for(String student :temp){
                   studentInDB.remove(student);
               }
                ListOfTeachersInDB.remove(teacher);
                break;
            }
        }
    }

    public void deleteAllTeachersFromDB() {
        for(List<String> temp:ListOfTeachersInDB.values()){
            for(String student:temp){
                studentInDB.remove(student);
            }
        }
        ListOfTeachersInDB.clear();
    }
}
