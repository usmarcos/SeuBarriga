package br.com.barriga.steps;

import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Quando;
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
//    @Dado("^que estou acessando a aplicação$")
//    public void queEstouAcessandoAAplicação() {
//        driver = new ChromeDriver();
//        driver.get("https://seubarriga.wcaquino.me");
//    }
//
//    @Quando("^informo o usuário \"([^\"]*)\"$")
//    public void informoOUsuário(String arg1) {
//        driver.findElement(By.id("email")).sendKeys(arg1);
//    }
//
//    @Quando("^a senha \"([^\"]*)\"$")
//    public void aSenha(String arg1) {
//        driver.findElement(By.id("senha")).sendKeys(arg1);
//    }
//
//    @Quando("^seleciono entrar$")
//    public void selecionoEntrar() {
//        driver.findElement(By.tagName("button")).click();
//    }
//
//    @Então("^visualizo a página inicial$")
//    public void visualizoAPáginaInicial() {
//        // Write code here that turns the phrase above into concrete actions
//        String texto = driver.findElement(By.xpath("//div[contains(text(),'Bem vindo, usmarcos!')]")).getText();
//        Assert.assertEquals("Bem vindo, usmarcos!",texto);
//    }
//
//    @Quando("^seleciono Contas$")
//    public void selecionoContas() {
//        driver.findElement(By.linkText("Contas")).click();
//    }
//
//    @Quando("^seleciono Adicionar$")
//    public void selecionoAdicionar() {
//        driver.findElement(By.linkText("Adicionar")).click();
//    }

    @Quando("^adiciono a \"([^\"]*)\"$")
    public void adicionoA(String arg1) {
        driver.findElement(By.id("nome")).sendKeys(arg1);
        driver.findElement(By.tagName("button")).click();

    }

//    @Quando("^informo a \"([^\"]*)\"$")
//    public void informoAConta(String arg1) {
//        driver.findElement(By.id("nome")).sendKeys(arg1);
//    }
//
//    @Quando("^seleciono Salvar$")
//    public void selecionoSalvar() {
//        driver.findElement(By.tagName("button")).click();
//    }

    /*DEPOIS DA IMPLEMENTAÇÃO DO ESQUEMA NÃO FOI MAIS NECESSÁRIO
     * */
//    @Então("^a conta é inserida com sucesso$")
//    public void aContaÉInseridaComSucesso() {
//        String texto = driver.findElement(By.xpath("//div[contains(text(),'Conta adicionada com sucesso!')]")).getText();
//        Assert.assertEquals("Conta adicionada com sucesso!", texto);
//    }
//    //SEGUNDO CENÁRIO
//    @Então("^sou notificado que o nome da conta é obrigatório$")
//    public void souNotificadoQueONomeDaContaÉObrigatório() {
//        String texto = driver.findElement(By.xpath("//div[contains(text(),'Informe o nome da conta')]")).getText();
//        Assert.assertEquals("Informe o nome da conta", texto);
//    }
//    //TERCEIRO CENÁRIO
//    @Então("^sou notificado que já existe uma conta com esse nome$")
//    public void souNotificadoQueJáExisteUmaContaComEsseNome() {
//        String texto = driver.findElement(By.xpath("//div[contains(text(),'Já existe uma conta com esse nome!')]")).getText();
//        Assert.assertEquals("Já existe uma conta com esse nome!", texto);
//    }

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
