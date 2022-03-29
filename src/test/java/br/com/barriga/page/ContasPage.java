package br.com.barriga.page;

import br.com.barriga.core.BasePage;
import org.openqa.selenium.By;

import static br.com.barriga.core.DriverFactory.getDriver;

public class ContasPage extends BasePage {

    public void setNome(String nome){
        escrever("nome", nome);
    }
    public void salvar (){
        clicarBotaoPorTexto("Salvar");
    }
    public String obterMensagemSucesso(){
        return obterTexto(By.xpath("//div[starts-with(@class,'alert alert-')]"));
    }
    public void clicarBotaoAlterar(String nome){

//        clicarBotao(By.xpath("//tbody/tr[td//text()[contains(., '"+nome+"')]]/td[2]/a[1]/span[1]"));
//        clicarBotaoTabela("Conta", nome, "Ações", "tabelaContas"); para esse deve passar o local para clicar no método clicarBotaoTabela
        obterCelula("Conta", nome, "Ações", "tabelaContas")
                .findElement(By.xpath(".//span[@class='glyphicon glyphicon-edit']")).click();
    }
    public void alterarNome(String nome){
        escrever("nome", nome);
    }

}
