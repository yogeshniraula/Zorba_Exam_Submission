package DI_XML_Based;

public class RentOfOneBHKFlat {
    private int rent;
    public boolean balcony;


    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }



    public boolean isBalcony() {
        return balcony;
    }

    public void setBalcony(boolean balcony) {
        this.balcony = balcony;
    }

    public int calculateRent(int noOfPerson) {
        int rentC = 250 * noOfPerson;
       return rent;
    }

}
