package TGHM;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author THARUN
 */
class ManagementAuth 
{
    private String username;
    private String password;
    ManagementAuth(String user,String pass)
    {
        username = user;
        password = pass;
    }
    public String getUsername()
    {
        return username;
    }
    public boolean checkPassword(String checkPass)
    {
        return checkPass.equals(password);
    }
}
