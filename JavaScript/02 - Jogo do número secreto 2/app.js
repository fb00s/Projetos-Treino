let listaNumerosSorteados = [];
let tentativas = 1;
let numeroMaximo = 5;
let numeroSecreto = gerarNumeroAleatorio();

function exibirTextoNaTela(tag, texto){
    let campo = document.querySelector(tag);
    campo.innerHTML = texto;
}

function exibirMensagemInicial(){
    exibirTextoNaTela('h1', 'Jogo do número secreto');
    let paragrafoInicial = `Escolha um número entre 1 e ${numeroMaximo}`;
    exibirTextoNaTela('p', paragrafoInicial);
}

exibirMensagemInicial();

function verificarChute(){
    let chute = document.querySelector('input').value;

    if (chute == numeroSecreto){
        exibirTextoNaTela('h1', 'Acertou!');
        let palavraTentativas = tentativas > 1 ? 'tentativas' : 'tentativa';
        let mensagemTentativas = `Você descobriu o número secreto (${numeroSecreto}) em ${tentativas} ${palavraTentativas}`;
        exibirTextoNaTela('p', mensagemTentativas);
        habilitarBotao('reiniciar');
        desabilitarBotao('chutar');
    } else {
        if (chute > numeroSecreto){
            let mensagemMenor = `O número secreto é menor que ${chute}`;
            exibirTextoNaTela('h1', mensagemMenor);
        } else {
            let mensagemMaior = `O número secreto é maior que ${chute}`;
            exibirTextoNaTela('h1', mensagemMaior);
        }
        tentativas++;
        limparCampo();
    }
}

function gerarNumeroAleatorio(){
    let numeroSorteado = parseInt(Math.random() * numeroMaximo + 1);
    let tamanhoLista = listaNumerosSorteados.length;

    if (tamanhoLista == numeroMaximo){
        listaNumerosSorteados = [];
    }

    if (listaNumerosSorteados.includes(numeroSorteado)){
        return gerarNumeroAleatorio();
    } else {
        listaNumerosSorteados.push(numeroSorteado);
        console.log(listaNumerosSorteados);
        return numeroSorteado;
    }
}

function limparCampo(){
    chute = document.querySelector('input');
    chute.value = '';
}

function habilitarBotao(id){
    document.getElementById(id).removeAttribute('disabled');
}

function desabilitarBotao(id){
    document.getElementById(id).setAttribute('disabled', true);
}

function reiniciarJogo(){
    tentativas = 1;
    numeroSecreto = gerarNumeroAleatorio();
    exibirMensagemInicial();
    limparCampo();
    habilitarBotao('chutar');
    desabilitarBotao('reiniciar');
}
