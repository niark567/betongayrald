package org.niark.betongayrald.server.clientmanager.impl;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import org.niark.betongayrald.server.clientmanager.ClientManager;

public class BetOnGayraldClientManager extends ClientManager
{

	public BetOnGayraldClientManager(Socket client)
	{
		super(client);
	}

	@Override
	protected void login()
	{
		// TODO Auto-generated method stub

	}

	@Override
	protected void loop()
	{
		String _message = "Hello I'm your server.";

		// TODO loop
		PrintWriter out;
		try
		{
			System.out.println("New client, address " + communicationManager.getSocket().getInetAddress() + " on " + communicationManager.getSocket().getPort() + ".");
			communicationManager.write(_message);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	protected void logout()
	{
		try
		{
			communicationManager.getSocket().close();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
