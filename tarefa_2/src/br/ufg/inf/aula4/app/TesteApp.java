package br.ufg.inf.aula4.app;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import br.ufg.inf.aula4.ctrl.AlunoCtrl;
import br.ufg.inf.aula4.ctrl.CursoCtrl;
import br.ufg.inf.aula4.ctrl.DisciplinaCtrl;
import br.ufg.inf.aula4.ctrl.MatriculaCtrl;
import br.ufg.inf.aula4.ctrl.OfertaCtrl;
import br.ufg.inf.aula4.ctrl.PessoaCtrl;
import br.ufg.inf.aula4.ctrl.ProfessorCtrl;
import br.ufg.inf.aula4.model.entities.Aluno;
import br.ufg.inf.aula4.model.entities.Curso;
import br.ufg.inf.aula4.model.entities.Disciplina;
import br.ufg.inf.aula4.model.entities.Matricula;
import br.ufg.inf.aula4.model.entities.Oferta;
import br.ufg.inf.aula4.model.entities.Pessoa;
import br.ufg.inf.aula4.model.entities.Professor;
import br.ufg.inf.aula4.model.enums.Dia;
import br.ufg.inf.aula4.model.enums.Escolaridade;

public class TesteApp {
	
	DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	
	public void testeCrudDisciplina(DisciplinaCtrl ctrl) {
		
		for (Disciplina dis : ctrl.buscaTodos()) {
			System.out.println(dis);
		}
		System.out.println("--------------------------------------------------");
		/* Inserir Disciplinas */
		Disciplina disc1 = new Disciplina(null, "Des. FullStack", 64);
		Disciplina disc2 = new Disciplina(null, "LLP", 60);
		Disciplina disc3 = new Disciplina(null, "Matemática", 30);
		Disciplina disc4 = new Disciplina(1, "Inglês", 10);
		Disciplina disc5 = new Disciplina(2, "Lógica", 40);
		Disciplina disc6 = new Disciplina(3, "Matemática", 30);
		ctrl.inserir(disc1);
		ctrl.inserir(disc2);
		ctrl.inserir(disc3);
		ctrl.inserir(disc4);
		ctrl.inserir(disc5);
		ctrl.inserir(disc6);
		
		System.out.println("--------------------------------------------------");
		/* Buscar todas as Disicplinas */
		System.out.println("Disciplinas Cadastradas");
		for (Disciplina dis : ctrl.buscaTodos()) {
			System.out.println(dis);
		}
		
		System.out.println("--------------------------------------------------");
		/* Buscar disciplina com o ID 2 */
		System.out.println("Buscar pelo id 2: " + ctrl.buscaPorId(2));
		
		System.out.println("--------------------------------------------------");
		/* Alterado a disciplina */
		disc3.setCargaHoraria(50);
		disc3.setNmDisciplina(disc3.getNmDisciplina() + " Alterada");
		ctrl.alterar(disc3);
		
		System.out.println("--------------------------------------------------");
		/* Excluíndo disciplina */
		ctrl.excluir(disc1.getIdDisciplina());
		System.out.println("Disciplinas Cadastradas");
		for (Disciplina dis : ctrl.buscaTodos()) {
			System.out.println(dis);
		}
		
		System.out.println("--------------------------------------------------");
		System.out.println(ctrl.buscaPorId(10));
	}
	
	@SuppressWarnings("deprecation")
	public void testeCrudPessoa(PessoaCtrl ctrl) {
		for (Pessoa dis : ctrl.buscaTodos()) {
			System.out.println(dis);
		}
		System.out.println("--------------------------------------------------");
		/* Inserir Pessoas */
		Pessoa pes1 = new Pessoa(null, "Luiz Martins", 12345678901L,
				new GregorianCalendar(1980, Calendar.JANUARY, 10).getTime());
		Pessoa pes2 = new Pessoa(null, "Fulano da Silva", 99999999999L,
				new GregorianCalendar(1985, Calendar.MARCH, 5).getTime());
		Pessoa pes3 = new Pessoa(null, "Ciclano da Silva", 88888888888L,
				new GregorianCalendar(1980, Calendar.FEBRUARY, 10).getTime());
		Pessoa pes4 = new Pessoa(null, "Beltrano da Silva", 77777777777L,
				new GregorianCalendar(1980, Calendar.FEBRUARY, 10).getTime());
		
		ctrl.inserir(pes1);
		ctrl.inserir(pes2);
		ctrl.inserir(pes3);
		ctrl.inserir(pes4);
		
		System.out.println("--------------------------------------------------");
		/* Buscar todas as Disicplinas */
		System.out.println("Pessoas Cadastradas");
		for (Pessoa dis : ctrl.buscaTodos()) {
			System.out.println(dis);
		}
		
		System.out.println("--------------------------------------------------");
		/* Buscar pessoa com o ID 1 */
		System.out.println("Buscar pelo id 1: " + ctrl.buscaPorId(1));
		
		System.out.println("--------------------------------------------------");
		/* Alterado a pessoa */
		pes4.setCpf(11111111111l);
		pes4.setNmPessoa("José " + pes4.getNmPessoa());
		ctrl.alterar(pes4);
		
		System.out.println("--------------------------------------------------");
		/* Excluíndo pessoa */
		ctrl.excluir(pes3.getIdPessoa());
		System.out.println("Pessoas Cadastradas");
		for (Pessoa dis : ctrl.buscaTodos()) {
			System.out.println(dis);
		}
		
		System.out.println("--------------------------------------------------");
		System.out.println(ctrl.buscaPorId(1));
	}
	
