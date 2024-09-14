/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.expensetracker;

/**
 *
 * @author AMSY
 */
import java.util.ArrayList;
import java.util.Scanner;
// Expense tracker main class
public class ExpenseTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Expense> expenses = ExpenseStorage.loadExpenses();

        while (true) {
            System.out.println("\nExpense Tracker Menu:");
            System.out.println("1. Add Expenses");
            System.out.println("2. View Expenses");
            System.out.println("3. Edit Expenses");
            System.out.println("4. Delete Expenses");
            System.out.println("5.Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter date (YYYY-MM-DD): ");
                    String date = scanner.next();
                    scanner.nextLine();  // Consume newline left over
                    System.out.print("Enter description: ");
                    String desc = scanner.nextLine();
                    System.out.print("Enter income: ");
                    double income = scanner.nextDouble();
                    System.out.print("Enter recurring cost: ");
                    double amount = scanner.nextDouble();
                    expenses.add(new Expense(date, desc, income, amount));
                    ExpenseStorage.saveExpenses(expenses);
                    break;
                case 2:
                    for (Expense e : expenses) {
                        System.out.println(e);
                    }
                    break;
                case 3:
                    System.out.print("Enter date or description of the expense to edit: ");
                    String searchCriteria = scanner.next();
                    scanner.nextLine();  // Consume newline left over

                    // Find the expense to edit
                    Expense foundExpense = null;
                    for (Expense e : expenses) {
                        if (e.matches(searchCriteria)) {
                            foundExpense = e;
                            break;
                        }
                    }

                    if (foundExpense != null) {
                        System.out.println("Expense found:");
                        System.out.println(foundExpense);
                        System.out.print("Enter the new date (YYYY-MM-DD): ");
                        String newDate = scanner.next();
                        scanner.nextLine();  // Consume newline left over
                        System.out.print("Enter the new description: ");
                        String newDescription = scanner.nextLine();
                        System.out.print("Enter the new income: ");
                        double newIncome = scanner.nextDouble();
                        System.out.print("Enter the new recurring cost: ");
                        double newAmount = scanner.nextDouble();

                        // Update the foundExpense with the new data
                        foundExpense.setData(newDate, newDescription, newIncome, newAmount);

                        ExpenseStorage.saveExpenses(expenses); // Save the updated list of expenses
                        System.out.println("Expense updated successfully.");
                    } else {
                        System.out.println("Expense not found for the provided criteria.");
                    }
                    break;
                case 4:
                    System.out.print("Enter the date of the expense to delete (YYYY-MM-DD): ");
                    String deleteDate = scanner.next();
                    scanner.nextLine();  // Consume newline left over

                    // Find and delete the expense
                    Expense expenseToDelete = null;
                    for (Expense e : expenses) {
                        if (e.hasDate(deleteDate)) {
                            expenseToDelete = e;
                            break;
                        }
                    }

                    if (expenseToDelete != null) {
                        expenses.remove(expenseToDelete); // Remove the expense from the list
                        ExpenseStorage.saveExpenses(expenses); // Save the updated list of expenses
                        System.out.println("Expense deleted successfully.");
                    } else {
                        System.out.println("Expense not found for the provided date.");
                    }
                    
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please select from the menu.");
            }
        }
    }
}

