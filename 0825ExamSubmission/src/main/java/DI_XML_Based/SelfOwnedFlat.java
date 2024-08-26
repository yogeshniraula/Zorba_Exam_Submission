package DI_XML_Based;

public abstract class SelfOwnedFlat implements Property{

    public abstract void finalPriceOfFlat(int calculatePlot);
    private SelfOwnedOneBHKFlat self1;
    private SelfOwnedTwoBHKFlat self2;
    private SelfOwnedThreeBHKFlat self3;

    public SelfOwnedOneBHKFlat getSelf1() {
        return self1;
    }

    public void setSelf1(SelfOwnedOneBHKFlat self1) {
        this.self1 = self1;
    }

    public SelfOwnedTwoBHKFlat getSelf2() {
        return self2;
    }

    public void setSelf2(SelfOwnedTwoBHKFlat self2) {
        this.self2 = self2;
    }

    public SelfOwnedThreeBHKFlat getSelf3() {
        return self3;
    }

    public void setSelf3(SelfOwnedThreeBHKFlat self3) {
        this.self3 = self3;
    }
}
