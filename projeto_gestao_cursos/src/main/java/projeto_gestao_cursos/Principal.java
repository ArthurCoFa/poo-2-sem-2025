package projeto_gestao_cursos;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Principal implements CommandLineRunner {
	
	private AlunoRepository alunoRepository;
    private CursoRepository cursoRepository;
    private InstrutorRepository instrutorRepository;
    private AlunoHasCursoRepository alunoHasCursoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Principal.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Dentro do método run()

		// 1. Salvar o Instrutor (Pré-requisito para o Curso)
		Instrutor instrutor = new Instrutor();
		instrutor.setCpf("11122233344");
		instrutor.setNomeInstrutor("Prof. Xavier");
		
		instrutorRepository.save(instrutor);

		// 2. Salvar o Aluno (Pré-requisito para a Matrícula)
		Aluno aluno = new Aluno();
		aluno.setIdade(25);
		aluno.setNomeAluno("Jean Grey");
		
		alunoRepository.save(aluno);

		// 3. Salvar o Curso (O Curso precisa do Instrutor)
		Curso curso = new Curso();
		curso.setCargaHoraria(80);
		curso.setNomeCurso("Introdução à Telecinese");
		curso.setInstrutor(instrutor); // Relacionamento 1:N
		
		cursoRepository.save(curso);

		// ----------------------------------------------------
		// 4. CRIAR E SALVAR A MATRÍCULA (Relacionamento N:N)
		// ----------------------------------------------------

		// Cria o objeto AlunoHasCurso usando o construtor que inicializa a chave composta (ID)
		AlunoHasCurso matricula = new AlunoHasCurso(aluno, curso);

		// Salva a matrícula no repositório dela
		alunoHasCursoRepository.save(matricula);

		System.out.println("Dados e Matrícula de Teste Salvos com Sucesso!");
		System.out.println("Matrícula criada: Aluno ID " + aluno.getIdAluno() + " no Curso ID " + curso.getIdCurso());

		// Opcional: Listar para verificar
		System.out.println("\nMatrículas Ativas:");
		alunoHasCursoRepository.findAll().forEach(m -> {
		    System.out.println("-> Aluno: " + m.getAluno().getNomeAluno() + 
		                       " matriculado no Curso: " + m.getCurso().getNomeCurso());
		});
	}
	
}
