
package Entity;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "bike.xml")
@XmlAccessorType(XmlAccessType.FIELD)

public class BikeXML {
     private List<Bike> bike;

    public List<Bike> getBike() {
        return bike;
    }

    public void setBike(List<Bike> bike) {
        this.bike = bike;
    }   
}
