package br.com.nttdata.attributes;

import org.openqa.selenium.By;

public class AttributesProduto {
    public By precoDoProduto = By.xpath("(//div[@aria-label='new item price']//p[contains(text(),'R$')])[1]");
    public By botaoAdicionarNoCarrinho = By.xpath("//span[normalize-space()='Colocar no carrinho']");
}
