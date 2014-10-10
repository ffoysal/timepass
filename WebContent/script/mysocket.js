rivets.config.handler = function (context, ev, binding) {
    if (binding.model instanceof binding.model.____) {
        return this.call(binding.model, binding.view.models, ev); // Event Target !!
    } else {
        return this.call(context, binding.view.models, ev);
    }
};

var myPlayerMessage ="";

var GameModel = function(){
	this.____ = GameModel;
	this.playerName = "";
	this.password = "";
	this.serviceLocation = "localhost:8080";
	this.showLoginDiv = true;
	this.connectionFailMsg='';
	this.loggedInUser = [];
	this.wsocket={};
};

//var wsocket;
//var serviceLocation = "ws://localhost:8080/howfunny/fungame/";

GameModel.prototype = {		
		connectToServer: function(){			
				this.wsocket = new WebSocket("ws://"+this.serviceLocation+ "/howfunny/fungame/" + this.playerName+'/'+this.password);
				this.wsocket.onmessage = onMessageReceived;
		},
		sendToServer: function(){
			myPlayerMessage.playerName = this.playerName;
			myPlayerMessage.gameInstruction = "DEAL";
			console.log(myPlayerMessage);
			console.log(JSON.stringify(myPlayerMessage));
			
			this.wsocket.send(JSON.stringify(myPlayerMessage));
			//this.wsocket.send("TESTING");
		}

};

var model = new GameModel();

rivets.bind(document.querySelector("#main-div"),{
		model: model
	});

function onMessageReceived(evt) {
	var msg = JSON.parse(evt.data);
	myPlayerMessage = msg;
	
	if(msg.messageType == "AUTHENTICATION"){
		if(msg.connectionStatus == "Connected"){
			model.showLoginDiv = false;
			model.loggedInUser = msg.players;
		}else{
			model.connectionFailMsg = msg.connectionStatus;
		}
	}
	if(msg.messageType == "NEWUSER"){
		model.loggedInUser = msg.players;
	}
	
	console.log(evt.data);
}
