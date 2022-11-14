package objetos.parcial3.examen;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TravelAgencyTest {

    @Test
    public void givenTravelAgency_whenAddUserAccount_thenAccountIsAdded() {
        // Given:
        TravelAgency travelAgency = new TravelAgency();
        UserAccount userAccount1 = buildUserAccount("user1@gmail.com", "Ivan", "78397", "4442225553");
        UserAccount userAccount2 = buildUserAccount("user2@gmail.com", "Juan", "78394", "4441112223");

        // When:
        String id1 = travelAgency.addUserAccount(userAccount1);
        String id2 = travelAgency.addUserAccount(userAccount2);

        // Then:
        Assertions.assertNotEquals(id1, id2, "Los ids generados deben ser únicos");
    }

    @Test
    public void givenTravelAgency_whenFindUserAccount_thenAccountIsRetrieved() {
        // Given:
        TravelAgency travelAgency = new TravelAgency();
        UserAccount userAccount1 = buildUserAccount("user1@gmail.com", "Ivan", "78397", "4442225553");
        UserAccount userAccount2 = buildUserAccount("user2@gmail.com", "Juan", "78394", "4441112223");

        String id1 = travelAgency.addUserAccount(userAccount1);
        String id2 = travelAgency.addUserAccount(userAccount2);

        // When:
        UserAccount accountFound1 = travelAgency.findAccount(id1);
        UserAccount accountFound2 = travelAgency.findAccount(id2);

        // Then:
        Assertions.assertEquals(accountFound1, userAccount1);
        Assertions.assertEquals(accountFound2, userAccount2);
    }

    @Test
    public void givenTravelAgency_whenFindUserAccountByEmail_thenAccountIsRetrieved() {
        // Given:
        TravelAgency travelAgency = new TravelAgency();
        UserAccount userAccount1 = buildUserAccount("user1@gmail.com", "Ivan", "78397", "4442225553");
        UserAccount userAccount2 = buildUserAccount("user2@gmail.com", "Juan", "78394", "4441112223");

        String id1 = travelAgency.addUserAccount(userAccount1);
        String id2 = travelAgency.addUserAccount(userAccount2);

        // When:
        UserAccount accountFound1 = travelAgency.findAccountByEmail("user1@gmail.com");
        UserAccount accountFound2 = travelAgency.findAccountByEmail("user2@gmail.com");

        // Then:
        Assertions.assertEquals(accountFound1, userAccount1);
        Assertions.assertEquals(accountFound2, userAccount2);
        Assertions.assertEquals(accountFound1.getId(), id1);
        Assertions.assertEquals(accountFound2.getId(), id2);
    }

    @Test
    public void givenTravelAgency_whenFindUserAccountByPhoneNumber_thenAccountIsRetrieved() {
        // Given:
        TravelAgency travelAgency = new TravelAgency();
        UserAccount userAccount1 = buildUserAccount("user1@gmail.com", "Ivan", "78397", "4442225553");
        UserAccount userAccount2 = buildUserAccount("user2@gmail.com", "Juan", "78394", "4441112223");

        String id1 = travelAgency.addUserAccount(userAccount1);
        String id2 = travelAgency.addUserAccount(userAccount2);

        // When:
        UserAccount accountFound1 = travelAgency.findAccountByPhoneNumber("4442225553");
        UserAccount accountFound2 = travelAgency.findAccountByPhoneNumber("4441112223");

        // Then:
        Assertions.assertEquals(accountFound1, userAccount1);
        Assertions.assertEquals(accountFound2, userAccount2);
        Assertions.assertEquals(accountFound1.getId(), id1);
        Assertions.assertEquals(accountFound2.getId(), id2);
    }

    @Test
    public void givenTravelAgency_whenFindUserAccountByEmailNotExistent_thenExceptionIsThrown() {
        // Given:
        TravelAgency travelAgency = new TravelAgency();
        UserAccount userAccount1 = buildUserAccount("user1@gmail.com", "Ivan", "78397", "4442225553");
        UserAccount userAccount2 = buildUserAccount("user2@gmail.com", "Juan", "78394", "4441112223");

        travelAgency.addUserAccount(userAccount1);
        travelAgency.addUserAccount(userAccount2);

        // When / Then:
        Assertions.assertThrows(AccountNotFoundException.class, () -> travelAgency.findAccountByEmail("anyEmail@gmail.com"));
    }

    @Test
    public void givenTravelAgency_whenFindUserAccountByPhoneNumberNotExistent_thenExceptionIsThrown() {
        // Given:
        TravelAgency travelAgency = new TravelAgency();
        UserAccount userAccount1 = buildUserAccount("user1@gmail.com", "Ivan", "78397", "4442225553");
        UserAccount userAccount2 = buildUserAccount("user2@gmail.com", "Juan", "78394", "4441112223");

        travelAgency.addUserAccount(userAccount1);
        travelAgency.addUserAccount(userAccount2);

        // When / Then:
        Assertions.assertThrows(AccountNotFoundException.class, () -> travelAgency.findAccountByPhoneNumber("1234567755"));
    }

    @Test
    public void givenTravelAgency_whenFindUserAccountByIdNotExistent_thenExceptionIsThrown() {
        // Given:
        TravelAgency travelAgency = new TravelAgency();
        UserAccount userAccount1 = buildUserAccount("user1@gmail.com", "Ivan", "78397", "4442225553");
        UserAccount userAccount2 = buildUserAccount("user2@gmail.com", "Juan", "78394", "4441112223");

        travelAgency.addUserAccount(userAccount1);
        travelAgency.addUserAccount(userAccount2);

        // When / Then:
        Assertions.assertThrows(AccountNotFoundException.class, () -> travelAgency.findAccount("1000"));
    }

    @Test
    public void givenTravelAgency_whenAddUserWithNoEmail_thenExceptionIsThrown() {
        // Given:
        TravelAgency travelAgency = new TravelAgency();
        UserAccount userAccount1 = buildUserAccount(null, "Ivan", "78397", "4442225553");

        // When / Then:
        Assertions.assertThrows(EmailRequiredException.class, () -> travelAgency.addUserAccount(userAccount1));
    }

    @Test
    public void givenTravelAgency_whenAddUserWithNoPhoneNumber_thenExceptionIsThrown() {
        // Given:
        TravelAgency travelAgency = new TravelAgency();
        UserAccount userAccount1 = buildUserAccount("test@gmail.com", "Ivan", "78397", null);

        // When / Then:
        Assertions.assertThrows(PhoneNumberRequiredException.class, () -> travelAgency.addUserAccount(userAccount1));
    }

    @Test
    public void givenTravelAgency_whenEmailAlreadyExists_thenExceptionIsThrown() {
        // Given:
        TravelAgency travelAgency = new TravelAgency();
        UserAccount userAccount1 = buildUserAccount("user1@gmail.com", "Ivan", "78397", "4442225553");
        UserAccount userAccount2 = buildUserAccount("user1@gmail.com", "Juan", "78394", "4441112223");

        travelAgency.addUserAccount(userAccount1);

        // When / Then:
        Assertions.assertThrows(DuplicatedEmailsNotAllowedException.class, () -> travelAgency.addUserAccount(userAccount2));
    }

    @Test
    public void givenTravelAgency_whenPhoneNumberAlreadyExists_thenExceptionIsThrown() {
        // Given:
        TravelAgency travelAgency = new TravelAgency();
        UserAccount userAccount1 = buildUserAccount("user1@gmail.com", "Ivan", "78397", "4442225553");
        UserAccount userAccount2 = buildUserAccount("user2@gmail.com", "Juan", "78394", "4442225553");

        travelAgency.addUserAccount(userAccount1);

        // When / Then:
        Assertions.assertThrows(DuplicatedPhoneNumbersNotAllowedException.class, () -> travelAgency.addUserAccount(userAccount2));
    }

    @Test
    public void givenTravelAgency_whenRemoveUserAccount_thenAccountIsRemoved() throws AccountNotPresentOnRemoveAttemptException {
        // Given:
        TravelAgency travelAgency = new TravelAgency();
        UserAccount userAccount1 = buildUserAccount("user1@gmail.com", "Ivan", "78397", "4442225553");
        UserAccount userAccount2 = buildUserAccount("user2@gmail.com", "Juan", "78394", "4441112223");

        String id1 = travelAgency.addUserAccount(userAccount1);
        String id2 = travelAgency.addUserAccount(userAccount2);

        // When:
        UserAccount accountFound1 = travelAgency.removeAccount(id1);

        // Then:
        Assertions.assertEquals(accountFound1, userAccount1);
        Assertions.assertEquals(travelAgency.findAccount(id2), userAccount2);
    }

    @Test
    public void givenTravelAgency_whenRemoveUserAccountThatDoesNotExist_thenExceptionIsThrown() throws AccountNotPresentOnRemoveAttemptException {
        // Given:
        TravelAgency travelAgency = new TravelAgency();
        UserAccount userAccount1 = buildUserAccount("user1@gmail.com", "Ivan", "78397", "4442225553");
        UserAccount userAccount2 = buildUserAccount("user2@gmail.com", "Juan", "78394", "4441112223");

        String id1 = travelAgency.addUserAccount(userAccount1);
        String id2 = travelAgency.addUserAccount(userAccount2);

        // When:
        AccountNotPresentOnRemoveAttemptException exception = Assertions.assertThrows(AccountNotPresentOnRemoveAttemptException.class, () -> travelAgency.removeAccount("ABC123"));

        // Then:
        Assertions.assertEquals(travelAgency.findAccount(id1), userAccount1);
        Assertions.assertEquals(travelAgency.findAccount(id2), userAccount2);
        Assertions.assertEquals("Account with Id 'ABC123' does not exist", exception.getMessage());
    }

    private static UserAccount buildUserAccount(String email, String name, String zipCode, String phoneNumber) {
        UserAccount userAccount = new UserAccount();

        userAccount.setEmail(email);
        userAccount.setName(name);
        userAccount.setZipCode(zipCode);
        userAccount.setPhoneNumber(phoneNumber);

        return userAccount;
    }
}
