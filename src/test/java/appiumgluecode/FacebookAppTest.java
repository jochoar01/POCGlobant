package appiumgluecode;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pages.FacebookRegisterPage;

import java.net.MalformedURLException;

public class FacebookAppTest {
    private AndroidDriver<AndroidElement> driver;
    FacebookRegisterPage app;


    @Given("^El usuario puede acceder a pagina principal de facebook$")
    public void el_usuario_puede_acceder_a_pagina_principal_de_facebook() throws MalformedURLException {

        app = new FacebookRegisterPage(driver);
        driver = app.appConection();
    }


    @When("^el usuario navega hasta la pagina de registro$")
    public void el_usuario_navega_hasta_la_pagina_de_registro() {

        app.go_to_register_page();
    }

    @Then("^diligencia formulario con valida letrero con \"([^\"]*)\" , \"([^\"]*)\" y \"([^\"]*)\"$")
    public void y_diligencia_formulario_con_valida_letrero_con_y(String nombre, String apellido, String fechaNacimiento) {

        app.fill_register_form(nombre, apellido, fechaNacimiento);
    }

    @Then("^como no se pudo identificar el field de Email entonces vamos a hacer una assertion del texto \"([^\"]*)\"$")
    public void como_no_se_pudo_identificar_el_field_de_Email_entonces_vamos_a_hacer_una_assertion_del_texto(String text) {

        app.identify_text_in_screen(text);
    }

}
