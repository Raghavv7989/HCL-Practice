class Employee {
    int empId;
    String empName;
    String gmail;
    double salary;
    String dept;

    Employee(int id, String name, String email, double sal, String department) {
        empId = id;
        empName = name;
        gmail = email;
        salary = sal;
        dept = department;
    }

    void displayDetails() {
        System.out.println("Employee ID: " + empId);
        System.out.println("Employee Name: " + empName);
        System.out.println("Gmail: " + gmail);
        System.out.println("Salary: " + salary);
        System.out.println("Department: " + dept);
        System.out.println("-------------------------");
    }
}

public class EmployeeDetails {
    public static void main(String[] args) {
        Employee e1 = new Employee(
            101, "Raghav", "raghav@gmail.com", 45000, "AI & ML"
        );

        Employee e2 = new Employee(
            102, "Rahul", "rahul@gmail.com", 50000, "Development"
        );

        e1.displayDetails();
        e2.displayDetails();
    }
}
