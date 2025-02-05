package org.example.demo_2025.tests;

import org.example.demo_2025.DAO.PartnersDAO;
import org.example.demo_2025.models.Partner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class PartnersTest {
    public static void main(String[] args) {
        // Параметры подключения к базе данных
        String url = "jdbc:postgresql://localhost:5432/demo_2025"; // URL
        String user = "evgenyportnov"; // имя пользователя
        String password = "hello88sharky"; // пароль

        // Создаем соединение и тестируем метод addPartner
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            PartnersDAO partnersDAO = new PartnersDAO(connection);

            // Создаем объект Partner
            Partner partner = new Partner();
            partner.setType("Тип партнера");
            partner.setCompanyName("Название компании");
            partner.setLegalAddress("Юридический адрес");
            partner.setInn("1567890");
            partner.setDirectorName("Имя Директора");
            partner.setContactPhone("+1234567890");
            partner.setContactEmail("email@example.com");
            partner.setLogo(null); // Если нет логотипа, установите null или массив байтов
            partner.setRating("5");
            partner.setSalesPlaces("Место 1, Место 2");
            partner.setDiscountHistory("История скидок");

            // Вызываем метод addPartner
            int generatedId = partnersDAO.addPartner(partner);
            System.out.println("Партнер добавлен с ID: " + generatedId);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
