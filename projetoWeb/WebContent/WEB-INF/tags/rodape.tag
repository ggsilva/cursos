<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ tag import="java.util.Calendar, java.util.GregorianCalendar" %>
<%@attribute name="nomeSite" fragment="true"%>
<div class="rodape" style="text-align: center;">
  <%
    GregorianCalendar cal = new GregorianCalendar();
    out.print(cal.get(Calendar.YEAR));
  %>
  &copy; <jsp:invoke fragment="nomeSite" />
  <p>
  <jsp:doBody />
  </p>
</div>