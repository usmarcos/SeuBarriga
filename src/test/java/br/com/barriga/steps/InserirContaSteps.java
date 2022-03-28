package br.com.barriga.steps;

import cucumber.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Então;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class InserirContaSteps {
    //incializando a variável
    private WebDriver driver;

    @Dado("^que desejo adicionar uma conta$")
    public void queDesejoAdicionarUmaConta() {
        driver = new ChromeDriver();
        driver.get("https://seubarriga.wcaquino.me");
        driver.findElement(By.id("email")).sendKeys("us@us.com");
        driver.findElement(By.id("senha")).sendKeys("us");
        driver.findElement(By.tagName("button")).click();
        driver.findElement(By.linkText("Contas")).click();
        driver.findElement(By.linkText("Adicionar")).click();
    }
    @Quando("^adiciono a \"([^\"]*)\"$")
    public void adicionoA(String arg1) {
        driver.findElement(By.id("nome")).sendKeys(arg1);
        driver.findElement(By.tagName("button")).click();

    }

    @Então("^recebo a \"([^\"]*)\"$")
    public void receboA(String arg1) {
        // pega o valor da div que comece com alerta alerta-
        String texto = driver.findElement(By.xpath("//div[starts-with(@class,'alert alert-')]")).getText();
        Assert.assertEquals(arg1, texto);
    }

    //tirando scrennshot a cada fim de cenário e nomeando com seu nome
    //order define qual vai ser executado primeiro ou não
    @After(order = 1)
    public void screenshot(Scenario cenario) {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File("target/screenshot/" + cenario.getName() + "." + cenario.getLines() + ".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //executa depois de cada cenário > lembrar de importar o do cucumber
    @After(order = 0)
    public void fecharBrowser() {
        driver.quit();
    }
}
