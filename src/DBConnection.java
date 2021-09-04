import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DBConnection {

    Scanner scanner = new Scanner(System.in);

    private Connection conn;

    public DBConnection() {

        try {
            String dbUrl = "jdbc:sqlite:petFiles.db";
            conn = DriverManager.getConnection(dbUrl);

            if (conn != null) {
                DatabaseMetaData databaseMetadata = conn.getMetaData();
                System.out.println("Connected to " + databaseMetadata.getDatabaseProductName() + " " + databaseMetadata.getDatabaseProductVersion());

                // CREATING A TABLE FOR PETS
                Statement statement = conn.createStatement();
                String sqlStatement =
                        "CREATE TABLE IF NOT EXISTS pets" +
                                " (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                                "name TEXT, " +
                                "gender TEXT NOT NULL, " +
                                "animal_type TEXT, " +
                                "animal_breed TEXT, " +
                                "date_of_birth TEXT NOT NULL, " +
                                "weight REAL NOT NULL, " +
                                "last_vaccination_date TEXT NOT NULL, " +
                                "next_vaccination_date TEXT NOT NULL, " +
                                "tick_meds_name TEXT, " +
                                "tick_date_given TEXT, " +
                                "tick_date_give_next TEXT, " +
                                "dewormer_meds_name TEXT, " +
                                "dew_date_given TEXT, " +
                                "dew_date_give_next TEXT) ";


                statement.execute(sqlStatement);

            }

        } catch (SQLException exception) {
            System.out.println("Database issues" + exception);
        }
    }


    //METHODS
    //METHOD TO CREATE A PET (INSERT PET INTO DATABASE)
    public void createPet(Pets pet) {

        try {
            Statement statement = conn.createStatement();
            String sqlStatement = "INSERT INTO pets (" +
                    "name, gender, animal_type, animal_breed, date_of_birth, weight, last_vaccination_date, next_vaccination_date, tick_meds_name, tick_date_given, tick_date_give_next, dewormer_meds_name, dew_date_given, dew_date_give_next) " +
                    "VALUES (" +
                    "'" + pet.getName() + "'," +
                    "'" + pet.getGender() + "'," +
                    "'" + pet.getAnimalType() + "'," +
                    "'" + pet.getAnimalBreed() + "'," +
                    "'" + pet.getDateOfBirth() + "'," +
                    + pet.getWeight() + "," +
                    "'" + pet.getLastVaccinationDate() + "'," +
                    "'" + pet.getNextVaccinationDate() + "'," +
                    "'" + pet.getTickMedsName() + "'," +
                    "'" + pet.getTickDateGiven() + "'," +
                    "'" + pet.getTickDateGiveNext() + "'," +
                    "'" + pet.getDewormerMedsName() + "'," +
                    "'" + pet.getDewDateGiven() + "'," +
                    "'" + pet.getDewDateGiveNext() + "'" +
                    ")";

            statement.execute(sqlStatement);

        } catch (SQLException exception) {
            System.out.println("Error creating a Pet : " + exception);
        }

    }


    //METHOD TO SHOW THE LIST OF PET NAMES
    public ArrayList<Pets> getPetNames() {

        ArrayList<Pets> petList = new ArrayList<Pets>();

        try {
            Statement statement = conn.createStatement();
            String sqlStatement = "SELECT name FROM pets";

            ResultSet rs = statement.executeQuery(sqlStatement);

            while (rs.next()) {
                //Create a new Pets object
                Pets pet = new Pets();
                pet.setName(rs.getString("name"));

                System.out.println(pet.getName());
            }
        } catch (SQLException exception) {
            System.out.println("Error getting Pet name list: " + exception);
        }
        return petList;
    }


    //METHOD TO SHOW ONE PET'S INFORMATION (PET PROFILE)
    public ArrayList<Pets> getOnePet() {

        ArrayList<Pets> petJustOne = new ArrayList<Pets>();

        try {
            Statement statement = conn.createStatement();
            String sqlStatement = "SELECT * FROM pets WHERE name = " + "\'" + scanner.next() + "\'";

            ResultSet rs = statement.executeQuery(sqlStatement);

            while (rs.next()) {
                //Create a new Pet object
                Pets pet = new Pets();
                pet.setName(rs.getString("name"));
                pet.setGender(rs.getString("gender").charAt(0));
                pet.setAnimalType(rs.getString("animal_type"));
                pet.setAnimalBreed(rs.getString("animal_breed"));
                pet.setDateOfBirth(rs.getString("date_of_birth"));
                pet.setWeight(rs.getDouble("weight"));
                pet.setLastVaccinationDate(rs.getString("last_vaccination_date"));
                pet.setNextVaccinationDate(rs.getString("next_vaccination_date"));
                pet.setTickMedsName(rs.getString("tick_meds_name"));
                pet.setTickDateGiven(rs.getString("tick_date_given"));
                pet.setTickDateGiveNext(rs.getString("tick_date_give_next"));
                pet.setDewormerMedsName(rs.getString("dewormer_meds_name"));
                pet.setDewDateGiven(rs.getString("dew_date_given"));
                pet.setDewDateGiveNext(rs.getString("dew_date_give_next"));


                System.out.println(pet.toString());
            }

        } catch (SQLException exception) {
            System.out.println("Error getting One pet's information: " + exception);
        }

        return petJustOne;
    }


    //METHOD TO SHOW ONE PET'S INFORMATION (PET PROFILE)
    public ArrayList<Pets> getVaccinationSchedule() {

        ArrayList<Pets> vaccData = new ArrayList<Pets>();

        try {
            Statement statement = conn.createStatement();
            String sqlStatement = "SELECT name, next_vaccination_date FROM pets ORDER BY next_vaccination_date";

            ResultSet rs = statement.executeQuery(sqlStatement);

            while (rs.next()) {
                //Create a new Pet object
                Pets pet = new Pets();
                pet.setName(rs.getString("name"));
                pet.setNextVaccinationDate(rs.getString("next_vaccination_date"));

                System.out.println(pet.getName() + " " + pet.getNextVaccinationDate());
            }

        } catch (SQLException exception) {
            System.out.println("Error getting vaccination schedule information: " + exception);
        }

        return vaccData;
    }


    //METHOD TO SHOW ONE PET'S INFORMATION (PET PROFILE)
    public ArrayList<Pets> getTickAndFleaSchedule() {

        ArrayList<Pets> medData = new ArrayList<Pets>();

        try {
            Statement statement = conn.createStatement();
            String sqlStatement = "SELECT name, tick_meds_name, tick_date_give_next FROM pets ORDER BY tick_date_give_next";

            ResultSet rs = statement.executeQuery(sqlStatement);

            while (rs.next()) {
                //Create a new Pet object
                Pets pet = new Pets();
                pet.setName(rs.getString("name"));
                pet.setTickMedsName(rs.getString("tick_meds_name"));
                pet.setTickDateGiveNext(rs.getString("tick_date_give_next"));

                System.out.println(pet.getName() + " - " + pet.getTickMedsName() + " | Next due: " + pet.getTickDateGiveNext());
            }

        } catch (SQLException exception) {
            System.out.println("Error getting vaccination schedule information: " + exception);
        }

        return medData;
    }




}



