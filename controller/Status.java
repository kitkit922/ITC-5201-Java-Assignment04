package controller;

/*************************************************************************************************
 * Course_Name – Assignment 04
 * 
 * I declare that this assignment is my own work in accordance with Humber
 * Academic Policy. 
 * 
 * No part of this assignment has been copied manually or electronically from
 * any other source (including web sites) or distributed to other students/social media.
 * 
 * Name: Wenhao Fand 
 * Student ID: N01555914
 * Date: 2023/03/17
 * 
 *************************************************************************************************/

/**
 * This is an enum of the status.
 * 
 * @author Wenhao Fang
 */
public enum Status {
    SUCCESS, // when the controller's action executes as expected.
    WARNING, // when the controller's action executes not as expected.
    ERROR// when the controller's action fails and raised an exception.
}
