import java.io.*;
import java.util.*;

class Student {
  private int marks;

  public int getMarks() {
    return this.marks;
  }

  public void setMarks(int marks) {
    this.marks = marks;
  }
}

class Classroom {
  private final ArrayList<Student> students;
  private ArrayList<Student> gradedStudents;

    Classroom() {
        students = new ArrayList<Student>();
    }

  public void addStudent(Student student) {
      students.add(student);
  }

  public ArrayList<Student> getGradedStudents(int marks) {
    gradedStudents = new ArrayList<Student>();
    for (int i = 0; i < students.size(); i++) {
      if (students.get(i).getMarks() >= marks) {
        gradedStudents.add(students.get(i));
      }
    }
    return gradedStudents;
  }
}