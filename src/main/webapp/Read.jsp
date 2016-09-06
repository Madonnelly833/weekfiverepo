<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.weekfivetwo.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
body{
background-image: url("http://www.pixelstalk.net/wp-content/uploads/2016/07/Guild-Wars-2-Background-HD.jpg");
}

div.ex4 {
    padding: 25px;
}
</style>
<head>

    
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Portfolio Item - Start Bootstrap Template</title>

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/portfolio-item.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

 <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">Start Bootstrap</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                <li>
                        <a href="Read.jsp">List</a>
                    </li>
                    <li>
                        <a href="add.html">Add</a>
                    </li>
                    <li>
                        <a href="Delete.jsp">Delete</a>
                    </li>
                    <li>
                        <a href="Update.jsp">Update</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
    
    <th>  <b>Hero List:</b>   </th>
    
	<th><b>See the players entered so far.</b></th>
			
	<table class="table table-striped" style="margin-left:30px">
		<tr>
			
		</tr>
		<thead>
                            <tr>
                                <th>ID</th>
                                <th>Name</th>
                                <th>Race</th>
                                <th>Profession</th>
                                <th>Attack</th>
                                <th>Defense</th>
                                <th>Hit Points</th>
                            </tr>
                        </thead>
		<tbody>
		<%
			Dew.readFromDB();
		
			Player readToJSP = new Player();

			for (int i = 0; i < Dew.charList.size(); i++) {
				readToJSP = Dew.charList.get(i);
		%>
		<tr>
			<td><%=readToJSP.getCharID()%></td>
			<td><%=readToJSP.getCharName()%></td>
			<td><%=readToJSP.getCharRace()%></td>
			<td><%=readToJSP.getCharProfession()%></td>
			<td><%=readToJSP.getAttack()%></td>
			<td><%=readToJSP.getDefense()%></td>
			<td><%=readToJSP.getHitPoints()%></td>
		</tr>

		<%
			}
			Dew.charList.clear();
		%></tbody>
	</table>
	<div class="ex4">
	
		<a href="index.html"><button type="button" class="btn btn-default">Home</button></a>
	</div>
	


</body>
</html>