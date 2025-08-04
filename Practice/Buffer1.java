package Practice;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.*;


    public class Buffer1 {
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    ArrayList<EmployeeData> emp = new ArrayList<>();

    System.out.println("count ");
    int count = scn.nextInt();
    scn.nextLine(); // <<< Fix: Consume the leftover newline

    for (int i = 0; i < count; i++) {
      System.out.println("Enter data for employee " + (i + 1));

      System.out.print("ID: ");
      String id = scn.nextLine();

      System.out.print("Name: ");
      String name = scn.nextLine();

      System.out.print("Department: ");
      String dept = scn.nextLine();

      System.out.print("Role: ");
      String role = scn.nextLine();

      System.out.print("Salary: ");
      String salary = scn.nextLine();

      emp.add(new EmployeeData(id, name, dept, role, salary));
    }

    emp.forEach(obj -> System.out.println(obj.getAll()));

    try (BufferedWriter obj = new BufferedWriter(new FileWriter("d.txt", true))) {
      for (EmployeeData e : emp) {
        obj.write(e.getAll());
        obj.newLine();
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

    getedit(emp);
  }



  public static void getedit(ArrayList<EmployeeData> edit) {
    Scanner scn = new Scanner(System.in);
    System.out.print("Enter ID to edit: ");
    String search = scn.nextLine();
    boolean found = false;

    for (EmployeeData emp1 : edit) {
      if (emp1.getId().equals(search)) {
        found = true;
        System.out.println("Editing name for ID " + search + ":");
        emp1.SetName(scn.nextLine());
        System.out.println("enter new department ");
        emp1.Setdept(scn.nextLine());

        System.out.println(" Employee updated: " + emp1.getAll());
        break; // Optional: stop after first match
      }
    }

    if (!found) {
      System.out.println(" ID not found.");
    }
  }




   


}




















class EmployeeData{
  String id ;
  String name;
  String dept;
  String role;
  String salary;


 public EmployeeData(String id,String name, String dept, String role, String salary )
 {
  this.id = id;
  this.name = name;
  this.dept = dept;
  this.role = role;
  this.salary = salary;
 }


   public String getAll()
 {
    return id + " "+ name +" "+ dept +" " + role +" "+ salary;
 }

 public String  getName()
 {
  return name;
 }

 public String getdept()
 {
  return dept;
 }

 public String getId()
 {
  return id;
 }





    public void SetName(String name)
    {
      this.name = name;
    }

    public void Setdept(String dept)
    {
      this.dept = dept;
    }

    public void SetId(String id)
    {
      this.id = id;
    }

    public void Setrole(String role)
    {
      this.role = role;
    }

    public void Setsalary(String salary)
    {
      this.salary = salary;
    }










}
