<html>
<body bgcolor="#c5de9">

<%=new java.util.Date() %>
<h1> Gestionando proyectos con Maven</h1>

<h2>Calculo de Trabajador por Horas</h2>
<form  action="calculos.jsp" method="post">
<table>
<tr><td>Valor  de Hora</td><td><input type="text" name="valorh"></td></tr>
<tr><td>Cantidad de Horas</td><td><input type="text" name="cantidadh"></td></tr>
<tr><td colspan="2"><input type="submit" value="Calcular"></td></tr>
</table>
</form>
</body>
</html>
