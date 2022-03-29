package br.com.barriga.page;

import br.com.barriga.core.BasePage;
import org.openqa.selenium.By;

public class HomePage extends BasePage {
    public String validacaoLogin(){
        return obterTexto(By.xpath("//body/footer[1]/span[1]"));
    }
}
