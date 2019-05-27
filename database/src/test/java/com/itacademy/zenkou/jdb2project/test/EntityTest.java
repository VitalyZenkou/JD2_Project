package com.itacademy.zenkou.jdb2project.test;

import com.itacademy.zenkou.jdb2project.dao.UserDao;
import com.itacademy.zenkou.jdb2project.entity.CreditCardType;
import com.itacademy.zenkou.jdb2project.entity.Currency;
import com.itacademy.zenkou.jdb2project.entity.UserRoleType;
import com.itacademy.zenkou.jdb2project.entity.bd.Address;
import com.itacademy.zenkou.jdb2project.entity.bd.BankAccount;
import com.itacademy.zenkou.jdb2project.entity.bd.BaseEntity;
import com.itacademy.zenkou.jdb2project.entity.bd.CreditCard;
import com.itacademy.zenkou.jdb2project.entity.bd.Payment;
import com.itacademy.zenkou.jdb2project.entity.bd.Role;
import com.itacademy.zenkou.jdb2project.entity.bd.User;
import com.itacademy.zenkou.jdb2project.utils.ConnectionManager;
import com.itacademy.zenkou.jdb2project.utils.CreditCardDataGenerator;
import com.itacademy.zenkou.jdb2project.validator.EntityValidator;
import org.hibernate.Session;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;

import static org.testng.Assert.assertNotNull;

public class EntityTest {

    private User savedUser;
    private Address savedAddress;
    private BankAccount savedBankAccount;
    private CreditCard savedCreditCard;
    private Payment savedPayment;
    private Role savedRole;
    private Session session;

    @BeforeMethod
    public void initTestData() {
        session = ConnectionManager.getSession();

        savedUser = User.builder()
                .login("vasia")
                .name("Vasia")
                .password("1234")
                .surname("Pupkin")
                .birthDate(LocalDate.of(1988, 10, 10))
                .build();

        savedAddress = Address.builder()
                .user(savedUser)
                .email("123123@gmail.com")
                .phoneNumber("+375293959859")
                .physicalAddress(Address.PhysicalAddress.builder()
                        .city("Minsk")
                        .street("Pushkina")
                        .houseNumber(38)
                        .flatNumber(10)
                        .build())
                .build();

        savedBankAccount = BankAccount.builder()
                .user(savedUser)
                .balance(new BigDecimal(100))
                .currency(Currency.BYR)
                .isBlocked(false)
                .build();

        savedCreditCard = CreditCard.builder()
                .creditCardType(CreditCardType.VISA)
                .bankAccount(savedBankAccount)
                .cvv(CreditCardDataGenerator.generateCvv())
                .isBlocked(false)
                .number(CreditCardDataGenerator.generateCreditCardNumber())
                .pinCode(CreditCardDataGenerator.generatePinCode())
                .validityDate("12/20")
                .build();

        savedPayment = Payment.builder()
                .bigDecimal(new BigDecimal(5))
                .creditCard(savedCreditCard)
                .isTransaction(false)
                .organization("bla-bla-bla")
                .build();

        savedRole = Role.builder()
                .userRoleType(UserRoleType.SUPER_ADMIN)
                .build();
    }

    @AfterMethod
    public void cleanDataBase() {
        UserDao.getInstance().delete(savedUser);
        session.close();
    }

    @Test
    public void userSaveTest() {
        session.beginTransaction();
        Serializable userId = session.save(savedUser);
        checkICommitAndClear(userId);
        User user = session.get(User.class, userId);
        refreshEntity(savedUser);
        EntityValidator.validateUser(user);
    }

    @Test(dependsOnMethods = "userSaveTest")
    public void addressSaveTest() {
        session.beginTransaction();
        Serializable userId = session.save(savedUser);
        Serializable addressId = session.save(savedAddress);
        checkICommitAndClear(userId, addressId);
        User user = session.get(User.class, userId);
        Address address = session.get(Address.class, addressId);
        refreshEntity(savedUser, savedAddress);
        EntityValidator.validateAddress(address, user);
    }

    @Test(dependsOnMethods = "userSaveTest", enabled = false)
    public void bankAccountSaveTest() {
        session.beginTransaction();
        Serializable userId = session.save(savedUser);
        Serializable bankAccountId = session.save(savedBankAccount);
        checkICommitAndClear(userId, bankAccountId);
        User user = session.get(User.class, userId);
        BankAccount bankAccount = session.get(BankAccount.class, bankAccountId);
        refreshEntity(savedUser, savedBankAccount);
        EntityValidator.validateBankAccount(bankAccount, user);
    }

    @Test(dependsOnMethods = "bankAccountSaveTest", enabled = false)
    public void creditCardSaveTest() {
        session.beginTransaction();
        Serializable userId = session.save(savedUser);
        Serializable bankAccountId = session.save(savedBankAccount);
        Serializable creditCardId = session.save(savedCreditCard);
        checkICommitAndClear(userId, bankAccountId, creditCardId);
        BankAccount bankAccount = session.get(BankAccount.class, bankAccountId);
        CreditCard creditCard = session.get(CreditCard.class, creditCardId);
        refreshEntity(savedUser, savedBankAccount, savedCreditCard);
        EntityValidator.validateCreditCard(creditCard, bankAccount);
    }

    @Test(dependsOnMethods = {"userSaveTest", "bankAccountSaveTest", "creditCardSaveTest"}, enabled = false)
    public void paymentSaveTest() {
        session.beginTransaction();
        Serializable userId = session.save(savedUser);
        Serializable bankAccountId = session.save(savedBankAccount);
        Serializable creditCardId = session.save(savedCreditCard);
        Serializable paymentId = session.save(savedPayment);
        checkICommitAndClear(userId, bankAccountId, creditCardId, paymentId);
        User user = session.get(User.class, userId);
        CreditCard creditCard = session.get(CreditCard.class, creditCardId);
        Payment payment = session.get(Payment.class, paymentId);
        refreshEntity(savedUser, savedBankAccount, savedCreditCard, savedPayment);
        EntityValidator.validatePayment(payment, user, creditCard);
    }

    @Test(dependsOnMethods = "userSaveTest")
    public void roleSaveTest() {
        session.beginTransaction();
        savedUser = savedUser.toBuilder().roles(Collections.singletonList(savedRole)).build();
        Serializable userId = session.save(savedUser);
        checkICommitAndClear(userId);
        User user = session.get(User.class, userId);
        Serializable roleId = user.getRoles().get(0).getId();
        Role role = session.get(Role.class, roleId);
        refreshEntity(savedUser, savedRole);
        EntityValidator.validateUserRole(role, user);
    }

    private void checkICommitAndClear(Serializable... id) {
        for (Serializable serializable : id) {
            assertNotNull(serializable);
        }
        session.getTransaction().commit();
        session.clear();
    }

    private void refreshEntity(BaseEntity... entities) {
        for (BaseEntity entity : entities) {
            session.refresh(entity);
        }
    }
}
