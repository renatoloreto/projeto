package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Curso;

public class CursoDAOImplMysql implements CursoDAO{

	    private String url = "jdbc:mysql://localhost:3306/db_bt002?useSSL=false";
	    private String username = "root";
	    private String password = "";

	    private static final String INSERT_USERS_SQL  = "INSERT INTO cursos (cod_curso, nome, descricao, valor, data_inicio, data_fim) VALUES (?, ?, ?, ?, ?, ?);";
	    private static final String SELECT_USER_BY_ID = "SELECT * FROM cursos WHERE cod_curso = ? ";
	    private static final String SELECT_ALL_USERS  = "SELECT * FROM cursos";
	    private static final String UPDATE_USERS_SQL  = "UPDATE cursos SET cod_curso=?, nome=?, descricao=?, valor=?, data_inicio=?, data_fim=? WHERE cod_curso=?;";
	    private static final String DELETE_USERS_SQL  = "DELETE FROM cursos WHERE cod_curso = ?;";

	    public CursoDAOImplMysql() {}

	    protected Connection getConnection() {
	        Connection connection = null;
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            connection = DriverManager.getConnection(url, username, password);
	        
	        } catch (SQLException | ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	        return connection;
	    }

	    // Create do CRUD
	    @Override
	    public void criarCurso(Curso curso) {
	        
	    	System.out.println(INSERT_USERS_SQL);
	        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
	        	// (cod_curso, nome, descrição, valor, data_início, data_fim)
	        	preparedStatement.setInt(1, curso.getCod_curso());
	        	preparedStatement.setString(2, curso.getNome());
	        	preparedStatement.setString(3, curso.getDescricao());
	        	preparedStatement.setDouble(4, curso.getValor());
	        	preparedStatement.setDate(5, curso.getData_inicio());
	        	preparedStatement.setDate(6, curso.getData_fim());
	            System.out.println(preparedStatement);
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            printSQLException(e);
	        }
	    }

	    // Read do CRUD
	    @Override
	    public Curso getCursoPorCod(Integer codBuscado) {
	    	Curso curso= null;
	        // Passo 1: Estabelecendo a conexão
	        try (Connection connection = getConnection();
	            // Passo 2: Cria um caminho usando o objeto de conexão
	            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
	            preparedStatement.setInt(1, codBuscado);
	            System.out.println(preparedStatement);
	            // Passo 3: Executando a consulta ou atualização/update
	            ResultSet rs = preparedStatement.executeQuery();

	            // Passo 4: Processando o ResultSet object
	            while (rs.next()) {
	                Integer cod_curso = rs.getInt("cod_curso");
	                String nome = rs.getString("nome");
	                String descricao = rs.getString("descricao");
	                Double valor = rs.getDouble("valor");
	                Date data_inicio = rs.getDate("data_inicio");
	                Date data_fim = rs.getDate("data_fim");
	                curso = new Curso(cod_curso, nome, descricao, valor, data_inicio, data_fim);
	            }
	        } catch (SQLException e) {
	            printSQLException(e);
	        }
	        return curso;
	    }

	    // Read do CRUD
	    @Override
	    public ArrayList<Curso> getTodosCursos() {

	        ArrayList<Curso> cursos = new ArrayList<>();
	        // Passo 1: Estabelecendo conexão
	        try (Connection connection = getConnection();

	            // Passo 2: Criando um caminho usando o objeto conexão
	            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
	            System.out.println(preparedStatement);
	            // Passo 3: executar a consulta ou atualização/update
	            ResultSet rs = preparedStatement.executeQuery();

	            // Passo 4: Processar o objeto ResultSet criando alunos e adicionando no ArrayList
	            while (rs.next()) {
	                Integer cod_curso = rs.getInt("cod_curso");
	                String nome = rs.getString("nome");
	                String descricao = rs.getString("descricao");
	                Double valor = rs.getDouble("valor");
	                Date data_inicio = rs.getDate("data_inicio");
	                Date data_fim = rs.getDate("data_fim");
	                cursos.add(new Curso(cod_curso, nome, descricao, valor, data_inicio, data_fim));
	            }
	        } catch (SQLException e) {
	            printSQLException(e);
	        }
	        return cursos;
	    }
	    
	    // Update do CRUD
	    @Override
	    public void atualizarCurso(Curso curso) {
	        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
	            statement.setInt(1, curso.getCod_curso());
	            statement.setString(2, curso.getNome());
	            statement.setString(3, curso.getDescricao());
	            statement.setDouble(4, curso.getValor());
	            statement.setDate(5, curso.getData_inicio());
	            statement.setDate(6, curso.getData_fim());
	            statement.setInt(7, curso.getCod_curso());  // WHERE cod_curso=?
	            statement.executeUpdate();
	        } catch (SQLException e) {
				e.printStackTrace();
			}
	    }

	    // Delete do CRUD
	    @Override
	    public void deleteCurso(Curso curso) {
	        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
	            statement.setInt(1, curso.getCod_curso());
					statement.executeUpdate();

	        }catch (SQLException e) {
				e.printStackTrace();
			}
	    }
	    
	    // Delete do CRUD
		@Override
		public void deleteCurso(Integer cod_curso) {
	        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
	            statement.setInt(1, cod_curso);
					statement.executeUpdate();

	        }catch (SQLException e) {
				e.printStackTrace();
			}
		}



	    private void printSQLException(SQLException ex) {
	        for (Throwable e: ex) {
	            if (e instanceof SQLException) {
	                e.printStackTrace(System.err);
	                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
	                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
	                System.err.println("Message: " + e.getMessage());
	                Throwable t = ex.getCause();
	                while (t != null) {
	                    System.out.println("Cause: " + t);
	                    t = t.getCause();
	                }
	            }
	        }
	    }



	
}