	public void testeCrudProfessor(ProfessorCtrl ctrl, PessoaCtrl pessoaCtrl) {
		for (Professor dis : ctrl.buscaTodos()) {
			System.out.println(dis);
		}
		System.out.println("--------------------------------------------------");
		
		Professor prof1 = new Professor(null, pessoaCtrl.buscaPorId(1), Escolaridade.get(4));
		Professor prof2 = new Professor(null, pessoaCtrl.buscaPorId(2), Escolaridade.get(2));
		
		ctrl.inserir(prof1);
		ctrl.inserir(prof2);
		
		System.out.println("--------------------------------------------------");
		/* Buscar todos os Professores */
		System.out.println("Professores Cadastrados");
		for (Professor dis : ctrl.buscaTodos()) {
			System.out.println(dis);
		}
		
		System.out.println("--------------------------------------------------");
		/* Buscar professor com o ID 1 */
		System.out.println("Buscar pelo id 1: " + ctrl.buscaPorId(1));
		
		System.out.println("--------------------------------------------------");
		/* Alterando o professor */
		
		prof2.setEscolaridade(Escolaridade.get(3));
		ctrl.alterar(prof2);
		
		System.out.println("--------------------------------------------------");
		/* Excluindo professor */
		ctrl.excluir(prof1.getIdProfessor());
		System.out.println("Professores Cadastrados");
		for (Professor dis : ctrl.buscaTodos()) {
			System.out.println(dis);
		}
		
		System.out.println("--------------------------------------------------");
		System.out.println(ctrl.buscaPorId(2));
	}
	
	public void testeCrudOferta(OfertaCtrl ctrl, DisciplinaCtrl disciplinaCtrl, ProfessorCtrl professorCtrl) {
		
		// Inserindo ofertas
		
		Date dt1 = null;
		Date dt2 = null;
		try {
			dt1 = new SimpleDateFormat("yyyy-MM-dd").parse("2021-3-10");
			dt2 = new SimpleDateFormat("yyyy-MM-dd").parse("2021-6-15");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Oferta ofe1 = new Oferta(null, professorCtrl.buscaPorId(2), disciplinaCtrl.buscaPorId(2), dt1, dt2,
				Dia.get(2),
				"08:00");
		ctrl.inserir(ofe1);
		
		try {
			dt1 = new SimpleDateFormat("yyyy-MM-dd").parse("2021-2-7");
			dt2 = new SimpleDateFormat("yyyy-MM-dd").parse("2021-5-31");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Oferta ofe2 = new Oferta(null, professorCtrl.buscaPorId(4), disciplinaCtrl.buscaPorId(6), dt1, dt2,
				Dia.get(6),
				"19:00");
		ctrl.inserir(ofe2);
		
		System.out.println("--------------------------------------------------");
		
	}
	
	public void testeCrudAluno(AlunoCtrl ctrl, PessoaCtrl pessoaCtrl, CursoCtrl cursoCtrl) throws ParseException {
		
		// Inserindo ofertas
		Aluno a1 = new Aluno(null,new Date(),true,pessoaCtrl.buscaPorId(2), cursoCtrl.buscaPorId(2));
		ctrl.inserir(a1);
		
		Aluno a2 = new Aluno(null, new SimpleDateFormat("yyyy-MM-dd").parse("2021-6-15"),true,pessoaCtrl.buscaPorId(2), cursoCtrl.buscaPorId(2));
		ctrl.inserir(a2);
		
		System.out.println("--------------------------------------------------");
		
	}
	public void testeCrudCurso(CursoCtrl ctrl) {
		
		// Inserindo ofertas
		Curso c1 = new Curso(null, "Curso 1");
		ctrl.inserir(c1);
		
		Curso c2 = new Curso(null, "Curso 2");
		ctrl.inserir(c2);
		
		System.out.println("Cursos Inseridos:");
		for (Curso curso :ctrl.buscaTodos()) {
			System.out.println(curso);
		}
		System.out.println("--------------------------------------------------");
		
	}
	
	public void testeCrudMatricula(MatriculaCtrl ctrl, AlunoCtrl alunoCtrl, OfertaCtrl ofertaCtrl) {
		
		// Inserindo ofertas
		Matricula m1 = new Matricula(null, alunoCtrl.buscaPorId(1), ofertaCtrl.buscaPorId(2) );
		ctrl.inserir(m1);
		
		Matricula m2 = new Matricula(null, alunoCtrl.buscaPorId(1), ofertaCtrl.buscaPorId(2) );
		ctrl.inserir(m2);
		
		System.out.println("Matriculas inseridas: ");
		for (Matricula matricula : ctrl.buscaTodos()) {
			System.out.println(matricula);
		}
		System.out.println("--------------------------------------------------");
		
	}
	
}
