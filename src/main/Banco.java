package src.main;

import java.sql.*;

public class Banco {
    public static void criarTabelas() {
        try (Connection conexao = DriverManager.getConnection("jdbc:sqlite:sqlite.db")) {
            System.out.println("[banco] Conexão com o banco realizada.");

            Statement stmt = conexao.createStatement();

            // Tabela de usuários
            stmt.execute("""
                    CREATE TABLE IF NOT EXISTS usuarios (
                        id INTEGER NOT NULL PRIMARY KEY,
                        nome VARCHAR(255),
                        telefone VARCHAR(255),
                        idade INTEGER,
                        cpf VARCHAR(255),
                        login VARCHAR(255),
                        senha VARCHAR(255)
                    )
                    """);
            System.out.println("[banco] Tabela `users` criada com sucesso.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
