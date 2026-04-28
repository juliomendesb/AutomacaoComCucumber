package br.com.nttdata.pages;

import br.com.nttdata.attributes.AttributesCarrinho;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class PageCarrinho extends AttributesCarrinho {

    private WebDriver driver;

    public PageCarrinho(WebDriver pdriver){
        this.driver = pdriver;
    }

    public boolean verificaProdutoNoCarrinho(){
        WebDriverWait espera = new WebDriverWait(driver, Duration.ofSeconds(30));
        return espera.until(ExpectedConditions.visibilityOfElementLocated(produtoNoCarrinho)).isDisplayed();
    }

    public String capturarValorTotalDoCarrinho(){
        String precoTotal = driver.findElement(valorTotalDoCarrinho).getText();
        System.out.println("Valor total do carrinho é: " + precoTotal);
        return precoTotal;
    }

}
