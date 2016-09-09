<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<body>
	<br>
	<h1>User Account Registration</h1>
	<form:form action="verifyUserOnRegistration.raj" method="post"
		commandName="register">
		<table>

			<tr>

				<td>Username</td>
				<td><form:input path="username" /></td>

				<td><font color="red" size="5"> <form:errors
							path="username" /></font></td>

			</tr>

			<tr>

				<td>Password</td>
				<td><form:input path="password" /></td>
				<td><font color="red" size="5"> <form:errors
							path="password" /></font></td>

			</tr>

	<tr>

				<td>Name</td>
				<td><form:input path="name" /></td>
				<td><font color="red" size="5"> <form:errors
							path="name" /></font></td>

			</tr>
	
			<tr>

				<td>Phone</td>
				<td><form:input path="phone" /></td>
				<td><font color="red" size="5"> <form:errors
							path="phone" /></font></td>

			</tr>
			<tr>

				<td>Address</td>
				<td><form:input path="address" /></td>
				<td><font color="red" size="5"> <form:errors
							path="address" /></font></td>

			</tr>
			<tr>

				<td>Pincode</td>
				<td><form:input path="pincode" /></td>
				<td><font color="red" size="5"> <form:errors
							path="pincode" /></font></td>

			</tr>
			<tr>

				<td>City</td>
				<td><form:input path="city" /></td>
				<td><font color="red" size="5"> <form:errors path="city" /></font></td>

			</tr>
			<tr>

				<td>State</td>
				<td><form:input path="state" /></td>
				<td><font color="red" size="5"> <form:errors
							path="state" /></font></td>

			</tr>

		</table>

		<input type="submit" value="Account Register">
	</form:form>

</body>
</html>