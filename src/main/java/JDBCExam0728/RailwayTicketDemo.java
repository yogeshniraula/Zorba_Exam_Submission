package JDBCExam0728;

import java.sql.*;
import java.util.Scanner;

public class RailwayTicketDemo {
    public static <RailwayTickets> void main(String[] args) {
        Connection connection = null;
        String dbUrl = "jdbc:mysql://localhost:3306/?user=root";

        try {
            //load the mysql driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //creating connection to Mysql Database
            connection = DriverManager.getConnection(dbUrl);
            System.out.println("Connection Successful....");
            Statement statement = connection.createStatement();

            String createTable = "Create Table Railway_Reservation(
                    passenger_name varchar(255),
                    paggenger_age int,
                    choosen_seat int,
                    reservation_type varchar(255),
                    is_senior_citizen varchar(255),
                    amount_paid float();" ;


            statement.execute(createTable);


            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter passenger name: ");
            String passengerName = scanner.nextLine();

            System.out.print("Enter passenger age: ");
            Integer passengerAge = scanner.nextInt();

            System.out.print("Enter chosen seat: ");
            Integer chosenSeat = scanner.nextInt();

            System.out.print("Enter reservation type: ");
            String reservationType = scanner.nextLine();

            System.out.print("Is the passenger a senior citizen (YES/NO: ");
            String isSeniorCitizen= scanner.nextLine();

            System.out.print("Enter passenger paid amount: ");
            Float amountPaid = scanner.nextFloat();







            for(int i = 0; i < 100; i++) {
                //prepare the ReservationDetails object
                RailwayTickets ReservationDetails = setRailwayTicketsObject(scanner);



                //insert to tourist_spot_details table
                String insertSpotTable = "insert into tourist_spot_details values(?,?)";
                PreparedStatement preparedStatement = connection.prepareStatement(insertSpotTable);

                int rowsUpdated = preparedStatement.executeUpdate();
                System.out.println(rowsUpdated + " row inserted");

                //inserting to tourist_details table
                String insertQuery = "insert into Railway_Reservation values(?,?,?,?,?,?)";
                System.out.println(rowsUpdated1 + " row inserted");
            }


        }
        catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                    System.out.println("Connection Closed...");




                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }}}}

public static ReservationDetails setRailwayTicketsObject(Scanner scanner) {
    System.out.print("Enter passenger name: ");
    String passengerName = scanner.nextLine();

    System.out.print("Enter passenger age: ");
    Integer passengerAge = scanner.nextInt();

    System.out.print("Enter chosen seat: ");
    Integer chosenSeat = scanner.nextInt();

    System.out.print("Enter reservation type: ");
    String reservationType = scanner.nextLine();

    System.out.print("Is the passenger a senior citizen (YES/NO: ");
    String isSeniorCitizen= scanner.nextLine();

    System.out.print("Enter passenger paid amount: ");
    Float amountPaid = scanner.nextFloat();
}