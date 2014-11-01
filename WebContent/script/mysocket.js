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
	this.hand = [];
	this.isloginFailed = false;
	this.bidMetrix={};
	this.bidImageMetrix =[];
	this.testBid = [
	                [
	                 {
	                	suit:'N',
	                	weight:1
	                },
	                {
	                	suit: 'N',
	                	weight: 2
	                }
	                 ],
	                 [
		                 {
			                	suit:'S',
			                	weight:1
			                },
			                {
			                	suit: 'S',
			                	weight: 2
			                }
	                  
	                  ]
	                ]
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
			//console.log(myPlayerMessage);
			//console.log(JSON.stringify(myPlayerMessage));
			
			this.wsocket.send(JSON.stringify(myPlayerMessage));
			//this.wsocket.send("TESTING");
		},
		sendBidToServer: function(){
			myPlayerMessage.playerName = this.playerName;
			myPlayerMessage.gameInstruction = "BID";
			//console.log(myPlayerMessage);
			//console.log(JSON.stringify(myPlayerMessage));		
			this.wsocket.send(JSON.stringify(myPlayerMessage));			
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
			model.isloginFailed = false;
			model.showLoginDiv = false;
			model.loggedInUser = msg.players;
		}else{
			model.connectionFailMsg = msg.connectionStatus;
			model.isloginFailed = true;			
		}
	}
	if(msg.messageType == "NEWUSER"){
		model.loggedInUser = msg.players;
	}
	if(msg.messageType == "DEAL_RESULT"){
		model.hand = makeCardImgPath(msg.hand);
	}
	if(msg.messageType == "BID_RESULT"){
		model.bidMetrix = msg.bidMetrix.metrix;
		makeBidImageMetrix(model.bidMetrix);
		//console.log(model.bidImageMetrix);
		$('#myModal').modal({
			  keyboard: false
			});
		
		var source   = $("#bid-metrix-template").html();
		var template = Handlebars.compile(source);
		var context = {bidRows: model.bidImageMetrix}
		var html    = template(context);
		$('.modal-body').empty();
		$('.modal-body').append(html);
		
		addImgDisableClass();
		
		$('.bid-image-td').on('click', function(evt){
			if($(evt.target).parent().attr('active-flag') == 'true'){
				removeImgClickedClass();
				$(evt.target).addClass('img-clicked');
			}
		});
		
		$('.btn-bid-submit').on('click',function(evt){
			var imgClicked = $('#bid-table').find('.img-clicked');			
			getClickedBid(imgClicked.parent().attr('suit'),imgClicked.parent().attr('weight'));
		});
		
		$('.pass-btn').on('click', function(evt){
			var bid = {enable: true, suit: null, weight: 0, other:'PASS'};
			console.log(bid);
		});
	}
	
	
	console.log(evt.data);
}

/* Based on the suit enable flag it disable the img in the bid modal
 * 
 */
function addImgDisableClass(){
	_.each($('#bid-table').find('.bid-image-td'), function(td){
	
		if($(td).attr('active-flag') != 'true')
			$(td).children().addClass('img-disable');
	});
}
// remove the imgClicked class from the bid modal.
// Once clicked on a img other img should be deselect
function removeImgClickedClass(){
	var imgClicked = $('#bid-table').find('.img-clicked');
	
	if(imgClicked.length)
		imgClicked.removeClass('img-clicked');
}


// add image url to the model
function makeBidImageMetrix(bidMetrix){
	model.bidImageMetrix = [];
	_.each(bidMetrix, function(row){
		var r;
		if(row.length > 1){
			r = _.map(row, function(a){
				a['image_url'] = './images/cards/'+ a.weight + a.suit + '.svg';
				return a;
			}); 
			model.bidImageMetrix.push(r);
		}
	});
}

function getClickedBid(st, wt){
	var bid = {};
	_.each(model.bidMetrix, function(row){
		_.each(row,function(td){
			if(td.suit == st && td.weight == wt){
				td.enable = false;
				bid = td;
			}
		});
	});
	console.log(bid);
	return bid;
}

function makeCardImgPath(cards){
	var counter = 0;
	return _.map(cards, function(card){ 
		counter = counter + 1;
		return { 
			name: "./images/cards/"+card+".svg", 
			card_class: "displayed-card displayed-card-"+counter
		}; 
		});
}
