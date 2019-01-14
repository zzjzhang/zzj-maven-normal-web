window.onload = function() {

	setInterval(function() {
		// 1. 获取 足球 比赛 模块
		var frame = document.getElementsByClassName("ipn-Classification ipn-Classification-open ")[1];
		var frameFootball = frame.children[1];

		// 2. 获取 所有 比赛
		var frameGames = frameFootball.children;

		// 3. 创建 发送 列表
		var jsonObjList = [];

		// 4. 遍历 所有 比赛
		for (var i = 0, len = frameGames.length; i < len; i++) {
			var frameGame = frameGames[i];
			var gameFrame = frameGame.children[3];

			// 5. 判断 比赛 栏目 是否 打开
			if(gameFrame == null || gameFrame == undefined) {
				// 打开 栏目
				frameGame.click();
			}

			var gameFrame = frameGame.children[3];
			var gameContents = gameFrame.children;

			// 6. 遍历 所有 比赛
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

				// 主队
				var teams = gameContentInnerTeam.children[0].innerHTML;

				// 客队 是否 为空
				var team2Content = gameContentInnerTeam.children[1];

				if(team2Content != null) {
					teams = teams + " vs " + team2Content.innerHTML;
				}

				// 可能 有 视频 直播 按钮
				var scoreTimeLength = gameContentInnerScores.children.length;

				var scores = gameContentInnerScores.children[scoreTimeLength-2].innerText;
				var time = gameContentInnerScores.children[scoreTimeLength-1].innerText;

				// 创建 发送 单个 对象
				var jsonObj = {};
				jsonObj["teams"] = teams;
				jsonObj["time"] = time;
				jsonObj["scores"] = scores;

				// 列表 添加
				jsonObjList.push(jsonObj);
			}
		}

		// 显式 列表
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

	}, 6 * 1000);

}