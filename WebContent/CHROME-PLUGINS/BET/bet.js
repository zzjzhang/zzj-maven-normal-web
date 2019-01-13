window.onload = function() {

	setInterval(function() {

		var frame = document.getElementsByClassName("ipn-Classification ipn-Classification-open ")[1];
		var frameFootball = frame.children[1];

		var frameGames = frameFootball.children;
		// console.log(frameGames[0].innerHTML);

		var jsonObjList = [];

		for (var i = 0, len = frameGames.length; i < len; i++) {
			var frameGame = frameGames[i];
			var gameContentFrame = frameGame.children[3];
			var gameContents = gameContentFrame.children;
			
			// console.log(gameContents[0].innerHTML);

			for(var j = 0, leng = gameContents.length; j < leng; j++) {
				var gameContentInner = gameContents[j].children[0];
				// var gameContentInner = gameContentInn.children[0];

				// Rate
				// var rateContent = gameContentInn.children[2].children;
				// var rate0;
				// var rate1;

				////////////////
				/* for (var j = 0, ratelen = rateContent.length; j < ratelen; j++) {
					var rate = rateContent[j].children[1];

					if(j == 0) {
						rate0 = rate.innerText;
					}

					if(j == 2) {
						rate1 = rate.innerText;
					}
				} */

				var gameContentInnerTeam = gameContentInner.children[1];
				var gameContentInnerScores = gameContentInner.children[2];

				var teams = gameContentInnerTeam.children[0].innerHTML;
				
				if(gameContentInnerTeam.children[1] != null) {
					teams = teams + "vs" + gameContentInnerTeam.children[1].innerHTML;
				}

				var scoreTimeLength = gameContentInnerScores.children.length;
				
				var scores = gameContentInnerScores.children[scoreTimeLength-2].innerText;
				var times = gameContentInnerScores.children[scoreTimeLength-1].innerText;

				var jsonObj = {};
				jsonObj["teams"] = teams;
				jsonObj["time"] = times;
				jsonObj["scores"] = scores;

				//
				jsonObjList.push(jsonObj);
			}
		}

		//
		console.log(jsonObjList);

		// Send request to backend
		var sendData = {};
		sendData["data"] = JSON.stringify(jsonObjList);

		$.ajax({
			type : "POST",
			url : "http://localhost:8080/zzj-normal-web/recordController",
			data : sendData,
			dataType : "json",
			crossDomain: true,
			// jsonp : "callback",
			beforeSend : function() {
				//
			},
			success : function(data) {
				//console
				// console.log(data);
				//judge existence
			},
			error : function(e) {
				//alert(JSON.stringify(e));
				// console.log(e);
			}
		})

	}, 5 * 1000);

}