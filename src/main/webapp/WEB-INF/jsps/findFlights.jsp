<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Flights Info | Cyram</title>
</head>
<body>
<h1>Find Flights</h1>

<form action="findFlights" method="POST">

    From: <input type="text" name="from"/>
    To: <input type="text" name="to"/>
    Departure Date: <input type="text" name="dateOfDeparture"/>
    <input type="submit" value="Search"/>

</form>

</body>
</html>
