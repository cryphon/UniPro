import Structures.User;
import Structures.UserDB;

import java.util.Objects;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        while(true){
            User user = userLogin();
            user.UserMenu();
        }
    }

    public static User userLogin(){
        UserDB userdb = UserDB.getInstance();
        User u;
        do{
            var sc = new Scanner(System.in);
            System.out.print("\nEnter username: ");
            String uName = String.valueOf(sc.next());
            System.out.print("Enter password: ");
            String uPasswd = String.valueOf(sc.next());

            u = UserDB.GetUserCredentialsVerification(uName, uPasswd);

            if(u != null)
                break;
            System.out.print("Incorrect credentials\n");
        }while(Objects.isNull(u));

        return u;
    }
}
