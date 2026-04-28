package br.com.nttdata.pages;

import br.com.nttdata.attributes.AttributesHome;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v85.page.Page;

public class PageHome extends AttributesHome {

    private WebDriver driver;

    public PageHome(WebDriver pdriver){
        this.driver = pdriver;
    }

    public void acessarSite(){
        driver.get("https://store.vivo.com.br/");
    }

    public void aceitarTermosDeUso(){
        driver.findElement(consentButton).click();
    }

    public void clicarNoMenuCelulares(){
        driver.findElement(menuCelulares).click();
    }
}
