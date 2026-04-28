package br.com.nttdata.steps;

import br.com.nttdata.hooks.Hooks;
import br.com.nttdata.pages.PageCarrinho;
import br.com.nttdata.pages.PageCelulares;
import br.com.nttdata.pages.PageHome;
import br.com.nttdata.pages.PageProduto;
import br.com.nttdata.support.DriverManager;
import br.com.nttdata.support.ScreenshotUtil;
import com.aventstack.extentreports.Status;
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
        Hooks.getCurrentTest().log(Status.PASS, "Acessou o site: " + url, ScreenshotUtil.capture(DriverManager.getDriver()));
        home.aceitarTermosDeUso();
        Hooks.getCurrentTest().log(Status.PASS, "Aceitou os termos de uso: " + url, ScreenshotUtil.capture(DriverManager.getDriver()));

    }

    @E("navego até a seção de {string}")
    public void navegoAteASecaoDeCelulares(String menu) {
        new PageHome(DriverManager.getDriver()).clicarNoMenuCelulares();
        Hooks.getCurrentTest().log(Status.PASS, "Navegou até a seção: " + menu, ScreenshotUtil.capture(DriverManager.getDriver()));
    }

    @E("seleciono o segundo produto exibido")
    public void selecionoOSegundoProdutoExibido() {
        PageCelulares pageCelulares = new PageCelulares(DriverManager.getDriver());
        pageCelulares.fecharPopUpSeVisivel();
        pageCelulares.escolherSegundoAparelho();
        Hooks.getCurrentTest().log(Status.PASS, "Selecionou o segundo produto exibido", ScreenshotUtil.capture(DriverManager.getDriver()));
    }

    @E("verifico o preço do produto")
    public void verificoOPrecoDoProduto() {
        precoProduto = new PageProduto(DriverManager.getDriver()).retornarPrecoProduto();
        Hooks.getCurrentTest().log(Status.PASS, "Verificou o preço do produto: " + precoProduto, ScreenshotUtil.capture(DriverManager.getDriver()));

    }

    @Quando("adiciono o produto ao carrinho")
    public void adicionoOProdutoAoCarrinho() {
        new PageProduto(DriverManager.getDriver()).clicarBotaoAdicionarNoCarrinho();
        Hooks.getCurrentTest().log(Status.PASS, "Adicionou o produto ao carrinho", ScreenshotUtil.capture(DriverManager.getDriver()));

    }

    @Então("o carrinho deve conter o item aicionado")
    public void oCarrinhoDeveConterOItemAicionado() {
        boolean estaNoCarrinho = new PageCarrinho(DriverManager.getDriver()).verificaProdutoNoCarrinho();
        assertTrue("O produto deve estar visível no carrinho", estaNoCarrinho);
        Hooks.getCurrentTest().log(Status.PASS, "Produto está visível no carrinho", ScreenshotUtil.capture(DriverManager.getDriver()));
    }

    @E("o total do carrinho deve ser igual ao valor do produto")
    public void oTotalDoCarrinhoDeveSerIgualAoValorDoProduto() {
        String valorTotal = new PageCarrinho(DriverManager.getDriver()).capturarValorTotalDoCarrinho();
        assertEquals("O valor total do carrinho deve ser igual ao preço do produto", precoProduto, valorTotal);
        Hooks.getCurrentTest().log(Status.PASS, "Total do carrinho igual ao preço do produto: " + valorTotal, ScreenshotUtil.capture(DriverManager.getDriver()));

    }
}
