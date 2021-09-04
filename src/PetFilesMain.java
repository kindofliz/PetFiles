import java.util.Locale;
import java.util.Scanner;

public class PetFilesMain {
    public static void main(String[] args) {

        DBConnection petFilesDb = new DBConnection();

        Scanner scanner = new Scanner(System.in);

        int menuItem;

        do {
            System.out.println();
            System.out.println("===============WELCOME!===============");
            System.out.println();
            System.out.println("What would you like to do?");
            System.out.println("1. - Add a new pet.");
            System.out.println("2. - See a list of my pets.");
            System.out.println("3. - See information on one pet.");
            System.out.println("4. - See the vaccination schedule.");
            System.out.println("5. - See the Tick and Flea medication schedule.");
            System.out.println("6. - See the De-worming medication schedule.");
//          System.out.println("7. - Calculate food info?.");
            System.out.println("8. - Edit information.");
                            // System.out.println("What would you like to change?");
                            //1. Change last vaccine date
                            //2. Change next vaccine date
                            //3. Change tick med name
                            //4. change tick med last date
                            //5. change tick med next date
                            //6. change dewormer name
                            //7. change dewormer last date
                            //8. change dewormer next date
                            //9. Change last vaccine date
                            //10. change weight
            System.out.println("9. - Delete a pet.");
            System.out.println("0. - Exit!");

            menuItem = scanner.nextInt();

            switch (menuItem) {
                case 1:
                    // Creating a new Pets object
                    Pets myPet = new Pets();

                    System.out.println("Enter your pet's name:");
                    String name = scanner.next();
                    myPet.setName(name);

                    System.out.println("Is your pet male (M) or female (F)?");
                    char gender = scanner.next().toUpperCase(Locale.ROOT).charAt(0);
                    myPet.setGender(gender);

                    System.out.println("What type of animal is it?:");
                    String type = scanner.next().toUpperCase(Locale.ROOT);
                    myPet.setAnimalType(type);

                    System.out.println("Enter your pet's breed:");
                    scanner.nextLine();            //making sure the cursor moves to the new line before scanning
                    String breed = scanner.next();
                    myPet.setAnimalBreed(breed);

                    System.out.println("Enter your pet's birthday (MM/dd/yyyy):");
                    String dateOfBirth = scanner.next();
                    myPet.setDateOfBirth(dateOfBirth);

                    System.out.println("Your pet's weight (kg): ");
                    double weight = scanner.nextDouble();
                    myPet.setWeight(weight);

                    System.out.println("Enter your pet's last vaccination date (MM/dd/yyyy) :");
                    String lastVacDate = scanner.next();
                    myPet.setLastVaccinationDate(lastVacDate);

                    System.out.println("Enter your pet's next vaccination date (MM/dd/yyyy) :");
                    String nextVacDate = scanner.next();
                    myPet.setNextVaccinationDate(nextVacDate);

                    System.out.println("Enter Tick and Flea prevention medication name: ");
                    String tickName = scanner.next();
                    myPet.setTickMedsName(tickName);

                    System.out.println("Last date of treatment against Ticks and Fleas (MM/dd/yyyy): ");
                    String tickLastDate = scanner.next();
                    myPet.setTickDateGiven(tickLastDate);

                    System.out.println("Next date for treatment against Ticks and Fleas (MM/dd/yyyy): ");
                    String tickNextDate = scanner.next();
                    myPet.setTickDateGiveNext(tickNextDate);

                    System.out.println("Enter deworming medication name: ");
                    String dewName = scanner.next();
                    myPet.setDewormerMedsName(dewName);

                    System.out.println("Last date of dewormer administration (MM/dd/yyyy): ");
                    String dewLastDate = scanner.next();
                    myPet.setDewDateGiven(dewLastDate);

                    System.out.println("Next date of dewormer administration (MM/dd/yyyy): ");
                    String dewNextDate = scanner.next();
                    myPet.setDewDateGiveNext(dewNextDate);


                    //INSERTING THE PET INTO DATABASE
                    petFilesDb.createPet(myPet);

                    break;
                case 2:

                    System.out.println("LIST OF MY PETS: ");
                    petFilesDb.getPetNames();

                    System.out.println();

                    break;
                case 3:
                    System.out.println("Enter a name from the pet list: ");
                    //Calling the method to SELECT all the info about chosen pet from DB

                    System.out.println("================= MY PET ====================");
                    petFilesDb.getOnePet();
                    System.out.println("=============================================");


                    break;
                case 4:
                    System.out.println("Vaccination schedule: ");
                    System.out.println();
                    petFilesDb.getVaccinationSchedule();

                    break;
                case 5:
                    System.out.println("Tick and Flea medication schedule: ");
                    System.out.println();
                    petFilesDb.getTickAndFleaSchedule();

                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 8:

                    break;
                case 9:

                    break;
                default:
                    if (menuItem != 0)
                        System.out.println("Menu item does not exist!");
                    System.out.println();
            }


        } while (menuItem != 0);


    }
}