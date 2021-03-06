<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel="stylesheet" type="text/css" href="/resources/html/css/dashHead.css" media="all">


</head>

<header>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

  <div class="topNav" id="myTopnav">
    <a href="<c:url value='/'/>" class="active">Strona Główna</a>
    <a href="<c:url value='/prisoners/add'/>">Dodaj osadzonego</a>
    <a href="<c:url value='/prisoners'/>">Osadzeni</a>
    <a href="<c:url value='/cells'/>">Stan cel</a>
    <a href="<c:url value='/guards/add'/>">Dodaj straznika</a>
    <a href="<c:url value='/guards'/>">Straznicy</a>
    <a href="<c:url value='/logout'/>">Wyloguj</a>
    <a href="javascript:void(0);" class="icon" onclick="myFunction()">
      <i class="fa fa-bars"></i>
    </a>
  </div>
</header>
<script type="text/javascript" src="<c:url value="../../../resources/html/js/main.js" />"></script>