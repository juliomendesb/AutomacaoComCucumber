package br.com.nttdata.pages;

import br.com.nttdata.attributes.AttributesCelulares;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageCelulares extends AttributesCelulares {
    private WebDriver driver;

    public PageCelulares(WebDriver pdriver){
        this.driver = pdriver;
    }

    public void escolherSegundoAparelho(){
        driver.findElement(segundoCelular).click();
    }

    public void fecharPopUpSeVisivel(){
        WebElement elementoPopUpPromocao = driver.findElement(popUpPromocao);

        if(elementoPopUpPromocao.isDisplayed()){
            elementoPopUpPromocao.click();
        }
    }
}
