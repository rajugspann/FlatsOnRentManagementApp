<%@taglib prefix="raju" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h1>Flats Information</h1>
<ul><raju:forEach var="flats" items="${AL}">
<li><h2>${flats}</h2>
</raju:forEach></ul>
</body>
</html>