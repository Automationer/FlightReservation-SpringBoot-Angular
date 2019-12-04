<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Complete Reservation | Cyram Flights</title>
</head>
<body>
<h2>Complete Reservation</h2>

Airline: ${flight.operatingAirlines}<br>
Departure City: ${flight.departureCity}<br>
Arrival City: ${flight.arrivalCity}<br>

<form action="completeReservation" method="POST">
    <h2>Passenger Details</h2>
    First name: <input type="text" name="passengerFirstName"/><br>
    Last name: <input type="text" name="passengerLastName"/><br>
    Email: <input type="text" name="passengerEmail"/><br>
    Phone: <input type="text" name="passengerPhone"/><br>

    <h2>Card Details</h2>
    Name on the card: <input type="text" name="nameOnTheCard"/><br>
    Card No: <input type="text" name="cardNo"/><br>
    Exp date: <input type="text" name="expDate"/><br>
    Sec code: <input type="text" name="secCode"/><br>

    <input type="hidden" name="flightId" value="${flight.id}"/>

    <input type="submit" value="confirm"/>
</form>
</body>
</html>
