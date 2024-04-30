/*package mystudent;
public class App
{
    public static void main(String[] args)
    {
        System.out.println("\nHello from class App\n");
        // Create a student object
        Student myStudent = new Student();
        // Fill the new myStudent object's data fields
        myStudent.firstName = "Kendall";
        myStudent.lastname = "Reagan";
        myStudent.gpa = 3.0;
        myStudent.major = "Mechanical Engineering";
        myStudent.city = "Clovis";
        System.out.println("\nThe first name of the student is: " + myStudent.firstName + "\n");
        System.out.println("\nThe last name of the student is: " + myStudent.lastname + "\n");
    }
}
package myanimals;
public class Cat extends Animal
{
    public Cat()
    {
        System.out.println("A cat is created");
    }
}
package myanimals;
public class Animal
{
    static int numOfAnimals = 0;
    public Animal()
    {
        numOfAnimals++;
        System.out.println("Number of animals: " + numOfAnimals);
    }
}
package mystuff;
public class Stuff
{
    public void use()
    {
        System.out.println("Using stuff...");
    }
}
package mystuff;
public class Driver
{
    public static void main(String[] args)
    {
        Stuff stuff = new Stuff();
        stuff.use();
    }
}
package mystudent;
public class Student
{
    String firstName;
    String lastname;
    double gpa;
    String major;
    String city;
}
 */
import java.util.*;
import java.io.*;
import java.lang.*;
import java.lang.StringBuilder;
import java.util.function.Supplier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
class Animal
{
    // vars within the animal class so no interference
    // w/ the other classes
    // these are for name, age, & species
    private String name;
    private int age;
    private String species;
    // my constructors for animal class
    public Animal(String name, int age, String species)
    {
        // my instance vars being assigned value
        this.name = name;
        this.age = age;
        this.species = species;
    }
    // my getters and setters
    // to get acsess to my private code
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public int getAge()
    {
        return age;
    }
    public void setAge(int age)
    {
        this.age = age;
    }
    public String getSpecies()
    {
        return species;
    }

