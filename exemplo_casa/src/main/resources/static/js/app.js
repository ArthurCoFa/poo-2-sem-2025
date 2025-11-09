/**
 * ARQUIVO: app.js
 * LOCAL: src/main/resources/static/js/app.js
 * ATUALIZADO com a lógica de EDIÇÃO (PUT)
 */

const API_BASE_URL = 'http://localhost:8080/api/alunos';
const alunosLista = document.getElementById('alunos-lista');

// Referências aos novos e antigos elementos do formulário
const alunoIdInput = document.getElementById('aluno-id'); // Campo oculto
const nomeInput = document.getElementById('nome');
const idadeInput = document.getElementById('idade');
const botaoSalvar = document.getElementById('botao-salvar');
const botaoCancelar = document.getElementById('botao-cancelar');

// --- 1. FUNÇÃO PARA BUSCAR E EXIBIR OS ALUNOS (GET) ---

async function carregarAlunos() {
    try {
        const response = await fetch(API_BASE_URL);
        
        if (!response.ok) {
            throw new Error(`Erro HTTP: ${response.status}`);
        }

        const alunos = await response.json(); 
        
        alunosLista.innerHTML = ''; 

        alunos.forEach(aluno => {
            const tr = document.createElement('tr');
            tr.innerHTML = `
                <td>${aluno.id}</td>
				<td>${aluno.matricula}</td>
                <td>${aluno.nome}</td>
                <td>${aluno.idade}</td>
                <td>
                    <button onclick="editarAluno(${aluno.id})">Editar</button> 
                    <button onclick="deletarAluno(${aluno.id})">Deletar</button>
                </td>
            `;
            alunosLista.appendChild(tr); 
        });

    } catch (error) {
        console.error("Falha ao carregar alunos:", error);
        alunosLista.innerHTML = `<tr><td colspan="4">Erro de comunicação com o Backend.</td></tr>`;
    }
}


// --- 2. FUNÇÃO UNIFICADA PARA SALVAR OU ATUALIZAR (POST ou PUT) ---

async function salvarOuAtualizarAluno() {
    const id = alunoIdInput.value;
    // O método é PUT se houver um ID no campo oculto, senão é POST
    const isUpdating = id !== ''; 

    const alunoData = {
        nome: nomeInput.value,
        idade: parseInt(idadeInput.value) 
    };
    
    if (!alunoData.nome || isNaN(alunoData.idade)) {
        alert("Por favor, preencha o Nome e a Idade corretamente.");
        return;
    }

    // Se estiver atualizando, anexa o ID à URL. Se for salvando, usa a URL base.
    const url = isUpdating ? `${API_BASE_URL}/${id}` : API_BASE_URL;
    const method = isUpdating ? 'PUT' : 'POST';

    try {
        const response = await fetch(url, {
            method: method,
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(alunoData)
        });

        if (response.ok) {
            // Limpa o modo de edição e recarrega a lista
            cancelarEdicao(); 
            carregarAlunos(); 
        } else {
            alert('Falha na operação! Verifique o console Java.');
        }

    } catch (error) {
        console.error(`Erro ao ${isUpdating ? 'atualizar' : 'salvar'} aluno:`, error);
        alert('Erro de conexão.');
    }
}


// --- 3. FUNÇÃO PARA CARREGAR OS DADOS NO FORMULÁRIO (CHAMADA pelo botão EDITAR) ---

async function editarAluno(id) {
    try {
        // 1. Busque os dados do aluno no Backend para garantir que são os mais recentes
        const response = await fetch(`${API_BASE_URL}/${id}`);
        if (!response.ok) {
            throw new Error(`Erro ao buscar aluno para edição: ${response.status}`);
        }
        const aluno = await response.json();

        // 2. Preenche o formulário com os dados do aluno
        alunoIdInput.value = aluno.id; // CRUCIAL: Preenche o campo oculto
        nomeInput.value = aluno.nome;
        idadeInput.value = aluno.idade;
        
        // 3. Altera a interface para o modo de edição
        botaoSalvar.textContent = 'Atualizar Aluno';
        botaoCancelar.style.display = 'inline-block'; // Mostra o botão Cancelar

    } catch (error) {
        console.error("Erro ao buscar dados para edição:", error);
        alert("Não foi possível carregar os dados para edição.");
    }
}

// --- 4. FUNÇÃO PARA CANCELAR O MODO DE EDIÇÃO ---

function cancelarEdicao() {
    // Limpa o formulário e o ID oculto
    alunoIdInput.value = ''; 
    nomeInput.value = '';
    idadeInput.value = '';
    
    // Volta a interface para o modo de "Adicionar"
    botaoSalvar.textContent = 'Salvar Aluno';
    botaoCancelar.style.display = 'none';
}


// --- 5. FUNÇÃO DE DELEÇÃO (MANTIDA) ---

async function deletarAluno(id) {
    if (!confirm('Tem certeza que deseja deletar o aluno ID ' + id + '?')) {
        return;
    }
    
    try {
        const response = await fetch(`${API_BASE_URL}/${id}`, {
            method: 'DELETE'
        });

        if (response.ok) {
            carregarAlunos();
        } else {
            alert('Falha ao deletar aluno! Verifique o console Java.');
        }

    } catch (error) {
        console.error("Erro ao deletar aluno:", error);
    }
}


// --- 6. INICIALIZAÇÃO ---
document.addEventListener('DOMContentLoaded', carregarAlunos);