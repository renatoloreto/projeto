package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Aluno;

public class AlunoDAOImplMysql implements AlunoDAO{

	    private String url = "jdbc:mysql://localhost:3306/db_bt002?useSSL=false";
	    private String username = "root";
	    private String password = "";

	    private static final String INSERT_USERS_SQL  = "INSERT INTO alunos (ra, nome, telefone, endereco, data_nascimento) VALUES (?, ?, ?, ?, ?);";
	    private static final String SELECT_USER_BY_ID = "SELECT * FROM alunos WHERE ra = ? ";
	    private static final String SELECT_ALL_USERS  = "SELECT * FROM alunos";
	    private static final String UPDATE_USERS_SQL  = "UPDATE alunos SET ra=?, nome=?, telefone=?, endereco=?, data_nascimento=? WHERE ra=?;";
	    private static final String DELETE_USERS_SQL  = "DELETE FROM alunos WHERE ra = ?;";

	    public AlunoDAOImplMysql() {}

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
	    public void criarAluno(Aluno aluno) {
	        
	    	System.out.println(INSERT_USERS_SQL);
	        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
	        	// (ra, nome, telefone, endereco, data_nascimento)
	        	preparedStatement.setString(1, aluno.getRa());
	        	preparedStatement.setString(2, aluno.getNome());
	        	preparedStatement.setString(3, aluno.getTelefone());
	        	preparedStatement.setString(4, aluno.getEndereco());
	        	preparedStatement.setDate(5, aluno.getData_nascimento());
	            System.out.println(preparedStatement);
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            printSQLException(e);
	        }
	    }

	    // Read do CRUD
	    @Override
	    public Aluno getAlunoPorRa(String raBuscado) {
	    	Aluno aluno = null;
	        // Passo 1: Estabelecendo a conexão
	        try (Connection connection = getConnection();
	            // Passo 2: Cria um caminho usando o objeto de conexão
	            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
	            preparedStatement.setString(1, raBuscado);
	            System.out.println(preparedStatement);
	            // Passo 3: Executando a consulta ou atualização/update
	            ResultSet rs = preparedStatement.executeQuery();

	            // Passo 4: Processando o ResultSet object
	            while (rs.next()) {
	                String ra = rs.getString("ra");
	                String nome = rs.getString("nome");
	                String telefone = rs.getString("telefone");
	                String endereco = rs.getString("endereco");
	                Date data_nascimento = rs.getDate("data_nascimento");
	                aluno = new Aluno(ra, nome, telefone, endereco, data_nascimento);
	            }
	        } catch (SQLException e) {
	            printSQLException(e);
	        }
	        return aluno;
	    }

	    // Read do CRUD
	    @Override
	    public ArrayList<Aluno> getTodosAlunos() {

	        ArrayList<Aluno> alunos = new ArrayList<>();
	        // Passo 1: Estabelecendo conexão
	        try (Connection connection = getConnection();

	            // Passo 2: Criando um caminho usando o objeto conexão
	        	//PreparedStatement - é o caminho, após a conexão com o banco, para trafegar os dados
	            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
	            // Passo 3: executar a consulta ou atualização/update
	            ResultSet rs = preparedStatement.executeQuery();

	            // Passo 4: Processar o objeto ResultSet criando alunos e adicionando no ArrayList
	            while (rs.next()) {
	                String r = rs.getString("ra");
	                String n = rs.getString("nome");
	                String telefone = rs.getString("telefone");
	                String endereco = rs.getString("endereco");
	                Date data_nascimento = rs.getDate("data_nascimento");
	                alunos.add(new Aluno(r, n, telefone, endereco, data_nascimento));
	            }
	        } catch (SQLException e) {
	            printSQLException(e);
	        }
	        return alunos;
	    }
	    
	    // Update do CRUD
	    @Override
	    public void atualizarAluno(Aluno aluno) {
	        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
	            statement.setString(1, aluno.getRa());
	            statement.setString(2, aluno.getNome());
	            statement.setString(3, aluno.getTelefone());
	            statement.setString(4, aluno.getEndereco());
	            statement.setDate(5, aluno.getData_nascimento());
	            statement.setString(6, aluno.getRa());  // WHERE ra=?
	            statement.executeUpdate();
	        } catch (SQLException e) {
				e.printStackTrace();
			}
	    }

	    // Delete do CRUD
	    @Override
	    public void deleteAluno(Aluno aluno) {
	        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
	            statement.setString(1, aluno.getRa());
					statement.executeUpdate();

	        }catch (SQLException e) {
				e.printStackTrace();
			}
	    }
	    
	    // Delete do CRUD
		@Override
		public void deleteAluno(String ra) {
	        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
	            statement.setString(1, ra);
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
