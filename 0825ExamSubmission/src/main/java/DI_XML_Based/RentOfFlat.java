package DI_XML_Based;

public abstract class RentOfFlat implements Property{
    private int RentId;
    private RentOfOneBHKFlat rentOfOneBHKFlat;
    private RentOfTwoBHKFlat rentOfTwoBHKFlat;
    private RentOfTwoBHKFlat rentOfThreeBHKFlat;
    public abstract void calculateRent(int noOfPerson);

    public void setRentOfOneBHKFlat(RentOfOneBHKFlat rentOfOneBHKFlat) {
        this.rentOfOneBHKFlat = rentOfOneBHKFlat;
    }

    public RentOfTwoBHKFlat getRentOfTwoBHKFlat() {
        return rentOfTwoBHKFlat;
    }

    public void setRentOfTwoBHKFlat(RentOfTwoBHKFlat rentOfTwoBHKFlat) {
        this.rentOfTwoBHKFlat = rentOfTwoBHKFlat;
    }

    public RentOfTwoBHKFlat getRentOfThreeBHKFlat() {
        return rentOfThreeBHKFlat;
    }

    public void setRentOfThreeBHKFlat(RentOfTwoBHKFlat rentOfThreeBHKFlat) {
        this.rentOfThreeBHKFlat = rentOfThreeBHKFlat;
    }

    public RentOfFlat(RentOfOneBHKFlat rent){
        this.rentOfOneBHKFlat = rent;
    }

    public RentOfOneBHKFlat getRentOfOneBHKFlat() {
        return rentOfOneBHKFlat;
    }




    public int getRentId() {
        return RentId;
    }

    public void setRentId(int rentId) {
        this.RentId = rentId;
    }


}

