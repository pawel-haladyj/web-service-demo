package pl.haladyj.webservicedemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.haladyj.webservicedemo.model.Country;

import java.util.Optional;

@Repository
public interface CountryRepositoryJpa extends JpaRepository<Country,Integer> {

    Optional<Country> findCountryByName(String name);
}
