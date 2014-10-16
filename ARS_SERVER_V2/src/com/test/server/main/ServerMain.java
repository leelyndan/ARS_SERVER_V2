package com.test.server.main;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.test.server.execute.ThreadMethod;

public class ServerMain {

	private ServerSocket server = null;

	private static int PORT = 4700;

	private void startServer() 
	{
		try 
		{
			server = new ServerSocket(PORT);
			System.out.println("server start ");
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	private void execute()
	{

		while (true) 
		{
			Socket socket = null;
			try 
			{
				socket = server.accept();
				new ThreadMethod(socket).start();
			} 
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) 
	{
		ServerMain server = new ServerMain();
		server.startServer();
		server.execute();
	}
}
