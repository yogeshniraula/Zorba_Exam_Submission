<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Inventory</title>
</head>
<body>
    <h2>Add New Inventory</h2>
    <form action="submitInventory" method="post" enctype="multipart/form-data">

        <!-- Inventory Category -->
        <label for="category">Inventory Category:</label>
        <select id="category" name="category" required>
            <option value="Grocery">Grocery</option>
            <option value="Cosmetics">Cosmetics</option>
            <option value="Dairy">Dairy</option>
        </select><br><br>

        <!-- Inventory Name -->
        <label for="name">Inventory Name:</label>
        <input type="text" id="name" name="name" required><br><br>

        <!-- Inventory Quantity -->
        <label for="quantity">Inventory Quantity:</label>
        <input type="number" id="quantity" name="quantity" required><br><br>

        <!-- Inventory Price (per unit) -->
        <label for="price">Inventory Price (per unit):</label>
        <input type="text" id="price" name="price" required><br><br>

        <!-- Inventory Image -->
        <label for="image">Inventory Image:</label>
        <input type="file" id="image" name="image" accept="image/png, image/jpeg" required><br><br>

        <!-- Inventory Description -->
        <label for="description">Inventory Description:</label>
        <textarea id="description" name="description" rows="4" cols="50" required></textarea><br><br>

        <button type="submit">Add Inventory</button>
    </form>
</body>
</html>
