//package br.com.barriga.steps;
//
//import cucumber.api.Scenario;
//import io.cucumber.java.After;
//import io.cucumber.java.pt.Dado;
//import io.cucumber.java.pt.Quando;
//import io.cucumber.java.pt.E;
//import io.cucumber.java.pt.Então;
//import org.apache.commons.io.FileUtils;
//import org.junit.Assert;
//import org.openqa.selenium.By;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import java.io.File;
//import java.io.IOException;
//
//
//public class AlterarContaSteps {
//    //incializando a variável
//    private WebDriver driver;
//
//    @Dado("que estou acessando a aplicação")
//    public void queEstouAcessandoAAplicação() {
//        driver = new ChromeDriver();
//        driver.get("https://seubarriga.wcaquino.me");
//    }
//
//    @Quando("informo o usuário {string}")
//    public void informoOUsuário(String string) {
//        driver.findElement(By.id("email")).sendKeys(string);
//
//    }
//
//    @Quando("a senha {string}")
//    public void aSenha(String string) {
//        driver.findElement(By.id("senha")).sendKeys(string);
//    }
//
//    @Quando("seleciono entrar")
//    public void selecionoEntrar() {
//        driver.findElement(By.tagName("button")).click();
//    }
//
//    @Então("visualizo a página inicial")
//    public void visualizoAPáginaInicial() {
//      String texto = driver.findElement(By.xpath("//body/footer[1]/span[1]")).getText();
//        Assert.assertEquals(texto,"Seu Barriga. Nunca mais esqueça de pagar o aluguel.reset");
//    }
//
//    @Quando("seleciono Contas")
//    public void selecionoContas() {
//        driver.findElement(By.xpath("//a[normalize-space()='Contas']")).click();
//    }
//
//    @Quando("seleciono Listar")
//    public void selecionoListar() {
//        driver.findElement(By.xpath("//a[normalize-space()='Listar']")).click();
//    }
//
//    @Quando("clico em alterar a {string}")
//    public void clicoEmAlterarA(String string) {
//        driver.findElement(By.xpath("//tbody/tr[td//text()[contains(., '"+ string +"')]]/td[2]/a[1]/span[1]")).click();
//    }
//
//    @Então("altero para {string}")
//    public void alteroPara(String string) {
//       driver.findElement(By.id("nome")).sendKeys(string);
//    }
//
//    @Quando("seleciono Salvar")
//    public void selecionoSalvar() {
//        driver.findElement(By.className("btn-group")).click();
//    }
//
//    @Então("recebo a {string} de alteração")
//    public void receboADeAlteração(String string) {
//        // pega o valor da div que comece com alerta alerta-
//        String texto = driver.findElement(By.xpath("//div[starts-with(@class,'alert alert-')]")).getText();
//        Assert.assertEquals(string, texto);
//    }
//
//    //tirando scrennshot a cada fim de cenário e nomeando com seu nome
//    //order define qual vai ser executado primeiro ou não
//    @After
//    public void screenshot(Scenario cenario) {
//        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        try {
//            FileUtils.copyFile(file, new File("target/screenshot/" + cenario.getName() + "." + cenario.getLines() + ".jpg"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    //executa depois de cada cenário > lembrar de importar o do cucumber
//    @After(order = 0)
//    public void fecharBrowser() {
//        driver.quit();
//    }
//}
