package com.study.gupao;

import com.study.gupao.api.IUserService;
import com.study.gupao.client.RomateInstance;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        RomateInstance romateInstance = new RomateInstance();
        IUserService userService = romateInstance.getInstance(IUserService.class);
        userService.getUsername();
    }
}
