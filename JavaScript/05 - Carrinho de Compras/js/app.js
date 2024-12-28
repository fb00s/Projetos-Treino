let valorTotal = 0;
document.getElementById('lista-produtos').innerHTML = '';
document.getElementById('valor-total').innerHTML = `R$ 0`;

function adicionar(){
  //recuperar valores de nome, quantidade e valor
  let produto = document.getElementById('produto').value;
  let nomeProduto = produto.split('-')[0];
  let quantidade = parseInt(document.getElementById('quantidade').value);
  let valorUnitario = parseInt(produto.split('R$')[1]);
  //calcular preço subtotal
  let subtotal = quantidade * valorUnitario;

  let carrinho = document.getElementById('lista-produtos');

  //adicionar no carrinho
  carrinho.innerHTML += `<section class="carrinho__produtos__produto"> <span class="texto-azul">${quantidade}x</span> ${nomeProduto} <span class="texto-azul">R$${valorUnitario}</span> </section>`

  //atualizar o valor total
  valorTotal += subtotal;
  document.getElementById('valor-total').innerHTML = `R$ ${valorTotal}`;
}

function limpar(){
  valorTotal = 0;
  document.getElementById('lista-produtos').innerHTML = '';
  document.getElementById('valor-total').innerHTML = `R$ 0`;
}