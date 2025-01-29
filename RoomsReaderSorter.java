import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class RoomsReaderSorter {
    public static void main(String[] args) throws FileNotFoundException {
        //creates a list to store all the rooms in
        ArrayList<Rooms> list = new ArrayList<Rooms>();
        //scans the file for the rooms and puts it in the scanner
        Scanner sc = new Scanner(new File("GameRooms.txt"));
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            //this takes the first line and separates it and puts the id and
            //puts it into two separate variables
            if (line.contains(",")) {

                String[] parts = line.split(",");

                // takes out and trims the id part and name
                String newID = parts[0].trim();  // "ID = 1"
                String newName = parts[1].trim(); // "Entrance"

                //splits the ID part on '=' and takes out the ID
                String[] idTokens = newID.split("=");
                // parses the id and removes extra spaces
                int id = Integer.parseInt(idTokens[1].trim());

                //makes new variables and scans the next lines in the files
                //putting it into the variables
                String newDesc = "";
                String newDirection = "";
                if (sc.hasNextLine()) {
                    line = sc.nextLine();
                    if (line.equals("Description")) {
                        line = sc.nextLine();
                        newDesc = line;
                        if (sc.hasNextLine()) {
                            line = sc.nextLine();
                            newDirection = line;
                        }
                    }
                }
                //makes a new room and adds it it to the list
                Rooms newRoom = new Rooms(id, newName, newDesc, newDirection);
                list.add(newRoom);
            }
        }

        //prints out the starting speech and scans the next line for the input
        //while making a new variable for the current room and newest room
        System.out.println("Welcome to my adventure game. You will proceed through rooms based upon your entries.\n" +
                "You can navigate by using the entire direction or just the first letter.\n" +
                "You can view a room using the 'Look' command.\n" +
                "To exit(X) the game, enter X\n");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int currentRoom = 1;
        String newInput = "";

        //if the input is x it quits the game
        if (input.equals("X")) {
            System.out.println("Exit");
            System.exit(0);

            //while the input isnt x it keeps going until user types x
            while (!input.equals("X")) {
                if (currentRoom == 1) {

                   //changes the visited part of the list and prints it if its visited or not
                    if (list.get(currentRoom - 1).isVisited() == false) {
                        System.out.println(list.get(currentRoom - 1).getName() + " Not visited");
                        list.get(currentRoom - 1).setVisited(true);
                    } else {
                        System.out.println(list.get(currentRoom - 1).getName() + " Visited");
                    }

                    //prints the details for the descrption of rooms and directions
                    System.out.println(list.get(currentRoom - 1).getDescription());
                    System.out.println(list.get(currentRoom - 1).getDirection());
                    System.out.println("What would you like to do?");
                    newInput = scanner.nextLine();

                    //checks to see if the input is valid and changes the room if it is
                    //if it isnt valid it tells the user
                    if (!newInput.equals("e") && !newInput.equals("east") && !newInput.equals("w") && !newInput.equals("west")) {
                        System.out.println("Invalid direction entered");
                    } else {
                        if (newInput.equals("e") || newInput.equals("east")) {
                            currentRoom = 4;
                        } else {
                            currentRoom = 2;
                        }
                    }
                }

                if (currentRoom == 2) {

                    if (list.get(currentRoom - 1).isVisited() == false) {
                        System.out.println(list.get(currentRoom - 1).getName() + " Not visited");
                        list.get(currentRoom - 1).setVisited(true);
                    } else {
                        System.out.println(list.get(currentRoom - 1).getName() + " Visited");
                    }

                    System.out.println(list.get(currentRoom - 1).getDescription());
                    System.out.println(list.get(currentRoom - 1).getDirection());
                    System.out.println("What would you like to do?");
                    newInput = scanner.nextLine();
                    if (!newInput.equals("s") && !newInput.equals("south") && !newInput.equals("w") && !newInput.equals("west")) {
                        System.out.println("Invalid direction entered");
                    } else {
                        if (newInput.equals("s") || newInput.equals("south")) {
                            currentRoom = 3;
                        } else {
                            currentRoom = 1;
                        }
                    }
                }

                if (currentRoom == 3) {

                    if (list.get(currentRoom - 1).isVisited() == false) {
                        System.out.println(list.get(currentRoom - 1).getName() + " Not visited");
                        list.get(currentRoom - 1).setVisited(true);
                    } else {
                        System.out.println(list.get(currentRoom - 1).getName() + " Visited");
                    }

                    System.out.println(list.get(currentRoom - 1).getDescription());
                    System.out.println(list.get(currentRoom - 1).getDirection());
                    System.out.println("What would you like to do?");
                    newInput = scanner.nextLine();
                    if (!newInput.equals("n") && !newInput.equals("north") && !newInput.equals("e") && !newInput.equals("east")) {
                        System.out.println("Invalid direction entered");
                    } else {
                        if (newInput.equals("n") || newInput.equals("north")) {
                            currentRoom = 2;
                        } else {
                            currentRoom = 10;
                        }
                    }
                }

                if (currentRoom == 4) {

                    if (list.get(currentRoom - 1).isVisited() == false) {
                        System.out.println(list.get(currentRoom - 1).getName() + " Not visited");
                        list.get(currentRoom - 1).setVisited(true);
                    } else {
                        System.out.println(list.get(currentRoom - 1).getName() + " Visited");
                    }

                    System.out.println(list.get(currentRoom - 1).getDescription());
                    System.out.println(list.get(currentRoom - 1).getDirection());
                    System.out.println("What would you like to do?");
                    newInput = scanner.nextLine();
                    if (newInput.equals("s") || newInput.equals("south")) {
                        currentRoom = 6;
                    } else if (newInput.equals("n") || newInput.equals("north")) {
                        currentRoom = 5;
                    } else if (newInput.equals("w") || newInput.equals("west")) {
                        currentRoom = 7;
                    } else if (newInput.equals("e") || newInput.equals("east")) {
                        currentRoom = 1;
                    } else {
                        System.out.println("Invalid direction entered");
                    }

                }

                if (currentRoom == 5) {

                    if (list.get(currentRoom - 1).isVisited() == false) {
                        System.out.println(list.get(currentRoom - 1).getName() + " Not visited");
                        list.get(currentRoom - 1).setVisited(true);
                    } else {
                        System.out.println(list.get(currentRoom - 1).getName() + " Visited");
                    }

                    System.out.println(list.get(currentRoom - 1).getDescription());
                    System.out.println(list.get(currentRoom - 1).getDirection());
                    System.out.println("What would you like to do?");
                    newInput = scanner.nextLine();
                    if (!newInput.equals("s") && !newInput.equals("south") && !newInput.equals("w") && !newInput.equals("west")) {
                        System.out.println("Invalid direction entered");
                    } else {
                        if (newInput.equals("s") || newInput.equals("south")) {
                            currentRoom = 4;
                        } else {
                            currentRoom = 8;
                        }
                    }
                }

                if (currentRoom == 6) {

                    if (list.get(currentRoom - 1).isVisited() == false) {
                        System.out.println(list.get(currentRoom - 1).getName() + " Not visited");
                        list.get(currentRoom - 1).setVisited(true);
                    } else {
                        System.out.println(list.get(currentRoom - 1).getName() + " Visited");
                    }

                    System.out.println(list.get(currentRoom - 1).getDescription());
                    System.out.println(list.get(currentRoom - 1).getDirection());
                    System.out.println("What would you like to do?");
                    newInput = scanner.nextLine();
                    if (!newInput.equals("n") || !newInput.equals("north")) {
                        System.out.println("Invalid direction entered");
                    } else {
                        if (newInput.equals("n") || newInput.equals("north")) {
                            currentRoom = 4;
                        }
                    }
                }

                if (currentRoom == 7) {

                    if (list.get(currentRoom - 1).isVisited() == false) {
                        System.out.println(list.get(currentRoom - 1).getName() + " Not visited");
                        list.get(currentRoom - 1).setVisited(true);
                    } else {
                        System.out.println(list.get(currentRoom - 1).getName() + " Visited");
                    }

                    System.out.println(list.get(currentRoom - 1).getDescription());
                    System.out.println(list.get(currentRoom - 1).getDirection());
                    System.out.println("What would you like to do?");
                    newInput = scanner.nextLine();
                    if (!newInput.equals("n") && !newInput.equals("north") && !newInput.equals("e") && !newInput.equals("east") && !newInput.equals("w") && !newInput.equals("west")) {
                        System.out.println("Invalid direction entered");
                    } else {
                        if (newInput.equals("n") || newInput.equals("north")) {
                            currentRoom = 8;
                        } else if (newInput.equals("e") || newInput.equals("east")) {
                            currentRoom = 4;
                        } else {
                            currentRoom = 9;
                        }
                    }
                }

                if (currentRoom == 8) {

                    if (list.get(currentRoom - 1).isVisited() == false) {
                        System.out.println(list.get(currentRoom - 1).getName() + " Not visited");
                        list.get(currentRoom - 1).setVisited(true);
                    } else {
                        System.out.println(list.get(currentRoom - 1).getName() + " Visited");
                    }

                    System.out.println(list.get(currentRoom - 1).getDescription());
                    System.out.println(list.get(currentRoom - 1).getDirection());
                    System.out.println("What would you like to do?");
                    newInput = scanner.nextLine();
                    if (!newInput.equals("s") && !newInput.equals("south") && !newInput.equals("e") && !newInput.equals("east")) {
                        System.out.println("Invalid direction entered");
                    } else {
                        if (newInput.equals("s") || newInput.equals("south")) {
                            currentRoom = 7;
                        } else {
                            currentRoom = 5;
                        }
                    }
                }

                if (currentRoom == 9) {

                    if (list.get(currentRoom - 1).isVisited() == false) {
                        System.out.println(list.get(currentRoom - 1).getName() + " Not visited");
                        list.get(currentRoom - 1).setVisited(true);
                    } else {
                        System.out.println(list.get(currentRoom - 1).getName() + " Visited");
                    }

                    System.out.println(list.get(currentRoom - 1).getDescription());
                    System.out.println(list.get(currentRoom - 1).getDirection());
                    System.out.println("What would you like to do?");
                    newInput = scanner.nextLine();
                    if (!newInput.equals("e") || newInput.equals("east")) {
                        System.out.println("Invalid direction entered");
                    } else {
                        if (newInput.equals("e") || newInput.equals("east")) {
                            currentRoom = 7;
                        }
                    }
                }

                if (currentRoom == 10) {

                    if (list.get(currentRoom - 1).isVisited() == false) {
                        System.out.println(list.get(currentRoom - 1).getName() + " Not visited");
                        list.get(currentRoom - 1).setVisited(true);
                    } else {
                        System.out.println(list.get(currentRoom - 1).getName() + " Visited");
                    }

                    System.out.println(list.get(currentRoom - 1).getDescription());
                    System.out.println(list.get(currentRoom - 1).getDirection());
                    System.out.println("What would you like to do?");
                    newInput = scanner.nextLine();
                    if (!newInput.equals("w") && !newInput.equals("west")) {
                        System.out.println("Invalid direction entered");
                    } else {
                        if (newInput.equals("w") || newInput.equals("west")) {
                            currentRoom = 3;
                        }
                    }
                }


            }
        }

        }
    }


