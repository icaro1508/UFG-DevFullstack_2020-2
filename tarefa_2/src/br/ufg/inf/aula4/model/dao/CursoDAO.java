package br.ufg.inf.aula4.model.dao;

import br.ufg.inf.aula4.app.DB;
import br.ufg.inf.aula4.exception.CursoException;
import br.ufg.inf.aula4.model.dao.mode.ReadWriteDAO;
import br.ufg.inf.aula4.model.entities.Curso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CursoDAO implements ReadWriteDAO<Curso, CursoException> {
	
	private final String SELECT_CURSO_SQL = "SELECT id_curso, nm_curso FROM tb_curso";
	
	@Override
	public Curso inserir(Curso curso) throws CursoException {
		PreparedStatement st = null;
		try {
			Connection conn = DB.getConnection();
			st = conn.prepareStatement("INSERT INTO tb_curso (nm_curso) VALUES (?)",
					Statement.RETURN_GENERATED_KEYS);
			st.setString(1, curso.getNmCurso());
			
			int rowsAffected = st.executeUpdate();
			System.out.println("Linhas alteradas: " + rowsAffected);
			
			if (rowsAffected > 0) {
				
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					curso.setIdCurso(id);
				}
			}
		} catch (SQLException e) {
			throw new CursoException("Erro ao inserir curso", e);
		}
		
		return curso;
	}
	
	@Override
	public List<Curso> buscaTodos() throws CursoException {
		List<Curso> cursos = new ArrayList<>();
		try {
			Connection conn = DB.getConnection();
			PreparedStatement st = conn.prepareStatement(SELECT_CURSO_SQL);
			ResultSet rows = st.executeQuery();
			
			while (rows.next()) {
				cursos.add(cursoFromResultSet(rows));
			}
		} catch (SQLException e) {
			throw new CursoException("Erro ao buscar cursos", e);
		}
		
		return cursos;
	}
	
	@Override
	public Curso buscaPorId(Integer id) throws CursoException {
		try {
			Connection conn = DB.getConnection();
			PreparedStatement st = null;
			st = conn.prepareStatement(SELECT_CURSO_SQL);
			ResultSet rows = st.executeQuery();
			
			if (rows.next()) {
				return cursoFromResultSet(rows);
			} else {
				return null;
			}
		} catch (SQLException e) {
			throw new CursoException("Erro ao buscar matrícula", e);
		}
	}
	
	@Override
	public Curso alterar(Curso curso) throws CursoException {
		try {
			Connection conn = DB.getConnection();
			PreparedStatement st = conn.prepareStatement(
					"UPDATE tb_curso SET nm_curso = ? WHERE id_curso = ?",
					Statement.RETURN_GENERATED_KEYS);
			st.setString(1, curso.getNmCurso());
			st.setInt(2, curso.getIdCurso());
			int rowsAffected = st.executeUpdate();
			if (rowsAffected > 0) {
				ResultSet rs = st.getResultSet();
				if (rs.next()) {
					return cursoFromResultSet(rs);
				}
			}
		} catch (SQLException e) {
			throw new CursoException("Erro ao alterar matrícula", e);
		}
		
		return null;
	}
	
	@Override
	public void excluir(Integer id) throws CursoException {
		try {
			PreparedStatement st = DB.getConnection().prepareStatement(
					"DELETE  FROM tb_curso WHERE id_curso = ?");
			st.setInt(1, id);
			st.executeUpdate();
		} catch (SQLException sqlException) {
			throw new CursoException("Erro ao excluir matrícula", sqlException);
		}
	}
	
	private Curso cursoFromResultSet(ResultSet rs) throws SQLException {
		return new Curso(rs.getInt(1), rs.getString(2));
	}
	
}
