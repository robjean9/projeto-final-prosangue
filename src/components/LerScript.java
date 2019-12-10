package components;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import org.apache.ibatis.jdbc.ScriptRunner;

/**
 *
 * @author Rafael Penczkoski
 */
public class LerScript {

    private final String DB_URL = "jdbc:mysql://localhost/?useTimezone=true&serverTimezone=UTC";
    private final String USERNAME = "root";
    private final String PASSWORD = "root";

    public void runScript(File file) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        ScriptRunner sr = new ScriptRunner(conn);
        Reader reader = new BufferedReader(new FileReader(file));
        sr.runScript(reader);
    }

}
