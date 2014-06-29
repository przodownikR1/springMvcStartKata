<%@ include file="/WEB-INF/views/includes.jsp"%>

<html>
<h3>N1 problem</h3>

<body>
   <c:forEach items="${persons}" var="person">
         Osoba : ${person.name}  ,  ${person.address}<br/>
         
         Samochody : 
         <c:forEach  items="${person.cars}"  var="car">
           marka : ${car.make} 
           wiek : ${car.age}
          <br/>
         </c:forEach>
         <br/>
         <hr>
   
   
    </c:forEach>

</body>


</html>