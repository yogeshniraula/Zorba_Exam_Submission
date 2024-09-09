package D_XML_Based;

import org.springframework.beans.factory.annotation.Autowired;

public class Laptop {
        private int laptopId;
        private Software software;

    public static Software getSoftware() {
        return software;
    }

    public void setSoftware(Software software) {
        this.software = software;
    }

    public int getLaptopId() {
        return laptopId;
    }

    public void setLaptopId(int laptopId) {
        this.laptopId = laptopId;
    }


    public void setSoftwareName(Software software){
    }
    }

