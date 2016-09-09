<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<body>


<br><h1>User Account Login</h1>
<form:form action="verifyUser.raj" method="post" commandName="user">
<table>

<tr>

<td>Username</td>
<td> <form:input path="username" /> </td>

<td><font color="red" size="5"> <form:errors path="username"/></font></td>

</tr>

<tr>

<td>Password</td>
<td> <form:password path="password"/> </td>
<td><font color="red" size="5"> <form:errors path="password"/></font></td>

</tr>

</table>

<input type="submit" value="Account Login">
</form:form>

</body>
</html>