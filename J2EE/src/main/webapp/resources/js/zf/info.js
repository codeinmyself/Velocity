
var orders = {};

function GetQueryString(name)
{
     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
     var r = window.location.search.substr(1).match(reg);
     if(r!=null)return  unescape(r[2]); return null;
}

function set_tab() {
    var tab_tag = GetQueryString("stat");
    var inputs = document.getElementsByTagName("a");
    for (var i = 0; i < inputs.length; i++) {
        if (inputs[i].id == tab_tag) {
            inputs[i].setAttribute("class","mdl-layout__tab is-active");
        }
        else if (inputs[i].classList.contains("is-active")) {
            inputs[i].setAttribute("class","mdl-layout__tab");
        }
    }
}

function orderlist(str){
	var content = document.getElementById("order_list");
	var ct=$("#order_list");
	ct.empty();
	
	var id = GetQueryString("uid");
	$.ajax(
            {
                type: 'GET',
                url: "getOrders?uid="+id+"&stat="+str,
                contentType: 'application/json;charset=utf-8',
                success: function (data) {
                    orders = data;
                    
                    for(var i = 0;i < orders.length; i++)
                    {
                    	var od=document.createElement("ul");
                		od.setAttribute("class", "mdl-list order_list_ul");
                		var html = '<li class="line-spacer"></li>' + 
                	    			 '<hr>'+
                	    			 '<li class="order_list">'+
                	    			 	'<div class="order_pre_info">'+
                	    					'<span>订单编号：' + orders[i].order_sn +'</span>' +
                	    					'<span>';
                		if(orders[i].order_status == 0)
                			html += '待付款';
                		else if(orders[i].order_status == 1)
                			html += '已付款';
                		else if(orders[i].order_status == 2)
                			html += '店家已审核';
                		else if(orders[i].order_status == 3)
                			html += '店家已发货';
                		else if(orders[i].order_status == 4)
                			html += '已收货';
                		else
                			html += '已取消';
                		
                	    html +=					'<label>|</label>'+
                	    						'<button class="ic_delete"><img src="resources/images/zf/ic_delete.png"></button>'+
                	    					'</span>'+
                	    				'</div>';
                	    
                	    var goods = {};
                	    goods = orders[i].goods;
                	    for(var j = 0; j < goods.length; j++){
                	    	html += 	'<button class="order_detail">'+
                	    					'<img src="resources/images/zf/' + goods[j].image +'" class="item_img"></image>'+
                	    					'<span class="order_description">'+
                	    						goods[j].goods_name +
                	    					'</span>'+
                	    				'</button>'+
                	    				'<div class="line-spacer-goods"></div>' ;
                	    }
                	    
                	    html +=			'<div class="order_after_info">' +	
                	    					'<span>订单总价：</span>'+
                	    					'<label>'+ orders[i].order_price + '</label>'+
                	    				'</div>'+
                	    				'<hr/>';
                	    if(orders[i].order_status == 0)
                			html += '<button type="button" class="mdl-button mdl-js-button mdl-button--accent func_btn" onclick="javascript:cancelorder(' + orders[i].order_id + ')">取消订单</button>';
                		else if(orders[i].order_status == 1)
                			html += '<button type="button" class="mdl-button mdl-js-button mdl-button--accent func_btn">我要催单</button>';
                		else if(orders[i].order_status == 2)
                			html += '<button type="button" class="mdl-button mdl-js-button mdl-button--accent func_btn">我要催单</button>';
                		else if(orders[i].order_status == 3)
                			html += '<button type="button" class="mdl-button mdl-js-button mdl-button--accent func_btn" onclick="javascript:finishorder(' + orders[i].order_id + ')">确认收货</button>';
                		else if(orders[i].order_status == 4)
                			html += '<button type="button" class="mdl-button mdl-js-button mdl-button--accent func_btn">再次购买</button>';
                		else
                			html += '<button type="button" class="mdl-button mdl-js-button mdl-button--accent func_btn">重新购买</button>';
                	    	
                	    html += 	'</li>'+
                	    			'<hr/>';
                	    
                	    od.innerHTML=html;
                	    content.appendChild(od);
                    }

                }
            }
        )	
	
	/*标签*/
	var inputs = document.getElementsByTagName("a");
    for (var i = 0; i < inputs.length; i++) {
        if (inputs[i].id == str) {
            inputs[i].setAttribute("class","mdl-layout__tab is-active");
        }
        else if (inputs[i].classList.contains("is-active")) {
            inputs[i].setAttribute("class","mdl-layout__tab");
        }
    }
}

function cancelorder(id){
	//alert("取消订单：" + id);
	$.ajax(
            {
                type: 'GET',
                contentType: 'application/json;charset=utf-8',
                url:'cancelOrder?order_id='+id,
                success:function (data) {
                    if(data == "success")
                    {
                    	orderlist('cancel');
                    }
                }
            }
          )
}

function finishorder(id){
	$.ajax(
            {
                type: 'GET',
                contentType: 'application/json;charset=utf-8',
                url:'finishOrder?order_id='+id,
                success:function (data) {
                    if(data == "success")
                    {
                    	orderlist('done');
                    }
                }
            }
          )
}
