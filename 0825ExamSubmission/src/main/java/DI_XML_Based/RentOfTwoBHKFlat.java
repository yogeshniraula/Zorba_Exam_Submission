package DI_XML_Based;

public class RentOfTwoBHKFlat {
   private boolean balcony;
   private int rent;


public void calculateRent(int noOfPerson) {
        int rent = 400 * noOfPerson;}

    public boolean isBalcony() {
        return balcony;
    }

    public void setBalcony(boolean balcony) {
        this.balcony = balcony;
    }

    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }
}
