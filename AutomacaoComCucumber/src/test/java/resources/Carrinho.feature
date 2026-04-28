#encoding: utf-8
#language: pt

@FuncCarrinho
Funcionalidade: Colocar produto no carrinho de compras

  @CenarioCarrinho
  Cenario: Adicionar item ao carrinho com sucesso e verificar preço
    Dado que acesso o site "https://store.vivo.com.br/"
    E navego até a seção de Celulares
    E seleciono o segundo produto exibido
    E verifico o preço do produto
    Quando adiciono o produto ao carrinho
    Então o carrinho deve conter o item aicionado
    E o total do carrinho deve ser igual ao valor do produto