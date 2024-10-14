
/******************************************
 *  @Author : Ali Azhari   
 *  @Created On : Oct 01 2024
 *  @File : Simulator.java
 *  @Description: TODO
 ****************************************** */

import java.util.Comparator;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class Simulator {

    public static void main(String[] args) throws FileNotFoundException {
      

        // Comparator implementation
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return a - b;
            }
        };
        

        DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<>();

        Scanner scanner = new Scanner(new File("commands.csv"));

        while (scanner.hasNextLine()) {

            String line = scanner.nextLine();
            String[] words = line.split(",");

           System.out.println("Command: " + words[0]);
            switch (words[0]) {
                case "create":
             
                System.out.println("create");
                break;
                case "insert":
                    // Call insert
                    doubleLinkedList.insert(Integer.parseInt(words[1]), Integer.parseInt(words[2]));
                    System.out.println("Insert: " +doubleLinkedList.getItemCount()+" items, List:"+ doubleLinkedList);
                    break;
                   
                   
                case ("remove"):
                   // call remove
                   System.out.println("Remove: " + doubleLinkedList.getEntry(Integer.parseInt(words[1])) );
                   doubleLinkedList.remove(Integer.parseInt(words[1]));
                    
                    break;

                case ("get"):
                    // call getEntry'
                    System.out.println("Get Entry: " + doubleLinkedList.getEntry(Integer.parseInt(words[1]))+" at index "+words[1]);
                    break;
                case ("print"):
                    // print in a natural order if argument is 0
                    // print after sorting if argument is 1
                    int sortedFlag = Integer.parseInt(words[1]);
                    if (sortedFlag == 1) {
                        // Sort and print the list
                        doubleLinkedList.sort(comparator);
                        System.out.println("Sorted list: " + doubleLinkedList);
                    }else {
                    // Print without sorting
                        System.out.println("Unsorted list: " + doubleLinkedList);
                    }
                    break;
                default:
                    System.out.println("Unknown Command");
            }
        }
    }
}
