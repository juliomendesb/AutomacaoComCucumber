package br.com.nttdata.steps;

import br.com.nttdata.pages.PageCarrinho;
import br.com.nttdata.pages.PageCelulares;
import br.com.nttdata.pages.PageHome;
import br.com.nttdata.pages.PageProduto;
import br.com.nttdata.support.DriverManager;
import io.cucumber.java.PendingException;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StoreVivoSteps {

    String precoProduto = "";

    @Dado("que acesso o site {string}")
    public void queAcessoOSite(String url) {
        PageHome home = new PageHome(DriverManager.getDriver());
        home.acessarSite();
        home.aceitarTermosDeUso();
    }

    @E("navego até a seção de Celulares")
    public void navegoAteASecaoDeCelulares() {
        new PageHome(DriverManager.getDriver()).clicarNoMenuCelulares();
    }

    @E("seleciono o segundo produto exibido")
    public void selecionoOSegundoProdutoExibido() {
        PageCelulares pageCelulares = new PageCelulares(DriverManager.getDriver());
        pageCelulares.fecharPopUpSeVisivel();
        pageCelulares.escolherSegundoAparelho();
    }

    @E("verifico o preço do produto")
    public void verificoOPrecoDoProduto() {
        precoProduto = new PageProduto(DriverManager.getDriver()).retornarPrecoProduto();
    }

    @Quando("adiciono o produto ao carrinho")
    public void adicionoOProdutoAoCarrinho() {
        new PageProduto(DriverManager.getDriver()).clicarBotaoAdicionarNoCarrinho();
    }

    @Então("o carrinho deve conter o item aicionado")
    public void oCarrinhoDeveConterOItemAicionado() {
        boolean estaNoCarrinho = new PageCarrinho(DriverManager.getDriver()).verificaProdutoNoCarrinho();
        assertTrue("O produto deve estar visível no carrinho", estaNoCarrinho);
    }

    @E("o total do carrinho deve ser igual ao valor do produto")
    public void oTotalDoCarrinhoDeveSerIgualAoValorDoProduto() {
        String valorTotal = new PageCarrinho(DriverManager.getDriver()).capturarValorTotalDoCarrinho();
        assertEquals("O valor total do carrinho deve ser igual ao preço do produto", precoProduto, valorTotal);
    }
}
