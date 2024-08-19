package execution;

//2. Take console input as customer info, product details that they are trying to order.
//While taking input, need to put a few validations. Find below the validation rules:
//        1. ProductId should be in the format of 'P01'
//        2. Customer id should be in the format of 'C01'
//        3. Customer phone number should be 10, not more than that.

import com.mysql.cj.conf.PropertyDefinitions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CustomerInfoExecution {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);


        System.out.println("Insert Product Id");
        String ProductId = scanner.nextLine();

        System.out.println("Insert Customer Id");
        String CustomerId = scanner.nextLine();


        System.out.println("Insert Customer Phone Number");
        String CustPhone = scanner.nextLine();

        System.out.println("What type product are you ordering?: ‘grocery’/’cosmetics’/’dairyproduct’.");





    }
    private static boolean isValidCustomerId(String CustomerId) {
        return CustomerId.matches("C\\d{2}");
    }

    private static boolean isValidProductId(String ProductId) {
        return ProductId.matches("P\\d{2}");
    }

    private static boolean isValidPhoneNumber(String custPhone) {
        return custPhone.matches("\\d{10}");
    }

}


