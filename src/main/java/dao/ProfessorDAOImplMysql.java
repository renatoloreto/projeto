package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Professor;

public class ProfessorDAOImplMysql implements ProfessorDAO{

	    private String url = "jdbc:mysql://localhost:3306/db_bt002?useSSL=false";
	    private String username = "root";
	    private String password = "";

	    private static final String INSERT_USERS_SQL  = "INSERT INTO professores (cpf, nome, telefone, conta_bancaria) VALUES (?, ?, ?, ?);";
	    private static final String SELECT_USER_BY_ID = "SELECT * FROM professores WHERE cpf = ? ";
	    private static final String SELECT_ALL_USERS  = "SELECT * FROM professores";
	    private static final String UPDATE_USERS_SQL  = "UPDATE professores SET cpf=?, nome=?, telefone=?, conta_bancaria=? WHERE cpf=?;";
	    private static final String DELETE_USERS_SQL  = "DELETE FROM professores WHERE cpf = ?;";

	    public ProfessorDAOImplMysql() {}

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
	    public void criarProfessor(Professor professor) {
	        
	    	System.out.println(INSERT_USERS_SQL);
	        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
	        	// (cpf, nome, telefone, conta_bancaria)
	        	preparedStatement.setString(1, professor.getCpf());
	        	preparedStatement.setString(2, professor.getNome());
	        	preparedStatement.setString(3, professor.getTelefone());
	        	preparedStatement.setString(4, professor.getConta_bancaria());
	        	System.out.println(preparedStatement);
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            printSQLException(e);
	        }
	    }

	    // Read do CRUD
	    @Override
	    public Professor getProfessorPorCpf(String cpfBuscado) {
	    	Professor professor = null;
	        // Passo 1: Estabelecendo a conexão
	        try (Connection connection = getConnection();
	            // Passo 2: Cria um caminho usando o objeto de conexão
	            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
	            preparedStatement.setString(1, cpfBuscado);
	            System.out.println(preparedStatement);
	            // Passo 3: Executando a consulta ou atualização/update
	            ResultSet rs = preparedStatement.executeQuery();

	            // Passo 4: Processando o ResultSet object
	            while (rs.next()) {
	                String cpf = rs.getString("cpf");
	                String nome = rs.getString("nome");
	                String telefone = rs.getString("telefone");
	                String conta_bancaria = rs.getString("conta_bancaria");
	                professor = new Professor(cpf, nome, telefone, conta_bancaria);
	            }
	        } catch (SQLException e) {
	            printSQLException(e);
	        }
	        return professor;
	    }

	    // Read do CRUD
	    @Override
	    public ArrayList<Professor> getTodosProfessores() {

	        ArrayList<Professor> professores = new ArrayList<>();
	        // Passo 1: Estabelecendo conexão
	        try (Connection connection = getConnection();

	            // Passo 2: Criando um caminho usando o objeto conexão
	            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
	            System.out.println(preparedStatement);
	            // Passo 3: executar a consulta ou atualização/update
	            ResultSet rs = preparedStatement.executeQuery();

	            // Passo 4: Processar o objeto ResultSet criando professores e adicionando no ArrayList
	            while (rs.next()) {
	                String cpf = rs.getString("cpf");
	                String nome = rs.getString("nome");
	                String telefone = rs.getString("telefone");
	                String conta_bancaria = rs.getString("conta_bancaria");
	                professores.add(new Professor(cpf, nome, telefone, conta_bancaria));
	            }
	        } catch (SQLException e) {
	            printSQLException(e);
	        }
	        return professores;
	    }
	    
	    // Update do CRUD
	    @Override
	    public void atualizarProfessor(Professor professor) {
	        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
	            statement.setString(1, professor.getCpf());
	            statement.setString(2, professor.getNome());
	            statement.setString(3, professor.getTelefone());
	            statement.setString(4, professor.getConta_bancaria());
	            statement.setString(5, professor.getCpf());  // WHERE cpf=?
	            statement.executeUpdate();
	        } catch (SQLException e) {
				e.printStackTrace();
			}
	    }

	    // Delete do CRUD
	    @Override
	    public void deleteProfessor(Professor professor) {
	        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
	            statement.setString(1, professor.getCpf());
					statement.executeUpdate();

	        }catch (SQLException e) {
				e.printStackTrace();
			}
	    }
	    
	    // Delete do CRUD
		@Override
		public void deleteProfessor(String cpf) {
	        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
	            statement.setString(1, cpf);
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
