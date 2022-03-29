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
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

import static br.com.barriga.core.DriverFactory.getDriver;
import static br.com.barriga.core.DriverFactory.killDriver;

public class AlterarContaSteps {
    //incializando a variável
    private WebDriver driver;

    @Dado("que estou acessando a aplicação")
    public void queEstouAcessandoAAplicação() {
        getDriver().get("https://seubarriga.wcaquino.me");
    }

    @Quando("informo o usuário {string}")
    public void informoOUsuário(String string) {
        getDriver().findElement(By.id("email")).sendKeys(string);

    }

    @Quando("a senha {string}")
    public void aSenha(String string) {
        getDriver().findElement(By.id("senha")).sendKeys(string);
    }

    @Quando("seleciono entrar")
    public void selecionoEntrar() {
        getDriver().findElement(By.tagName("button")).click();
    }

    @Então("visualizo a página inicial")
    public void visualizoAPáginaInicial() {
        String texto = getDriver().findElement(By.xpath("//body/footer[1]/span[1]")).getText();
        Assert.assertEquals(texto, "Seu Barriga. Nunca mais esqueça de pagar o aluguel.reset");
    }

    @Quando("seleciono Contas")
    public void selecionoContas() {
        getDriver().findElement(By.xpath("//a[normalize-space()='Contas']")).click();
    }

    @Quando("seleciono Listar")
    public void selecionoListar() {
        getDriver().findElement(By.xpath("//a[normalize-space()='Listar']")).click();
    }

    @Quando("clico em alterar a {string}")
    public void clicoEmAlterarA(String string) {
        getDriver().findElement(By.xpath("//tbody/tr[td//text()[contains(., '" + string + "')]]/td[2]/a[1]/span[1]")).click();
    }

    @Então("altero para {string}")
    public void alteroPara(String string) {
        getDriver().findElement(By.id("nome")).sendKeys(string);
    }

    @Quando("seleciono Salvar")
    public void selecionoSalvar() {
        getDriver().findElement(By.className("btn-group")).click();
    }

    @Então("recebo a {string} de alteração")
    public void receboADeAlteração(String string) {
        // pega o valor da div que comece com alerta alerta-
        String texto = getDriver().findElement(By.xpath("//div[starts-with(@class,'alert alert-')]")).getText();
        Assert.assertEquals(string, texto);
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
    public void fecharBrowser() {
        killDriver();
    }

}
