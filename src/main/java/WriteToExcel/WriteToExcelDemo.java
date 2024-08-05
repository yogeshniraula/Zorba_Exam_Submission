package WriteToExcel;

import java.sql.Connection;

public class WriteToExcelDemo {

    public class FirstJdbcConnection {
        public static void main(String[] args) {
            Connection connection = null;
            String dbUrl = "jdbc:mysql://localhost:3306/Zorba_1015_batch_sql_practice";
            String userName = "root";
            String password = "Troyguy2123!";

            try {
                //load the mysql driver
                Class.forName("com.mysql.cj.jdbc.Driver");

                //creating connection to Mysql Database
                connection = DriverManager.getConnection(dbUrl, userName, password);
                System.out.println("Connection Successful....");

                //Schema information
                DatabaseMetaData databaseMetaData = connection.getMetaData();
                String[] type = {"TABLE"};
                ResultSet tableSet = databaseMetaData.getTables("Zorba_1015_batch_sql_practice", "Zorba_1015_batch_sql_practice", "%", type);
                ResultSetMetaData tableSetMetaData = tableSet.getMetaData();
                System.out.println(tableSetMetaData.getColumnName(1) + " " + tableSetMetaData.getColumnName(2) + " " + tableSetMetaData.getColumnName(3));
                while (tableSet.next()) {
                    System.out.println(tableSet.getString(1));
                    System.out.println(tableSet.getString(2));
                    System.out.println(tableSet.getString(3));
                }

                //create a new table named tax
                String createQuery = "create table tax(tax_id int(4), tax_name varchar(255))";
                Statement createStatement = connection.createStatement();
                createStatement.execute(createQuery);
                System.out.println("New Table has been created...");

                //alter table add primary key
                String alterQuery = "alter table tax add primary key(tax_id)";
                createStatement.execute(alterQuery);
                System.out.println("Table altered...");

                //insert data into tax table
                String insertQuery = "insert tax values(?, ?)";
                PreparedStatement insetStatement = connection.prepareStatement(insertQuery);
                insetStatement.setInt(1, 1008);
                insetStatement.setString(2, "Road Tax");
                int noOfRowsEffected = insetStatement.executeUpdate();
                System.out.println(noOfRowsEffected + " Row inserted..");

                //fetch data from tax table
                String query = "select * from tax";

                //Create Statement object
                //Statement statement = connection.createStatement();
                //ResultSet resultSet = statement.executeQuery(query);

                //create Prepared statement object
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                //preparedStatement.setInt(1, 105);
                //preparedStatement.setString(2, "Alex");
                ResultSet resultSet = preparedStatement.executeQuery();

                //To get the table column information
                ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
                int noOfColumn = resultSetMetaData.getColumnCount();
                System.out.println("No Of Column Present :: "+noOfColumn);
                System.out.println(resultSetMetaData.getColumnName(2));
                System.out.println(resultSetMetaData.getColumnClassName(2));

                //to display the data returned from database
                while (resultSet.next()) {
                    int taxId = resultSet.getInt(1);
                    String taxName = resultSet.getString(2);
                    System.out.println(taxId + " " + taxName);
                }

                //delete statement
                String deleteQuery = "delete from tax where tax_id = ?";
                PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery);
                deleteStatement.setInt(1, 1008);
                int rowEffected = deleteStatement.executeUpdate();
                System.out.println(rowEffected + "row deleted..");
            } catch (ClassNotFoundException | SQLException e) {
                System.err.println(e.getMessage());
            } finally {
                if (connection != null) {
                    try {
                        connection.close();
                        System.out.println("Connection Closed...");
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                }
            }
        }
    }
}
