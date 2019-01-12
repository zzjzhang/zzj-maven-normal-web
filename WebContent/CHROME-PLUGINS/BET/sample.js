window.onload = function() {

	setInterval(function() {

		var frame = document.getElementsByClassName("ipn-Classification ipn-Classification-open ")[1];
		var frame1 = frame.children[1];

		var childrenFrames = frame1.children;

		for (var i = 0, len = childrenFrames.length; i < len; i++) {
			var content = childrenFrames[i];
			var gameContent = content.children[3];
			var gameContentInner1 = gameContent.children[0];
			var gameContentInner2 = gameContentInner1.children[0];

			var gameContentInner3 = gameContentInner2.children[1];
			var gameContentInner4 = gameContentInner2.children[2];

			var team1 = gameContentInner3.children[0].innerHTML;
			var team2 = gameContentInner3.children[1].innerHTML;

			var scores = gameContentInner4.children[0].innerHTML;
			var score0 = scores.split("-")[0];
			var score1 = scores.split("-")[1];

			var times = gameContentInner4.children[1].innerText;
			var minutes = times.split(":")[0];

			if(score0 > 0 || score1 > 0) {
				if(minutes < 85) {
					console.log(team1 + " vs " + team2);
					console.log(scores + " " + times);
				}
			}
		}

	}, 5 * 1000);

}