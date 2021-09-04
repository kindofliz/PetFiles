public class Owners {

    //ATTRIBUTES
    private String ownersName;
    private String ownersSurname;


    //NO-ARGUMENT CONSTRUCTOR
    public Owners() {
    }


    //TO-STRING METHOD
    @Override
    public String toString() {
        return "Owners{" +
                "ownersName='" + ownersName + '\'' +
                ", ownersSurname='" + ownersSurname + '\'' +
                '}';
    }


    //GETTERS AND SETTERS
    public String getOwnersName() {
        return ownersName;
    }

    public void setOwnersName(String ownersName) {
        this.ownersName = ownersName;
    }

    public String getOwnersSurname() {
        return ownersSurname;
    }

    public void setOwnersSurname(String ownersSurname) {
        this.ownersSurname = ownersSurname;
    }
}