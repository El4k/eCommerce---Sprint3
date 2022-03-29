# <h1 align="center"> Loja Virtual - Pear Compass </h1>

<p align="center">
<img src="http://img.shields.io/static/v1?label=STATUS&message=%20Concluido&color=GREEN&style=for-the-badge"/>
</p>

# <h2> Descrição sobre o Projeto </h2>
O projeto realizado buscou resolver os problemas de um ecommerce fictício (Pear Compass LTDA) a fim de demonstrar as habilidades dos colaboradores em uma avaliação para o estágio.

Informações sobre a empresa:
A empresa Pear Compass LTDA quer expandir seu negócio para o mundo digital, dessa forma, foi requisitado a criação de um web site para venda dos seus produtos de tecnologia. O CEO Toninho solicitou que tal web site tenha a implementação de:
- `Autenticação do usuário logado`
- `Listagem de todos os seus produtos disponíveis em uma tela bem formatada`
- `Carrinho de compras, onde o usuário possa selecionar e comprar os produtos escolhidos por ele`

## 🔨 Funcionalidades do projeto

- `Funcionalidade 1` `Entrada do Site`: Em nosso projeto web o usuário primeiramente irá acessar a tela de Entrada na qual será carregado todos os produtos que estão em nosso banco de dados. Não é necessário que o usuário tenha realizado o login porém, temos botões com imagens para que ele possa fazer o login caso necessário, também temos um botão do carrinho de compras que mostra todos os produtos que foram adicionados pelo usuário, caso o usuário esteja logado irá aparecer um botão com imagem extra que é o botão para a realização do logout e o antigo botão de login se transforma no botão de visualizar as informações do usuário.

- `Funcionalidade 2` `Login do Usuário`: Em nosso projeto web buscamos trazer a realidade, ou seja, para que o usuário realize a compra é necessário que ele esteja logado, há diversas formas de acessar a página para realizar o login do usuário sendo elas: botão na tela de entrada & botão no carrinho de compras. O nosso login do usuário fará uma busca do login e da senha colocados nos campos para com o nosso banco de dados a fim de verificarmos se os dados realmente existem e estão corretos.

- `Funcionalidade 3` `Cadastramento`: Em nosso projeto web buscamos realizar o cadastramento de login e senha e também fazemos a busca de um CEP existente assim como ocorre em lojas virtuais reais, tanto o cadastramento quanto o atualizar usuário utiliza lógicas similares, um formulário com linkagem com a API VIA CEP.

- `Funcionalidade 4` `Carrinho de Compras`: Em nosso projeto web o carrinho de compras é peça essencial pois, toda a interação dos produtos com usuário serão visualizadas no carrinho de compras, quando o usuário (logado ou não) adiciona um produto no carrinho (caso o produto tenha no estoque) automaticamente será enviado o mesmo produto para o carrinho de compras, também é possível remover os produtos do carrinho assim como em uma loja virtual real, tal funcionalidade é acessada por um ícone (botão com figura) em todo nosso site através do header.

- `Funcionalidade 5` `Finalizar Compra`: Em nosso projeto web o finalizar compra é o caminho final do pedido do usuário, essa funcionalidade é acessada pelo carrinho de compras, caso o usuário queira acessar sem estar logado ele será redirecionado para a tela de login, assim que foi realizado o login, será automaticamente realizado a compra dos produtos e o pedido é finalizado, caso o usuário esteja logado apenas é realizado a compra e o pedido é finalizado. Assim que a compra é realizada, é mostrado todos os dados do usuário com o valor do frete, prazo de entrega e o preço total dos produtos, é válido ressaltar que obtivemos o valor do frete e do prazo de entrega através da API dos CORREIOS.

## 📁 Acesso ao projeto

**Você pode <a href="https://github.com/El4k/ecommerce">acessar o código fonte do projeto inicial</a> ou <a href="https://github.com/El4k/ecommerce/archive/refs/heads/main.zip">baixá-lo</a>.**

## 🛠️ Abrir e rodar o projeto

- **Open an Existing Project** (ou alguma opção similar)
- Procure o local onde o projeto está e o selecione (Caso o projeto seja baixado via zip, é necessário extraí-lo antes de procurá-lo)
- Por fim clique em OK
- É necessário uma conexão com o MySQL Workbench para que seja utilizado o banco de dados que está integrado ao nosso projeto. (Atualize o persistence com seus dados)
- **Caso já tenha o MySQL instalado** utilize o seguinte <a href="https://drive.google.com/file/d/1DoYIqmDkWx-Ur65aYaAz3azBGx7N0YJN/view?usp=sharing">SQL<a/>.

## ✔️ Técnicas e tecnologias utilizadas

- ``Java 11``
- ``Eclipse``
- ``Paradigma de orientação a objetos``

## Autores

| [<img src="https://avatars.githubusercontent.com/u/57332066?v=4" width=115><br><sub>Emílio Araújo de Lima</sub>](https://github.com/El4k) |  [<img src="https://avatars.githubusercontent.com/u/71047456?v=4" width=115><br><sub>Alexandre Abib</sub>](https://github.com/AleAbib) |  [<img src="https://avatars.githubusercontent.com/u/97471753?v=4" width=115><br><sub>Pedro</sub>](https://github.com/PedroHND) |
| :---: | :---: | :---: |
