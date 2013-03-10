package org.niark.betongayrald.server;

import java.io.IOException;
import java.net.ServerSocket;

import org.niark.betongayrald.server.clientmanager.ClientManager;
import org.niark.betongayrald.server.clientmanager.impl.BetOnGayraldClientManager;

public class Server
{
	private static final int	DEFAULT_PORT	= 31337;

	private static int			_port;
	private static ServerSocket	_socket;

	public static void main(String[] args)
	{
		try
		{
			_port = (args.length == 1) ? Integer.parseInt(args[0]) : DEFAULT_PORT;
			_socket = new ServerSocket(_port);

			System.out.println("TCP server is running on " + _port + "...");

			while (true)
			{
				ClientManager c = new BetOnGayraldClientManager(_socket.accept());
				c.start();
			}
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

}
