package br.com.barriga.steps;

import br.com.barriga.core.BasePage;
import br.com.barriga.page.ContasPage;
import br.com.barriga.page.LoginPage;
import br.com.barriga.page.MenuPage;
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

public class InserirContaSteps extends BasePage {

    private LoginPage loginPage = new LoginPage();
    private MenuPage menuPage = new MenuPage();
    private ContasPage contasPage = new ContasPage();

    @Dado("^que desejo adicionar uma conta$")
    public void queDesejoAdicionarUmaConta() {
        loginPage.acessaAplicacao();
        loginPage.setEmail("us@us.com");
        loginPage.setSenha("us");
        loginPage.logar();
        menuPage.adicionarConta();
    }

    @Quando("^adiciono a \"([^\"]*)\"$")
    public void adicionoA(String arg1) {
        contasPage.setNome(arg1);
        contasPage.salvar();
    }

    @Então("^recebo a \"([^\"]*)\"$")
    public void receboA(String arg1) {
        String texto = contasPage.obterMensagemSucesso();
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
    public void fecharBrowser() {
        killDriver();
    }
}
