console.log('app runnin m8');
const URL = 'https://lab01-projsw-ufcg.herokuapp.com/api/disciplinas',
      $listaDisciplinas = document.querySelector('#listaDisciplinas'),
      $nomeDisciplina = document.querySelector('#nomeDisciplina'),
      $notaDisciplina = document.querySelector('#notaDisciplina'),
      $createButton = document.querySelector('#novaDisciplina');

$createButton.addEventListener('click', criarDisciplina);
window.addEventListener('keyup', (e) => {
    if (e.keyCode == 13) criarDisciplina();
});

function clear() {
    $listaDisciplinas.innerHTML = '<div class="row head"><div class="column">Disciplina</div><div class="column">Nota</div></div>';
    $nomeDisciplina.value = "";
    $notaDisciplina.value = "";
    fetch_disciplinas();
}

function fetch_disciplinas() {
    fetch(URL)
    .then(response => response.json())
    .then(dados => {
        dados.forEach(v => {
            const $div = document.createElement('div');
            $div.className = 'row hover';
            $div.innerHTML = '<div class="column">' + v.nome + '</div><div class="column">' + v.nota + '</div>';
            
            const $deleteButton = document.createElement('button');
            $deleteButton.innerText = 'Remover';
            $deleteButton.id = v.id;
            $deleteButton.addEventListener('click', () => deletarDisciplina($deleteButton.id));

            const $column = document.createElement('div');
            $column.className = 'column delete';

            $column.appendChild($deleteButton);
            $div.appendChild($column);
            $listaDisciplinas.appendChild($div);
        });
    });
}

function criarDisciplina() {
    const nome = $nomeDisciplina.value;
    const nota = $notaDisciplina.value;
    
    fetch(URL, {
        'method': 'POST',
        'body': `{"nome": "${nome}", "nota": "${nota}"}`,
        'headers': {'Content-Type': 'application/json'}
    }).then(() => clear());
}

function deletarDisciplina(id) {
    fetch(URL + "/" + id, {
        'method': 'DELETE',
        'headers': {'Content-Type': 'application/json'}
    }).then(() => clear());
}

clear();