import java.io.*;
import java.util.*;

public class EMS {


          public static void main(String[] args) throws InterruptedException{
         Scanner sc = new Scanner(System.in);
  
       
             ArrayList<EmployeeName> emp = new ArrayList<>(); 


             emp.add(new EmployeeName("101", "Om", "R&D", "Developer", "30000"));
             emp.add(new EmployeeName("102", "Anjali", "HR", "Manager", "45000"));
             emp.add(new EmployeeName("103", "Rahul", "IT", "Tester", "28000"));
             emp.add(new EmployeeName("104", "Sneha", "Finance", "Analyst", "35000"));
             emp.add(new EmployeeName("105", "Aman", "Support", "Tech Lead", "40000"));

           
     
              


          Thread.sleep(500);

          for (int i = 0; i < 4; i++) {
            System.out.println();
         }

          String[] banner = {
            "$$\\      $$\\ $$$$$$\\ $$\\   $$\\  $$$$$$\\  $$$$$$$\\  ",
            "$$$\\    $$$ |\\_$$  _|$$$\\  $$ |$$  __$$\\ $$  __$$\\ ",
            "$$$$\\  $$$$ |  $$ |  $$$$\\ $$ |$$ /  $$ |$$ |  $$ |",
            "$$\\$$\\$$ $$ |  $$ |  $$ $$\\$$ |$$ |  $$ |$$$$$$$  |",
            "$$ \\$$$  $$ |  $$ |  $$ \\$$$$ |$$ |  $$ |$$  ____/ ",
            "$$ |\\$  /$$ |  $$ |  $$ |\\$$$ |$$ |  $$ |$$ |      ",
            "$$ | \\_/ $$ |$$$$$$\\ $$ | \\$$ | $$$$$$  |$$ |      ",
            "\\__|     \\__|\\______|\\__|  \\__| \\______/ \\__|      "
          };

          int terminalWidth = 170;
          for (String line : banner) {
            Thread.sleep(100);
            int padding = (terminalWidth - line.length()) / 2;
            if (padding < 0)
                padding = 0;
            System.out.printf("%" + (padding + line.length()) + "s%n", line);
          }

          System.out.println("*****************************************************************************************************************************************************************************");
        
           System.out.println("MENU ");
           System.out.println();

           
           String[] add ={
          
"╔════════════════════════════════════════════════════╗",
"║               EMPLOYEE CONTROL PANEL               ║",
"╠════════════════════════════════════════════════════╣",
"║     1. Register New Employee   (Add )              ║",
"║     2. Display All Employee Records (View)         ║",
"║     3. Update Existing Employee Details (edit)     ║",
"║     4. Remove Employee from System  (delete)       ║",
"║     5. Exit Program                                ║",
"╚════════════════════════════════════════════════════╝",
           
           };   



   int terminalWidth1 = 170;
          for (String line : add) {
            Thread.sleep(150);
            int padding = (terminalWidth1 - line.length()) / 2;
            if (padding < 0)
                padding = 0;
            System.out.printf("%" + (padding + line.length()) + "s%n", line);
          }


           /* 
          String[] add = {
            "OPTION ", "1 ", ": ", "ADD EMPLOYEE", "                  ",
            "OPTION ", "2 ", ": ", "VIEW EMPLOYEE List", "                  ",
            "OPTION ", "3 ", ": ", "EDIT EMPLOYEE", "                  ",
            "OPTION ", "4 ", ": ", "DELETE EMPLOYEE"
          };
*/


          // for (String s1 : add) {
            // Thread.sleep(400);
            //System.out.println(s1);
          //}


           for (int i = 0; i < 2; i++) {
            System.out.println();
           }

           char[] ch = { 'L', 'o', 'a', 'd', 'i', 'n', 'g', '.', '.', '.', '.', '.' };
          for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '.') {
                Thread.sleep(400);
            } else {
                Thread.sleep(100);
            }
            System.out.print(ch[i]);
           }

           for (int i = 0; i < 3; i++) {
            System.out.println();
          }

          while (true) {
            /* 
            System.out.println("\n--- MENU ---");
            Thread.sleep(100);
            System.out.println("1. Add");
            Thread.sleep(50);
            System.out.println("2. View");
            Thread.sleep(50);
            System.out.println("3. Delete");
            Thread.sleep(50);
            System.out.println("4. Exit");
            */
            System.out.print("Enter choice (number or command): ");
            String choice = sc.nextLine().trim().toLowerCase();
               // move this outside switch if needed globally

         switch (choice) {
          case "1":
          case "add": {
            Scanner scn = new Scanner(System.in);
             System.out.print("How many employees do you want to add? ");
          int count = scn.nextInt();
          scn.nextLine(); // consume newline

           for (int i = 0; i < count; i++) {
            System.out.println("\nEnter details for employee " + (i + 1) + ":");

            System.out.print("ID: ");
            String id = scn.nextLine();
            //scn.nextLine();

            System.out.print("Name: ");
            String name = scn.nextLine();

            System.out.print("Department: ");
            String department = scn.nextLine();

            System.out.print("Role: ");
            String role = scn.nextLine();

            System.out.print("Salary: ");
            String salary = scn.nextLine();
            //scn.nextLine();

            emp.add(new EmployeeName(id, name, department, role, salary));
         
           // 🔽 Write all employee records to file after collecting
          try (BufferedWriter writer = new BufferedWriter(new FileWriter("d.txt", true))) {

           
            for (EmployeeName employee : emp) {
             
                writer.write(employee.getId() + "," +
                             employee.getName() + "," +
                             employee.getDepartment() + "," +
                             employee.getRole() + "," +
                             employee.getSalary());
                writer.newLine();
            }
            System.out.println("Employee details saved to file.");
            System.out.println();
            
          } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
           }

      
           
          }
              break;
         }
           
               
               
               case "2":
                case "view":
                   if(emp.isEmpty())
                   {
                    System.out.println("NO DATA FOUND ");
                    break;
                   }
                   else{
                   System.out.println("\n====== Employees List  ======");
                   System.out.println("id  |Name  |Depart  |role  |salary  ");
                   emp.forEach(System.out::println);
                    break;
                   }

                case "3":
                case "edit":
                   getedit(emp);
                   break;


                case "4":
                case "delete":
               //   obj.exit();
                    getDelete(emp);
                  // return;
                  break;


                case "5":
                case "exit":
                         System.out.println("Thanks for visiting ......");
                   return;

                default:
                    System.out.println("Invalid input.");


            }

        }
    

    }
    
     
