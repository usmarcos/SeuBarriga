package br.com.barriga.steps;

import cucumber.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

import static br.com.barriga.core.DriverFactory.getDriver;
import static br.com.barriga.core.DriverFactory.killDriver;

public class InserirContaSteps {

    @Dado("^que desejo adicionar uma conta$")
    public void queDesejoAdicionarUmaConta() {
        getDriver().get("https://seubarriga.wcaquino.me");
        getDriver().findElement(By.id("email")).sendKeys("us@us.com");
        getDriver().findElement(By.id("senha")).sendKeys("us");
        getDriver().findElement(By.tagName("button")).click();
        getDriver().findElement(By.linkText("Contas")).click();
        getDriver().findElement(By.linkText("Adicionar")).click();
    }

    @Quando("^adiciono a \"([^\"]*)\"$")
    public void adicionoA(String arg1) {
        getDriver().findElement(By.id("nome")).sendKeys(arg1);
        getDriver().findElement(By.tagName("button")).click();

    }

    @Então("^recebo a \"([^\"]*)\"$")
    public void receboA(String arg1) {
        // pega o valor da div que comece com alerta alerta-
        String texto = getDriver().findElement(By.xpath("//div[starts-with(@class,'alert alert-')]")).getText();
        Assert.assertEquals(arg1, texto);
    }

    //tirando scrennshot a cada fim de cenário e nomeando com seu nome
    //order define qual vai ser executado primeiro ou não
    @After(order = 1)
    public void screenshot(Scenario cenario) throws InterruptedException {
        File file = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File("target/screenshot/" + cenario.getName() + "." + cenario.getLines() + ".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @After(order = 0)
    public void fecharBrowser(){
        killDriver();
    }
}
