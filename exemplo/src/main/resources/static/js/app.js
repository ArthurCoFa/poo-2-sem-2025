/**
 * ARQUIVO: app.js
 * FUNÇÃO: Interage com a API REST de Pessoas (GET, POST, PUT, DELETE).
 * LOCAL: src/main/resources/static/js/app.js
 */

// A URL base da sua API REST de Pessoas. Verifique a porta e o endpoint.
const API_BASE_URL = 'http://localhost:8080/api/pessoas';

// Referências aos elementos do DOM
const pessoasLista = document.querySelector('#tabela-pessoas tbody'); // Tbody da tabela
const pessoaIdInput = document.getElementById('current-id'); // Campo oculto para o ID em edição
const nomeInput = document.getElementById('nome');
const idadeInput = document.getElementById('idade');
const form = document.getElementById('pessoa-form');
const botaoSalvar = document.getElementById('submit-button');
const botaoCancelar = document.getElementById('cancel-edit-button');

// Adiciona o listener de submit ao formulário
form.addEventListener('submit', function(e) {
    e.preventDefault(); 
    salvarOuAtualizarPessoa();
});

// Adiciona o listener para o botão de cancelar edição
botaoCancelar.addEventListener('click', cancelarEdicao);


// --- 1. FUNÇÃO PARA BUSCAR E EXIBIR AS PESSOAS (GET) ---

async function carregarPessoas() {
    try {
        const response = await fetch(API_BASE_URL);
        
        if (!response.ok) {
            throw new Error(`Erro HTTP: ${response.status}. Verifique se o backend está rodando.`);
        }

        const pessoas = await response.json(); 
        pessoasLista.innerHTML = ''; 

        pessoas.forEach(pessoa => {
            const tr = document.createElement('tr');
            tr.innerHTML = `
                <td>${pessoa.id}</td>
                <td>${pessoa.nome}</td>
                <td>${pessoa.idade}</td>
                <td>
                    <button onclick="editarPessoa(${pessoa.id})">Editar</button> 
                    <button onclick="deletarPessoa(${pessoa.id})">Excluir</button>
                </td>
            `;
            pessoasLista.appendChild(tr); 
        });

    } catch (error) {
        console.error("Falha ao carregar pessoas:", error);
        pessoasLista.innerHTML = `<tr><td colspan="4">Erro: ${error.message}.</td></tr>`;
    }
}


// --- 2. FUNÇÃO UNIFICADA PARA SALVAR OU ATUALIZAR (POST ou PUT) ---

async function salvarOuAtualizarPessoa() {
    const id = pessoaIdInput.value;
    const isUpdating = id !== ''; // É atualização se o campo ID estiver preenchido

    const pessoaData = {
        // As chaves 'nome' e 'idade' devem BATER com a sua classe Pessoa no Java
        nome: nomeInput.value,
        idade: parseInt(idadeInput.value) 
    };
    
    if (!pessoaData.nome || isNaN(pessoaData.idade)) {
        alert("Por favor, preencha o Nome e a Idade corretamente.");
        return;
    }

    const url = isUpdating ? `${API_BASE_URL}/${id}` : API_BASE_URL;
    const method = isUpdating ? 'PUT' : 'POST';

    try {
        const response = await fetch(url, {
            method: method,
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(pessoaData)
        });

        if (response.ok) {
            cancelarEdicao(); // Limpa o formulário e retorna ao modo 'Adicionar'
            carregarPessoas(); // Recarrega a lista para mostrar a alteração
        } else {
            // Se o backend retornou 4xx ou 5xx
            alert(`Falha na operação (${method}): ${response.status}. Verifique o console do backend.`);
        }

    } catch (error) {
        console.error(`Erro ao ${isUpdating ? 'atualizar' : 'salvar'} pessoa:`, error);
        alert('Erro de conexão ou CORS. Verifique o console.');
    }
}


// --- 3. FUNÇÃO PARA CARREGAR OS DADOS NO FORMULÁRIO (CHAMADA pelo botão EDITAR) ---

async function editarPessoa(id) {
    try {
        // Busca os dados da pessoa no Backend para edição
        const response = await fetch(`${API_BASE_URL}/${id}`);
        if (!response.ok) {
            throw new Error(`Erro ao buscar pessoa: ${response.status}`);
        }
        const pessoa = await response.json();

        // 1. Preenche o formulário com os dados
        pessoaIdInput.value = pessoa.id; // CRUCIAL: Popula o ID para o PUT
        nomeInput.value = pessoa.nome;
        idadeInput.value = pessoa.idade;
        
        // 2. Altera a interface para o modo de edição
        botaoSalvar.textContent = 'Atualizar Pessoa';
        botaoCancelar.style.display = 'inline-block';
        nomeInput.focus();

    } catch (error) {
        console.error("Erro ao buscar dados para edição:", error);
        alert("Não foi possível carregar os dados para edição.");
    }
}

// --- 4. FUNÇÃO PARA CANCELAR O MODO DE EDIÇÃO ---

function cancelarEdicao() {
    // Limpa o formulário e o ID oculto
    form.reset();
    pessoaIdInput.value = ''; 
    
    // Volta a interface para o modo de "Adicionar"
    botaoSalvar.textContent = 'Adicionar';
    botaoCancelar.style.display = 'none';
}


// --- 5. FUNÇÃO DE DELEÇÃO (DELETE) ---

async function deletarPessoa(id) {
    if (!confirm('Tem certeza que deseja excluir a pessoa ID ' + id + '?')) {
        return;
    }
    
    try {
        const response = await fetch(`${API_BASE_URL}/${id}`, {
            method: 'DELETE'
        });

        if (response.ok) {
            carregarPessoas();
        } else {
            alert('Falha ao excluir pessoa! Verifique o console do backend.');
        }

    } catch (error) {
        console.error("Erro ao excluir pessoa:", error);
        alert('Erro de conexão.');
    }
}


// --- 6. INICIALIZAÇÃO ---
document.addEventListener('DOMContentLoaded', carregarPessoas);