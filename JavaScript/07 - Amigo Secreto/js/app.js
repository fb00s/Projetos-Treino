let listaAmigos = [];
let amigosSorteados;

function adicionar(){
    let nomeAmigo = document.getElementById('nome-amigo').value;
    if(nomeAmigo.trim().length == 0){
        alert('O campo "Nome do amigo" não pode ficar em branco');
        return;
    }

    if(listaAmigos.includesIgnoreCase(nomeAmigo)){
        alert(`O amigo ${nomeAmigo} já foi adicionado`);
        return;
    }

    listaAmigos.push(nomeAmigo);
    document.getElementById('nome-amigo').value = '';

    let campoLista = document.getElementById('lista-amigos');

    if (campoLista.textContent == ''){
        campoLista.textContent = nomeAmigo;
    } else {
        campoLista.textContent += ', ' + nomeAmigo;
    }
}

function sortear(){
    if (listaAmigos.length < 4){
        alert('Adicione pelo menos quatro amigos para fazer o sorteio');
        return;
    }
    let amigoAleatorio;

    amigosSorteados = [];

    //Popula a lista amigosSorteados com os mesmos itens que a listaAmigos, porém embaralhados
    for (let i = 0; i < listaAmigos.length; i++){
        do{
            //Retorna um amigo aleatorio
            amigoAleatorio = listaAmigos[parseInt(Math.random() * listaAmigos.length)];

        } while(amigosSorteados.includes(amigoAleatorio)); //Gera novamente caso o amigo sorteado já tenha sido sorteado anteriormente

        amigosSorteados.push(amigoAleatorio);
    }

    let campoSorteados = document.getElementById('lista-sorteio');
    campoSorteados.innerHTML = '';

    for (let i = 0; i < amigosSorteados.length; i++){
        if (i == amigosSorteados.length - 1){
            campoSorteados.innerHTML += `<p>${amigosSorteados[i]} => ${amigosSorteados[0]}</p>`;
        } else {
            campoSorteados.innerHTML += `<p>${amigosSorteados[i]} => ${amigosSorteados[i + 1]}</p>`;
        }
    }   
}

function reiniciar(){
    listaAmigos = [];
    document.getElementById('lista-sorteio').innerHTML = '';
    document.getElementById('lista-amigos').innerHTML = '';
    document.getElementById('nome-amigo').value = '';
}