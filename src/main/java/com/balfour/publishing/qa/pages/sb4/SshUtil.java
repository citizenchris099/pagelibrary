package com.balfour.publishing.qa.pages.sb4;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;

import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.common.IOUtils;
import net.schmizz.sshj.connection.channel.direct.Session;
import net.schmizz.sshj.connection.channel.direct.Session.Command;
import net.schmizz.sshj.userauth.keyprovider.PKCS8KeyFile;
import net.schmizz.sshj.userauth.method.AuthPublickey;

import org.openqa.selenium.WebDriver;

import com.balfour.publishing.qa.pages.Page;

/**
 * utility class whose methods are intended to aid in ssh access to various
 * environments.
 * 
 * @author cmanning
 * 
 */
public class SshUtil extends Page {

	public SshUtil(WebDriver driver) {
		super(driver);
	}

	/**
	 * method used to verify negative result (no file present). as is the case
	 * when deleting files etc...
	 * 
	 * @param ip
	 *            : of box to access
	 * @param authusr
	 *            : user name
	 * @param cmd
	 *            : command to execute on the box
	 * @return
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public SshUtil rmFile(String ip, String authusr, String cmd)
			throws IOException, URISyntaxException {

		final SSHClient ssh = new SSHClient();
		ssh.addHostKeyVerifier("c4:27:0b:af:9d:b9:24:d2:6f:aa:e7:c7:75:7f:f9:8a");

		ssh.connect(ip);

		PKCS8KeyFile keyFile = new PKCS8KeyFile();
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		keyFile.init(new File(loader.getResource("sb3qa.pem").toURI()));
		ssh.auth(authusr, new AuthPublickey(keyFile));

		try {
			final Session session = ssh.startSession();
			try {
				final Command command = session.exec(cmd);
				String response = IOUtils.readFully(command.getInputStream())
						.toString();
				command.join(10, TimeUnit.SECONDS);
				if (!response.equals("")) {
					throw new RuntimeException("file present");
				}
				logger.info(response);
			} finally {
				session.close();
			}
		} finally {
			ssh.disconnect();
			ssh.close();
		}
		return this;
	}

	/**
	 * method used to assert log file present
	 * 
	 * @param ip
	 *            : of box to access
	 * @param authusr
	 *            : user name
	 * @param cmd
	 *            : command to execute on the box
	 * @return
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public SshUtil lsFile(String ip, String authusr, String cmd)
			throws IOException, URISyntaxException, InterruptedException {
		Thread.sleep(5000);

		final SSHClient ssh = new SSHClient();
		ssh.addHostKeyVerifier("c4:27:0b:af:9d:b9:24:d2:6f:aa:e7:c7:75:7f:f9:8a");

		ssh.connect(ip);

		PKCS8KeyFile keyFile = new PKCS8KeyFile();
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		keyFile.init(new File(loader.getResource("sb3qa.pem").toURI()));
		ssh.auth(authusr, new AuthPublickey(keyFile));

		try {
			final Session session = ssh.startSession();
			try {
				final Command command = session.exec(cmd);
				String response = IOUtils.readFully(command.getInputStream())
						.toString();
				command.join(10, TimeUnit.SECONDS);
				if (response.equals("")) {
					throw new RuntimeException("file not present");
				}
				logger.info(response);
			} finally {
				session.close();
			}
		} finally {
			ssh.disconnect();
			ssh.close();
		}
		return this;
	}

}
