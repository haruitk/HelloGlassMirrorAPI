package com.example;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.example.auth.AuthUtils;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.appengine.http.UrlFetchTransport;
import com.google.api.client.json.jackson.JacksonFactory;
import com.google.api.services.mirror.Mirror;

public class MirrorUtils {
	
	public static Mirror getMirror(HttpServletRequest req) throws IOException{
		String userId = SessionUtils.getUserId(req);
		Credential credential = AuthUtils.getCredential(userId);

		return new Mirror.Builder(new UrlFetchTransport(),
				new JacksonFactory(), credential).setApplicationName(
				"Hello Mirror API").build();
	}

}
