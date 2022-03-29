package br.com.barriga.steps;

import br.com.barriga.core.BasePage;
import br.com.barriga.page.ContasPage;
import br.com.barriga.page.HomePage;
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
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import static br.com.barriga.core.DriverFactory.getDriver;
import static br.com.barriga.core.DriverFactory.killDriver;

public class AlterarContaSteps extends BasePage {

    private LoginPage loginPage = new LoginPage();
    private HomePage homePage = new HomePage();
    private MenuPage menuPage = new MenuPage();
    private ContasPage contasPage = new ContasPage();

    @Dado("que estou acessando a aplicação")
    public void queEstouAcessandoAAplicação() {
        loginPage.acessaAplicacao();
    }

    @Quando("informo o usuário {string}")
    public void informoOUsuário(String string) {
        loginPage.setEmail(string);
    }

    @Quando("a senha {string}")
    public void aSenha(String string) {
        loginPage.setSenha(string);
    }

    @Quando("seleciono entrar")
    public void selecionoEntrar() {
        loginPage.logar();
    }

    @Então("visualizo a página inicial")
    public void visualizoAPáginaInicial() {
        String texto = homePage.validacaoLogin();
        Assert.assertEquals(texto, "Seu Barriga. Nunca mais esqueça de pagar o aluguel.reset");
    }

    @Quando("seleciono Contas")
    public void selecionoContas() {
        menuPage.menuConta();
    }

    @Quando("seleciono Listar")
    public void selecionoListar() {
        menuPage.subMenuListar();
    }

    @Quando("clico em alterar a {string}")
    public void clicoEmAlterarA(String string) {
        contasPage.clicarBotaoAlterar(string);
    }

    @Então("altero para {string}")
    public void alteroPara(String string) {
        contasPage.alterarNome(string);
    }

    @Quando("seleciono Salvar")
    public void selecionoSalvar() {
        contasPage.salvar();
    }

    @Então("recebo a {string} de alteração")
    public void receboADeAlteração(String string) {
        // pega o valor da div que comece com alerta alerta-
        String texto = contasPage.obterMensagemSucesso();
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
