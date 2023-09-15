import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataRetrieval{
    public static void main(String[] args) {
        try (Connection connection = DatabaseConnection.connect();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM your_table");
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                // データを処理
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                // 他の列も取得可能
                System.out.println("ID: " + id + ", Name: " + name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
