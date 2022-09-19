package Structures;

public class UserBasic extends User {

    //ctor
    public UserBasic(String uName, String uPasswd) {
        super(uName, uPasswd);
    }

    @Override
    public void UserMenu() { super.UserMenu();}
    @Override
    public void TreatMenuInput(String i){ super.TreatMenuInput(i); }
}