public static void getedit(ArrayList<EmployeeName >edit) {
    Scanner scn = new Scanner(System.in);
    System.out.print("Enter ID to edit: ");
    String search = scn.nextLine();
    boolean found = false;
 
    for (EmployeeName emp1 : edit) {
      if (emp1.getId().equals(search)) {
        found = true;
        

        System.out.println("edit name ? : yes / no");
       String  goinse = scn.nextLine();
        if(goinse.equals("yes")){
        System.out.println("Editing name for ID " + search + ":");
        emp1.SetName(scn.nextLine());
        }


        
        System.out.println("edit Department ? : yes / no");
       String  goDept = scn.nextLine();
        if(goDept.equals("yes")){
        System.out.println("Editing name for ID " + search + ":");
        emp1.Setdept(scn.nextLine());
        }





         
        System.out.println("edit Role ? : yes / no");
       String  gorole = scn.nextLine();
        if(gorole.equals("yes")){
        System.out.println("Editing name for ID " + search + ":");
        emp1.Setrole(scn.nextLine());
        }




        
         
        System.out.println("edit Salary ? : yes / no");
       String  gosalary = scn.nextLine();
        if(gosalary.equals("yes")){
        System.out.println("Editing name for ID " + search + ":");
        emp1.Setrole(scn.nextLine());
        }



        
        break; // Optional: stop after first match
      }
    }

    if (!found) {
      System.out.println("❌ ID not found.");
    }
  }


 public static void getDelete(ArrayList<EmployeeName> deletNam)
{

 Scanner scn = new Scanner(System.in);
   System.out.print("Enter ID to delete: ");
    String search = scn.nextLine();
    

       boolean s = deletNam.removeIf(emp -> emp.getId().equals(search));
       if(s){
       System.out.println(" Id get deleted ");
       }
       else{
        System.out.println("not deleted ");
       }
    


    }


    }





  
 class EmployeeName{
    private String id;
    private String name;
    private String department;
    private String role;
    private String salary;

    public EmployeeName(String id, String name, String department, String role, String salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.role = role;
        this.salary = salary;
    }
  
    //Setter 

    public void SetName(String name)
    {
      this.name = name;
    }

    public void Setdept(String department)
    {
      this.department = department;
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

    public String getAll()
    {
      return  id +" |"+ name+ " |"+ department +"  |"+ role + " |"+ salary; 
    }


















    // Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public String getRole() {
        return role;
    }

    public String getSalary() {
        return salary;
    }


    @Override
    public String toString() {
        return id + " - " + name + " - " + department + " - " + role + " - " + salary;
    }
}