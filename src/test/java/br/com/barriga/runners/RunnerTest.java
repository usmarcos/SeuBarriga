package br.com.barriga.runners;


import cucumber.api.Scenario;
import io.cucumber.java.AfterStep;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/", //mapeia as features
        glue = "br.com.barriga.steps", //mapeia as steps
        //entre chaves executa essa tag ou outra após a virgula
        tags = {"not @ignore"}, //se colocar apenas a tag só irá executar este e com o "not" ele ignora a tag
        //mostra as descrições na hora de executar, como um relatório
        //cria relatório em html no target
        plugin = {"pretty", "html:target/report.html", "json:target/report.json"},
        monochrome = false, //cor nas descrições
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        dryRun = false // True - ele apenas valida o mapeamento e não executa os testes
)
public class RunnerTest {
    //reseta o BD antes de execuação a aplicação
    static WebDriver driver = new ChromeDriver();

    @BeforeClass
    public static void reset() {

        driver.get("https://seubarriga.wcaquino.me/");
        driver.findElement(By.id("email")).sendKeys("us@us.com");
        driver.findElement(By.id("senha")).sendKeys("us");
        driver.findElement(By.tagName("button")).click();
        driver.findElement(By.linkText("reset")).click();
        driver.quit();
    }

}