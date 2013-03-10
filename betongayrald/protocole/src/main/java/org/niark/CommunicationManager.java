package org.niark;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class CommunicationManager
{

	private Socket	socket;

	public CommunicationManager(Socket s)
	{
		if (s == null || !s.isConnected() || !s.isBound() || s.isClosed())
		{
			throw new IllegalStateException("Impossible d'établir une communication.");
		}
		
		this.socket = s;
	}

	public void write(String msg) throws IOException
	{
		if (!socket.isConnected())
		{
			throw new IllegalStateException("Impossible d'envoyer un message : la communication est terminée.");
		}

		OutputStream os = socket.getOutputStream();

		os.write(msg.getBytes());
		os.flush();
	}

	public String read() throws IOException
	{
		if (!socket.isConnected())
		{
			throw new IllegalStateException("Impossible de lire un message : la communication est terminée.");
		}

		String msg = null;

		InputStreamReader isr = new InputStreamReader(socket.getInputStream());

		if (isr.ready())
		{
			BufferedReader bis = new BufferedReader(isr);
			msg = bis.readLine();
		}

		isr.close();

		return msg;
	}

	public Socket getSocket()
	{
		return this.socket;
	}

}
