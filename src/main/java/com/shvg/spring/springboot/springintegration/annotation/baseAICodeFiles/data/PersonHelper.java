package com.shvg.spring.springboot.springintegration.annotation.baseAICodeFiles.data;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PersonHelper {

    private PersonRepository repository;
    private List<Person> personList;

    public PersonHelper(PersonRepository repository) {
        this.repository = repository;
    }

    public PersonHelper(List<Person> personList) {
        this.personList = personList;
    }

    public List<String> getLastNames() {
        return repository.findAll().stream()
                .map(Person::getLastName)
                .collect(Collectors.toList());
    }

    public Integer getHighestId() {
        return repository.findAll().stream()
                .mapToInt(Person::getTaxID)
                .max().orElse(0);
    }

    public List<Integer> savePeople(Person... person) {
        return Arrays.stream(person)
                .map(repository::save)
                .map(Person::getTaxID)
                .collect(Collectors.toList());
    }

    public Person createPerson(int id, String first, String last, LocalDate dob) {
        Person person = new Person(id, first, last, dob);
        repository.save(person);
        return person;
    }

    public long getTotalPeople() {
        return repository.count();
    }

    public void delete(Person person) {
        //Implement
    }

    public void deleteAll() {
        repository.findAll().forEach(repository::delete);
    }

    public List<Person> findByIds(Integer... ids) {
        return Arrays.stream(ids)
                .map(repository::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

    public Person findByTaxId(Integer id) {

        for (Person person : personList) {
            if (person.getTaxID() == id) {
                return person;
            }
        }

        return null;
    }
}
