rivets.config.handler = function (context, ev, binding) {
    if (binding.model instanceof binding.model.____) {
        return this.call(binding.model, binding.view.models, ev); // Event Target !!
    } else {
        return this.call(context, binding.view.models, ev);
    }
};


var GameModel = function(){
	this.____ = GameModel;
	this.playerName = "";
	this.password = "";
	this.serviceLocation = "localhost:8080";
	this.showLoginDiv = true;
	this.connectionFailMsg='';
};

var wsocket;
//var serviceLocation = "ws://localhost:8080/howfunny/fungame/";

GameModel.prototype = {		
		connectToServer: function(){			
				wsocket = new WebSocket("ws://"+this.serviceLocation+ "/howfunny/fungame/" + this.playerName+'/'+this.password);
				wsocket.onmessage = onMessageReceived;
		}
};

var model = new GameModel();

rivets.bind(document.querySelector("#main-div"),{
		model: model
	});

function onMessageReceived(evt) {
	var msg = JSON.parse(evt.data);
	if(msg.messageType == "AUTHENTICATION"){
		if(msg.connectionStatus == "Connected"){
			model.showLoginDiv = false;
		}else{
			model.connectionFailMsg = msg.connectionStatus;
		}
	}
	console.log(evt.data);
}
