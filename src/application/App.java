package application;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import dao.StudentUtil;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Menu:");
                System.out.println("1. Create Student Table");
                System.out.println("2. Insert data in Student");
                System.out.println("3. Update Student");
                System.out.println("4. Delete Student");
                System.out.println("5. Search Student by ID");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        boolean tableCreated = StudentUtil.createStudentTable();
                        System.out.println("Student table created: " + tableCreated);
                        break;
                    case 2:
                        System.out.print("Enter student ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter student name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter student course: ");
                        String course = scanner.nextLine();
                        System.out.print("Enter student age: ");
                        byte age = scanner.nextByte();
                        boolean studentInserted = StudentUtil.insertStudent(id, name, course, age);
                        System.out.println("Student updated: " + studentInserted);
                        break;
                    case 3:
                        System.out.print("Enter student ID: ");
                        int Uid = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter student name: ");
                        String Uname = scanner.nextLine();
                        System.out.print("Enter student course: ");
                        String Ucourse = scanner.nextLine();
                        System.out.print("Enter student age: ");
                        byte Uage = scanner.nextByte();
                        boolean studentUpdated = StudentUtil.updateStudent(Uid, Uname, Ucourse, Uage);
                        System.out.println("Student updated: " + studentUpdated);
                        break;
                    case 4:
                        System.out.print("Enter student ID: ");
                        int deleteId = scanner.nextInt();
                        boolean studentDeleted = StudentUtil.deleteStudent(deleteId);
                        System.out.println("Student deleted: " + studentDeleted);
                        break;
                    case 5:
                        System.out.print("Enter student ID: ");
                        int searchId = scanner.nextInt();
                        ResultSet rs = StudentUtil.searchStudentById(searchId);
                        if (rs.next()) {
                            System.out.println("Student ID: " + rs.getInt("stu_id"));
                            System.out.println("Student Name: " + rs.getString("Stud_Name"));
                            System.out.println("Student Course: " + rs.getString("Stud_course"));
                            System.out.println("Student Age: " + rs.getByte("Stu_age"));
                        } else {
                            System.out.println("Student not found.");
                        }
                        break;
                    case 6:
                        scanner.close();
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (SQLException e) {
                System.out.println("SQL Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
