package com.qaautomation.stepdefinitions;

import Page.FormBugsPages.FormsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.After;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class BugsFormSteps {
    private WebDriver driver;
    private FormsPage formsPage;

    @Given("el usuario se encuentra en la home de BugsForm")
    public void elUsuarioSeEncuentraEnLaHomeDeBugsForm() {
        ChromeOptions options = new ChromeOptions();

        String pathChromeDriver = System.getProperty("user.dir") + "\\src\\main\\driver\\chromedriver.exe";
        System.out.println("[Info] Ruta driver: " + pathChromeDriver);
        System.setProperty("webdriver.chrome.driver", pathChromeDriver);

        options.addArguments("start-maximized");
        options.addArguments("incognito");
        options.setPageLoadTimeout(Duration.ofSeconds(60));

        driver = new ChromeDriver(options);
        driver.get("https://qa-practice.netlify.app/bugs-form");
        this.formsPage = new FormsPage(driver);
    }

    @When("el usuario ingresa First Name {string}")
    public void elUsuarioIngresaFirstName(String nombre) {
        this.formsPage.enviarFirstName(nombre);
    }

    @And("el usuario ingresa Last Name {string}")
    public void elUsuarioIngresaLastName(String apellido) {
        this.formsPage.enviarLastName(apellido);
    }

    @And("el usuario ingresa Phone number {string}")
    public void elUsuarioIngresaPhoneNumber(String telefono) {
        this.formsPage.enviarPhoneNumber(telefono);
    }

    @And("el usuario ingresa Country {string}")
    public void elUsuarioIngresaCountry(String pais) {
        // Si no se usa, podés dejarlo vacío o completarlo si en el futuro hacés algo con el campo.
    }

    @And("el usuario ingresa Email address {string}")
    public void elUsuarioIngresaEmailAddress(String email) {
        this.formsPage.enviarEmail(email); // Antes lo tenías con comillas, eso lo hacía incorrecto
    }

    @And("el usuario ingresa Password {string}")
    public void elUsuarioIngresaPassword(String password) {
        this.formsPage.enviarPassword(password); // Mismo caso: sin comillas
    }

    @And("el usuario hace clic boton Register")
    public void elUsuarioHaceClicBotonRegister() {
        this.formsPage.clicBtnRegister();
    }

    @Then("el usuario visualiza el mensaje {string}")
    public void elUsuarioVisualizaElMensaje(String msjEsperado) {
        String msjRecuperado = this.formsPage.verLblRegister();
        Assert.assertEquals("[Error] El mensaje no es lo esperado", msjEsperado, msjRecuperado);
    }

    @Then("el usuario visualiza el mensaje de ayuda de contraseña {string}")
    public void elUsuarioVisualizaElMensajeDeAyudaDeContrasena(String mensajeEsperado) {
        String mensajeAyudaRecuperado = this.formsPage.getPasswordHelpMessage();
        Assert.assertEquals("[Error] El mensaje de ayuda no es el esperado", mensajeEsperado, mensajeAyudaRecuperado);
    }

    @Then("el usuario visualiza el mensaje de ayuda obligatorio {string}")
    public void elUsuarioVisualizaElMensajeDeAyudaObligatorio(String mensajeEsperado) {
        String mensajeAyudaRecuperado = this.formsPage.getMandatoryMessage();
        Assert.assertEquals("[Error] El mensaje de ayuda no es el esperado", mensajeEsperado, mensajeAyudaRecuperado);
    }

    @Then("el usuario visualiza el mensaje de ayuda de teléfono {string}")
    public void elUsuarioVisualizaElMensajeDeAyudaDeTelefono(String mensajeEsperado) {
        String mensajeAyudaRecuperado = this.formsPage.getPhoneHelpMessage();
        Assert.assertEquals("[Error] El mensaje de ayuda no es el esperado", mensajeEsperado, mensajeAyudaRecuperado);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("[Info] El navegador se cerró correctamente.");
        }
    }
}
