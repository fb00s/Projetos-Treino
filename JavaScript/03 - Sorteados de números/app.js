function sortear(){
    let quantidade = parseInt(document.getElementById('quantidade').value);
    let de = parseInt(document.getElementById('de').value);
    let ate = parseInt(document.getElementById('ate').value);

    let listaNumeros = [];
    let numero;

    if (de >= ate){
        alert('O campo "Do Número" deve ser inferior ao campo "Até o número."');
        return;
    }

    if ((ate - de + 1) < quantidade){
        alert('O campo "Quantidade" deve ser menor ou igual ao intervalo informado pelos campos "Do número" e "Até o número. Diminua a quantidade ou aumente o intervalo.');
        return;
    }

    for (let i = 0; i < quantidade; i++){
        numero = gerarNumeroAleatorio(de, ate);

        while (listaNumeros.includes(numero)){
            numero = gerarNumeroAleatorio(de, ate);
        }

        listaNumeros.push(numero);
    }

    let resultado = document.getElementById('resultado');
    resultado.innerHTML = `<label class="texto__paragrafo">Números sorteados: ${listaNumeros}</label>`;

    alterarStatusBotao('btn-sortear');
    alterarStatusBotao('btn-reiniciar');
}

function gerarNumeroAleatorio(min, max){
    return parseInt(Math.random() * (max - min + 1) + min);
}

function alterarStatusBotao(id){
    let botao = document.getElementById(id);

    if (botao.classList.contains('container__botao-desabilitado')){
        botao.classList.remove('container__botao-desabilitado');
        botao.classList.add('container__botao');
    } else {
        botao.classList.remove('container__botao');
        botao.classList.add('container__botao-desabilitado');
    }
}

function reiniciar(){
    document.getElementById('quantidade').value = '';
    document.getElementById('de').value = '';
    document.getElementById('ate').value = '';
    document.getElementById('resultado').innerHTML = '<label class="texto__paragrafo">Números sorteados:  nenhum até agora</label>';
    alterarStatusBotao('btn-sortear');
    alterarStatusBotao('btn-reiniciar');
}
