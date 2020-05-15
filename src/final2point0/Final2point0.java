package final2point0;

import java.util.*;

public class Final2point0 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        final int MAX_DOGS = 13;  // max unadopted dogs you can have
        Dogs[] dogs = new Dogs[12];
        Adopters[] a = new Adopters[10];
        // Initialize the array
        createDogArray(dogs);

        // Displays and loops the menu
        do {
            System.out.println("Happy Tails Main Menu");
            // 2D Array to store menu
            String menuArray[][] = {
                {"1: ", "List Current Dogs"},
                {"2: ", "Add A Dog"},
                {"3: ", "Remove A Dog"},
                {"4: ", "Change A Dog"},
                {"5: ", "Adopt A Dog"},
                {"0: ", "Quit"}

            };

            for (int row = 0; row < 6; row++) {
                for (int col = 0; col < 2; col++) {
                    System.out.print(menuArray[row][col] + "   ");
                }

                System.out.println();
            }

            System.out.print("Please choose one of the options: ");
            int menuChoice = scanner.nextInt();

            switch (menuChoice) {
                case 1:
                    listCurrentDogs(dogs);
                    break;
                case 2:
                    addNewDog(dogs, scanner);
                    break;
                case 3:
                    removeADog(dogs, scanner);
                    break;
                case 4:
                    changeDogRecord(dogs, scanner);
                    break;
                case 5:
                    adoptDog(scanner, dogs, a);
                    break;
                case 0:
                    System.out.print("Happy tails to you - until we meet again!\n\n");
                    quit = true;
                    break;
                default:
                    System.out.print("That is not a valid option. Please try again.\n\n");
            }

        } while (!quit);
    } // Method to create the dogs and clean up main

    public static void adoptDog(Scanner scanner, Dogs[] dogs, Adopters[] a) {
        int adoptIndex = 0;
        System.out.print("Please choose the dog index who is getting adopted: ");
        int adoptDogIndex = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Congratulations " + dogs[adoptDogIndex].getName() + "! You're getting adopted!\n");
        System.out.print("Adopter's first name: ");
        String aFirstName = scanner.nextLine();
        System.out.print("Adopter's last name: ");
        String aLastName = scanner.nextLine();
        System.out.print("What is " + aFirstName + " " + aLastName +
                "'s age: ");
        int aAge = scanner.nextInt();
        scanner.nextLine();
        System.out.print("What is " + aFirstName + " " + aLastName +
                "'s address: ");
        String aAddress = scanner.nextLine();
        a[adoptIndex++] = new Adopters(aFirstName, aLastName, aAge, aAddress);
        dogs[adoptDogIndex].setAdopted(true);
        System.out.print("Conratulations " + aFirstName + ", on your adoption of " + dogs[adoptDogIndex].getName() + "!");
        System.out.println();
        System.out.println();
    }

    // Method to change elements within a dog's record
    public static void changeDogRecord(Dogs[] dogs, Scanner scanner) {
        
        // Choose the record in the array you want to change
        System.out.println("Let's get a dog's record changed");
        listCurrentDogs(dogs);
        System.out.print("Choose the index of the dog you would like to change: ");
        int changeIndex = scanner.nextInt();
        scanner.nextLine();
        
        // Make sure the choice is within the size of the array or reach else statement
        if (changeIndex <= 13) {
            System.out.println("You are changing the record for: " + dogs[changeIndex].getName() + "\n");
            System.out.println("Which part of the record do you want to change?");
            System.out.print("1. Name\n2. Age\n3. Weight\n4. Fixed\n5. Adopted\nChoose one of the options: ");
            int changeElement = scanner.nextInt();
            scanner.nextLine();
            if (changeElement == 1) {
                System.out.print("What would you like " + dogs[changeIndex].getName() +"'s name to? ");
                String newName = scanner.nextLine();
                dogs[changeIndex].setName(newName);
                System.out.println("Here is the new record\n");
                System.out.print(dogs[changeIndex].toString());
                System.out.println();
            }
            else if (changeElement == 2) {
                System.out.print("What would you like " + dogs[changeIndex].getName() +"'s age to? ");
                int newAge = scanner.nextInt();
                scanner.nextLine();
                dogs[changeIndex].setAge(newAge);
                System.out.println("Here is the new record\n");
                System.out.print(dogs[changeIndex].toString());
                System.out.println();
            }
            else if (changeElement == 3) {
                System.out.print("What would you like " + dogs[changeIndex].getName() +"'s weight to? ");
                double newWeight = scanner.nextDouble();
                scanner.nextLine();
                dogs[changeIndex].setWeight(newWeight);
                System.out.println("Here is the new record\n");
                System.out.print(dogs[changeIndex].toString());
                System.out.println();
            }
            else if (changeElement == 4) {
                System.out.print("What would you like " + dogs[changeIndex].getName() +"'s fixed status to (true/false)? ");
                boolean newFixed = scanner.nextBoolean();
                scanner.nextLine();
                dogs[changeIndex].setFixed(newFixed);
                System.out.println("Here is the new record\n");
                System.out.print(dogs[changeIndex].toString());
                System.out.println();
            }
            else if (changeElement == 5) {
                System.out.print("What would you like " + dogs[changeIndex].getName() +"'s adoption status to (true/false)? ");
                boolean newAdopted = scanner.nextBoolean();
                scanner.nextLine();
                dogs[changeIndex].setFixed(newAdopted);
                System.out.println("Here is the new record\n");
                System.out.print(dogs[changeIndex].toString());
                System.out.println();
            }
            else {
                System.out.print("Invalid input. Please try again: ");
            }
        }
        else {
            System.out.println("Invalid input. Please try again");
        }
        System.out.println();
        System.out.println();
    }

    // Method to remove a dogs record / null
    public static void removeADog(Dogs[] dogs, Scanner scanner) {
        // Show the user the list of dogs
        listCurrentDogs(dogs);

        // Ask user which dogs to remove
        System.out.print("Enter dog record (index) to be deleted : ");
        try {
            int removeIndex = scanner.nextInt();
            scanner.nextLine();
            for (int i = removeIndex; i < dogs.length - 1; i++) {
                dogs[i] = dogs[i + 1];

                System.out.println();
                System.out.println();
                System.out.print("Here is your updated list\n\n");
                listCurrentDogs(dogs);

            }
        } catch (NumberFormatException ex) {
            System.out.println(ex);
        }
    }

    // Method to display the list of current dogs
    public static void listCurrentDogs(Dogs[] dogs) {
        System.out.println("Here's a list of current dogs\n");

        // Display the Dogs
        System.out.println("Index\tName\tAge\tColor\tWeight\tFixed\tAdopted");
        for (Dogs d : dogs) {
            if (d != null) {
                System.out.println(d);
            }
        }
        // Line break
        System.out.println();
    }

    // Method to add a new dog to the array
    public static void addNewDog(Dogs[] dogs, Scanner scanner) {
        System.out.print("Let's get a new dog added\n");
        try {
            for (int i = 0; i < dogs.length; i++) {

                if (dogs[i] == null) {
                    System.out.println("The next open IDs are: " + i);
                }

            }

            System.out.println("Create the new dog's record");
            System.out.print("Dog ID: ");
            int newDogID = scanner.nextInt();
            scanner.nextLine();
            int index = newDogID;
            System.out.print("Dog's name: ");
            String newDogName = scanner.nextLine();
            System.out.print(newDogName + "'s age: ");
            int newDogAge = scanner.nextInt();
            scanner.nextLine();
            System.out.print(newDogName + "'s color: ");
            String newDogColor = scanner.nextLine();
            System.out.print(newDogName + "'s weight: ");
            double newDogWeight = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Is " + newDogName + " spay or neutered? ");
            boolean newFixed = scanner.nextBoolean();
            scanner.nextLine();
            System.out.print("Has " + newDogName + " been adopted yet? ");
            boolean newAdoption = scanner.nextBoolean();
            scanner.nextLine();

            dogs[index++] = new Dogs(newDogID, newDogName, newDogAge, newDogColor, newDogWeight, newFixed, newAdoption);

        } catch (Exception e) {
            System.out.print(e);
        }
    }

    // Fill the initial array with information
    public static void createDogArray(Dogs[] dogs) {
        // Create each dog
        dogs[0] = new Dogs(0, "Betty", 3, "Cream", 25, true, true);
        dogs[1] = new Dogs(1, "Loki", 8, "Brindle", 70, true, true);
        dogs[2] = new Dogs(2, "Ursa", 1, "Black", 7, true, true);
        dogs[3] = new Dogs(3, "Georgy", 3, "Brown", 20, true, false);
        dogs[4] = new Dogs(4, "Hero", 3, "Blue", 65, true, false);
        dogs[5] = new Dogs(5, "Piggy", 16, "Brown", 55, true, false);
        dogs[6] = new Dogs(6, "Abby", 6, "Black", 55, true, false);
        dogs[7] = new Dogs(7, "Chloe", 8, "Black", 35, false, false);
        dogs[8] = new Dogs(8, "Bruce", 6, "Black", 42, false, false);
        dogs[9] = new Dogs(9, "Spike", 12, "Red", 10, false, false);
    }


}
