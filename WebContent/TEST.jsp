<!DOCTYPE HTML>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
	<head>
		<title>Test</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	</head>
	<body>
		<input type="button" id="send" value="Send" />

		<script src="resources/js/jquery_1.9.1.js"></script>
		<script src="resources/js/amq_jquery_adapter.js"></script>
		<script src="resources/js/amq.js"></script>

		<script type="text/javascript">
			$(document).ready(
				function() {
					org.activemq.Amq.init(
						{
							uri: 'amq',
							logging: true,
							Timeout: 1,
							clientId: (new Date()).getTime().toString()
						}
					);
				}
			);

			var msg = "<msg type='common'>"
              +  "<id>msg1</id>"  
              +  "<content>This is test content from client ajax</content>"  
              + "</msg>";

			$("#send").on("click", function() {
					amq.sendMessage("topic://TEST", msg);
					//alert("hello");
				}
			);
			
			
			var myHandler = {
				rcvMessage: function(message) {
					alert(message.getAttribute('type'));
					//console.log(message);
				}
			};

			amq.addListener("testHandlerId","topic://TEST", myHandler.rcvMessage);
		</script>
	</body>
</html>