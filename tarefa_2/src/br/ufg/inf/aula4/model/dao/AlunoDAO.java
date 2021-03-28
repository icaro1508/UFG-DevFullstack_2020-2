package br.ufg.inf.aula4.model.dao;

import br.ufg.inf.aula4.app.DB;
import br.ufg.inf.aula4.exception.AlunoException;
import br.ufg.inf.aula4.model.dao.mode.ReadWriteDAO;
import br.ufg.inf.aula4.model.entities.Aluno;
import br.ufg.inf.aula4.model.entities.Curso;
import br.ufg.inf.aula4.model.entities.Oferta;
import br.ufg.inf.aula4.model.entities.Pessoa;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO implements ReadWriteDAO<Aluno, AlunoException> {
	private final String ALUNO_SQL = "SELECT id_aluno, dt_inicio, ativo, id_pessoa, id_curso FROM tb_aluno";
	@Override
	public Aluno inserir(Aluno aluno) throws AlunoException {
		PreparedStatement st = null;
		try {
			Connection conn = DB.getConnection();
			st = (PreparedStatement) conn.prepareStatement(
					"INSERT INTO tb_aluno (dt_inicio, ativo, id_pessoa, id_curso)" + "VALUES (?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			st.setDate(1, new Date(aluno.getDtInicio().getTime()));
			st.setBoolean(2, aluno.getAtivo());
			st.setInt(3, aluno.getPessoa().getIdPessoa());
			st.setInt(4, aluno.getCurso().getIdCurso());
			
			int rowsAffected = st.executeUpdate();
			System.out.println("Linhas alteradas: " + rowsAffected);
			
			if (rowsAffected > 0) {
				
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					aluno.setIdAluno(id);
				}
			}
		} catch (SQLException e) {
			throw new AlunoException("Erro ao inserir aluno", e);
		}
		
		return aluno;
	}
	
	@Override
	public List<Aluno> buscaTodos() throws AlunoException {
		List<Aluno> alunos = new ArrayList<>();
		try {
			Connection conn = DB.getConnection();
			PreparedStatement st = conn.prepareStatement(ALUNO_SQL);
			ResultSet rows = st.executeQuery();
			
			while (rows.next()) {
				alunos.add(alunoFromResultSet(rows));
			}
		} catch (SQLException e) {
			throw new AlunoException("Erro ao buscar alunos", e);
		}
		
		return alunos;
	}
	
	@Override
	public Aluno buscaPorId(Integer id) throws AlunoException {
		try {
			Connection conn = DB.getConnection();
			PreparedStatement st = null;
			st = conn.prepareStatement(ALUNO_SQL);
			ResultSet rows = st.executeQuery();
			
			if (rows.next()) {
				return alunoFromResultSet(rows);
			} else {
				return null;
			}
		} catch (SQLException e) {
			throw new AlunoException("Erro ao buscar matrícula", e);
		}
	}
	
	@Override
	public Aluno alterar(Aluno aluno) throws AlunoException {
		PreparedStatement st = null;
		try {
			Connection conn = DB.getConnection();
			st = (PreparedStatement) conn.prepareStatement(
					"UPDATE tb_aluno SET dt_inicio = ?, ativo = ?, id_pessoa = ?, id_curso = ? WHERE id_aluno = ?",
					Statement.RETURN_GENERATED_KEYS);
			st.setDate(1, new Date(aluno.getDtInicio().getTime()));
			st.setBoolean(2, aluno.getAtivo());
			st.setInt(3, aluno.getPessoa().getIdPessoa());
			st.setInt(4, aluno.getCurso().getIdCurso());
			st.setInt(5, aluno.getIdAluno());
			int rowsAffected = st.executeUpdate();
			if (rowsAffected > 0) {
				ResultSet rs = st.getResultSet();
				if (rs.next()) {
					return alunoFromResultSet(rs);
				}
			}
		} catch (SQLException e) {
			throw new AlunoException("Erro ao alterar matrícula", e);
		}
		
		return null;
	}
	
	@Override
	public void excluir(Integer id) throws AlunoException {
		try {
			PreparedStatement st = DB.getConnection().prepareStatement(
					"DELETE  FROM tb_aluno WHERE id_aluno = ?");
			st.setInt(1, id);
			st.executeUpdate();
		} catch (SQLException sqlException) {
			throw new AlunoException("Erro ao excluir matrícula", sqlException);
		}
	}
	
	private Aluno alunoFromResultSet(ResultSet rs) throws SQLException {
		Pessoa p = new Pessoa();
		p.setIdPessoa(rs.getInt(4));
		Curso c = new Curso();
		c.setIdCurso(rs.getInt(5));
		return new Aluno(rs.getInt(1), rs.getDate(2), rs.getBoolean(3), p, c);
	}
	
	
}
