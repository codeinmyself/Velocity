/**
 * Created by Administrator on 2017/5/22.
 */
var page=1;
var orderlist={};
var pagenum;
window.onload=function () {
    var table=document.getElementById("list");
    $.ajax(
        {
            type: 'POST',
            url: "getOrders",
            contentType: 'application/json;charset=utf-8',
            success: function (data) {
                orderlist=data;
                if(orderlist.length%7!=0)
                    pagenum=parseInt(orderlist.length/7)+1;
                else pagenum=orderlist.length/7;
                document.getElementById("pageshow").innerHTML='第<input id="input-page" type="number" class="page-input" min="1" max="'+ pagenum +'" value="'+page+'">页(共'+pagenum+'页)'+
                    '<a href="javascript:gopage()" class="page-go">Go</a>';
                var number;
                if(orderlist.length>7)number=7;
                else number=orderlist.length;
                for(var i=0;i<number;i++)
                {
                    var tr=document.createElement("tr");
                    var html='<td class="short"><input type="checkbox"></td> ' +
                        '<td class="middle">'+orderlist[i].order_sn+'</td>' +
                        '<td class="middle">'+orderlist[i].goods_name+'</td> ' +
                        '<td class="middle">'+orderlist[i].add_time+'</td> ' +
                        '<td class="short">'+orderlist[i].consignee+'</td> ' +
                        '<td class="middle">'+orderlist[i].user_name+'</td> ' +
                        '<td class="middle">'+orderlist[i].price+'</td> ' +
                        '<td class="short">'+orderlist[i].isUrgency+'</td> ' +
                        '<td class="long">'+orderlist[i].remark+'</td>'+
                        '<td class="short">' +orderlist[i].order_status+ '</td>' +
                        '<td class="middle">'+orderlist[i].shipped_time+'</td> ' +
                        '<td class="long">' +
                         	'<button class="btn btn-default" onclick="godetail('+i+')">详细信息</button>' +
                         	'<button class="btn btn-default" onclick="goupdate('+i+')">修改订单</button>';
                    
                    if(orderlist[i].order_status == "已付款"){
                    	html += '<button class="btn btn-default" onclick="check('+i+')">确认</button>';
                    } else if (orderlist[i].order_status == "已审核"){
                    	html += '<button class="btn btn-default" onclick="goship('+i+')">发货</button>';
                    }
                    
                    html += '</td>';
                    tr.innerHTML=html;
                    table.appendChild(tr);
                }

            }
        }
    )
}
function nextpage() {
    if(page<pagenum)
    {
        var table=document.getElementById("list");
        var ta=$("#list");
        ta.empty();
        page=page+1;
        var th=document.createElement("thead");
        th.innerHTML='<td class="short" style="border-radius: 3px 0 0 0;"><input id="checkbox0" type="checkbox"></td>'+
            '<td class="middle">订单号</td>'+
            '<td class="middle">商品名称</td>'+
            '<td class="middle">下单时间</td>'+
            '<td class="short">收货人</td>'+
            '<td class="middle">用户名</td>'+
            '<td class="middle">总金额</td>'+
            '<td class="short">加急</td>'+
            '<td class="long">备注</td>'+
            '<td class="short">订单状态</td>' +
            '<td class="middle">发货时间</td>' +
            '<td class="long">操作</td>';
        table.appendChild(th);
        for(var i=7*(page-1);i<7*page;i++) {
            if (orderlist[i] != null) {
                var tr = document.createElement("tr");
                var html = '<td class="short"><input type="checkbox"></td> ' +
                    '<td class="middle">' + orderlist[i].order_sn + '</td>' +
                    '<td class="middle">' + orderlist[i].goods_name + '</td> ' +
                    '<td class="middle">' + orderlist[i].add_time + '</td> ' +
                    '<td class="short">' + orderlist[i].consignee + '</td> ' +
                    '<td class="middle">' + orderlist[i].user_name + '</td> ' +
                    '<td class="middle">' + orderlist[i].price + '</td> ' +
                    '<td class="short">' + orderlist[i].isUrgency + '</td> ' +
                    '<td class="long">' + orderlist[i].remark + '</td>' +
                    '<td class="short">' +orderlist[i].order_status+ '</td>' +
                    '<td class="middle">'+orderlist[i].shipped_time+'</td> ' +
                    '<td class="long">' +
                 	'<button class="btn btn-default" onclick="godetail('+i+')">详细信息</button>' +
                 	'<button class="btn btn-default" onclick="goupdate('+i+')">修改订单</button>';
            
	            if(orderlist[i].order_status == "已付款"){
	            	html += '<button class="btn btn-default" onclick="check('+i+')">确认</button>';
	            } else if (orderlist[i].order_status == "已审核"){
	            	html += '<button class="btn btn-default" onclick="goship('+i+')">发货</button>';
	            }
		            
		        html += '</td>';
                tr.innerHTML = html;
                table.appendChild(tr);
            }
        }
        document.getElementById("input-page").value=page;
    }
}
function lastpage() {
    if(page>1)
    {
        var table=document.getElementById("list");
        var ta=$("#list");
        ta.empty();
        page=page-1;
        var th=document.createElement("thead");
        th.innerHTML='<td class="short" style="border-radius: 3px 0 0 0;"><input id="checkbox0" type="checkbox"></td>'+
            '<td class="middle">订单号</td>'+
            '<td class="middle">商品名称</td>'+
            '<td class="middle">下单时间</td>'+
            '<td class="short">收货人</td>'+
            '<td class="middle">用户名</td>'+
            '<td class="middle">总金额</td>'+
            '<td class="short">加急</td>'+
            '<td class="long">备注</td>'+
            '<td class="short">订单状态</td>' +
            '<td class="middle">发货时间</td>' +
            '<td class="long">操作</td>';
        table.appendChild(th);
        for(var i=7*(page-1);i<7*page;i++)
        {
            if(orderlist[i]!=null) {
                var tr = document.createElement("tr");b
                var html = '<td class="short"><input type="checkbox"></td> ' +
                    '<td class="middle">' + orderlist[i].order_sn + '</td>' +
                    '<td class="middle">' + orderlist[i].goods_name + '</td> ' +
                    '<td class="middle">' + orderlist[i].add_time + '</td> ' +
                    '<td class="short">' + orderlist[i].consignee + '</td> ' +
                    '<td class="middle">' + orderlist[i].user_name + '</td> ' +
                    '<td class="middle">' + orderlist[i].price + '</td> ' +
                    '<td class="short">' + orderlist[i].isUrgency + '</td> ' +
                    '<td class="long">' + orderlist[i].remark + '</td>' +
                    '<td class="short">' +orderlist[i].order_status+ '</td>' +
                    '<td class="middle">'+orderlist[i].shipped_time+'</td> ' +
                    '<td class="long">' +
                 	'<button class="btn btn-default" onclick="godetail('+i+')">详细信息</button>' +
                 	'<button class="btn btn-default" onclick="goupdate('+i+')">修改订单</button>';
            
	            if(orderlist[i].order_status == "已付款"){
	            	html += '<button class="btn btn-default" onclick="check('+i+')">确认</button>';
	            } else if (orderlist[i].order_status == "已审核"){
	            	html += '<button class="btn btn-default" onclick="goship('+i+')">发货</button>';
	            }
		            
		        html += '</td>';
                tr.innerHTML = html;
                table.appendChild(tr);
            }
        }
        document.getElementById("input-page").value=page;

    }
}
function gopage() {
    var goto=document.getElementById("input-page").value;
    if(goto<=pagenum&&goto>0)
    {
        var table=document.getElementById("list");
        var ta=$("#list");
        ta.empty();
        page=goto;
        var th=document.createElement("thead");
        th.innerHTML='<td class="short" style="border-radius: 3px 0 0 0;"><input id="checkbox0" type="checkbox"></td>'+
            '<td class="middle">订单号</td>'+
            '<td class="middle">商品名称</td>'+
            '<td class="middle">下单时间</td>'+
            '<td class="short">收货人</td>'+
            '<td class="middle">用户名</td>'+
            '<td class="middle">总金额</td>'+
            '<td class="short">加急</td>'+
            '<td class="long">备注</td>'+
            '<td class="short">订单状态</td>' +
            '<td class="middle">发货时间</td>' +
            '<td class="long">操作</td>';
        table.appendChild(th);
        for(var i=7*(page-1);i<7*page;i++)
        {
            if(orderlist[i]!=null) {
                var tr = document.createElement("tr");
                var html = '<td class="short"><input type="checkbox"></td> ' +
                    '<td class="middle">' + orderlist[i].order_sn + '</td>' +
                    '<td class="middle">' + orderlist[i].goods_name + '</td> ' +
                    '<td class="middle">' + orderlist[i].add_time + '</td> ' +
                    '<td class="short">' + orderlist[i].consignee + '</td> ' +
                    '<td class="middle">' + orderlist[i].user_name + '</td> ' +
                    '<td class="middle">' + orderlist[i].price + '</td> ' +
                    '<td class="short">' + orderlist[i].isUrgency + '</td> ' +
                    '<td class="long">' + orderlist[i].remark + '</td>' +
                    '<td class="short">' +orderlist[i].order_status+ '</td>' +
                    '<td class="middle">'+orderlist[i].shipped_time+'</td> ' +
                    '<td class="long">' +
                 	'<button class="btn btn-default" onclick="godetail('+i+')">详细信息</button>' +
                 	'<button class="btn btn-default" onclick="goupdate('+i+')">修改订单</button>';
            
	            if(orderlist[i].order_status == "已付款"){
	            	html += '<button class="btn btn-default" onclick="check('+i+')">确认</button>';
	            } else if (orderlist[i].order_status == "已审核"){
	            	html += '<button class="btn btn-default" onclick="goship('+i+')">发货</button>';
	            }
		            
		        html += '</td>';
                tr.innerHTML = html;
                table.appendChild(tr);
            }
        }
        document.getElementById("input-page").value=page;
    }
}

