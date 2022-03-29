package br.com.barriga.page;

import br.com.barriga.core.BasePage;
import org.openqa.selenium.By;

public class MenuPage extends BasePage {

    public void adicionarConta() {
        clicarBotao(By.xpath("//a[normalize-space()='Contas']"));
        clicarBotao(By.xpath("//a[normalize-space()='Adicionar']"));
    }
    public void menuConta(){
        clicarBotao(By.xpath("//a[normalize-space()='Contas']"));
    }
    public void subMenuListar(){
        clicarBotao(By.xpath("//a[normalize-space()='Listar']"));
    }
    public void listarConta(){
        clicarBotao(By.xpath("//a[normalize-space()='Contas']"));
        clicarBotao(By.xpath("//a[normalize-space()='Listar']"));
    }
}
