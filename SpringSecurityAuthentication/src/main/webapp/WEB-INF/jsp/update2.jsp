<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
</head>
<body>
		<h2>Successfully Updated User</h2>
		
		<div>
			<p> User ID: ${IDedit}</p>
			<div>
				<table>
				   <tr><th>ID</th><th>Name</th><th>Email</th><th>Password</th></tr>
				   <c:forEach items="${user}" var="userE" varStatus="count">
				    <tr id="${count.index}">
				    	<td>${userE.id}</td>
				        <td>${userE.name}</td>
				        <td>${userE.email}</td>
				        <td>${userE.password}</td>
				    </tr>
					</c:forEach>
				</table>
			</div>
			<br><br>
			<h3>Return to Homepage</h3>
			<div>
				<a href="/">Return</a>
			</div>

</body>
</html>