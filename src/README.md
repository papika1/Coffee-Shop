# ☕ Coffee Shop Application

A simple desktop coffee shop application built with Java Swing. 
The application allows users to create orders, manage a cart, and store order data in a MySQL database.

---

## 🚀 Features

- Select coffee type from a dropdown menu
- Set quantity using a spinner
- Automatic price and subtotal calculation
- Add items to cart
- Remove selected item from cart
- Clear entire cart
- Place order and store it in database
- Display:
- current date and time
- number of orders today
- today's revenue
- Data persistence using MySQL

---

## 🧱 Technologies Used

- Java (Swing GUI)
- MySQL
- JDBC
- JUnit (basic unit testing)

---

## 🗄️ Database Structure

### `orders` table

| Column | Type |
|--------------|----------|
| id | INT (PK) |
| order_time | DATETIME |
| total_amount | DOUBLE |

### `order_items` table

| Column | Type |
|------------|----------|
| id | INT (PK) |
| order_id | INT (FK) |
| coffee_type| VARCHAR |
| quantity | INT |
| unit_price | DOUBLE |
| subtotal | DOUBLE |

---

## ⚙️ How It Works

1. User selects a coffee type and quantity
2. Item is added to cart
3. Cart total is calculated dynamically
4. When placing an order:
- Order is saved to `orders`
- Items are saved to `order_items`
- Transaction ensures data consistency

---

## ▶️ How to Run

1. Clone the repository
2. Create a MySQL database:

```sql
CREATE DATABASE coffee_shop;
USE coffee_shop;

CREATE TABLE orders (
    id INT AUTO_INCREMENT PRIMARY KEY,
    order_time DATETIME NOT NULL,
    total_amount DECIMAL(10,2) NOT NULL
);

CREATE TABLE order_items (
    id INT AUTO_INCREMENT PRIMARY KEY,
    order_id INT NOT NULL,
    coffee_type VARCHAR(100) NOT NULL,
    quantity INT NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (order_id) REFERENCES orders(id)
);
ALTER TABLE order_items
ADD COLUMN unit_price DOUBLE;
