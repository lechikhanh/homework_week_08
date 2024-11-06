package week8;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
public class StudentManagement {
	 private static ArrayList<Student> students = new ArrayList<>();
	    private static Scanner scanner = new Scanner(System.in);
	    public static void main(String[] args) {
	        while (true) {
	            System.out.println("WELCOME TO STUDENT MANAGEMENT");
	            System.out.println("1. Create");
	            System.out.println("2. Find and Sort");
	            System.out.println("3. Update/Delete");
	            System.out.println("4. Report");
	            System.out.println("5. Exit");
	            System.out.print("Choose an option: ");
	            int choice = scanner.nextInt();
	            scanner.nextLine(); // Clear buffer

	            switch (choice) {
	                case 1 -> createStudent();
	                case 2 -> findAndSortStudents();
	                case 3 -> updateOrDeleteStudent();
	                case 4 -> generateReport();
	                case 5 -> {
	                    System.out.println("Exiting...");
	                    return;
	                }
	                default -> System.out.println("Invalid choice! Please choose again.");
	            }
	        }
	    }

	    private static void createStudent() {
	        System.out.print("Enter Student ID: ");
	        String id = scanner.nextLine();
	        System.out.print("Enter Student Name: ");
	        String name = scanner.nextLine();
	        System.out.print("Enter Semester: ");
	        String semester = scanner.nextLine();
	        System.out.print("Enter Course (Java, .Net, C/C++): ");
	        String course = scanner.nextLine();

	        if (!course.equals("Java") && !course.equals(".Net") && !course.equals("C/C++")) {
	            System.out.println("Invalid course. Please enter Java, .Net, or C/C++.");
	            return;
	        }

	        Student student = new Student(id, name, semester, course);
	        students.add(student);
	        System.out.println("Student added successfully.");
	    }

	    private static void findAndSortStudents() {
	        System.out.print("Enter Student Name to find: ");
	        String name = scanner.nextLine();
	        ArrayList<Student> foundStudents = new ArrayList<>();

	        for (Student student : students) {
	            if (student.getName().equalsIgnoreCase(name)) {
	                foundStudents.add(student);
	            }
	        }

	        if (foundStudents.isEmpty()) {
	            System.out.println("No students found with the name: " + name);
	            return;
	        }

	        foundStudents.sort(Comparator.comparing(Student::getName));
	        System.out.println("Found Students (Sorted by Name):");
	        for (Student student : foundStudents) {
	            System.out.println(student);
	        }
	    }

	    private static void updateOrDeleteStudent() {
	        System.out.print("Enter Student ID to update/delete: ");
	        String id = scanner.nextLine();
	        Student student = null;

	        for (Student s : students) {
	            if (s.getId().equals(id)) {
	                student = s;
	                break;
	            }
	        }

	        if (student == null) {
	            System.out.println("Student with ID " + id + " not found.");
	            return;
	        }

	        System.out.println("1. Update");
	        System.out.println("2. Delete");
	        System.out.print("Choose an option: ");
	        int choice = scanner.nextInt();
	        scanner.nextLine(); // Clear buffer

	        if (choice == 1) {
	            System.out.print("Enter new name: ");
	            student.setName(scanner.nextLine());
	            System.out.print("Enter new semester: ");
	            student.setSemester(scanner.nextLine());
	            System.out.print("Enter new course (Java, .Net, C/C++): ");
	            String course = scanner.nextLine();

	            if (course.equals("Java") || course.equals(".Net") || course.equals("C/C++")) {
	                student.setCourse(course);
	                System.out.println("Student updated successfully.");
	            } else {
	                System.out.println("Invalid course. Update failed.");
	            }
	        } else if (choice == 2) {
	            students.remove(student);
	            System.out.println("Student deleted successfully.");
	        } else {
	            System.out.println("Invalid choice.");
	        }
	    }

	    private static void generateReport() {
	        if (students.isEmpty()) {
	            System.out.println("No students in the list.");
	            return;
	        }

	        System.out.println("Student Report:");
	        for (Student student : students) {
	            System.out.println(student);
	        }
	    }
	}

