window.onload = function() {

	setInterval(function() {

		var frame = document.getElementsByClassName("ipn-Classification ipn-Classification-open ")[1];
		var frameFootball = frame.children[1];

		var frameGames = frameFootball.children;

		for (var i = 0, len = frameGames.length; i < len; i++) {
			var frameGame = frameGames[i];
			var gameContent = frameGame.children[3];

			var gameContentInn = gameContent.children[0];
			var gameContentInner = gameContentInn.children[0];

			var gameContentInnerTeam = gameContentInner.children[1];
			var gameContentInnerScores = gameContentInner.children[2];

			var team0 = gameContentInnerTeam.children[0].innerHTML;
			var team1 = gameContentInnerTeam.children[1].innerHTML;

			var scores = gameContentInnerScores.children[0].innerHTML;
			var score0 = scores.split("-")[0];
			var score1 = scores.split("-")[1];

			var times = gameContentInnerScores.children[1].innerText;
			var minutes = times.split(":")[0];

			if(score0 > 0 || score1 > 0) {
				if(minutes < 85) {
					console.log(team0 + " vs " + team1);
					console.log(scores + " " + times);
				}
			}
		}

	}, 5 * 1000);

}