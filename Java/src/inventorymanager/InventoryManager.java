package inventorymanager;

//  John Emery

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InventoryManager {
    
     public static void main(String[] args) {
    // Read Inventory:
         
         String tName;
         String tPath;
         
         Item[] tItem=new Item[4];
         int i=0;
         try{
         File myFile=new File("Arduino_Code.txt");
         Scanner input=new Scanner(myFile);
             while(input.hasNext()){
              tName=input.next();
              tPath=input.next();

              //System.out.println(tName+"  "+tPath);
    //    ii.  For every item in this file create a new object of the Item
    //         class with appropriate values.
              tItem[i]=new Item(tName,tPath);
              i++;  
          }
        }
        // This handles if the filename or path is invalid
        catch (FileNotFoundException Ex){
          System.out.print("ERROR:  File not found");
          System.exit(1);
        }
        catch (InputMismatchException Ex){
          System.out.println("ERROR:  There is an error in the data file... Fix input file and try again");
          System.exit(2);
        }
      
        boolean keeprunning=true;
        do{ 
      System.out.println("-------ARDUINO CODE MANAGER MENU--------");
      System.out.println("< L > ist Arduino Programs");
      System.out.println("< C > Compile Arduino Programs");
      System.out.println("< E > Exit");
      System.out.println("----------------------------------------");   
      String choice;
               // Create Scanner
      Scanner choice1=new Scanner(System.in);  
      // Ask the user the type of transaction they want (c/d/w)
      choice=choice1.nextLine();
         
          switch (choice){
          case "l":{
            // List Arduino Programs
             printInventory(tItem);
           break;
           }
          case "c":{
            // Compile Arduino Programs
            compileProgram(tItem);
            break;
           }

           case "e":{
            // f.  Exits the program
            System.out.println("Exit Program--------------------");
             keeprunning=false;
            break;
           }
          }
        }while(keeprunning);
     }
     
     // c.  Write a method printInventory to which pass the array of objects as
     //     an input parameter.  The method prints the inventory in the following
     //     format:  Item Name, Quantity, Price Per Piece
     public static void printInventory(Item[] Temparray){
            System.out.println("--------------ARDUINO PROGRAMS-----------------");
            System.out.println("Item Name\tPath\n");
                for(int i=0;i<(Temparray.length-1);i++){
                System.out.printf("%-10s\t%-10s\t\n",Temparray[i].getName(),Temparray[i].getPath());
                }
            System.out.println("------------------------------------------------");
     }    
     
     public static void compileProgram(Item[] Temparray){
         boolean keeprunning=true;
         do{ 
            System.out.println("---------COMPILE ARDUINO PROGRAMS----------");
            System.out.println("Num\tItem Name\tPath\n");
            for(int i=0;i<(Temparray.length-1);i++){
            System.out.printf("%-3d\t%-10s\t%-10s\t\n",i,Temparray[i].getName(),Temparray[i].getPath());
            }
            System.out.println("< E > Exit");
            System.out.println("------------------------------------------");
            String choice;
            // Create Scanner
            Scanner choice1=new Scanner(System.in);  
            // Ask the user the type of transaction they want (0,1)
            choice=choice1.nextLine();
      
            switch (choice){
            	case "0":{
            	// Compile Beep
            	try {
					Runtime.getRuntime().exec("cmd /k loadmelody.bat");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	break;
            	}
            	case "1":{
            	// Compile Button
            	try {
					Runtime.getRuntime().exec("cmd /k loadbutton.bat");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	break;
            	}

            	case "e":{
                // f.  Exits the program
                System.out.println("Exit Program--------------------");
                 keeprunning=false;
                break;
               }
              }
            }while(keeprunning);
     }
}
