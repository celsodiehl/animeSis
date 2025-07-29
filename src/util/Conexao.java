package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

/**
 * @author Celso
 */
public class Conexao {

    private static EntityManagerFactory factory;

    static {
        try {
            InputStream prop_file = new FileInputStream("C:/Easy/AnimeSis.properties");
//            if (!prop_file.isFile()) {
//                try {
//                    throw new Exception(
//                            "Arquivo de propriedade não encontrado, caminho.: " + prop_file.getAbsolutePath() + ", errado.!");
//                } catch (Exception ex) {
//                    Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
//                }
//               }
            Properties prop = new Properties();

            prop.load(prop_file);
           // prop.setProperty("javax.persistence.jdbc.url", "jdbc:postgresql://192.168.1.3:5432/anime");
            prop.setProperty("javax.persistence.jdbc.user", "postgres");
            prop.setProperty("javax.persistence.jdbc.password", "postdba");
            prop.setProperty("javax.persistence.jdbc.driver", "org.postgresql.Driver");
            prop.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
            prop.setProperty("hibernate.cache.provider_class", "org.hibernate.cache.NoCacheProvider");
            //C3PO
           // prop.setProperty("hibernate.connection.provider_class", "org.hibernate.connection.C3P0ConnectionProvider");
           // prop.setProperty("hibernate.c3p0.acquire_increment", "5");
//            prop.setProperty("hibernate.c3p0.idle_test_period", "1800");
//            prop.setProperty("hibernate.c3p0.max_size", "600");
//            prop.setProperty("hibernate.c3p0.max_statements", "50");
//            prop.setProperty("hibernate.c3p0.min_size", "5");
//            prop.setProperty("hibernate.c3p0.timeout", "1800");
                    
            prop.setProperty("hibernate.hbm2ddl.auto", "update");
            prop.setProperty("hibernate.format_sql", "true");
            prop.setProperty("hibernate.show_sql", "false");
            System.out.println("util.Conexao.: " + prop);

            try {
                factory = Persistence.createEntityManagerFactory("animeSisPU", prop);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao Conectar com Banco de Dados.:\n " + ex.getMessage(), "ERROR.: ", JOptionPane.ERROR_MESSAGE);
            }
        } catch (IOException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static EntityManager getEM() {
        return factory.createEntityManager();
    }

    public static void close() {
        factory.close();
    }

}
