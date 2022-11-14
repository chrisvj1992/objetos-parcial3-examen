package objetos.parcial3.examen;


import java.util.ArrayList;
import java.util.List;

public class TravelAgency {


   private List<UserAccount> travelAgency = new ArrayList<>();

    public String  addUserAccount(UserAccount userAccount1)  {

        for(UserAccount userAccount: travelAgency){
            if(userAccount.getPhoneNumber().equals( userAccount1.getPhoneNumber() )){
                throw new DuplicatedPhoneNumbersNotAllowedException("This Phone number is already in use ");
            }
        }


        for(UserAccount userAccount: travelAgency){
            if(userAccount.getEmail().equals( userAccount1.getEmail() )){
                throw new DuplicatedEmailsNotAllowedException("This email is already in use ");
            }
        }

        travelAgency.add(userAccount1);

        return userAccount1.getId();
    }

    public UserAccount findAccount(String id1){

        for(UserAccount userAccount: travelAgency){
            if(userAccount.getId().equals(id1)){
                return userAccount;
            }
        }
        throw new AccountNotFoundException("The Account has not been founded");

    }

    public UserAccount findAccountByEmail(String s){

        for(UserAccount userAccount: travelAgency){
            if(userAccount.getEmail().equals(s)){
                return userAccount;
            }
        }
        throw new AccountNotFoundException("The Account has not been founded");
    }

    public UserAccount findAccountByPhoneNumber(String s){

        for(UserAccount userAccount: travelAgency){
            if(userAccount.getPhoneNumber().equals(s)){
                return userAccount;
            }
        }
        throw new AccountNotFoundException("The Account has not been founded");
    }

    public UserAccount removeAccount(String id1) {


        for(UserAccount userAccount: travelAgency){
            if(userAccount.getId().equals(id1)){
                travelAgency.remove(id1);
            }else{
                throw new AccountNotPresentOnRemoveAttemptException("The Account can´t be Removed, because it doesnt exist");
            }
        }
        return null;
    }
}
