package br.ufg.inf.aula4.model.dao;

import br.ufg.inf.aula4.app.DB;
import br.ufg.inf.aula4.exception.MatriculaException;
import br.ufg.inf.aula4.model.dao.mode.ReadWriteDAO;
import br.ufg.inf.aula4.model.entities.Aluno;
import br.ufg.inf.aula4.model.entities.Matricula;
import br.ufg.inf.aula4.model.entities.Oferta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MatriculaDAO implements ReadWriteDAO<Matricula, MatriculaException> {
	private final String MATRICULA_SQL = "SELECT id_matricula, id_aluno, id_oferta FROM tb_matricula";
	@Override
	public Matricula inserir(Matricula matricula) throws MatriculaException {
		PreparedStatement st = null;
		try {
			Connection conn = DB.getConnection();
			st = (PreparedStatement) conn.prepareStatement(
					"INSERT INTO tb_matricula (id_aluno, id_oferta)" + "VALUES (?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			st.setInt(1, matricula.getAluno().getIdAluno());
			st.setInt(2, matricula.getOferta().getIdOferta());
			int rowsAffected = st.executeUpdate();
			System.out.println("Linhas alteradas: " + rowsAffected);
			
			if (rowsAffected > 0) {
				
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					matricula.setIdMatricula(id);
				}
			}
		} catch (SQLException e) {
			throw new MatriculaException("Erro ao inserir matricula", e);
		}
		
		return matricula;
	}
	
	@Override
	public List<Matricula> buscaTodos() throws MatriculaException {
		List<Matricula> matriculas = new ArrayList<>();
		try {
			Connection conn = DB.getConnection();
			PreparedStatement st = conn.prepareStatement(MATRICULA_SQL);
			ResultSet rows = st.executeQuery();
			
			while (rows.next()) {
				matriculas.add(matriculaFromResultSet(rows));
			}
		} catch (SQLException e) {
			throw new MatriculaException("Erro ao buscar matriculas", e);
		}
		
		return matriculas;
	}
	
	@Override
	public Matricula buscaPorId(Integer id) throws MatriculaException {
		try {
			Connection conn = DB.getConnection();
			PreparedStatement st = conn.prepareStatement(MATRICULA_SQL);
			ResultSet rows = st.executeQuery();
			
			if (rows.next()) {
				return matriculaFromResultSet(rows);
			} else {
				return null;
			}
		} catch (SQLException e) {
			throw new MatriculaException("Erro ao buscar matrícula", e);
		}
	}
	
	@Override
	public Matricula alterar(Matricula matricula) throws MatriculaException {
		PreparedStatement st = null;
		try {
			Connection conn = DB.getConnection();
			st = (PreparedStatement) conn.prepareStatement(
					"UPDATE tb_matricula SET id_aluno = ? id_oferta = ? WHERE id_matricula = ?",
					Statement.RETURN_GENERATED_KEYS);
			st.setInt(1, matricula.getAluno().getIdAluno());
			st.setInt(2, matricula.getOferta().getIdOferta());
			st.setInt(3, matricula.getIdMatricula());
			int rowsAffected = st.executeUpdate();
			if (rowsAffected > 0) {
				ResultSet rs = st.getResultSet();
				if (rs.next()) {
					return matriculaFromResultSet(rs);
				}
			}
		} catch (SQLException e) {
			throw new MatriculaException("Erro ao alterar matrícula", e);
		}
		
		return null;
	}
	
	@Override
	public void excluir(Integer id) throws MatriculaException {
		try {
			PreparedStatement st = DB.getConnection().prepareStatement(
							"DELETE  FROM tb_matricula WHERE id_matricula = ?");
			st.setInt(1, id);
			st.executeUpdate();
		} catch (SQLException sqlException) {
			throw new MatriculaException("Erro ao excluir matrícula", sqlException);
		}
	}
	
	private Matricula matriculaFromResultSet(ResultSet rs) throws SQLException {
		Aluno a = new Aluno();
		a.setIdAluno(rs.getInt(2));
		Oferta o = new Oferta();
		o.setIdOferta(rs.getInt(3));
		return new Matricula(rs.getInt(1), a, o);
	}
	
}