    public void setSpecies(String species)
    {
        this.species = species;
    }
}
// extends means can access all the code from the private animal class
class Hyena extends Animal
{
    // my constructors for specific Hyena species
    public Hyena(String name, int age)
    {
        super(name, age, "Hyena");
    }
}
class Lion extends Animal
{
    // my constructor for Lion subclass
    public Lion(String name, int age)
    {
        super(name, age, "Lion");
    }
}
class Tiger extends Animal
{
    // my constructor for Tiger subclass
    public Tiger(String name, int age)
    {
        super(name, age, "Tiger");
    }
}
class Bear extends Animal
{
    // my constructor for Bear subclass
    public Bear(String name, int age)
    {
        super(name, age, "Bear");
    }
}
public class ZookeeperChallengeMIDterm
{
    public static void main(String[] args)
    {
        //ArrayList for string animal instances
        //declaring it as 4 b/c Hyena, Lion, Tiger, and Bear
        String[] animalArray = new String[4];
        String[] animalArray2 = {"Hyena","Lion","Tiger","Bear"};
        //[0][1][2][3] index
        System.out.println(animalArray2[1]);
        System.out.println(animalArray2.length);
        //reset an element
        animalArray2 [0]="tiger";
        System.out.println(animalArray2[0]);
        //print out the full array
        System.out.println(animalArray2);
        //arrayList time
        ArrayList<String> animalArrayList = new ArrayList<>();
        ArrayList<String> animalArrayList2 = new ArrayList<>(Arrays.asList("Hyena","Lion","Tiger","Bear"));
        //get size
        System.out.println(animalArrayList2.get(1));
        System.out.println(animalArrayList2.size());
        //add element
        animalArrayList2.add("elphant");
        System.out.println(animalArrayList2.get(4));
        //reset an element
        animalArrayList2.set(0,"elphant");
        System.out.println(animalArrayList2.get(0));
        //remove an element
        animalArrayList2.remove("Lion");
        System.out.println(animalArrayList2.get(1));
        //print out the full arrayList
        System.out.println(animalArrayList2);
        //map and hashmap time
        //species of the animals
        //can't use primitive data types
        HashMap<String, Integer> species = new HashMap<>();
        species.put("Lion",1);
        species.put("Tiger",1);
        species.put("Bear",1);
        species.put("Elphant",1);
        species.put("Hyena",1);
        System.out.println(species);
        species.get("Elphant");
        System.out.println(species.get("Elphant"));
        //checking for existance you cant also seach w/ ints instead of the name just enter the int
        System.out.println(species.containsKey("Bear"));
        System.out.println(species.containsKey("llama"));
        //change the int & you can use replace. it doesn't add if not there & putIfAbsent for the oppo
        species.put("Tiger",2);
        System.out.println(species);
        //vecta ArrayList
        int size = 1000000;
        List<Integer> arrayList= new ArrayList<>();
        long start = System.currentTimeMillis();
        for(int i=0; i< size; i++)
        {
            arrayList.add(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("Added " +size+ " elements to ArrayList: " +(end-start)+"ms");
        //vector time
        List<Integer> vector = new Vector<>();
        start = System.currentTimeMillis();
        for(int i=0; i< size; i++)
        {
            vector.add(i);
        }
        end = System.currentTimeMillis();
        System.out.println("Added " +size+ " elements to vector: " +(end-start)+"ms");
        //multi thread approach
        List<Integer> multithreadedList = new ArrayList<>();
        start = System.currentTimeMillis();
        //Thread
        Thread t1 = new Thread(
                ()->
                {
                    for(int i=0; i< size; i++)
                    {
                        multithreadedList.add(i);
                    }
                });
        Thread t2 = new Thread(() ->
        {
            for(int i=0; i< size; i++)
            {
                multithreadedList.add(i);
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        end = System.currentTimeMillis();
        System.out.println("Added " +size+ " elements in a multithreaded way to ArrayList: " +(end-start)+"ms");
        List<Integer> multithreadedVector = new Vector<>();
        start = System.currentTimeMillis();
        //Thread
        t1 = new Thread(
                ()->
                {
                    for(int i=0; i< size; i++)
                    {
                        multithreadedVector.add(i);
                    }
                });
        t2 = new Thread(
                ()->
                {
                    for(int i=0; i< size; i++)
                    {
                        multithreadedVector.add(i);
                    }
                });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        end = System.currentTimeMillis();
        System.out.println("Added " +size+ " elements in a multithreaded way to Vector: " +(end-start)+"ms");
      /*//fileIO stuff
      //gotta use a try catch blcok to make the throw IOexception go away
      try
      {
      BufferedWriter writer = new BufferedWriter(new FileWriter("motha.txt"));
      writer.write("lions, tigers, and bears! oh my");
      for (String name :animalArrayList2)
      {
         writer.write("\n"+animalArrayList2);
      }
      writer.close();
      }
      catch (IOException e)
      {
         e.printStackTrace();
      }
      try
      {
      BufferedReader reader = new BufferedReader(new FileReader("motha.txt"));
      String line;
      while((line=reader.readLine()) !=null)
      {
      System.out.println(line);
      }
      reader.close();
      }catch (IOException e)
      {
         e.printStackTrace();
      }*/
        // arrayList are better b/c you can add to it
        ArrayList<Animal> animals = new ArrayList<>();
        // hashMaps for keeping track of species count
        HashMap<String, Integer> speciesCount = new HashMap<>();
        // for the animal names now
        HashMap<String, ArrayList<String>> animalNames = new HashMap<>();
        // now we reading the names from the file provided
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader("animalNames.txt"));
            // to hold what the buffer reads
            String line;
            String currentSpecies = "";
            while ((line = reader.readLine()) != null)
            {
                if (line.contains("Names:"))
                {
                    // i had it reading comas before but changed it to spaces for no out of bounds errors
                    currentSpecies = line.split(" ")[0];
                    animalNames.put(currentSpecies, new ArrayList<>());
                } else
                {
                    String[] names = line.split(", ");
                    for (String name : names)
                    {
                        animalNames.get(currentSpecies).add(name);
                    }
                }
            }
            reader.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        // reading animal details from arrivingAnimals file provided
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader("arrivingAnimals.txt"));
            // to hold the buffer info
            String line;
            while ((line = reader.readLine()) != null)
            {
                String[] parts = line.split(" ");
                String[] ageParts = parts[0].split(" ");
                int age = Integer.parseInt(ageParts[0]);
                String species = parts[5];
                Animal animal;
                // used switch for each possible outcome when it comes to species
                switch (species)
                {
                    case "hyena":
                        animal = new Hyena(parts[6], age);
                        break;
                    case "lion":
                        animal = new Lion(parts[6], age);
                        break;
                    case "tiger":
                        animal = new Tiger(parts[6], age);
                        break;
                    case "bear":
                        animal = new Bear(parts[6], age);
                        break;
                    default:
                        animal = new Animal(parts[6], age, species);
                }
                animals.add(animal);
                speciesCount.put(species, speciesCount.getOrDefault(species, 0) + 1);
            }
            reader.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        // writing report to newAnimals file provided
        try
        {
            BufferedWriter writer = new BufferedWriter(new FileWriter("newAnimals.txt"));
            // to keep track of species count
            for (String species : speciesCount.keySet())
            {
                // write out the species count then put in the file
                writer.write("Species: " + species + ", Count: " + speciesCount.get(species) + "\n");
                for (Animal animal : animals)
                {
                    // only if species match do we write to the file
                    if (animal.getSpecies().equalsIgnoreCase(species))
                    {
                        writer.write("Name: " + animal.getName() + ", Age: " + animal.getAge() + "\n");
                    }
                }
                writer.write("\n");
            }
            writer.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
//Class Design: Create an Animal class with the properties name, age, and species.
// //Develop four subclasses: Hyena, Lion, Tiger, and Bear, each with unique features.
//Data Structures: Use ArrayList for storing animal instances and HashMap for counting species
//File I/O: Read animal details from arrivingAnimals.txt, and animalNames.txt and
// //output a report to newAnimals.txt, listing animals by species, their names, ages, and the total count of each species
//Control Structures & OOP Design: Apply loops, conditionals, encapsulation, inheritance, and polymorphism as specified.
//import java.lang.System.currentTimeMillis;