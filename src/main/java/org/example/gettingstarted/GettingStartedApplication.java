package org.example.gettingstarted;

import org.example.gettingstarted.student.Student;
import org.example.gettingstarted.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class GettingStartedApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(GettingStartedApplication.class, args);
    }

    private final StudentService studentService;
    @Autowired
    public GettingStartedApplication(StudentService studentService) {
        this.studentService = studentService;
    }


    @Override
    public void run(String... args) throws Exception {
        Scanner sc = new Scanner(System.in);
        do{
            switch (menu()){
                case 1 -> {
                    headerDisplay();
                    for (Student student : studentService.selectAll()) {
                        studentDisplay(student);
                    }
                }case 2 -> {
                    Student student = studentInput(sc, "Enter student");
                    studentService.insert(student);
                }
                case 3 -> {
                    System.out.print("Enter student id: ");
                    Integer id = Integer.parseInt(sc.nextLine());
                    Student student = studentService.selectById(id);
                    if (student != null) {
                        headerDisplay();
                        studentDisplay(student);

                    }else{
                        System.err.println("Cannot find student with id " + id);
                    }
                }
                case 4 -> {
                    System.out.print("Enter student id: ");
                    Integer id = Integer.parseInt(sc.nextLine());
                    Student student = studentInput(sc, "Enter new student");
                    if(studentService.updateById(id, student)){
                        System.out.println("Student updated");
                    }else {
                        System.err.println("Cannot find student with id " + id);
                    }
                }
                case 5 -> {
                    System.out.print("Enter student id: ");
                    Integer id = Integer.parseInt(sc.nextLine());
                    if(studentService.deleteById(id)){
                        System.out.println("Student deleted");
                    }else{
                        System.err.println("Cannot find student with id " + id);
                    }
                }
                case 6 -> {
                    System.exit(0);
                }
            }
            System.out.print("Any key to continue...");
            sc.nextLine();
        }while (true);
    }

    private Student studentInput(Scanner sc, String message) {
        System.out.print(message + " id: ");
        Integer id = Integer.parseInt(sc.nextLine());
        System.out.print(message + " name: ");
        String fullName = sc.nextLine();
        System.out.print(message + " gender: ");
        String gender = sc.nextLine();
        System.out.print(message + " score: ");
        Double score = Double.parseDouble(sc.nextLine());
        return new Student(id, fullName, gender, score);
    }

    public void headerDisplay(){
        System.out.printf("%-5s %-20s %-10s %-10s\n",
                "ID",
                "FULL NAME",
                "GENDER",
                "SCORE");
    }

    public void studentDisplay(Student student) {
        System.out.printf("%-5s %-20s %-10s %-10.2f\n",
                student.getId(),
                student.getFullName(),
                student.getGender(),
                student.getScore());
    }


    public Integer menu(){
        System.out.println("Welcome to Spring Boot Application");
        System.out.println("""
                1. Show all students
                2. Insert a new student
                3. Search student by id
                4. Update student by id
                5. Delete student by id
                6. Exit the program""");
        System.out.print("[+] Choose an option: ");
        int choice;
        do{
            try{
                choice = Integer.parseInt(new Scanner(System.in).nextLine());
            }catch (Exception ignored){
                choice = 0;
            }
        }while (choice < 1 || choice > 6);
        return choice;
    }
}
