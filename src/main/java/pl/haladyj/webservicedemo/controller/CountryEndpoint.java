package pl.haladyj.webservicedemo.controller;

import io.spring.guides.gs_producing_web_service.GetCountryRequest;
//import io.spring.guides.gs_producing_web_service.GetCountryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import pl.haladyj.webservicedemo.repository.CountryRepositoryJpa;
import pl.haladyj.webservicedemo.webService.GetCountryResponse;

@Endpoint
public class CountryEndpoint {

    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

    //private CountryRepository countryRepository;

    private final CountryRepositoryJpa repositoryJpa;

    @Autowired
    public CountryEndpoint(CountryRepositoryJpa repositoryJpa){
        this.repositoryJpa = repositoryJpa;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
    @ResponsePayload
    public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request){
        GetCountryResponse response = new GetCountryResponse();
        //response.setCountry(countryRepository.findCountry(request.getName()));
        response.setCountry(repositoryJpa.findCountryByName(request.getName()).get());
        return response;
    }
}
