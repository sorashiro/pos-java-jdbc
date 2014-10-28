package com.thoughtworks.iamcoach.pos.dao;

import com.thoughtworks.iamcoach.pos.util.DatabaseUtil;
import com.thoughtworks.iamcoach.pos.vo.Item;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemDao {
    private Connection connection = DatabaseUtil.getConnection();

    public List<Item> getItems() {
        List<Item> itemList = new ArrayList<Item>();
        String sql = "SELECT * FROM item";

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Item item = new Item(resultSet.getInt("id"), resultSet.getString("barcode"),
                        resultSet.getString("name"), resultSet.getString("unit"),
                        resultSet.getDouble("price"), resultSet.getString("category"));
                itemList.add(item);
            }
            statement.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DatabaseUtil.closeConnection();
        return itemList;
    }

    public Item getItemById(int id) {
        Item item = null;
        String sql = "SELECT * FROM item WHERE id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            item = new Item(resultSet.getInt("id"), resultSet.getString("barcode"),
                    resultSet.getString("name"), resultSet.getString("unit"),
                    resultSet.getDouble("price"), resultSet.getString("category"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }


}
