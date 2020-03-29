package pl.haladyj.webservicedemo.webService;

import lombok.Getter;
import lombok.Setter;
import pl.haladyj.webservicedemo.model.Country;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "country"
})
@XmlRootElement(name = "getUserResponse", namespace = "http://spring.io/guides/gs-producing-web-service")
public class GetCountryResponse {

    @XmlElement(namespace = "http://spring.io/guides/gs-producing-web-service", required = true)
    private Country country;

    public Country getCountry(){
        return country;
    }

    public void setCountry(Country country){
        this.country = country;
    }


}
