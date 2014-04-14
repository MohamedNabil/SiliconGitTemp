<#import "spring.ftl" as spring>

<html>
<head>

<title>Home Page</title>
<link rel="stylesheet" type="text/css" href="CSS/table.css">

</head>
<body>
    <h1>Home Page</h1>
    
		

	<p>We have these Employees:
	<table border=1>
  	<tr><th>Name<th>age
  	<#list Employees as employee>
  	<tr><td>${employee.name}<td>${employee.age} L.E
  	</#list>
	</table>
	 
</body>
</html>