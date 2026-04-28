package br.com.nttdata.pages;

import br.com.nttdata.attributes.AttributesProduto;
import org.openqa.selenium.WebDriver;

public class PageProduto extends AttributesProduto {
    private WebDriver driver;

    public PageProduto(WebDriver pdriver){
        this.driver = pdriver;
    }

    public String retornarPrecoProduto(){
         String precoProduto = driver.findElement(precoDoProduto).getText();
        System.out.println(precoProduto);
         return precoProduto;
    }

    public void clicarBotaoAdicionarNoCarrinho(){
        driver.findElement(botaoAdicionarNoCarrinho).click();
    }
}
