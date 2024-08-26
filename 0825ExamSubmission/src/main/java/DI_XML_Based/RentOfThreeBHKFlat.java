package DI_XML_Based;

public class RentOfThreeBHKFlat {
private boolean balcony;
private int rent;

    public int calculateRent(int noOfPerson) {
        int rent = 600 * noOfPerson;
        return rent;
    }

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
