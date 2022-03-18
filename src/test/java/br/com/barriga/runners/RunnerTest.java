package br.com.barriga.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

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
        snippets = SnippetType.CAMELCASE,
        dryRun = false // True - ele apenas valida o mapeamento e não executa os testes
)
public class RunnerTest {

}