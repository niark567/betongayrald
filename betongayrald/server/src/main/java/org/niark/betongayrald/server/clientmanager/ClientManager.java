package org.niark.betongayrald.server.clientmanager;

import java.net.Socket;

import org.niark.CommunicationManager;

public abstract class ClientManager extends Thread
{

	protected CommunicationManager	communicationManager;

	public ClientManager(Socket client)
	{
		this.communicationManager = new CommunicationManager(client);
	}

	public void run()
	{
		login();
		loop();
		logout();
	}

	protected abstract void login();

	protected abstract void loop();

	protected abstract void logout();

}
