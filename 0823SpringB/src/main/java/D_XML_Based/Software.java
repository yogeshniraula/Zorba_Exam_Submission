package D_XML_Based;

public class Software {
    private int softwareId;
    private Program program;

    public int getSoftwareId() {
        return softwareId;
    }

    public void setSoftwareId(int softwareId) {
        this.softwareId = softwareId;
    }
    public Software(Program program){
        this.program = program;
    }
}
