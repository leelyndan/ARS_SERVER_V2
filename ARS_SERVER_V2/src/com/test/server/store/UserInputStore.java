package com.test.server.store;

import java.util.ArrayList;
import java.util.List;

import com.test.server.util.StringUtils;

public class UserInputStore
{
    
    private List<String> userInputCmd;
    
    public UserInputStore()
    {
        userInputCmd = new ArrayList<String>(10);
    }
    
    public void addUserInputCmd(String cmd)
    {
        if (StringUtils.isEmpty(cmd))
        {
            return;
        }
        userInputCmd.add(cmd);
    }
    
    public String getUserInputCmd(int index)
    {
        if (index >= userInputCmd.size())
        {
            return null;
        }
        return userInputCmd.get(index);
    }
    
    public String getLastUserInputCmd()
    {
        return userInputCmd.get(userInputCmd.size() - 1);
    }
    
    public void removeUserInputLastCmd()
    {
        userInputCmd.remove(userInputCmd.size() - 1);
    }
    
    public int getInputListSize()
    {
        return userInputCmd.size();
    }
}
