function comprar(){
    let tipoIngresso = document.getElementById('tipo-ingresso').value;
    let quantidadeComprada = document.getElementById('qtd').value;
    let campoQuantidadeDisponivel = document.getElementById(`qtd-${tipoIngresso}`);
    let quantidadeDisponivel = campoQuantidadeDisponivel.innerHTML;

    if (quantidadeDisponivel - quantidadeComprada < 0){
        alert(`Quantidade indisponível para o tipo ${tipoIngresso}`);
        return;
    }
    campoQuantidadeDisponivel.innerHTML = quantidadeDisponivel - quantidadeComprada; 
}