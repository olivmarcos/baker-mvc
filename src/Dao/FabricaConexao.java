package Dao;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class FabricaConexao {
 
    private static final String STR_DRIVER = "org.gjt.mm.mysql.Driver";  // definiÃ§Ã£o de qual banco serÃ¡ utilizado
    private static final String DATABASE = "baker"; // Nome do banco de dados         
    private static final String IP = "localhost";  // ip de conexao
    private static final String STR_CON = "jdbc:mysql://" + IP + ":3306/" + DATABASE; // string de conexao com o banco de dados
    private static final String USER = "root"; // Nome do usuÃ¡rio
    private static final String PASSWORD = ""; // senha
    private static Connection objConexao = null;
 
    public FabricaConexao() {
        try{
            Class.forName(STR_DRIVER);
            objConexao = DriverManager.getConnection(STR_CON, USER, PASSWORD);
            System.out.println("deu certo");
        }catch (ClassNotFoundException e) {   
            String errorMsg = "Driver nao encontrado: "+e.getMessage();    
            System.out.println(errorMsg);
        } catch (SQLException e) {   
            String errorMsg = "Erro ao obter a conexao: "+e.getMessage();   
            System.out.println(errorMsg);
        }   
    }
 
    public static Connection GeraConexao() {
        if (objConexao == null) {
            FabricaConexao MANTERCONEXAO = new FabricaConexao();
        }
        return objConexao;
    }
     
}