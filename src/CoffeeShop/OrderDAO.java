package CoffeeShop;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class OrderDAO {
	
	public void saveOrder(Order order) throws SQLException {

        String insertOrderSQL = "INSERT INTO orders (order_time, total_amount) VALUES (?, ?)";
        String insertItemSQL = "INSERT INTO order_items (order_id, coffee_type, quantity,"
        		+ " unit_price, price) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection()) {

            conn.setAutoCommit(false);

            try (
                PreparedStatement orderStmt = conn.prepareStatement(insertOrderSQL, 
                		Statement.RETURN_GENERATED_KEYS);
                PreparedStatement itemStmt = conn.prepareStatement(insertItemSQL)
            ) {

                
                orderStmt.setTimestamp(1, Timestamp.valueOf(order.getOrderTime()));
                orderStmt.setDouble(2, order.getTotalAmount());

                orderStmt.executeUpdate();

                
                ResultSet rs = orderStmt.getGeneratedKeys();
                int orderId;

                if (rs.next()) {
                    orderId = rs.getInt(1);
                } else {
                    throw new SQLException("Failed to retrieve order ID.");
                }

                
                for (OrderItem item : order.getItems()) {

                    itemStmt.setInt(1, orderId);
                    itemStmt.setString(2, item.getCoffeeType().name());
                    itemStmt.setInt(3, item.getQuantity());
                    itemStmt.setDouble(4, item.getUnitPrice());
                    itemStmt.setDouble(5, item.getSubtotal());

                    itemStmt.addBatch();
                }

                itemStmt.executeBatch();

                conn.commit();

            } catch (Exception e) {
                conn.rollback();
                throw e;
            }
        }
    }
	
	public int getTodayOrderCount() {
        String sql = "SELECT COUNT(*) FROM orders WHERE DATE(order_time) = CURDATE()";

        try (
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()
        ) {
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
		
			e.printStackTrace();
		}

        return 0;
    }

    public double getTodayRevenue() {
        String sql = "SELECT COALESCE(SUM(total_amount), 0) FROM orders WHERE DATE(order_time) = "
        		+ "CURDATE()";

        try (
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()
        ) {
            if (rs.next()) {
                return rs.getDouble(1);
            }
        } catch (SQLException e) {
			
			e.printStackTrace();
		}

        return 0.0;
    }
	
}
