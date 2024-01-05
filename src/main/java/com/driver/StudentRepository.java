package com.driver;

import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.HashMap;

@Repository
public class StudentRepository {
    private HashMap<String, Student> studentDb = new HashMap<>();
    private HashMap<String, Teacher> teacherDb = new HashMap<>();
    private HashMap<String, List<String>> studentsOfATeacher = new HashMap<>();//it could also be a list of Student(obj)

    private List<String> studentsList = new ArrayList<>();
    public void addStudent(Student student){
        String dbKey = student.getName();
        studentDb.put(dbKey, student);
    }

    public void addTeacher(Teacher teacher){
        String dbKey = teacher.getName();
        teacherDb.put(dbKey, teacher);
    }
    public void addStudentTeacherPair(String studentName, String teacherName){
        List<String> temp = studentsOfATeacher.getOrDefault(teacherName, new ArrayList<>());
        if(!studentDb.containsKey(studentName) || !teacherDb.containsKey(teacherName)){
            return;
        }
        temp.add(studentName);
        studentsOfATeacher.put(teacherName, temp);
    }

    public Student getStudentByName(String studentName){
        if(studentDb.containsKey(studentName)){
            return studentDb.get(studentName);
        }
       return null;
    }
    public Teacher getTeacherByName(String teacherName){
        if(teacherDb.containsKey(teacherName)){
            return teacherDb.get(teacherName);
        }
        return null;
    }

    public List<String> getStudentsByTeacherName(String teacherName){
        return studentsOfATeacher.getOrDefault(teacherName, new ArrayList<>());
    }
    public List<String> getAllStudents(){
        for(String student : studentDb.keySet()){
            studentsList.add(studentDb.get(student).getName());
        }
        return  studentsList;
    }
    public void deleteTeacherByName(String teacher){
        if(!teacherDb.containsKey(teacher)){
            return;
        }
        teacherDb.remove(teacher);
        if(studentsOfATeacher.containsKey(teacher))
        {
            List<String> StudList=studentsOfATeacher.get(teacher);
            studentsOfATeacher.remove(teacher);
            for(String student :StudList)
            {
                studentsOfATeacher.remove(student);
            }
        }
//        studentsOfATeacher.remove(teacher);
    }
    public void deleteAllTeachers(){
        if(teacherDb.isEmpty()){
            return;
        }
        teacherDb.clear();
        studentsOfATeacher.clear();
        studentDb.clear();

//        HashSet<String> std_hash = new HashSet<>();
//        for(String teacher : studentsOfATeacher.keySet()) {
//            std_hash.addAll(studentsOfATeacher.get(teacher));
//        }
//        for(String student : std_hash) {
//            studentDb.remove(student);
//        }

    }
}
