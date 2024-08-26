package DI_XML_Based;

public class SelfOwnedTwoBHKFlat {
    private float price;

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float calculatePlot(float length, float breadth, float height){
        float plot = (float) (length * breadth * height);
        return plot;
    }

    public float finalPriceOfFlat(float plot){
        float price = (float) (plot*30000);
        return price;
    }
}
