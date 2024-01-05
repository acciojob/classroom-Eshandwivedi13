package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repoObj;

    public void addStudent(Student student){
        repoObj.addStudent(student);
    }
    public void addTeacher(Teacher teacher){
        repoObj.addTeacher(teacher);
    }
    public void addStudentTeacherPair(String studentName, String teacherName){
        repoObj.addStudentTeacherPair(studentName, teacherName);
    }

    public Student getStudentByName(String studentName){
      return  repoObj.getStudentByName(studentName);
    }
    public Teacher getTeacherByName(String teacherName){
        return  repoObj.getTeacherByName(teacherName);
    }
    public List<String> getStudentsByTeacherName(String teacherName){
        return  repoObj.getStudentsByTeacherName(teacherName);
    }
    public List<String> getAllStudents(){
        return  repoObj.getAllStudents();
    }

    public void deleteTeacherByName(String teacher){
        repoObj.deleteTeacherByName(teacher);
    }
    public void deleteAllTeachers(){
        repoObj.deleteAllTeachers();
    }

}
