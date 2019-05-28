package com.util;

import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;
import org.testng.annotations.DataProvider;

public class DataProviderClass {


    @DataProvider
    public static Object[][] getNewPersondata() {

        Fairy fairy = Fairy.create();
        Person person = fairy.person();

        System.out.println(person.getCompany());

        Object[][] object = {
                {
                        person.getSex().toString() == "MALE" ? "Mr" : "Miss",
                        person.getFirstName().toString(),
                        person.getLastName().toString(),
                        person.getCompany().getName(),
                        person.getTelephoneNumber().toString(),
                        person.getEmail().toString()}
        };

        return object;
    }

}
