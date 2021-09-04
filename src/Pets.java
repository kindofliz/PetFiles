import java.util.Date;

public class Pets extends Owners {

    //ATTRIBUTES
    //Basic
    private String name;
    private char gender;
    private String animalType;
    private String animalBreed;
    private String dateOfBirth;
    private double weight;

    //Vaccination dates
    private String lastVaccinationDate;
    private String nextVaccinationDate;

    //Tick and Deworming meds
    private String tickMedsName;
    private String tickDateGiven;
    private String tickDateGiveNext;
    private String dewormerMedsName;
    private String dewDateGiven;
    private String dewDateGiveNext;

//    private String foodBrand;
//    private int foodBagWeight;
//    private int dailyAmount; //in grams
//    private String purchaseDate;


    //NO-ARGUMENT CONSTRUCTOR
    public Pets() {
    }


    //TO-STRING METHOD
    @Override
    public String toString() {
        return "MY PET || " +
                "Name: '" + name + '\'' +
                "\n| Gender: " + gender +
                "\n| Animal Type: '" + animalType + '\'' +
                "\n| Breed: '" + animalBreed + '\'' +
                "\n| Birthday: '" + dateOfBirth + '\'' +
                "\n| Weight (Kg): " + weight +
                "\n| Last vaccination date: '" + lastVaccinationDate + '\'' +
                "\n| Next vaccination date: '" + nextVaccinationDate + '\'' +
                "\n| Anti Tick and Flea meds: '" + tickMedsName + '\'' +
                "\n| Last given on: '" + tickDateGiven + '\'' +
                "\n| Next time to give: '" + tickDateGiveNext + '\'' +
                "\n| Dewormer name: '" + dewormerMedsName + '\'' +
                "\n| Last given on: '" + dewDateGiven + '\'' +
                "\n| Next time to give: '" + dewDateGiveNext + '\'' +
                '|';
    }



    //GETTERS AND SETTERS
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public String getAnimalBreed() {
        return animalBreed;
    }

    public void setAnimalBreed(String animalBreed) {
        this.animalBreed = animalBreed;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getLastVaccinationDate() {
        return lastVaccinationDate;
    }

    public void setLastVaccinationDate(String lastVaccinationDate) {
        this.lastVaccinationDate = lastVaccinationDate;
    }

    public String getNextVaccinationDate() {
        return nextVaccinationDate;
    }

    public void setNextVaccinationDate(String nextVaccinationDate) {
        this.nextVaccinationDate = nextVaccinationDate;
    }

    public String getTickMedsName() {
        return tickMedsName;
    }

    public void setTickMedsName(String tickMedsName) {
        this.tickMedsName = tickMedsName;
    }

    public String getTickDateGiven() {
        return tickDateGiven;
    }

    public void setTickDateGiven(String tickDateGiven) {
        this.tickDateGiven = tickDateGiven;
    }

    public String getTickDateGiveNext() {
        return tickDateGiveNext;
    }

    public void setTickDateGiveNext(String tickDateGiveNext) {
        this.tickDateGiveNext = tickDateGiveNext;
    }

    public String getDewormerMedsName() {
        return dewormerMedsName;
    }

    public void setDewormerMedsName(String dewormerMedsName) {
        this.dewormerMedsName = dewormerMedsName;
    }

    public String getDewDateGiven() {
        return dewDateGiven;
    }

    public void setDewDateGiven(String dewDateGiven) {
        this.dewDateGiven = dewDateGiven;
    }

    public String getDewDateGiveNext() {
        return dewDateGiveNext;
    }

    public void setDewDateGiveNext(String dewDateGiveNext) {
        this.dewDateGiveNext = dewDateGiveNext;
    }

}