package com.company;

import java.util.Scanner;

public class Email {
    private final String firstName;
    private final String lastName;
    private String password;
    private String email;
    private String department;
    private int mailBoxCapacity = 500;
    private int passwordLength = 10;
    private String alternateEmail;
    private String companySuffix = "company.com";

    // Constructor will receive first and las name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("EMAIL CREATED: " + this.firstName + " " + this.lastName + ".");

        // Call a method asking for the department
        this.department = setDepartment();
        System.out.println("Department is: " + this.department);

        // Call a method that returns a random password
        this.password = randomPassword(passwordLength);
        System.out.println("Your password is: " + this.password);

        // Combine elements to generate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + this.department + this.companySuffix;
        System.out.println("Your company email is: " + email);
    }

    // Ask for the department
    private String setDepartment() {
        int depChoice;

        System.out.println("Department codes\n1 for Sales\n2 for Development\n3 for Accounting\n0 for None\nEnter department code: ");
        Scanner in = new Scanner(System.in);

        depChoice = in.nextInt();

        if (depChoice == 1) return "sales";
        else if (depChoice == 2) return "dev";
        else if (depChoice == 3) return "acct";
        else return "No department";
    }

    // Generate a random password
    private String randomPassword(int length) {
        String passwordSet = "QWERTYUIOPASDFGHJKLZXCVBNM1234567890!@#$%^&*_+";
        char[] password = new char[length];

        for (int i = 0; i < length; i++) {
            int randInt = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(randInt);
        }

        return new String(password);
    }

    // Set the mailbox capacity
    public void setMailBoxCapacity(int capacity) {
        this.mailBoxCapacity = capacity;

    }

    // Set alternate email
    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;

    }

    // Change the password
    public void changePassword(String newPassword) {
        this.password = password;
    }

    public int getMailBoxCapacity() {
        return mailBoxCapacity;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }
}