function godetail(i) {
    window.location.href="checkOrder_info?order_id="+orderlist[i].order_id;
}

function goupdate(i) {
	window.location.href="updateOrder_info?order_id="+orderlist[i].order_id;
}

function check(i) {
	if(confirm("是否确认订单？")){
		window.location.href="checkOrder?order_id="+orderlist[i].order_id;
	}
}

function goship(i){
	window.location.href="shipOrder?order_id="+orderlist[i].order_id;
}

function search(){
	window.location.href="search";
}

function urgent(){
	var table=document.getElementById("list");
    var ta=$("#list");
    ta.empty();
    var th=document.createElement("thead");
    th.innerHTML='<td class="short" style="border-radius: 3px 0 0 0;"><input id="checkbox0" type="checkbox"></td>'+
        '<td class="middle">订单号</td>'+
        '<td class="middle">商品名称</td>'+
        '<td class="middle">下单时间</td>'+
        '<td class="short">收货人</td>'+
        '<td class="middle">用户名</td>'+
        '<td class="middle">总金额</td>'+
        '<td class="short">加急</td>'+
        '<td class="long">备注</td>'+
        '<td class="short">订单状态</td>' +
        '<td class="middle">发货时间</td>' +
        '<td class="long">操作</td>';
    table.appendChild(th);
    page=1;
    $.ajax(
            {
                type: 'POST',
                url: "getUrgentOrders",
                contentType: 'application/json;charset=utf-8',
                success: function (data) {
                    orderlist=data;
                    if(orderlist.length%7!=0)
                        pagenum=parseInt(orderlist.length/7)+1;
                    else pagenum=orderlist.length/7;
                    document.getElementById("pageshow").innerHTML='第<input id="input-page" type="number" class="page-input" min="1" max="'+ pagenum +'" value="'+page+'">页(共'+pagenum+'页)'+
                        '<a href="javascript:gopage()" class="page-go">Go</a>';
                    var number;
                    if(orderlist.length>7)number=7;
                    else number=orderlist.length;
                    for(var i=0;i<number;i++)
                    {
                        var tr=document.createElement("tr");
                        var html='<td class="short"><input type="checkbox"></td> ' +
                            '<td class="middle">'+orderlist[i].order_sn+'</td>' +
                            '<td class="middle">'+orderlist[i].goods_name+'</td> ' +
                            '<td class="middle">'+orderlist[i].add_time+'</td> ' +
                            '<td class="short">'+orderlist[i].consignee+'</td> ' +
                            '<td class="middle">'+orderlist[i].user_name+'</td> ' +
                            '<td class="middle">'+orderlist[i].price+'</td> ' +
                            '<td class="short">'+orderlist[i].isUrgency+'</td> ' +
                            '<td class="long">'+orderlist[i].remark+'</td>'+
                            '<td class="short">' +orderlist[i].order_status+ '</td>' +
                            '<td class="middle">'+orderlist[i].shipped_time+'</td> ' +
                            '<td class="long">' +
                             	'<button class="btn btn-default" onclick="godetail('+i+')">详细信息</button>' +
                             	'<button class="btn btn-default" onclick="goupdate('+i+')">修改订单</button>';
                        
                        if(orderlist[i].order_status == "已付款"){
                        	html += '<button class="btn btn-default" onclick="check('+i+')">确认</button>';
                        } else if (orderlist[i].order_status == "已审核"){
                        	html += '<button class="btn btn-default" onclick="goship('+i+')">发货</button>';
                        }
                        
                        html += '</td>';
                        tr.innerHTML=html;
                        table.appendChild(tr);
                    }

                }
            }
        )
}