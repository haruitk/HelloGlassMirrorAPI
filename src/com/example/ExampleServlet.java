package com.example;

import java.io.IOException;

import javax.servlet.http.*;

import com.google.api.services.mirror.Mirror;
import com.google.api.services.mirror.model.TimelineItem;

@SuppressWarnings("serial")
public class ExampleServlet extends HttpServlet {
  public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    
    Mirror mirror = MirrorUtils.getMirror(req);
    TimelineItem timelineItem = new TimelineItem();
    timelineItem.setText("Hello mirror");
    mirror.timeline().insert(timelineItem).execute();
    
    resp.setContentType("text/plain");
    resp.getWriter().println("Hello, mirror");
    
    
  }
}
