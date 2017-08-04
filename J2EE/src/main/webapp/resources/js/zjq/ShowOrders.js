/**
 * Created by Administrator on 2017/5/22.
 */
var page=1;
var orderlist={};
var pagenum;
window.onload=function () {
    if(sessionStorage.getItem("search")!="yes") {
        var table = document.getElementById("list");
        $.ajax(
            {
                type: 'POST',
                url: "ShowList",
                contentType: 'application/json;charset=utf-8',
                success: function (data) {
                    orderlist = data;
                    if (orderlist.length % 7 != 0)
                        pagenum = parseInt(orderlist.length / 7) + 1;
                    else pagenum = orderlist.length / 7;
                    document.getElementById("pageshow").innerHTML = '第<input id="input-page" type="number" class="page-input" min="1" value="' + page + '">页(共' + pagenum + '页)' +
                        '<a href="javascript:gopage()" class="page-go">Go</a>';
                    var number;
                    if (orderlist.length > 7) number = 7;
                    else number = orderlist.length;
                    for (var i = 0; i < number; i++) {
                    	if(orderlist[i].remark==null) orderlist[i].remark='';
                  
                        var tr = document.createElement("tr");
                        var html = '<td class="short"><input type="checkbox"></td> ' +
                            '<td class="middle">' + orderlist[i].order_sn + '</td>' +
                            '<td class="middle">' + orderlist[i].name + '</td> ' +
                            '<td class="long">' + orderlist[i].add_time + '</td> ' +
                            '<td class="middle">' + orderlist[i].consignee + '</td> ' +
                            '<td class="middle">' + orderlist[i].user_name + '</td> ' +
                            '<td class="middle">' + orderlist[i].order_price + '</td> ' +
                            '<td class="short">' + orderlist[i].isUrgency + '</td> ' +
                            '<td class="long">' + orderlist[i].remark + '</td>' +
                            '<td id="status'+i+'"  class="middle">' + orderlist[i].order_status + '</td> ' +
                            '<td class="long">' + orderlist[i].shipped_time + '</td> ' +
                            '<td class="middle"><button class="btn btn-default" onclick="godetail(' + i + ')">详细信息</button></td>' +
                            '<td class="middle"><button class="btn btn-default" onclick="goupdate(' + i + ')">修改信息</button></td>';

                        tr.innerHTML = html;
                        table.appendChild(tr);
                        var td=document.createElement("td");
                        td.setAttribute("class","middle");
                        var inner='<button id="change'+i+'" class="btn btn-default" onclick="gochange('+i+')">确认</button>';
                        td.innerHTML=inner;
                        tr.appendChild(td);
                        if(orderlist[i].order_status!='已收款') document.getElementById("change"+i).style.display="none";
                        var td=document.createElement("td");
                        td.setAttribute("class","middle");
                        var inner='<button id="send'+i+'" class="btn btn-default" onclick="gosend('+i+')">发货</button>';
                        td.innerHTML=inner;
                        tr.appendChild(td);
                        if(orderlist[i].order_status!='定制中') document.getElementById("send"+i).style.display="none";
                    }

                }
            }
        )
    }
    else
    {
        sessionStorage.setItem("search","no");
        var table = document.getElementById("list");

        $.ajax(
            {
                type: 'POST',
                url: "SearchList",
                data:sessionStorage.getItem("searchobject"),
                contentType: 'application/json;charset=utf-8',
                success: function (data) {
                    orderlist = data;
                    if (orderlist.length % 7 != 0)
                        pagenum = parseInt(orderlist.length / 7) + 1;
                    else pagenum = orderlist.length / 7;
                    document.getElementById("pageshow").innerHTML = '第<input id="input-page" type="number" class="page-input" min="1" value="' + page + '">页(共' + pagenum + '页)' +
                        '<a href="javascript:gopage()" class="page-go">Go</a>';
                    var number;
                    if (orderlist.length > 7) number = 7;
                    else number = orderlist.length;
                    for (var i = 0; i < number; i++) {
                        var tr = document.createElement("tr");
                        if(orderlist[i].remark==null) orderlist[i].remark='';
                        var html = '<td class="short"><input type="checkbox"></td> ' +
                            '<td class="middle">' + orderlist[i].order_sn + '</td>' +
                            '<td class="middle">' + orderlist[i].name + '</td> ' +
                            '<td class="long">' + orderlist[i].add_time + '</td> ' +
                            '<td class="middle">' + orderlist[i].consignee + '</td> ' +
                            '<td class="middle">' + orderlist[i].user_name + '</td> ' +
                            '<td class="middle">' + orderlist[i].order_price + '</td> ' +
                            '<td class="short">' + orderlist[i].isUrgency + '</td> ' +
                            '<td class="long">' + orderlist[i].remark + '</td>' +
                            '<td id="status'+i+'"  class="middle">' + orderlist[i].order_status + '</td> ' +
                            '<td class="long">' + orderlist[i].shipped_time + '</td> ' +
                            '<td class="middle"><button class="btn btn-default" onclick="godetail(' + i + ')">详细信息</button></td>' +
                            '<td class="middle"><button class="btn btn-default" onclick="goupdate(' + i + ')">修改信息</button></td>' ;
                        tr.innerHTML = html;
                        table.appendChild(tr);
                        var td=document.createElement("td");
                        td.setAttribute("class","middle");
                        var inner='<button id="change'+i+'" class="btn btn-default" onclick="gochange('+i+')">确认</button>';
                        td.innerHTML=inner;
                        tr.appendChild(td);
                        if(orderlist[i].order_status!='已收款') document.getElementById("change"+i).style.display="none";
                        var td=document.createElement("td");
                        td.setAttribute("class","middle");
                        var inner='<button id="send'+i+'" class="btn btn-default" onclick="gosend('+i+')">发货</button>';
                        td.innerHTML=inner;
                        tr.appendChild(td);
                        if(orderlist[i].order_status!='定制中') document.getElementById("send"+i).style.display="none";
                    }
                }
            }
        )
    }
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
            '<td class="middle">订单状态</td>'+
            '<td class="long">发货时间</td>'+
            '<td class="middle"></td>'+
            '<td class="middle"></td>'+
            '<td class="middle"></td>'+
            '<td class="middle"></td>';
            table.appendChild(th);
        for(var i=7*(page-1);i<7*page;i++) {
            if (orderlist[i] != null) {
                var tr = document.createElement("tr");
                if(orderlist[i].remark==null) orderlist[i].remark='';
                var html = '<td class="short"><input type="checkbox"></td> ' +
                    '<td class="middle">' + orderlist[i].order_sn + '</td>' +
                    '<td class="middle">' + orderlist[i].name + '</td> ' +
                    '<td class="long">' + orderlist[i].add_time + '</td> ' +
                    '<td class="middle">' + orderlist[i].consignee + '</td> ' +
                    '<td class="middle">' + orderlist[i].user_name + '</td> ' +
                    '<td class="middle">' + orderlist[i].order_price + '</td> ' +
                    '<td class="short">' + orderlist[i].isUrgency + '</td> ' +
                    '<td class="long">' + orderlist[i].remark + '</td>' +
                    '<td id="status'+i+'"  class="middle">'+orderlist[i].order_status+'</td> ' +
                    '<td class="long">'+orderlist[i].shipped_time+'</td> ' +
                    '<td class="middle"><button class="btn btn-default" onclick="godetail('+i+')">详细信息</button></td>'+
                    '<td class="middle"><button class="btn btn-default" onclick="goupdate('+i+')">修改信息</button></td>';
                tr.innerHTML = html;
                table.appendChild(tr);
                var td=document.createElement("td");
                td.setAttribute("class","middle");
                var inner='<button id="change'+i+'" class="btn btn-default" onclick="gochange('+i+')">确认</button>';
                td.innerHTML=inner;
                tr.appendChild(td);
                if(orderlist[i].order_status!='已收款') document.getElementById("change"+i).style.display="none";
                var td=document.createElement("td");
                td.setAttribute("class","middle");
                var inner='<button id="send'+i+'" class="btn btn-default" onclick="gosend('+i+')">发货</button>';
                td.innerHTML=inner;
                tr.appendChild(td);
                if(orderlist[i].order_status!='定制中') document.getElementById("send"+i).style.display="none";
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
            '<td class="middle">订单状态</td>'+
            '<td class="long">发货时间</td>'+
            '<td class="middle"></td>'+
            '<td class="middle"></td>'+
            '<td class="middle"></td>'+
            '<td class="middle"></td>';
            table.appendChild(th);
        for(var i=7*(page-1);i<7*page;i++)
        {
            if(orderlist[i]!=null) {
                var tr = document.createElement("tr");
                if(orderlist[i].remark==null) orderlist[i].remark='';
                var html = '<td class="short"><input type="checkbox"></td> ' +
                    '<td class="middle">' + orderlist[i].order_sn + '</td>' +
                    '<td class="middle">' + orderlist[i].name + '</td> ' +
                    '<td class="long">' + orderlist[i].add_time + '</td> ' +
                    '<td class="middle">' + orderlist[i].consignee + '</td> ' +
                    '<td class="middle">' + orderlist[i].user_name + '</td> ' +
                    '<td class="middle">' + orderlist[i].order_price + '</td> ' +
                    '<td class="short">' + orderlist[i].isUrgency + '</td> ' +
                    '<td class="long">' + orderlist[i].remark + '</td>' +
                    '<td id="status'+i+'"  class="middle">'+orderlist[i].order_status+'</td> ' +
                    '<td class="long">'+orderlist[i].shipped_time+'</td> ' +
                    '<td class="middle"><button class="btn btn-default" onclick="godetail('+i+')">详细信息</button></td>'+
                    '<td class="middle"><button class="btn btn-default" onclick="goupdate('+i+')">修改信息</button></td>';
                tr.innerHTML = html;
                table.appendChild(tr);
                var td=document.createElement("td");
                td.setAttribute("class","middle");
                var inner='<button id="change'+i+'" class="btn btn-default" onclick="gochange('+i+')">确认</button>';
                td.innerHTML=inner;
                tr.appendChild(td);
                if(orderlist[i].order_status!='已收款') document.getElementById("change"+i).style.display="none";
                var td=document.createElement("td");
                td.setAttribute("class","middle");
                var inner='<button id="send'+i+'" class="btn btn-default" onclick="gosend('+i+')">发货</button>';
                td.innerHTML=inner;
                tr.appendChild(td);
                if(orderlist[i].order_status!='定制中') document.getElementById("send"+i).style.display="none";
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
            '<td class="middle">订单状态</td>'+
            '<td class="long">发货时间</td>'+
            '<td class="middle"></td>'+
            '<td class="middle"></td>'+
            '<td class="middle"></td>'+
            '<td class="middle"></td>';
            table.appendChild(th);
        for(var i=7*(page-1);i<7*page;i++)
        {
            if(orderlist[i]!=null) {
                var tr = document.createElement("tr");
                if(orderlist[i].remark==null) orderlist[i].remark='';
                var html = '<td class="short"><input type="checkbox"></td> ' +
                    '<td class="middle">' + orderlist[i].order_sn + '</td>' +
                    '<td class="middle">' + orderlist[i].name + '</td> ' +
                    '<td class="long">' + orderlist[i].add_time + '</td> ' +
                    '<td class="middle">' + orderlist[i].consignee + '</td> ' +
                    '<td class="middle">' + orderlist[i].user_name + '</td> ' +
                    '<td class="middle">' + orderlist[i].order_price + '</td> ' +
                    '<td class="short">' + orderlist[i].isUrgency + '</td> ' +
                    '<td class="long">' + orderlist[i].remark + '</td>' +
                    '<td id="status'+i+'" class="middle">'+orderlist[i].order_status+'</td> ' +
                    '<td class="long">'+orderlist[i].shipped_time+'</td> ' +
                    '<td class="middle"><button class="btn btn-default" onclick="godetail('+i+')">详细信息</button></td>'+
                    '<td class="middle"><button class="btn btn-default" onclick="goupdate('+i+')">修改信息</button></td>';
                    tr.innerHTML = html;
                    table.appendChild(tr);
                    var td=document.createElement("td");
                    td.setAttribute("class","middle");
                    var inner='<button id="change'+i+'" class="btn btn-default" onclick="gochange('+i+')">确认</button>';
                    td.innerHTML=inner;
                    tr.appendChild(td);
                     if(orderlist[i].order_status!='已收款') document.getElementById("change"+i).style.display="none";
                    var td=document.createElement("td");
                    td.setAttribute("class","middle");
                    var inner='<button id="send'+i+'" class="btn btn-default" onclick="gosend('+i+')">发货</button>';
                    td.innerHTML=inner;
                    tr.appendChild(td);
                    if(orderlist[i].order_status!='定制中') document.getElementById("send"+i).style.display="none";
            }
        }
        document.getElementById("input-page").value=page;
    }
}
function godetail(i) {
    window.location.href="Detail?order_id="+orderlist[i].order_id;
}
function goupdate(i) {
    window.location.href="UpdateShow?order_id="+orderlist[i].order_id;
}
function gosearch() {
    window.location.href="GoSearch";
}
/*
    直接在order页面修改的逻辑
 */
function gosend(i) {
    window.location.href="SendOrder?order_id="+orderlist[i].order_id;
}
function gochange(i) {
    if(confirm("确认定制？")) {
        orderlist[i].order_status = "定制中"
        $.ajax({
            type: "GET",
            url: "change?orderid=" + orderlist[i].order_id + "&&status=2",
            success: function () {
                document.getElementById("status" + i).innerHTML = "定制中";
                document.getElementById("change" + i).style.display = "none";
                document.getElementById("send"+i).style.display="block";
            }
        })
    }
}
