//package com.driver;
//
//import org.springframework.stereotype.Repository;
//
//import java.util.*;
//import java.util.HashMap;
//
//@Repository
//public class StudentRepository {
//    private HashMap<String, Student> studentDb = new HashMap<>();
//    private HashMap<String, Teacher> teacherDb = new HashMap<>();
//    private HashMap<String, List<String>> studentsOfATeacher = new HashMap<>();//it could also be a list of Student(obj)
//
//    private List<String> studentsList = new ArrayList<>();
//    public void addStudent(Student student){
//        String dbKey = student.getName();
//        studentDb.put(dbKey, student);
//    }
//
//    public void addTeacher(Teacher teacher){
//        String dbKey = teacher.getName();
//        teacherDb.put(dbKey, teacher);
//    }
//    public void addStudentTeacherPair(String studentName, String teacherName){
//        List<String> temp = studentsOfATeacher.getOrDefault(teacherName, new ArrayList<>());
//        if(!studentDb.containsKey(studentName) || !teacherDb.containsKey(teacherName)){
//            return;
//        }
//        temp.add(studentName);
//        studentsOfATeacher.put(teacherName, temp);
//    }
//
//    public Student getStudentByName(String studentName){
//        if(studentDb.containsKey(studentName)){
//            return studentDb.get(studentName);
//        }
//       return null;
//    }
//    public Teacher getTeacherByName(String teacherName){
//        if(teacherDb.containsKey(teacherName)){
//            return teacherDb.get(teacherName);
//        }
//        return null;
//    }
//
//    public List<String> getStudentsByTeacherName(String teacherName){
//        return studentsOfATeacher.getOrDefault(teacherName, new ArrayList<>());
//    }
//    public List<String> getAllStudents(){
//        studentsList = new ArrayList<>();
//        for(String student : studentDb.keySet()){
//            studentsList.add(studentDb.get(student).getName());
//        }
//        return  studentsList;
//    }
//    public void deleteTeacherByName(String teacher){
//        if(!teacherDb.containsKey(teacher)){
//            return;
//        }
//        teacherDb.remove(teacher);//teacher dead
//        if(studentsOfATeacher.containsKey(teacher))
//        {
//            List<String> StudList=studentsOfATeacher.get(teacher);
//            studentsOfATeacher.remove(teacher);//no more a student of that teacher
//            for(String student :StudList)
//            {
//                studentDb.remove(student);//no more even a student, cuz that teacher is dead
//            }
//        }
////        studentsOfATeacher.remove(teacher);
//    }
//    public void deleteAllTeachers(){
//        if(teacherDb.isEmpty()){
//            return;
//        }
//        teacherDb.clear();
//        studentsOfATeacher.clear();
//        studentDb.clear();
//
//        HashSet<String> std_hash = new HashSet<>();
//        for(String teacher : studentsOfATeacher.keySet()) {
//            std_hash.addAll(studentsOfATeacher.get(teacher));
//        }
//        for(String student : std_hash) {
//            studentDb.remove(student);
//        }
//
//    }
//}









package com.driver;
import org.springframework.stereotype.Repository;

import java.util.*;
@Repository
public class StudentRepository {
    private HashMap<String,Student>Smap=new HashMap<>();
    private HashMap<String,Teacher>Tmap=new HashMap<>();
    private HashMap<String,List<String>>STmap=new HashMap<>();

    //private List<String>StudentList=new ArrayList<>();

    /* POST METHOD */
    public void addStudent(Student s)
    {
        Smap.put(s.getName(),s);
        //StudentList.add(s.getName());
    }

    public void addTeacher(Teacher t)
    {
        Tmap.put(t.getName(),t);
        //return "addTeacher";
    }
    /*PUT METHOD*/
    public void addStudentTeacherPair(String Sname,String Tname)
    {
        if(Smap.containsKey(Sname) && Tmap.containsKey(Tname))
        {
            List<String>pairL=STmap.getOrDefault(Tname,new ArrayList<>());
            pairL.add(Sname);
            STmap.put(Tname,pairL);
        }
    }

    /* Get Method */
    public Student getStudentByName(String name)
    {
        return Smap.get(name);
    }
    public Teacher getTeacherByName(String name)
    {
        return Tmap.get(name);
    }
    public  List<String> getStudentByTeacherName(String Tname)
    {
        return new ArrayList<>(STmap.get(Tname));
    }
    public List<String> getAllStudent()
    {
        List<String>SL=new ArrayList<>();
        for(String s:Smap.keySet())
        {
            SL.add(s);
        }
        return SL;
    }

    /* Delete Method */
    public void deleteTeacherName(String Tname)
    {
        Tmap.remove(Tname);
        if(STmap.containsKey(Tname))
        {
            List<String>SL=STmap.get(Tname);
            STmap.remove(Tname);
            for(String s:SL)
            {
                Smap.remove(s);
            }
        }
    }

    public void deleteAllTeacher()
    {
        HashSet<String> std_hash = new HashSet<>();

        for(String teacher : STmap.keySet()) {

            std_hash.addAll(STmap.get(teacher));
        }
        for(String student : std_hash) {
            Smap.remove(student);
        }
    }

}