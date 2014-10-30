package com.thoughtworks.iamcoach.pos.dao;

import com.thoughtworks.iamcoach.pos.PromotionFactory;
import com.thoughtworks.iamcoach.pos.util.DatabaseUtil;
import com.thoughtworks.iamcoach.pos.vo.Item;
import com.thoughtworks.iamcoach.pos.vo.Promotion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemDao {
    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    public List<Item> getItems() {
        List<Item> itemList = new ArrayList<Item>();
        String sql = "SELECT * FROM item";

        try {
            connection = DatabaseUtil.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Item item = new Item(resultSet.getInt("id"), resultSet.getString("barcode"),
                        resultSet.getString("name"), resultSet.getString("unit"),
                        resultSet.getDouble("price"), resultSet.getString("category"));
                itemList.add(item);
            }
            resultSet.close();
            statement.close();
            DatabaseUtil.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return itemList;
    }

    public Item getItemById(int id) {
        Item item = null;
        String sql = "SELECT * FROM item WHERE id=?";
        try {
            connection = DatabaseUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            item = new Item(resultSet.getInt("id"), resultSet.getString("barcode"),
                    resultSet.getString("name"), resultSet.getString("unit"),
                    resultSet.getDouble("price"), resultSet.getString("category"));
            preparedStatement.close();
            resultSet.close();
            DatabaseUtil.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    public List<Promotion> getItemPromotionList(int id) {
        List<Promotion> promotionList = new ArrayList<Promotion>();
        String sql = "SELECT promotion.*,promotion_item.discount FROM promotion,promotion_item " +
                "WHERE promotion_item.item_id=? AND promotion.id=promotion_item.promotion_id";
        try {
            connection = DatabaseUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Promotion promotion = PromotionFactory.createPromotion(resultSet.getInt("id"), resultSet.getString("type"),
                        resultSet.getInt("discount"), resultSet.getInt("level"));
                promotionList.add(promotion);
            }
            resultSet.close();
            preparedStatement.close();
            DatabaseUtil.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return promotionList;
    }

    public Item getItemByBarcode(String barcode) {
        Item item = null;
        String sql = "SELECT * FROM item WHERE barcode=?";
        try {
            connection = DatabaseUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, barcode);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            item = new Item(resultSet.getInt("id"), resultSet.getString("barcode"),
                    resultSet.getString("name"), resultSet.getString("unit"),
                    resultSet.getDouble("price"), resultSet.getString("category"));

            resultSet.close();
            preparedStatement.close();
            DatabaseUtil.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

}
