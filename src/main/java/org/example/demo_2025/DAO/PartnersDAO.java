package org.example.demo_2025.DAO;

import org.example.demo_2025.models.Partner;

import java.sql.*;


public class PartnersDAO {
    private final Connection connection;

    public PartnersDAO(Connection connection) {
        this.connection = connection;
    }

    // Метод для добавления нового партнера
    public int addPartner(Partner partner) throws SQLException {
        String sql = "INSERT INTO partners (type, company_name, legal_address, inn, director_name, contact_phone, contact_email, logo, rating, sales_places, discount_history) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, partner.getType());
            statement.setString(2, partner.getCompanyName());
            statement.setString(3, partner.getLegalAddress());
            statement.setString(4, partner.getInn());
            statement.setString(5, partner.getDirectorName());
            statement.setString(6, partner.getContactPhone());
            statement.setString(7, partner.getContactEmail());
            statement.setBytes(8, partner.getLogo());
            statement.setString(9, partner.getRating());
            statement.setString(10, partner.getSalesPlaces());
            statement.setString(11, partner.getDiscountHistory());

            // Выполняем запрос
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Не удалось создать партнера, ни одна строка не была затронута.");
            }

            // Получаем сгенерированные ключи
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1); // Возвращаем сгенерированный ID
                } else {
                    throw new SQLException("Не удалось создать партнера, идентификатор не получен.");
                }
            }
        }
    }

}
