package br.com.barriga.page;

import br.com.barriga.core.BasePage;
import org.openqa.selenium.By;

import static br.com.barriga.core.DriverFactory.getDriver;

public class LoginPage extends BasePage {

    public void acessaAplicacao() {
        getDriver().get("https://seubarriga.wcaquino.me");
    }
    public void setEmail (String email){
        escrever("email", email);
    }
    public void setSenha (String senha){
        escrever("senha", senha);
    }
    public void logar (){
        clicarBotaoPorTexto("Entrar");
    }

}
