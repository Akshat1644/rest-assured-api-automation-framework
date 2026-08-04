package specifications;

import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;


public class RequestSpec {

    public static RequestSpecification requestSpecification() {

        return new RequestSpecBuilder()

                .setContentType("application/json")
                
                .addFilter(new RequestLoggingFilter())

                .addFilter(new ResponseLoggingFilter())

                .build();

    }

}