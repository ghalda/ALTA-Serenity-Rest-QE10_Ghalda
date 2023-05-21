package starter.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Reqres.ReqresAPI;
import starter.Reqres.ReqressResponses;
import starter.Utils.Constants;

import java.io.File;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class RegisterStepDef {

    @Steps
    ReqresAPI reqresAPI;

    @Given("Register new user with valid json")
    public void registerNewUserWithValidJson() {
        File json = new File(Constants.REQ_BODY_DIR+ "Register/ValidInputReqBody.json");
        reqresAPI.registerUser(json);
    }

    @When("Send POST register user")
    public void sendPostRegisterUser() {
        SerenityRest.when().post(ReqresAPI.POST_REGISTER);
    }

    @And("Response body token exist")
    public void responseBodyTokenExist() {
        SerenityRest.and().body(ReqressResponses.TOKEN, notNullValue());
    }

    @And("Validate successful post register user json schema")
    public void validateSuccessfulPostRegisterUserJsonSchema() {
        File json = new File(Constants.JSON_SCHEMA_DIR+ "Register/SuccessfulRegister.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Register new user without request body email")
    public void registerNewUserWithoutRequestBodyEmail() {
        File json = new File(Constants.REQ_BODY_DIR+ "Register/WithoutEmailReqBody.json");
        reqresAPI.registerUser(json);
    }

    @And("Response body error message was {string}")
    public void responseBodyErrorMessageWas(String errMessage) {
        SerenityRest.and().body(ReqressResponses.ERROR, equalTo(errMessage));
    }

    @And("Validate post unsuccessful register user")
    public void validatePostUnsuccessfulRegisterUser() {
        File json = new File(Constants.JSON_SCHEMA_DIR + "Register/UnsuccessfulRegister.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Register new user without request body password")
    public void registerNewUserWithoutRequestBodyPassword() {
        File json = new File(Constants.REQ_BODY_DIR+ "Register/WithoutPasswordReqBody.json");
        reqresAPI.registerUser(json);
    }

    @Given("Register new user without request body email and password")
    public void registerNewUserWithoutRequestBodyEmailAndPassword() {
        File json = new File(Constants.REQ_BODY_DIR+ "Register/WithoutReqBody.json");
        reqresAPI.registerUser(json);
    }

    @Given("Register new user with invalid format email")
    public void registerNewUserWithInvalidFormatEmail() {
        File json = new File(Constants.REQ_BODY_DIR+ "Register/InvalidEmailReqBody.json");
        reqresAPI.registerUser(json);
    }

    @Given("Register new user with email number type data")
    public void registerNewUserWithEmailNumberTypeData() {
        File json = new File(Constants.REQ_BODY_DIR+ "Register/NumberEmailReqBody.json");
        reqresAPI.registerUser(json);
    }

    @Given("Register new user with invalid password")
    public void registerNewUserWithInvalidPassword() {
        File json = new File(Constants.REQ_BODY_DIR+ "Register/InvalidPasswordReqBody.json");
        reqresAPI.registerUser(json);
    }

    @Given("Register new user with invalid email and password")
    public void registerNewUserWithInvalidEmailAndPassword() {
        File json = new File(Constants.REQ_BODY_DIR+ "Register/InvalidEmailAndPassword.json");
        reqresAPI.registerUser(json);
    }

    @Given("Register new user with empty password")
    public void registerNewUserWithEmptyPassword() {
        File json = new File(Constants.REQ_BODY_DIR+ "Register/EmptyPasswordReqBody.json");
        reqresAPI.registerUser(json);
    }

    @Given("Register new user with empty email")
    public void registerNewUserWithEmptyEmail() {
        File json = new File(Constants.REQ_BODY_DIR+ "Register/EmptyEmailReqBody.json");
        reqresAPI.registerUser(json);
    }
}
