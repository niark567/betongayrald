package org.niark.betongayrald.client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import org.apache.commons.lang.SystemUtils;
import org.niark.CommunicationManager;

public class Client
{

	private static final int		DEFAULT_PORT	= 31337;

	private static final String		username		= System.getProperty(SystemUtils.USER_NAME);

	private Socket					_socket;

	private CommunicationManager	communicationManager;

	public Client(Socket socket)
	{
		this._socket = socket;
	}

	public static void main(String[] args)
	{
		// TODO
		// String s_port = System.getProperty(CLIENT_PORT);
		int port;
		// if(StringUtils.isEmpty(s_port)) {
		port = DEFAULT_PORT;
		// }

		Socket socket;

		try
		{
			socket = new Socket((String) null /* TODO */, port);
		}
		catch (UnknownHostException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}

		Client c = new Client(socket);
		c.init();
		c.login();
		c.run();
		c.logout();
	}

	private void init()
	{
		communicationManager = new CommunicationManager(_socket);
	}

	private void run()
	{
		try
		{
			// Show the server response
			System.out.println("Server message: " + communicationManager.read());
		}
		catch (UnknownHostException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				_socket.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}

	private void login()
	{
		// // TODO Auto-generated method stub
		// String msg = "Je suis " + username;
		//
		// try
		// {
		// _socket.getOutputStream().write(msg.getBytes());
		// }
		// catch (IOException e)
		// {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		// TODO
		// new BufferedReader(new InputStreamReader(input)).readLine()
		// _socket.getInputStream().read
	}

	private void logout()
	{
		// TODO Auto-generated method stub
	}

}
